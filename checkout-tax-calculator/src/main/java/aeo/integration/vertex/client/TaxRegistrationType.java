
package aeo.integration.vertex.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for TaxRegistrationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TaxRegistrationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TaxRegistrationNumber" type="{urn:vertexinc:o-series:tps:9:0}RegistrationIdType" minOccurs="0"/>
 *         &lt;element name="NexusOverride" maxOccurs="4" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="locationRole" use="required" type="{urn:vertexinc:o-series:tps:9:0}TaxingLocationCodeType" />
 *                 &lt;attribute name="country" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="mainDivision" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="subDivision" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="city" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="district" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PhysicalLocation" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{urn:vertexinc:o-series:tps:9:0}PostalAddressType">
 *                 &lt;attribute name="taxAreaId" type="{urn:vertexinc:o-series:tps:9:0}TaxAreaIdType" />
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}ImpositionType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="isoCountryCode" type="{urn:vertexinc:o-series:tps:9:0}CountryAlphaCodeType" />
 *       &lt;attribute name="mainDivision">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="60"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="hasPhysicalPresenceIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="jurisdictionId">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *             &lt;minInclusive value="0"/>
 *             &lt;maxInclusive value="999999999"/>
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
@XmlType(name = "TaxRegistrationType", propOrder = {
    "taxRegistrationNumber",
    "nexusOverride",
    "physicalLocation",
    "impositionType"
})
public class TaxRegistrationType {

    @XmlElement(name = "TaxRegistrationNumber")
    protected String taxRegistrationNumber;
    @XmlElement(name = "NexusOverride")
    protected List<TaxRegistrationType.NexusOverride> nexusOverride;
    @XmlElement(name = "PhysicalLocation")
    protected List<TaxRegistrationType.PhysicalLocation> physicalLocation;
    @XmlElement(name = "ImpositionType")
    protected ImpositionType impositionType;
    @XmlAttribute(name = "isoCountryCode")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String isoCountryCode;
    @XmlAttribute(name = "mainDivision")
    protected String mainDivision;
    @XmlAttribute(name = "hasPhysicalPresenceIndicator")
    protected Boolean hasPhysicalPresenceIndicator;
    @XmlAttribute(name = "jurisdictionId")
    protected Integer jurisdictionId;

    /**
     * Gets the value of the taxRegistrationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxRegistrationNumber() {
        return taxRegistrationNumber;
    }

    /**
     * Sets the value of the taxRegistrationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxRegistrationNumber(String value) {
        this.taxRegistrationNumber = value;
    }

    /**
     * Gets the value of the nexusOverride property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nexusOverride property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNexusOverride().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaxRegistrationType.NexusOverride }
     * 
     * 
     */
    public List<TaxRegistrationType.NexusOverride> getNexusOverride() {
        if (nexusOverride == null) {
            nexusOverride = new ArrayList<TaxRegistrationType.NexusOverride>();
        }
        return this.nexusOverride;
    }

    /**
     * Gets the value of the physicalLocation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the physicalLocation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPhysicalLocation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaxRegistrationType.PhysicalLocation }
     * 
     * 
     */
    public List<TaxRegistrationType.PhysicalLocation> getPhysicalLocation() {
        if (physicalLocation == null) {
            physicalLocation = new ArrayList<TaxRegistrationType.PhysicalLocation>();
        }
        return this.physicalLocation;
    }

    /**
     * The type description that is assigned to the imposition.
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
     * Gets the value of the isoCountryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsoCountryCode() {
        return isoCountryCode;
    }

    /**
     * Sets the value of the isoCountryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsoCountryCode(String value) {
        this.isoCountryCode = value;
    }

    /**
     * Gets the value of the mainDivision property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMainDivision() {
        return mainDivision;
    }

    /**
     * Sets the value of the mainDivision property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMainDivision(String value) {
        this.mainDivision = value;
    }

    /**
     * Gets the value of the hasPhysicalPresenceIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasPhysicalPresenceIndicator() {
        return hasPhysicalPresenceIndicator;
    }

    /**
     * Sets the value of the hasPhysicalPresenceIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasPhysicalPresenceIndicator(Boolean value) {
        this.hasPhysicalPresenceIndicator = value;
    }

    /**
     * Gets the value of the jurisdictionId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getJurisdictionId() {
        return jurisdictionId;
    }

    /**
     * Sets the value of the jurisdictionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setJurisdictionId(Integer value) {
        this.jurisdictionId = value;
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
     *       &lt;attribute name="locationRole" use="required" type="{urn:vertexinc:o-series:tps:9:0}TaxingLocationCodeType" />
     *       &lt;attribute name="country" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="mainDivision" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="subDivision" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="city" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="district" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class NexusOverride {

        @XmlAttribute(name = "locationRole", required = true)
        protected TaxingLocationCodeType locationRole;
        @XmlAttribute(name = "country")
        protected Boolean country;
        @XmlAttribute(name = "mainDivision")
        protected Boolean mainDivision;
        @XmlAttribute(name = "subDivision")
        protected Boolean subDivision;
        @XmlAttribute(name = "city")
        protected Boolean city;
        @XmlAttribute(name = "district")
        protected Boolean district;

        /**
         * Gets the value of the locationRole property.
         * 
         * @return
         *     possible object is
         *     {@link TaxingLocationCodeType }
         *     
         */
        public TaxingLocationCodeType getLocationRole() {
            return locationRole;
        }

        /**
         * Sets the value of the locationRole property.
         * 
         * @param value
         *     allowed object is
         *     {@link TaxingLocationCodeType }
         *     
         */
        public void setLocationRole(TaxingLocationCodeType value) {
            this.locationRole = value;
        }

        /**
         * Gets the value of the country property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isCountry() {
            return country;
        }

        /**
         * Sets the value of the country property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setCountry(Boolean value) {
            this.country = value;
        }

        /**
         * Gets the value of the mainDivision property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isMainDivision() {
            return mainDivision;
        }

        /**
         * Sets the value of the mainDivision property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setMainDivision(Boolean value) {
            this.mainDivision = value;
        }

        /**
         * Gets the value of the subDivision property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isSubDivision() {
            return subDivision;
        }

        /**
         * Sets the value of the subDivision property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setSubDivision(Boolean value) {
            this.subDivision = value;
        }

        /**
         * Gets the value of the city property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isCity() {
            return city;
        }

        /**
         * Sets the value of the city property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setCity(Boolean value) {
            this.city = value;
        }

        /**
         * Gets the value of the district property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isDistrict() {
            return district;
        }

        /**
         * Sets the value of the district property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setDistrict(Boolean value) {
            this.district = value;
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
     *     &lt;extension base="{urn:vertexinc:o-series:tps:9:0}PostalAddressType">
     *       &lt;attribute name="taxAreaId" type="{urn:vertexinc:o-series:tps:9:0}TaxAreaIdType" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class PhysicalLocation
        extends PostalAddressType
    {

        @XmlAttribute(name = "taxAreaId")
        protected Integer taxAreaId;

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

    }

}
