
package aeo.integration.vertex.client;

import java.math.BigDecimal;
import java.math.BigInteger;
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
 * Line Item declaration for Inventory Removal Response message.
 * 
 * <p>Java class for LineItemIRMOType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LineItemIRMOType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Owner" type="{urn:vertexinc:o-series:tps:9:0}OwnerType" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}TaxOverride" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}ImpositionToProcess" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}JurisdictionOverride" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}SitusOverride" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}Purchase" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}LineType" minOccurs="0"/>
 *         &lt;element name="CommodityCode" type="{urn:vertexinc:o-series:tps:9:0}CommodityCodeResponseType" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}Quantity" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}Weight" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}Volume" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}SupplementaryUnit" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}StatisticalValue" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}Cost" minOccurs="0"/>
 *         &lt;element name="NetBookValue" type="{urn:vertexinc:o-series:tps:9:0}AmountType" minOccurs="0"/>
 *         &lt;element name="TotalCost" type="{urn:vertexinc:o-series:tps:9:0}AmountType" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}FairMarketValue" minOccurs="0"/>
 *         &lt;element name="FairRentalValue" type="{urn:vertexinc:o-series:tps:9:0}AmountType" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}ExtendedPrice" minOccurs="0"/>
 *         &lt;element name="CompanyCodeCurrencyTaxableAmount" type="{urn:vertexinc:o-series:tps:9:0}AmountType" minOccurs="0"/>
 *         &lt;element name="CompanyCodeCurrencyTaxAmount" type="{urn:vertexinc:o-series:tps:9:0}AmountType" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}SpecialTaxBasis" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}WageBasis" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}Taxes" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}TotalTax" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}FlexibleFields" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}ReturnsFields" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}AssistedParameters" minOccurs="0"/>
 *         &lt;element name="LineItem" type="{urn:vertexinc:o-series:tps:9:0}LineItemIRMOType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{urn:vertexinc:o-series:tps:9:0}InventoryRemovalLineItemGroup"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LineItemIRMOType", propOrder = {
    "owner",
    "taxOverride",
    "impositionToProcess",
    "jurisdictionOverride",
    "situsOverride",
    "purchase",
    "lineType",
    "commodityCode",
    "quantity",
    "weight",
    "volume",
    "supplementaryUnit",
    "statisticalValue",
    "cost",
    "netBookValue",
    "totalCost",
    "fairMarketValue",
    "fairRentalValue",
    "extendedPrice",
    "companyCodeCurrencyTaxableAmount",
    "companyCodeCurrencyTaxAmount",
    "specialTaxBasis",
    "wageBasis",
    "taxes",
    "totalTax",
    "flexibleFields",
    "returnsFields",
    "assistedParameters",
    "lineItem"
})
public class LineItemIRMOType {

