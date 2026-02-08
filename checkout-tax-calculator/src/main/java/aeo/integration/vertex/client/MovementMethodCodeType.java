
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MovementMethodCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MovementMethodCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="CONSIGNMENT"/>
 *     &lt;enumeration value="CALL_OFF"/>
 *     &lt;enumeration value="REGULAR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MovementMethodCodeType")
@XmlEnum
public enum MovementMethodCodeType {


    /**
     * Indicates transfer of goods from one country to another to create a stock that is
     *                         held in the second country under the owner's control. The stock is available for sale to
     *                         multiple customers. This condition applies to Asset Movement transactions only. Depending on the
     *                         countries involved in the transaction, it may allow for the deferment of Value Added Tax.
     *                     
     * 
     */
    CONSIGNMENT,

    /**
     * Indicates transfer of goods from one country to another to create a stock that is
     *                         held in the second country for the use of a single customer. The stock is not intended for sale
     *                         to any party other than the single customer. This condition applies to Asset Movement
     *                         transactions only. Depending on the countries involved in the transaction, it may allow for the
     *                         deferment of Value Added Tax.
     *                     
     * 
     */
    CALL_OFF,

    /**
     * Indicates that there is no special consignment stock or call off stock condition
     *                         to be considered for tax calculation.
     *                     
     * 
     */
    REGULAR;

    public String value() {
        return name();
    }

    public static MovementMethodCodeType fromValue(String v) {
        return valueOf(v);
    }

}
