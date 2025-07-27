package com.mqtt.iotplatform.dto;



import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor

public class MqttObuMessagePoland implements MqttObuMessageInt{

    
	
	@JsonProperty(value = "szerokosc", required = true)
	private Double lat;
	@JsonProperty(value = "długosc", required = true)
	private Double lon;
	@JsonProperty(value = "obu_pol", required = true)
	private String obuId;
}
