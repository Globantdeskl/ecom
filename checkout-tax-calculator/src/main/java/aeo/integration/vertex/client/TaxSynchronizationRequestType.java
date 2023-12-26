
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Parent type for all Tax Synchronization request messages
 * 
 * <p>Java class for TaxSynchronizationRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TaxSynchronizationRequestType">
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
@XmlType(name = "TaxSynchronizationRequestType")
@XmlSeeAlso({
    AccrualSyncRequestType.class,
    APInvoiceSyncRequestType.class,
    ARBillingSyncRequestType.class,
    DeleteRequestType.class,
    ReversalRequestType.class,
    RollbackRequestType.class,
    TransactionExistsRequestType.class
})
public class TaxSynchronizationRequestType {


}
