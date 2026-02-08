
package aeo.integration.vertex.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}DispatcherCode"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}TaxRegistration" maxOccurs="unbounded" minOccurs="0"/>
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
    "dispatcherCode",
    "taxRegistration"
})
@XmlRootElement(name = "Dispatcher")
public class Dispatcher {

    @XmlElement(name = "DispatcherCode", required = true)
    protected DispatcherCode dispatcherCode;
    @XmlElement(name = "TaxRegistration")
    protected List<TaxRegistrationType> taxRegistration;

    /**
     * Gets the value of the dispatcherCode property.
     * 
     * @return
     *     possible object is
     *     {@link DispatcherCode }
     *     
     */
    public DispatcherCode getDispatcherCode() {
        return dispatcherCode;
    }

    /**
     * Sets the value of the dispatcherCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link DispatcherCode }
     *     
     */
    public void setDispatcherCode(DispatcherCode value) {
        this.dispatcherCode = value;
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
