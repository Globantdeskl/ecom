
package aeo.integration.vertex.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Result of a version lookup
 * 
 * <p>Java class for VersionResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VersionResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProductVersions" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ProductVersion" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="productName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="LibraryVersions" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="LibraryVersion" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="libraryName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="libraryOwner" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="DatabaseVersions" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DatabaseVersion" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="SchemaVersion">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="PlatformVersion">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="vendorName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="DriverVersion">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="driverName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="DataContentVersions" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="DataContentVersion" maxOccurs="unbounded">
 *                                         &lt;complexType>
 *                                           &lt;simpleContent>
 *                                             &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                               &lt;attribute name="contentName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                             &lt;/extension>
 *                                           &lt;/simpleContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="logicalName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="OperatingSystemVersion" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="operatingSystemName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="JavaVirtualMachineVersion" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="jvmName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ServerInformation" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ServerDetail" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="serverDetailName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="DataManagementActivities" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DataManagementActivity" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="StartTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                             &lt;element name="EndTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                             &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="activityName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ConfigFileOverrides" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ConfigFileOverride" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="parameterName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SettingsOverrides" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SettingsOverride" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="parameterName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="categoryName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="partition" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
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
@XmlType(name = "VersionResponseType", propOrder = {
    "productVersions",
    "libraryVersions",
    "databaseVersions",
    "operatingSystemVersion",
    "javaVirtualMachineVersion",
    "serverInformation",
    "dataManagementActivities",
    "configFileOverrides",
    "settingsOverrides"
})
public class VersionResponseType {

    @XmlElement(name = "ProductVersions")
    protected VersionResponseType.ProductVersions productVersions;
    @XmlElement(name = "LibraryVersions")
    protected VersionResponseType.LibraryVersions libraryVersions;
    @XmlElement(name = "DatabaseVersions")
    protected VersionResponseType.DatabaseVersions databaseVersions;
    @XmlElement(name = "OperatingSystemVersion")
    protected VersionResponseType.OperatingSystemVersion operatingSystemVersion;
    @XmlElement(name = "JavaVirtualMachineVersion")
    protected VersionResponseType.JavaVirtualMachineVersion javaVirtualMachineVersion;
    @XmlElement(name = "ServerInformation")
    protected VersionResponseType.ServerInformation serverInformation;
    @XmlElement(name = "DataManagementActivities")
    protected VersionResponseType.DataManagementActivities dataManagementActivities;
    @XmlElement(name = "ConfigFileOverrides")
    protected VersionResponseType.ConfigFileOverrides configFileOverrides;
    @XmlElement(name = "SettingsOverrides")
    protected VersionResponseType.SettingsOverrides settingsOverrides;

    /**
     * Gets the value of the productVersions property.
     * 
     * @return
     *     possible object is
     *     {@link VersionResponseType.ProductVersions }
     *     
     */
    public VersionResponseType.ProductVersions getProductVersions() {
        return productVersions;
    }

    /**
     * Sets the value of the productVersions property.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionResponseType.ProductVersions }
     *     
     */
    public void setProductVersions(VersionResponseType.ProductVersions value) {
        this.productVersions = value;
    }

    /**
     * Gets the value of the libraryVersions property.
     * 
     * @return
     *     possible object is
     *     {@link VersionResponseType.LibraryVersions }
     *     
     */
    public VersionResponseType.LibraryVersions getLibraryVersions() {
        return libraryVersions;
    }

    /**
     * Sets the value of the libraryVersions property.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionResponseType.LibraryVersions }
     *     
     */
    public void setLibraryVersions(VersionResponseType.LibraryVersions value) {
        this.libraryVersions = value;
    }

    /**
     * Gets the value of the databaseVersions property.
     * 
     * @return
     *     possible object is
     *     {@link VersionResponseType.DatabaseVersions }
     *     
     */
    public VersionResponseType.DatabaseVersions getDatabaseVersions() {
        return databaseVersions;
    }

    /**
     * Sets the value of the databaseVersions property.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionResponseType.DatabaseVersions }
     *     
     */
    public void setDatabaseVersions(VersionResponseType.DatabaseVersions value) {
        this.databaseVersions = value;
    }

