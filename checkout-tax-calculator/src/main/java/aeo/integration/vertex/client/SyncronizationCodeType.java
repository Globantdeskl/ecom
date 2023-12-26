
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SyncronizationCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SyncronizationCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="ADD"/>
 *     &lt;enumeration value="MODIFY"/>
 *     &lt;enumeration value="DELETE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SyncronizationCodeType")
@XmlEnum
public enum SyncronizationCodeType {


    /**
     * O Series synchronization adds a line item.
     * 
     */
    ADD,

    /**
     * O Series synchronization modifies a line item. The line item to be modified must
     *                         have existed on a previous transaction.
     *                     
     * 
     */
    MODIFY,

    /**
     * O Series synchronization deletes a line item. The line item to be deleted must
     *                         have existed on a previous transaction.
     *                     
     * 
     */
    DELETE;

    public String value() {
        return name();
    }

    public static SyncronizationCodeType fromValue(String v) {
        return valueOf(v);
    }

}
