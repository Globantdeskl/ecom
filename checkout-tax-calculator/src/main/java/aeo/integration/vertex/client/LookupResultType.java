
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LookupResultType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LookupResultType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="NORMAL"/>
 *     &lt;enumeration value="BAD_REGION_FIELDS"/>
 *     &lt;enumeration value="BAD_STREET_INFORMATION"/>
 *     &lt;enumeration value="IGNORED_REGION_FIELDS"/>
 *     &lt;enumeration value="MAX_TAXAREAS_EXCEEDED"/>
 *     &lt;enumeration value="MAX_FULL_ADDRESSES_EXCEEDED"/>
 *     &lt;enumeration value="MIN_AGGREGATE_CONFIDENCE_EXCEEDED"/>
 *     &lt;enumeration value="CONFIDENCE_INDICATOR_SUPPRESSED"/>
 *     &lt;enumeration value="PRECEDES_CONFIDENCE_INDICATOR_FUNCTIONALITY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LookupResultType")
@XmlEnum
public enum LookupResultType {


    /**
     * The lookup returned at least one tax area.
     * 
     */
    NORMAL,

    /**
     * The location information used during the lookup was incomplete or inconsistent.
     *                     
     * 
     */
    BAD_REGION_FIELDS,

    /**
     * The street address used during the lookup was incomplete or inconsistent.
     *                     
     * 
     */
    BAD_STREET_INFORMATION,

    /**
     * Some of the location information was missing during the lookup.
     *                     
     * 
     */
    IGNORED_REGION_FIELDS,

    /**
     * The maximum number of tax areas was exceeded. The maximum number of
     *                         tax areas that can be returned during a lookup is specified in the
     *                         taxgis.jurisdictionfinder.MaximumTaxAreas parameter.
     *                     
     * 
     */
    MAX_TAXAREAS_EXCEEDED,

    /**
     * The maximum number of full addresses was exceeded.
     *                         The maximum number of full addresses that can be returned during a
     *                         lookup is specified in the taxgis.jurisdictionfinder.MaximumFullAddresses
     *                         parameter.
     *                     
     * 
     */
    MAX_FULL_ADDRESSES_EXCEEDED,

    /**
     * The minimum aggregate confidence level has been exceeded. The minimum
     *                         aggregate confidence indicator for returning tax areas is specified
     *                         in the taxgis.jurisdictionfinder.MinimumAggregateConfidence parameter.
     *                     
     * 
     */
    MIN_AGGREGATE_CONFIDENCE_EXCEEDED,

    /**
     * The confidence indicator value indicates the strength of the Tax Area lookup
     *                         result.
     * 
     *                         The confidence indicator was supressed because one of the following was true: (1) the ZIP Code
     *                         was missing in a lookup for a United States address, or (2) the lookup was for an address in
     *                         Canada.
     *                     
     * 
     */
    CONFIDENCE_INDICATOR_SUPPRESSED,

    /**
     * The confidence indicator feature has been disabled because the transaction
     *                         date specified in the search criteria for this Tax Area lookup precedes the
     *                         implementation date of the TaxGIS Confidence Indicator. The default date value is 20060501.
     *                     
     * 
     */
    PRECEDES_CONFIDENCE_INDICATOR_FUNCTIONALITY;

    public String value() {
        return name();
    }

    public static LookupResultType fromValue(String v) {
        return valueOf(v);
    }

}
