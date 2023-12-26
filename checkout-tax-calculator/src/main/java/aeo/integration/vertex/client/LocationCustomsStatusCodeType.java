
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LocationCustomsStatusCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LocationCustomsStatusCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;minLength value="0"/>
 *     &lt;enumeration value="FREE_CIRCULATION"/>
 *     &lt;enumeration value="BONDED_WAREHOUSE"/>
 *     &lt;enumeration value="FREE_TRADE_ZONE"/>
 *     &lt;enumeration value="TEMPORARY_IMPORT"/>
 *     &lt;enumeration value="INWARD_PROCESSING_RELIEF"/>
 *     &lt;enumeration value="OUTWARD_PROCESSING_RELIEF"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LocationCustomsStatusCodeType")
@XmlEnum
public enum LocationCustomsStatusCodeType {


    /**
     * The status of goods which have been imported, where all the applicable
     *                         documentation has been completed and the duties paid.
     *                     
     * 
     */
    FREE_CIRCULATION,

    /**
     * Indicates that goods reside in a Bonded or Customs Warehouse. A Bonded warehouse
     *                         is a warehouse where goods on which duties have not yet been paid can be stored. The goods are
     *                         stored under bond and in joint custody of the importer (or the importer’s agent) and the customs
     *                         officers.
     *                     
     * 
     */
    BONDED_WAREHOUSE,

    /**
     * Indicates that goods are located in a Free Trade Zone (FTZ). An FTZ is one or
     *                         more areas of a country where tariffs and quotas are eliminated, and bureaucratic requirements
     *                         are lowered in hopes of attracting new business and foreign investment.
     *                     
     * 
     */
    FREE_TRADE_ZONE,

    /**
     * Indicates that goods have entered the location on a temporary basis. Temporary
     *                         imports are a procedure where goods may enter a custom territory, under specific conditions,
     *                         free of duty for a limited time. Instead of duty, the importer posts bond for twice the amount
     *                         of duty, taxes, and other related importation charges that would otherwise be owed. The importer
     *                         agrees to export or destroy the merchandise within a specified time or pay liquidated damages,
     *                         which are twice the normal duty.
     *                     
     * 
     */
    TEMPORARY_IMPORT,

    /**
     * Indicates that goods are subject to Inward Processing Relief (IPR). IPR is a
     *                         method of obtaining relief from customs duties and VAT charges. This relief applies to goods
     *                         imported from outside a country, processed, and exported to other countries.
     *                     
     * 
     */
    INWARD_PROCESSING_RELIEF,

    /**
     * Indicates that goods are subject to Outward Processing Relief (OPR). OPR is a
     *                         method of obtaining relief from Customs duty. The relief applies to goods, imported from non-EU
     *                         countries, which have been produced from goods which were previously exported from the EU.
     *                     
     * 
     */
    OUTWARD_PROCESSING_RELIEF;

    public String value() {
        return name();
    }

    public static LocationCustomsStatusCodeType fromValue(String v) {
        return valueOf(v);
    }

}
