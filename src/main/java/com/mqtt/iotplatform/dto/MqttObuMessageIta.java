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
public class MqttObuMessageIta implements MqttObuMessageInt{

    
	
	@JsonProperty(value = "latitudine", required = true)
	private Double lat;
	@JsonProperty(value = "longitudine", required = true)
	private Double lon;
	@JsonProperty(value = "obu_ita", required = true)
	private String obuId;
}
