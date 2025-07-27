package com.mqtt.ita.repo;

import org.springframework.stereotype.Repository;

import com.mqtt.iotplatform.repo.ObuMessageRepo;
import com.mqtt.ita.emtities.ObuMessageItaEntity;

@Repository
public interface ObuMessageRepoIta extends ObuMessageRepo<ObuMessageItaEntity> {

}
