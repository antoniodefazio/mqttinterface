package com.mqtt.pol.emtities;



import org.springframework.data.mongodb.core.mapping.Document;

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
@Document(collection = "obumessages")
public class ObuMessagePolandEntity implements ObuMessageInt{

    @Id
	private Long id;
    @Column(name="szerokosc")
	private Double lat;
    @Column(name="długosc")
	private Double lon;
    @Column(name="obu_pol")
	private String obuId;
}
