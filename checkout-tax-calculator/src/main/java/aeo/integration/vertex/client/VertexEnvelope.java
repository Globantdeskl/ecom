
package aeo.integration.vertex.client;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


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
 *         &lt;element name="Login" type="{urn:vertexinc:o-series:tps:9:0}LoginType"/>
 *         &lt;choice>
 *           &lt;element name="AccrualRequest" type="{urn:vertexinc:o-series:tps:9:0}AccrualRequestType"/>
 *           &lt;element name="AccrualResponse" type="{urn:vertexinc:o-series:tps:9:0}AccrualResponseType"/>
 *           &lt;element name="AccrualSyncRequest" type="{urn:vertexinc:o-series:tps:9:0}AccrualSyncRequestType"/>
 *           &lt;element name="AccrualSyncResponse" type="{urn:vertexinc:o-series:tps:9:0}AccrualSyncResponseType"/>
 *           &lt;element name="APInvoiceSyncRequest" type="{urn:vertexinc:o-series:tps:9:0}APInvoiceSyncRequestType"/>
 *           &lt;element name="APInvoiceSyncResponse" type="{urn:vertexinc:o-series:tps:9:0}APInvoiceSyncResponseType"/>
 *           &lt;element name="ARBillingSyncRequest" type="{urn:vertexinc:o-series:tps:9:0}ARBillingSyncRequestType"/>
 *           &lt;element name="ARBillingSyncResponse" type="{urn:vertexinc:o-series:tps:9:0}ARBillingSyncResponseType"/>
 *           &lt;element name="AssetMovementRequest" type="{urn:vertexinc:o-series:tps:9:0}AssetMovementRequestType"/>
 *           &lt;element name="AssetMovementResponse" type="{urn:vertexinc:o-series:tps:9:0}AssetMovementResponseType"/>
 *           &lt;element name="BuyerInputTaxRequest" type="{urn:vertexinc:o-series:tps:9:0}BuyerInputTaxRequestType"/>
 *           &lt;element name="BuyerInputTaxResponse" type="{urn:vertexinc:o-series:tps:9:0}BuyerInputTaxResponseType"/>
 *           &lt;element name="DeleteRequest" type="{urn:vertexinc:o-series:tps:9:0}DeleteRequestType"/>
 *           &lt;element name="DeleteResponse" type="{urn:vertexinc:o-series:tps:9:0}DeleteResponseType"/>
 *           &lt;element name="DistributeTaxProcurementRequest" type="{urn:vertexinc:o-series:tps:9:0}DistributeTaxProcurementRequestType"/>
 *           &lt;element name="DistributeTaxProcurementResponse" type="{urn:vertexinc:o-series:tps:9:0}DistributeTaxProcurementResponseType"/>
 *           &lt;element name="DistributeTaxRequest" type="{urn:vertexinc:o-series:tps:9:0}DistributeTaxRequestType"/>
 *           &lt;element name="DistributeTaxResponse" type="{urn:vertexinc:o-series:tps:9:0}DistributeTaxResponseType"/>
 *           &lt;element name="ERSRequest" type="{urn:vertexinc:o-series:tps:9:0}ERSRequestType"/>
 *           &lt;element name="ERSResponse" type="{urn:vertexinc:o-series:tps:9:0}ERSResponseType"/>
 *           &lt;element name="InventoryRemovalRequest" type="{urn:vertexinc:o-series:tps:9:0}InventoryRemovalRequestType"/>
 *           &lt;element name="InventoryRemovalResponse" type="{urn:vertexinc:o-series:tps:9:0}InventoryRemovalResponseType"/>
 *           &lt;element name="InvoiceRequest" type="{urn:vertexinc:o-series:tps:9:0}InvoiceRequestType"/>
 *           &lt;element name="InvoiceResponse" type="{urn:vertexinc:o-series:tps:9:0}InvoiceResponseType"/>
 *           &lt;element name="InvoiceVerificationRequest" type="{urn:vertexinc:o-series:tps:9:0}InvoiceVerificationRequestType"/>
 *           &lt;element name="InvoiceVerificationResponse" type="{urn:vertexinc:o-series:tps:9:0}InvoiceVerificationResponseType"/>
 *           &lt;element name="PurchaseOrderRequest" type="{urn:vertexinc:o-series:tps:9:0}PurchaseOrderRequestType"/>
 *           &lt;element name="PurchaseOrderResponse" type="{urn:vertexinc:o-series:tps:9:0}PurchaseOrderResponseType"/>
 *           &lt;element name="QuotationRequest" type="{urn:vertexinc:o-series:tps:9:0}QuotationRequestType"/>
 *           &lt;element name="QuotationResponse" type="{urn:vertexinc:o-series:tps:9:0}QuotationResponseType"/>
 *           &lt;element name="ReversalRequest" type="{urn:vertexinc:o-series:tps:9:0}ReversalRequestType"/>
 *           &lt;element name="ReversalResponse" type="{urn:vertexinc:o-series:tps:9:0}ReversalResponseType"/>
 *           &lt;element name="RollbackRequest" type="{urn:vertexinc:o-series:tps:9:0}RollbackRequestType"/>
 *           &lt;element name="RollbackResponse" type="{urn:vertexinc:o-series:tps:9:0}RollbackResponseType"/>
 *           &lt;element name="TransactionExistsRequest" type="{urn:vertexinc:o-series:tps:9:0}TransactionExistsRequestType"/>
 *           &lt;element name="TransactionExistsResponse" type="{urn:vertexinc:o-series:tps:9:0}TransactionExistsResponseType"/>
 *           &lt;element name="FindChangedTaxAreaIdsRequest" type="{urn:vertexinc:o-series:tps:9:0}FindChangedTaxAreaIdsRequestType"/>
 *           &lt;element name="FindChangedTaxAreaIdsResponse" type="{urn:vertexinc:o-series:tps:9:0}FindChangedTaxAreaIdsResponseType"/>
 *           &lt;element name="IsTaxAreaChangedRequest" type="{urn:vertexinc:o-series:tps:9:0}IsTaxAreaChangedRequestType"/>
 *           &lt;element name="IsTaxAreaChangedResponse" type="{urn:vertexinc:o-series:tps:9:0}IsTaxAreaChangedResponseType"/>
 *           &lt;element name="TaxAreaRequest" type="{urn:vertexinc:o-series:tps:9:0}TaxAreaRequestType"/>
 *           &lt;element name="TaxAreaResponse" type="{urn:vertexinc:o-series:tps:9:0}TaxAreaResponseType"/>
 *           &lt;element name="FindTaxAreasRequest" type="{urn:vertexinc:o-series:tps:9:0}FindTaxAreasRequestType"/>
 *           &lt;element name="FindTaxAreasResponse" type="{urn:vertexinc:o-series:tps:9:0}FindTaxAreasResponseType"/>
 *           &lt;element name="VersionRequest" type="{urn:vertexinc:o-series:tps:9:0}VersionRequestType"/>
 *           &lt;element name="VersionResponse" type="{urn:vertexinc:o-series:tps:9:0}VersionResponseType"/>
 *         &lt;/choice>
 *         &lt;element name="ApplicationData" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Sender" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ApplicationProperty" type="{urn:vertexinc:o-series:tps:9:0}ApplicationPropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="MessageLogging" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="OverrideLoggingThreshold" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;urn:vertexinc:o-series:tps:9:0>LogLevelType">
 *                                     &lt;attribute name="thresholdScope" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="returnLogEntries" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="LogEntry" type="{urn:vertexinc:o-series:tps:9:0}LogEntryType" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="ResponseTimeMS" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "login",
    "accrualRequest",
    "accrualResponse",
    "accrualSyncRequest",
    "accrualSyncResponse",
    "apInvoiceSyncRequest",
    "apInvoiceSyncResponse",
    "arBillingSyncRequest",
    "arBillingSyncResponse",
    "assetMovementRequest",
    "assetMovementResponse",
    "buyerInputTaxRequest",
    "buyerInputTaxResponse",
    "deleteRequest",
    "deleteResponse",
    "distributeTaxProcurementRequest",
    "distributeTaxProcurementResponse",
    "distributeTaxRequest",
    "distributeTaxResponse",
    "ersRequest",
    "ersResponse",
    "inventoryRemovalRequest",
    "inventoryRemovalResponse",
    "invoiceRequest",
    "invoiceResponse",
    "invoiceVerificationRequest",
    "invoiceVerificationResponse",
    "purchaseOrderRequest",
    "purchaseOrderResponse",
    "quotationRequest",
    "quotationResponse",
    "reversalRequest",
    "reversalResponse",
    "rollbackRequest",
    "rollbackResponse",
    "transactionExistsRequest",
    "transactionExistsResponse",
    "findChangedTaxAreaIdsRequest",
    "findChangedTaxAreaIdsResponse",
    "isTaxAreaChangedRequest",
    "isTaxAreaChangedResponse",
    "taxAreaRequest",
    "taxAreaResponse",
    "findTaxAreasRequest",
    "findTaxAreasResponse",
    "versionRequest",
    "versionResponse",
    "applicationData"
})
@XmlRootElement(name = "VertexEnvelope")
public class VertexEnvelope {

