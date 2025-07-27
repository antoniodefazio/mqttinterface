package com.mqtt.iotplatform.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.mqtt.iotplatform.dto.MqttObuMessageInt;
import com.mqtt.iotplatform.exception.JsonProcessingRuntimeException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MqttListener {
	
	@Autowired
	private Converter<String,MqttObuMessageInt> toMessageConverter;
	@Value("${spring.application.name}")
	private String appName;
	
	@RabbitListener(queues = "${rabbit.queue}")
	public void receiveMessage(String message) {
		log.info("Listener application: {}", appName);
		log.info("Mqtt message: {}", message);
		MqttObuMessageInt messageDto = null;
		try {
		    messageDto = toMessageConverter.convert(message);
		} catch (JsonProcessingRuntimeException ex) {
		    log.error("Failed to convert JSON message: {} | Payload: {}", ex.getMessage(), message);
		    return;
		} catch (Exception ex) {
		    log.error("Unexpected error during message conversion. Payload: {}", message);
		    return;
		}
		log.info("Mqtt message: successfully converted {}", messageDto);
		//TODO:Process the message
	}

}
