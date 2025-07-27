package com.mqtt.iotplatform.dto;

public interface MqttObuMessageInt {

	public Double getLat();
	
	public void setLat(Double lat);

	public Double getLon();

	public void setLon(Double lon) ;

	public String getObuId();

	public void setObuId(String obuId);
	
}
