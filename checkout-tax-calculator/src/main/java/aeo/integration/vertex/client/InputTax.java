
package aeo.integration.vertex.client;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TaxingJurisdictionLocation">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{urn:vertexinc:o-series:tps:9:0}TaxingJurisdictionLocationType">
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}InputAmount"/>
 *         &lt;element name="InvoiceTaxRate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="BlockingOverridePercent" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{urn:vertexinc:o-series:tps:9:0}PercentType">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PartialExemptRecoverableOverridePercent" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{urn:vertexinc:o-series:tps:9:0}PercentType">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="isImport" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "taxingJurisdictionLocation",
    "inputAmount",
    "invoiceTaxRate",
    "blockingOverridePercent",
    "partialExemptRecoverableOverridePercent"
})
@XmlRootElement(name = "InputTax")
public class InputTax {

    @XmlElement(name = "TaxingJurisdictionLocation", required = true)
    protected InputTax.TaxingJurisdictionLocation taxingJurisdictionLocation;
    @XmlElement(name = "InputAmount", required = true)
    protected BigDecimal inputAmount;
    @XmlElement(name = "InvoiceTaxRate")
    protected BigDecimal invoiceTaxRate;
    @XmlElement(name = "BlockingOverridePercent")
    protected BigDecimal blockingOverridePercent;
    @XmlElement(name = "PartialExemptRecoverableOverridePercent")
    protected BigDecimal partialExemptRecoverableOverridePercent;
    @XmlAttribute(name = "isImport")
    protected Boolean isImport;

    /**
     * Gets the value of the taxingJurisdictionLocation property.
     * 
     * @return
     *     possible object is
     *     {@link InputTax.TaxingJurisdictionLocation }
     *     
     */
    public InputTax.TaxingJurisdictionLocation getTaxingJurisdictionLocation() {
        return taxingJurisdictionLocation;
    }

    /**
     * Sets the value of the taxingJurisdictionLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link InputTax.TaxingJurisdictionLocation }
     *     
     */
    public void setTaxingJurisdictionLocation(InputTax.TaxingJurisdictionLocation value) {
        this.taxingJurisdictionLocation = value;
    }

    /**
     * Gets the value of the inputAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInputAmount() {
        return inputAmount;
    }

    /**
     * Sets the value of the inputAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInputAmount(BigDecimal value) {
        this.inputAmount = value;
    }

    /**
     * Gets the value of the invoiceTaxRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInvoiceTaxRate() {
        return invoiceTaxRate;
    }

    /**
     * Sets the value of the invoiceTaxRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInvoiceTaxRate(BigDecimal value) {
        this.invoiceTaxRate = value;
    }

    /**
     * Gets the value of the blockingOverridePercent property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBlockingOverridePercent() {
        return blockingOverridePercent;
    }

    /**
     * Sets the value of the blockingOverridePercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBlockingOverridePercent(BigDecimal value) {
        this.blockingOverridePercent = value;
    }

    /**
     * Gets the value of the partialExemptRecoverableOverridePercent property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPartialExemptRecoverableOverridePercent() {
        return partialExemptRecoverableOverridePercent;
    }

    /**
     * Sets the value of the partialExemptRecoverableOverridePercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPartialExemptRecoverableOverridePercent(BigDecimal value) {
        this.partialExemptRecoverableOverridePercent = value;
    }

    /**
     * Gets the value of the isImport property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isIsImport() {
        if (isImport == null) {
            return false;
        } else {
            return isImport;
        }
    }

    /**
     * Sets the value of the isImport property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsImport(Boolean value) {
        this.isImport = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{urn:vertexinc:o-series:tps:9:0}TaxingJurisdictionLocationType">
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class TaxingJurisdictionLocation
        extends TaxingJurisdictionLocationType
    {


    }

}
