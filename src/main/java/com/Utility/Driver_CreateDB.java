package com.Utility;

import com.beans.Department;
import com.beans.Domain;
import com.beans.Employee;
import com.beans.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Driver_CreateDB {

    public static void main(String args[])
    {
        Domain domain = new Domain();
        domain.setD_code(103);
        domain.setD_capacity(150);
        domain.setD_qualification("BTech-CSE");
        domain.setD_name("MTech-CSE");

        Domain domain1 = new Domain();
        domain1.setD_code(212);
        domain1.setD_capacity(60);
        domain1.setD_qualification("12TH");
        domain1.setD_name("IMtech-ECE");

        Domain domain2 = new Domain();
        domain2.setD_code(123);
        domain2.setD_capacity(150);
        domain2.setD_qualification("BTech-ECE");
        domain2.setD_name("MTech-ECE");

        Domain domain3 = new Domain();
        domain3.setD_code(777);
        domain3.setD_capacity(60);
        domain3.setD_qualification("12TH");
        domain3.setD_name("DigiSOC");


        Session session = SessionUtil.getSession();
        session.beginTransaction();



        Department d1 = new Department();
        d1.setDept_id(1);
        d1.setDept_name("Admin");

        Department d2 = new Department();
        d2.setDept_id(2);
        d2.setDept_name("Teaching");

        Student s1 = new Student();
        s1.setRoll_no(101);
        s1.setName("Harshabh");
        s1.setD_enrolled(domain);

        Student s2 = new Student();
        s2.setRoll_no(102);
        s2.setName("Saurabh");
        s2.setD_enrolled(domain1);

        Student s3 = new Student();
        s3.setRoll_no(103);
        s3.setName("Alex");
        s3.setD_enrolled(domain2);

        Student s4 = new Student();
        s4.setRoll_no(104);
        s4.setName("Ram");
        s4.setD_enrolled(domain3);

        Student s5 = new Student();
        s5.setRoll_no(105);
        s5.setName("Raghav");
        s5.setD_enrolled(domain2);

        Student s6 = new Student();
        s6.setRoll_no(106);
        s6.setName("Parth");
        s6.setD_enrolled(domain1);

        Student s7 = new Student();
        s7.setRoll_no(107);
        s7.setName("Arvind");
        s7.setD_enrolled(domain2);



        Employee e1 = new Employee();
        e1.setEID(101);
        e1.setPassword("101");
        e1.setDepartment(d1);

        Employee e2 = new Employee();
        e2.setEID(201);
        e2.setPassword("202");
        e2.setDepartment(d2);

        Employee e3 = new Employee();
        e3.setEID(102);
        e3.setPassword("102");
        e3.setDepartment(d1);


        session.save(d1);
        session.save(d2);
        session.save(e1);
        session.save(e2);
        session.save(e3);

        session.save(domain);
        session.save(domain1);
        session.save(domain2);
        session.save(domain3);

        session.save(s1);
        session.save(s2);
        session.save(s3);
        session.save(s4);
        session.save(s5);
        session.save(s6);
        session.save(s7);

        session.flush();
        session.getTransaction().commit();
        session.close();

    }

}
