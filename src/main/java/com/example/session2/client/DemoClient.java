package com.example.session2.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

public class DemoClient {

    public static void main(String[] args) {
        new DemoClient().aSimpleClient();
    }

    private void aSimpleClient() {

        Client client = ClientBuilder.newClient();
        WebTarget resourceTarget = client.target("http://localhost:8080/myapp").path("beanmap/showbean/1/mps")
                .queryParam("q", "mps");

        //Build POST Entity
        Person entity = new Person();
        entity.setFirstName("deepak");
        // Build a HTTP POST request that accepts "application/json" response type
        // and contains a custom HTTP header entry.
        // An invocation is a request that has been prepared and is ready for execution.
        Invocation invocation = resourceTarget.request("application/json").header("header", "some header value")
                .buildPost(Entity.entity(entity, "application/json"));

        // Invoke the request using generic interface
        //String response = invocation.invoke(String.class);

        Response response2 = invocation.invoke();
        System.out.println("response: " + response2.getStatus());
        System.out.println("response: " + response2.readEntity(String.class));
    }

    private Form getForm() {
        return new Form() {
            {
                MultivaluedMap<String, String> map = this.asMap();
                map.putSingle("firstName", "deepak");
            }
        };
    }
}

class Person {
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
