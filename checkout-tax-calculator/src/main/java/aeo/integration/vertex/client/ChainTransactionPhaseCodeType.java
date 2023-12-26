
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ChainTransactionPhaseCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ChainTransactionPhaseCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="MANUFACTURER"/>
 *     &lt;enumeration value="INTERMEDIARY"/>
 *     &lt;enumeration value="FINAL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ChainTransactionPhaseCodeType")
@XmlEnum
public enum ChainTransactionPhaseCodeType {


    /**
     * An entity that creates some good or tangible property.
     * 
     */
    MANUFACTURER,

    /**
     * A third-party entity between the manufacturer that creates the good or tangible
     *                         property and the final consumer of the good or property. This is a Domestic VAT scenario.
     *                     
     * 
     */
    INTERMEDIARY,

    /**
     * An entity that is the final consumer of the good or tangible property. This is an
     *                         Intra-EU, Zero Rate VAT scenario.
     *                     
     * 
     */
    FINAL;

    public String value() {
        return name();
    }

    public static ChainTransactionPhaseCodeType fromValue(String v) {
        return valueOf(v);
    }

}
