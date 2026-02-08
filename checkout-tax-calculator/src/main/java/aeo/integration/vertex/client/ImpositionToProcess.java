
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}JurisdictionLevel"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}ImpositionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "jurisdictionLevel",
    "impositionType"
})
@XmlRootElement(name = "ImpositionToProcess")
public class ImpositionToProcess {

    @XmlElement(name = "JurisdictionLevel", required = true)
    @XmlSchemaType(name = "NMTOKEN")
    protected JurisdictionLevelCodeType jurisdictionLevel;
    @XmlElement(name = "ImpositionType")
    protected ImpositionType impositionType;

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

}
