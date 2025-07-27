package com.mqtt.iotplatform.service;

import java.util.List;

import com.mqtt.iotplatform.entities.ObuMessageInt;

public interface ObuMessageService<T extends ObuMessageInt> {
	
	List<T> getRoute(String obu);
	T save(T t);
	T evoSave(T t);

}
