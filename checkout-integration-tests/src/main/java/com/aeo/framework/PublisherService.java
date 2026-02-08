package com.aeo.framework;

import com.aeo.framework.model.OrderType;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.ProjectTopicName;
import com.google.pubsub.v1.PubsubMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

@Service
@Slf4j
public class PublisherService {

    final
    Environment environment;

    public PublisherService(Environment environment) {
        this.environment = environment;
    }

    @Value("${spring.cloud.gcp.pubsub.projectId}")
    private String pubsubProjectId;


    public void publishOrder(String encodedKey, String orderId, String testEmail, OrderType orderType) throws Exception {
        GoogleCredentials credentials = GoogleCredentials.fromStream(
                new ByteArrayInputStream(Base64.getDecoder().decode(encodedKey)));

        String customerOrder = new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource("orders/" + orderType.toString()).toURI())));
        ProjectTopicName topicName = ProjectTopicName.of(pubsubProjectId, environment.orderPublisherPubSubTopicName);

        Publisher publisher = Publisher.newBuilder(topicName).setCredentialsProvider(FixedCredentialsProvider.create(credentials)).build();
        PubsubMessage pubsubMessage = PubsubMessage.newBuilder().setData(ByteString.copyFromUtf8(String.format(customerOrder, orderId, testEmail))).build();
        ApiFuture<String> messageIdFuture = publisher.publish(pubsubMessage);
        ApiFutures.addCallback(messageIdFuture, new ApiFutureCallback<String>() {
            public void onSuccess(String messageId) {
                log.info("Published with message id: " + messageId);
                log.info("Published with order id: " + orderId);
                log.info("Published with order type: " + orderType.toString());
            }
            public void onFailure(Throwable t) {
                log.info("failed to publish to Pubsub: " + t);
            }
        }, MoreExecutors.directExecutor());
    }


}
