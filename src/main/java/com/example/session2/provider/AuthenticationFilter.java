package com.example.session2.provider;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

@Provider
public class AuthenticationFilter implements ContainerRequestFilter {
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String AUTH_SCHEME = "Basic";

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        //Get request headers
        final MultivaluedMap<String, String> headers = requestContext.getHeaders();

        //Fetch authorization header
        final List<String> authorization = headers.get(AUTHORIZATION_HEADER);

        if (authorization == null || authorization.isEmpty()) {

            Response denied_response = Response.status(Response.Status.UNAUTHORIZED)
                    .entity("You cannot access this resource").build();
            requestContext.abortWith(denied_response);
            return;
        }

        String encodedUserPassword = authorization.get(0).replaceFirst(AUTH_SCHEME + " ", "");
        String usernameAndPassword = new String(Base64.decode(encodedUserPassword.getBytes()));

    }

}