    @XmlElement(name = "Login", required = true)
    protected LoginType login;
    @XmlElement(name = "AccrualRequest")
    protected AccrualRequestType accrualRequest;
    @XmlElement(name = "AccrualResponse")
    protected AccrualResponseType accrualResponse;
    @XmlElement(name = "AccrualSyncRequest")
    protected AccrualSyncRequestType accrualSyncRequest;
    @XmlElement(name = "AccrualSyncResponse")
    protected AccrualSyncResponseType accrualSyncResponse;
    @XmlElement(name = "APInvoiceSyncRequest")
    protected APInvoiceSyncRequestType apInvoiceSyncRequest;
    @XmlElement(name = "APInvoiceSyncResponse")
    protected APInvoiceSyncResponseType apInvoiceSyncResponse;
    @XmlElement(name = "ARBillingSyncRequest")
    protected ARBillingSyncRequestType arBillingSyncRequest;
    @XmlElement(name = "ARBillingSyncResponse")
    protected ARBillingSyncResponseType arBillingSyncResponse;
    @XmlElement(name = "AssetMovementRequest")
    protected AssetMovementRequestType assetMovementRequest;
    @XmlElement(name = "AssetMovementResponse")
    protected AssetMovementResponseType assetMovementResponse;
    @XmlElement(name = "BuyerInputTaxRequest")
    protected BuyerInputTaxRequestType buyerInputTaxRequest;
    @XmlElement(name = "BuyerInputTaxResponse")
    protected BuyerInputTaxResponseType buyerInputTaxResponse;
    @XmlElement(name = "DeleteRequest")
    protected DeleteRequestType deleteRequest;
    @XmlElement(name = "DeleteResponse")
    protected DeleteResponseType deleteResponse;
    @XmlElement(name = "DistributeTaxProcurementRequest")
    protected DistributeTaxProcurementRequestType distributeTaxProcurementRequest;
    @XmlElement(name = "DistributeTaxProcurementResponse")
    protected DistributeTaxProcurementResponseType distributeTaxProcurementResponse;
    @XmlElement(name = "DistributeTaxRequest")
    protected DistributeTaxRequestType distributeTaxRequest;
    @XmlElement(name = "DistributeTaxResponse")
    protected DistributeTaxResponseType distributeTaxResponse;
    @XmlElement(name = "ERSRequest")
    protected ERSRequestType ersRequest;
    @XmlElement(name = "ERSResponse")
    protected ERSResponseType ersResponse;
    @XmlElement(name = "InventoryRemovalRequest")
    protected InventoryRemovalRequestType inventoryRemovalRequest;
    @XmlElement(name = "InventoryRemovalResponse")
    protected InventoryRemovalResponseType inventoryRemovalResponse;
    @XmlElement(name = "InvoiceRequest")
    protected InvoiceRequestType invoiceRequest;
    @XmlElement(name = "InvoiceResponse")
    protected InvoiceResponseType invoiceResponse;
    @XmlElement(name = "InvoiceVerificationRequest")
    protected InvoiceVerificationRequestType invoiceVerificationRequest;
    @XmlElement(name = "InvoiceVerificationResponse")
    protected InvoiceVerificationResponseType invoiceVerificationResponse;
    @XmlElement(name = "PurchaseOrderRequest")
    protected PurchaseOrderRequestType purchaseOrderRequest;
    @XmlElement(name = "PurchaseOrderResponse")
    protected PurchaseOrderResponseType purchaseOrderResponse;
    @XmlElement(name = "QuotationRequest")
    protected QuotationRequestType quotationRequest;
    @XmlElement(name = "QuotationResponse")
    protected QuotationResponseType quotationResponse;
    @XmlElement(name = "ReversalRequest")
    protected ReversalRequestType reversalRequest;
    @XmlElement(name = "ReversalResponse")
    protected ReversalResponseType reversalResponse;
    @XmlElement(name = "RollbackRequest")
    protected RollbackRequestType rollbackRequest;
    @XmlElement(name = "RollbackResponse")
    protected RollbackResponseType rollbackResponse;
    @XmlElement(name = "TransactionExistsRequest")
    protected TransactionExistsRequestType transactionExistsRequest;
    @XmlElement(name = "TransactionExistsResponse")
    protected TransactionExistsResponseType transactionExistsResponse;
    @XmlElement(name = "FindChangedTaxAreaIdsRequest")
    protected FindChangedTaxAreaIdsRequestType findChangedTaxAreaIdsRequest;
    @XmlElement(name = "FindChangedTaxAreaIdsResponse")
    protected FindChangedTaxAreaIdsResponseType findChangedTaxAreaIdsResponse;
    @XmlElement(name = "IsTaxAreaChangedRequest")
    protected IsTaxAreaChangedRequestType isTaxAreaChangedRequest;
    @XmlElement(name = "IsTaxAreaChangedResponse")
    protected IsTaxAreaChangedResponseType isTaxAreaChangedResponse;
    @XmlElement(name = "TaxAreaRequest")
    protected TaxAreaRequestType taxAreaRequest;
    @XmlElement(name = "TaxAreaResponse")
    protected TaxAreaResponseType taxAreaResponse;
    @XmlElement(name = "FindTaxAreasRequest")
    protected FindTaxAreasRequestType findTaxAreasRequest;
    @XmlElement(name = "FindTaxAreasResponse")
    protected FindTaxAreasResponseType findTaxAreasResponse;
    @XmlElement(name = "VersionRequest")
    protected VersionRequestType versionRequest;
    @XmlElement(name = "VersionResponse")
    protected VersionResponseType versionResponse;
    @XmlElement(name = "ApplicationData")
    protected VertexEnvelope.ApplicationData applicationData;

