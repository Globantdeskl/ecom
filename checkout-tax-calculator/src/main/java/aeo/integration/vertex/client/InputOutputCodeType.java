
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InputOutputCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InputOutputCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="INPUT"/>
 *     &lt;enumeration value="IMPORT"/>
 *     &lt;enumeration value="OUTPUT"/>
 *     &lt;enumeration value="INPUT_OUTPUT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InputOutputCodeType")
@XmlEnum
public enum InputOutputCodeType {


    /**
     * Input VAT is the VAT you incur as part of the purchase price of your goods or
     *                         services. This is the VAT paid to the Vendor on purchases.
     *                     
     * 
     */
    INPUT,

    /**
     * Import VAT is charged when goods are imported into one jurisdiction (country)
     *                         from another jurisdiction (country). This is the VAT paid by the Importer of Record on goods
     *                         brought in from another jurisdiction (country). The tax is paid at the time the goods clear
     *                         customs unless they go into a suspended state. The tax would then be due when the goods enter
     *                         into free circulation.
     * 
     *                         For VAT purposes, the jurisdictions (countries) in the EU are affiliated together as a trade
     *                         block. The EU acts as a single jurisdiction (country) for VAT purposes. Specific territories
     *                         that trade with the EU are excluded from VAT. These territories are the Island of Heligoland and
     *                         the territory of Büsingen (Germany); Ceuta, Melilla, and Canary Island (Spain); Livigno,
     *                         Campione d'Italia, and the Italian waters of Lake Lugano (Italy); the French Overseas
     *                         Departments of Guadeloupe, French Guiana, Martinque and and Reunion, and Monaco (France); Mount
     *                         Athos, also known as Agion Poros (Greece); Åland Islands, (Finland), the Isle of Man (United
     *                         Kingdom); and Akrotiri and Dhekelia (Cyprus).
     *                     
     * 
     */
    IMPORT,

    /**
     * Output VAT is the VAT you add to the sale price of your goods or services. This
     *                         is the VAT charged by the Taxpayer on sales.
     *                     
     * 
     */
    OUTPUT,

    /**
     * Input_Output is the code used to specify the application of a reverse charge. In
     *                         this case, the buyer has accounted for the VAT due.
     *                     
     * 
     */
    INPUT_OUTPUT;

    public String value() {
        return name();
    }

    public static InputOutputCodeType fromValue(String v) {
        return valueOf(v);
    }

}
