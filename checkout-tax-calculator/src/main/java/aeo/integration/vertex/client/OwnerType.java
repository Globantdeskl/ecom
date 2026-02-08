
package aeo.integration.vertex.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OwnerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OwnerType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vertexinc:o-series:tps:9:0}TaxpayerType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}PhysicalOrigin" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}Destination" minOccurs="0"/>
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
@XmlType(name = "OwnerType", propOrder = {
    "physicalOrigin",
    "destination",
    "taxRegistration"
})
public class OwnerType
    extends TaxpayerType
{

    @XmlElement(name = "PhysicalOrigin")
    protected LocationType physicalOrigin;
    @XmlElement(name = "Destination")
    protected LocationType destination;
    @XmlElement(name = "TaxRegistration")
    protected List<TaxRegistrationType> taxRegistration;

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
