package com.mqtt.iotplatform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration

public class Config {

	@Bean
	public ObjectMapper objectMapper() {
	    return new ObjectMapper()
	            .configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true)
	            .configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
	            .configure(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES, true);
	}
}
