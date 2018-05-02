package com.example.session2;

import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

public class MyBeanParam {

    @PathParam("p")
    private String pathParam;

    @FormParam("fname")
    private String firstName;

    @HeaderParam("header")
    private String headerParam;

    @QueryParam("q")
    private String queryParam;

    public MyBeanParam(@QueryParam("q") String queryParam) {
        this.queryParam = queryParam;
    }

    public String getPathParam() {
        return pathParam;
    }

    public String getHeaderParam() {
        return headerParam;
    }

    public String getQueryParam() {
        return queryParam;
    }

    public String getFirstName() {
        return firstName;
    }

}
