package tn.esprit.telecom.demo.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.telecom.demo.entites.Universite;
import tn.esprit.telecom.demo.entites.Departement;
import tn.esprit.telecom.demo.repositories.IDepartementRepository;
import tn.esprit.telecom.demo.repositories.IUniversiteRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class UniversiteServicesImpl implements IUniversiteServices{
    IUniversiteRepository universiteRepository;
    IDepartementRepository departementRepository;

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {

        Universite u1=universiteRepository.findById(u.getIdUniv()).get();
        u1.setNomUniv(u.getNomUniv());
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public List<Universite> retrieveAllUniversites() {
        List<Universite> universites=new ArrayList<>();
        universiteRepository.findAll().forEach(universites::add);
        return universites;
    }

    @Override
    public Universite assignUnToDep(Integer idDepartement, Integer idUniversite) {
        Universite u = universiteRepository.findById(idUniversite).orElse(null);
        Departement d = departementRepository.findById(idDepartement).orElse(null);
        if (u.getDepartements()==null){
            Set<Departement> departements = new HashSet<Departement>();
            departements.add(d);
            u.setDepartements(departements);
        }else {
            u.getDepartements().add(d);
        }
        return universiteRepository.save(u);
    }
}
