
package aeo.integration.vertex.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VendorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VendorType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vertexinc:o-series:tps:9:0}PartyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}VendorCode" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}PhysicalOrigin" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}AdministrativeOrigin" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}TaxRegistration" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VendorType", propOrder = {
    "vendorCode",
    "physicalOrigin",
    "administrativeOrigin",
    "taxRegistration"
})
public class VendorType
    extends PartyType
{

    @XmlElement(name = "VendorCode")
    protected VendorCode vendorCode;
    @XmlElement(name = "PhysicalOrigin")
    protected LocationType physicalOrigin;
    @XmlElement(name = "AdministrativeOrigin")
    protected LocationType administrativeOrigin;
    @XmlElement(name = "TaxRegistration")
    protected List<TaxRegistrationType> taxRegistration;

    /**
     * Gets the value of the vendorCode property.
     * 
     * @return
     *     possible object is
     *     {@link VendorCode }
     *     
     */
    public VendorCode getVendorCode() {
        return vendorCode;
    }

    /**
     * Sets the value of the vendorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link VendorCode }
     *     
     */
    public void setVendorCode(VendorCode value) {
        this.vendorCode = value;
    }

    /**
     * Gets the value of the physicalOrigin property.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getPhysicalOrigin() {
        return physicalOrigin;
    }

    /**
     * Sets the value of the physicalOrigin property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setPhysicalOrigin(LocationType value) {
        this.physicalOrigin = value;
    }

    /**
     * Gets the value of the administrativeOrigin property.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getAdministrativeOrigin() {
        return administrativeOrigin;
    }

    /**
     * Sets the value of the administrativeOrigin property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setAdministrativeOrigin(LocationType value) {
        this.administrativeOrigin = value;
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

}
