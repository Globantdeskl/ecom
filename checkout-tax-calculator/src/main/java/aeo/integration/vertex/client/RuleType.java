
package aeo.integration.vertex.client;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for RuleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RuleType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>positiveInteger">
 *       &lt;attribute name="userDefined" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="salesTaxHolidayIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="taxRuleType" type="{urn:vertexinc:o-series:tps:9:0}TaxRuleCodeType" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RuleType", propOrder = {
    "value"
})
public class RuleType {

    @XmlValue
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger value;
    @XmlAttribute(name = "userDefined")
    protected Boolean userDefined;
    @XmlAttribute(name = "salesTaxHolidayIndicator")
    protected Boolean salesTaxHolidayIndicator;
    @XmlAttribute(name = "taxRuleType")
    protected TaxRuleCodeType taxRuleType;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setValue(BigInteger value) {
        this.value = value;
    }

    /**
     * Gets the value of the userDefined property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUserDefined() {
        return userDefined;
    }

    /**
     * Sets the value of the userDefined property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUserDefined(Boolean value) {
        this.userDefined = value;
    }

    /**
     * Gets the value of the salesTaxHolidayIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSalesTaxHolidayIndicator() {
        return salesTaxHolidayIndicator;
    }

    /**
     * Sets the value of the salesTaxHolidayIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSalesTaxHolidayIndicator(Boolean value) {
        this.salesTaxHolidayIndicator = value;
    }

    /**
     * Gets the value of the taxRuleType property.
     * 
     * @return
     *     possible object is
     *     {@link TaxRuleCodeType }
     *     
     */
    public TaxRuleCodeType getTaxRuleType() {
        return taxRuleType;
    }

    /**
     * Sets the value of the taxRuleType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxRuleCodeType }
     *     
     */
    public void setTaxRuleType(TaxRuleCodeType value) {
        this.taxRuleType = value;
    }

}
