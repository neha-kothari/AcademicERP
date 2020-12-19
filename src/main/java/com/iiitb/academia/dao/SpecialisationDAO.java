package com.iiitb.academia.dao;

import com.iiitb.academia.bean.Specialisation;

import java.util.List;

public interface SpecialisationDAO {

    public abstract boolean addSpecialisation(Specialisation specialisation);
    public abstract List<Specialisation> getSpecialisationDetails();
    public abstract Specialisation getSpecialisationDetailsById(Integer id);
    public abstract Specialisation getSpecialisationDetailsByCode(String code);
}
