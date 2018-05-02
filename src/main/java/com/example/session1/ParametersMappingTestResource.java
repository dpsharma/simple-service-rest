package com.example.session1;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("paramdemo")
public class ParametersMappingTestResource {

    //simple demo
    @Path("sayhi")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHi() {
        return "hi";
    }

    @Path("start")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    //example: query params
    @Path("queryparams")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String queryParams(@DefaultValue("2") @QueryParam("step") int step,
            @DefaultValue("true") @QueryParam("b-test") boolean btest) {
        System.out.println(step);
        System.out.println(btest);
        return "hello - queryParams";
    }

    //example: query param - mapped
    @Path("customtype")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String customType(@DefaultValue("blue") @QueryParam("color") ColorParam color) {
        System.out.println("color: " + color);
        return "hello - custom type params";
    }

    //example: form request
    @Path("formreq")
    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces("text/plain")
    public String post(@FormParam("fname") String name) {
        StringBuilder builder = new StringBuilder();
        builder.append("fomr name input is " + name + "!, ");
        return "fomr name input is " + name + "!";
    }
}
