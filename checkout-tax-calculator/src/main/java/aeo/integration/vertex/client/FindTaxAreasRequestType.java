
package aeo.integration.vertex.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FindTaxAreasRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FindTaxAreasRequestType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vertexinc:o-series:tps:9:0}TaxgisRequestType">
 *       &lt;sequence>
 *         &lt;element name="TaxAreaLookup" type="{urn:vertexinc:o-series:tps:9:0}TaxAreaLookupType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FindTaxAreasRequestType", propOrder = {
    "taxAreaLookup"
})
public class FindTaxAreasRequestType
    extends TaxgisRequestType
{

    @XmlElement(name = "TaxAreaLookup", required = true)
    protected List<TaxAreaLookupType> taxAreaLookup;

    /**
     * Gets the value of the taxAreaLookup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxAreaLookup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxAreaLookup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaxAreaLookupType }
     * 
     * 
     */
    public List<TaxAreaLookupType> getTaxAreaLookup() {
        if (taxAreaLookup == null) {
            taxAreaLookup = new ArrayList<TaxAreaLookupType>();
        }
        return this.taxAreaLookup;
    }

}
