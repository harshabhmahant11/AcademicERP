package com.Controller;

import com.beans.Domain;
import com.beans.Student;
import com.dao.DomainDao;
import com.dao.StudentDao;

import javax.ws.rs.*;
import java.util.List;

@Path("/student")
public class StudentController {

    @POST
    @Path("/getStudents")
    @Produces({"application/json"})
    public List<Student> getStudents(@FormParam("d_code") int d_code) {

        StudentDao studentDao = new StudentDao();
        List<Student> res = studentDao.StudentsEnrolled(d_code);

        for(Student s : res)
        {
            System.out.println(s);
        }

        return res;
    }
}
