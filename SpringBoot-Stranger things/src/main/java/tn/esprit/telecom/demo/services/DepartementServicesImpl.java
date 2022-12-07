package tn.esprit.telecom.demo.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.telecom.demo.entites.Contrat;
import tn.esprit.telecom.demo.repositories.IDepartementRepository;
import tn.esprit.telecom.demo.entites.Departement;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class DepartementServicesImpl implements IDepartementServices{
IDepartementRepository departementRepository;

    @Override
    public Departement addDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {
        Departement de=departementRepository.findById(d.getIdDepart()).get();
        de.setNomDepart(d.getNomDepart());

        return departementRepository.save(d);
    }


    @Override
    public Departement retrieveDepartement(Integer idDepart) {
        return  departementRepository.findById(idDepart).orElse(null);
    }

    @Override
    public List<Departement> retrieveAllDepartements() {
        List<Departement> departements=new ArrayList<>();
        departementRepository.findAll().forEach(departements::add);
        return departements;
    }

}
