
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SimplificationCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SimplificationCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="CONSIGNMENT"/>
 *     &lt;enumeration value="CALL_OFF"/>
 *     &lt;enumeration value="TRIANGULATION"/>
 *     &lt;enumeration value="REGISTRATION_GROUP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SimplificationCodeType")
@XmlEnum
public enum SimplificationCodeType {


    /**
     * Indicates transfer of goods from one country to another to create a stock that is
     *                         held in the second country under the owners control. The stock is available for sale to multiple
     *                         customers. This condition applies to Asset Movement transactions only. Depending on the
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
     * Involves two sales of the same goods within the EU. Three taxpayers are involved
     *                         and located in different Member States. Party A sells goods to Party B, who in turn sells the
     *                         goods to Party C but has Party A ship the goods directly to Party C. Party A issues a zero-rated
     *                         invoice to Party B. Party B issues a zero-rated invoice to Party C. Party C self-assesses the
     *                         VAT due. The goods do not follow the invoice trail because they never go to Party B.
     *                     
     * 
     */
    TRIANGULATION,

    /**
     * Identifies the transaction as involving a VAT group. A VAT group consists of two
     *                         or more corporate entities that have registered to be treated as a single taxable person for VAT
     *                         purposes.
     *                     
     * 
     */
    REGISTRATION_GROUP;

    public String value() {
        return name();
    }

    public static SimplificationCodeType fromValue(String v) {
        return valueOf(v);
    }

}
