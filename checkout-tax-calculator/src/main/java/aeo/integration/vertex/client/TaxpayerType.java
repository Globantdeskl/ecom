
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TaxpayerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TaxpayerType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vertexinc:o-series:tps:9:0}PartyType">
 *       &lt;sequence>
 *         &lt;element name="Company" type="{urn:vertexinc:o-series:tps:9:0}EntityCodeType" minOccurs="0"/>
 *         &lt;element name="Division" type="{urn:vertexinc:o-series:tps:9:0}EntityCodeType" minOccurs="0"/>
 *         &lt;element name="Department" type="{urn:vertexinc:o-series:tps:9:0}EntityCodeType" minOccurs="0"/>
 *         &lt;element name="UtilityProvider" type="{urn:vertexinc:o-series:tps:9:0}UtilityProviderType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxpayerType", propOrder = {
    "company",
    "division",
    "department",
    "utilityProvider"
})
@XmlSeeAlso({
    OwnerType.class,
    BuyerType.class,
    SellerType.class,
    ERSBuyerType.class
})
public class TaxpayerType
    extends PartyType
{

    @XmlElement(name = "Company")
    protected String company;
    @XmlElement(name = "Division")
    protected String division;
    @XmlElement(name = "Department")
    protected String department;
    @XmlElement(name = "UtilityProvider")
    @XmlSchemaType(name = "NMTOKEN")
    protected UtilityProviderType utilityProvider;

    /**
     * Gets the value of the company property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets the value of the company property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompany(String value) {
        this.company = value;
    }

    /**
     * Gets the value of the division property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDivision() {
        return division;
    }

    /**
     * Sets the value of the division property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDivision(String value) {
        this.division = value;
    }

    /**
     * Gets the value of the department property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the value of the department property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartment(String value) {
        this.department = value;
    }

    /**
     * Gets the value of the utilityProvider property.
     * 
     * @return
     *     possible object is
     *     {@link UtilityProviderType }
     *     
     */
    public UtilityProviderType getUtilityProvider() {
        return utilityProvider;
    }

    /**
     * Sets the value of the utilityProvider property.
     * 
     * @param value
     *     allowed object is
     *     {@link UtilityProviderType }
     *     
     */
    public void setUtilityProvider(UtilityProviderType value) {
        this.utilityProvider = value;
    }

}
