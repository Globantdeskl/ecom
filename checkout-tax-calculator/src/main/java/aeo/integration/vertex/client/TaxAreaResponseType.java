
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
 * <p>Java class for TaxAreaResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TaxAreaResponseType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vertexinc:o-series:tps:9:0}TaxgisResponseType">
 *       &lt;sequence>
 *         &lt;element name="TaxAreaResult" type="{urn:vertexinc:o-series:tps:9:0}TaxAreaResultType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxAreaResponseType", propOrder = {
    "taxAreaResult"
})
public class TaxAreaResponseType
    extends TaxgisResponseType
{

    @XmlElement(name = "TaxAreaResult")
    protected List<TaxAreaResultType> taxAreaResult;

    /**
     * Gets the value of the taxAreaResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxAreaResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxAreaResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaxAreaResultType }
     * 
     * 
     */
    public List<TaxAreaResultType> getTaxAreaResult() {
        if (taxAreaResult == null) {
            taxAreaResult = new ArrayList<TaxAreaResultType>();
        }
        return this.taxAreaResult;
    }

}
