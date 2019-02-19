package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.DeviceApiService;
import io.swagger.api.factories.DeviceApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;


import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/device")


@io.swagger.annotations.Api(description = "the device API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-02-18T09:12:01.963Z")
public class DeviceApi  {
   private final DeviceApiService delegate;

   public DeviceApi(@Context ServletConfig servletContext) {
      DeviceApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("DeviceApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (DeviceApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = DeviceApiServiceFactory.getDeviceApi();
      }

      this.delegate = delegate;
   }

    @GET
    @Path("/{parameter1}")
    
    @Produces({ "text/json" })
    @io.swagger.annotations.ApiOperation(value = "Runs an external command.", notes = "Runs an external command.", response = Void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Description", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "API key is missing or invalid", response = Void.class) })
    public Response deviceParameter1Get(@ApiParam(value = "Parameter1.",required=true) @PathParam("parameter1") String parameter1
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deviceParameter1Get(parameter1,securityContext);
    }
}
