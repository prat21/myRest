package com.rest.myrest.Database;

import java.util.HashMap;
import java.util.Map;

import com.rest.myrest.model.Message;

public class DatabaseStub {
	private static Map<Integer,Message> messages = new HashMap<>();
	
	public static Map<Integer,Message> getMessages(){
		return messages;
	}
}
