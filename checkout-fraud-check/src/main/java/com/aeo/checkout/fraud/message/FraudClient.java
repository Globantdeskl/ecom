package com.aeo.checkout.fraud.message;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.stereotype.Component;

import com.aeo.checkout.fraud.config.RedACICircuitBreakerConfig;
import com.aeo.checkout.fraud.model.aci.ACIConstants;
import com.aeo.checkout.fraud.model.aci.ACIException;
import com.aeo.checkout.fraud.model.aci.LPTransactionProperty;
import com.liveprocessor.LPClient.LPClient;
import com.liveprocessor.LPClient.LPTransaction;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.newrelic.api.agent.ExternalParameters;
import com.newrelic.api.agent.HttpParameters;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FraudClient {

	private final LPClient lpClient;
	private final URI newRelicUri;

	public FraudClient(LPClient lpClient) throws URISyntaxException {
		this.lpClient = lpClient;
		this.newRelicUri = new URI("http", null, "aciworldwide.com", 80, null, null, null);
	}

	@Trace
	@HystrixCommand(groupKey = RedACICircuitBreakerConfig.GROUP_KEY_NAME, 
			commandKey = RedACICircuitBreakerConfig.COMMAND_KEY_NAME,
			fallbackMethod = "fallback")
	public LPTransaction call(LPTransaction transaction) throws ACIException {
		log.debug("RedACI Circuit {}", RedACICircuitBreakerConfig.findCircuitBreakerState());
		addExternalCallToNewRelic(transaction);
		try {
			transaction.process(lpClient);
		} catch (Exception e) {
			throw new ACIException(e);
		}
		return transaction;
	}
	
	@Trace(leaf = true)
	public LPTransaction fallback(LPTransaction transaction) throws ACIException {
		log.error("RedACI Circuit {}", RedACICircuitBreakerConfig.findCircuitBreakerState());
		throw new ACIException("RedACI Circuit fallback tripped");
	}
	
	private void addExternalCallToNewRelic(LPTransaction transaction) {
		
		String actionCode = transaction.getField(LPTransactionProperty.ACT_CD.name());
		if (ACIConstants.ActionCode.GET_TOKEN.code().equals(actionCode)) {
			actionCode = ACIConstants.ActionCode.GET_TOKEN.toString();
		} else if (ACIConstants.ActionCode.FRAUD_CHECK_ONLY.code().equals(actionCode)) {
			actionCode = ACIConstants.ActionCode.FRAUD_CHECK_ONLY.toString();
		}
		
		ExternalParameters params = HttpParameters.library("RedACI")
				.uri(newRelicUri).procedure(actionCode).noInboundHeaders().build();
		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
	}

}
