package com.example.session2.excptnhandling;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;

public class ExceptionHandlingDemoResourceTest extends JerseyTest {

    @Override
    public Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        return new ResourceConfig().register(ExceptionHandlingDemoResource.class)
                .register(ExceptionMapperProviderDemo.class);
    }

    @Test
    public void testResourceWhenIdDoesnotExists() {
        int id = 3;
        Response output = target("exception/" + id).request().get();
        assertEquals("should return status 404", 404, output.getStatus());
        String actualMsg = output.readEntity(String.class);
        assertEquals("Expected message", "The product with the id " + id + " does not exist", actualMsg);
    }

    @Test
    public void testResourceWhenIdExists() {
        int id = 1;
        Response output = target("exception/" + id).request().get();
        assertEquals("should return status 200", 200, output.getStatus());
        String actualMsg = output.readEntity(String.class);
        assertEquals("Expected message", "Reebok", actualMsg);
    }
}