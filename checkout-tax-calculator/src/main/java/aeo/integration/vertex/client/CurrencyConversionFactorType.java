
package aeo.integration.vertex.client;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CurrencyConversionFactorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CurrencyConversionFactorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SourceCurrency" type="{urn:vertexinc:o-series:tps:9:0}CurrencyType"/>
 *         &lt;element name="TargetCurrency" type="{urn:vertexinc:o-series:tps:9:0}CurrencyType"/>
 *         &lt;element name="ConversionFactor" type="{urn:vertexinc:o-series:tps:9:0}AmountType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CurrencyConversionFactorType", propOrder = {
    "sourceCurrency",
    "targetCurrency",
    "conversionFactor"
})
public class CurrencyConversionFactorType {

    @XmlElement(name = "SourceCurrency", required = true)
    protected CurrencyType sourceCurrency;
    @XmlElement(name = "TargetCurrency", required = true)
    protected CurrencyType targetCurrency;
    @XmlElement(name = "ConversionFactor", required = true)
    protected BigDecimal conversionFactor;

    /**
     * Gets the value of the sourceCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyType }
     *     
     */
    public CurrencyType getSourceCurrency() {
        return sourceCurrency;
    }

    /**
     * Sets the value of the sourceCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyType }
     *     
     */
    public void setSourceCurrency(CurrencyType value) {
        this.sourceCurrency = value;
    }

    /**
     * Gets the value of the targetCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyType }
     *     
     */
    public CurrencyType getTargetCurrency() {
        return targetCurrency;
    }

    /**
     * Sets the value of the targetCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyType }
     *     
     */
    public void setTargetCurrency(CurrencyType value) {
        this.targetCurrency = value;
    }

    /**
     * Gets the value of the conversionFactor property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getConversionFactor() {
        return conversionFactor;
    }

    /**
     * Sets the value of the conversionFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setConversionFactor(BigDecimal value) {
        this.conversionFactor = value;
    }

}
