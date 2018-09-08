package com.rest.myrest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.rest.myrest.model.Message;
import com.rest.myrest.service.MessageService;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {
	MessageService service = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public List<Message> getAllJSONMessages(@QueryParam("year") int year,
    									@QueryParam("start") int start,
    									@QueryParam("size") int size) {
       if(year>0)
    	   System.out.println("The year is: "+year);
       System.out.println("In getAllJSONMessages");
       return service.getAllMessages();
    }
	
	@GET
	@Produces(MediaType.TEXT_XML)
    public List<Message> getAllXMLMessages(@QueryParam("year") int year,
    									@QueryParam("start") int start,
    									@QueryParam("size") int size) {
       if(year>0)
    	   System.out.println("The year is: "+year);
       System.out.println("In getAllXMLMessages");
       return service.getAllMessages();
    }
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") int id) {
		return service.getMessage(id);
	}
	
	@POST	
	public Message addMessage(Message message) {
		return service.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") int id, Message message) {
		message.setId(id);
		return service.updateMessage(message);
	}
	
	
	@DELETE
	@Path("/{messageId}")
	public void deletMessage(@PathParam("messageId") int id) {
		service.deletMessage(id);
	}
	
	
	/*This delegates the call to the CommentResource class. So all the calls to /messages/{messageId}/comments will 
	 * passed to CommentResource*/
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
}
