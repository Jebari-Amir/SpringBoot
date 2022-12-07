package tn.esprit.telecom.demo.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.telecom.demo.entites.Contrat;
import tn.esprit.telecom.demo.entites.Etudiant;
import tn.esprit.telecom.demo.repositories.IContratRepository;
import tn.esprit.telecom.demo.repositories.IEtudiantRepository;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class ContratServicesimpl implements IContratServices{
    IContratRepository contratRepository;
    IEtudiantRepository iEtudiantRepository;

    @Override
    public List<Contrat> retrieveAllContrats() {
        List<Contrat> contrats=new ArrayList<>();
        contratRepository.findAll().forEach(contrats::add);
        return contrats;
    }

    @Override
    public Contrat addContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public Contrat updateContrat(Contrat ce) {
      Contrat c=contratRepository.findById(ce.getIdContrat()).get();
      c.setArchive(ce.getArchive());
      c.setDateFinContrat(ce.getDateFinContrat());
      c.setDateDebutContrat(ce.getDateDebutContrat());
      c.setSpecialite(ce.getSpecialite());
      return contratRepository.save(ce);
    }

    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        return contratRepository.findById(idContrat).orElse(null);
    }

    @Override
    public void removeContrat(Integer idContrat) {
        contratRepository.deleteById(idContrat);
    }

    @Override
    public Contrat assignContratToEt(Integer idContrat, Integer idEtudiant) {
        Etudiant e = iEtudiantRepository.findById(idEtudiant).orElse(null);
        Contrat c= contratRepository.findById(idContrat).orElse(null);
        c.setEtudiant(e);
        return contratRepository.save(c);
    }
}
