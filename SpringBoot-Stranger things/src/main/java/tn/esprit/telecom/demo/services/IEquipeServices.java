package tn.esprit.telecom.demo.services;


import tn.esprit.telecom.demo.entites.Departement;
import tn.esprit.telecom.demo.entites.Equipe;

import java.util.List;

public interface IEquipeServices {
    Equipe addEquipe(Equipe e);
    Equipe updateEquipe(Equipe e);
    Equipe retrieveEquipe(Integer idEquipe);
    List<Equipe> retrieveAllEquipes();
}
