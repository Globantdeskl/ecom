
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TaxRuleCurrencyConversionFactorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TaxRuleCurrencyConversionFactorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TaxRuleId" type="{urn:vertexinc:o-series:tps:9:0}RuleType"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}CurrencyConversionFactors"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxRuleCurrencyConversionFactorType", propOrder = {
    "taxRuleId",
    "currencyConversionFactors"
})
public class TaxRuleCurrencyConversionFactorType {

    @XmlElement(name = "TaxRuleId", required = true)
    protected RuleType taxRuleId;
    @XmlElement(name = "CurrencyConversionFactors", required = true)
    protected CurrencyConversionFactors currencyConversionFactors;

    /**
     * Gets the value of the taxRuleId property.
     * 
     * @return
     *     possible object is
     *     {@link RuleType }
     *     
     */
    public RuleType getTaxRuleId() {
        return taxRuleId;
    }

    /**
     * Sets the value of the taxRuleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link RuleType }
     *     
     */
    public void setTaxRuleId(RuleType value) {
        this.taxRuleId = value;
    }

    /**
     * A list of conversion factors that Vertex O Series requires to perform currency
     *                         conversion. These factors include Source Currency, Target Currency, and Conversion Factor.
     *                     
     * 
     * @return
     *     possible object is
     *     {@link CurrencyConversionFactors }
     *     
     */
    public CurrencyConversionFactors getCurrencyConversionFactors() {
        return currencyConversionFactors;
    }

    /**
     * Sets the value of the currencyConversionFactors property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyConversionFactors }
     *     
     */
    public void setCurrencyConversionFactors(CurrencyConversionFactors value) {
        this.currencyConversionFactors = value;
    }

}
