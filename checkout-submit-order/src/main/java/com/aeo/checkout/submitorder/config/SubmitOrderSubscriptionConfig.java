package com.aeo.checkout.submitorder.config;

import com.aeo.checkout.submitorder.messaging.SubmitOrderSubscriber;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.pubsub.v1.ProjectSubscriptionName;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Configuration
@Slf4j
@ConditionalOnProperty(value = "spring.cloud.gcp.pubsub.enabled", havingValue = "true", matchIfMissing = true)
@RequiredArgsConstructor
public class SubmitOrderSubscriptionConfig {

	private final SubmitOrderSubscriber messageReceiver;

	@Primary
	@Bean
	public Subscriber pubsubSubscriber(@Value("${app-configs.submit-order-project-id}") String projectId,
									   @Value("${app-configs.submit-order-subscription}") String subscriptionId) {

		ProjectSubscriptionName subscriptionName = ProjectSubscriptionName.of(projectId, subscriptionId);

		Subscriber subscriber = null;
		try {
			ExecutorProvider executorProvider = InstantiatingExecutorProvider.newBuilder().setExecutorThreadCount(10).build();
			subscriber = Subscriber.newBuilder(subscriptionName, messageReceiver)
									.setExecutorProvider(executorProvider)
									.build();
			subscriber.startAsync().awaitRunning(60, TimeUnit.SECONDS);
			log.info("Listening for messages on {} ...", subscriptionName.toString());
		} catch (TimeoutException e) {
			log.warn("Listener Stopping for {}", subscriptionName.toString());
			if(subscriber != null) {
				subscriber.stopAsync();
			}
		}
		return subscriber;
	}

}