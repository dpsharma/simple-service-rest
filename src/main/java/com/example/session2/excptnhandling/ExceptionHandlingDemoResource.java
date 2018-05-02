package com.example.session2.excptnhandling;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("exception")
public class ExceptionHandlingDemoResource {

    private Map<String, String> products;

    public ExceptionHandlingDemoResource() {
        products = createProductMap();
    }

    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response findById(@PathParam("id") String id) throws CustomWebException {
        String product = getProductsMap(id);
        if (product != null) {
            return Response.status(200).entity(product).build();
        } else {
            String message = "The product with the id " + id + " does not exist";
            throw new CustomWebException(message, 404);
        }
    }

    private String getProductsMap(String key) {
        return products.get(key);
    }

    private Map<String, String> createProductMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "Reebok");
        map.put("2", "Nike");
        return map;
    }
}