    /**
     * Gets the value of the operatingSystemVersion property.
     * 
     * @return
     *     possible object is
     *     {@link VersionResponseType.OperatingSystemVersion }
     *     
     */
    public VersionResponseType.OperatingSystemVersion getOperatingSystemVersion() {
        return operatingSystemVersion;
    }

    /**
     * Sets the value of the operatingSystemVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionResponseType.OperatingSystemVersion }
     *     
     */
    public void setOperatingSystemVersion(VersionResponseType.OperatingSystemVersion value) {
        this.operatingSystemVersion = value;
    }

    /**
     * Gets the value of the javaVirtualMachineVersion property.
     * 
     * @return
     *     possible object is
     *     {@link VersionResponseType.JavaVirtualMachineVersion }
     *     
     */
    public VersionResponseType.JavaVirtualMachineVersion getJavaVirtualMachineVersion() {
        return javaVirtualMachineVersion;
    }

    /**
     * Sets the value of the javaVirtualMachineVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionResponseType.JavaVirtualMachineVersion }
     *     
     */
    public void setJavaVirtualMachineVersion(VersionResponseType.JavaVirtualMachineVersion value) {
        this.javaVirtualMachineVersion = value;
    }

    /**
     * Gets the value of the serverInformation property.
     * 
     * @return
     *     possible object is
     *     {@link VersionResponseType.ServerInformation }
     *     
     */
    public VersionResponseType.ServerInformation getServerInformation() {
        return serverInformation;
    }

    /**
     * Sets the value of the serverInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionResponseType.ServerInformation }
     *     
     */
    public void setServerInformation(VersionResponseType.ServerInformation value) {
        this.serverInformation = value;
    }

    /**
     * Gets the value of the dataManagementActivities property.
     * 
     * @return
     *     possible object is
     *     {@link VersionResponseType.DataManagementActivities }
     *     
     */
    public VersionResponseType.DataManagementActivities getDataManagementActivities() {
        return dataManagementActivities;
    }

    /**
     * Sets the value of the dataManagementActivities property.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionResponseType.DataManagementActivities }
     *     
     */
    public void setDataManagementActivities(VersionResponseType.DataManagementActivities value) {
        this.dataManagementActivities = value;
    }

    /**
     * Gets the value of the configFileOverrides property.
     * 
     * @return
     *     possible object is
     *     {@link VersionResponseType.ConfigFileOverrides }
     *     
     */
    public VersionResponseType.ConfigFileOverrides getConfigFileOverrides() {
        return configFileOverrides;
    }

    /**
     * Sets the value of the configFileOverrides property.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionResponseType.ConfigFileOverrides }
     *     
     */
    public void setConfigFileOverrides(VersionResponseType.ConfigFileOverrides value) {
        this.configFileOverrides = value;
    }

    /**
     * Gets the value of the settingsOverrides property.
     * 
     * @return
     *     possible object is
     *     {@link VersionResponseType.SettingsOverrides }
     *     
     */
    public VersionResponseType.SettingsOverrides getSettingsOverrides() {
        return settingsOverrides;
    }

