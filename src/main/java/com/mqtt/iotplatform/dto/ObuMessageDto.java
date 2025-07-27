package com.mqtt.iotplatform.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class ObuMessageDto {

	
	private Double lat;
	private Double lon;
	private String obuId;
}
