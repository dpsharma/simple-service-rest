package com.example.session2;

import javax.inject.Singleton;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("beanmap")
@Singleton
public class BeanParamExampleResource {

    //http://localhost:8080/myapp/beanmap/showbean/mps?q=qvalue
    //Content-Type: application/x-www-form-urlencoded
    //header: header=header value
    //Body: fname=deepak
    @Path("showbean/{p}")
    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public String beanMethodParam(@BeanParam MyBeanParam beanParam, String entity) {
        System.out.println("beanMethodParam");
        StringBuilder builder = new StringBuilder();
        builder.append("fomreq - name is: " + beanParam.getFirstName() + "!, <br/>");
        builder.append("path params: " + beanParam.getPathParam() + "!, <br/>");
        builder.append("header params: " + beanParam.getHeaderParam() + "!, <br/>");
        builder.append("query params: " + beanParam.getQueryParam() + "!");
        return builder.toString();
    }

    //http://localhost:8080/myapp/beanmap/showbean/1/mps?q=qvalue
    //Content-Type: application/json
    //header: header=header value
    //Body: fname=deepak
    @Path("showbean/1/{p}")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Person simpleJsonRestResourceMethodProcessor(@BeanParam Person beanParam, Customer personEntity) {
        System.out.println("simpleJsonRestResourceMethodProcessor");
        StringBuilder builder = new StringBuilder();
        builder.append("fomreq - name is: " + personEntity.getFirstName() + "!, <br/>");
        builder.append("path params: " + beanParam.getPathParam() + "!, <br/>");
        builder.append("header params: " + beanParam.getHeaderParam() + "!, <br/>");
        builder.append("query params: " + beanParam.getQueryParam() + "!");
        return beanParam;
    }

    //http://localhost:8080/myapp/beanmap/showbean/2/mps?q=qvalue
    //Content-Type: application/json
    //header: header=header value
    //Body: fname=deepak
    @Path("showbean/2/{p}")
    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public MyBeanParam simpleFormRestResourceMethodProcessor(@BeanParam MyBeanParam beanParam, String entity) {
        System.out.println("simpleFormRestResourceMethodProcessor");
        StringBuilder builder = new StringBuilder();
        builder.append("fomreq - name is: " + beanParam.getFirstName() + "!, <br/>");
        builder.append("path params: " + beanParam.getPathParam() + "!, <br/>");
        builder.append("header params: " + beanParam.getHeaderParam() + "!, <br/>");
        builder.append("query params: " + beanParam.getQueryParam() + "!");
        return beanParam;
    }
}

class Customer {
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
