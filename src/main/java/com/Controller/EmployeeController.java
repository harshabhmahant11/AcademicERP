package com.Controller;

import com.beans.Employee;
import com.dao.EmployeeDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api")
public class EmployeeController {


    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }


    @POST
    @Path("/login")
    //@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String EmployeeLogin(@FormParam("EID") String eid,
                                @FormParam("password") String password)
    {
        int eiid = Integer.parseInt(eid);
        Employee e = new Employee();
        e.setEID(eiid);
        e.setPassword(password);
        EmployeeDao employeeDao = new EmployeeDao();
       // System.out.println("Came from js "+e);
        String ret = employeeDao.EmployeeAuth(e);
        if(ret.equals("true"))
        {
            System.out.println("Login success");
            return "success";

        } else if(ret.equals("notadmin")) {
            System.out.println("Not Admin");
            return "notadmin";
        }
        else
        {
            System.out.println("failed");
            return "failed";
        }
    }
}
