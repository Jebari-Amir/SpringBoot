package tn.esprit.telecom.demo.services;

import tn.esprit.telecom.demo.entites.Etudiant;

import java.util.List;

public interface IEtudiantServices {
    List<Etudiant>retrieveAllEtudiants();
    Etudiant addEtudiant(Etudiant etudiant);
    Etudiant updateEtudiant(Etudiant e);
    Etudiant retrieveEtudiant(Integer idEtudiant);
    void removeEtudiant(Integer idEtudiant);
    Etudiant asignDepToEt(Integer idEt,Integer idDep);

    Etudiant asignEtToEq(Integer idEtudiant,Integer idEquipe);

}



