package com.aeo.framework;

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

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
@Slf4j
public class GRPublishService {

    @Value("${spring.cloud.gcp.ghostRetail.pubsub.projectId}")
    private String projectID;

    @Value("${spring.cloud.gcp.ghostRetail.pubsub.queueName}")
    private String queueName;

    @Value("${spring.cloud.gcp.ghostRetail.credentials.encoded-key}")
    private String encodedKey;

    private Publisher publisher;

    @PostConstruct
    public void initPublisher() throws Exception {
        GoogleCredentials credentials = GoogleCredentials.fromStream(
                new ByteArrayInputStream(Base64.getDecoder().decode(encodedKey)));
        ProjectTopicName topicName = ProjectTopicName.of(projectID, queueName);
        publisher = Publisher.newBuilder(topicName).setCredentialsProvider(FixedCredentialsProvider.create(credentials)).build();
    }

    public void publish(String message) throws Exception {
        List<ApiFuture<String>> messageIdFutures = new ArrayList<>();
        PubsubMessage pubsubMessage = PubsubMessage.newBuilder().setData(ByteString.copyFromUtf8(message)).build();
        ApiFuture<String> messageIdFuture = publisher.publish(pubsubMessage);
        messageIdFutures.add(messageIdFuture);
        ApiFutures.addCallback(messageIdFuture, new ApiFutureCallback<String>() {
            public void onSuccess(String messageId) {
                log.info("Published to Pubsub with message id: " + messageId);
            }
            public void onFailure(Throwable t) {
                log.info("Failed to publish to Pubsub: " + t);
            }
        }, MoreExecutors.directExecutor());

        log.info("Publishing message " + message);
        ApiFutures.allAsList(messageIdFutures).get();
    }
}
