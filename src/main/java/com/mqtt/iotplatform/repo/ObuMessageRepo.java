package com.mqtt.iotplatform.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mqtt.iotplatform.entities.ObuMessageInt;

public interface ObuMessageRepo<T extends ObuMessageInt> extends JpaRepository<T, Long> {

	List<T> findByObuId(String obuId);
}
