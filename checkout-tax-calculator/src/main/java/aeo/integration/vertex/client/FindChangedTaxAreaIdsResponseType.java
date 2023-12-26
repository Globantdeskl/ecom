
package aeo.integration.vertex.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * List of tax areas changed during an identified period of time.
 * 
 * <p>Java class for FindChangedTaxAreaIdsResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FindChangedTaxAreaIdsResponseType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vertexinc:o-series:tps:9:0}TaxgisResponseType">
 *       &lt;sequence>
 *         &lt;element name="TaxAreaId" type="{urn:vertexinc:o-series:tps:9:0}TaxAreaIdType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FindChangedTaxAreaIdsResponseType", propOrder = {
    "taxAreaId"
})
public class FindChangedTaxAreaIdsResponseType
    extends TaxgisResponseType
{

    @XmlElement(name = "TaxAreaId", type = Integer.class)
    @XmlSchemaType(name = "integer")
    protected List<Integer> taxAreaId;

    /**
     * Gets the value of the taxAreaId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxAreaId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxAreaId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getTaxAreaId() {
        if (taxAreaId == null) {
            taxAreaId = new ArrayList<Integer>();
        }
        return this.taxAreaId;
    }

}
