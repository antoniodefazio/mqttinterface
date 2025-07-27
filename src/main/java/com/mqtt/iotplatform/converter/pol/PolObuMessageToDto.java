package com.mqtt.iotplatform.converter.pol;

import org.springframework.context.annotation.Profile;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.mqtt.iotplatform.dto.ObuMessageDto;
import com.mqtt.iotplatform.entities.ObuMessageInt;
import com.mqtt.pol.emtities.ObuMessagePolandEntity;

@Component
@Profile("pol")
public class PolObuMessageToDto implements Converter<ObuMessageInt,ObuMessageDto>{

	@Override
	public ObuMessageDto convert(ObuMessageInt entityInt) {
		ObuMessagePolandEntity entity=(ObuMessagePolandEntity)entityInt;
		return ObuMessageDto.builder().lat(entity.getLat()).
				lon(entity.getLon()).obuId(entity.getObuId()).build();
	}

}
