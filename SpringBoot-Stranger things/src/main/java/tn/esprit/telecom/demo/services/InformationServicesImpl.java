package tn.esprit.telecom.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.telecom.demo.entites.Departement;
import tn.esprit.telecom.demo.entites.Information;
import tn.esprit.telecom.demo.repositories.IInformationRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class InformationServicesImpl  implements IInformationServices{
    @Autowired
    IInformationRepository informationRepository;

    @Override
    public Information addInfo(Information d) {
        return informationRepository.save(d);
    }

    @Override
    public Information updateInfo(Information d) {
        Information de=informationRepository.findById(d.getIdInf()).get();
        de.setPhotoperso(d.getPhotoperso());
        de.setMoyen(d.getMoyen());
        return informationRepository.save(de);
    }


    @Override
    public Information retrieveInfo(Integer idInf) {
        return  informationRepository.findById(idInf).orElse(null);
    }

    @Override
    public List<Information> ShowInf() {
        List<Information> infs=new ArrayList<>();
        informationRepository.findAll().forEach(infs::add);
        return infs;
    }

}
