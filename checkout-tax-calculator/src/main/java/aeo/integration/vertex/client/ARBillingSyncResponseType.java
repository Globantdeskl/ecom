
package aeo.integration.vertex.client;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Account Receivable Billing Synchronization Response message.
 * 
 * <p>Java class for ARBillingSyncResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ARBillingSyncResponseType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vertexinc:o-series:tps:9:0}TaxSynchronizationResponseType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}Currency" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}OriginalCurrency" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}CompanyCodeCurrency" minOccurs="0"/>
 *         &lt;element name="Seller" type="{urn:vertexinc:o-series:tps:9:0}SellerType" minOccurs="0"/>
 *         &lt;element name="Customer" type="{urn:vertexinc:o-series:tps:9:0}CustomerType" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}TaxOverride" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}ImpositionToProcess" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}JurisdictionOverride" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}SitusOverride" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}Discount" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}SubTotal" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}Total" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}TotalTax" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}ProratePercentage" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}CurrencyConversionFactors" minOccurs="0"/>
 *         &lt;element name="LineItem" type="{urn:vertexinc:o-series:tps:9:0}LineItemARBOType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{urn:vertexinc:o-series:tps:9:0}ARBillingSyncTransactionGroup"/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ARBillingSyncResponseType", propOrder = {
    "currency",
    "originalCurrency",
    "companyCodeCurrency",
    "seller",
    "customer",
    "taxOverride",
    "impositionToProcess",
    "jurisdictionOverride",
    "situsOverride",
    "discount",
    "subTotal",
    "total",
    "totalTax",
    "proratePercentage",
    "currencyConversionFactors",
    "lineItem"
})
public class ARBillingSyncResponseType
    extends TaxSynchronizationResponseType
{

    @XmlElement(name = "Currency")
    protected CurrencyType currency;
    @XmlElement(name = "OriginalCurrency")
    protected CurrencyType originalCurrency;
    @XmlElement(name = "CompanyCodeCurrency")
    protected CurrencyType companyCodeCurrency;
    @XmlElement(name = "Seller")
    protected SellerType seller;
    @XmlElement(name = "Customer")
    protected CustomerType customer;
    @XmlElement(name = "TaxOverride")
    protected TaxOverride taxOverride;
    @XmlElement(name = "ImpositionToProcess")
    protected List<ImpositionToProcess> impositionToProcess;
    @XmlElement(name = "JurisdictionOverride")
    protected List<JurisdictionOverride> jurisdictionOverride;
    @XmlElement(name = "SitusOverride")
    protected SitusOverride situsOverride;
    @XmlElement(name = "Discount")
    protected Discount discount;
    @XmlElement(name = "SubTotal")
    protected BigDecimal subTotal;
    @XmlElement(name = "Total")
    protected BigDecimal total;
    @XmlElement(name = "TotalTax")
    protected BigDecimal totalTax;
    @XmlElement(name = "ProratePercentage")
    protected BigDecimal proratePercentage;
    @XmlElement(name = "CurrencyConversionFactors")
    protected CurrencyConversionFactors currencyConversionFactors;
    @XmlElement(name = "LineItem")
    protected List<LineItemARBOType> lineItem;
    @XmlAttribute(name = "documentNumber")
    protected String documentNumber;
    @XmlAttribute(name = "accumulationDocumentNumber")
    protected String accumulationDocumentNumber;
    @XmlAttribute(name = "accumulationCustomerNumber")
    protected String accumulationCustomerNumber;
    @XmlAttribute(name = "documentType")
    protected String documentType;
    @XmlAttribute(name = "billingType")
    protected String billingType;
    @XmlAttribute(name = "orderType")
    protected String orderType;
    @XmlAttribute(name = "postingDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar postingDate;
    @XmlAttribute(name = "locationCode")
    protected String locationCode;
    @XmlAttribute(name = "returnAssistedParametersIndicator")
    protected Boolean returnAssistedParametersIndicator;
    @XmlAttribute(name = "returnGeneratedLineItemsIndicator")
    protected Boolean returnGeneratedLineItemsIndicator;
    @XmlAttribute(name = "deliveryTerm")
    protected DeliveryTermCodeType deliveryTerm;
    @XmlAttribute(name = "documentDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar documentDate;
    @XmlAttribute(name = "transactionId", required = true)
    protected String transactionId;
    @XmlAttribute(name = "transactionType")
    protected SaleTransactionType transactionType;
    @XmlAttribute(name = "simplificationCode")
    protected SimplificationCodeType simplificationCode;
    @XmlAttribute(name = "roundAtLineLevel")
    protected Boolean roundAtLineLevel;
    @XmlAttribute(name = "paymentDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar paymentDate;
    @XmlAttribute(name = "documentSequenceId")
    protected String documentSequenceId;
    @XmlAttribute(name = "taxPointDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar taxPointDate;

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyType }
     *     
     */
    public CurrencyType getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyType }
     *     
     */
    public void setCurrency(CurrencyType value) {
        this.currency = value;
    }

    /**
     * Gets the value of the originalCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyType }
     *     
     */
    public CurrencyType getOriginalCurrency() {
        return originalCurrency;
    }

    /**
     * Sets the value of the originalCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyType }
     *     
     */
    public void setOriginalCurrency(CurrencyType value) {
        this.originalCurrency = value;
    }

    /**
     * Gets the value of the companyCodeCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyType }
     *     
     */
    public CurrencyType getCompanyCodeCurrency() {
        return companyCodeCurrency;
    }

    /**
     * Sets the value of the companyCodeCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyType }
     *     
     */
    public void setCompanyCodeCurrency(CurrencyType value) {
        this.companyCodeCurrency = value;
    }

    /**
     * Gets the value of the seller property.
     * 
     * @return
     *     possible object is
     *     {@link SellerType }
     *     
     */
    public SellerType getSeller() {
        return seller;
    }

    /**
     * Sets the value of the seller property.
     * 
     * @param value
     *     allowed object is
     *     {@link SellerType }
     *     
     */
    public void setSeller(SellerType value) {
        this.seller = value;
    }

    /**
     * Gets the value of the customer property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerType }
     *     
     */
    public CustomerType getCustomer() {
        return customer;
    }

    /**
     * Sets the value of the customer property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerType }
     *     
     */
    public void setCustomer(CustomerType value) {
        this.customer = value;
    }

    /**
     * Gets the value of the taxOverride property.
     * 
     * @return
     *     possible object is
     *     {@link TaxOverride }
     *     
     */
    public TaxOverride getTaxOverride() {
        return taxOverride;
    }

    /**
     * Sets the value of the taxOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxOverride }
     *     
     */
    public void setTaxOverride(TaxOverride value) {
        this.taxOverride = value;
    }

    /**
     * Gets the value of the impositionToProcess property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the impositionToProcess property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImpositionToProcess().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImpositionToProcess }
     * 
     * 
     */
    public List<ImpositionToProcess> getImpositionToProcess() {
        if (impositionToProcess == null) {
            impositionToProcess = new ArrayList<ImpositionToProcess>();
        }
        return this.impositionToProcess;
    }

    /**
     * Gets the value of the jurisdictionOverride property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the jurisdictionOverride property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJurisdictionOverride().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JurisdictionOverride }
     * 
     * 
     */
    public List<JurisdictionOverride> getJurisdictionOverride() {
        if (jurisdictionOverride == null) {
            jurisdictionOverride = new ArrayList<JurisdictionOverride>();
        }
        return this.jurisdictionOverride;
    }

    /**
     * Gets the value of the situsOverride property.
     * 
     * @return
     *     possible object is
     *     {@link SitusOverride }
     *     
     */
    public SitusOverride getSitusOverride() {
        return situsOverride;
    }

    /**
     * Sets the value of the situsOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link SitusOverride }
     *     
     */
    public void setSitusOverride(SitusOverride value) {
        this.situsOverride = value;
    }

    /**
     * Gets the value of the discount property.
     * 
     * @return
     *     possible object is
     *     {@link Discount }
     *     
     */
    public Discount getDiscount() {
        return discount;
    }

    /**
     * Sets the value of the discount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Discount }
     *     
     */
    public void setDiscount(Discount value) {
        this.discount = value;
    }

    /**
     * Gets the value of the subTotal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSubTotal() {
        return subTotal;
    }

    /**
     * Sets the value of the subTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSubTotal(BigDecimal value) {
        this.subTotal = value;
    }

    /**
     * Gets the value of the total property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * Sets the value of the total property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotal(BigDecimal value) {
        this.total = value;
    }

    /**
     * Gets the value of the totalTax property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalTax() {
        return totalTax;
    }

    /**
     * Sets the value of the totalTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalTax(BigDecimal value) {
        this.totalTax = value;
    }

    /**
     * Gets the value of the proratePercentage property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getProratePercentage() {
        return proratePercentage;
    }

    /**
     * Sets the value of the proratePercentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setProratePercentage(BigDecimal value) {
        this.proratePercentage = value;
    }

    /**
     * A list of conversion factors that Vertex O Series requires to perform currency conversion. These factors include Source Currency, Target Currency, and Conversion Factor.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyConversionFactors }
     *     
     */
    public CurrencyConversionFactors getCurrencyConversionFactors() {
        return currencyConversionFactors;
    }

    /**
     * Sets the value of the currencyConversionFactors property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyConversionFactors }
     *     
     */
    public void setCurrencyConversionFactors(CurrencyConversionFactors value) {
        this.currencyConversionFactors = value;
    }

    /**
     * Gets the value of the lineItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lineItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLineItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LineItemARBOType }
     * 
     * 
     */
    public List<LineItemARBOType> getLineItem() {
        if (lineItem == null) {
            lineItem = new ArrayList<LineItemARBOType>();
        }
        return this.lineItem;
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
     * Gets the value of the documentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentType() {
        return documentType;
    }

    /**
     * Sets the value of the documentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentType(String value) {
        this.documentType = value;
    }

    /**
     * Gets the value of the billingType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillingType() {
        return billingType;
    }

    /**
     * Sets the value of the billingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillingType(String value) {
        this.billingType = value;
    }

    /**
     * Gets the value of the orderType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * Sets the value of the orderType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderType(String value) {
        this.orderType = value;
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
     * Gets the value of the locationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationCode() {
        return locationCode;
    }

    /**
     * Sets the value of the locationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationCode(String value) {
        this.locationCode = value;
    }

    /**
     * Gets the value of the returnAssistedParametersIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReturnAssistedParametersIndicator() {
        return returnAssistedParametersIndicator;
    }

    /**
     * Sets the value of the returnAssistedParametersIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReturnAssistedParametersIndicator(Boolean value) {
        this.returnAssistedParametersIndicator = value;
    }

    /**
     * Gets the value of the returnGeneratedLineItemsIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReturnGeneratedLineItemsIndicator() {
        return returnGeneratedLineItemsIndicator;
    }

    /**
     * Sets the value of the returnGeneratedLineItemsIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReturnGeneratedLineItemsIndicator(Boolean value) {
        this.returnGeneratedLineItemsIndicator = value;
    }

    /**
     * Gets the value of the deliveryTerm property.
     * 
     * @return
     *     possible object is
     *     {@link DeliveryTermCodeType }
     *     
     */
    public DeliveryTermCodeType getDeliveryTerm() {
        return deliveryTerm;
    }

    /**
     * Sets the value of the deliveryTerm property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveryTermCodeType }
     *     
     */
    public void setDeliveryTerm(DeliveryTermCodeType value) {
        this.deliveryTerm = value;
    }

    /**
     * Gets the value of the documentDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDocumentDate() {
        return documentDate;
    }

    /**
     * Sets the value of the documentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDocumentDate(XMLGregorianCalendar value) {
        this.documentDate = value;
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
     * Gets the value of the transactionType property.
     * 
     * @return
     *     possible object is
     *     {@link SaleTransactionType }
     *     
     */
    public SaleTransactionType getTransactionType() {
        return transactionType;
    }

    /**
     * Sets the value of the transactionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SaleTransactionType }
     *     
     */
    public void setTransactionType(SaleTransactionType value) {
        this.transactionType = value;
    }

    /**
     * Gets the value of the simplificationCode property.
     * 
     * @return
     *     possible object is
     *     {@link SimplificationCodeType }
     *     
     */
    public SimplificationCodeType getSimplificationCode() {
        return simplificationCode;
    }

    /**
     * Sets the value of the simplificationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimplificationCodeType }
     *     
     */
    public void setSimplificationCode(SimplificationCodeType value) {
        this.simplificationCode = value;
    }

    /**
     * Gets the value of the roundAtLineLevel property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRoundAtLineLevel() {
        return roundAtLineLevel;
    }

    /**
     * Sets the value of the roundAtLineLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRoundAtLineLevel(Boolean value) {
        this.roundAtLineLevel = value;
    }

    /**
     * Gets the value of the paymentDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPaymentDate() {
        return paymentDate;
    }

    /**
     * Sets the value of the paymentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPaymentDate(XMLGregorianCalendar value) {
        this.paymentDate = value;
    }

    /**
     * Gets the value of the documentSequenceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentSequenceId() {
        return documentSequenceId;
    }

    /**
     * Sets the value of the documentSequenceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentSequenceId(String value) {
        this.documentSequenceId = value;
    }

    /**
     * Gets the value of the taxPointDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTaxPointDate() {
        return taxPointDate;
    }

    /**
     * Sets the value of the taxPointDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTaxPointDate(XMLGregorianCalendar value) {
        this.taxPointDate = value;
    }

}
