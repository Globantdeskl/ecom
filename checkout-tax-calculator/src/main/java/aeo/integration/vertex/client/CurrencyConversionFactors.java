
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
 *         &lt;element name="CurrencyConversionFactor" type="{urn:vertexinc:o-series:tps:9:0}CurrencyConversionFactorType" maxOccurs="unbounded"/>
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
    "currencyConversionFactor"
})
@XmlRootElement(name = "CurrencyConversionFactors")
public class CurrencyConversionFactors {

    @XmlElement(name = "CurrencyConversionFactor", required = true)
    protected List<CurrencyConversionFactorType> currencyConversionFactor;

    /**
     * Gets the value of the currencyConversionFactor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the currencyConversionFactor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCurrencyConversionFactor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CurrencyConversionFactorType }
     * 
     * 
     */
    public List<CurrencyConversionFactorType> getCurrencyConversionFactor() {
        if (currencyConversionFactor == null) {
            currencyConversionFactor = new ArrayList<CurrencyConversionFactorType>();
        }
        return this.currencyConversionFactor;
    }

}
