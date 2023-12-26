
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TaxOverrideCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TaxOverrideCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="TAXABLE"/>
 *     &lt;enumeration value="NONTAXABLE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TaxOverrideCodeType")
@XmlEnum
public enum TaxOverrideCodeType {


    /**
     * Indicates the line item is subject to tax.
     * 
     */
    TAXABLE,

    /**
     * Indicates the line item is not subject to tax. You can indicate the reason in the
     *                         overrideReasonCode attribute.
     *                     
     * 
     */
    NONTAXABLE;

    public String value() {
        return name();
    }

    public static TaxOverrideCodeType fromValue(String v) {
        return valueOf(v);
    }

}
