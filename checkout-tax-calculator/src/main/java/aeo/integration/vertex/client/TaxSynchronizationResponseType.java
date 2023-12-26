
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Parent type for all Tax Synchronziation response message
 * 
 * <p>Java class for TaxSynchronizationResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TaxSynchronizationResponseType">
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
@XmlType(name = "TaxSynchronizationResponseType")
@XmlSeeAlso({
    AccrualSyncResponseType.class,
    APInvoiceSyncResponseType.class,
    ARBillingSyncResponseType.class,
    DeleteResponseType.class,
    ReversalResponseType.class,
    RollbackResponseType.class,
    TransactionExistsResponseType.class
})
public class TaxSynchronizationResponseType {


}
