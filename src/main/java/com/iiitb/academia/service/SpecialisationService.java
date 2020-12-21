package com.iiitb.academia.service;

import com.iiitb.academia.bean.Specialisation;
import com.iiitb.academia.dao.SpecialisationDAO;
import com.iiitb.academia.dao.impl.SpecialisationDAOImpl;

import java.util.List;

public class SpecialisationService {
    SpecialisationDAO specialisationDAO=new SpecialisationDAOImpl(); 
        
        public boolean addSpecialisation(Specialisation specialisation) {
            return false;
        }
        
        public List<Specialisation> getSpecialisationDetails() {
            return specialisationDAO.getSpecialisationDetails();
        }
        
        public Specialisation getSpecialisationDetailsById(Integer id) {
            return specialisationDAO.getSpecialisationDetailsById(id);
        }
        
        public Specialisation getSpecialisationDetailsByCode(String code) {
            return getSpecialisationDetailsByCode(code);
        }
}

