
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TaxCollectedFromPartyType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TaxCollectedFromPartyType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="SELLER"/>
 *     &lt;enumeration value="BUYER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TaxCollectedFromPartyType")
@XmlEnum
public enum TaxCollectedFromPartyType {


    /**
     * In Supplies transactions, the Seller is equivalent to the Taxpayer
     *                         responsible for collecting and remitting tax.
     *                     
     * 
     */
    SELLER,

    /**
     * In Sales tax or Value Added Tax Supplies transactions, the Buyer is
     *                         equivalent to the Customer receiving goods or services.
     *                     
     * 
     */
    BUYER;

    public String value() {
        return name();
    }

    public static TaxCollectedFromPartyType fromValue(String v) {
        return valueOf(v);
    }

}
