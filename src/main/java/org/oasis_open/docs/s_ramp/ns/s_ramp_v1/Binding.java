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
// Generated on: 2014.12.18 at 01:31:33 PM EST 
//


package org.oasis_open.docs.s_ramp.ns.s_ramp_v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for Binding complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Binding">
 *   &lt;complexContent>
 *     &lt;extension base="{http://docs.oasis-open.org/s-ramp/ns/s-ramp-v1.0}NamedWsdlDerivedArtifactType">
 *       &lt;sequence>
 *         &lt;element name="bindingOperation" type="{http://docs.oasis-open.org/s-ramp/ns/s-ramp-v1.0}bindingOperationTarget" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="portType" type="{http://docs.oasis-open.org/s-ramp/ns/s-ramp-v1.0}portTypeTarget"/>
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
@XmlType(name = "Binding", propOrder = {
    "bindingOperation",
    "portType"
})
public class Binding
    extends NamedWsdlDerivedArtifactType
    implements Serializable
{

    private static final long serialVersionUID = -5662242680710736353L;
    protected List<BindingOperationTarget> bindingOperation;
    @XmlElement(required = true)
    protected PortTypeTarget portType;

    /**
     * Gets the value of the bindingOperation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bindingOperation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBindingOperation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BindingOperationTarget }
     *
     *
     */
    public List<BindingOperationTarget> getBindingOperation() {
        if (bindingOperation == null) {
            bindingOperation = new ArrayList<BindingOperationTarget>();
        }
        return this.bindingOperation;
    }

    /**
     * Gets the value of the portType property.
     *
     * @return
     *     possible object is
     *     {@link PortTypeTarget }
     *
     */
    public PortTypeTarget getPortType() {
        return portType;
    }

    /**
     * Sets the value of the portType property.
     *
     * @param value
     *     allowed object is
     *     {@link PortTypeTarget }
     *     
     */
    public void setPortType(PortTypeTarget value) {
        this.portType = value;
    }

}
