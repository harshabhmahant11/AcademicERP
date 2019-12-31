package com.dao;

import com.Utility.SessionUtil;
import com.beans.Domain;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DomainDao {

    public List<Domain> getAllDomainData()
    {
        Session session = SessionUtil.getSession();
        session.beginTransaction();
        Query q  = session.createQuery("from com.beans.Domain");
        List<Domain> domains = q.list();
        session.close();
        return domains;
    }

public String DomainDel(int d_code)
{
    Session session = SessionUtil.getSession();
    session.beginTransaction();

    Query Dquery = session.createQuery("from Domain d where d.D_code=:dcode");
    Dquery.setParameter("dcode", d_code );

    Domain dResult = (Domain) Dquery.getSingleResult();

    Domain d =new Domain();

    d= session.load(Domain.class,dResult.getD_id());

    session.delete(d);
    session.flush();

    session.getTransaction().commit();
    session.close();

    return "success";
}

public void DomainMod(Domain dnew,int old_dcode)
{
    Session session = SessionUtil.getSession();
    session.beginTransaction();

    Query Dquery = session.createQuery("from Domain d where d.D_code=:dcode");
    Dquery.setParameter("dcode", old_dcode );

    Domain dResult = (Domain) Dquery.getSingleResult();

    Domain d =new Domain();

    d= session.load(Domain.class,dResult.getD_id());


    d.setD_code(dnew.getD_code());
    d.setD_name(dnew.getD_name());
    d.setD_capacity(dnew.getD_capacity());
    d.setD_qualification(dnew.getD_qualification());

    session.getTransaction().commit();
    session.close();


}

public void DomainAdd(Domain d)
{
    Session session = SessionUtil.getSession();
    session.beginTransaction();

    session.save(d);

    session.getTransaction().commit();
    session.close();
}

}