    /**
     * Gets the value of the login property.
     * 
     * @return
     *     possible object is
     *     {@link LoginType }
     *     
     */
    public LoginType getLogin() {
        return login;
    }

    /**
     * Sets the value of the login property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoginType }
     *     
     */
    public void setLogin(LoginType value) {
        this.login = value;
    }

    /**
     * Gets the value of the accrualRequest property.
     * 
     * @return
     *     possible object is
     *     {@link AccrualRequestType }
     *     
     */
    public AccrualRequestType getAccrualRequest() {
        return accrualRequest;
    }

    /**
     * Sets the value of the accrualRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccrualRequestType }
     *     
     */
    public void setAccrualRequest(AccrualRequestType value) {
        this.accrualRequest = value;
    }

    /**
     * Gets the value of the accrualResponse property.
     * 
     * @return
     *     possible object is
     *     {@link AccrualResponseType }
     *     
     */
    public AccrualResponseType getAccrualResponse() {
        return accrualResponse;
    }

    /**
     * Sets the value of the accrualResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccrualResponseType }
     *     
     */
    public void setAccrualResponse(AccrualResponseType value) {
        this.accrualResponse = value;
    }

    /**
     * Gets the value of the accrualSyncRequest property.
     * 
     * @return
     *     possible object is
     *     {@link AccrualSyncRequestType }
     *     
     */
    public AccrualSyncRequestType getAccrualSyncRequest() {
        return accrualSyncRequest;
    }

