package com.mqtt.pol.repo;

import org.springframework.stereotype.Repository;

import com.mqtt.iotplatform.repo.ObuMessageRepo;
import com.mqtt.pol.emtities.ObuMessagePolandEntity;

@Repository
public interface ObuMessageRepoPol extends ObuMessageRepo<ObuMessagePolandEntity> {

}
