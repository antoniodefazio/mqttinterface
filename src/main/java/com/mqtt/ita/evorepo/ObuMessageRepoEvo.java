package com.mqtt.ita.evorepo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mqtt.iotplatform.entities.ObuMessageInt;


public interface ObuMessageRepoEvo<T extends ObuMessageInt> extends CrudRepository<T,Long> {

	List<T> findByObuId(String obuId);
}
