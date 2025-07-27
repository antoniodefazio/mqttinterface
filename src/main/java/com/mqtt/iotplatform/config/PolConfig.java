package com.mqtt.iotplatform.config;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@Profile("pol")
@EntityScan({"com.mqtt.pol.emtities"})
@EnableJpaRepositories("com.mqtt.pol.repo")
@EnableMongoRepositories("com.mqtt.pol.nosqlrepo")
public class PolConfig {
	
	@Bean
	public Queue polandQueue() {
	    return new Queue("polandQueue", true);
	}

}