    /**
     * Sets the value of the accrualSyncRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccrualSyncRequestType }
     *     
     */
    public void setAccrualSyncRequest(AccrualSyncRequestType value) {
        this.accrualSyncRequest = value;
    }

    /**
     * Gets the value of the accrualSyncResponse property.
     * 
     * @return
     *     possible object is
     *     {@link AccrualSyncResponseType }
     *     
     */
    public AccrualSyncResponseType getAccrualSyncResponse() {
        return accrualSyncResponse;
    }

    /**
     * Sets the value of the accrualSyncResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccrualSyncResponseType }
     *     
     */
    public void setAccrualSyncResponse(AccrualSyncResponseType value) {
        this.accrualSyncResponse = value;
    }

    /**
     * Gets the value of the apInvoiceSyncRequest property.
     * 
     * @return
     *     possible object is
     *     {@link APInvoiceSyncRequestType }
     *     
     */
    public APInvoiceSyncRequestType getAPInvoiceSyncRequest() {
        return apInvoiceSyncRequest;
    }

    /**
     * Sets the value of the apInvoiceSyncRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link APInvoiceSyncRequestType }
     *     
     */
    public void setAPInvoiceSyncRequest(APInvoiceSyncRequestType value) {
        this.apInvoiceSyncRequest = value;
    }

    /**
     * Gets the value of the apInvoiceSyncResponse property.
     * 
     * @return
     *     possible object is
     *     {@link APInvoiceSyncResponseType }
     *     
     */
    public APInvoiceSyncResponseType getAPInvoiceSyncResponse() {
        return apInvoiceSyncResponse;
    }

    /**
     * Sets the value of the apInvoiceSyncResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link APInvoiceSyncResponseType }
     *     
     */
    public void setAPInvoiceSyncResponse(APInvoiceSyncResponseType value) {
        this.apInvoiceSyncResponse = value;
    }

    /**
     * Gets the value of the arBillingSyncRequest property.
     * 
     * @return
     *     possible object is
     *     {@link ARBillingSyncRequestType }
     *     
     */
    public ARBillingSyncRequestType getARBillingSyncRequest() {
        return arBillingSyncRequest;
    }

    /**
     * Sets the value of the arBillingSyncRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link ARBillingSyncRequestType }
     *     
     */
    public void setARBillingSyncRequest(ARBillingSyncRequestType value) {
        this.arBillingSyncRequest = value;
    }

    /**
     * Gets the value of the arBillingSyncResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ARBillingSyncResponseType }
     *     
     */
    public ARBillingSyncResponseType getARBillingSyncResponse() {
        return arBillingSyncResponse;
    }

    /**
     * Sets the value of the arBillingSyncResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ARBillingSyncResponseType }
     *     
     */
    public void setARBillingSyncResponse(ARBillingSyncResponseType value) {
        this.arBillingSyncResponse = value;
    }

    /**
     * Gets the value of the assetMovementRequest property.
     * 
     * @return
     *     possible object is
     *     {@link AssetMovementRequestType }
     *     
     */
    public AssetMovementRequestType getAssetMovementRequest() {
        return assetMovementRequest;
    }

    /**
     * Sets the value of the assetMovementRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssetMovementRequestType }
     *     
     */
    public void setAssetMovementRequest(AssetMovementRequestType value) {
        this.assetMovementRequest = value;
    }

    /**
     * Gets the value of the assetMovementResponse property.
     * 
     * @return
     *     possible object is
     *     {@link AssetMovementResponseType }
     *     
     */
    public AssetMovementResponseType getAssetMovementResponse() {
        return assetMovementResponse;
    }

    /**
     * Sets the value of the assetMovementResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssetMovementResponseType }
     *     
     */
    public void setAssetMovementResponse(AssetMovementResponseType value) {
        this.assetMovementResponse = value;
    }

    /**
     * Gets the value of the buyerInputTaxRequest property.
     * 
     * @return
     *     possible object is
     *     {@link BuyerInputTaxRequestType }
     *     
     */
    public BuyerInputTaxRequestType getBuyerInputTaxRequest() {
        return buyerInputTaxRequest;
    }

    /**
     * Sets the value of the buyerInputTaxRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link BuyerInputTaxRequestType }
     *     
     */
    public void setBuyerInputTaxRequest(BuyerInputTaxRequestType value) {
        this.buyerInputTaxRequest = value;
    }

    /**
     * Gets the value of the buyerInputTaxResponse property.
     * 
     * @return
     *     possible object is
     *     {@link BuyerInputTaxResponseType }
     *     
     */
    public BuyerInputTaxResponseType getBuyerInputTaxResponse() {
        return buyerInputTaxResponse;
    }

    /**
     * Sets the value of the buyerInputTaxResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link BuyerInputTaxResponseType }
     *     
     */
    public void setBuyerInputTaxResponse(BuyerInputTaxResponseType value) {
        this.buyerInputTaxResponse = value;
    }

    /**
     * Gets the value of the deleteRequest property.
     * 
     * @return
     *     possible object is
     *     {@link DeleteRequestType }
     *     
     */
    public DeleteRequestType getDeleteRequest() {
        return deleteRequest;
    }

    /**
     * Sets the value of the deleteRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeleteRequestType }
     *     
     */
    public void setDeleteRequest(DeleteRequestType value) {
        this.deleteRequest = value;
    }

