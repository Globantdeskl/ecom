
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UtilityProviderType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UtilityProviderType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="REGULATED_TAXPAYER"/>
 *     &lt;enumeration value="UNREGULATED_TAXPAYER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UtilityProviderType")
@XmlEnum
public enum UtilityProviderType {

    REGULATED_TAXPAYER,
    UNREGULATED_TAXPAYER;

    public String value() {
        return name();
    }

    public static UtilityProviderType fromValue(String v) {
        return valueOf(v);
    }

}
