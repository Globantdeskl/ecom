
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TaxingLocationCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TaxingLocationCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;minLength value="1"/>
 *     &lt;maxLength value="60"/>
 *     &lt;enumeration value="ADMINISTRATIVE_DESTINATION"/>
 *     &lt;enumeration value="ADMINISTRATIVE_ORIGIN"/>
 *     &lt;enumeration value="DESTINATION"/>
 *     &lt;enumeration value="PHYSICAL_ORIGIN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TaxingLocationCodeType")
@XmlEnum
public enum TaxingLocationCodeType {


    /**
     * Administrative Destination is equivalent to the Bill To: location. 
     * A common synonym is benefit received. 
     * 
     * For service transactions in the U.S. and Canada, the administrative
     * destination is the benefit received location and the destination is the
     * service performed location. 
     * 
     * For tangible personal property transactions, the administrative 
     * destination is examined when checking for the triangulation condition
     * of an intra-European Union (EU) transaction from the buyer's perspective.
     * 
     */
    ADMINISTRATIVE_DESTINATION,

    /**
     * Administrative Origin is equivalent to the Bill-From: location. 
     * Common synonyms include order taken, order acceptance, place of 
     * principal negotiation, and place of business.
     * 
     */
    ADMINISTRATIVE_ORIGIN,

    /**
     * Destination is equivalent to the Ship-To: location. Common synonyms
     * include benefit received, first used, where used, primary place of use,
     * principal use location, location of property, and place of use.
     * 
     */
    DESTINATION,

    /**
     * Physical Origin is equivalent to the Ship-From: location. 
     * A common synonym is first removed. A physical origin is required to 
     * perform triangulation in the case of value added tax transactions.
     * 
     */
    PHYSICAL_ORIGIN;

    public String value() {
        return name();
    }

    public static TaxingLocationCodeType fromValue(String v) {
        return valueOf(v);
    }

}