    /**
     * Gets the value of the deleteResponse property.
     * 
     * @return
     *     possible object is
     *     {@link DeleteResponseType }
     *     
     */
    public DeleteResponseType getDeleteResponse() {
        return deleteResponse;
    }

    /**
     * Sets the value of the deleteResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeleteResponseType }
     *     
     */
    public void setDeleteResponse(DeleteResponseType value) {
        this.deleteResponse = value;
    }

    /**
     * Gets the value of the distributeTaxProcurementRequest property.
     * 
     * @return
     *     possible object is
     *     {@link DistributeTaxProcurementRequestType }
     *     
     */
    public DistributeTaxProcurementRequestType getDistributeTaxProcurementRequest() {
        return distributeTaxProcurementRequest;
    }

    /**
     * Sets the value of the distributeTaxProcurementRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistributeTaxProcurementRequestType }
     *     
     */
    public void setDistributeTaxProcurementRequest(DistributeTaxProcurementRequestType value) {
        this.distributeTaxProcurementRequest = value;
    }

    /**
     * Gets the value of the distributeTaxProcurementResponse property.
     * 
     * @return
     *     possible object is
     *     {@link DistributeTaxProcurementResponseType }
     *     
     */
    public DistributeTaxProcurementResponseType getDistributeTaxProcurementResponse() {
        return distributeTaxProcurementResponse;
    }

    /**
     * Sets the value of the distributeTaxProcurementResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistributeTaxProcurementResponseType }
     *     
     */
    public void setDistributeTaxProcurementResponse(DistributeTaxProcurementResponseType value) {
        this.distributeTaxProcurementResponse = value;
    }

    /**
     * Gets the value of the distributeTaxRequest property.
     * 
     * @return
     *     possible object is
     *     {@link DistributeTaxRequestType }
     *     
     */
    public DistributeTaxRequestType getDistributeTaxRequest() {
        return distributeTaxRequest;
    }

    /**
     * Sets the value of the distributeTaxRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistributeTaxRequestType }
     *     
     */
    public void setDistributeTaxRequest(DistributeTaxRequestType value) {
        this.distributeTaxRequest = value;
    }

    /**
     * Gets the value of the distributeTaxResponse property.
     * 
     * @return
     *     possible object is
     *     {@link DistributeTaxResponseType }
     *     
     */
    public DistributeTaxResponseType getDistributeTaxResponse() {
        return distributeTaxResponse;
    }

    /**
     * Sets the value of the distributeTaxResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistributeTaxResponseType }
     *     
     */
    public void setDistributeTaxResponse(DistributeTaxResponseType value) {
        this.distributeTaxResponse = value;
    }

    /**
     * Gets the value of the ersRequest property.
     * 
     * @return
     *     possible object is
     *     {@link ERSRequestType }
     *     
     */
    public ERSRequestType getERSRequest() {
        return ersRequest;
    }

    /**
     * Sets the value of the ersRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link ERSRequestType }
     *     
     */
    public void setERSRequest(ERSRequestType value) {
        this.ersRequest = value;
    }

    /**
     * Gets the value of the ersResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ERSResponseType }
     *     
     */
    public ERSResponseType getERSResponse() {
        return ersResponse;
    }

    /**
     * Sets the value of the ersResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ERSResponseType }
     *     
     */
    public void setERSResponse(ERSResponseType value) {
        this.ersResponse = value;
    }

    /**
     * Gets the value of the inventoryRemovalRequest property.
     * 
     * @return
     *     possible object is
     *     {@link InventoryRemovalRequestType }
     *     
     */
    public InventoryRemovalRequestType getInventoryRemovalRequest() {
        return inventoryRemovalRequest;
    }

    /**
     * Sets the value of the inventoryRemovalRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link InventoryRemovalRequestType }
     *     
     */
    public void setInventoryRemovalRequest(InventoryRemovalRequestType value) {
        this.inventoryRemovalRequest = value;
    }

    /**
     * Gets the value of the inventoryRemovalResponse property.
     * 
     * @return
     *     possible object is
     *     {@link InventoryRemovalResponseType }
     *     
     */
    public InventoryRemovalResponseType getInventoryRemovalResponse() {
        return inventoryRemovalResponse;
    }

    /**
     * Sets the value of the inventoryRemovalResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link InventoryRemovalResponseType }
     *     
     */
    public void setInventoryRemovalResponse(InventoryRemovalResponseType value) {
        this.inventoryRemovalResponse = value;
    }

    /**
     * Gets the value of the invoiceRequest property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceRequestType }
     *     
     */
    public InvoiceRequestType getInvoiceRequest() {
        return invoiceRequest;
    }

    /**
     * Sets the value of the invoiceRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceRequestType }
     *     
     */
    public void setInvoiceRequest(InvoiceRequestType value) {
        this.invoiceRequest = value;
    }

    /**
     * Gets the value of the invoiceResponse property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceResponseType }
     *     
     */
    public InvoiceResponseType getInvoiceResponse() {
        return invoiceResponse;
    }

    /**
     * Sets the value of the invoiceResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceResponseType }
     *     
     */
    public void setInvoiceResponse(InvoiceResponseType value) {
        this.invoiceResponse = value;
    }

    /**
     * Gets the value of the invoiceVerificationRequest property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceVerificationRequestType }
     *     
     */
    public InvoiceVerificationRequestType getInvoiceVerificationRequest() {
        return invoiceVerificationRequest;
    }

