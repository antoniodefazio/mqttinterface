package com.mqtt.iotplatform.config;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Profile("default")
@EntityScan({"com.mqtt.ita.emtities"})
@EnableJpaRepositories("com.mqtt.ita.repo")
public class ItaConfig {

	@Bean
	public Queue polandQueue() {
	    return new Queue("itaQueue", true);
	}
}
