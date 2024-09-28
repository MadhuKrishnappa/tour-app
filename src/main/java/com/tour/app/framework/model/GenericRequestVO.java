package com.tour.app.framework.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@JsonIgnoreProperties
public class GenericRequestVO<T> {
	
	private RequestHeader header;
	
	private T body;

}
