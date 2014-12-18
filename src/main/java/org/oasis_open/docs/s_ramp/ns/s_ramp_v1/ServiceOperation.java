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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.18 at 01:49:11 PM EST 
//


package org.oasis_open.docs.s_ramp.ns.s_ramp_v1;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ServiceOperation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceOperation">
 *   &lt;complexContent>
 *     &lt;extension base="{http://docs.oasis-open.org/s-ramp/ns/s-ramp-v1.0}ServiceImplementationModelType">
 *       &lt;sequence>
 *         &lt;element name="operationDefinedBy" type="{http://docs.oasis-open.org/s-ramp/ns/s-ramp-v1.0}derivedArtifactTarget" minOccurs="0"/>
 *         &lt;element name="extension" type="{http://docs.oasis-open.org/s-ramp/ns/s-ramp-v1.0}ExtensionType" minOccurs="0"/>
 *         &lt;element name="end" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceOperation", propOrder = {
    "operationDefinedBy",
    "extension",
    "end",
    "any"
})
public class ServiceOperation
    extends ServiceImplementationModelType
    implements Serializable
{

    private static final long serialVersionUID = 5633817872752518952L;
    protected DerivedArtifactTarget operationDefinedBy;
    protected ExtensionType extension;
    @XmlElement(required = true)
    protected String end;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the operationDefinedBy property.
     * 
     * @return
     *     possible object is
     *     {@link DerivedArtifactTarget }
     *
     */
    public DerivedArtifactTarget getOperationDefinedBy() {
        return operationDefinedBy;
    }

    /**
     * Sets the value of the operationDefinedBy property.
     *
     * @param value
     *     allowed object is
     *     {@link DerivedArtifactTarget }
     *
     */
    public void setOperationDefinedBy(DerivedArtifactTarget value) {
        this.operationDefinedBy = value;
    }

    /**
     * Gets the value of the extension property.
     *
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *
     */
    public ExtensionType getExtension() {
        return extension;
    }

    /**
     * Sets the value of the extension property.
     *
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *
     */
    public void setExtension(ExtensionType value) {
        this.extension = value;
    }

    /**
     * Gets the value of the end property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEnd(String value) {
        this.end = value;
    }

    /**
     * Gets the value of the any property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * {@link org.w3c.dom.Element }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

}
