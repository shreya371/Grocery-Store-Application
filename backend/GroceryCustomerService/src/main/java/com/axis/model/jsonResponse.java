package com.axis.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
@Document
public class jsonResponse {
	@Id
	private String resid;
	
	private int cartTotal;
	
	
	

	
	
	
	

}
