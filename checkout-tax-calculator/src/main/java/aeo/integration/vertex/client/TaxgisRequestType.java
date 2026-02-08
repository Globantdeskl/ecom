
package aeo.integration.vertex.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Parent type for all Taxgis request messages
 * 
 * <p>Java class for TaxgisRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TaxgisRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxgisRequestType")
@XmlSeeAlso({
    FindChangedTaxAreaIdsRequestType.class,
    IsTaxAreaChangedRequestType.class,
    TaxAreaRequestType.class,
    FindTaxAreasRequestType.class
})
public class TaxgisRequestType {


}
