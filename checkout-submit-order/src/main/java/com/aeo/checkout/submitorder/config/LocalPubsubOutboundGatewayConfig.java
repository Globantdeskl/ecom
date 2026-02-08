package com.aeo.checkout.submitorder.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

import com.aeo.checkout.submitorder.config.FulfillOrderPublisherConfig.Submit2FulfillmentPubsubOutboundGateway;

import lombok.NoArgsConstructor;

@Profile("!kubernetes")
@Configuration
public class LocalPubsubOutboundGatewayConfig {
	
	@Profile("!kubernetes")
	@Service("fulfillmentPubsub")
	@NoArgsConstructor
	public class MockSubmit2Fulfillment implements Submit2FulfillmentPubsubOutboundGateway {
		@Override
		public void sendToPubsub(String text) throws MessagingException {}
	}

}
