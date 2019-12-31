package com.dao;

import com.Utility.SessionUtil;
import com.beans.Employee;
import org.hibernate.Session;

public class EmployeeDao {

    public String EmployeeAuth(Employee e1)
    {

        Session session = SessionUtil.getSession();
        session.beginTransaction();

        Employee e2 = session.get(Employee.class,e1.getEID());

        session.getTransaction().commit();
        session.close();

        if(e2 == null)
        {
            return "false";
        }

        if(e2.department.getDept_name().equals("Admin"))
        {
            if(e2.getEID() == e1.getEID())
            {
                if(e2.getPassword().equals(e1.getPassword()))
                {
                    return "true";
                }
                else
                {
                    return "false";
                }
            }
        }
        else
        {
            return "notadmin";
        }

        return "false";
    }



}
