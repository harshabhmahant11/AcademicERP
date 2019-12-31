package com.Controller;

import com.beans.Domain;
import com.dao.DomainDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Path("/domain")
public class DomainController {

    @GET  @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "hi how are you...";
    }


    @POST
    @Path("/modDomain")
    @Produces(MediaType.TEXT_PLAIN)
    public String DomainModify(@FormParam("d_code") String d_code,
                               @FormParam("d_name") String d_name,
                               @FormParam("d_capacity") String d_capacity,
                               @FormParam("d_qualification") String d_qual,
                               @FormParam("d_oldDcode") String old_dcode)
    {
        DomainDao domainDao = new DomainDao();
        Domain d = new Domain();

        d.setD_code(Integer.parseInt(d_code));
        d.setD_qualification(d_qual);
        d.setD_capacity(Integer.parseInt(d_capacity));
        d.setD_name(d_name);

        domainDao.DomainMod(d,Integer.parseInt(old_dcode));
        System.out.println("D Code: "+d_code);
        return "Success";
    }


    @POST
    @Path("/addDomain")
    @Produces(MediaType.TEXT_PLAIN)
    public String DomainAdd(@FormParam("d_code") String d_code,
                               @FormParam("d_name") String d_name,
                               @FormParam("d_capacity") String d_capacity,
                               @FormParam("d_qualification") String d_qual)
    {
        DomainDao domainDao = new DomainDao();
        Domain d = new Domain();

        d.setD_code(Integer.parseInt(d_code));
        d.setD_qualification(d_qual);
        d.setD_capacity(Integer.parseInt(d_capacity));
        d.setD_name(d_name);

       domainDao.DomainAdd(d);
        System.out.println("D Code: "+d_code);
        return "Success";
    }

    @POST
    @Path("/delDomain")
    @Produces(MediaType.TEXT_PLAIN)
    public String DomainDelete(@FormParam("d_code") int d_code)
    {
        DomainDao domainDao = new DomainDao();
        domainDao.DomainDel(d_code);
        System.out.println("D Code: "+d_code);
        return "Success";
    }

    @GET
    @Path("/getAll")
    @Produces({"application/json"})
    public List<Domain> FindEmployee() {

        DomainDao dmDAO=new DomainDao();
        List<Domain> d = dmDAO.getAllDomainData();
        for(Domain d2 : d)
        {
            System.out.println(d2);
        }

        return d;
    }




}
