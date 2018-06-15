package org.mk.learning.messenger.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mk.learning.messenger.database.DatabaseClass;
import org.mk.learning.messenger.model.Profile;

public class ProfileService {
	
	private Map<String,Profile> profiles = DatabaseClass.getProfiles();
	//private Map<String,Profile> profiles = new HashMap<>();

	
	public ProfileService() {
		profiles.put("Maneesh", new Profile(1,"Maneesh", "Maneesh","Kumar"));
		profiles.put("Alex", new Profile(2,"Alex", "Alex","Dsouza"));
		profiles.put("Bob", new Profile(3,"Bob", "Bob","Boon"));
		profiles.put("Charlie", new Profile(4,"Charlie", "Charlie","Brown"));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName){
		if(profiles.containsKey(profileName))
			return profiles.get(profileName);
		else
			return null;
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(String profileName, Profile profile) {
		if(profiles.containsKey(profileName))
		{
			profile.setId(profiles.get(profileName).getId());
			profiles.put(profileName, profile);
			return profile;
		}
		else 
			return null;
	}
	
	public void removeProfile(String profileName) {
		if(profiles.containsKey(profileName))
			profiles.remove(profileName);
	}

}
