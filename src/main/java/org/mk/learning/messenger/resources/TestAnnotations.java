package org.mk.learning.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/testAnnotation")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class TestAnnotations {
	
	@GET
	@Path("/test")
	public String testAnnotations(@MatrixParam("myMatrix") String matrixParam,
								  @HeaderParam("myHeader") String headerParam,
								  @CookieParam("Temp") String cookieParam) {
		return "Matrix Param : " + matrixParam +
				" Header Param: " + headerParam +
				" Cookie Param: " + cookieParam;
	}
	
	@GET
	@Path("/context")
	public String testContext(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
		
		String path = uriInfo.getAbsolutePath().toString();
		String cookies = headers.getCookies().toString();
		
		return "uri info : " + path +
				" Headers " + cookies;
	}

}
