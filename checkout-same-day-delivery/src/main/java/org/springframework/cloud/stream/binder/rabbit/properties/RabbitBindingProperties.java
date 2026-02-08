package org.springframework.cloud.stream.binder.rabbit.properties;

import org.springframework.cloud.stream.binder.BinderSpecificPropertiesProvider;

import lombok.Data;

@Data
public class RabbitBindingProperties implements BinderSpecificPropertiesProvider {
	
	private RabbitConsumerProperties consumer = new RabbitConsumerProperties();
	private RabbitProducerProperties producer = new RabbitProducerProperties();

}
