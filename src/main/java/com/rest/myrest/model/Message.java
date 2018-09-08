package com.rest.myrest.model;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {
	private int id;
	private String message;
	private String author;
	private Map<Integer,Comment> comments = new HashMap<>();
	
	@XmlTransient									//So that comments do not get translated to xml/JSON when message is converted to xml/json
	public Map<Integer, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Integer, Comment> comments) {
		this.comments = comments;
	}

	public Message() {
		
	}
	
	public Message(int id, String message, String author) {
		this.id = id;
		this.message = message;
		this.author = author;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
