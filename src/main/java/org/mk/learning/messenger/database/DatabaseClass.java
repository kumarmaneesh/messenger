package org.mk.learning.messenger.database;

import java.util.HashMap;
import java.util.Map;
import org.mk.learning.messenger.model.Message;
import org.mk.learning.messenger.model.Profile;

//This should be the JDBC or Hibernate class getting the data from database
//This is not thread-safe. No concurrency implemented

public class DatabaseClass {
	
	private static Map<Long,Message> messages= new HashMap<>();
	//private static Map<Long,Profile> profiles = new HashMap<>();
	private static Map<String,Profile> profiles = new HashMap<>();

	
	public static Map<Long, Message> getMessages(){
		return messages;
	}

	
	public static Map<String, Profile> getProfiles(){
		return profiles;
	}

}
