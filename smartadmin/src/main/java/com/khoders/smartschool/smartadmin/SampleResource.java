package com.khoders.smartschool.smartadmin;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


@Path("sample")
public class SampleResource {

	@Inject
	private String message;

	@GET
	public Response message() {
		return Response.ok(message).build();
	}

}
