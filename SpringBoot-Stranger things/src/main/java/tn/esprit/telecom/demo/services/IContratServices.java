package tn.esprit.telecom.demo.services;

import tn.esprit.telecom.demo.entites.Contrat;
import tn.esprit.telecom.demo.entites.Etudiant;

import java.util.List;

public interface IContratServices {
    List<Contrat> retrieveAllContrats();
    Contrat addContrat(Contrat ce);
    Contrat updateContrat(Contrat ce);
    Contrat retrieveContrat(Integer idContrat);
    void removeContrat(Integer idContrat);
    Contrat assignContratToEt(Integer idContrat ,Integer idEtudiant);
}
