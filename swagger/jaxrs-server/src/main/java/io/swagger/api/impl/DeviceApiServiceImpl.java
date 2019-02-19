package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-02-18T09:12:01.963Z")
public class DeviceApiServiceImpl extends DeviceApiService {
	@Override
	public Response deviceParameter1Get(String parameter1, SecurityContext securityContext) throws NotFoundException {
		// do some magic!
		return Response.ok("Hello, " + parameter1 + "!").status(200).build();
		// return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK,
		// "magic!")).build();
	}
}
