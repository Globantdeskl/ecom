
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
 * The request used in self-accrual situations. These situations occur when the purchaser must remit tax on tangible personal property or services (used or consumed) when tax is due but has not been paid. Use Tax Accrual transactions are written to the Tax Journal. Some examples of self-accrual situations include when a seller does not have nexus in the purchaser's state and does not collect tax, when non-exempt tangible personal property is purchased without tax and is subsequently used in a taxable manner (and the purchaser has provided the seller a direct pay permit), when a company uses items from inventory in a taxable manner (and the purchaser has provided the seller a resale certificate).
 * 
 * 
 * <p>Java class for AccrualRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccrualRequestType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vertexinc:o-series:tps:9:0}TaxTransactionRequestType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}Currency" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}OriginalCurrency" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}CompanyCodeCurrency" minOccurs="0"/>
 *         &lt;element name="Buyer" type="{urn:vertexinc:o-series:tps:9:0}BuyerType" minOccurs="0"/>
 *         &lt;element name="Vendor" type="{urn:vertexinc:o-series:tps:9:0}VendorType" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}TaxOverride" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}ImpositionToProcess" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}JurisdictionOverride" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}SitusOverride" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}Discount" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}ProratePercentage" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}ChargedTax" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}CurrencyConversionFactors" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}TaxabilityCategoryTotals" minOccurs="0"/>
 *         &lt;element name="LineItem" type="{urn:vertexinc:o-series:tps:9:0}LineItemATIType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{urn:vertexinc:o-series:tps:9:0}AccrualTransactionGroup"/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccrualRequestType", propOrder = {
    "currency",
    "originalCurrency",
    "companyCodeCurrency",
    "buyer",
    "vendor",
    "taxOverride",
    "impositionToProcess",
    "jurisdictionOverride",
    "situsOverride",
    "discount",
    "proratePercentage",
    "chargedTax",
    "currencyConversionFactors",
    "taxabilityCategoryTotals",
    "lineItem"
})
public class AccrualRequestType
    extends TaxTransactionRequestType
{

    @XmlElement(name = "Currency")
    protected CurrencyType currency;
    @XmlElement(name = "OriginalCurrency")
    protected CurrencyType originalCurrency;
    @XmlElement(name = "CompanyCodeCurrency")
    protected CurrencyType companyCodeCurrency;
    @XmlElement(name = "Buyer")
    protected BuyerType buyer;
    @XmlElement(name = "Vendor")
    protected VendorType vendor;
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
    @XmlElement(name = "ProratePercentage")
    protected BigDecimal proratePercentage;
    @XmlElement(name = "ChargedTax")
    protected BigDecimal chargedTax;
    @XmlElement(name = "CurrencyConversionFactors")
    protected CurrencyConversionFactors currencyConversionFactors;
    @XmlElement(name = "TaxabilityCategoryTotals")
    protected TaxabilityCategoryTotals taxabilityCategoryTotals;
    @XmlElement(name = "LineItem", required = true)
    protected List<LineItemATIType> lineItem;
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
    @XmlAttribute(name = "documentDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar documentDate;
    @XmlAttribute(name = "transactionId")
    protected String transactionId;
    @XmlAttribute(name = "transactionType", required = true)
    protected ProcurementTransactionType transactionType;
    @XmlAttribute(name = "simplificationCode")
    protected SimplificationCodeType simplificationCode;
    @XmlAttribute(name = "recoverableDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar recoverableDate;
    @XmlAttribute(name = "calculateVendorTaxIndicator")
    protected Boolean calculateVendorTaxIndicator;
    @XmlAttribute(name = "postToJournal")
    protected Boolean postToJournal;
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
     * Gets the value of the buyer property.
     * 
     * @return
     *     possible object is
     *     {@link BuyerType }
     *     
     */
    public BuyerType getBuyer() {
        return buyer;
    }

    /**
     * Sets the value of the buyer property.
     * 
     * @param value
     *     allowed object is
     *     {@link BuyerType }
     *     
     */
    public void setBuyer(BuyerType value) {
        this.buyer = value;
    }

    /**
     * Gets the value of the vendor property.
     * 
     * @return
     *     possible object is
     *     {@link VendorType }
     *     
     */
    public VendorType getVendor() {
        return vendor;
    }

    /**
     * Sets the value of the vendor property.
     * 
     * @param value
     *     allowed object is
     *     {@link VendorType }
     *     
     */
    public void setVendor(VendorType value) {
        this.vendor = value;
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
     * This value is used when the buyer has paid a portion of the tax due on the invoice but an undercharge scenario occurs that   required a partial accrual of tax or additional use tax may be due depending on the jurisdiction and usage of the Purchase. The amount paid from the invoice verification process should be passed so that partial accrual can be applied. Additional consumer use tax will be automatically accrued. 
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getChargedTax() {
        return chargedTax;
    }

    /**
     * Sets the value of the chargedTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setChargedTax(BigDecimal value) {
        this.chargedTax = value;
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
     * A list of taxability category total information that you can pass from your ERP to Vertex O Series.
     * 
     * @return
     *     possible object is
     *     {@link TaxabilityCategoryTotals }
     *     
     */
    public TaxabilityCategoryTotals getTaxabilityCategoryTotals() {
        return taxabilityCategoryTotals;
    }

    /**
     * Sets the value of the taxabilityCategoryTotals property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxabilityCategoryTotals }
     *     
     */
    public void setTaxabilityCategoryTotals(TaxabilityCategoryTotals value) {
        this.taxabilityCategoryTotals = value;
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
     * {@link LineItemATIType }
     * 
     * 
     */
    public List<LineItemATIType> getLineItem() {
        if (lineItem == null) {
            lineItem = new ArrayList<LineItemATIType>();
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
     *     {@link ProcurementTransactionType }
     *     
     */
    public ProcurementTransactionType getTransactionType() {
        return transactionType;
    }

    /**
     * Sets the value of the transactionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcurementTransactionType }
     *     
     */
    public void setTransactionType(ProcurementTransactionType value) {
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
     * Gets the value of the recoverableDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRecoverableDate() {
        return recoverableDate;
    }

    /**
     * Sets the value of the recoverableDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRecoverableDate(XMLGregorianCalendar value) {
        this.recoverableDate = value;
    }

    /**
     * Gets the value of the calculateVendorTaxIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCalculateVendorTaxIndicator() {
        return calculateVendorTaxIndicator;
    }

    /**
     * Sets the value of the calculateVendorTaxIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCalculateVendorTaxIndicator(Boolean value) {
        this.calculateVendorTaxIndicator = value;
    }

    /**
     * Gets the value of the postToJournal property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isPostToJournal() {
        if (postToJournal == null) {
            return true;
        } else {
            return postToJournal;
        }
    }

    /**
     * Sets the value of the postToJournal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPostToJournal(Boolean value) {
        this.postToJournal = value;
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
