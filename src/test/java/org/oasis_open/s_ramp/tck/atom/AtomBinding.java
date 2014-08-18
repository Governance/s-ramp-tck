/*
 * Copyright 2014 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.oasis_open.s_ramp.tck.atom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Response;
import javax.xml.namespace.QName;

import org.apache.commons.codec.binary.Base64;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.plugins.providers.atom.Entry;
import org.jboss.resteasy.plugins.providers.atom.Feed;
import org.jboss.resteasy.plugins.providers.atom.Link;
import org.jboss.resteasy.plugins.providers.multipart.MultipartConstants;
import org.jboss.resteasy.plugins.providers.multipart.MultipartRelatedOutput;
import org.oasis_open.docs.s_ramp.ns.s_ramp_v1.BaseArtifactType;
import org.oasis_open.s_ramp.tck.ArtifactType;
import org.oasis_open.s_ramp.tck.Binding;
import org.oasis_open.s_ramp.tck.MediaType;

/**
 * @author Brett Meyer
 */
public class AtomBinding extends Binding {
    
//    private static final String BASE_URL = System.getProperty("password");
    private static final String BASE_URL = "http://localhost:8080/s-ramp-server";

    private static final QName DERIVED_QNAME = new QName(
            "http://docs.oasis-open.org/s-ramp/ns/s-ramp-v1.0", "derived", "s-ramp");
    
    private static final String NAMESPACE = "http://docs.oasis-open.org/s-ramp/ns/s-ramp-v1.0";

    @Override
    public List<BaseArtifactType> query(String query) throws Exception {
        List<BaseArtifactType> artifacts = new ArrayList<BaseArtifactType>();
        Feed feed = getFeed(query);
        for (Entry entry : feed.getEntries()) {
//            artifacts.add(SrampAtomUtils.unwrapSrampArtifact(entry));
            // TODO: The feed doesn't include sramp:artifact on the entities, so unwrapping doesn't work.  Should
            // the below be necessary?
            
            for (Link link : entry.getLinks()) {
                // TODO: Safe assumption for all impls?
                if ("self".equals(link.getRel())) {
                    artifacts.add(SrampAtomUtils.unwrapSrampArtifact(getArtifact(link.getHref().toString())));
                }
            }
        }
        return artifacts;
    }

    @Override
    public BaseArtifactType upload(ArtifactType artifactType, String filePath) throws Exception {
        String atomUrl = getUrl(artifactType);
        Builder clientRequest = getClientRequest(atomUrl);
        
        InputStream is = this.getClass().getResourceAsStream(filePath);
        String text = convertStreamToString(is);
        is.close();

        String fileName = filePath.substring( filePath.lastIndexOf('/') + 1, filePath.length() );
        clientRequest.header("Slug", fileName); //$NON-NLS-1$

        Response response = clientRequest.post(Entity.entity(text, artifactType.getMimeType()));
        checkResponse(response);
        Entry entry = response.readEntity(Entry.class);
        verifyEntry(entry);
        return SrampAtomUtils.unwrapSrampArtifact(artifactType, entry);
    }
    
    @Override
    public BaseArtifactType upload(BaseArtifactType artifact, String filePath) throws Exception {
        ArtifactType artifactType = ArtifactType.valueOf(artifact);
        String atomUrl = getUrl(artifactType);
        Builder clientRequest = getClientRequest(atomUrl);

        MultipartRelatedOutput output = new MultipartRelatedOutput();

        //1. Add first part, the S-RAMP entry
        Entry atomEntry = SrampAtomUtils.wrapSrampArtifact(artifact);

        MediaType mediaType = new MediaType("application", "atom+xml"); //$NON-NLS-1$ //$NON-NLS-2$
        output.addPart(atomEntry, mediaType);

        //2. Add second part, the content
        InputStream is = this.getClass().getResourceAsStream(filePath);
        String text = convertStreamToString(is);
        is.close();
        output.addPart(text, MediaType.valueOf(artifactType.getMimeType()));

        //3. Send the request
        Response response = clientRequest.post(Entity.entity(output, MultipartConstants.MULTIPART_RELATED));
        checkResponse(response);
        Entry entry = response.readEntity(Entry.class);
        verifyEntry(entry);
        return SrampAtomUtils.unwrapSrampArtifact(artifactType, entry);
    }
    
