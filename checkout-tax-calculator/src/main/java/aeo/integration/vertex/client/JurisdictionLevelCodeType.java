
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JurisdictionLevelCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JurisdictionLevelCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;minLength value="1"/>
 *     &lt;maxLength value="60"/>
 *     &lt;enumeration value="APO"/>
 *     &lt;enumeration value="BOROUGH"/>
 *     &lt;enumeration value="CITY"/>
 *     &lt;enumeration value="COUNTRY"/>
 *     &lt;enumeration value="COUNTY"/>
 *     &lt;enumeration value="DISTRICT"/>
 *     &lt;enumeration value="FPO"/>
 *     &lt;enumeration value="LOCAL_IMPROVEMENT_DISTRICT"/>
 *     &lt;enumeration value="PARISH"/>
 *     &lt;enumeration value="PROVINCE"/>
 *     &lt;enumeration value="SPECIAL_PURPOSE_DISTRICT"/>
 *     &lt;enumeration value="STATE"/>
 *     &lt;enumeration value="TERRITORY"/>
 *     &lt;enumeration value="TOWNSHIP"/>
 *     &lt;enumeration value="TRADE_BLOCK"/>
 *     &lt;enumeration value="TRANSIT_DISTRICT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JurisdictionLevelCodeType")
@XmlEnum
public enum JurisdictionLevelCodeType {


    /**
     * Army and Air Force Post Office box. This value may also be used for Diplomatic Post Office (DPO) box.
     * 
     */
    APO,

    /**
     * An entity that acts as a self-governing body on the local level.
     * 
     */
    BOROUGH,

    /**
     * An incorporated municipality in which definite boundaries and legal powers are set forth in a charter granted by the state.
     * 
     */
    CITY,

    /**
     * An entity that acts as a self-governing body, based on a special common geographic area of interest
     * 
     */
    COUNTRY,

    /**
     * An entity within a state or country, used for administrative purposes, created by territorial division for the purpose of local government.
     * 
     */
    COUNTY,

    /**
     * A local jurisdiction, which may or may not follow city or county boundaries, in which taxes or fees are imposed to benefit a specific purpose.  Examples include Special Purpose Districts, Municipal Transportation Authorities, Transit Districts, Community Improvement Districts, Transportation Development Districts, Hospital Districts, Local Improvement Districts, Public Improvement Districts, School Districts, and Police Jurisdictions.
     * 
     */
    DISTRICT,

    /**
     * (Military) Field Post Office.
     * 
     */
    FPO,

    /**
     * A municipality that provides local government functions. 
     * 
     */
    LOCAL_IMPROVEMENT_DISTRICT,

    /**
     * An entity within a state or country, used for administrative purposes, created by territorial division for the purpose of local government (most often seen in Louisiana). 
     * 
     */
    PARISH,

    /**
     * A territorial unit that acts in an administrative function or organized political system within a country. Provinces in Canada are similar to states in the United States.
     * 
     * 
     */
    PROVINCE,

    /**
     * A local jurisdiction that does not follow city or county boundaries.
     * Examples include municipal transportation authorities (MTAs), hospitals,
     * and school districts.
     * 
     */
    SPECIAL_PURPOSE_DISTRICT,

    /**
     * A territorial unit that acts in an administrative function or organized political system within a country. States in the United States are similar to provinces in Canada.
     * 
     */
    STATE,

    /**
     * A non-sovereign geographic region within a country.
     * 
     */
    TERRITORY,

    /**
     * An incorporated municipality in which definite boundaries and legal powers are set forth in a charter granted by the state, similar to a city.
     * 
     */
    TOWNSHIP,

    /**
     * A type of intergovernmental agreement where regional barriers to trade are reduced or eliminated among member countries.
     * 
     * 
     */
    TRADE_BLOCK,

    /**
     * A special-purpose district organized as either a corporation authorized
     *  by statute, or a government agency that provides public transportation
     *  within a specific region.
     * 
     */
    TRANSIT_DISTRICT;

    public String value() {
        return name();
    }

    public static JurisdictionLevelCodeType fromValue(String v) {
        return valueOf(v);
    }

}
