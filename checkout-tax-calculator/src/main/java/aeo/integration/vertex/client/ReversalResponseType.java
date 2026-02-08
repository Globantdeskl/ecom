
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Reversal Response message.
 * 
 * <p>Java class for ReversalResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReversalResponseType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vertexinc:o-series:tps:9:0}TaxSynchronizationResponseType">
 *       &lt;attGroup ref="{urn:vertexinc:o-series:tps:9:0}ReversalTransactionGroup"/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReversalResponseType")
public class ReversalResponseType
    extends TaxSynchronizationResponseType
{

    @XmlAttribute(name = "originalTransactionId", required = true)
    protected String originalTransactionId;
    @XmlAttribute(name = "transactionId")
    protected String transactionId;
    @XmlAttribute(name = "accumulationDocumentNumber")
    protected String accumulationDocumentNumber;
    @XmlAttribute(name = "accumulationCustomerNumber")
    protected String accumulationCustomerNumber;
    @XmlAttribute(name = "postingDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar postingDate;
    @XmlAttribute(name = "documentNumber")
    protected String documentNumber;

    /**
     * Gets the value of the originalTransactionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalTransactionId() {
        return originalTransactionId;
    }

    /**
     * Sets the value of the originalTransactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalTransactionId(String value) {
        this.originalTransactionId = value;
    }

    /**
     * Gets the value of the transactionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the value of the transactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionId(String value) {
        this.transactionId = value;
    }

    /**
     * Gets the value of the accumulationDocumentNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccumulationDocumentNumber() {
        return accumulationDocumentNumber;
    }

    /**
     * Sets the value of the accumulationDocumentNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccumulationDocumentNumber(String value) {
        this.accumulationDocumentNumber = value;
    }

    /**
     * Gets the value of the accumulationCustomerNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccumulationCustomerNumber() {
        return accumulationCustomerNumber;
    }

    /**
     * Sets the value of the accumulationCustomerNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccumulationCustomerNumber(String value) {
        this.accumulationCustomerNumber = value;
    }

    /**
     * Gets the value of the postingDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPostingDate() {
        return postingDate;
    }

    /**
     * Sets the value of the postingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPostingDate(XMLGregorianCalendar value) {
        this.postingDate = value;
    }

    /**
     * Gets the value of the documentNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentNumber() {
        return documentNumber;
    }

    /**
     * Sets the value of the documentNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentNumber(String value) {
        this.documentNumber = value;
    }

}
