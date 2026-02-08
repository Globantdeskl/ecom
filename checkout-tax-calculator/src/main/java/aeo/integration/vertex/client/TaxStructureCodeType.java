
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TaxStructureCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TaxStructureCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="BRACKET"/>
 *     &lt;enumeration value="FLAT_TAX"/>
 *     &lt;enumeration value="QUANTITY"/>
 *     &lt;enumeration value="SINGLE_RATE"/>
 *     &lt;enumeration value="TIERED"/>
 *     &lt;enumeration value="QUANTITY_TIERED"/>
 *     &lt;enumeration value="QUANTITY_RATE_TIERED"/>
 *     &lt;enumeration value="TIERED_MODIFIER"/>
 *     &lt;enumeration value="QUANTITY_TIERED_MODIFIER"/>
 *     &lt;enumeration value="QUANTITY_RATE_TIERED_MODIFIER"/>
 *     &lt;enumeration value="QUANTITY_TIERED_FLAT"/>
 *     &lt;enumeration value="TIERED_FLAT"/>
 *     &lt;enumeration value="QUANTITY_RATE_TIERED_EQUIVALENT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TaxStructureCodeType")
@XmlEnum
public enum TaxStructureCodeType {


    /**
     * Tax is based on a the bracket tax schedule logic of a jurisdiction. Bracket tax
     *                         schedules are provided through Vertex data updates.
     *                     
     * 
     */
    BRACKET,

    /**
     * Tax is a flat fee amount that is applied uniformly to every transaction.
     *                     
     * 
     */
    FLAT_TAX,

    /**
     * Tax is based on either the number of units or the type of units in a
     *                         transaction.
     *                     
     * 
     */
    QUANTITY,

    /**
     * Tax is based on a single percentage rate.
     * 
     */
    SINGLE_RATE,

    /**
     * Tax varies, based on the levels of taxable amounts defined by the
     *                         jurisdiction.
     *                     
     * 
     */
    TIERED,

    /**
     * Tax varies, based on the levels of quantity amounts defined by the
     *                         jurisdiction.
     *                     
     * 
     */
    QUANTITY_TIERED,

    /**
     * Tax rate varies, based on the levels of quantity amounts defined by the
     *                         jurisdiction.
     *                     
     * 
     */
    QUANTITY_RATE_TIERED,

    /**
     * Tax varies with a modifying percentage, based on the levels of taxable amounts defined by the
     *                         jurisdiction.
     *                     
     * 
     */
    TIERED_MODIFIER,

    /**
     * Tax varies with a modifying percentage, based on the levels of quantity amounts defined by the
     *                         jurisdiction.
     *                     
     * 
     */
    QUANTITY_TIERED_MODIFIER,

    /**
     * Tax rate varies with a modifying percentage, based on the levels of quantity amounts defined by the
     *                         jurisdiction.
     *                     
     * 
     */
    QUANTITY_RATE_TIERED_MODIFIER,

    /**
     * Flat tax varies as a flat amount, based on the levels of quantity amounts defined by the
     *                         jurisdiction.
     *                     
     * 
     */
    QUANTITY_TIERED_FLAT,

    /**
     * Flat tax varies, based on the levels of taxable amounts defined by the
     *                         jurisdiction.
     *                     
     * 
     */
    TIERED_FLAT,

    /**
     * Tax varies, based on the levels of quantity amounts or equavlent quantity amounts defined by the
     *                         jurisdiction.
     *                     
     * 
     */
    QUANTITY_RATE_TIERED_EQUIVALENT;

    public String value() {
        return name();
    }

    public static TaxStructureCodeType fromValue(String v) {
        return valueOf(v);
    }

}
