package com.masai.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFundException extends RuntimeException {

	
	String resourceName;
	String fieldName;
	long fieldValue;
	
	
	public ResourceNotFundException(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s not found with %s : %1", resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
	
}
