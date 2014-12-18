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
// Generated on: 2014.12.18 at 12:46:07 PM EST 
//


package org.oasis_open.docs.s_ramp.ns.s_ramp_v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for baseArtifactEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="baseArtifactEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BaseArtifactType"/>
 *     &lt;enumeration value="DocumentArtifactType"/>
 *     &lt;enumeration value="Document"/>
 *     &lt;enumeration value="XmlDocument"/>
 *     &lt;enumeration value="XsdDocument"/>
 *     &lt;enumeration value="WsdlDocument"/>
 *     &lt;enumeration value="PolicyDocument"/>
 *     &lt;enumeration value="DerivedArtifactType"/>
 *     &lt;enumeration value="PolicyAttachment"/>
 *     &lt;enumeration value="PolicyExpression"/>
 *     &lt;enumeration value="AttributeDeclaration"/>
 *     &lt;enumeration value="ElementDeclaration"/>
 *     &lt;enumeration value="XsdType"/>
 *     &lt;enumeration value="ComplexTypeDeclaration"/>
 *     &lt;enumeration value="SimpleTypeDeclaration"/>
 *     &lt;enumeration value="WsdlDerivedArtifactType"/>
 *     &lt;enumeration value="NamedWsdlDerivedArtifactType"/>
 *     &lt;enumeration value="WsdlService"/>
 *     &lt;enumeration value="Port"/>
 *     &lt;enumeration value="Binding"/>
 *     &lt;enumeration value="PortType"/>
 *     &lt;enumeration value="BindingOperation"/>
 *     &lt;enumeration value="BindingOperationInput"/>
 *     &lt;enumeration value="BindingOperationFault"/>
 *     &lt;enumeration value="Operation"/>
 *     &lt;enumeration value="OperationInput"/>
 *     &lt;enumeration value="Fault"/>
 *     &lt;enumeration value="Message"/>
 *     &lt;enumeration value="Part"/>
 *     &lt;enumeration value="BindingOperationOutput"/>
 *     &lt;enumeration value="OperationOutput"/>
 *     &lt;enumeration value="WsdlExtension"/>
 *     &lt;enumeration value="SoapAddress"/>
 *     &lt;enumeration value="SoapBinding"/>
 *     &lt;enumeration value="ExtendedArtifactType"/>
 *     &lt;enumeration value="ExtendedDocument"/>
 *     &lt;enumeration value="SoaModelType"/>
 *     &lt;enumeration value="ServiceInterface"/>
 *     &lt;enumeration value="Effect"/>
 *     &lt;enumeration value="Event"/>
 *     &lt;enumeration value="InformationType"/>
 *     &lt;enumeration value="Policy"/>
 *     &lt;enumeration value="PolicySubject"/>
 *     &lt;enumeration value="ServiceContract"/>
 *     &lt;enumeration value="Element"/>
 *     &lt;enumeration value="Service"/>
 *     &lt;enumeration value="Actor"/>
 *     &lt;enumeration value="Organization"/>
 *     &lt;enumeration value="System"/>
 *     &lt;enumeration value="Task"/>
 *     &lt;enumeration value="Composition"/>
 *     &lt;enumeration value="ServiceComposition"/>
 *     &lt;enumeration value="Choreography"/>
 *     &lt;enumeration value="Collaboration"/>
 *     &lt;enumeration value="Orchestration"/>
 *     &lt;enumeration value="Process"/>
 *     &lt;enumeration value="ChoreographyProcess"/>
 *     &lt;enumeration value="CollaborationProcess"/>
 *     &lt;enumeration value="OrchestrationProcess"/>
 *     &lt;enumeration value="ServiceImplementationModelType"/>
 *     &lt;enumeration value="ServiceInstance"/>
 *     &lt;enumeration value="ServiceOperation"/>
 *     &lt;enumeration value="ServiceEndpoint"/>
 *     &lt;enumeration value="ServiceOperation"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "baseArtifactEnum")
@XmlEnum
public enum BaseArtifactEnum {

