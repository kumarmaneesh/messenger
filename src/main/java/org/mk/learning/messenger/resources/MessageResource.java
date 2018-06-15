package org.mk.learning.messenger.resources;

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

import org.mk.learning.messenger.model.Message;
import org.mk.learning.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {
	
	MessageService ms = new MessageService();
	
/*	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages() {		
		return ms.getAllMessages();
		//return "Hello World!";
	}*/
	
	//GET request with query parameters
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@QueryParam("year") int year,
									 @QueryParam("start") int start,
									 @QueryParam("size") int size) 
	{		
		if (year>0) return ms.getAllMessagesForYear(year);
		
		if (start>0 && size>0) return ms.getAllMessagesPaginated(start, size);
		
		return ms.getAllMessages();

	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message msg) {		
		return ms.addMessage(msg);
	}
	
	@PUT
	@Path("/{msgId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("msgId") long msgId, Message msg) {		
		msg.setId(msgId);
		return ms.updateMessage(msg);
	}
	
	@DELETE
	@Path("/{msgId}")
	public Message removeMessage(@PathParam("msgId") long msgId) {		
		return ms.removeMessage(msgId);
	}
	
	@GET
	@Path("/{msgId}")
	@Produces(MediaType.APPLICATION_XML)
	public Message getMessage(@PathParam("msgId") long msgId) {		
		return ms.getMessage(msgId);
	}
	
	@Path("/{msgId}/comments")
	public CommentResource getCommentResource() {		
		return new CommentResource();
	}
	
}
