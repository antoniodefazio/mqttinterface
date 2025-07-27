package com.mqtt.iotplatform.api;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mqtt.iotplatform.dto.MqttObuMessageIta;
import com.mqtt.iotplatform.dto.MqttObuMessagePoland;
import com.mqtt.iotplatform.dto.ObuMessageDto;
import com.mqtt.iotplatform.entities.ObuMessageInt;
import com.mqtt.iotplatform.service.ObuMessageService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RouteApi {

	@Autowired
	private ObuMessageService<ObuMessageInt> obuService;
	@Autowired
	private Converter<ObuMessageDto, ObuMessageInt> converterToEntity;
	@Autowired
	private Converter<ObuMessageInt, ObuMessageDto> converterToDto;
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	private ObjectMapper objectMapper;

	@Value("${rabbit.queue}")
	private String queueName;

	@Value("${spring.application.name}")
	private String appName;

	private static long mongoIdCounter = 31;

	@GetMapping("/route")
	public ResponseEntity<List<ObuMessageDto>> getRouteByObu(@RequestParam String obu) {
		log.info("Running application: {}", appName);
		try {
			List<ObuMessageInt> route = obuService.getRoute(obu);
			if (route.isEmpty()) {
				log.info("Response: {}", "noContent");
				return ResponseEntity.noContent().build();
			} else {
				List<ObuMessageDto> response = route.stream().map(converterToDto::convert).toList();
				log.info("Response: {}", response);
				return ResponseEntity.ok(response);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/romePositionTest")
	public ResponseEntity<ObuMessageDto> uploadObuMessage() throws JsonProcessingException {
		log.info("Running application: {}", appName);
		ObuMessageDto romeDto = ObuMessageDto.builder().lat(41.9028).lon(12.4964).obuId("OBU_ROMA" + appName).build();
		ObuMessageInt entity = converterToEntity.convert(romeDto);
		entity.setId(mongoIdCounter++);
		log.info("Entity: {}", entity);
		ObuMessageInt saved = obuService.save(entity);
		ObuMessageDto response = converterToDto.convert(saved);
		log.info("Response: {}", response);
		testQueue();
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("/evoRomePositionTest")
	public ResponseEntity<ObuMessageDto> evoUploadObuMessage() throws JsonProcessingException {
		log.info("Running application: {}", appName);
		ObuMessageDto romeDto = ObuMessageDto.builder().lat(41.9028).lon(12.4964).obuId("OBU_ROMA_EVO" + appName)
				.build();
		ObuMessageInt entity = converterToEntity.convert(romeDto);
		entity.setId(mongoIdCounter++);
		log.info("Entity: {}", entity);
		ObuMessageInt saved = obuService.evoSave(entity);
		ObuMessageDto response = converterToDto.convert(saved);
		log.info("Response: {}", response);
		testQueue();
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	private void testQueue() throws JsonProcessingException {
		MqttObuMessagePoland polandMessage = MqttObuMessagePoland.builder().lat(52.2297).lon(21.0122).obuId("POL-001")
				.build();
		MqttObuMessageIta itaMessage = MqttObuMessageIta.builder().lat(41.9028).lon(12.4964).obuId("ITA-001").build();
		String jsonPol = objectMapper.writeValueAsString(polandMessage);
		log.info("Sending Pol Message to queue [{}]: {}", queueName, jsonPol);
		String jsonIta = objectMapper.writeValueAsString(itaMessage);
		log.info("Sending Ita Message to queue [{}]: {}", queueName, jsonIta);
		rabbitTemplate.convertAndSend(queueName, jsonPol);
		rabbitTemplate.convertAndSend(queueName, jsonIta);
	}
}
