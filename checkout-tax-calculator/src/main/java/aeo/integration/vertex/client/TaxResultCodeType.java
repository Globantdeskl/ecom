
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TaxResultCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TaxResultCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="TAXABLE"/>
 *     &lt;enumeration value="NONTAXABLE"/>
 *     &lt;enumeration value="EXEMPT"/>
 *     &lt;enumeration value="DPPAPPLIED"/>
 *     &lt;enumeration value="NO_TAX"/>
 *     &lt;enumeration value="DEFERRED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TaxResultCodeType")
@XmlEnum
public enum TaxResultCodeType {


    /**
     * This result has a tax imposition.
     * 
     */
    TAXABLE,

    /**
     * This result does not have a tax imposition.
     * 
     */
    NONTAXABLE,

    /**
     * This result is exempt from tax.
     * 
     */
    EXEMPT,

    /**
     * This result, due to its situs (Place of Supply) determination, applies a Direct
     *                         Pay Permit tax imposition. A Direct Pay Permit is a document granted by a jurisdiction that
     *                         allows a buyer to determine which of their purchases are taxable and which are exempt, and remit
     *                         any tax that is due directly to the jurisdiction. When a buyer submits a valid Direct Payment
     *                         Permit certificate to a seller, the seller is relieved of all responsibility for collecting tax
     *                         from the permit holder. Tax is not calculated
     *                     
     * 
     */
    DPPAPPLIED,

    /**
     * This result has no tax.
     * 
     */
    NO_TAX,

    /**
     * This result, due to its situs determination, has a tax, but the imposition of the
     *                         tax is deferred.
     *                     
     * 
     */
    DEFERRED;

    public String value() {
        return name();
    }

    public static TaxResultCodeType fromValue(String v) {
        return valueOf(v);
    }

}