    @XmlEnumValue("BaseArtifactType")
    BASE_ARTIFACT_TYPE("BaseArtifactType"),
    @XmlEnumValue("DocumentArtifactType")
    DOCUMENT_ARTIFACT_TYPE("DocumentArtifactType"),
    @XmlEnumValue("Document")
    DOCUMENT("Document"),
    @XmlEnumValue("XmlDocument")
    XML_DOCUMENT("XmlDocument"),
    @XmlEnumValue("XsdDocument")
    XSD_DOCUMENT("XsdDocument"),
    @XmlEnumValue("WsdlDocument")
    WSDL_DOCUMENT("WsdlDocument"),
    @XmlEnumValue("PolicyDocument")
    POLICY_DOCUMENT("PolicyDocument"),
    @XmlEnumValue("DerivedArtifactType")
    DERIVED_ARTIFACT_TYPE("DerivedArtifactType"),
    @XmlEnumValue("PolicyAttachment")
    POLICY_ATTACHMENT("PolicyAttachment"),
    @XmlEnumValue("PolicyExpression")
    POLICY_EXPRESSION("PolicyExpression"),
    @XmlEnumValue("AttributeDeclaration")
    ATTRIBUTE_DECLARATION("AttributeDeclaration"),
    @XmlEnumValue("ElementDeclaration")
    ELEMENT_DECLARATION("ElementDeclaration"),
    @XmlEnumValue("XsdType")
    XSD_TYPE("XsdType"),
    @XmlEnumValue("ComplexTypeDeclaration")
    COMPLEX_TYPE_DECLARATION("ComplexTypeDeclaration"),
    @XmlEnumValue("SimpleTypeDeclaration")
    SIMPLE_TYPE_DECLARATION("SimpleTypeDeclaration"),
    @XmlEnumValue("WsdlDerivedArtifactType")
    WSDL_DERIVED_ARTIFACT_TYPE("WsdlDerivedArtifactType"),
    @XmlEnumValue("NamedWsdlDerivedArtifactType")
    NAMED_WSDL_DERIVED_ARTIFACT_TYPE("NamedWsdlDerivedArtifactType"),
    @XmlEnumValue("WsdlService")
    WSDL_SERVICE("WsdlService"),
    @XmlEnumValue("Port")
    PORT("Port"),
    @XmlEnumValue("Binding")
    BINDING("Binding"),
    @XmlEnumValue("PortType")
    PORT_TYPE("PortType"),
    @XmlEnumValue("BindingOperation")
    BINDING_OPERATION("BindingOperation"),
    @XmlEnumValue("BindingOperationInput")
    BINDING_OPERATION_INPUT("BindingOperationInput"),
    @XmlEnumValue("BindingOperationFault")
    BINDING_OPERATION_FAULT("BindingOperationFault"),
    @XmlEnumValue("Operation")
    OPERATION("Operation"),
    @XmlEnumValue("OperationInput")
    OPERATION_INPUT("OperationInput"),
    @XmlEnumValue("Fault")
    FAULT("Fault"),
    @XmlEnumValue("Message")
    MESSAGE("Message"),
    @XmlEnumValue("Part")
    PART("Part"),
    @XmlEnumValue("BindingOperationOutput")
    BINDING_OPERATION_OUTPUT("BindingOperationOutput"),
    @XmlEnumValue("OperationOutput")
    OPERATION_OUTPUT("OperationOutput"),
    @XmlEnumValue("WsdlExtension")
    WSDL_EXTENSION("WsdlExtension"),
    @XmlEnumValue("SoapAddress")
    SOAP_ADDRESS("SoapAddress"),
    @XmlEnumValue("SoapBinding")
    SOAP_BINDING("SoapBinding"),
    @XmlEnumValue("ExtendedArtifactType")
    EXTENDED_ARTIFACT_TYPE("ExtendedArtifactType"),
    @XmlEnumValue("ExtendedDocument")
    EXTENDED_DOCUMENT("ExtendedDocument"),
    @XmlEnumValue("SoaModelType")
    SOA_MODEL_TYPE("SoaModelType"),
    @XmlEnumValue("ServiceInterface")
    SERVICE_INTERFACE("ServiceInterface"),
    @XmlEnumValue("Effect")
    EFFECT("Effect"),
    @XmlEnumValue("Event")
    EVENT("Event"),
    @XmlEnumValue("InformationType")
    INFORMATION_TYPE("InformationType"),
    @XmlEnumValue("Policy")
    POLICY("Policy"),
    @XmlEnumValue("PolicySubject")
    POLICY_SUBJECT("PolicySubject"),
    @XmlEnumValue("ServiceContract")
    SERVICE_CONTRACT("ServiceContract"),
    @XmlEnumValue("Element")
    ELEMENT("Element"),
    @XmlEnumValue("Service")
    SERVICE("Service"),
    @XmlEnumValue("Actor")
    ACTOR("Actor"),
    @XmlEnumValue("Organization")
    ORGANIZATION("Organization"),
    @XmlEnumValue("System")
    SYSTEM("System"),
    @XmlEnumValue("Task")
    TASK("Task"),
    @XmlEnumValue("Composition")
    COMPOSITION("Composition"),
    @XmlEnumValue("ServiceComposition")
    SERVICE_COMPOSITION("ServiceComposition"),
    @XmlEnumValue("Choreography")
    CHOREOGRAPHY("Choreography"),
    @XmlEnumValue("Collaboration")
    COLLABORATION("Collaboration"),
    @XmlEnumValue("Orchestration")
    ORCHESTRATION("Orchestration"),
    @XmlEnumValue("Process")
    PROCESS("Process"),
    @XmlEnumValue("ChoreographyProcess")
    CHOREOGRAPHY_PROCESS("ChoreographyProcess"),
    @XmlEnumValue("CollaborationProcess")
    COLLABORATION_PROCESS("CollaborationProcess"),
    @XmlEnumValue("OrchestrationProcess")
    ORCHESTRATION_PROCESS("OrchestrationProcess"),
    @XmlEnumValue("ServiceImplementationModelType")
    SERVICE_IMPLEMENTATION_MODEL_TYPE("ServiceImplementationModelType"),
    @XmlEnumValue("ServiceInstance")
    SERVICE_INSTANCE("ServiceInstance"),
    @XmlEnumValue("ServiceOperation")
    SERVICE_OPERATION("ServiceOperation"),
    @XmlEnumValue("ServiceEndpoint")
    SERVICE_ENDPOINT("ServiceEndpoint");
    private final String value;

    BaseArtifactEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BaseArtifactEnum fromValue(String v) {
        for (BaseArtifactEnum c: BaseArtifactEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
