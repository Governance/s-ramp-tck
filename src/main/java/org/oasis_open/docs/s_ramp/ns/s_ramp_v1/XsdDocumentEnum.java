//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.08.01 at 01:38:08 PM EDT 
//


package org.oasis_open.docs.s_ramp.ns.s_ramp_v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for xsdDocumentEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="xsdDocumentEnum">
 *   &lt;restriction base="{http://docs.oasis-open.org/s-ramp/ns/s-ramp-v1.0}baseArtifactEnum">
 *     &lt;enumeration value="XsdDocument"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "xsdDocumentEnum")
@XmlEnum(BaseArtifactEnum.class)
public enum XsdDocumentEnum {

    @XmlEnumValue("XsdDocument")
    XSD_DOCUMENT(BaseArtifactEnum.XSD_DOCUMENT);
    private final BaseArtifactEnum value;

    XsdDocumentEnum(BaseArtifactEnum v) {
        value = v;
    }

    public BaseArtifactEnum value() {
        return value;
    }

    public static XsdDocumentEnum fromValue(BaseArtifactEnum v) {
        for (XsdDocumentEnum c: XsdDocumentEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}