    @XmlElement(name = "Owner")
    protected OwnerType owner;
    @XmlElement(name = "TaxOverride")
    protected TaxOverride taxOverride;
    @XmlElement(name = "ImpositionToProcess")
    protected List<ImpositionToProcess> impositionToProcess;
    @XmlElement(name = "JurisdictionOverride")
    protected List<JurisdictionOverride> jurisdictionOverride;
    @XmlElement(name = "SitusOverride")
    protected SitusOverride situsOverride;
    @XmlElement(name = "Purchase")
    protected Purchase purchase;
    @XmlElement(name = "LineType")
    protected LineType lineType;
    @XmlElement(name = "CommodityCode")
    protected CommodityCodeResponseType commodityCode;
    @XmlElement(name = "Quantity")
    protected MeasureType quantity;
    @XmlElement(name = "Weight")
    protected MeasureType weight;
    @XmlElement(name = "Volume")
    protected MeasureType volume;
    @XmlElement(name = "SupplementaryUnit")
    protected SupplementaryUnitType supplementaryUnit;
    @XmlElement(name = "StatisticalValue")
    protected CurrencyAmountType statisticalValue;
    @XmlElement(name = "Cost")
    protected BigDecimal cost;
    @XmlElement(name = "NetBookValue")
    protected BigDecimal netBookValue;
    @XmlElement(name = "TotalCost")
    protected BigDecimal totalCost;
    @XmlElement(name = "FairMarketValue")
    protected BigDecimal fairMarketValue;
    @XmlElement(name = "FairRentalValue")
    protected BigDecimal fairRentalValue;
    @XmlElement(name = "ExtendedPrice")
    protected BigDecimal extendedPrice;
    @XmlElement(name = "CompanyCodeCurrencyTaxableAmount")
    protected BigDecimal companyCodeCurrencyTaxableAmount;
    @XmlElement(name = "CompanyCodeCurrencyTaxAmount")
    protected BigDecimal companyCodeCurrencyTaxAmount;
    @XmlElement(name = "SpecialTaxBasis")
    protected BigDecimal specialTaxBasis;
    @XmlElement(name = "WageBasis")
    protected BigDecimal wageBasis;
    @XmlElement(name = "Taxes")
    protected List<TaxesType> taxes;
    @XmlElement(name = "TotalTax")
    protected BigDecimal totalTax;
    @XmlElement(name = "FlexibleFields")
    protected FlexibleFields flexibleFields;
    @XmlElement(name = "ReturnsFields")
    protected ReturnsFields returnsFields;
    @XmlElement(name = "AssistedParameters")
    protected AssistedParametersType assistedParameters;
    @XmlElement(name = "LineItem")
    protected List<LineItemIRMOType> lineItem;
    @XmlAttribute(name = "lineItemNumber")
    protected Long lineItemNumber;
    @XmlAttribute(name = "taxDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar taxDate;
    @XmlAttribute(name = "isMulticomponent")
    protected Boolean isMulticomponent;
    @XmlAttribute(name = "locationCode")
    protected String locationCode;
    @XmlAttribute(name = "deliveryTerm")
    protected DeliveryTermCodeType deliveryTerm;
    @XmlAttribute(name = "postingDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar postingDate;
    @XmlAttribute(name = "costCenter")
    protected String costCenter;
    @XmlAttribute(name = "departmentCode")
    protected String departmentCode;
    @XmlAttribute(name = "generalLedgerAccount")
    protected String generalLedgerAccount;
    @XmlAttribute(name = "materialCode")
    protected String materialCode;
    @XmlAttribute(name = "projectNumber")
    protected String projectNumber;
    @XmlAttribute(name = "usage")
    protected String usage;
    @XmlAttribute(name = "usageClass")
    protected String usageClass;
    @XmlAttribute(name = "vendorSKU")
    protected String vendorSKU;
    @XmlAttribute(name = "countryOfOriginISOCode")
    protected String countryOfOriginISOCode;
    @XmlAttribute(name = "modeOfTransport")
    protected Integer modeOfTransport;
    @XmlAttribute(name = "natureOfTransaction")
    protected Integer natureOfTransaction;
    @XmlAttribute(name = "intrastatCommodityCode")
    protected String intrastatCommodityCode;
    @XmlAttribute(name = "netMassKilograms")
    protected BigInteger netMassKilograms;
    @XmlAttribute(name = "lineItemId")
    protected String lineItemId;
    @XmlAttribute(name = "exportProcedure")
    protected String exportProcedure;
    @XmlAttribute(name = "materialOrigin")
    protected String materialOrigin;

    /**
     * Gets the value of the owner property.
     * 
     * @return
     *     possible object is
     *     {@link OwnerType }
     *     
     */
    public OwnerType getOwner() {
        return owner;
    }

    /**
     * Sets the value of the owner property.
     * 
     * @param value
     *     allowed object is
     *     {@link OwnerType }
     *     
     */
    public void setOwner(OwnerType value) {
        this.owner = value;
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
     * Gets the value of the purchase property.
     * 
     * @return
     *     possible object is
     *     {@link Purchase }
     *     
     */
    public Purchase getPurchase() {
        return purchase;
    }

    /**
     * Sets the value of the purchase property.
     * 
     * @param value
     *     allowed object is
     *     {@link Purchase }
     *     
     */
    public void setPurchase(Purchase value) {
        this.purchase = value;
    }

    /**
     * Gets the value of the lineType property.
     * 
     * @return
     *     possible object is
     *     {@link LineType }
     *     
     */
    public LineType getLineType() {
        return lineType;
    }

    /**
     * Sets the value of the lineType property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineType }
     *     
     */
    public void setLineType(LineType value) {
        this.lineType = value;
    }

    /**
     * Gets the value of the commodityCode property.
     * 
     * @return
     *     possible object is
     *     {@link CommodityCodeResponseType }
     *     
     */
    public CommodityCodeResponseType getCommodityCode() {
        return commodityCode;
    }

    /**
     * Sets the value of the commodityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommodityCodeResponseType }
     *     
     */
    public void setCommodityCode(CommodityCodeResponseType value) {
        this.commodityCode = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setQuantity(MeasureType value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the weight property.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getWeight() {
        return weight;
    }

    /**
     * Sets the value of the weight property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setWeight(MeasureType value) {
        this.weight = value;
    }

    /**
     * Gets the value of the volume property.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getVolume() {
        return volume;
    }

    /**
     * Sets the value of the volume property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setVolume(MeasureType value) {
        this.volume = value;
    }

    /**
     * Gets the value of the supplementaryUnit property.
     * 
     * @return
     *     possible object is
     *     {@link SupplementaryUnitType }
     *     
     */
    public SupplementaryUnitType getSupplementaryUnit() {
        return supplementaryUnit;
    }

    /**
     * Sets the value of the supplementaryUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplementaryUnitType }
     *     
     */
    public void setSupplementaryUnit(SupplementaryUnitType value) {
        this.supplementaryUnit = value;
    }

    /**
     * Gets the value of the statisticalValue property.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyAmountType }
     *     
     */
    public CurrencyAmountType getStatisticalValue() {
        return statisticalValue;
    }

    /**
     * Sets the value of the statisticalValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyAmountType }
     *     
     */
    public void setStatisticalValue(CurrencyAmountType value) {
        this.statisticalValue = value;
    }

    /**
     * Gets the value of the cost property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCost() {
        return cost;
    }

    /**
     * Sets the value of the cost property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCost(BigDecimal value) {
        this.cost = value;
    }

    /**
     * Gets the value of the netBookValue property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNetBookValue() {
        return netBookValue;
    }

    /**
     * Sets the value of the netBookValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNetBookValue(BigDecimal value) {
        this.netBookValue = value;
    }

    /**
     * Gets the value of the totalCost property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalCost() {
        return totalCost;
    }

    /**
     * Sets the value of the totalCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalCost(BigDecimal value) {
        this.totalCost = value;
    }

    /**
     * Gets the value of the fairMarketValue property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFairMarketValue() {
        return fairMarketValue;
    }

    /**
     * Sets the value of the fairMarketValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFairMarketValue(BigDecimal value) {
        this.fairMarketValue = value;
    }

    /**
     * Gets the value of the fairRentalValue property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFairRentalValue() {
        return fairRentalValue;
    }

    /**
     * Sets the value of the fairRentalValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFairRentalValue(BigDecimal value) {
        this.fairRentalValue = value;
    }

    /**
     * Gets the value of the extendedPrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getExtendedPrice() {
        return extendedPrice;
    }

    /**
     * Sets the value of the extendedPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setExtendedPrice(BigDecimal value) {
        this.extendedPrice = value;
    }

    /**
     * Gets the value of the companyCodeCurrencyTaxableAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCompanyCodeCurrencyTaxableAmount() {
        return companyCodeCurrencyTaxableAmount;
    }

    /**
     * Sets the value of the companyCodeCurrencyTaxableAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCompanyCodeCurrencyTaxableAmount(BigDecimal value) {
        this.companyCodeCurrencyTaxableAmount = value;
    }

    /**
     * Gets the value of the companyCodeCurrencyTaxAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCompanyCodeCurrencyTaxAmount() {
        return companyCodeCurrencyTaxAmount;
    }

    /**
     * Sets the value of the companyCodeCurrencyTaxAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCompanyCodeCurrencyTaxAmount(BigDecimal value) {
        this.companyCodeCurrencyTaxAmount = value;
    }

    /**
     * Gets the value of the specialTaxBasis property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSpecialTaxBasis() {
        return specialTaxBasis;
    }

    /**
     * Sets the value of the specialTaxBasis property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSpecialTaxBasis(BigDecimal value) {
        this.specialTaxBasis = value;
    }

    /**
     * Gets the value of the wageBasis property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getWageBasis() {
        return wageBasis;
    }

    /**
     * Sets the value of the wageBasis property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setWageBasis(BigDecimal value) {
        this.wageBasis = value;
    }

    /**
     * Gets the value of the taxes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaxesType }
     * 
     * 
     */
    public List<TaxesType> getTaxes() {
        if (taxes == null) {
            taxes = new ArrayList<TaxesType>();
        }
        return this.taxes;
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
     * Gets the value of the flexibleFields property.
     * 
     * @return
     *     possible object is
     *     {@link FlexibleFields }
     *     
     */
    public FlexibleFields getFlexibleFields() {
        return flexibleFields;
    }

    /**
     * Sets the value of the flexibleFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link FlexibleFields }
     *     
     */
    public void setFlexibleFields(FlexibleFields value) {
        this.flexibleFields = value;
    }

    /**
     * Gets the value of the returnsFields property.
     * 
     * @return
     *     possible object is
     *     {@link ReturnsFields }
     *     
     */
    public ReturnsFields getReturnsFields() {
        return returnsFields;
    }

    /**
     * Sets the value of the returnsFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReturnsFields }
     *     
     */
    public void setReturnsFields(ReturnsFields value) {
        this.returnsFields = value;
    }

    /**
     * Gets the value of the assistedParameters property.
     * 
     * @return
     *     possible object is
     *     {@link AssistedParametersType }
     *     
     */
    public AssistedParametersType getAssistedParameters() {
        return assistedParameters;
    }

    /**
     * Sets the value of the assistedParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssistedParametersType }
     *     
     */
    public void setAssistedParameters(AssistedParametersType value) {
        this.assistedParameters = value;
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
     * {@link LineItemIRMOType }
     * 
     * 
     */
    public List<LineItemIRMOType> getLineItem() {
        if (lineItem == null) {
            lineItem = new ArrayList<LineItemIRMOType>();
        }
        return this.lineItem;
    }

    /**
     * Gets the value of the lineItemNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLineItemNumber() {
        return lineItemNumber;
    }

    /**
     * Sets the value of the lineItemNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLineItemNumber(Long value) {
        this.lineItemNumber = value;
    }

    /**
     * Gets the value of the taxDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTaxDate() {
        return taxDate;
    }

    /**
     * Sets the value of the taxDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTaxDate(XMLGregorianCalendar value) {
        this.taxDate = value;
    }

    /**
     * Gets the value of the isMulticomponent property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsMulticomponent() {
        return isMulticomponent;
    }

    /**
     * Sets the value of the isMulticomponent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsMulticomponent(Boolean value) {
        this.isMulticomponent = value;
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
     * Gets the value of the costCenter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCostCenter() {
        return costCenter;
    }

    /**
     * Sets the value of the costCenter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCostCenter(String value) {
        this.costCenter = value;
    }

    /**
     * Gets the value of the departmentCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartmentCode() {
        return departmentCode;
    }

    /**
     * Sets the value of the departmentCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartmentCode(String value) {
        this.departmentCode = value;
    }

    /**
     * Gets the value of the generalLedgerAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeneralLedgerAccount() {
        return generalLedgerAccount;
    }

    /**
     * Sets the value of the generalLedgerAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeneralLedgerAccount(String value) {
        this.generalLedgerAccount = value;
    }

    /**
     * Gets the value of the materialCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaterialCode() {
        return materialCode;
    }

    /**
     * Sets the value of the materialCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaterialCode(String value) {
        this.materialCode = value;
    }

    /**
     * Gets the value of the projectNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProjectNumber() {
        return projectNumber;
    }

    /**
     * Sets the value of the projectNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProjectNumber(String value) {
        this.projectNumber = value;
    }

    /**
     * Gets the value of the usage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsage() {
        return usage;
    }

    /**
     * Sets the value of the usage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsage(String value) {
        this.usage = value;
    }

    /**
     * Gets the value of the usageClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsageClass() {
        return usageClass;
    }

    /**
     * Sets the value of the usageClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsageClass(String value) {
        this.usageClass = value;
    }

    /**
     * Gets the value of the vendorSKU property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVendorSKU() {
        return vendorSKU;
    }

    /**
     * Sets the value of the vendorSKU property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVendorSKU(String value) {
        this.vendorSKU = value;
    }

    /**
     * Gets the value of the countryOfOriginISOCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryOfOriginISOCode() {
        return countryOfOriginISOCode;
    }

    /**
     * Sets the value of the countryOfOriginISOCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryOfOriginISOCode(String value) {
        this.countryOfOriginISOCode = value;
    }

    /**
     * Gets the value of the modeOfTransport property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getModeOfTransport() {
        return modeOfTransport;
    }

    /**
     * Sets the value of the modeOfTransport property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setModeOfTransport(Integer value) {
        this.modeOfTransport = value;
    }

    /**
     * Gets the value of the natureOfTransaction property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNatureOfTransaction() {
        return natureOfTransaction;
    }

    /**
     * Sets the value of the natureOfTransaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNatureOfTransaction(Integer value) {
        this.natureOfTransaction = value;
    }

    /**
     * Gets the value of the intrastatCommodityCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntrastatCommodityCode() {
        return intrastatCommodityCode;
    }

    /**
     * Sets the value of the intrastatCommodityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntrastatCommodityCode(String value) {
        this.intrastatCommodityCode = value;
    }

    /**
     * Gets the value of the netMassKilograms property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNetMassKilograms() {
        return netMassKilograms;
    }

    /**
     * Sets the value of the netMassKilograms property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNetMassKilograms(BigInteger value) {
        this.netMassKilograms = value;
    }

    /**
     * Gets the value of the lineItemId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLineItemId() {
        return lineItemId;
    }

    /**
     * Sets the value of the lineItemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLineItemId(String value) {
        this.lineItemId = value;
    }

    /**
     * Gets the value of the exportProcedure property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExportProcedure() {
        return exportProcedure;
    }

    /**
     * Sets the value of the exportProcedure property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExportProcedure(String value) {
        this.exportProcedure = value;
    }

    /**
     * Gets the value of the materialOrigin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaterialOrigin() {
        return materialOrigin;
    }

    /**
     * Sets the value of the materialOrigin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaterialOrigin(String value) {
        this.materialOrigin = value;
    }

}
