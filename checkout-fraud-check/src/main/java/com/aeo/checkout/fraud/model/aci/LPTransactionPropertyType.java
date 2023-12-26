package com.aeo.checkout.fraud.model.aci;

/**
 * An enum representing the type of a property in an LPTransaction. Properties
 * are added to the LPTransaction to create a request (REQUEST), other
 * properties are added to the LPTransaction as a response from the backend
 * (RESPONSE), and some properties on the request may be changed and read in the
 * response (BOTH).
 * 
 * @author jay
 *
 */
public enum LPTransactionPropertyType {

	REQUEST, RESPONSE, BOTH;

}
