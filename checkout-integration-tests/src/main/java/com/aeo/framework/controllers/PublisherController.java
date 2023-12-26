package com.aeo.framework.controllers;

import com.aeo.framework.PublisherService;
import com.aeo.framework.model.OrderType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class PublisherController {
    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping("v1/framework/publish/{orderId}")
    public void publishOrder(@PathVariable String encodedKey, String orderId, String testEmail, OrderType orderType) throws Exception {
        publisherService.publishOrder(encodedKey, orderId, testEmail, orderType);
    }
}
