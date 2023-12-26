package com.aeo.checkout.submitorder.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.gcp.core.DefaultGcpProjectIdProvider;
import org.springframework.cloud.gcp.core.GcpProjectIdProvider;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.cloud.gcp.pubsub.integration.outbound.PubSubMessageHandler;
import org.springframework.cloud.gcp.pubsub.support.DefaultPublisherFactory;
import org.springframework.cloud.gcp.pubsub.support.DefaultSubscriberFactory;
import org.springframework.cloud.gcp.pubsub.support.PublisherFactory;
import org.springframework.cloud.gcp.pubsub.support.SubscriberFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

import com.google.api.gax.core.CredentialsProvider;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;

@Configuration
@ConditionalOnProperty(value = "spring.cloud.gcp.pubsub.enabled", matchIfMissing = true)
public class FulfillOrderPublisherConfig {
	
	private final String projectId;
	private final String topicName;
	
	public FulfillOrderPublisherConfig(ApplicationConfigs configs) {
		this.projectId = configs.getFulfillOrderProjectId();
		this.topicName = configs.getFulfillOrderTopicName();
	}

	@Bean(name = "submit2fulfillment_IdProvider")
	public GcpProjectIdProvider submit2FulfillmentIdProvider() {
		return new DefaultGcpProjectIdProvider() {
			@Override
			public String getProjectId() {
				return projectId;
			}
		};
	}
	
	@Bean(name = "submit2fulfillment_credentialsProvider")
	public CredentialsProvider submit2FulfillmentCredentialsProvider() {
		return new CredentialsProvider() {
			@Override
			public Credentials getCredentials() throws IOException {
				return GoogleCredentials.getApplicationDefault()
						.createScoped(new ArrayList<>(
								List.of("https://www.googleapis.com/auth/cloud-platform")));
			}
		};
	}

	@Bean("submit2fulfillment_publisherFactory")
	public DefaultPublisherFactory publisherFactory(
			@Qualifier("submit2fulfillment_IdProvider") GcpProjectIdProvider projectIdProvider,
			@Qualifier("submit2fulfillment_credentialsProvider") CredentialsProvider credentialsProvider) {
		final DefaultPublisherFactory defaultPublisherFactory = new DefaultPublisherFactory(projectIdProvider);
		defaultPublisherFactory.setCredentialsProvider(credentialsProvider);
		return defaultPublisherFactory;
	}

	@Bean("submit2fulfillment_subscriberFactory")
	public DefaultSubscriberFactory subscriberFactory(
			@Qualifier("submit2fulfillment_IdProvider") GcpProjectIdProvider projectIdProvider,
			@Qualifier("submit2fulfillment_credentialsProvider") CredentialsProvider credentialsProvider) {
		final DefaultSubscriberFactory defaultSubscriberFactory = new DefaultSubscriberFactory(projectIdProvider);
		defaultSubscriberFactory.setCredentialsProvider(credentialsProvider);
		return defaultSubscriberFactory;
	}

	@Bean(name = "submit2fulfillment_pubSubTemplate")
	public PubSubTemplate submit2FulfillmentPubSubTemplate(
			@Qualifier("submit2fulfillment_publisherFactory") PublisherFactory publisherFactory,
			@Qualifier("submit2fulfillment_subscriberFactory") SubscriberFactory subscriberFactory,
			@Qualifier("submit2fulfillment_credentialsProvider") CredentialsProvider credentialsProvider) {
		if (publisherFactory instanceof DefaultPublisherFactory) {
			((DefaultPublisherFactory) publisherFactory).setCredentialsProvider(credentialsProvider);
		}
		return new PubSubTemplate(publisherFactory, subscriberFactory);
	}

	@Bean("submit2fulfillment_messageSender")
	@ServiceActivator(inputChannel = "submit2fulfillment_pubsubOutputChannel")
	public MessageHandler messageSender(
			@Qualifier("submit2fulfillment_pubSubTemplate") PubSubTemplate pubsubTemplate) {
		PubSubMessageHandler adapter = new PubSubMessageHandler(pubsubTemplate, topicName);
		adapter.setSync(true);
		return adapter;
	}

	@Service
	@MessagingGateway(defaultRequestChannel = "submit2fulfillment_pubsubOutputChannel")
	public interface Submit2FulfillmentPubsubOutboundGateway {

		void sendToPubsub(String text) throws MessagingException;
	}

}
