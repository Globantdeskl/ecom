
package aeo.integration.vertex.client;

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
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}DeductionOverride" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}RateOverride" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}ImpositionType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="jurisdictionLevel" use="required" type="{urn:vertexinc:o-series:tps:9:0}JurisdictionLevelCodeType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "deductionOverride",
    "rateOverride",
    "impositionType"
})
@XmlRootElement(name = "JurisdictionOverride")
public class JurisdictionOverride {

    @XmlElement(name = "DeductionOverride")
    protected DeductionOverride deductionOverride;
    @XmlElement(name = "RateOverride")
    protected RateOverride rateOverride;
    @XmlElement(name = "ImpositionType")
    protected ImpositionType impositionType;
    @XmlAttribute(name = "jurisdictionLevel", required = true)
    protected JurisdictionLevelCodeType jurisdictionLevel;

    /**
     * Gets the value of the deductionOverride property.
     * 
     * @return
     *     possible object is
     *     {@link DeductionOverride }
     *     
     */
    public DeductionOverride getDeductionOverride() {
        return deductionOverride;
    }

    /**
     * Sets the value of the deductionOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeductionOverride }
     *     
     */
    public void setDeductionOverride(DeductionOverride value) {
        this.deductionOverride = value;
    }

    /**
     * Gets the value of the rateOverride property.
     * 
     * @return
     *     possible object is
     *     {@link RateOverride }
     *     
     */
    public RateOverride getRateOverride() {
        return rateOverride;
    }

    /**
     * Sets the value of the rateOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link RateOverride }
     *     
     */
    public void setRateOverride(RateOverride value) {
        this.rateOverride = value;
    }

    /**
     * The type description that is assigned to the imposition.
     * 
     * @return
     *     possible object is
     *     {@link ImpositionType }
     *     
     */
    public ImpositionType getImpositionType() {
        return impositionType;
    }

    /**
     * Sets the value of the impositionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImpositionType }
     *     
     */
    public void setImpositionType(ImpositionType value) {
        this.impositionType = value;
    }

    /**
     * Gets the value of the jurisdictionLevel property.
     * 
     * @return
     *     possible object is
     *     {@link JurisdictionLevelCodeType }
     *     
     */
    public JurisdictionLevelCodeType getJurisdictionLevel() {
        return jurisdictionLevel;
    }

    /**
     * Sets the value of the jurisdictionLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link JurisdictionLevelCodeType }
     *     
     */
    public void setJurisdictionLevel(JurisdictionLevelCodeType value) {
        this.jurisdictionLevel = value;
    }

}
