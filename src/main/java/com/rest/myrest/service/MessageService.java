package com.rest.myrest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.rest.myrest.Database.DatabaseStub;
import com.rest.myrest.Exception.DataNotFoundException;
import com.rest.myrest.model.Message;

public class MessageService {
	private Map<Integer,Message> messages = DatabaseStub.getMessages();
	
	public MessageService() {
		messages.put(1, new Message(1, "First Message", "author1"));
		messages.put(2, new Message(2, "Second Message", "author2"));
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(int id) {
		Message message = messages.get(id);
		if(message==null)
			throw new DataNotFoundException("Messsage with id : "+id+" not found");
		return message;
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId()<=0)
			return null;
		messages.put(message.getId(),message);
		return message;
	}
	
	public void deletMessage(int id) {
		messages.remove(id);
	}
	
	
}
