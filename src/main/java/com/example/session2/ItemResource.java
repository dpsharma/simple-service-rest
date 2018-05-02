package com.example.session2;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("/item")
public class ItemResource {
    @Context
    UriInfo uriInfo;

    //http://localhost:8080/myapp/item/content   -- @Get
    //http://localhost:8080/myapp/item/content/123  -- @Put
    @Path("content")
    public ItemContentResource subResourceLocator() {
        System.out.println("subResourceLocator");
        return new ItemContentResource();
    }

    //http://localhost:8080/myapp/item   -- @Get
    //http://localhost:8080/myapp/item/123  -- @Put
    @Path("/")
    public Class<ItemContentResource> subResourceLocatorWithEmptyPath() {
        System.out.println("subResourceLocatorWithEmptyPath");
        return ItemContentResource.class;
    }

}