package tn.esprit.telecom.demo.services;

import tn.esprit.telecom.demo.entites.Universite;

import java.util.List;

public interface IUniversiteServices {
    Universite addUniversite(Universite u);
    Universite updateUniversite(Universite u);
    Universite retrieveUniversite(Integer idUniversite);
    List<Universite> retrieveAllUniversites();
    Universite assignUnToDep(Integer idDepartement, Integer idUniversite);
}
