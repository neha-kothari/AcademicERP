package com.iiitb.academia.service;

import com.iiitb.academia.bean.Domains;
import com.iiitb.academia.bean.Grades;
import com.iiitb.academia.dao.DomainsDAO;
import com.iiitb.academia.dao.GradesDAO;
import com.iiitb.academia.dao.impl.DomainsDAOImpl;
import com.iiitb.academia.dao.impl.GradesDAOImpl;

import java.util.List;

public class DomainsService {

    DomainsDAO domainsDAO = new DomainsDAOImpl();
    public void addGrade(Domains domain){
        domainsDAO.addDomain(domain);
    }

    public List<Domains> getAllDomainsDetails(){
        return domainsDAO.getAllDomainsDetails();
    }

    public Domains fetchDomainDetailsById(Integer id){
        return domainsDAO.getDomainById(id);
    }
}
