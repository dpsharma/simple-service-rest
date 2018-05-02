package com.example.session2.excptnhandling;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionMapperProviderDemo implements ExceptionMapper<CustomWebException> {

    @Override
    public Response toResponse(CustomWebException exception) {
        return Response.status(exception.getStatus()).entity(exception.getMessage()).type(MediaType.APPLICATION_JSON)
                .build();
    }

}
