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
package org.oasis_open.s_ramp.tck.foundation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.oasis_open.docs.s_ramp.ns.s_ramp_v1.*;
import org.oasis_open.s_ramp.tck.Binding;

/**
 * @author Brett Meyer
 */
public class Test_2_1 extends AbstractFoundationTest {

    public Test_2_1(Binding binding) {
        super(binding);
    }
    
    @Test
    public void test_2_1_2() throws Exception {
        XsdDocument xsd1 = XsdDocument();
        BaseArtifactType xsdArtifact1 = binding.upload(xsd1, "/PO.xsd");
        verifyArtifact(xsdArtifact1);
        
        XsdDocument xsd2 = XsdDocument();
        
        XsdDocumentTarget xsdTarget = new XsdDocumentTarget();
        xsdTarget.setValue(xsdArtifact1.getUuid());
        xsdTarget.setArtifactType(XsdDocumentEnum.XSD_DOCUMENT);

        // create a valid generic relationship w/ a target
        Relationship validRelationship = new Relationship();
        validRelationship.setRelationshipType("similarXsds");
        validRelationship.getRelationshipTarget().add(xsdTarget);
        xsd2.getRelationship().add(validRelationship);

        // create a valid generic relationship w/ no target
        // TODO FAILURE: SRAMP-552
//        Relationship validRelationshipNoTarget = new Relationship();
//        validRelationship.setRelationshipType("foo");
//        xsd2.getRelationship().add(validRelationshipNoTarget);
        
        // TODO: After SRAMP-552, test that only 1 instance of a relationship type, with *no* target, can be added to a source
        // TODO: After SRAMP-552, test that instances of a relationship type cannot have both target(s) and no target
        
        XsdDocument xsd2Artifact = (XsdDocument) binding.upload(xsd2, "/PO.xsd");
        verifyArtifact(xsd2Artifact);
        
        // TODO FAILURE: SRAMP-552
//        assertEquals(2, xsd2Artifact.getRelationship().size());
        
        // generic relationships cannot have the same type as a derived/modeled relationship
        xsd2.getRelationship().clear();
        Relationship invalidRelationship = new Relationship();
        invalidRelationship.setRelationshipType("importedXsds");
        invalidRelationship.getRelationshipTarget().add(xsdTarget);
        xsd2.getRelationship().add(invalidRelationship);

        binding.upload(xsd2, "/PO.xsd", 409);

        // reset
        xsd2.getRelationship().remove(invalidRelationship);
        
        // test that a derived relationship cannot be created/edited
        xsd2.getImportedXsds().add(xsdTarget);
        binding.upload(xsd2, "/PO.xsd", 409);

        // test modeled relationship support
        // TODO: cardinality assertions?
        Task task = new Task();
        task = (Task) binding.create(task);
        verifyArtifact(task);
        TaskTarget taskTarget = new TaskTarget();
        taskTarget.setArtifactType(TaskEnum.TASK);
        taskTarget.setValue(task.getUuid());
        Actor actor = new Actor();
        actor.getDoes().add(taskTarget);
        actor = (Actor) binding.create(actor);
        verifyArtifact(actor);
        assertEquals(1, actor.getDoes().size());
        assertEquals(task.getUuid(), actor.getDoes().get(0).getValue());
    }

}
