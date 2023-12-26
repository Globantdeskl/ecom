
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for TaxAreaLookupType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TaxAreaLookupType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice minOccurs="0">
 *         &lt;element name="TaxAreaId" type="{urn:vertexinc:o-series:tps:9:0}TaxAreaIdType"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}PostalAddress"/>
 *         &lt;element name="ExternalJurisdiction">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ExternalJurisdictionCode" type="{urn:vertexinc:o-series:tps:9:0}ExternalJurisdictionCodeType"/>
 *                   &lt;element name="Country">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="1"/>
 *                         &lt;maxLength value="60"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}Coordinates"/>
 *       &lt;/choice>
 *       &lt;attribute name="asOfDate" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="lookupId">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="40"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxAreaLookupType", propOrder = {
    "taxAreaId",
    "postalAddress",
    "externalJurisdiction",
    "coordinates"
})
public class TaxAreaLookupType {

    @XmlElement(name = "TaxAreaId")
    @XmlSchemaType(name = "integer")
    protected Integer taxAreaId;
    @XmlElement(name = "PostalAddress")
    protected PostalAddressType postalAddress;
    @XmlElement(name = "ExternalJurisdiction")
    protected TaxAreaLookupType.ExternalJurisdiction externalJurisdiction;
    @XmlElement(name = "Coordinates")
    protected CoordinatesType coordinates;
    @XmlAttribute(name = "asOfDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar asOfDate;
    @XmlAttribute(name = "lookupId")
    protected String lookupId;

    /**
     * Gets the value of the taxAreaId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTaxAreaId() {
        return taxAreaId;
    }

    /**
     * Sets the value of the taxAreaId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTaxAreaId(Integer value) {
        this.taxAreaId = value;
    }

    /**
     * Gets the value of the postalAddress property.
     * 
     * @return
     *     possible object is
     *     {@link PostalAddressType }
     *     
     */
    public PostalAddressType getPostalAddress() {
        return postalAddress;
    }

    /**
     * Sets the value of the postalAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link PostalAddressType }
     *     
     */
    public void setPostalAddress(PostalAddressType value) {
        this.postalAddress = value;
    }

    /**
     * Gets the value of the externalJurisdiction property.
     * 
     * @return
     *     possible object is
     *     {@link TaxAreaLookupType.ExternalJurisdiction }
     *     
     */
    public TaxAreaLookupType.ExternalJurisdiction getExternalJurisdiction() {
        return externalJurisdiction;
    }

    /**
     * Sets the value of the externalJurisdiction property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxAreaLookupType.ExternalJurisdiction }
     *     
     */
    public void setExternalJurisdiction(TaxAreaLookupType.ExternalJurisdiction value) {
        this.externalJurisdiction = value;
    }

    /**
     * Gets the value of the coordinates property.
     * 
     * @return
     *     possible object is
     *     {@link CoordinatesType }
     *     
     */
    public CoordinatesType getCoordinates() {
        return coordinates;
    }

    /**
     * Sets the value of the coordinates property.
     * 
     * @param value
     *     allowed object is
     *     {@link CoordinatesType }
     *     
     */
    public void setCoordinates(CoordinatesType value) {
        this.coordinates = value;
    }

    /**
     * Gets the value of the asOfDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAsOfDate() {
        return asOfDate;
    }

    /**
     * Sets the value of the asOfDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAsOfDate(XMLGregorianCalendar value) {
        this.asOfDate = value;
    }

    /**
     * Gets the value of the lookupId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLookupId() {
        return lookupId;
    }

    /**
     * Sets the value of the lookupId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLookupId(String value) {
        this.lookupId = value;
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
     *         &lt;element name="ExternalJurisdictionCode" type="{urn:vertexinc:o-series:tps:9:0}ExternalJurisdictionCodeType"/>
     *         &lt;element name="Country">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="60"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
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
        "externalJurisdictionCode",
        "country"
    })
    public static class ExternalJurisdiction {

        @XmlElement(name = "ExternalJurisdictionCode", required = true)
        protected String externalJurisdictionCode;
        @XmlElement(name = "Country", required = true)
        protected String country;

        /**
         * Gets the value of the externalJurisdictionCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getExternalJurisdictionCode() {
            return externalJurisdictionCode;
        }

        /**
         * Sets the value of the externalJurisdictionCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setExternalJurisdictionCode(String value) {
            this.externalJurisdictionCode = value;
        }

        /**
         * Gets the value of the country property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCountry() {
            return country;
        }

        /**
         * Sets the value of the country property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCountry(String value) {
            this.country = value;
        }

    }

}