    @Override
    public BaseArtifactType createArtifact(BaseArtifactType artifact) throws Exception {
        ArtifactType artifactType = ArtifactType.valueOf(artifact);
        String atomUrl = getUrl(artifactType);
        
        Builder clientRequest = getClientRequest(atomUrl);
        Response response = clientRequest.post(Entity.entity(SrampAtomUtils.wrapSrampArtifact(artifact),
                MediaType.APPLICATION_ATOM_XML_ENTRY));
        checkResponse(response);
        Entry entry = response.readEntity(Entry.class);
        verifyEntry(entry);
        return SrampAtomUtils.unwrapSrampArtifact(artifactType, entry);
    }
    
    @Override
    public void deleteAll() throws Exception {
        Feed feed = getFeed("/s-ramp?query=/s-ramp&startIndex=0&count=10000");
        for (Entry entry : feed.getEntries()) {
            // Delete all primary artifacts
            if (entry.getExtensionAttributes().containsKey(DERIVED_QNAME)
                    && "false".equals(entry.getExtensionAttributes().get(DERIVED_QNAME))) {
                for (Link link : entry.getLinks()) {
                    // TODO: Safe assumption for all impls?
                    if ("self".equals(link.getRel())) {
                        getClientRequest(link.getHref().toString()).delete();
                    }
                }
            }
        }
    }
    
    @Override
    public String getUrl(BaseArtifactType artifact) {
        ArtifactType artifactType = ArtifactType.valueOf(artifact);
        return getUrl(artifactType);
    }
    
    @Override
    public String getUrl(ArtifactType artifactType) {
        String type = artifactType.getType();
        return String.format("%1$s/%2$s/%3$s", BASE_URL + "/s-ramp", //$NON-NLS-1$
                artifactType.getArtifactType().getModel(), type);
    }
    
    private Feed getFeed(String endpoint) {
        Builder clientRequest = getClientRequest(BASE_URL + endpoint);
        Feed feed = clientRequest.get(Feed.class);
        verifyFeed(feed);
        return feed;
    }
    
    private Entry getArtifact(String url) {
        Builder clientRequest = getClientRequest(url);
        Entry entry = clientRequest.get(Entry.class);
        verifyEntry(entry);
        return entry;
    }
    
    private Builder getClientRequest(String endpoint) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        client.register(new BasicAuthFilter());
        return client.target(endpoint).request();
    }
    
    private String convertStreamToString(java.io.InputStream is) {
        try {
            return new Scanner(is).useDelimiter("\\A").next(); //$NON-NLS-1$
        } catch (java.util.NoSuchElementException e) {
            return ""; //$NON-NLS-1$
        }
    }
    
    private void checkResponse(Response response) {
        if (response.getStatus() != 200) {
            fail("Server responded with status " + response.getStatus() + ".  Check the logs for issues.");
        }
    }
    
    private void verifyFeed(Feed feed) {
        for (Object key : feed.getExtensionAttributes().keySet()) {
            QName qname = (QName) key;
            // Foundation 1.9
            assertEquals(NAMESPACE, qname.getNamespaceURI());
        }
        for (Entry entry : feed.getEntries()) {
            verifyEntry(entry);
      }
    }
    
    private void verifyEntry(Entry entry) {
        for (Object key : entry.getExtensionAttributes().keySet()) {
            QName qname = (QName) key;
            // Foundation 1.9
            assertEquals(NAMESPACE, qname.getNamespaceURI());
        }
    }
    
    public static class BasicAuthFilter implements ClientRequestFilter {

//        private static final String USERNAME = System.getProperty("username");
//        private static final String PASSWORD = System.getProperty("password");
        private static final String USERNAME = "admin";
        private static final String PASSWORD = "overlord1!";

        @Override
        public void filter(ClientRequestContext requestContext) throws IOException {
            String token = USERNAME + ":" + PASSWORD;
            String base64Token = Base64.encodeBase64String(token.getBytes(StandardCharsets.UTF_8));
            requestContext.getHeaders().add("Authorization", "Basic " + base64Token);
        }
    }

}
