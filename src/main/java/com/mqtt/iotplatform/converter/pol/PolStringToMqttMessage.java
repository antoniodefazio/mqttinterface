package com.mqtt.iotplatform.converter.pol;

import org.springframework.context.annotation.Profile;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mqtt.iotplatform.dto.MqttObuMessageInt;
import com.mqtt.iotplatform.dto.MqttObuMessagePoland;
import com.mqtt.iotplatform.exception.JsonProcessingRuntimeException;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Profile("pol")
@Slf4j
@AllArgsConstructor
public class PolStringToMqttMessage implements Converter<String,MqttObuMessageInt>{
	
	
	private final ObjectMapper objectMapper;

	@Override
	public MqttObuMessageInt convert(String json) {
	
		try {
			return objectMapper.readValue(json, MqttObuMessagePoland.class);
		} catch (JsonProcessingException e) {
			log.error("Malformed MqttObuMessagePol JSON: {}", json);
            throw new JsonProcessingRuntimeException("Invalid or incomplete JSON input");
		}
	}

}
