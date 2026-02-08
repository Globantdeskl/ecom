
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TaxingType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TaxingType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="SALES"/>
 *     &lt;enumeration value="SELLER_USE"/>
 *     &lt;enumeration value="CONSUMERS_USE"/>
 *     &lt;enumeration value="VAT"/>
 *     &lt;enumeration value="IMPORT_VAT"/>
 *     &lt;enumeration value="NONE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TaxingType")
@XmlEnum
public enum TaxingType {


    /**
     * A tax imposed on the privilege of making sales. Sales taxes are typically imposed on intrastate transactions.
     * 
     */
    SALES,

    /**
     * A tax imposed on the amount charged for the transfer of title or possession of tangible personal property and/or services. The tax is collected when the seller and the purchaser are located in different taxing authorities.
     * 
     */
    SELLER_USE,

    /**
     * Tax liability that is imposed on the storage, use, consumption, and, sometimes, distribution of property or services. Consumer use taxes typically arise when the seller that provides the goods or services is not registered to bill and collect the tax in a taxing jurisdiction.
     * 
     */
    CONSUMERS_USE,

    /**
     * Value Added Tax (VAT) is imposed on all possible entity types of taxpayer (such as individuals and enterprises) on the sale price of goods or certain services. VAT typically applies to the sale and importation of goods and also applies to processing, repair, or replacement services carried out in the taxing country.
     * 
     */
    VAT,

    /**
     * Import VAT is charged when goods are imported into one jurisdiction (country) from another jurisdiction (country). This is the VAT paid by the Importer of Record on goods brought in from another jurisdiction (country). The tax is paid at the time the goods clear customs unless they go into a suspended state. The tax would then be due when the goods enter into free circulation. 
     * 
     * For VAT purposes, the jurisdictions (countries) in the EU are affiliated together as a trade block. The EU acts as a single jurisdiction (country) for VAT purposes. Specific territories that trade with the EU are excluded from VAT.  These territories are the Island of Heligoland and the territory of Büsingen  (Germany); Ceuta, Melilla, and Canary Island (Spain); Livigno, Campione d'Italia, and the Italian waters of Lake Lugano (Italy); the French Overseas Departments of Guadeloupe, French Guiana, Martinque and  and Reunion, and Monaco (France); Mount Athos, also known asa Agion Poros (Greece).
     * 
     */
    IMPORT_VAT,

    /**
     * No tax is imposed.
     * 
     */
    NONE;

    public String value() {
        return name();
    }

    public static TaxingType fromValue(String v) {
        return valueOf(v);
    }

}
