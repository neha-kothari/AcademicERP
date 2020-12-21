package com.iiitb.academia.dao.impl;

import com.iiitb.academia.bean.Specialisation;
import com.iiitb.academia.dao.SpecialisationDAO;
import com.iiitb.academia.util.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class SpecialisationDAOImpl implements SpecialisationDAO {
    @Override
    public boolean addSpecialisation(Specialisation specialisation) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(specialisation);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public List<Specialisation> getSpecialisationDetails() {
        Session session = SessionUtil.getSession();
        List<Specialisation> specialisations = new ArrayList<>();
        try {
            for (final Object sp : session.createQuery("from Specialisation ").list()) {
                specialisations.add((Specialisation) sp);
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return specialisations;
    }

    @Override
    public Specialisation getSpecialisationDetailsById(Integer id) {
        Session session = SessionUtil.getSession();
        try {
            return session.get(Specialisation.class, id);
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public Specialisation getSpecialisationDetailsByCode(String code) {
        Session session = SessionUtil.getSession();
        try {
            Query query = session.createQuery("from Specialisation where code like :code");
            query.setParameter("code", code);
            for (final Object fetch : query.list()) {
                return (Specialisation) fetch;
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        return null;
    }
}