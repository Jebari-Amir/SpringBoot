package tn.esprit.telecom.demo.services;

import tn.esprit.telecom.demo.entites.DetailEquipe;

import java.util.List;

public interface IDetailEquipeServices {
    DetailEquipe addOrUpdateDetailEquipe(DetailEquipe detailEquipe);
    void removeDetailEquipe(Integer idDetailEquipe);
    DetailEquipe retrieveDetailEquipe(Integer idDetailEquipe);
    List<DetailEquipe> retrieveAllDetailEquipe();

}
