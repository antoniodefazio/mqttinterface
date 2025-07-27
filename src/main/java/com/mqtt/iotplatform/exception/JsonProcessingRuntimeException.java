package com.mqtt.iotplatform.exception;

public class JsonProcessingRuntimeException extends RuntimeException {

    
	
	 
	private static final long serialVersionUID = 1L;

	public JsonProcessingRuntimeException(String message) {
        super(message);
    }

    public JsonProcessingRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}