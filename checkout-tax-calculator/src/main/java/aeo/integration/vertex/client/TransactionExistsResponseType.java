
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Transaction Exists Response message.
 * 
 * <p>Java class for TransactionExistsResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransactionExistsResponseType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vertexinc:o-series:tps:9:0}TaxSynchronizationResponseType">
 *       &lt;attribute name="transactionId" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="40"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="transactionExistsIndicator" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionExistsResponseType")
public class TransactionExistsResponseType
    extends TaxSynchronizationResponseType
{

    @XmlAttribute(name = "transactionId", required = true)
    protected String transactionId;
    @XmlAttribute(name = "transactionExistsIndicator", required = true)
    protected boolean transactionExistsIndicator;

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
     * Gets the value of the transactionExistsIndicator property.
     * 
     */
    public boolean isTransactionExistsIndicator() {
        return transactionExistsIndicator;
    }

    /**
     * Sets the value of the transactionExistsIndicator property.
     * 
     */
    public void setTransactionExistsIndicator(boolean value) {
        this.transactionExistsIndicator = value;
    }

}