    /**
     * Sets the value of the invoiceVerificationRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceVerificationRequestType }
     *     
     */
    public void setInvoiceVerificationRequest(InvoiceVerificationRequestType value) {
        this.invoiceVerificationRequest = value;
    }

    /**
     * Gets the value of the invoiceVerificationResponse property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceVerificationResponseType }
     *     
     */
    public InvoiceVerificationResponseType getInvoiceVerificationResponse() {
        return invoiceVerificationResponse;
    }

    /**
     * Sets the value of the invoiceVerificationResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceVerificationResponseType }
     *     
     */
    public void setInvoiceVerificationResponse(InvoiceVerificationResponseType value) {
        this.invoiceVerificationResponse = value;
    }

    /**
     * Gets the value of the purchaseOrderRequest property.
     * 
     * @return
     *     possible object is
     *     {@link PurchaseOrderRequestType }
     *     
     */
    public PurchaseOrderRequestType getPurchaseOrderRequest() {
        return purchaseOrderRequest;
    }

    /**
     * Sets the value of the purchaseOrderRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link PurchaseOrderRequestType }
     *     
     */
    public void setPurchaseOrderRequest(PurchaseOrderRequestType value) {
        this.purchaseOrderRequest = value;
    }

    /**
     * Gets the value of the purchaseOrderResponse property.
     * 
     * @return
     *     possible object is
     *     {@link PurchaseOrderResponseType }
     *     
     */
    public PurchaseOrderResponseType getPurchaseOrderResponse() {
        return purchaseOrderResponse;
    }

    /**
     * Sets the value of the purchaseOrderResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link PurchaseOrderResponseType }
     *     
     */
    public void setPurchaseOrderResponse(PurchaseOrderResponseType value) {
        this.purchaseOrderResponse = value;
    }

    /**
     * Gets the value of the quotationRequest property.
     * 
     * @return
     *     possible object is
     *     {@link QuotationRequestType }
     *     
     */
    public QuotationRequestType getQuotationRequest() {
        return quotationRequest;
    }

    /**
     * Sets the value of the quotationRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link QuotationRequestType }
     *     
     */
    public void setQuotationRequest(QuotationRequestType value) {
        this.quotationRequest = value;
    }

    /**
     * Gets the value of the quotationResponse property.
     * 
     * @return
     *     possible object is
     *     {@link QuotationResponseType }
     *     
     */
    public QuotationResponseType getQuotationResponse() {
        return quotationResponse;
    }

    /**
     * Sets the value of the quotationResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link QuotationResponseType }
     *     
     */
    public void setQuotationResponse(QuotationResponseType value) {
        this.quotationResponse = value;
    }

    /**
     * Gets the value of the reversalRequest property.
     * 
     * @return
     *     possible object is
     *     {@link ReversalRequestType }
     *     
     */
    public ReversalRequestType getReversalRequest() {
        return reversalRequest;
    }

    /**
     * Sets the value of the reversalRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReversalRequestType }
     *     
     */
    public void setReversalRequest(ReversalRequestType value) {
        this.reversalRequest = value;
    }

    /**
     * Gets the value of the reversalResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ReversalResponseType }
     *     
     */
    public ReversalResponseType getReversalResponse() {
        return reversalResponse;
    }

    /**
     * Sets the value of the reversalResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReversalResponseType }
     *     
     */
    public void setReversalResponse(ReversalResponseType value) {
        this.reversalResponse = value;
    }

    /**
     * Gets the value of the rollbackRequest property.
     * 
     * @return
     *     possible object is
     *     {@link RollbackRequestType }
     *     
     */
    public RollbackRequestType getRollbackRequest() {
        return rollbackRequest;
    }

    /**
     * Sets the value of the rollbackRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link RollbackRequestType }
     *     
     */
    public void setRollbackRequest(RollbackRequestType value) {
        this.rollbackRequest = value;
    }

    /**
     * Gets the value of the rollbackResponse property.
     * 
     * @return
     *     possible object is
     *     {@link RollbackResponseType }
     *     
     */
    public RollbackResponseType getRollbackResponse() {
        return rollbackResponse;
    }

    /**
     * Sets the value of the rollbackResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link RollbackResponseType }
     *     
     */
    public void setRollbackResponse(RollbackResponseType value) {
        this.rollbackResponse = value;
    }

    /**
     * Gets the value of the transactionExistsRequest property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionExistsRequestType }
     *     
     */
    public TransactionExistsRequestType getTransactionExistsRequest() {
        return transactionExistsRequest;
    }

    /**
     * Sets the value of the transactionExistsRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionExistsRequestType }
     *     
     */
    public void setTransactionExistsRequest(TransactionExistsRequestType value) {
        this.transactionExistsRequest = value;
    }

    /**
     * Gets the value of the transactionExistsResponse property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionExistsResponseType }
     *     
     */
    public TransactionExistsResponseType getTransactionExistsResponse() {
        return transactionExistsResponse;
    }

    /**
     * Sets the value of the transactionExistsResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionExistsResponseType }
     *     
     */
    public void setTransactionExistsResponse(TransactionExistsResponseType value) {
        this.transactionExistsResponse = value;
    }

    /**
     * Gets the value of the findChangedTaxAreaIdsRequest property.
     * 
     * @return
     *     possible object is
     *     {@link FindChangedTaxAreaIdsRequestType }
     *     
     */
    public FindChangedTaxAreaIdsRequestType getFindChangedTaxAreaIdsRequest() {
        return findChangedTaxAreaIdsRequest;
    }

