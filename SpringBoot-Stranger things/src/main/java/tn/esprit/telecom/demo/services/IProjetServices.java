package tn.esprit.telecom.demo.services;

import tn.esprit.telecom.demo.entites.Projet;

import java.util.List;

public interface IProjetServices {

    Projet addprj(Projet d);
    Projet updateprj(Projet d);
    Projet retrieveprj(Integer idp);

    List<Projet> Showprj();


}
