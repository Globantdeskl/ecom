package com.aeo.checkout.tax.config;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import com.newrelic.api.agent.Trace;

import aeo.integration.vertex.client.VertexEnvelope;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class VertexSOAPConnector extends WebServiceGatewaySupport {
	
	private final String serviceUrl;
	
	public VertexSOAPConnector(VertexConfig config) {
		super();
		
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		String contextPath = VertexEnvelope.class.getPackageName();
        marshaller.setContextPath(contextPath);
        
        HttpComponentsMessageSender httpMessageSender = new HttpComponentsMessageSender();
        httpMessageSender.setConnectionTimeout(config.getTimeout());
        httpMessageSender.setReadTimeout(config.getTimeout());
        
        this.setDefaultUri(config.getWsdlLocation());
        this.setMarshaller(marshaller);
        this.setUnmarshaller(marshaller);
        this.setMessageSender(httpMessageSender);
        this.serviceUrl = config.getServiceEndpoint();
        
        log.info("Vertex Connector: {}, Contex: {}", serviceUrl, contextPath);
	}

	@Trace
	public VertexEnvelope callWebService(VertexEnvelope quotationRequest) {
        return (VertexEnvelope) getWebServiceTemplate().marshalSendAndReceive(serviceUrl, quotationRequest);
    }
	
}
