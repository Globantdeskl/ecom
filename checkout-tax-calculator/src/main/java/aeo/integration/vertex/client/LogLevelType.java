
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LogLevelType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LogLevelType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="FATAL"/>
 *     &lt;enumeration value="ERROR"/>
 *     &lt;enumeration value="WARNING"/>
 *     &lt;enumeration value="OPS"/>
 *     &lt;enumeration value="TRACE"/>
 *     &lt;enumeration value="DEBUG"/>
 *     &lt;enumeration value="SUPPORT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LogLevelType")
@XmlEnum
public enum LogLevelType {


    /**
     * Logs any system condition or event that jeopardizes system
     * integrity, such as allocation failures, disk space errors, or major
     * database problems. 
     * 
     */
    FATAL,

    /**
     * Logs all abnormal events that are neither warnings nor fatal. 
     * Use this setting in a production environment.
     * 
     */
    ERROR,

    /**
     * Logs any system condition or event that is abnormal but poses
     * no risk to stability, performance, or answer quality.
     * 
     */
    WARNING,

    /**
     * Logs major system events, such as starting up or shutting
     * down of major system components or services.
     * 
     */
    OPS,

    /**
     * Logs entry and exit points of substantial classes and services.
     * 
     */
    TRACE,

    /**
     * Logs a detailed description of software execution. Use this setting only if you are working in a development environment.
     * 
     * 
     */
    DEBUG,

    /**
     * Logs pertinent details to enhance Vertex Product Support troubleshooting.
     * 
     */
    SUPPORT;

    public String value() {
        return name();
    }

    public static LogLevelType fromValue(String v) {
        return valueOf(v);
    }

}