    /**
     * Sets the value of the findChangedTaxAreaIdsRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link FindChangedTaxAreaIdsRequestType }
     *     
     */
    public void setFindChangedTaxAreaIdsRequest(FindChangedTaxAreaIdsRequestType value) {
        this.findChangedTaxAreaIdsRequest = value;
    }

    /**
     * Gets the value of the findChangedTaxAreaIdsResponse property.
     * 
     * @return
     *     possible object is
     *     {@link FindChangedTaxAreaIdsResponseType }
     *     
     */
    public FindChangedTaxAreaIdsResponseType getFindChangedTaxAreaIdsResponse() {
        return findChangedTaxAreaIdsResponse;
    }

    /**
     * Sets the value of the findChangedTaxAreaIdsResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link FindChangedTaxAreaIdsResponseType }
     *     
     */
    public void setFindChangedTaxAreaIdsResponse(FindChangedTaxAreaIdsResponseType value) {
        this.findChangedTaxAreaIdsResponse = value;
    }

    /**
     * Gets the value of the isTaxAreaChangedRequest property.
     * 
     * @return
     *     possible object is
     *     {@link IsTaxAreaChangedRequestType }
     *     
     */
    public IsTaxAreaChangedRequestType getIsTaxAreaChangedRequest() {
        return isTaxAreaChangedRequest;
    }

    /**
     * Sets the value of the isTaxAreaChangedRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link IsTaxAreaChangedRequestType }
     *     
     */
    public void setIsTaxAreaChangedRequest(IsTaxAreaChangedRequestType value) {
        this.isTaxAreaChangedRequest = value;
    }

    /**
     * Gets the value of the isTaxAreaChangedResponse property.
     * 
     * @return
     *     possible object is
     *     {@link IsTaxAreaChangedResponseType }
     *     
     */
    public IsTaxAreaChangedResponseType getIsTaxAreaChangedResponse() {
        return isTaxAreaChangedResponse;
    }

    /**
     * Sets the value of the isTaxAreaChangedResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link IsTaxAreaChangedResponseType }
     *     
     */
    public void setIsTaxAreaChangedResponse(IsTaxAreaChangedResponseType value) {
        this.isTaxAreaChangedResponse = value;
    }

    /**
     * Gets the value of the taxAreaRequest property.
     * 
     * @return
     *     possible object is
     *     {@link TaxAreaRequestType }
     *     
     */
    public TaxAreaRequestType getTaxAreaRequest() {
        return taxAreaRequest;
    }

    /**
     * Sets the value of the taxAreaRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxAreaRequestType }
     *     
     */
    public void setTaxAreaRequest(TaxAreaRequestType value) {
        this.taxAreaRequest = value;
    }

    /**
     * Gets the value of the taxAreaResponse property.
     * 
     * @return
     *     possible object is
     *     {@link TaxAreaResponseType }
     *     
     */
    public TaxAreaResponseType getTaxAreaResponse() {
        return taxAreaResponse;
    }

    /**
     * Sets the value of the taxAreaResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxAreaResponseType }
     *     
     */
    public void setTaxAreaResponse(TaxAreaResponseType value) {
        this.taxAreaResponse = value;
    }

    /**
     * Gets the value of the findTaxAreasRequest property.
     * 
     * @return
     *     possible object is
     *     {@link FindTaxAreasRequestType }
     *     
     */
    public FindTaxAreasRequestType getFindTaxAreasRequest() {
        return findTaxAreasRequest;
    }

    /**
     * Sets the value of the findTaxAreasRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link FindTaxAreasRequestType }
     *     
     */
    public void setFindTaxAreasRequest(FindTaxAreasRequestType value) {
        this.findTaxAreasRequest = value;
    }

    /**
     * Gets the value of the findTaxAreasResponse property.
     * 
     * @return
     *     possible object is
     *     {@link FindTaxAreasResponseType }
     *     
     */
    public FindTaxAreasResponseType getFindTaxAreasResponse() {
        return findTaxAreasResponse;
    }

    /**
     * Sets the value of the findTaxAreasResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link FindTaxAreasResponseType }
     *     
     */
    public void setFindTaxAreasResponse(FindTaxAreasResponseType value) {
        this.findTaxAreasResponse = value;
    }

    /**
     * Gets the value of the versionRequest property.
     * 
     * @return
     *     possible object is
     *     {@link VersionRequestType }
     *     
     */
    public VersionRequestType getVersionRequest() {
        return versionRequest;
    }

    /**
     * Sets the value of the versionRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionRequestType }
     *     
     */
    public void setVersionRequest(VersionRequestType value) {
        this.versionRequest = value;
    }

    /**
     * Gets the value of the versionResponse property.
     * 
     * @return
     *     possible object is
     *     {@link VersionResponseType }
     *     
     */
    public VersionResponseType getVersionResponse() {
        return versionResponse;
    }

    /**
     * Sets the value of the versionResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionResponseType }
     *     
     */
    public void setVersionResponse(VersionResponseType value) {
        this.versionResponse = value;
    }

    /**
     * Gets the value of the applicationData property.
     * 
     * @return
     *     possible object is
     *     {@link VertexEnvelope.ApplicationData }
     *     
     */
    public VertexEnvelope.ApplicationData getApplicationData() {
        return applicationData;
    }

