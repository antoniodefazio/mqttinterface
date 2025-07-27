package com.mqtt.pol.nosqlrepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mqtt.ita.evorepo.ObuMessageRepoEvo;
import com.mqtt.pol.emtities.ObuMessagePolandEntity;

@Repository("obuMessageRepoEvo")
public interface ObuMessageRepoPolEvoNoSql extends MongoRepository<ObuMessagePolandEntity,Long>, ObuMessageRepoEvo<ObuMessagePolandEntity> {

	
}
