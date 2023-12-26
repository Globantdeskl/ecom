
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Indicator whether a tax area has changed.
 * 
 * <p>Java class for IsTaxAreaChangedRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IsTaxAreaChangedRequestType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vertexinc:o-series:tps:9:0}TaxgisRequestType">
 *       &lt;sequence>
 *         &lt;element name="DatePeriod">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{urn:vertexinc:o-series:tps:9:0}DatePeriodType">
 *                 &lt;sequence>
 *                   &lt;element name="BeginDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TaxAreaId" type="{urn:vertexinc:o-series:tps:9:0}TaxAreaIdType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IsTaxAreaChangedRequestType", propOrder = {
    "datePeriod",
    "taxAreaId"
})
public class IsTaxAreaChangedRequestType
    extends TaxgisRequestType
{

    @XmlElement(name = "DatePeriod", required = true)
    protected IsTaxAreaChangedRequestType.DatePeriod datePeriod;
    @XmlElement(name = "TaxAreaId")
    @XmlSchemaType(name = "integer")
    protected int taxAreaId;

    /**
     * Gets the value of the datePeriod property.
     * 
     * @return
     *     possible object is
     *     {@link IsTaxAreaChangedRequestType.DatePeriod }
     *     
     */
    public IsTaxAreaChangedRequestType.DatePeriod getDatePeriod() {
        return datePeriod;
    }

    /**
     * Sets the value of the datePeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link IsTaxAreaChangedRequestType.DatePeriod }
     *     
     */
    public void setDatePeriod(IsTaxAreaChangedRequestType.DatePeriod value) {
        this.datePeriod = value;
    }

    /**
     * Gets the value of the taxAreaId property.
     * 
     */
    public int getTaxAreaId() {
        return taxAreaId;
    }

    /**
     * Sets the value of the taxAreaId property.
     * 
     */
    public void setTaxAreaId(int value) {
        this.taxAreaId = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{urn:vertexinc:o-series:tps:9:0}DatePeriodType">
     *       &lt;sequence>
     *         &lt;element name="BeginDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class DatePeriod
        extends DatePeriodType
    {


    }

}
