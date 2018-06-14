package org.mk.learning.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.mk.learning.messenger.database.DatabaseClass;
import org.mk.learning.messenger.model.Profile;

public class ProfileService {
	
	private Map<Long, Profile> profiles = DatabaseClass.getProfiles();

	public ProfileService() {
		profiles.put(1L, new Profile(1,"Maneesh","Maneesh", "Kumar"));
		profiles.put(2L, new Profile(2,"MK","Mike","Killer"));
	}
	
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}

	//method to get a particular profile
	public Profile getProfile(long id) {
		return profiles.get(id);
	}
	
	//method to update a particular profile
	public Profile updateProfile(long id, Profile pf) {
		return profiles.put(id, pf);
	}
	
	//method to delete a particular profile
	public Profile removeProfile(long id) {
		return profiles.remove(id);
	}

	//method to add a profile
	public Profile addProfile(Profile pf) {
		pf.setId(profiles.size()+1);
		profiles.put(pf.getId(),pf);
		return pf;
		
	}	
}
