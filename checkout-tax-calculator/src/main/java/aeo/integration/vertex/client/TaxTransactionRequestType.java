
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Parent type for all Tax Transaction request messages
 * 
 * <p>Java class for TaxTransactionRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TaxTransactionRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxTransactionRequestType")
@XmlSeeAlso({
    AccrualRequestType.class,
    AssetMovementRequestType.class,
    BuyerInputTaxRequestType.class,
    DistributeTaxProcurementRequestType.class,
    DistributeTaxRequestType.class,
    ERSRequestType.class,
    InventoryRemovalRequestType.class,
    InvoiceRequestType.class,
    InvoiceVerificationRequestType.class,
    PurchaseOrderRequestType.class,
    QuotationRequestType.class
})
public class TaxTransactionRequestType {


}
