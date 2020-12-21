package com.iiitb.academia.dao.impl;

import com.iiitb.academia.bean.Domains;
import com.iiitb.academia.dao.DomainsDAO;
import com.iiitb.academia.util.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class DomainsDAOImpl implements DomainsDAO {

    @Override
    public void addDomain(Domains domain) {
        try(Session session = SessionUtil.getSession())
        {
            session.beginTransaction();
            Integer id  = (Integer)session.save(domain);
            System.out.println("Domain created with id:"+id);
            session.getTransaction().commit();
        }
        catch (HibernateException e){
            System.out.print(e.getLocalizedMessage());
        }
    }

    @Override
    public List<Domains> getAllDomainsDetails() {
        Session session = SessionUtil.getSession();
        List<Domains> domains = new ArrayList<>();
        try {
            for (final Object domain : session.createQuery("from Domains ").list()) {
                domains.add((Domains) domain);
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return domains;
    }

    @Override
    public Domains getDomainById(Integer id) {
        Session session = SessionUtil.getSession();
        try {
            return session.get(Domains.class, id);
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }
}
