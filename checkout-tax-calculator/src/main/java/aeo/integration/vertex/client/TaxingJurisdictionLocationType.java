
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TaxingJurisdictionLocationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TaxingJurisdictionLocationType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vertexinc:o-series:tps:9:0}LocationType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}ImpositionType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="jurisdictionLevel" use="required" type="{urn:vertexinc:o-series:tps:9:0}JurisdictionLevelCodeType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxingJurisdictionLocationType", propOrder = {
    "impositionType"
})
@XmlSeeAlso({
    aeo.integration.vertex.client.InputTax.TaxingJurisdictionLocation.class
})
public class TaxingJurisdictionLocationType
    extends LocationType
{

    @XmlElement(name = "ImpositionType")
    protected ImpositionType impositionType;
    @XmlAttribute(name = "jurisdictionLevel", required = true)
    protected JurisdictionLevelCodeType jurisdictionLevel;

    /**
     * Gets the value of the impositionType property.
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
