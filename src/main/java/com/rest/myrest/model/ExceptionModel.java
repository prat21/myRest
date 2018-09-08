package com.rest.myrest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ExceptionModel {
	private String message;
	private int statusCode;
	
	public ExceptionModel() {
		
	}
	
	public ExceptionModel(String message, int statusCode) {
		this.message = message;
		this.statusCode = statusCode;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	
}
