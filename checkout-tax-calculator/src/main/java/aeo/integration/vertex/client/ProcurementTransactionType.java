
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProcurementTransactionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ProcurementTransactionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="RENTAL"/>
 *     &lt;enumeration value="LEASE"/>
 *     &lt;enumeration value="PURCHASE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ProcurementTransactionType")
@XmlEnum
public enum ProcurementTransactionType {


    /**
     * A transaction that results in the transfer of possession, not title,
     *                         of tangible personal property (for consideration) to a customer for
     *                         use. Rental time periods are typically shorter in duration as compared
     *                         to leases. For some jurisdictions, rental and lease are synonymous.
     *                     
     * 
     */
    RENTAL,

    /**
     * A transaction that results in the transfer of possession, but not title,
     *                         of tangible personal property (for consideration) to a customer for
     *                         the customer’s use for a specified time period.
     *                     
     * 
     */
    LEASE,

    /**
     * A transaction that results in the passage of title, possession, or
     *                         service benefit to a buyer from a seller in exchange for consideration.
     *                     
     * 
     */
    PURCHASE;

    public String value() {
        return name();
    }

    public static ProcurementTransactionType fromValue(String v) {
        return valueOf(v);
    }

}
