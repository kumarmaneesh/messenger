package org.mk.learning.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mk.learning.messenger.database.DatabaseClass;
import org.mk.learning.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	//private Map<Long, Message> messages = new HashMap<>();

	
	public MessageService() {
		messages.put(1L, new Message(1,"Hello World!","Maneesh"));
		messages.put(2L, new Message(2,"Hello REST World!","MK"));
	}
	
	//method to get all messages
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	//method to get all messages for an year
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR)==year) 
				messagesForYear.add(message);
			}
		return messagesForYear;
	}
	
	//method to get all messages paginated
	public List<Message> getAllMessagesPaginated(int start, int size){
		ArrayList<Message> paginatedMessages = new ArrayList<Message>(messages.values());
			if(start+size > paginatedMessages.size()) return new ArrayList<>();
			
			return paginatedMessages.subList(start, start+size);
	}
	
	//method to get a particular message
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	//method to update a particular message
	public Message updateMessage(Message msg) {
		if(msg.getId()<=0) {
			return null;
		}else {
		messages.put(msg.getId(),msg);
		return msg;
		}
	}
	
	//method to delete a particular message
	public Message removeMessage(long id) {
		return messages.remove(id);
	}

	//method to add a message
	public Message addMessage(Message msg) {
		msg.setId(messages.size()+1);
		messages.put(msg.getId(),msg);
		return msg;
		
	}	
}
