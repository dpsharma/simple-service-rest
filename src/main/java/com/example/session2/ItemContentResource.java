package com.example.session2;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Singleton
public class ItemContentResource {

    @GET
    public Response get() {
        System.out.println("ItemContentResource : get " + this.hashCode());
        return null;
    }

    @PUT
    @Path("{version}")
    public void put(@PathParam("version") int version) {
        System.out.println("ItemContentResource : put " + this.hashCode());
    }
}
