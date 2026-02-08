
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Log  entry type indicates the type of log entry. 
 * 
 * 
 * <p>Java class for LogEntryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LogEntryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Exception" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="logLevel" use="required" type="{urn:vertexinc:o-series:tps:9:0}LogLevelType" />
 *       &lt;attribute name="instanceId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="threadId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="className" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogEntryType", propOrder = {
    "message",
    "exception"
})
public class LogEntryType {

    @XmlElement(name = "Message", required = true)
    protected String message;
    @XmlElement(name = "Exception")
    protected String exception;
    @XmlAttribute(name = "logLevel", required = true)
    protected LogLevelType logLevel;
    @XmlAttribute(name = "instanceId")
    protected String instanceId;
    @XmlAttribute(name = "threadId")
    protected String threadId;
    @XmlAttribute(name = "className")
    protected String className;

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the exception property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getException() {
        return exception;
    }

    /**
     * Sets the value of the exception property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setException(String value) {
        this.exception = value;
    }

    /**
     * Gets the value of the logLevel property.
     * 
     * @return
     *     possible object is
     *     {@link LogLevelType }
     *     
     */
    public LogLevelType getLogLevel() {
        return logLevel;
    }

    /**
     * Sets the value of the logLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link LogLevelType }
     *     
     */
    public void setLogLevel(LogLevelType value) {
        this.logLevel = value;
    }

    /**
     * Gets the value of the instanceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstanceId() {
        return instanceId;
    }

    /**
     * Sets the value of the instanceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstanceId(String value) {
        this.instanceId = value;
    }

    /**
     * Gets the value of the threadId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThreadId() {
        return threadId;
    }

    /**
     * Sets the value of the threadId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThreadId(String value) {
        this.threadId = value;
    }

    /**
     * Gets the value of the className property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassName() {
        return className;
    }

    /**
     * Sets the value of the className property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassName(String value) {
        this.className = value;
    }

}
