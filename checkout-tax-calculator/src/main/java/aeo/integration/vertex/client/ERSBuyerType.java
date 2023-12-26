
package aeo.integration.vertex.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ERSBuyerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ERSBuyerType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vertexinc:o-series:tps:9:0}TaxpayerType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}Destination" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}AdministrativeDestination" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}ExemptionCertificate" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}TaxRegistration" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="isTaxExempt" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="exemptionReasonCode" type="{urn:vertexinc:o-series:tps:9:0}ReasonCodeType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ERSBuyerType", propOrder = {
    "destination",
    "administrativeDestination",
    "exemptionCertificate",
    "taxRegistration"
})
public class ERSBuyerType
    extends TaxpayerType
{

    @XmlElement(name = "Destination")
    protected LocationType destination;
    @XmlElement(name = "AdministrativeDestination")
    protected LocationType administrativeDestination;
    @XmlElement(name = "ExemptionCertificate")
    protected ExemptionCertificate exemptionCertificate;
    @XmlElement(name = "TaxRegistration")
    protected List<TaxRegistrationType> taxRegistration;
    @XmlAttribute(name = "isTaxExempt")
    protected Boolean isTaxExempt;
    @XmlAttribute(name = "exemptionReasonCode")
    protected String exemptionReasonCode;

    /**
     * Gets the value of the destination property.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getDestination() {
        return destination;
    }

    /**
     * Sets the value of the destination property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setDestination(LocationType value) {
        this.destination = value;
    }

    /**
     * Gets the value of the administrativeDestination property.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getAdministrativeDestination() {
        return administrativeDestination;
    }

    /**
     * Sets the value of the administrativeDestination property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setAdministrativeDestination(LocationType value) {
        this.administrativeDestination = value;
    }

    /**
     * Gets the value of the exemptionCertificate property.
     * 
     * @return
     *     possible object is
     *     {@link ExemptionCertificate }
     *     
     */
    public ExemptionCertificate getExemptionCertificate() {
        return exemptionCertificate;
    }

    /**
     * Sets the value of the exemptionCertificate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExemptionCertificate }
     *     
     */
    public void setExemptionCertificate(ExemptionCertificate value) {
        this.exemptionCertificate = value;
    }

    /**
     * Gets the value of the taxRegistration property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxRegistration property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxRegistration().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaxRegistrationType }
     * 
     * 
     */
    public List<TaxRegistrationType> getTaxRegistration() {
        if (taxRegistration == null) {
            taxRegistration = new ArrayList<TaxRegistrationType>();
        }
        return this.taxRegistration;
    }

    /**
     * Gets the value of the isTaxExempt property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isIsTaxExempt() {
        if (isTaxExempt == null) {
            return false;
        } else {
            return isTaxExempt;
        }
    }

    /**
     * Sets the value of the isTaxExempt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsTaxExempt(Boolean value) {
        this.isTaxExempt = value;
    }

    /**
     * Gets the value of the exemptionReasonCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExemptionReasonCode() {
        return exemptionReasonCode;
    }

    /**
     * Sets the value of the exemptionReasonCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExemptionReasonCode(String value) {
        this.exemptionReasonCode = value;
    }

}
