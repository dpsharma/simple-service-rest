package com.example.session2;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("matrixparams")
public class ParamsAnnotatiosResource2 {

    //http://localhost:8080/myapp/matrixparams;fname=value1;lname=value2;qual=value3
    @GET
    @Produces("application/json")
    public String matrixParamDemo(@MatrixParam("fname") String fname, @MatrixParam("lname") String lname,
            @MatrixParam("qual") String qual) {
        return "fname " + fname + ", lname " + lname + ", qual " + qual;
    }
}
