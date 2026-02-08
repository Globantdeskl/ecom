
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Tax Area request type declaration.
 * 
 * <p>Java class for TaxAreaRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TaxAreaRequestType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vertexinc:o-series:tps:9:0}TaxgisRequestType">
 *       &lt;sequence>
 *         &lt;element name="TaxAreaLookup" type="{urn:vertexinc:o-series:tps:9:0}TaxAreaLookupType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxAreaRequestType", propOrder = {
    "taxAreaLookup"
})
public class TaxAreaRequestType
    extends TaxgisRequestType
{

    @XmlElement(name = "TaxAreaLookup")
    protected TaxAreaLookupType taxAreaLookup;

    /**
     * Gets the value of the taxAreaLookup property.
     * 
     * @return
     *     possible object is
     *     {@link TaxAreaLookupType }
     *     
     */
    public TaxAreaLookupType getTaxAreaLookup() {
        return taxAreaLookup;
    }

    /**
     * Sets the value of the taxAreaLookup property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxAreaLookupType }
     *     
     */
    public void setTaxAreaLookup(TaxAreaLookupType value) {
        this.taxAreaLookup = value;
    }

}
