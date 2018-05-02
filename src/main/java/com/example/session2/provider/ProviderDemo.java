package com.example.session2.provider;

import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

@Provider
public class ProviderDemo implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        System.out.println("--request headers-----");
        MultivaluedMap<String, String> headers = requestContext.getHeaders();
        Set<Entry<String, List<String>>> set = headers.entrySet();
        for (Entry<String, List<String>> entry : set) {
            System.out.println(entry);
        }
    }

}
