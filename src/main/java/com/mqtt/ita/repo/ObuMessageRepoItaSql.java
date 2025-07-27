package com.mqtt.ita.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mqtt.ita.emtities.ObuMessageItaEntity;
import com.mqtt.ita.evorepo.ObuMessageRepoEvo;

@Repository("obuMessageRepoEvo")
public interface ObuMessageRepoItaSql extends JpaRepository<ObuMessageItaEntity,Long>, ObuMessageRepoEvo<ObuMessageItaEntity> {

	
}
