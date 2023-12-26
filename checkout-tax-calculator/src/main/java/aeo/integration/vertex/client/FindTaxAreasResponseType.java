
package aeo.integration.vertex.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Tax Area Response type structure
 * 
 * <p>Java class for FindTaxAreasResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FindTaxAreasResponseType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vertexinc:o-series:tps:9:0}TaxgisResponseType">
 *       &lt;sequence>
 *         &lt;element name="TaxAreaLookupResult" type="{urn:vertexinc:o-series:tps:9:0}TaxAreaLookupResultType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FindTaxAreasResponseType", propOrder = {
    "taxAreaLookupResult"
})
public class FindTaxAreasResponseType
    extends TaxgisResponseType
{

    @XmlElement(name = "TaxAreaLookupResult")
    protected List<TaxAreaLookupResultType> taxAreaLookupResult;

    /**
     * Gets the value of the taxAreaLookupResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxAreaLookupResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxAreaLookupResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaxAreaLookupResultType }
     * 
     * 
     */
    public List<TaxAreaLookupResultType> getTaxAreaLookupResult() {
        if (taxAreaLookupResult == null) {
            taxAreaLookupResult = new ArrayList<TaxAreaLookupResultType>();
        }
        return this.taxAreaLookupResult;
    }

}
