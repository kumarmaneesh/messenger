package org.mk.learning.messenger.resources;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.mk.learning.messenger.model.Profile;
import org.mk.learning.messenger.service.ProfileService;

@Path("/profiles")
public class ProfileResource {
	
	ProfileService ps = new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Profile> getProfiles() {		
		return ps.getAllProfiles();
	}
	
	@GET
	@Path("/{profileId}")
	@Produces(MediaType.APPLICATION_XML)
	public Profile getProfile(@PathParam("profileId") long pfId) {		
		return ps.getProfile(pfId);
	}
}
