
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{urn:vertexinc:o-series:tps:9:0}ImpositionType"/>
 *         &lt;element name="Country" type="{urn:vertexinc:o-series:tps:9:0}EntityNameType"/>
 *         &lt;element name="MainDivision" type="{urn:vertexinc:o-series:tps:9:0}EntityNameType" minOccurs="0"/>
 *         &lt;element name="SubDivision" type="{urn:vertexinc:o-series:tps:9:0}EntityNameType" minOccurs="0"/>
 *         &lt;element name="City" type="{urn:vertexinc:o-series:tps:9:0}EntityNameType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="userDefined" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name",
    "impositionType",
    "country",
    "mainDivision",
    "subDivision",
    "city"
})
@XmlRootElement(name = "TaxImposition")
public class TaxImposition {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "ImpositionType", required = true)
    protected ImpositionType impositionType;
    @XmlElement(name = "Country", required = true)
    protected String country;
    @XmlElement(name = "MainDivision")
    protected String mainDivision;
    @XmlElement(name = "SubDivision")
    protected String subDivision;
    @XmlElement(name = "City")
    protected String city;
    @XmlAttribute(name = "userDefined")
    protected Boolean userDefined;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
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
     * Gets the value of the subDivision property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubDivision() {
        return subDivision;
    }

    /**
     * Sets the value of the subDivision property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubDivision(String value) {
        this.subDivision = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
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

}