    /**
     * Sets the value of the settingsOverrides property.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionResponseType.SettingsOverrides }
     *     
     */
    public void setSettingsOverrides(VersionResponseType.SettingsOverrides value) {
        this.settingsOverrides = value;
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
     *         &lt;element name="ConfigFileOverride" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="parameterName" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    @XmlType(name = "", propOrder = {
        "configFileOverride"
    })
    public static class ConfigFileOverrides {

        @XmlElement(name = "ConfigFileOverride", required = true)
        protected List<VersionResponseType.ConfigFileOverrides.ConfigFileOverride> configFileOverride;

        /**
         * Gets the value of the configFileOverride property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the configFileOverride property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getConfigFileOverride().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link VersionResponseType.ConfigFileOverrides.ConfigFileOverride }
         * 
         * 
         */
        public List<VersionResponseType.ConfigFileOverrides.ConfigFileOverride> getConfigFileOverride() {
            if (configFileOverride == null) {
                configFileOverride = new ArrayList<VersionResponseType.ConfigFileOverrides.ConfigFileOverride>();
            }
            return this.configFileOverride;
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
         *       &lt;attribute name="parameterName" type="{http://www.w3.org/2001/XMLSchema}string" />
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
        public static class ConfigFileOverride {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "parameterName")
            protected String parameterName;

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
             * Gets the value of the parameterName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getParameterName() {
                return parameterName;
            }

            /**
             * Sets the value of the parameterName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setParameterName(String value) {
                this.parameterName = value;
            }

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
     *         &lt;element name="DatabaseVersion" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="SchemaVersion">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="PlatformVersion">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="vendorName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="DriverVersion">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="driverName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="DataContentVersions" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="DataContentVersion" maxOccurs="unbounded">
     *                               &lt;complexType>
     *                                 &lt;simpleContent>
     *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                                     &lt;attribute name="contentName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                   &lt;/extension>
     *                                 &lt;/simpleContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="logicalName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
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
    @XmlType(name = "", propOrder = {
        "databaseVersion"
    })
    public static class DatabaseVersions {

        @XmlElement(name = "DatabaseVersion", required = true)
        protected List<VersionResponseType.DatabaseVersions.DatabaseVersion> databaseVersion;

        /**
         * Gets the value of the databaseVersion property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the databaseVersion property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDatabaseVersion().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link VersionResponseType.DatabaseVersions.DatabaseVersion }
         * 
         * 
         */
        public List<VersionResponseType.DatabaseVersions.DatabaseVersion> getDatabaseVersion() {
            if (databaseVersion == null) {
                databaseVersion = new ArrayList<VersionResponseType.DatabaseVersions.DatabaseVersion>();
            }
            return this.databaseVersion;
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
         *         &lt;element name="SchemaVersion">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="PlatformVersion">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="vendorName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="DriverVersion">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="driverName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="DataContentVersions" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="DataContentVersion" maxOccurs="unbounded">
         *                     &lt;complexType>
         *                       &lt;simpleContent>
         *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                           &lt;attribute name="contentName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                         &lt;/extension>
         *                       &lt;/simpleContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="logicalName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "schemaVersion",
            "platformVersion",
            "driverVersion",
            "dataContentVersions"
        })
        public static class DatabaseVersion {

            @XmlElement(name = "SchemaVersion", required = true)
            protected VersionResponseType.DatabaseVersions.DatabaseVersion.SchemaVersion schemaVersion;
            @XmlElement(name = "PlatformVersion", required = true)
            protected VersionResponseType.DatabaseVersions.DatabaseVersion.PlatformVersion platformVersion;
            @XmlElement(name = "DriverVersion", required = true)
            protected VersionResponseType.DatabaseVersions.DatabaseVersion.DriverVersion driverVersion;
            @XmlElement(name = "DataContentVersions")
            protected VersionResponseType.DatabaseVersions.DatabaseVersion.DataContentVersions dataContentVersions;
            @XmlAttribute(name = "logicalName", required = true)
            protected String logicalName;

            /**
             * Gets the value of the schemaVersion property.
             * 
             * @return
             *     possible object is
             *     {@link VersionResponseType.DatabaseVersions.DatabaseVersion.SchemaVersion }
             *     
             */
            public VersionResponseType.DatabaseVersions.DatabaseVersion.SchemaVersion getSchemaVersion() {
                return schemaVersion;
            }

            /**
             * Sets the value of the schemaVersion property.
             * 
             * @param value
             *     allowed object is
             *     {@link VersionResponseType.DatabaseVersions.DatabaseVersion.SchemaVersion }
             *     
             */
            public void setSchemaVersion(VersionResponseType.DatabaseVersions.DatabaseVersion.SchemaVersion value) {
                this.schemaVersion = value;
            }

            /**
             * Gets the value of the platformVersion property.
             * 
             * @return
             *     possible object is
             *     {@link VersionResponseType.DatabaseVersions.DatabaseVersion.PlatformVersion }
             *     
             */
            public VersionResponseType.DatabaseVersions.DatabaseVersion.PlatformVersion getPlatformVersion() {
                return platformVersion;
            }

            /**
             * Sets the value of the platformVersion property.
             * 
             * @param value
             *     allowed object is
             *     {@link VersionResponseType.DatabaseVersions.DatabaseVersion.PlatformVersion }
             *     
             */
            public void setPlatformVersion(VersionResponseType.DatabaseVersions.DatabaseVersion.PlatformVersion value) {
                this.platformVersion = value;
            }

            /**
             * Gets the value of the driverVersion property.
             * 
             * @return
             *     possible object is
             *     {@link VersionResponseType.DatabaseVersions.DatabaseVersion.DriverVersion }
             *     
             */
            public VersionResponseType.DatabaseVersions.DatabaseVersion.DriverVersion getDriverVersion() {
                return driverVersion;
            }

            /**
             * Sets the value of the driverVersion property.
             * 
             * @param value
             *     allowed object is
             *     {@link VersionResponseType.DatabaseVersions.DatabaseVersion.DriverVersion }
             *     
             */
            public void setDriverVersion(VersionResponseType.DatabaseVersions.DatabaseVersion.DriverVersion value) {
                this.driverVersion = value;
            }

            /**
             * Gets the value of the dataContentVersions property.
             * 
             * @return
             *     possible object is
             *     {@link VersionResponseType.DatabaseVersions.DatabaseVersion.DataContentVersions }
             *     
             */
            public VersionResponseType.DatabaseVersions.DatabaseVersion.DataContentVersions getDataContentVersions() {
                return dataContentVersions;
            }

            /**
             * Sets the value of the dataContentVersions property.
             * 
             * @param value
             *     allowed object is
             *     {@link VersionResponseType.DatabaseVersions.DatabaseVersion.DataContentVersions }
             *     
             */
            public void setDataContentVersions(VersionResponseType.DatabaseVersions.DatabaseVersion.DataContentVersions value) {
                this.dataContentVersions = value;
            }

            /**
             * Gets the value of the logicalName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLogicalName() {
                return logicalName;
            }

            /**
             * Sets the value of the logicalName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLogicalName(String value) {
                this.logicalName = value;
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
             *         &lt;element name="DataContentVersion" maxOccurs="unbounded">
             *           &lt;complexType>
             *             &lt;simpleContent>
             *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *                 &lt;attribute name="contentName" type="{http://www.w3.org/2001/XMLSchema}string" />
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
            @XmlType(name = "", propOrder = {
                "dataContentVersion"
            })
            public static class DataContentVersions {

                @XmlElement(name = "DataContentVersion", required = true)
                protected List<VersionResponseType.DatabaseVersions.DatabaseVersion.DataContentVersions.DataContentVersion> dataContentVersion;

                /**
                 * Gets the value of the dataContentVersion property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the dataContentVersion property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getDataContentVersion().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link VersionResponseType.DatabaseVersions.DatabaseVersion.DataContentVersions.DataContentVersion }
                 * 
                 * 
                 */
                public List<VersionResponseType.DatabaseVersions.DatabaseVersion.DataContentVersions.DataContentVersion> getDataContentVersion() {
                    if (dataContentVersion == null) {
                        dataContentVersion = new ArrayList<VersionResponseType.DatabaseVersions.DatabaseVersion.DataContentVersions.DataContentVersion>();
                    }
                    return this.dataContentVersion;
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
                 *       &lt;attribute name="contentName" type="{http://www.w3.org/2001/XMLSchema}string" />
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
                public static class DataContentVersion {

                    @XmlValue
                    protected String value;
                    @XmlAttribute(name = "contentName")
                    protected String contentName;

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
                     * Gets the value of the contentName property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getContentName() {
                        return contentName;
                    }

                    /**
                     * Sets the value of the contentName property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setContentName(String value) {
                        this.contentName = value;
                    }

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
             *       &lt;attribute name="driverName" type="{http://www.w3.org/2001/XMLSchema}string" />
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
            public static class DriverVersion {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "driverName")
                protected String driverName;

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
                 * Gets the value of the driverName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDriverName() {
                    return driverName;
                }

                /**
                 * Sets the value of the driverName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDriverName(String value) {
                    this.driverName = value;
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
             *       &lt;attribute name="vendorName" type="{http://www.w3.org/2001/XMLSchema}string" />
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
            public static class PlatformVersion {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "vendorName")
                protected String vendorName;

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
                 * Gets the value of the vendorName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getVendorName() {
                    return vendorName;
                }

                /**
                 * Sets the value of the vendorName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setVendorName(String value) {
                    this.vendorName = value;
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
            public static class SchemaVersion {

                @XmlValue
                protected String value;

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

            }

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
     *         &lt;element name="DataManagementActivity" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="StartTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *                   &lt;element name="EndTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                   &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="activityName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
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
    @XmlType(name = "", propOrder = {
        "dataManagementActivity"
    })
    public static class DataManagementActivities {

        @XmlElement(name = "DataManagementActivity", required = true)
        protected List<VersionResponseType.DataManagementActivities.DataManagementActivity> dataManagementActivity;

        /**
         * Gets the value of the dataManagementActivity property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the dataManagementActivity property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDataManagementActivity().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link VersionResponseType.DataManagementActivities.DataManagementActivity }
         * 
         * 
         */
        public List<VersionResponseType.DataManagementActivities.DataManagementActivity> getDataManagementActivity() {
            if (dataManagementActivity == null) {
                dataManagementActivity = new ArrayList<VersionResponseType.DataManagementActivities.DataManagementActivity>();
            }
            return this.dataManagementActivity;
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
         *         &lt;element name="StartTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
         *         &lt;element name="EndTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
         *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *       &lt;attribute name="activityName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "startTime",
            "endTime",
            "status"
        })
        public static class DataManagementActivity {

            @XmlElement(name = "StartTime", required = true)
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar startTime;
            @XmlElement(name = "EndTime")
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar endTime;
            @XmlElement(name = "Status", required = true)
            protected String status;
            @XmlAttribute(name = "activityName")
            protected String activityName;

            /**
             * Gets the value of the startTime property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getStartTime() {
                return startTime;
            }

            /**
             * Sets the value of the startTime property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setStartTime(XMLGregorianCalendar value) {
                this.startTime = value;
            }

            /**
             * Gets the value of the endTime property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getEndTime() {
                return endTime;
            }

            /**
             * Sets the value of the endTime property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setEndTime(XMLGregorianCalendar value) {
                this.endTime = value;
            }

            /**
             * Gets the value of the status property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStatus() {
                return status;
            }

            /**
             * Sets the value of the status property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStatus(String value) {
                this.status = value;
            }

            /**
             * Gets the value of the activityName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getActivityName() {
                return activityName;
            }

            /**
             * Sets the value of the activityName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setActivityName(String value) {
                this.activityName = value;
            }

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
     *       &lt;attribute name="jvmName" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    public static class JavaVirtualMachineVersion {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "jvmName")
        protected String jvmName;

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
         * Gets the value of the jvmName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJvmName() {
            return jvmName;
        }

        /**
         * Sets the value of the jvmName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJvmName(String value) {
            this.jvmName = value;
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
     *         &lt;element name="LibraryVersion" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="libraryName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="libraryOwner" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    @XmlType(name = "", propOrder = {
        "libraryVersion"
    })
    public static class LibraryVersions {

        @XmlElement(name = "LibraryVersion", required = true)
        protected List<VersionResponseType.LibraryVersions.LibraryVersion> libraryVersion;

        /**
         * Gets the value of the libraryVersion property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the libraryVersion property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLibraryVersion().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link VersionResponseType.LibraryVersions.LibraryVersion }
         * 
         * 
         */
        public List<VersionResponseType.LibraryVersions.LibraryVersion> getLibraryVersion() {
            if (libraryVersion == null) {
                libraryVersion = new ArrayList<VersionResponseType.LibraryVersions.LibraryVersion>();
            }
            return this.libraryVersion;
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
         *       &lt;attribute name="libraryName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="libraryOwner" type="{http://www.w3.org/2001/XMLSchema}string" />
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
        public static class LibraryVersion {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "libraryName")
            protected String libraryName;
            @XmlAttribute(name = "libraryOwner")
            protected String libraryOwner;

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
             * Gets the value of the libraryName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLibraryName() {
                return libraryName;
            }

            /**
             * Sets the value of the libraryName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLibraryName(String value) {
                this.libraryName = value;
            }

            /**
             * Gets the value of the libraryOwner property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLibraryOwner() {
                return libraryOwner;
            }

            /**
             * Sets the value of the libraryOwner property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLibraryOwner(String value) {
                this.libraryOwner = value;
            }

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
     *       &lt;attribute name="operatingSystemName" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    public static class OperatingSystemVersion {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "operatingSystemName")
        protected String operatingSystemName;

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
         * Gets the value of the operatingSystemName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOperatingSystemName() {
            return operatingSystemName;
        }

        /**
         * Sets the value of the operatingSystemName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOperatingSystemName(String value) {
            this.operatingSystemName = value;
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
     *         &lt;element name="ProductVersion" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="productName" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    @XmlType(name = "", propOrder = {
        "productVersion"
    })
    public static class ProductVersions {

        @XmlElement(name = "ProductVersion", required = true)
        protected List<VersionResponseType.ProductVersions.ProductVersion> productVersion;

        /**
         * Gets the value of the productVersion property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the productVersion property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getProductVersion().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link VersionResponseType.ProductVersions.ProductVersion }
         * 
         * 
         */
        public List<VersionResponseType.ProductVersions.ProductVersion> getProductVersion() {
            if (productVersion == null) {
                productVersion = new ArrayList<VersionResponseType.ProductVersions.ProductVersion>();
            }
            return this.productVersion;
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
         *       &lt;attribute name="productName" type="{http://www.w3.org/2001/XMLSchema}string" />
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
        public static class ProductVersion {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "productName")
            protected String productName;

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
             * Gets the value of the productName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProductName() {
                return productName;
            }

            /**
             * Sets the value of the productName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProductName(String value) {
                this.productName = value;
            }

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
     *         &lt;element name="ServerDetail" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="serverDetailName" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    @XmlType(name = "", propOrder = {
        "serverDetail"
    })
    public static class ServerInformation {

        @XmlElement(name = "ServerDetail", required = true)
        protected List<VersionResponseType.ServerInformation.ServerDetail> serverDetail;

        /**
         * Gets the value of the serverDetail property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the serverDetail property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getServerDetail().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link VersionResponseType.ServerInformation.ServerDetail }
         * 
         * 
         */
        public List<VersionResponseType.ServerInformation.ServerDetail> getServerDetail() {
            if (serverDetail == null) {
                serverDetail = new ArrayList<VersionResponseType.ServerInformation.ServerDetail>();
            }
            return this.serverDetail;
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
         *       &lt;attribute name="serverDetailName" type="{http://www.w3.org/2001/XMLSchema}string" />
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
        public static class ServerDetail {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "serverDetailName")
            protected String serverDetailName;

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
             * Gets the value of the serverDetailName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getServerDetailName() {
                return serverDetailName;
            }

            /**
             * Sets the value of the serverDetailName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setServerDetailName(String value) {
                this.serverDetailName = value;
            }

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
     *         &lt;element name="SettingsOverride" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="parameterName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="categoryName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="partition" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    @XmlType(name = "", propOrder = {
        "settingsOverride"
    })
    public static class SettingsOverrides {

        @XmlElement(name = "SettingsOverride", required = true)
        protected List<VersionResponseType.SettingsOverrides.SettingsOverride> settingsOverride;

        /**
         * Gets the value of the settingsOverride property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the settingsOverride property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSettingsOverride().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link VersionResponseType.SettingsOverrides.SettingsOverride }
         * 
         * 
         */
        public List<VersionResponseType.SettingsOverrides.SettingsOverride> getSettingsOverride() {
            if (settingsOverride == null) {
                settingsOverride = new ArrayList<VersionResponseType.SettingsOverrides.SettingsOverride>();
            }
            return this.settingsOverride;
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
         *       &lt;attribute name="parameterName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="categoryName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="partition" type="{http://www.w3.org/2001/XMLSchema}string" />
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
        public static class SettingsOverride {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "parameterName")
            protected String parameterName;
            @XmlAttribute(name = "categoryName")
            protected String categoryName;
            @XmlAttribute(name = "partition")
            protected String partition;

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
             * Gets the value of the parameterName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getParameterName() {
                return parameterName;
            }

            /**
             * Sets the value of the parameterName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setParameterName(String value) {
                this.parameterName = value;
            }

            /**
             * Gets the value of the categoryName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCategoryName() {
                return categoryName;
            }

            /**
             * Sets the value of the categoryName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCategoryName(String value) {
                this.categoryName = value;
            }

            /**
             * Gets the value of the partition property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPartition() {
                return partition;
            }

            /**
             * Sets the value of the partition property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPartition(String value) {
                this.partition = value;
            }

        }

    }

}
