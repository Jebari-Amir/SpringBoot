package tn.esprit.telecom.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.telecom.demo.entites.Projet;
import tn.esprit.telecom.demo.repositories.IProjetRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProjetServicesImpl implements IProjetServices {
    @Autowired
    private IProjetRepository projetRepository;
    @Override
    public Projet addprj(Projet d) {
        return projetRepository.save(d);
    }

    @Override
    public Projet updateprj(Projet d) {
        Projet de = projetRepository.findById(d.getIdp()).get();
        de.setNomPrj(d.getNomPrj());
        de.setDiscription(d.getDiscription());

        return projetRepository.save(d);
    }


    @Override
    public Projet retrieveprj(Integer idp) {
        return projetRepository.findById(idp).orElse(null);
    }

    @Override
    public List<Projet> Showprj() {
        List<Projet> prj = new ArrayList<>();
        projetRepository.findAll().forEach(prj::add);
        return prj;
    }

}
