package com.mqtt.iotplatform.converter.ita;

import org.springframework.context.annotation.Profile;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.mqtt.iotplatform.dto.ObuMessageDto;
import com.mqtt.iotplatform.entities.ObuMessageInt;
import com.mqtt.ita.emtities.ObuMessageItaEntity;

@Component
@Profile("default")
public class ItaObuMessageToDto implements Converter<ObuMessageInt,ObuMessageDto>{

	@Override
	public ObuMessageDto convert(ObuMessageInt entityInt) {
		ObuMessageItaEntity entity=(ObuMessageItaEntity)entityInt;
		return ObuMessageDto.builder().lat(entity.getLat()).
				lon(entity.getLon()).obuId(entity.getObuId()).build();
	}

}
