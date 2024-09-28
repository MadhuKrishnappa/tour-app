package com.tour.app.framework.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class GenericResponseVO<T> {
	
	private ResponseHeader header=new ResponseHeader();
	
	private T body;

}
