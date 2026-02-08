
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Parent type for all Tax Transaction response messges
 * 
 * <p>Java class for TaxTransactionResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TaxTransactionResponseType">
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
@XmlType(name = "TaxTransactionResponseType")
@XmlSeeAlso({
    AccrualResponseType.class,
    AssetMovementResponseType.class,
    BuyerInputTaxResponseType.class,
    DistributeTaxProcurementResponseType.class,
    DistributeTaxResponseType.class,
    ERSResponseType.class,
    InventoryRemovalResponseType.class,
    InvoiceResponseType.class,
    InvoiceVerificationResponseType.class,
    PurchaseOrderResponseType.class,
    QuotationResponseType.class
})
public class TaxTransactionResponseType {


}
