package com.iiitb.academia.dao;

import com.iiitb.academia.bean.Domains;

import java.util.List;

public interface DomainsDAO {
    public abstract void addDomain(Domains domain);
    public abstract List<Domains> getAllDomainsDetails();
    public abstract Domains getDomainById(Integer id);
}
