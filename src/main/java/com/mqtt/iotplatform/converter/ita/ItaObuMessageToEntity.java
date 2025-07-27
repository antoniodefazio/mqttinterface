package com.mqtt.iotplatform.converter.ita;

import org.springframework.context.annotation.Profile;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.mqtt.iotplatform.dto.ObuMessageDto;
import com.mqtt.iotplatform.entities.ObuMessageInt;
import com.mqtt.ita.emtities.ObuMessageItaEntity;

@Component
@Profile("default")
public class ItaObuMessageToEntity implements Converter<ObuMessageDto,ObuMessageInt>{

	@Override
	public ObuMessageInt convert(ObuMessageDto dto) {
		
		return ObuMessageItaEntity.builder()
			    .lat(dto.getLat())
			    .lon(dto.getLon())
			    .obuId(dto.getObuId())
			    .build();
	}

}
