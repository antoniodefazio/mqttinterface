package com.mqtt.ita.emtities;



import com.mqtt.iotplatform.entities.ObuMessageInt;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class ObuMessageItaEntity implements ObuMessageInt{

    @Id
	private Long id;
	@Column(name="latitudine")
	private Double lat;
	@Column(name="longitudine")
	private Double lon;
	@Column(name="obu_ita")
	private String obuId;
}
