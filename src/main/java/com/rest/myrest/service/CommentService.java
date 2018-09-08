package com.rest.myrest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.rest.myrest.Database.DatabaseStub;
import com.rest.myrest.model.Comment;
import com.rest.myrest.model.Message;

public class CommentService {
	private Map<Integer,Message> messages = DatabaseStub.getMessages();
	
	public CommentService() {
		//messages.put(1, new Message(1, "First Message", "author1"));
		//messages.put(2, new Message(2, "Second Message", "author2"));
	}
	
	public List<Comment> getAllComments(int messageId){
		return new ArrayList<Comment>(messages.get(messageId).getComments().values());
	}
	
	public Comment getComment(int messageId,int commentId) {
		return messages.get(messageId).getComments().get(commentId);
	}
	
	public Comment addComment(int messageId,Comment comment) {
		comment.setId(messages.get(messageId).getComments().size()+1);
		messages.get(messageId).getComments().put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(int messageId,Comment comment) {
		if(comment.getId()<=0)
			return null;
		messages.get(messageId).getComments().put(comment.getId(),comment);
		return comment;
	}
	
	public void deleteComment(int messageId,int id) {
		messages.get(messageId).getComments().remove(id);
	}
}