    /**
     * Sets the value of the applicationData property.
     * 
     * @param value
     *     allowed object is
     *     {@link VertexEnvelope.ApplicationData }
     *     
     */
    public void setApplicationData(VertexEnvelope.ApplicationData value) {
        this.applicationData = value;
    }


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
     *         &lt;element name="Sender" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ApplicationProperty" type="{urn:vertexinc:o-series:tps:9:0}ApplicationPropertyType" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="MessageLogging" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="OverrideLoggingThreshold" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;urn:vertexinc:o-series:tps:9:0>LogLevelType">
     *                           &lt;attribute name="thresholdScope" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="returnLogEntries" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="LogEntry" type="{urn:vertexinc:o-series:tps:9:0}LogEntryType" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="ResponseTimeMS" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
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
        "sender",
        "applicationProperty",
        "messageLogging",
        "logEntry",
        "responseTimeMS"
    })
    public static class ApplicationData {

        @XmlElement(name = "Sender")
        protected String sender;
        @XmlElement(name = "ApplicationProperty")
        protected List<ApplicationPropertyType> applicationProperty;
        @XmlElement(name = "MessageLogging")
        protected VertexEnvelope.ApplicationData.MessageLogging messageLogging;
        @XmlElement(name = "LogEntry")
        protected List<LogEntryType> logEntry;
        @XmlElement(name = "ResponseTimeMS")
        protected BigDecimal responseTimeMS;

        /**
         * Gets the value of the sender property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSender() {
            return sender;
        }

        /**
         * Sets the value of the sender property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSender(String value) {
            this.sender = value;
        }

        /**
         * Gets the value of the applicationProperty property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the applicationProperty property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getApplicationProperty().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ApplicationPropertyType }
         * 
         * 
         */
        public List<ApplicationPropertyType> getApplicationProperty() {
            if (applicationProperty == null) {
                applicationProperty = new ArrayList<ApplicationPropertyType>();
            }
            return this.applicationProperty;
        }

        /**
         * Gets the value of the messageLogging property.
         * 
         * @return
         *     possible object is
         *     {@link VertexEnvelope.ApplicationData.MessageLogging }
         *     
         */
        public VertexEnvelope.ApplicationData.MessageLogging getMessageLogging() {
            return messageLogging;
        }

        /**
         * Sets the value of the messageLogging property.
         * 
         * @param value
         *     allowed object is
         *     {@link VertexEnvelope.ApplicationData.MessageLogging }
         *     
         */
        public void setMessageLogging(VertexEnvelope.ApplicationData.MessageLogging value) {
            this.messageLogging = value;
        }

        /**
         * Gets the value of the logEntry property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the logEntry property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLogEntry().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link LogEntryType }
         * 
         * 
         */
        public List<LogEntryType> getLogEntry() {
            if (logEntry == null) {
                logEntry = new ArrayList<LogEntryType>();
            }
            return this.logEntry;
        }

        /**
         * Gets the value of the responseTimeMS property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getResponseTimeMS() {
            return responseTimeMS;
        }

        /**
         * Sets the value of the responseTimeMS property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setResponseTimeMS(BigDecimal value) {
            this.responseTimeMS = value;
        }


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
         *         &lt;element name="OverrideLoggingThreshold" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;urn:vertexinc:o-series:tps:9:0>LogLevelType">
         *                 &lt;attribute name="thresholdScope" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="returnLogEntries" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "overrideLoggingThreshold"
        })
        public static class MessageLogging {

            @XmlElement(name = "OverrideLoggingThreshold")
            protected List<VertexEnvelope.ApplicationData.MessageLogging.OverrideLoggingThreshold> overrideLoggingThreshold;
            @XmlAttribute(name = "returnLogEntries")
            protected Boolean returnLogEntries;

            /**
             * Gets the value of the overrideLoggingThreshold property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the overrideLoggingThreshold property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getOverrideLoggingThreshold().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link VertexEnvelope.ApplicationData.MessageLogging.OverrideLoggingThreshold }
             * 
             * 
             */
            public List<VertexEnvelope.ApplicationData.MessageLogging.OverrideLoggingThreshold> getOverrideLoggingThreshold() {
                if (overrideLoggingThreshold == null) {
                    overrideLoggingThreshold = new ArrayList<VertexEnvelope.ApplicationData.MessageLogging.OverrideLoggingThreshold>();
                }
                return this.overrideLoggingThreshold;
            }

            /**
             * Gets the value of the returnLogEntries property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isReturnLogEntries() {
                return returnLogEntries;
            }

            /**
             * Sets the value of the returnLogEntries property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setReturnLogEntries(Boolean value) {
                this.returnLogEntries = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;urn:vertexinc:o-series:tps:9:0>LogLevelType">
             *       &lt;attribute name="thresholdScope" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class OverrideLoggingThreshold {

                @XmlValue
                protected LogLevelType value;
                @XmlAttribute(name = "thresholdScope")
                protected String thresholdScope;

                /**
                 * Log levels indicate the severity of an error. The following log levels are listed from most severe to least severe.
                 * 
                 * @return
                 *     possible object is
                 *     {@link LogLevelType }
                 *     
                 */
                public LogLevelType getValue() {
                    return value;
                }

                /**
                 * Sets the value of the value property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link LogLevelType }
                 *     
                 */
                public void setValue(LogLevelType value) {
                    this.value = value;
                }

                /**
                 * Gets the value of the thresholdScope property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getThresholdScope() {
                    return thresholdScope;
                }

                /**
                 * Sets the value of the thresholdScope property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setThresholdScope(String value) {
                    this.thresholdScope = value;
                }

            }

        }

    }

}
