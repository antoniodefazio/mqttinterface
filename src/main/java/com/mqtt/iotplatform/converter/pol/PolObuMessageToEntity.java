package com.mqtt.iotplatform.converter.pol;

import org.springframework.context.annotation.Profile;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.mqtt.iotplatform.dto.ObuMessageDto;
import com.mqtt.iotplatform.entities.ObuMessageInt;
import com.mqtt.pol.emtities.ObuMessagePolandEntity;

@Component
@Profile("pol")
public class PolObuMessageToEntity implements Converter<ObuMessageDto,ObuMessageInt>{

	@Override
	public ObuMessageInt convert(ObuMessageDto dto) {
		
		return ObuMessagePolandEntity.builder()
			    .lat(dto.getLat())
			    .lon(dto.getLon())
			    .obuId(dto.getObuId())
			    .build();
	}

}
