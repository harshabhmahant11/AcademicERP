package com.dao;

import com.Utility.SessionUtil;
import com.beans.Domain;
import com.beans.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDao {

    public List<Student> StudentsEnrolled(int D_code)
    {
        Session session = SessionUtil.getSession();
        session.beginTransaction();


        Query Dquery = session.createQuery("from Domain d where d.D_code=:dcode");
        Dquery.setParameter("dcode", D_code );

        Domain dResult = (Domain) Dquery.getSingleResult();

        //System.out.println(dResult);

        String hql = "FROM Student st WHERE st.D_enrolled=:dom";
        Query query = session.createQuery(hql);
        query.setParameter("dom", dResult );

        List<Student> result  = query.list();
        for(Student d : result)
        {
            System.out.println(d);
        }


        session.getTransaction().commit();
        session.close();


        return result;
    }

}
