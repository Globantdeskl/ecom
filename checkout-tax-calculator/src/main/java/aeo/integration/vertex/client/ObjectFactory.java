
package aeo.integration.vertex.client;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the aeo.integration.vertex.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AdditionalTaxesDue_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "AdditionalTaxesDue");
    private final static QName _OriginalCurrency_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "OriginalCurrency");
    private final static QName _Destination_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "Destination");
    private final static QName _StatisticalValue_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "StatisticalValue");
    private final static QName _CompanyCodeCurrency_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "CompanyCodeCurrency");
    private final static QName _AssistedParameters_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "AssistedParameters");
    private final static QName _WageBasis_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "WageBasis");
    private final static QName _JurisdictionLevel_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "JurisdictionLevel");
    private final static QName _ProratePercentage_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "ProratePercentage");
    private final static QName _SpecialTaxBasis_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "SpecialTaxBasis");
    private final static QName _AdministrativeOrigin_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "AdministrativeOrigin");
    private final static QName _Cost_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "Cost");
    private final static QName _SubTotal_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "SubTotal");
    private final static QName _PreviousTaxPaid_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "PreviousTaxPaid");
    private final static QName _DeliveryTerm_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "DeliveryTerm");
    private final static QName _SupplementaryUnit_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "SupplementaryUnit");
    private final static QName _ExtendedPrice_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "ExtendedPrice");
    private final static QName _InputTotalTax_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "InputTotalTax");
    private final static QName _TotalTax_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "TotalTax");
    private final static QName _Currency_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "Currency");
    private final static QName _InvoiceTexts_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "InvoiceTexts");
    private final static QName _InvoiceTextCode_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "InvoiceTextCode");
    private final static QName _Freight_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "Freight");
    private final static QName _ChargedTax_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "ChargedTax");
    private final static QName _TimePeriod_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "TimePeriod");
    private final static QName _TaxRegistration_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "TaxRegistration");
    private final static QName _CustomerCode_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "CustomerCode");
    private final static QName _Coordinates_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "Coordinates");
    private final static QName _Amount_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "Amount");
    private final static QName _Quantity_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "Quantity");
    private final static QName _DateTimePeriod_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "DateTimePeriod");
    private final static QName _Weight_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "Weight");
    private final static QName _AdministrativeDestination_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "AdministrativeDestination");
    private final static QName _PostalAddress_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "PostalAddress");
    private final static QName _PhysicalOrigin_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "PhysicalOrigin");
    private final static QName _LandedCost_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "LandedCost");
    private final static QName _UnitPrice_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "UnitPrice");
    private final static QName _InputAmount_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "InputAmount");
    private final static QName _TaxingLocation_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "TaxingLocation");
    private final static QName _Taxes_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "Taxes");
    private final static QName _Volume_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "Volume");
    private final static QName _FairMarketValue_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "FairMarketValue");
    private final static QName _Total_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "Total");
    private final static QName _DatePeriod_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "DatePeriod");
    private final static QName _AmountBilledToDate_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "AmountBilledToDate");
    private final static QName _RecipientCode_QNAME = new QName("urn:vertexinc:o-series:tps:9:0", "RecipientCode");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: aeo.integration.vertex.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link VertexEnvelope }
     * 
     */
    public VertexEnvelope createVertexEnvelope() {
        return new VertexEnvelope();
    }

    /**
     * Create an instance of {@link DeductionOverride }
     * 
     */
    public DeductionOverride createDeductionOverride() {
        return new DeductionOverride();
    }

    /**
     * Create an instance of {@link FlexibleFields }
     * 
     */
    public FlexibleFields createFlexibleFields() {
        return new FlexibleFields();
    }

    /**
     * Create an instance of {@link InputTax }
     * 
     */
    public InputTax createInputTax() {
        return new InputTax();
    }

    /**
     * Create an instance of {@link ReturnsFields }
     * 
     */
    public ReturnsFields createReturnsFields() {
        return new ReturnsFields();
    }

    /**
     * Create an instance of {@link TaxAreaLookupType }
     * 
     */
    public TaxAreaLookupType createTaxAreaLookupType() {
        return new TaxAreaLookupType();
    }

    /**
     * Create an instance of {@link TaxAreaResultType }
     * 
     */
    public TaxAreaResultType createTaxAreaResultType() {
        return new TaxAreaResultType();
    }

    /**
     * Create an instance of {@link TaxAreaLookupResultType }
     * 
     */
    public TaxAreaLookupResultType createTaxAreaLookupResultType() {
        return new TaxAreaLookupResultType();
    }

    /**
     * Create an instance of {@link InvoiceTextsType }
     * 
     */
    public InvoiceTextsType createInvoiceTextsType() {
        return new InvoiceTextsType();
    }

    /**
     * Create an instance of {@link TaxesType }
     * 
     */
    public TaxesType createTaxesType() {
        return new TaxesType();
    }

    /**
     * Create an instance of {@link TaxRegistrationType }
     * 
     */
    public TaxRegistrationType createTaxRegistrationType() {
        return new TaxRegistrationType();
    }

    /**
     * Create an instance of {@link VertexEnvelope.ApplicationData }
     * 
     */
    public VertexEnvelope.ApplicationData createVertexEnvelopeApplicationData() {
        return new VertexEnvelope.ApplicationData();
    }

    /**
     * Create an instance of {@link VertexEnvelope.ApplicationData.MessageLogging }
     * 
     */
    public VertexEnvelope.ApplicationData.MessageLogging createVertexEnvelopeApplicationDataMessageLogging() {
        return new VertexEnvelope.ApplicationData.MessageLogging();
    }

    /**
     * Create an instance of {@link VersionResponseType }
     * 
     */
    public VersionResponseType createVersionResponseType() {
        return new VersionResponseType();
    }

    /**
     * Create an instance of {@link VersionResponseType.SettingsOverrides }
     * 
     */
    public VersionResponseType.SettingsOverrides createVersionResponseTypeSettingsOverrides() {
        return new VersionResponseType.SettingsOverrides();
    }

    /**
     * Create an instance of {@link VersionResponseType.ConfigFileOverrides }
     * 
     */
    public VersionResponseType.ConfigFileOverrides createVersionResponseTypeConfigFileOverrides() {
        return new VersionResponseType.ConfigFileOverrides();
    }

    /**
     * Create an instance of {@link VersionResponseType.DataManagementActivities }
     * 
     */
    public VersionResponseType.DataManagementActivities createVersionResponseTypeDataManagementActivities() {
        return new VersionResponseType.DataManagementActivities();
    }

    /**
     * Create an instance of {@link VersionResponseType.ServerInformation }
     * 
     */
    public VersionResponseType.ServerInformation createVersionResponseTypeServerInformation() {
        return new VersionResponseType.ServerInformation();
    }

    /**
     * Create an instance of {@link VersionResponseType.DatabaseVersions }
     * 
     */
    public VersionResponseType.DatabaseVersions createVersionResponseTypeDatabaseVersions() {
        return new VersionResponseType.DatabaseVersions();
    }

    /**
     * Create an instance of {@link VersionResponseType.DatabaseVersions.DatabaseVersion }
     * 
     */
    public VersionResponseType.DatabaseVersions.DatabaseVersion createVersionResponseTypeDatabaseVersionsDatabaseVersion() {
        return new VersionResponseType.DatabaseVersions.DatabaseVersion();
    }

    /**
     * Create an instance of {@link VersionResponseType.DatabaseVersions.DatabaseVersion.DataContentVersions }
     * 
     */
    public VersionResponseType.DatabaseVersions.DatabaseVersion.DataContentVersions createVersionResponseTypeDatabaseVersionsDatabaseVersionDataContentVersions() {
        return new VersionResponseType.DatabaseVersions.DatabaseVersion.DataContentVersions();
    }

    /**
     * Create an instance of {@link VersionResponseType.LibraryVersions }
     * 
     */
    public VersionResponseType.LibraryVersions createVersionResponseTypeLibraryVersions() {
        return new VersionResponseType.LibraryVersions();
    }

    /**
     * Create an instance of {@link VersionResponseType.ProductVersions }
     * 
     */
    public VersionResponseType.ProductVersions createVersionResponseTypeProductVersions() {
        return new VersionResponseType.ProductVersions();
    }

    /**
     * Create an instance of {@link IsTaxAreaChangedRequestType }
     * 
     */
    public IsTaxAreaChangedRequestType createIsTaxAreaChangedRequestType() {
        return new IsTaxAreaChangedRequestType();
    }

    /**
     * Create an instance of {@link FindChangedTaxAreaIdsRequestType }
     * 
     */
    public FindChangedTaxAreaIdsRequestType createFindChangedTaxAreaIdsRequestType() {
        return new FindChangedTaxAreaIdsRequestType();
    }

    /**
     * Create an instance of {@link BuyerInputTaxRequestType }
     * 
     */
    public BuyerInputTaxRequestType createBuyerInputTaxRequestType() {
        return new BuyerInputTaxRequestType();
    }

    /**
     * Create an instance of {@link AssetMovementRequestType }
     * 
     */
    public AssetMovementRequestType createAssetMovementRequestType() {
        return new AssetMovementRequestType();
    }

    /**
     * Create an instance of {@link AccrualSyncResponseType }
     * 
     */
    public AccrualSyncResponseType createAccrualSyncResponseType() {
        return new AccrualSyncResponseType();
    }

    /**
     * Create an instance of {@link AssistedParametersType }
     * 
     */
    public AssistedParametersType createAssistedParametersType() {
        return new AssistedParametersType();
    }

    /**
     * Create an instance of {@link AccumulateAsImpositionType }
     * 
     */
    public AccumulateAsImpositionType createAccumulateAsImpositionType() {
        return new AccumulateAsImpositionType();
    }

    /**
     * Create an instance of {@link CurrencyConversion }
     * 
     */
    public CurrencyConversion createCurrencyConversion() {
        return new CurrencyConversion();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link LocationType }
     * 
     */
    public LocationType createLocationType() {
        return new LocationType();
    }

    /**
     * Create an instance of {@link LoginType }
     * 
     */
    public LoginType createLoginType() {
        return new LoginType();
    }

    /**
     * Create an instance of {@link AccrualRequestType }
     * 
     */
    public AccrualRequestType createAccrualRequestType() {
        return new AccrualRequestType();
    }

    /**
     * Create an instance of {@link AccrualResponseType }
     * 
     */
    public AccrualResponseType createAccrualResponseType() {
        return new AccrualResponseType();
    }

    /**
     * Create an instance of {@link AccrualSyncRequestType }
     * 
     */
    public AccrualSyncRequestType createAccrualSyncRequestType() {
        return new AccrualSyncRequestType();
    }

    /**
     * Create an instance of {@link APInvoiceSyncRequestType }
     * 
     */
    public APInvoiceSyncRequestType createAPInvoiceSyncRequestType() {
        return new APInvoiceSyncRequestType();
    }

    /**
     * Create an instance of {@link APInvoiceSyncResponseType }
     * 
     */
    public APInvoiceSyncResponseType createAPInvoiceSyncResponseType() {
        return new APInvoiceSyncResponseType();
    }

    /**
     * Create an instance of {@link ARBillingSyncRequestType }
     * 
     */
    public ARBillingSyncRequestType createARBillingSyncRequestType() {
        return new ARBillingSyncRequestType();
    }

    /**
     * Create an instance of {@link ARBillingSyncResponseType }
     * 
     */
    public ARBillingSyncResponseType createARBillingSyncResponseType() {
        return new ARBillingSyncResponseType();
    }

    /**
     * Create an instance of {@link AssetMovementResponseType }
     * 
     */
    public AssetMovementResponseType createAssetMovementResponseType() {
        return new AssetMovementResponseType();
    }

    /**
     * Create an instance of {@link BuyerInputTaxResponseType }
     * 
     */
    public BuyerInputTaxResponseType createBuyerInputTaxResponseType() {
        return new BuyerInputTaxResponseType();
    }

    /**
     * Create an instance of {@link DeleteRequestType }
     * 
     */
    public DeleteRequestType createDeleteRequestType() {
        return new DeleteRequestType();
    }

    /**
     * Create an instance of {@link DeleteResponseType }
     * 
     */
    public DeleteResponseType createDeleteResponseType() {
        return new DeleteResponseType();
    }

    /**
     * Create an instance of {@link DistributeTaxProcurementRequestType }
     * 
     */
    public DistributeTaxProcurementRequestType createDistributeTaxProcurementRequestType() {
        return new DistributeTaxProcurementRequestType();
    }

    /**
     * Create an instance of {@link DistributeTaxProcurementResponseType }
     * 
     */
    public DistributeTaxProcurementResponseType createDistributeTaxProcurementResponseType() {
        return new DistributeTaxProcurementResponseType();
    }

    /**
     * Create an instance of {@link DistributeTaxRequestType }
     * 
     */
    public DistributeTaxRequestType createDistributeTaxRequestType() {
        return new DistributeTaxRequestType();
    }

    /**
     * Create an instance of {@link DistributeTaxResponseType }
     * 
     */
    public DistributeTaxResponseType createDistributeTaxResponseType() {
        return new DistributeTaxResponseType();
    }

    /**
     * Create an instance of {@link ERSRequestType }
     * 
     */
    public ERSRequestType createERSRequestType() {
        return new ERSRequestType();
    }

    /**
     * Create an instance of {@link ERSResponseType }
     * 
     */
    public ERSResponseType createERSResponseType() {
        return new ERSResponseType();
    }

    /**
     * Create an instance of {@link InventoryRemovalRequestType }
     * 
     */
    public InventoryRemovalRequestType createInventoryRemovalRequestType() {
        return new InventoryRemovalRequestType();
    }

    /**
     * Create an instance of {@link InventoryRemovalResponseType }
     * 
     */
    public InventoryRemovalResponseType createInventoryRemovalResponseType() {
        return new InventoryRemovalResponseType();
    }

    /**
     * Create an instance of {@link InvoiceRequestType }
     * 
     */
    public InvoiceRequestType createInvoiceRequestType() {
        return new InvoiceRequestType();
    }

    /**
     * Create an instance of {@link InvoiceResponseType }
     * 
     */
    public InvoiceResponseType createInvoiceResponseType() {
        return new InvoiceResponseType();
    }

    /**
     * Create an instance of {@link InvoiceVerificationRequestType }
     * 
     */
    public InvoiceVerificationRequestType createInvoiceVerificationRequestType() {
        return new InvoiceVerificationRequestType();
    }

    /**
     * Create an instance of {@link InvoiceVerificationResponseType }
     * 
     */
    public InvoiceVerificationResponseType createInvoiceVerificationResponseType() {
        return new InvoiceVerificationResponseType();
    }

    /**
     * Create an instance of {@link PurchaseOrderRequestType }
     * 
     */
    public PurchaseOrderRequestType createPurchaseOrderRequestType() {
        return new PurchaseOrderRequestType();
    }

    /**
     * Create an instance of {@link PurchaseOrderResponseType }
     * 
     */
    public PurchaseOrderResponseType createPurchaseOrderResponseType() {
        return new PurchaseOrderResponseType();
    }

    /**
     * Create an instance of {@link QuotationRequestType }
     * 
     */
    public QuotationRequestType createQuotationRequestType() {
        return new QuotationRequestType();
    }

    /**
     * Create an instance of {@link QuotationResponseType }
     * 
     */
    public QuotationResponseType createQuotationResponseType() {
        return new QuotationResponseType();
    }

    /**
     * Create an instance of {@link ReversalRequestType }
     * 
     */
    public ReversalRequestType createReversalRequestType() {
        return new ReversalRequestType();
    }

    /**
     * Create an instance of {@link ReversalResponseType }
     * 
     */
    public ReversalResponseType createReversalResponseType() {
        return new ReversalResponseType();
    }

    /**
     * Create an instance of {@link RollbackRequestType }
     * 
     */
    public RollbackRequestType createRollbackRequestType() {
        return new RollbackRequestType();
    }

    /**
     * Create an instance of {@link RollbackResponseType }
     * 
     */
    public RollbackResponseType createRollbackResponseType() {
        return new RollbackResponseType();
    }

    /**
     * Create an instance of {@link TransactionExistsRequestType }
     * 
     */
    public TransactionExistsRequestType createTransactionExistsRequestType() {
        return new TransactionExistsRequestType();
    }

    /**
     * Create an instance of {@link TransactionExistsResponseType }
     * 
     */
    public TransactionExistsResponseType createTransactionExistsResponseType() {
        return new TransactionExistsResponseType();
    }

    /**
     * Create an instance of {@link FindChangedTaxAreaIdsResponseType }
     * 
     */
    public FindChangedTaxAreaIdsResponseType createFindChangedTaxAreaIdsResponseType() {
        return new FindChangedTaxAreaIdsResponseType();
    }

    /**
     * Create an instance of {@link IsTaxAreaChangedResponseType }
     * 
     */
    public IsTaxAreaChangedResponseType createIsTaxAreaChangedResponseType() {
        return new IsTaxAreaChangedResponseType();
    }

    /**
     * Create an instance of {@link TaxAreaRequestType }
     * 
     */
    public TaxAreaRequestType createTaxAreaRequestType() {
        return new TaxAreaRequestType();
    }

    /**
     * Create an instance of {@link TaxAreaResponseType }
     * 
     */
    public TaxAreaResponseType createTaxAreaResponseType() {
        return new TaxAreaResponseType();
    }

    /**
     * Create an instance of {@link FindTaxAreasRequestType }
     * 
     */
    public FindTaxAreasRequestType createFindTaxAreasRequestType() {
        return new FindTaxAreasRequestType();
    }

    /**
     * Create an instance of {@link FindTaxAreasResponseType }
     * 
     */
    public FindTaxAreasResponseType createFindTaxAreasResponseType() {
        return new FindTaxAreasResponseType();
    }

    /**
     * Create an instance of {@link VersionRequestType }
     * 
     */
    public VersionRequestType createVersionRequestType() {
        return new VersionRequestType();
    }

    /**
     * Create an instance of {@link TaxImposition }
     * 
     */
    public TaxImposition createTaxImposition() {
        return new TaxImposition();
    }

    /**
     * Create an instance of {@link ImpositionType }
     * 
     */
    public ImpositionType createImpositionType() {
        return new ImpositionType();
    }

    /**
     * Create an instance of {@link SupplementaryUnitType }
     * 
     */
    public SupplementaryUnitType createSupplementaryUnitType() {
        return new SupplementaryUnitType();
    }

    /**
     * Create an instance of {@link TaxOverride }
     * 
     */
    public TaxOverride createTaxOverride() {
        return new TaxOverride();
    }

    /**
     * Create an instance of {@link CurrencyType }
     * 
     */
    public CurrencyType createCurrencyType() {
        return new CurrencyType();
    }

    /**
     * Create an instance of {@link ImpositionToProcess }
     * 
     */
    public ImpositionToProcess createImpositionToProcess() {
        return new ImpositionToProcess();
    }

    /**
     * Create an instance of {@link TaxabilityCategoryTotal }
     * 
     */
    public TaxabilityCategoryTotal createTaxabilityCategoryTotal() {
        return new TaxabilityCategoryTotal();
    }

    /**
     * Create an instance of {@link TaxabilityCategory }
     * 
     */
    public TaxabilityCategory createTaxabilityCategory() {
        return new TaxabilityCategory();
    }

    /**
     * Create an instance of {@link CurrencyAmountType }
     * 
     */
    public CurrencyAmountType createCurrencyAmountType() {
        return new CurrencyAmountType();
    }

    /**
     * Create an instance of {@link TaxRuleCurrencyConversionFactors }
     * 
     */
    public TaxRuleCurrencyConversionFactors createTaxRuleCurrencyConversionFactors() {
        return new TaxRuleCurrencyConversionFactors();
    }

    /**
     * Create an instance of {@link TaxRuleCurrencyConversionFactorType }
     * 
     */
    public TaxRuleCurrencyConversionFactorType createTaxRuleCurrencyConversionFactorType() {
        return new TaxRuleCurrencyConversionFactorType();
    }

    /**
     * Create an instance of {@link TimePeriodType }
     * 
     */
    public TimePeriodType createTimePeriodType() {
        return new TimePeriodType();
    }

    /**
     * Create an instance of {@link CoordinatesType }
     * 
     */
    public CoordinatesType createCoordinatesType() {
        return new CoordinatesType();
    }

    /**
     * Create an instance of {@link Recipient }
     * 
     */
    public Recipient createRecipient() {
        return new Recipient();
    }

    /**
     * Create an instance of {@link CustomerCodeType }
     * 
     */
    public CustomerCodeType createCustomerCodeType() {
        return new CustomerCodeType();
    }

    /**
     * Create an instance of {@link JurisdictionOverride }
     * 
     */
    public JurisdictionOverride createJurisdictionOverride() {
        return new JurisdictionOverride();
    }

    /**
     * Create an instance of {@link DeductionOverride.ExemptOverride }
     * 
     */
    public DeductionOverride.ExemptOverride createDeductionOverrideExemptOverride() {
        return new DeductionOverride.ExemptOverride();
    }

    /**
     * Create an instance of {@link DeductionOverride.NonTaxableOverride }
     * 
     */
    public DeductionOverride.NonTaxableOverride createDeductionOverrideNonTaxableOverride() {
        return new DeductionOverride.NonTaxableOverride();
    }

    /**
     * Create an instance of {@link RateOverride }
     * 
     */
    public RateOverride createRateOverride() {
        return new RateOverride();
    }

    /**
     * Create an instance of {@link DateTimePeriodType }
     * 
     */
    public DateTimePeriodType createDateTimePeriodType() {
        return new DateTimePeriodType();
    }

    /**
     * Create an instance of {@link MeasureType }
     * 
     */
    public MeasureType createMeasureType() {
        return new MeasureType();
    }

    /**
     * Create an instance of {@link ExemptionCertificate }
     * 
     */
    public ExemptionCertificate createExemptionCertificate() {
        return new ExemptionCertificate();
    }

    /**
     * Create an instance of {@link PostalAddressType }
     * 
     */
    public PostalAddressType createPostalAddressType() {
        return new PostalAddressType();
    }

    /**
     * Create an instance of {@link DatePeriodType }
     * 
     */
    public DatePeriodType createDatePeriodType() {
        return new DatePeriodType();
    }

    /**
     * Create an instance of {@link FlexibleFields.FlexibleCodeField }
     * 
     */
    public FlexibleFields.FlexibleCodeField createFlexibleFieldsFlexibleCodeField() {
        return new FlexibleFields.FlexibleCodeField();
    }

    /**
     * Create an instance of {@link FlexibleFields.FlexibleNumericField }
     * 
     */
    public FlexibleFields.FlexibleNumericField createFlexibleFieldsFlexibleNumericField() {
        return new FlexibleFields.FlexibleNumericField();
    }

    /**
     * Create an instance of {@link FlexibleFields.FlexibleDateField }
     * 
     */
    public FlexibleFields.FlexibleDateField createFlexibleFieldsFlexibleDateField() {
        return new FlexibleFields.FlexibleDateField();
    }

    /**
     * Create an instance of {@link Discount }
     * 
     */
    public Discount createDiscount() {
        return new Discount();
    }

    /**
     * Create an instance of {@link InputTax.TaxingJurisdictionLocation }
     * 
     */
    public InputTax.TaxingJurisdictionLocation createInputTaxTaxingJurisdictionLocation() {
        return new InputTax.TaxingJurisdictionLocation();
    }

    /**
     * Create an instance of {@link Dispatcher }
     * 
     */
    public Dispatcher createDispatcher() {
        return new Dispatcher();
    }

    /**
     * Create an instance of {@link DispatcherCode }
     * 
     */
    public DispatcherCode createDispatcherCode() {
        return new DispatcherCode();
    }

    /**
     * Create an instance of {@link CompanyCodeType }
     * 
     */
    public CompanyCodeType createCompanyCodeType() {
        return new CompanyCodeType();
    }

    /**
     * Create an instance of {@link VendorCode }
     * 
     */
    public VendorCode createVendorCode() {
        return new VendorCode();
    }

    /**
     * Create an instance of {@link LineType }
     * 
     */
    public LineType createLineType() {
        return new LineType();
    }

    /**
     * Create an instance of {@link TaxabilityCategoryTotals }
     * 
     */
    public TaxabilityCategoryTotals createTaxabilityCategoryTotals() {
        return new TaxabilityCategoryTotals();
    }

    /**
     * Create an instance of {@link Purchase }
     * 
     */
    public Purchase createPurchase() {
        return new Purchase();
    }

    /**
     * Create an instance of {@link ReturnsFields.ReturnsCodeField }
     * 
     */
    public ReturnsFields.ReturnsCodeField createReturnsFieldsReturnsCodeField() {
        return new ReturnsFields.ReturnsCodeField();
    }

    /**
     * Create an instance of {@link ReturnsFields.ReturnsNumericField }
     * 
     */
    public ReturnsFields.ReturnsNumericField createReturnsFieldsReturnsNumericField() {
        return new ReturnsFields.ReturnsNumericField();
    }

    /**
     * Create an instance of {@link ReturnsFields.ReturnsDateField }
     * 
     */
    public ReturnsFields.ReturnsDateField createReturnsFieldsReturnsDateField() {
        return new ReturnsFields.ReturnsDateField();
    }

    /**
     * Create an instance of {@link ReturnsFields.ReturnsIndicatorField }
     * 
     */
    public ReturnsFields.ReturnsIndicatorField createReturnsFieldsReturnsIndicatorField() {
        return new ReturnsFields.ReturnsIndicatorField();
    }

    /**
     * Create an instance of {@link SitusOverride }
     * 
     */
    public SitusOverride createSitusOverride() {
        return new SitusOverride();
    }

    /**
     * Create an instance of {@link CurrencyConversionFactors }
     * 
     */
    public CurrencyConversionFactors createCurrencyConversionFactors() {
        return new CurrencyConversionFactors();
    }

    /**
     * Create an instance of {@link CurrencyConversionFactorType }
     * 
     */
    public CurrencyConversionFactorType createCurrencyConversionFactorType() {
        return new CurrencyConversionFactorType();
    }

    /**
     * Create an instance of {@link LineItemIVSOType }
     * 
     */
    public LineItemIVSOType createLineItemIVSOType() {
        return new LineItemIVSOType();
    }

    /**
     * Create an instance of {@link OwnerType }
     * 
     */
    public OwnerType createOwnerType() {
        return new OwnerType();
    }

    /**
     * Create an instance of {@link TaxTransactionRequestType }
     * 
     */
    public TaxTransactionRequestType createTaxTransactionRequestType() {
        return new TaxTransactionRequestType();
    }

    /**
     * Create an instance of {@link LineItemDTPIType }
     * 
     */
    public LineItemDTPIType createLineItemDTPIType() {
        return new LineItemDTPIType();
    }

    /**
     * Create an instance of {@link ERSVendorType }
     * 
     */
    public ERSVendorType createERSVendorType() {
        return new ERSVendorType();
    }

    /**
     * Create an instance of {@link LineItemIRMOType }
     * 
     */
    public LineItemIRMOType createLineItemIRMOType() {
        return new LineItemIRMOType();
    }

    /**
     * Create an instance of {@link CommodityCodeRequestType }
     * 
     */
    public CommodityCodeRequestType createCommodityCodeRequestType() {
        return new CommodityCodeRequestType();
    }

    /**
     * Create an instance of {@link RuleType }
     * 
     */
    public RuleType createRuleType() {
        return new RuleType();
    }

    /**
     * Create an instance of {@link LineItemASIType }
     * 
     */
    public LineItemASIType createLineItemASIType() {
        return new LineItemASIType();
    }

    /**
     * Create an instance of {@link LineItemEPTOType }
     * 
     */
    public LineItemEPTOType createLineItemEPTOType() {
        return new LineItemEPTOType();
    }

    /**
     * Create an instance of {@link CustomerType }
     * 
     */
    public CustomerType createCustomerType() {
        return new CustomerType();
    }

    /**
     * Create an instance of {@link ApplicationPropertyType }
     * 
     */
    public ApplicationPropertyType createApplicationPropertyType() {
        return new ApplicationPropertyType();
    }

    /**
     * Create an instance of {@link TaxSynchronizationRequestType }
     * 
     */
    public TaxSynchronizationRequestType createTaxSynchronizationRequestType() {
        return new TaxSynchronizationRequestType();
    }

    /**
     * Create an instance of {@link LineItemAPIIType }
     * 
     */
    public LineItemAPIIType createLineItemAPIIType() {
        return new LineItemAPIIType();
    }

    /**
     * Create an instance of {@link TaxpayerType }
     * 
     */
    public TaxpayerType createTaxpayerType() {
        return new TaxpayerType();
    }

    /**
     * Create an instance of {@link TaxTransactionResponseType }
     * 
     */
    public TaxTransactionResponseType createTaxTransactionResponseType() {
        return new TaxTransactionResponseType();
    }

    /**
     * Create an instance of {@link LineItemISIType }
     * 
     */
    public LineItemISIType createLineItemISIType() {
        return new LineItemISIType();
    }

    /**
     * Create an instance of {@link BuyerType }
     * 
     */
    public BuyerType createBuyerType() {
        return new BuyerType();
    }

    /**
     * Create an instance of {@link TaxingJurisdictionLocationType }
     * 
     */
    public TaxingJurisdictionLocationType createTaxingJurisdictionLocationType() {
        return new TaxingJurisdictionLocationType();
    }

    /**
     * Create an instance of {@link LineItemAPIOType }
     * 
     */
    public LineItemAPIOType createLineItemAPIOType() {
        return new LineItemAPIOType();
    }

    /**
     * Create an instance of {@link LogEntryType }
     * 
     */
    public LogEntryType createLogEntryType() {
        return new LogEntryType();
    }

    /**
     * Create an instance of {@link LineItemDTSIType }
     * 
     */
    public LineItemDTSIType createLineItemDTSIType() {
        return new LineItemDTSIType();
    }

    /**
     * Create an instance of {@link LineItemAMOType }
     * 
     */
    public LineItemAMOType createLineItemAMOType() {
        return new LineItemAMOType();
    }

    /**
     * Create an instance of {@link LineItemARBOType }
     * 
     */
    public LineItemARBOType createLineItemARBOType() {
        return new LineItemARBOType();
    }

    /**
     * Create an instance of {@link LineItemASOType }
     * 
     */
    public LineItemASOType createLineItemASOType() {
        return new LineItemASOType();
    }

    /**
     * Create an instance of {@link LineItemIVSIType }
     * 
     */
    public LineItemIVSIType createLineItemIVSIType() {
        return new LineItemIVSIType();
    }

    /**
     * Create an instance of {@link LineItemBITIType }
     * 
     */
    public LineItemBITIType createLineItemBITIType() {
        return new LineItemBITIType();
    }

    /**
     * Create an instance of {@link LineItemATIType }
     * 
     */
    public LineItemATIType createLineItemATIType() {
        return new LineItemATIType();
    }

    /**
     * Create an instance of {@link LineItemATOType }
     * 
     */
    public LineItemATOType createLineItemATOType() {
        return new LineItemATOType();
    }

    /**
     * Create an instance of {@link LineItemIRMIType }
     * 
     */
    public LineItemIRMIType createLineItemIRMIType() {
        return new LineItemIRMIType();
    }

    /**
     * Create an instance of {@link LineItemBITOType }
     * 
     */
    public LineItemBITOType createLineItemBITOType() {
        return new LineItemBITOType();
    }

    /**
     * Create an instance of {@link LineItemQSIType }
     * 
     */
    public LineItemQSIType createLineItemQSIType() {
        return new LineItemQSIType();
    }

    /**
     * Create an instance of {@link LineItemDTPOType }
     * 
     */
    public LineItemDTPOType createLineItemDTPOType() {
        return new LineItemDTPOType();
    }

    /**
     * Create an instance of {@link LineItemDTSOType }
     * 
     */
    public LineItemDTSOType createLineItemDTSOType() {
        return new LineItemDTSOType();
    }

    /**
     * Create an instance of {@link LineItemPOTOType }
     * 
     */
    public LineItemPOTOType createLineItemPOTOType() {
        return new LineItemPOTOType();
    }

    /**
     * Create an instance of {@link TaxSynchronizationResponseType }
     * 
     */
    public TaxSynchronizationResponseType createTaxSynchronizationResponseType() {
        return new TaxSynchronizationResponseType();
    }

    /**
     * Create an instance of {@link LineItemARBIType }
     * 
     */
    public LineItemARBIType createLineItemARBIType() {
        return new LineItemARBIType();
    }

    /**
     * Create an instance of {@link LineItemAMIType }
     * 
     */
    public LineItemAMIType createLineItemAMIType() {
        return new LineItemAMIType();
    }

    /**
     * Create an instance of {@link JurisdictionType }
     * 
     */
    public JurisdictionType createJurisdictionType() {
        return new JurisdictionType();
    }

    /**
     * Create an instance of {@link TaxgisRequestType }
     * 
     */
    public TaxgisRequestType createTaxgisRequestType() {
        return new TaxgisRequestType();
    }

    /**
     * Create an instance of {@link CommodityCodeResponseType }
     * 
     */
    public CommodityCodeResponseType createCommodityCodeResponseType() {
        return new CommodityCodeResponseType();
    }

    /**
     * Create an instance of {@link LineItemISOType }
     * 
     */
    public LineItemISOType createLineItemISOType() {
        return new LineItemISOType();
    }

    /**
     * Create an instance of {@link LineItemPOTIType }
     * 
     */
    public LineItemPOTIType createLineItemPOTIType() {
        return new LineItemPOTIType();
    }

    /**
     * Create an instance of {@link SellerType }
     * 
     */
    public SellerType createSellerType() {
        return new SellerType();
    }

    /**
     * Create an instance of {@link LineItemEPTIType }
     * 
     */
    public LineItemEPTIType createLineItemEPTIType() {
        return new LineItemEPTIType();
    }

    /**
     * Create an instance of {@link PartyType }
     * 
     */
    public PartyType createPartyType() {
        return new PartyType();
    }

    /**
     * Create an instance of {@link TaxgisResponseType }
     * 
     */
    public TaxgisResponseType createTaxgisResponseType() {
        return new TaxgisResponseType();
    }

    /**
     * Create an instance of {@link VendorType }
     * 
     */
    public VendorType createVendorType() {
        return new VendorType();
    }

    /**
     * Create an instance of {@link LineItemQSOType }
     * 
     */
    public LineItemQSOType createLineItemQSOType() {
        return new LineItemQSOType();
    }

    /**
     * Create an instance of {@link ERSBuyerType }
     * 
     */
    public ERSBuyerType createERSBuyerType() {
        return new ERSBuyerType();
    }

    /**
     * Create an instance of {@link TaxAreaLookupType.ExternalJurisdiction }
     * 
     */
    public TaxAreaLookupType.ExternalJurisdiction createTaxAreaLookupTypeExternalJurisdiction() {
        return new TaxAreaLookupType.ExternalJurisdiction();
    }

    /**
     * Create an instance of {@link TaxAreaResultType.Status }
     * 
     */
    public TaxAreaResultType.Status createTaxAreaResultTypeStatus() {
        return new TaxAreaResultType.Status();
    }

    /**
     * Create an instance of {@link TaxAreaResultType.AddressCleansingResultMessage }
     * 
     */
    public TaxAreaResultType.AddressCleansingResultMessage createTaxAreaResultTypeAddressCleansingResultMessage() {
        return new TaxAreaResultType.AddressCleansingResultMessage();
    }

    /**
     * Create an instance of {@link TaxAreaLookupResultType.LookupException }
     * 
     */
    public TaxAreaLookupResultType.LookupException createTaxAreaLookupResultTypeLookupException() {
        return new TaxAreaLookupResultType.LookupException();
    }

    /**
     * Create an instance of {@link InvoiceTextsType.InvoiceText }
     * 
     */
    public InvoiceTextsType.InvoiceText createInvoiceTextsTypeInvoiceText() {
        return new InvoiceTextsType.InvoiceText();
    }

    /**
     * Create an instance of {@link TaxesType.Jurisdiction }
     * 
     */
    public TaxesType.Jurisdiction createTaxesTypeJurisdiction() {
        return new TaxesType.Jurisdiction();
    }

    /**
     * Create an instance of {@link TaxesType.AccumulateAsJurisdiction }
     * 
     */
    public TaxesType.AccumulateAsJurisdiction createTaxesTypeAccumulateAsJurisdiction() {
        return new TaxesType.AccumulateAsJurisdiction();
    }

    /**
     * Create an instance of {@link TaxesType.Imposition }
     * 
     */
    public TaxesType.Imposition createTaxesTypeImposition() {
        return new TaxesType.Imposition();
    }

    /**
     * Create an instance of {@link TaxesType.AccumulateAsImposition }
     * 
     */
    public TaxesType.AccumulateAsImposition createTaxesTypeAccumulateAsImposition() {
        return new TaxesType.AccumulateAsImposition();
    }

    /**
     * Create an instance of {@link TaxesType.CertificateNumber }
     * 
     */
    public TaxesType.CertificateNumber createTaxesTypeCertificateNumber() {
        return new TaxesType.CertificateNumber();
    }

    /**
     * Create an instance of {@link TaxesType.FilingCurrencyAmounts }
     * 
     */
    public TaxesType.FilingCurrencyAmounts createTaxesTypeFilingCurrencyAmounts() {
        return new TaxesType.FilingCurrencyAmounts();
    }

    /**
     * Create an instance of {@link TaxesType.AccumulateAsLineType }
     * 
     */
    public TaxesType.AccumulateAsLineType createTaxesTypeAccumulateAsLineType() {
        return new TaxesType.AccumulateAsLineType();
    }

    /**
     * Create an instance of {@link TaxRegistrationType.NexusOverride }
     * 
     */
    public TaxRegistrationType.NexusOverride createTaxRegistrationTypeNexusOverride() {
        return new TaxRegistrationType.NexusOverride();
    }

    /**
     * Create an instance of {@link TaxRegistrationType.PhysicalLocation }
     * 
     */
    public TaxRegistrationType.PhysicalLocation createTaxRegistrationTypePhysicalLocation() {
        return new TaxRegistrationType.PhysicalLocation();
    }

    /**
     * Create an instance of {@link VertexEnvelope.ApplicationData.MessageLogging.OverrideLoggingThreshold }
     * 
     */
    public VertexEnvelope.ApplicationData.MessageLogging.OverrideLoggingThreshold createVertexEnvelopeApplicationDataMessageLoggingOverrideLoggingThreshold() {
        return new VertexEnvelope.ApplicationData.MessageLogging.OverrideLoggingThreshold();
    }

    /**
     * Create an instance of {@link VersionResponseType.OperatingSystemVersion }
     * 
     */
    public VersionResponseType.OperatingSystemVersion createVersionResponseTypeOperatingSystemVersion() {
        return new VersionResponseType.OperatingSystemVersion();
    }

    /**
     * Create an instance of {@link VersionResponseType.JavaVirtualMachineVersion }
     * 
     */
    public VersionResponseType.JavaVirtualMachineVersion createVersionResponseTypeJavaVirtualMachineVersion() {
        return new VersionResponseType.JavaVirtualMachineVersion();
    }

    /**
     * Create an instance of {@link VersionResponseType.SettingsOverrides.SettingsOverride }
     * 
     */
    public VersionResponseType.SettingsOverrides.SettingsOverride createVersionResponseTypeSettingsOverridesSettingsOverride() {
        return new VersionResponseType.SettingsOverrides.SettingsOverride();
    }

    /**
     * Create an instance of {@link VersionResponseType.ConfigFileOverrides.ConfigFileOverride }
     * 
     */
    public VersionResponseType.ConfigFileOverrides.ConfigFileOverride createVersionResponseTypeConfigFileOverridesConfigFileOverride() {
        return new VersionResponseType.ConfigFileOverrides.ConfigFileOverride();
    }

    /**
     * Create an instance of {@link VersionResponseType.DataManagementActivities.DataManagementActivity }
     * 
     */
    public VersionResponseType.DataManagementActivities.DataManagementActivity createVersionResponseTypeDataManagementActivitiesDataManagementActivity() {
        return new VersionResponseType.DataManagementActivities.DataManagementActivity();
    }

    /**
     * Create an instance of {@link VersionResponseType.ServerInformation.ServerDetail }
     * 
     */
    public VersionResponseType.ServerInformation.ServerDetail createVersionResponseTypeServerInformationServerDetail() {
        return new VersionResponseType.ServerInformation.ServerDetail();
    }

    /**
     * Create an instance of {@link VersionResponseType.DatabaseVersions.DatabaseVersion.SchemaVersion }
     * 
     */
    public VersionResponseType.DatabaseVersions.DatabaseVersion.SchemaVersion createVersionResponseTypeDatabaseVersionsDatabaseVersionSchemaVersion() {
        return new VersionResponseType.DatabaseVersions.DatabaseVersion.SchemaVersion();
    }

    /**
     * Create an instance of {@link VersionResponseType.DatabaseVersions.DatabaseVersion.PlatformVersion }
     * 
     */
    public VersionResponseType.DatabaseVersions.DatabaseVersion.PlatformVersion createVersionResponseTypeDatabaseVersionsDatabaseVersionPlatformVersion() {
        return new VersionResponseType.DatabaseVersions.DatabaseVersion.PlatformVersion();
    }

    /**
     * Create an instance of {@link VersionResponseType.DatabaseVersions.DatabaseVersion.DriverVersion }
     * 
     */
    public VersionResponseType.DatabaseVersions.DatabaseVersion.DriverVersion createVersionResponseTypeDatabaseVersionsDatabaseVersionDriverVersion() {
        return new VersionResponseType.DatabaseVersions.DatabaseVersion.DriverVersion();
    }

    /**
     * Create an instance of {@link VersionResponseType.DatabaseVersions.DatabaseVersion.DataContentVersions.DataContentVersion }
     * 
     */
    public VersionResponseType.DatabaseVersions.DatabaseVersion.DataContentVersions.DataContentVersion createVersionResponseTypeDatabaseVersionsDatabaseVersionDataContentVersionsDataContentVersion() {
        return new VersionResponseType.DatabaseVersions.DatabaseVersion.DataContentVersions.DataContentVersion();
    }

    /**
     * Create an instance of {@link VersionResponseType.LibraryVersions.LibraryVersion }
     * 
     */
    public VersionResponseType.LibraryVersions.LibraryVersion createVersionResponseTypeLibraryVersionsLibraryVersion() {
        return new VersionResponseType.LibraryVersions.LibraryVersion();
    }

    /**
     * Create an instance of {@link VersionResponseType.ProductVersions.ProductVersion }
     * 
     */
    public VersionResponseType.ProductVersions.ProductVersion createVersionResponseTypeProductVersionsProductVersion() {
        return new VersionResponseType.ProductVersions.ProductVersion();
    }

    /**
     * Create an instance of {@link IsTaxAreaChangedRequestType.DatePeriod }
     * 
     */
    public IsTaxAreaChangedRequestType.DatePeriod createIsTaxAreaChangedRequestTypeDatePeriod() {
        return new IsTaxAreaChangedRequestType.DatePeriod();
    }

    /**
     * Create an instance of {@link FindChangedTaxAreaIdsRequestType.DatePeriod }
     * 
     */
    public FindChangedTaxAreaIdsRequestType.DatePeriod createFindChangedTaxAreaIdsRequestTypeDatePeriod() {
        return new FindChangedTaxAreaIdsRequestType.DatePeriod();
    }

    /**
     * Create an instance of {@link BuyerInputTaxRequestType.LineItem }
     * 
     */
    public BuyerInputTaxRequestType.LineItem createBuyerInputTaxRequestTypeLineItem() {
        return new BuyerInputTaxRequestType.LineItem();
    }

    /**
     * Create an instance of {@link AssetMovementRequestType.LineItem }
     * 
     */
    public AssetMovementRequestType.LineItem createAssetMovementRequestTypeLineItem() {
        return new AssetMovementRequestType.LineItem();
    }

    /**
     * Create an instance of {@link AccrualSyncResponseType.LineItem }
     * 
     */
    public AccrualSyncResponseType.LineItem createAccrualSyncResponseTypeLineItem() {
        return new AccrualSyncResponseType.LineItem();
    }

    /**
     * Create an instance of {@link AssistedParametersType.AssistedParameter }
     * 
     */
    public AssistedParametersType.AssistedParameter createAssistedParametersTypeAssistedParameter() {
        return new AssistedParametersType.AssistedParameter();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "AdditionalTaxesDue")
    public JAXBElement<BigDecimal> createAdditionalTaxesDue(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_AdditionalTaxesDue_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurrencyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "OriginalCurrency")
    public JAXBElement<CurrencyType> createOriginalCurrency(CurrencyType value) {
        return new JAXBElement<CurrencyType>(_OriginalCurrency_QNAME, CurrencyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "Destination")
    public JAXBElement<LocationType> createDestination(LocationType value) {
        return new JAXBElement<LocationType>(_Destination_QNAME, LocationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurrencyAmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "StatisticalValue")
    public JAXBElement<CurrencyAmountType> createStatisticalValue(CurrencyAmountType value) {
        return new JAXBElement<CurrencyAmountType>(_StatisticalValue_QNAME, CurrencyAmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurrencyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "CompanyCodeCurrency")
    public JAXBElement<CurrencyType> createCompanyCodeCurrency(CurrencyType value) {
        return new JAXBElement<CurrencyType>(_CompanyCodeCurrency_QNAME, CurrencyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssistedParametersType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "AssistedParameters")
    public JAXBElement<AssistedParametersType> createAssistedParameters(AssistedParametersType value) {
        return new JAXBElement<AssistedParametersType>(_AssistedParameters_QNAME, AssistedParametersType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "WageBasis")
    public JAXBElement<BigDecimal> createWageBasis(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_WageBasis_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JurisdictionLevelCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "JurisdictionLevel")
    public JAXBElement<JurisdictionLevelCodeType> createJurisdictionLevel(JurisdictionLevelCodeType value) {
        return new JAXBElement<JurisdictionLevelCodeType>(_JurisdictionLevel_QNAME, JurisdictionLevelCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "ProratePercentage")
    public JAXBElement<BigDecimal> createProratePercentage(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ProratePercentage_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "SpecialTaxBasis")
    public JAXBElement<BigDecimal> createSpecialTaxBasis(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_SpecialTaxBasis_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "AdministrativeOrigin")
    public JAXBElement<LocationType> createAdministrativeOrigin(LocationType value) {
        return new JAXBElement<LocationType>(_AdministrativeOrigin_QNAME, LocationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "Cost")
    public JAXBElement<BigDecimal> createCost(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Cost_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "SubTotal")
    public JAXBElement<BigDecimal> createSubTotal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_SubTotal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "PreviousTaxPaid")
    public JAXBElement<BigDecimal> createPreviousTaxPaid(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_PreviousTaxPaid_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeliveryTermCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "DeliveryTerm")
    public JAXBElement<DeliveryTermCodeType> createDeliveryTerm(DeliveryTermCodeType value) {
        return new JAXBElement<DeliveryTermCodeType>(_DeliveryTerm_QNAME, DeliveryTermCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SupplementaryUnitType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "SupplementaryUnit")
    public JAXBElement<SupplementaryUnitType> createSupplementaryUnit(SupplementaryUnitType value) {
        return new JAXBElement<SupplementaryUnitType>(_SupplementaryUnit_QNAME, SupplementaryUnitType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "ExtendedPrice")
    public JAXBElement<BigDecimal> createExtendedPrice(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ExtendedPrice_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "InputTotalTax")
    public JAXBElement<BigDecimal> createInputTotalTax(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_InputTotalTax_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "TotalTax")
    public JAXBElement<BigDecimal> createTotalTax(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_TotalTax_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurrencyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "Currency")
    public JAXBElement<CurrencyType> createCurrency(CurrencyType value) {
        return new JAXBElement<CurrencyType>(_Currency_QNAME, CurrencyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvoiceTextsType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "InvoiceTexts")
    public JAXBElement<InvoiceTextsType> createInvoiceTexts(InvoiceTextsType value) {
        return new JAXBElement<InvoiceTextsType>(_InvoiceTexts_QNAME, InvoiceTextsType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "InvoiceTextCode")
    public JAXBElement<BigInteger> createInvoiceTextCode(BigInteger value) {
        return new JAXBElement<BigInteger>(_InvoiceTextCode_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "Freight")
    public JAXBElement<BigDecimal> createFreight(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Freight_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "ChargedTax")
    public JAXBElement<BigDecimal> createChargedTax(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ChargedTax_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimePeriodType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "TimePeriod")
    public JAXBElement<TimePeriodType> createTimePeriod(TimePeriodType value) {
        return new JAXBElement<TimePeriodType>(_TimePeriod_QNAME, TimePeriodType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TaxRegistrationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "TaxRegistration")
    public JAXBElement<TaxRegistrationType> createTaxRegistration(TaxRegistrationType value) {
        return new JAXBElement<TaxRegistrationType>(_TaxRegistration_QNAME, TaxRegistrationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "CustomerCode")
    public JAXBElement<CustomerCodeType> createCustomerCode(CustomerCodeType value) {
        return new JAXBElement<CustomerCodeType>(_CustomerCode_QNAME, CustomerCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoordinatesType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "Coordinates")
    public JAXBElement<CoordinatesType> createCoordinates(CoordinatesType value) {
        return new JAXBElement<CoordinatesType>(_Coordinates_QNAME, CoordinatesType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "Amount")
    public JAXBElement<BigDecimal> createAmount(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Amount_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "Quantity")
    public JAXBElement<MeasureType> createQuantity(MeasureType value) {
        return new JAXBElement<MeasureType>(_Quantity_QNAME, MeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateTimePeriodType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "DateTimePeriod")
    public JAXBElement<DateTimePeriodType> createDateTimePeriod(DateTimePeriodType value) {
        return new JAXBElement<DateTimePeriodType>(_DateTimePeriod_QNAME, DateTimePeriodType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "Weight")
    public JAXBElement<MeasureType> createWeight(MeasureType value) {
        return new JAXBElement<MeasureType>(_Weight_QNAME, MeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "AdministrativeDestination")
    public JAXBElement<LocationType> createAdministrativeDestination(LocationType value) {
        return new JAXBElement<LocationType>(_AdministrativeDestination_QNAME, LocationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PostalAddressType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "PostalAddress")
    public JAXBElement<PostalAddressType> createPostalAddress(PostalAddressType value) {
        return new JAXBElement<PostalAddressType>(_PostalAddress_QNAME, PostalAddressType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "PhysicalOrigin")
    public JAXBElement<LocationType> createPhysicalOrigin(LocationType value) {
        return new JAXBElement<LocationType>(_PhysicalOrigin_QNAME, LocationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "LandedCost")
    public JAXBElement<BigDecimal> createLandedCost(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_LandedCost_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "UnitPrice")
    public JAXBElement<BigDecimal> createUnitPrice(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_UnitPrice_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "InputAmount")
    public JAXBElement<BigDecimal> createInputAmount(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_InputAmount_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TaxingLocationCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "TaxingLocation")
    public JAXBElement<TaxingLocationCodeType> createTaxingLocation(TaxingLocationCodeType value) {
        return new JAXBElement<TaxingLocationCodeType>(_TaxingLocation_QNAME, TaxingLocationCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TaxesType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "Taxes")
    public JAXBElement<TaxesType> createTaxes(TaxesType value) {
        return new JAXBElement<TaxesType>(_Taxes_QNAME, TaxesType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "Volume")
    public JAXBElement<MeasureType> createVolume(MeasureType value) {
        return new JAXBElement<MeasureType>(_Volume_QNAME, MeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "FairMarketValue")
    public JAXBElement<BigDecimal> createFairMarketValue(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_FairMarketValue_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "Total")
    public JAXBElement<BigDecimal> createTotal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Total_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DatePeriodType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "DatePeriod")
    public JAXBElement<DatePeriodType> createDatePeriod(DatePeriodType value) {
        return new JAXBElement<DatePeriodType>(_DatePeriod_QNAME, DatePeriodType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "AmountBilledToDate")
    public JAXBElement<BigDecimal> createAmountBilledToDate(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_AmountBilledToDate_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:vertexinc:o-series:tps:9:0", name = "RecipientCode")
    public JAXBElement<CustomerCodeType> createRecipientCode(CustomerCodeType value) {
        return new JAXBElement<CustomerCodeType>(_RecipientCode_QNAME, CustomerCodeType.class, null, value);
    }

}
