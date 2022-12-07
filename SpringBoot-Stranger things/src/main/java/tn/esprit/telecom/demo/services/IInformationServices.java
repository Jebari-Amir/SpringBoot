package tn.esprit.telecom.demo.services;


import tn.esprit.telecom.demo.entites.Information;

import java.util.List;

public interface IInformationServices {

    Information addInfo(Information d);
    Information updateInfo(Information d);
    Information retrieveInfo(Integer idInf);

    List<Information>ShowInf();



}
