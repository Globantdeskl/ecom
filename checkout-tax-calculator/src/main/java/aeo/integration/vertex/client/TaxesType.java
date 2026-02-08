
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
import javax.xml.bind.annotation.XmlValue;


/**
 * Taxes calculated by the transaction processing system.
 * 
 * <p>Java class for TaxesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TaxesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Jurisdiction" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;urn:vertexinc:o-series:tps:9:0>JurisdictionType">
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="AccumulateAsJurisdiction" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;urn:vertexinc:o-series:tps:9:0>JurisdictionType">
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CalculatedTax" type="{urn:vertexinc:o-series:tps:9:0}AmountType" minOccurs="0"/>
 *         &lt;element name="EffectiveRate" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TaxApportionmentRate" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="BasisReductionPercentage" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Exempt" type="{urn:vertexinc:o-series:tps:9:0}MeasureType" minOccurs="0"/>
 *         &lt;element name="NonTaxable" type="{urn:vertexinc:o-series:tps:9:0}MeasureType" minOccurs="0"/>
 *         &lt;element name="Taxable" type="{urn:vertexinc:o-series:tps:9:0}MeasureType" minOccurs="0"/>
 *         &lt;element name="ReportingBasis" type="{urn:vertexinc:o-series:tps:9:0}AmountType" minOccurs="0"/>
 *         &lt;element name="Imposition" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="userDefined" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="impositionId" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}ImpositionType" minOccurs="0"/>
 *         &lt;element name="AccumulateAsImposition" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="userDefined" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="impositionId" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}AccumulateAsImpositionType" minOccurs="0"/>
 *         &lt;element name="TaxRuleId" type="{urn:vertexinc:o-series:tps:9:0}RuleType" minOccurs="0"/>
 *         &lt;element name="BasisRuleId" type="{urn:vertexinc:o-series:tps:9:0}RuleType" minOccurs="0"/>
 *         &lt;element name="InclusionRuleId" type="{urn:vertexinc:o-series:tps:9:0}RuleType" minOccurs="0"/>
 *         &lt;element name="MaxTaxRuleId" type="{urn:vertexinc:o-series:tps:9:0}RuleType" minOccurs="0"/>
 *         &lt;element name="RecoverableRuleId" type="{urn:vertexinc:o-series:tps:9:0}RuleType" minOccurs="0"/>
 *         &lt;element name="PostCalculationEvaluationRuleId" type="{urn:vertexinc:o-series:tps:9:0}RuleType" minOccurs="0"/>
 *         &lt;element name="CreditRuleId" type="{urn:vertexinc:o-series:tps:9:0}RuleType" minOccurs="0"/>
 *         &lt;element name="BasisApportionmentRuleId" type="{urn:vertexinc:o-series:tps:9:0}RuleType" minOccurs="0"/>
 *         &lt;element name="TaxRateAdjustmentRuleId" type="{urn:vertexinc:o-series:tps:9:0}RuleType" minOccurs="0"/>
 *         &lt;element name="TaxApportionmentRuleId" type="{urn:vertexinc:o-series:tps:9:0}RuleType" minOccurs="0"/>
 *         &lt;element name="AccumulationRuleId" type="{urn:vertexinc:o-series:tps:9:0}RuleType" minOccurs="0"/>
 *         &lt;element name="TelecomUnitConversionRuleId" type="{urn:vertexinc:o-series:tps:9:0}RuleType" minOccurs="0"/>
 *         &lt;element name="ReportingBasisRuleId" type="{urn:vertexinc:o-series:tps:9:0}RuleType" minOccurs="0"/>
 *         &lt;element name="CertificateNumber" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="certificateType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="RecoverableAmount" type="{urn:vertexinc:o-series:tps:9:0}AmountType" minOccurs="0"/>
 *         &lt;element name="RecoverablePercent" type="{urn:vertexinc:o-series:tps:9:0}PercentType" minOccurs="0"/>
 *         &lt;element name="BlockingRecoverablePercent" type="{urn:vertexinc:o-series:tps:9:0}PercentType" minOccurs="0"/>
 *         &lt;element name="PartialExemptRecoverablePercent" type="{urn:vertexinc:o-series:tps:9:0}PercentType" minOccurs="0"/>
 *         &lt;element name="UnrecoverableAmount" type="{urn:vertexinc:o-series:tps:9:0}AmountType" minOccurs="0"/>
 *         &lt;element name="FilingCurrencyAmounts" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{urn:vertexinc:o-series:tps:9:0}CurrencyConversion"/>
 *                   &lt;element name="FilingCalculatedTax" type="{urn:vertexinc:o-series:tps:9:0}AmountType" minOccurs="0"/>
 *                   &lt;element name="FilingExempt" type="{urn:vertexinc:o-series:tps:9:0}AmountType" minOccurs="0"/>
 *                   &lt;element name="FilingNonTaxable" type="{urn:vertexinc:o-series:tps:9:0}AmountType" minOccurs="0"/>
 *                   &lt;element name="FilingTaxable" type="{urn:vertexinc:o-series:tps:9:0}AmountType" minOccurs="0"/>
 *                   &lt;element name="FilingRecoverableAmount" type="{urn:vertexinc:o-series:tps:9:0}AmountType" minOccurs="0"/>
 *                   &lt;element name="FilingUnrecoverableAmount" type="{urn:vertexinc:o-series:tps:9:0}AmountType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SellerRegistrationId" type="{urn:vertexinc:o-series:tps:9:0}RegistrationIdType" minOccurs="0"/>
 *         &lt;element name="BuyerRegistrationId" type="{urn:vertexinc:o-series:tps:9:0}RegistrationIdType" minOccurs="0"/>
 *         &lt;element name="OwnerRegistrationId" type="{urn:vertexinc:o-series:tps:9:0}RegistrationIdType" minOccurs="0"/>
 *         &lt;element name="DispatcherRegistrationId" type="{urn:vertexinc:o-series:tps:9:0}RegistrationIdType" minOccurs="0"/>
 *         &lt;element name="RecipientRegistrationId" type="{urn:vertexinc:o-series:tps:9:0}RegistrationIdType" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}InvoiceTextCode" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SummaryInvoiceText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}InvoiceTexts" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}AssistedParameters" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}TaxRuleCurrencyConversionFactors" minOccurs="0"/>
 *         &lt;element name="OriginalTax" type="{urn:vertexinc:o-series:tps:9:0}AmountType" minOccurs="0"/>
 *         &lt;element name="IncludedTax" type="{urn:vertexinc:o-series:tps:9:0}AmountType" minOccurs="0"/>
 *         &lt;element name="NominalRate" type="{urn:vertexinc:o-series:tps:9:0}AmountType" minOccurs="0"/>
 *         &lt;element name="MarkUpRate" type="{urn:vertexinc:o-series:tps:9:0}AmountType" minOccurs="0"/>
 *         &lt;element name="AccumulateAsLineType" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="userDefined" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="taxResult" type="{urn:vertexinc:o-series:tps:9:0}TaxResultCodeType" />
 *       &lt;attribute name="taxType" type="{urn:vertexinc:o-series:tps:9:0}TaxingType" />
 *       &lt;attribute name="maxTaxIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="situs" type="{urn:vertexinc:o-series:tps:9:0}TaxingLocationCodeType" />
 *       &lt;attribute name="notRegisteredIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="inputOutputType" type="{urn:vertexinc:o-series:tps:9:0}InputOutputCodeType" />
 *       &lt;attribute name="taxCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="vertexTaxCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="reasonCode" type="{urn:vertexinc:o-series:tps:9:0}ReasonCodeType" />
 *       &lt;attribute name="filingCategoryCode">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger">
 *             &lt;minInclusive value="1"/>
 *             &lt;maxInclusive value="99999"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="isService" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="rateClassification" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="taxCollectedFromParty" type="{urn:vertexinc:o-series:tps:9:0}TaxCollectedFromPartyType" />
 *       &lt;attribute name="taxStructure" type="{urn:vertexinc:o-series:tps:9:0}TaxStructureCodeType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxesType", propOrder = {
    "jurisdiction",
    "accumulateAsJurisdiction",
    "calculatedTax",
    "effectiveRate",
    "taxApportionmentRate",
    "basisReductionPercentage",
    "exempt",
    "nonTaxable",
    "taxable",
    "reportingBasis",
    "imposition",
    "impositionType",
    "accumulateAsImposition",
    "accumulateAsImpositionType",
    "taxRuleId",
    "basisRuleId",
    "inclusionRuleId",
    "maxTaxRuleId",
    "recoverableRuleId",
    "postCalculationEvaluationRuleId",
    "creditRuleId",
    "basisApportionmentRuleId",
    "taxRateAdjustmentRuleId",
    "taxApportionmentRuleId",
    "accumulationRuleId",
    "telecomUnitConversionRuleId",
    "reportingBasisRuleId",
    "certificateNumber",
    "recoverableAmount",
    "recoverablePercent",
    "blockingRecoverablePercent",
    "partialExemptRecoverablePercent",
    "unrecoverableAmount",
    "filingCurrencyAmounts",
    "sellerRegistrationId",
    "buyerRegistrationId",
    "ownerRegistrationId",
    "dispatcherRegistrationId",
    "recipientRegistrationId",
    "invoiceTextCode",
    "summaryInvoiceText",
    "invoiceTexts",
    "assistedParameters",
    "taxRuleCurrencyConversionFactors",
    "originalTax",
    "includedTax",
    "nominalRate",
    "markUpRate",
    "accumulateAsLineType"
})
public class TaxesType {

    @XmlElement(name = "Jurisdiction")
    protected TaxesType.Jurisdiction jurisdiction;
    @XmlElement(name = "AccumulateAsJurisdiction")
    protected TaxesType.AccumulateAsJurisdiction accumulateAsJurisdiction;
    @XmlElement(name = "CalculatedTax")
    protected BigDecimal calculatedTax;
    @XmlElement(name = "EffectiveRate")
    protected BigDecimal effectiveRate;
    @XmlElement(name = "TaxApportionmentRate")
    protected BigDecimal taxApportionmentRate;
    @XmlElement(name = "BasisReductionPercentage")
    protected BigDecimal basisReductionPercentage;
    @XmlElement(name = "Exempt")
    protected MeasureType exempt;
    @XmlElement(name = "NonTaxable")
    protected MeasureType nonTaxable;
    @XmlElement(name = "Taxable")
    protected MeasureType taxable;
    @XmlElement(name = "ReportingBasis")
    protected BigDecimal reportingBasis;
    @XmlElement(name = "Imposition")
    protected TaxesType.Imposition imposition;
    @XmlElement(name = "ImpositionType")
    protected ImpositionType impositionType;
    @XmlElement(name = "AccumulateAsImposition")
    protected TaxesType.AccumulateAsImposition accumulateAsImposition;
    @XmlElement(name = "AccumulateAsImpositionType")
    protected AccumulateAsImpositionType accumulateAsImpositionType;
    @XmlElement(name = "TaxRuleId")
    protected RuleType taxRuleId;
    @XmlElement(name = "BasisRuleId")
    protected RuleType basisRuleId;
    @XmlElement(name = "InclusionRuleId")
    protected RuleType inclusionRuleId;
    @XmlElement(name = "MaxTaxRuleId")
    protected RuleType maxTaxRuleId;
    @XmlElement(name = "RecoverableRuleId")
    protected RuleType recoverableRuleId;
    @XmlElement(name = "PostCalculationEvaluationRuleId")
    protected RuleType postCalculationEvaluationRuleId;
    @XmlElement(name = "CreditRuleId")
    protected RuleType creditRuleId;
    @XmlElement(name = "BasisApportionmentRuleId")
    protected RuleType basisApportionmentRuleId;
    @XmlElement(name = "TaxRateAdjustmentRuleId")
    protected RuleType taxRateAdjustmentRuleId;
    @XmlElement(name = "TaxApportionmentRuleId")
    protected RuleType taxApportionmentRuleId;
    @XmlElement(name = "AccumulationRuleId")
    protected RuleType accumulationRuleId;
    @XmlElement(name = "TelecomUnitConversionRuleId")
    protected RuleType telecomUnitConversionRuleId;
    @XmlElement(name = "ReportingBasisRuleId")
    protected RuleType reportingBasisRuleId;
    @XmlElement(name = "CertificateNumber")
    protected TaxesType.CertificateNumber certificateNumber;
    @XmlElement(name = "RecoverableAmount")
    protected BigDecimal recoverableAmount;
    @XmlElement(name = "RecoverablePercent")
    protected BigDecimal recoverablePercent;
    @XmlElement(name = "BlockingRecoverablePercent")
    protected BigDecimal blockingRecoverablePercent;
    @XmlElement(name = "PartialExemptRecoverablePercent")
    protected BigDecimal partialExemptRecoverablePercent;
    @XmlElement(name = "UnrecoverableAmount")
    protected BigDecimal unrecoverableAmount;
    @XmlElement(name = "FilingCurrencyAmounts")
    protected TaxesType.FilingCurrencyAmounts filingCurrencyAmounts;
    @XmlElement(name = "SellerRegistrationId")
    protected String sellerRegistrationId;
    @XmlElement(name = "BuyerRegistrationId")
    protected String buyerRegistrationId;
    @XmlElement(name = "OwnerRegistrationId")
    protected String ownerRegistrationId;
    @XmlElement(name = "DispatcherRegistrationId")
    protected String dispatcherRegistrationId;
    @XmlElement(name = "RecipientRegistrationId")
    protected String recipientRegistrationId;
    @XmlElement(name = "InvoiceTextCode")
    protected List<BigInteger> invoiceTextCode;
    @XmlElement(name = "SummaryInvoiceText")
    protected String summaryInvoiceText;
    @XmlElement(name = "InvoiceTexts")
    protected InvoiceTextsType invoiceTexts;
    @XmlElement(name = "AssistedParameters")
    protected AssistedParametersType assistedParameters;
    @XmlElement(name = "TaxRuleCurrencyConversionFactors")
    protected TaxRuleCurrencyConversionFactors taxRuleCurrencyConversionFactors;
    @XmlElement(name = "OriginalTax")
    protected BigDecimal originalTax;
    @XmlElement(name = "IncludedTax")
    protected BigDecimal includedTax;
    @XmlElement(name = "NominalRate")
    protected BigDecimal nominalRate;
    @XmlElement(name = "MarkUpRate")
    protected BigDecimal markUpRate;
    @XmlElement(name = "AccumulateAsLineType")
    protected TaxesType.AccumulateAsLineType accumulateAsLineType;
    @XmlAttribute(name = "taxResult")
    protected TaxResultCodeType taxResult;
    @XmlAttribute(name = "taxType")
    protected TaxingType taxType;
    @XmlAttribute(name = "maxTaxIndicator")
    protected Boolean maxTaxIndicator;
    @XmlAttribute(name = "situs")
    protected TaxingLocationCodeType situs;
    @XmlAttribute(name = "notRegisteredIndicator")
    protected Boolean notRegisteredIndicator;
    @XmlAttribute(name = "inputOutputType")
    protected InputOutputCodeType inputOutputType;
    @XmlAttribute(name = "taxCode")
    protected String taxCode;
    @XmlAttribute(name = "vertexTaxCode")
    protected String vertexTaxCode;
    @XmlAttribute(name = "reasonCode")
    protected String reasonCode;
    @XmlAttribute(name = "filingCategoryCode")
    protected Integer filingCategoryCode;
    @XmlAttribute(name = "isService")
    protected Boolean isService;
    @XmlAttribute(name = "rateClassification")
    protected String rateClassification;
    @XmlAttribute(name = "taxCollectedFromParty")
    protected TaxCollectedFromPartyType taxCollectedFromParty;
    @XmlAttribute(name = "taxStructure")
    protected TaxStructureCodeType taxStructure;

    /**
     * Gets the value of the jurisdiction property.
     * 
     * @return
     *     possible object is
     *     {@link TaxesType.Jurisdiction }
     *     
     */
    public TaxesType.Jurisdiction getJurisdiction() {
        return jurisdiction;
    }

    /**
     * Sets the value of the jurisdiction property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxesType.Jurisdiction }
     *     
     */
    public void setJurisdiction(TaxesType.Jurisdiction value) {
        this.jurisdiction = value;
    }

    /**
     * Gets the value of the accumulateAsJurisdiction property.
     * 
     * @return
     *     possible object is
     *     {@link TaxesType.AccumulateAsJurisdiction }
     *     
     */
    public TaxesType.AccumulateAsJurisdiction getAccumulateAsJurisdiction() {
        return accumulateAsJurisdiction;
    }

    /**
     * Sets the value of the accumulateAsJurisdiction property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxesType.AccumulateAsJurisdiction }
     *     
     */
    public void setAccumulateAsJurisdiction(TaxesType.AccumulateAsJurisdiction value) {
        this.accumulateAsJurisdiction = value;
    }

    /**
     * Gets the value of the calculatedTax property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCalculatedTax() {
        return calculatedTax;
    }

    /**
     * Sets the value of the calculatedTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCalculatedTax(BigDecimal value) {
        this.calculatedTax = value;
    }

    /**
     * Gets the value of the effectiveRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEffectiveRate() {
        return effectiveRate;
    }

    /**
     * Sets the value of the effectiveRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEffectiveRate(BigDecimal value) {
        this.effectiveRate = value;
    }

    /**
     * Gets the value of the taxApportionmentRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTaxApportionmentRate() {
        return taxApportionmentRate;
    }

    /**
     * Sets the value of the taxApportionmentRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTaxApportionmentRate(BigDecimal value) {
        this.taxApportionmentRate = value;
    }

    /**
     * Gets the value of the basisReductionPercentage property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBasisReductionPercentage() {
        return basisReductionPercentage;
    }

    /**
     * Sets the value of the basisReductionPercentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBasisReductionPercentage(BigDecimal value) {
        this.basisReductionPercentage = value;
    }

    /**
     * Gets the value of the exempt property.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getExempt() {
        return exempt;
    }

    /**
     * Sets the value of the exempt property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setExempt(MeasureType value) {
        this.exempt = value;
    }

    /**
     * Gets the value of the nonTaxable property.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getNonTaxable() {
        return nonTaxable;
    }

    /**
     * Sets the value of the nonTaxable property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setNonTaxable(MeasureType value) {
        this.nonTaxable = value;
    }

    /**
     * Gets the value of the taxable property.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getTaxable() {
        return taxable;
    }

    /**
     * Sets the value of the taxable property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setTaxable(MeasureType value) {
        this.taxable = value;
    }

    /**
     * Gets the value of the reportingBasis property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getReportingBasis() {
        return reportingBasis;
    }

    /**
     * Sets the value of the reportingBasis property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setReportingBasis(BigDecimal value) {
        this.reportingBasis = value;
    }

    /**
     * Gets the value of the imposition property.
     * 
     * @return
     *     possible object is
     *     {@link TaxesType.Imposition }
     *     
     */
    public TaxesType.Imposition getImposition() {
        return imposition;
    }

    /**
     * Sets the value of the imposition property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxesType.Imposition }
     *     
     */
    public void setImposition(TaxesType.Imposition value) {
        this.imposition = value;
    }

    /**
     * Gets the value of the impositionType property.
     * 
     * @return
     *     possible object is
     *     {@link ImpositionType }
     *     
     */
    public ImpositionType getImpositionType() {
        return impositionType;
    }

    /**
     * Sets the value of the impositionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImpositionType }
     *     
     */
    public void setImpositionType(ImpositionType value) {
        this.impositionType = value;
    }

    /**
     * Gets the value of the accumulateAsImposition property.
     * 
     * @return
     *     possible object is
     *     {@link TaxesType.AccumulateAsImposition }
     *     
     */
    public TaxesType.AccumulateAsImposition getAccumulateAsImposition() {
        return accumulateAsImposition;
    }

    /**
     * Sets the value of the accumulateAsImposition property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxesType.AccumulateAsImposition }
     *     
     */
    public void setAccumulateAsImposition(TaxesType.AccumulateAsImposition value) {
        this.accumulateAsImposition = value;
    }

    /**
     * Gets the value of the accumulateAsImpositionType property.
     * 
     * @return
     *     possible object is
     *     {@link AccumulateAsImpositionType }
     *     
     */
    public AccumulateAsImpositionType getAccumulateAsImpositionType() {
        return accumulateAsImpositionType;
    }

    /**
     * Sets the value of the accumulateAsImpositionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccumulateAsImpositionType }
     *     
     */
    public void setAccumulateAsImpositionType(AccumulateAsImpositionType value) {
        this.accumulateAsImpositionType = value;
    }

    /**
     * Gets the value of the taxRuleId property.
     * 
     * @return
     *     possible object is
     *     {@link RuleType }
     *     
     */
    public RuleType getTaxRuleId() {
        return taxRuleId;
    }

    /**
     * Sets the value of the taxRuleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link RuleType }
     *     
     */
    public void setTaxRuleId(RuleType value) {
        this.taxRuleId = value;
    }

    /**
     * Gets the value of the basisRuleId property.
     * 
     * @return
     *     possible object is
     *     {@link RuleType }
     *     
     */
    public RuleType getBasisRuleId() {
        return basisRuleId;
    }

    /**
     * Sets the value of the basisRuleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link RuleType }
     *     
     */
    public void setBasisRuleId(RuleType value) {
        this.basisRuleId = value;
    }

    /**
     * Gets the value of the inclusionRuleId property.
     * 
     * @return
     *     possible object is
     *     {@link RuleType }
     *     
     */
    public RuleType getInclusionRuleId() {
        return inclusionRuleId;
    }

    /**
     * Sets the value of the inclusionRuleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link RuleType }
     *     
     */
    public void setInclusionRuleId(RuleType value) {
        this.inclusionRuleId = value;
    }

    /**
     * Gets the value of the maxTaxRuleId property.
     * 
     * @return
     *     possible object is
     *     {@link RuleType }
     *     
     */
    public RuleType getMaxTaxRuleId() {
        return maxTaxRuleId;
    }

    /**
     * Sets the value of the maxTaxRuleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link RuleType }
     *     
     */
    public void setMaxTaxRuleId(RuleType value) {
        this.maxTaxRuleId = value;
    }

    /**
     * Gets the value of the recoverableRuleId property.
     * 
     * @return
     *     possible object is
     *     {@link RuleType }
     *     
     */
    public RuleType getRecoverableRuleId() {
        return recoverableRuleId;
    }

    /**
     * Sets the value of the recoverableRuleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link RuleType }
     *     
     */
    public void setRecoverableRuleId(RuleType value) {
        this.recoverableRuleId = value;
    }

    /**
     * Gets the value of the postCalculationEvaluationRuleId property.
     * 
     * @return
     *     possible object is
     *     {@link RuleType }
     *     
     */
    public RuleType getPostCalculationEvaluationRuleId() {
        return postCalculationEvaluationRuleId;
    }

    /**
     * Sets the value of the postCalculationEvaluationRuleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link RuleType }
     *     
     */
    public void setPostCalculationEvaluationRuleId(RuleType value) {
        this.postCalculationEvaluationRuleId = value;
    }

    /**
     * Gets the value of the creditRuleId property.
     * 
     * @return
     *     possible object is
     *     {@link RuleType }
     *     
     */
    public RuleType getCreditRuleId() {
        return creditRuleId;
    }

    /**
     * Sets the value of the creditRuleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link RuleType }
     *     
     */
    public void setCreditRuleId(RuleType value) {
        this.creditRuleId = value;
    }

    /**
     * Gets the value of the basisApportionmentRuleId property.
     * 
     * @return
     *     possible object is
     *     {@link RuleType }
     *     
     */
    public RuleType getBasisApportionmentRuleId() {
        return basisApportionmentRuleId;
    }

    /**
     * Sets the value of the basisApportionmentRuleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link RuleType }
     *     
     */
    public void setBasisApportionmentRuleId(RuleType value) {
        this.basisApportionmentRuleId = value;
    }

    /**
     * Gets the value of the taxRateAdjustmentRuleId property.
     * 
     * @return
     *     possible object is
     *     {@link RuleType }
     *     
     */
    public RuleType getTaxRateAdjustmentRuleId() {
        return taxRateAdjustmentRuleId;
    }

    /**
     * Sets the value of the taxRateAdjustmentRuleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link RuleType }
     *     
     */
    public void setTaxRateAdjustmentRuleId(RuleType value) {
        this.taxRateAdjustmentRuleId = value;
    }

    /**
     * Gets the value of the taxApportionmentRuleId property.
     * 
     * @return
     *     possible object is
     *     {@link RuleType }
     *     
     */
    public RuleType getTaxApportionmentRuleId() {
        return taxApportionmentRuleId;
    }

    /**
     * Sets the value of the taxApportionmentRuleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link RuleType }
     *     
     */
    public void setTaxApportionmentRuleId(RuleType value) {
        this.taxApportionmentRuleId = value;
    }

    /**
     * Gets the value of the accumulationRuleId property.
     * 
     * @return
     *     possible object is
     *     {@link RuleType }
     *     
     */
    public RuleType getAccumulationRuleId() {
        return accumulationRuleId;
    }

    /**
     * Sets the value of the accumulationRuleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link RuleType }
     *     
     */
    public void setAccumulationRuleId(RuleType value) {
        this.accumulationRuleId = value;
    }

    /**
     * Gets the value of the telecomUnitConversionRuleId property.
     * 
     * @return
     *     possible object is
     *     {@link RuleType }
     *     
     */
    public RuleType getTelecomUnitConversionRuleId() {
        return telecomUnitConversionRuleId;
    }

    /**
     * Sets the value of the telecomUnitConversionRuleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link RuleType }
     *     
     */
    public void setTelecomUnitConversionRuleId(RuleType value) {
        this.telecomUnitConversionRuleId = value;
    }

    /**
     * Gets the value of the reportingBasisRuleId property.
     * 
     * @return
     *     possible object is
     *     {@link RuleType }
     *     
     */
    public RuleType getReportingBasisRuleId() {
        return reportingBasisRuleId;
    }

    /**
     * Sets the value of the reportingBasisRuleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link RuleType }
     *     
     */
    public void setReportingBasisRuleId(RuleType value) {
        this.reportingBasisRuleId = value;
    }

    /**
     * Gets the value of the certificateNumber property.
     * 
     * @return
     *     possible object is
     *     {@link TaxesType.CertificateNumber }
     *     
     */
    public TaxesType.CertificateNumber getCertificateNumber() {
        return certificateNumber;
    }

    /**
     * Sets the value of the certificateNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxesType.CertificateNumber }
     *     
     */
    public void setCertificateNumber(TaxesType.CertificateNumber value) {
        this.certificateNumber = value;
    }

    /**
     * Gets the value of the recoverableAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRecoverableAmount() {
        return recoverableAmount;
    }

    /**
     * Sets the value of the recoverableAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRecoverableAmount(BigDecimal value) {
        this.recoverableAmount = value;
    }

    /**
     * Gets the value of the recoverablePercent property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRecoverablePercent() {
        return recoverablePercent;
    }

    /**
     * Sets the value of the recoverablePercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRecoverablePercent(BigDecimal value) {
        this.recoverablePercent = value;
    }

    /**
     * Gets the value of the blockingRecoverablePercent property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBlockingRecoverablePercent() {
        return blockingRecoverablePercent;
    }

    /**
     * Sets the value of the blockingRecoverablePercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBlockingRecoverablePercent(BigDecimal value) {
        this.blockingRecoverablePercent = value;
    }

    /**
     * Gets the value of the partialExemptRecoverablePercent property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPartialExemptRecoverablePercent() {
        return partialExemptRecoverablePercent;
    }

    /**
     * Sets the value of the partialExemptRecoverablePercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPartialExemptRecoverablePercent(BigDecimal value) {
        this.partialExemptRecoverablePercent = value;
    }

    /**
     * Gets the value of the unrecoverableAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUnrecoverableAmount() {
        return unrecoverableAmount;
    }

    /**
     * Sets the value of the unrecoverableAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUnrecoverableAmount(BigDecimal value) {
        this.unrecoverableAmount = value;
    }

    /**
     * Gets the value of the filingCurrencyAmounts property.
     * 
     * @return
     *     possible object is
     *     {@link TaxesType.FilingCurrencyAmounts }
     *     
     */
    public TaxesType.FilingCurrencyAmounts getFilingCurrencyAmounts() {
        return filingCurrencyAmounts;
    }

    /**
     * Sets the value of the filingCurrencyAmounts property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxesType.FilingCurrencyAmounts }
     *     
     */
    public void setFilingCurrencyAmounts(TaxesType.FilingCurrencyAmounts value) {
        this.filingCurrencyAmounts = value;
    }

    /**
     * Gets the value of the sellerRegistrationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSellerRegistrationId() {
        return sellerRegistrationId;
    }

    /**
     * Sets the value of the sellerRegistrationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSellerRegistrationId(String value) {
        this.sellerRegistrationId = value;
    }

    /**
     * Gets the value of the buyerRegistrationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuyerRegistrationId() {
        return buyerRegistrationId;
    }

    /**
     * Sets the value of the buyerRegistrationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuyerRegistrationId(String value) {
        this.buyerRegistrationId = value;
    }

    /**
     * Gets the value of the ownerRegistrationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerRegistrationId() {
        return ownerRegistrationId;
    }

    /**
     * Sets the value of the ownerRegistrationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerRegistrationId(String value) {
        this.ownerRegistrationId = value;
    }

    /**
     * Gets the value of the dispatcherRegistrationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDispatcherRegistrationId() {
        return dispatcherRegistrationId;
    }

    /**
     * Sets the value of the dispatcherRegistrationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDispatcherRegistrationId(String value) {
        this.dispatcherRegistrationId = value;
    }

    /**
     * Gets the value of the recipientRegistrationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipientRegistrationId() {
        return recipientRegistrationId;
    }

    /**
     * Sets the value of the recipientRegistrationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipientRegistrationId(String value) {
        this.recipientRegistrationId = value;
    }

    /**
     * Gets the value of the invoiceTextCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the invoiceTextCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInvoiceTextCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BigInteger }
     * 
     * 
     */
    public List<BigInteger> getInvoiceTextCode() {
        if (invoiceTextCode == null) {
            invoiceTextCode = new ArrayList<BigInteger>();
        }
        return this.invoiceTextCode;
    }

    /**
     * Gets the value of the summaryInvoiceText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSummaryInvoiceText() {
        return summaryInvoiceText;
    }

    /**
     * Sets the value of the summaryInvoiceText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSummaryInvoiceText(String value) {
        this.summaryInvoiceText = value;
    }

    /**
     * Gets the value of the invoiceTexts property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceTextsType }
     *     
     */
    public InvoiceTextsType getInvoiceTexts() {
        return invoiceTexts;
    }

    /**
     * Sets the value of the invoiceTexts property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceTextsType }
     *     
     */
    public void setInvoiceTexts(InvoiceTextsType value) {
        this.invoiceTexts = value;
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
     * Gets the value of the taxRuleCurrencyConversionFactors property.
     * 
     * @return
     *     possible object is
     *     {@link TaxRuleCurrencyConversionFactors }
     *     
     */
    public TaxRuleCurrencyConversionFactors getTaxRuleCurrencyConversionFactors() {
        return taxRuleCurrencyConversionFactors;
    }

    /**
     * Sets the value of the taxRuleCurrencyConversionFactors property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxRuleCurrencyConversionFactors }
     *     
     */
    public void setTaxRuleCurrencyConversionFactors(TaxRuleCurrencyConversionFactors value) {
        this.taxRuleCurrencyConversionFactors = value;
    }

    /**
     * Gets the value of the originalTax property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOriginalTax() {
        return originalTax;
    }

    /**
     * Sets the value of the originalTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOriginalTax(BigDecimal value) {
        this.originalTax = value;
    }

    /**
     * Gets the value of the includedTax property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIncludedTax() {
        return includedTax;
    }

    /**
     * Sets the value of the includedTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIncludedTax(BigDecimal value) {
        this.includedTax = value;
    }

    /**
     * Gets the value of the nominalRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNominalRate() {
        return nominalRate;
    }

    /**
     * Sets the value of the nominalRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNominalRate(BigDecimal value) {
        this.nominalRate = value;
    }

    /**
     * Gets the value of the markUpRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMarkUpRate() {
        return markUpRate;
    }

    /**
     * Sets the value of the markUpRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMarkUpRate(BigDecimal value) {
        this.markUpRate = value;
    }

    /**
     * Gets the value of the accumulateAsLineType property.
     * 
     * @return
     *     possible object is
     *     {@link TaxesType.AccumulateAsLineType }
     *     
     */
    public TaxesType.AccumulateAsLineType getAccumulateAsLineType() {
        return accumulateAsLineType;
    }

    /**
     * Sets the value of the accumulateAsLineType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxesType.AccumulateAsLineType }
     *     
     */
    public void setAccumulateAsLineType(TaxesType.AccumulateAsLineType value) {
        this.accumulateAsLineType = value;
    }

    /**
     * Gets the value of the taxResult property.
     * 
     * @return
     *     possible object is
     *     {@link TaxResultCodeType }
     *     
     */
    public TaxResultCodeType getTaxResult() {
        return taxResult;
    }

    /**
     * Sets the value of the taxResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxResultCodeType }
     *     
     */
    public void setTaxResult(TaxResultCodeType value) {
        this.taxResult = value;
    }

    /**
     * Gets the value of the taxType property.
     * 
     * @return
     *     possible object is
     *     {@link TaxingType }
     *     
     */
    public TaxingType getTaxType() {
        return taxType;
    }

    /**
     * Sets the value of the taxType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxingType }
     *     
     */
    public void setTaxType(TaxingType value) {
        this.taxType = value;
    }

    /**
     * Gets the value of the maxTaxIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMaxTaxIndicator() {
        return maxTaxIndicator;
    }

    /**
     * Sets the value of the maxTaxIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMaxTaxIndicator(Boolean value) {
        this.maxTaxIndicator = value;
    }

    /**
     * Gets the value of the situs property.
     * 
     * @return
     *     possible object is
     *     {@link TaxingLocationCodeType }
     *     
     */
    public TaxingLocationCodeType getSitus() {
        return situs;
    }

    /**
     * Sets the value of the situs property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxingLocationCodeType }
     *     
     */
    public void setSitus(TaxingLocationCodeType value) {
        this.situs = value;
    }

    /**
     * Gets the value of the notRegisteredIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNotRegisteredIndicator() {
        return notRegisteredIndicator;
    }

    /**
     * Sets the value of the notRegisteredIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNotRegisteredIndicator(Boolean value) {
        this.notRegisteredIndicator = value;
    }

    /**
     * Gets the value of the inputOutputType property.
     * 
     * @return
     *     possible object is
     *     {@link InputOutputCodeType }
     *     
     */
    public InputOutputCodeType getInputOutputType() {
        return inputOutputType;
    }

    /**
     * Sets the value of the inputOutputType property.
     * 
     * @param value
     *     allowed object is
     *     {@link InputOutputCodeType }
     *     
     */
    public void setInputOutputType(InputOutputCodeType value) {
        this.inputOutputType = value;
    }

    /**
     * Gets the value of the taxCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxCode() {
        return taxCode;
    }

    /**
     * Sets the value of the taxCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxCode(String value) {
        this.taxCode = value;
    }

    /**
     * Gets the value of the vertexTaxCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVertexTaxCode() {
        return vertexTaxCode;
    }

    /**
     * Sets the value of the vertexTaxCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVertexTaxCode(String value) {
        this.vertexTaxCode = value;
    }

    /**
     * Gets the value of the reasonCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReasonCode() {
        return reasonCode;
    }

    /**
     * Sets the value of the reasonCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReasonCode(String value) {
        this.reasonCode = value;
    }

    /**
     * Gets the value of the filingCategoryCode property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFilingCategoryCode() {
        return filingCategoryCode;
    }

    /**
     * Sets the value of the filingCategoryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFilingCategoryCode(Integer value) {
        this.filingCategoryCode = value;
    }

    /**
     * Gets the value of the isService property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsService() {
        return isService;
    }

    /**
     * Sets the value of the isService property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsService(Boolean value) {
        this.isService = value;
    }

    /**
     * Gets the value of the rateClassification property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRateClassification() {
        return rateClassification;
    }

    /**
     * Sets the value of the rateClassification property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRateClassification(String value) {
        this.rateClassification = value;
    }

    /**
     * Gets the value of the taxCollectedFromParty property.
     * 
     * @return
     *     possible object is
     *     {@link TaxCollectedFromPartyType }
     *     
     */
    public TaxCollectedFromPartyType getTaxCollectedFromParty() {
        return taxCollectedFromParty;
    }

    /**
     * Sets the value of the taxCollectedFromParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxCollectedFromPartyType }
     *     
     */
    public void setTaxCollectedFromParty(TaxCollectedFromPartyType value) {
        this.taxCollectedFromParty = value;
    }

    /**
     * Gets the value of the taxStructure property.
     * 
     * @return
     *     possible object is
     *     {@link TaxStructureCodeType }
     *     
     */
    public TaxStructureCodeType getTaxStructure() {
        return taxStructure;
    }

    /**
     * Sets the value of the taxStructure property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxStructureCodeType }
     *     
     */
    public void setTaxStructure(TaxStructureCodeType value) {
        this.taxStructure = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="userDefined" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="impositionId" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
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
    public static class AccumulateAsImposition {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "userDefined")
        protected Boolean userDefined;
        @XmlAttribute(name = "impositionId")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger impositionId;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the userDefined property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isUserDefined() {
            return userDefined;
        }

        /**
         * Sets the value of the userDefined property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setUserDefined(Boolean value) {
            this.userDefined = value;
        }

        /**
         * Gets the value of the impositionId property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getImpositionId() {
            return impositionId;
        }

        /**
         * Sets the value of the impositionId property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setImpositionId(BigInteger value) {
            this.impositionId = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;urn:vertexinc:o-series:tps:9:0>JurisdictionType">
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class AccumulateAsJurisdiction
        extends JurisdictionType
    {


    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="userDefined" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
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
    public static class AccumulateAsLineType {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "userDefined")
        protected Boolean userDefined;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the userDefined property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isUserDefined() {
            if (userDefined == null) {
                return false;
            } else {
                return userDefined;
            }
        }

        /**
         * Sets the value of the userDefined property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setUserDefined(Boolean value) {
            this.userDefined = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="certificateType" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    public static class CertificateNumber {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "certificateType")
        protected String certificateType;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the certificateType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCertificateType() {
            return certificateType;
        }

        /**
         * Sets the value of the certificateType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCertificateType(String value) {
            this.certificateType = value;
        }

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
     *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}CurrencyConversion"/>
     *         &lt;element name="FilingCalculatedTax" type="{urn:vertexinc:o-series:tps:9:0}AmountType" minOccurs="0"/>
     *         &lt;element name="FilingExempt" type="{urn:vertexinc:o-series:tps:9:0}AmountType" minOccurs="0"/>
     *         &lt;element name="FilingNonTaxable" type="{urn:vertexinc:o-series:tps:9:0}AmountType" minOccurs="0"/>
     *         &lt;element name="FilingTaxable" type="{urn:vertexinc:o-series:tps:9:0}AmountType" minOccurs="0"/>
     *         &lt;element name="FilingRecoverableAmount" type="{urn:vertexinc:o-series:tps:9:0}AmountType" minOccurs="0"/>
     *         &lt;element name="FilingUnrecoverableAmount" type="{urn:vertexinc:o-series:tps:9:0}AmountType" minOccurs="0"/>
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
        "currencyConversion",
        "filingCalculatedTax",
        "filingExempt",
        "filingNonTaxable",
        "filingTaxable",
        "filingRecoverableAmount",
        "filingUnrecoverableAmount"
    })
    public static class FilingCurrencyAmounts {

        @XmlElement(name = "CurrencyConversion", required = true)
        protected CurrencyConversion currencyConversion;
        @XmlElement(name = "FilingCalculatedTax")
        protected BigDecimal filingCalculatedTax;
        @XmlElement(name = "FilingExempt")
        protected BigDecimal filingExempt;
        @XmlElement(name = "FilingNonTaxable")
        protected BigDecimal filingNonTaxable;
        @XmlElement(name = "FilingTaxable")
        protected BigDecimal filingTaxable;
        @XmlElement(name = "FilingRecoverableAmount")
        protected BigDecimal filingRecoverableAmount;
        @XmlElement(name = "FilingUnrecoverableAmount")
        protected BigDecimal filingUnrecoverableAmount;

        /**
         * Gets the value of the currencyConversion property.
         * 
         * @return
         *     possible object is
         *     {@link CurrencyConversion }
         *     
         */
        public CurrencyConversion getCurrencyConversion() {
            return currencyConversion;
        }

        /**
         * Sets the value of the currencyConversion property.
         * 
         * @param value
         *     allowed object is
         *     {@link CurrencyConversion }
         *     
         */
        public void setCurrencyConversion(CurrencyConversion value) {
            this.currencyConversion = value;
        }

        /**
         * Gets the value of the filingCalculatedTax property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFilingCalculatedTax() {
            return filingCalculatedTax;
        }

        /**
         * Sets the value of the filingCalculatedTax property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFilingCalculatedTax(BigDecimal value) {
            this.filingCalculatedTax = value;
        }

        /**
         * Gets the value of the filingExempt property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFilingExempt() {
            return filingExempt;
        }

        /**
         * Sets the value of the filingExempt property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFilingExempt(BigDecimal value) {
            this.filingExempt = value;
        }

        /**
         * Gets the value of the filingNonTaxable property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFilingNonTaxable() {
            return filingNonTaxable;
        }

        /**
         * Sets the value of the filingNonTaxable property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFilingNonTaxable(BigDecimal value) {
            this.filingNonTaxable = value;
        }

        /**
         * Gets the value of the filingTaxable property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFilingTaxable() {
            return filingTaxable;
        }

        /**
         * Sets the value of the filingTaxable property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFilingTaxable(BigDecimal value) {
            this.filingTaxable = value;
        }

        /**
         * Gets the value of the filingRecoverableAmount property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFilingRecoverableAmount() {
            return filingRecoverableAmount;
        }

        /**
         * Sets the value of the filingRecoverableAmount property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFilingRecoverableAmount(BigDecimal value) {
            this.filingRecoverableAmount = value;
        }

        /**
         * Gets the value of the filingUnrecoverableAmount property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFilingUnrecoverableAmount() {
            return filingUnrecoverableAmount;
        }

        /**
         * Sets the value of the filingUnrecoverableAmount property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFilingUnrecoverableAmount(BigDecimal value) {
            this.filingUnrecoverableAmount = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="userDefined" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="impositionId" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
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
    public static class Imposition {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "userDefined")
        protected Boolean userDefined;
        @XmlAttribute(name = "impositionId")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger impositionId;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the userDefined property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isUserDefined() {
            return userDefined;
        }

        /**
         * Sets the value of the userDefined property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setUserDefined(Boolean value) {
            this.userDefined = value;
        }

        /**
         * Gets the value of the impositionId property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getImpositionId() {
            return impositionId;
        }

        /**
         * Sets the value of the impositionId property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setImpositionId(BigInteger value) {
            this.impositionId = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;urn:vertexinc:o-series:tps:9:0>JurisdictionType">
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Jurisdiction
        extends JurisdictionType
    {


    }

}
