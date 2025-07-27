package com.mqtt.iotplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mqtt.iotplatform.entities.ObuMessageInt;
import com.mqtt.iotplatform.repo.ObuMessageRepo;
import com.mqtt.ita.evorepo.ObuMessageRepoEvo;

@Service
public class ObuMessageServiceImpl<T extends ObuMessageInt> implements ObuMessageService<T> {

	@Autowired
	private ObuMessageRepo<T> repo;

	@Autowired
	@Qualifier("obuMessageRepoEvo")
	private ObuMessageRepoEvo<T> repoEvo;

	@Override
	public List<T> getRoute(String obu) {

		return repo.findByObuId(obu);
	}

	@Override
	public T save(T t) {
		return repo.save(t);

	}

	@Override
	public T evoSave(T t) {
		return repoEvo.save(t);

	}

}
