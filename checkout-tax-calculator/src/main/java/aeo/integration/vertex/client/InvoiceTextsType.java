
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
 * List of all Invoice Text information when the Invoice Text Rules are hit during the tax calculation.
 * 
 * <p>Java class for InvoiceTextsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InvoiceTextsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InvoiceText" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="invoiceTextRuleId" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                       &lt;minInclusive value="0"/>
 *                       &lt;maxInclusive value="999999999"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="userDefined" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="text" type="{http://www.w3.org/2001/XMLSchema}string" />
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
@XmlType(name = "InvoiceTextsType", propOrder = {
    "invoiceText"
})
public class InvoiceTextsType {

    @XmlElement(name = "InvoiceText", required = true)
    protected List<InvoiceTextsType.InvoiceText> invoiceText;

    /**
     * Gets the value of the invoiceText property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the invoiceText property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInvoiceText().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InvoiceTextsType.InvoiceText }
     * 
     * 
     */
    public List<InvoiceTextsType.InvoiceText> getInvoiceText() {
        if (invoiceText == null) {
            invoiceText = new ArrayList<InvoiceTextsType.InvoiceText>();
        }
        return this.invoiceText;
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
     *       &lt;attribute name="invoiceTextRuleId" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
     *             &lt;minInclusive value="0"/>
     *             &lt;maxInclusive value="999999999"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="userDefined" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="text" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    public static class InvoiceText {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "invoiceTextRuleId", required = true)
        protected int invoiceTextRuleId;
        @XmlAttribute(name = "userDefined")
        protected Boolean userDefined;
        @XmlAttribute(name = "text")
        protected String text;

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
         * Gets the value of the invoiceTextRuleId property.
         * 
         */
        public int getInvoiceTextRuleId() {
            return invoiceTextRuleId;
        }

        /**
         * Sets the value of the invoiceTextRuleId property.
         * 
         */
        public void setInvoiceTextRuleId(int value) {
            this.invoiceTextRuleId = value;
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
         * Gets the value of the text property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getText() {
            return text;
        }

        /**
         * Sets the value of the text property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setText(String value) {
            this.text = value;
        }

    }

}
