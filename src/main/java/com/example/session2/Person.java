package com.example.session2;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

public class Person {
    @PathParam("p")
    private String pathParam;

    private String firstName;

    @HeaderParam("header")
    private String headerParam;

    @QueryParam("q")
    private String queryParam;

    public Person(@QueryParam("q") String queryParam) {
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
