
package aeo.integration.vertex.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * List of all parameters on the tax or line item that were assisted by one or more
 *                 assisting services.
 *             
 * 
 * <p>Java class for AssistedParametersType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AssistedParametersType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AssistedParameter" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="paramName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="phase" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;enumeration value="PRE"/>
 *                       &lt;enumeration value="POST"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="ruleName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="originalValue" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
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
@XmlType(name = "AssistedParametersType", propOrder = {
    "assistedParameter"
})
public class AssistedParametersType {

    @XmlElement(name = "AssistedParameter", required = true)
    protected List<AssistedParametersType.AssistedParameter> assistedParameter;

    /**
     * Gets the value of the assistedParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assistedParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssistedParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AssistedParametersType.AssistedParameter }
     * 
     * 
     */
    public List<AssistedParametersType.AssistedParameter> getAssistedParameter() {
        if (assistedParameter == null) {
            assistedParameter = new ArrayList<AssistedParametersType.AssistedParameter>();
        }
        return this.assistedParameter;
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
     *       &lt;attribute name="paramName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="phase" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;enumeration value="PRE"/>
     *             &lt;enumeration value="POST"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="ruleName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="originalValue" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    public static class AssistedParameter {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "paramName", required = true)
        protected String paramName;
        @XmlAttribute(name = "phase", required = true)
        protected String phase;
        @XmlAttribute(name = "ruleName")
        protected String ruleName;
        @XmlAttribute(name = "originalValue")
        protected String originalValue;

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
         * Gets the value of the paramName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getParamName() {
            return paramName;
        }

        /**
         * Sets the value of the paramName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setParamName(String value) {
            this.paramName = value;
        }

        /**
         * Gets the value of the phase property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPhase() {
            return phase;
        }

        /**
         * Sets the value of the phase property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPhase(String value) {
            this.phase = value;
        }

        /**
         * Gets the value of the ruleName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRuleName() {
            return ruleName;
        }

        /**
         * Sets the value of the ruleName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRuleName(String value) {
            this.ruleName = value;
        }

        /**
         * Gets the value of the originalValue property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOriginalValue() {
            return originalValue;
        }

        /**
         * Sets the value of the originalValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOriginalValue(String value) {
            this.originalValue = value;
        }

    }

}
