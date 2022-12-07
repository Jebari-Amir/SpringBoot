package tn.esprit.telecom.demo.services;

import tn.esprit.telecom.demo.entites.Departement;

import java.util.List;

public interface IDepartementServices {
    Departement addDepartement(Departement d);
    Departement updateDepartement(Departement d);
    Departement retrieveDepartement(Integer idDepart);
    List<Departement>retrieveAllDepartements();


}
