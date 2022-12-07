package tn.esprit.telecom.demo.services;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esprit.telecom.demo.entites.Departement;
import tn.esprit.telecom.demo.entites.DetailEquipe;
import tn.esprit.telecom.demo.entites.Universite;
import tn.esprit.telecom.demo.repositories.IDetailEquipeRepository;
import tn.esprit.telecom.demo.entites.Equipe;
import tn.esprit.telecom.demo.repositories.IEquipeRepository;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class EquipeServicesImpl implements IEquipeServices{
    IEquipeRepository equipeRepository;
    IDetailEquipeRepository detailEquipeRepository;

    @Override
    public Equipe addEquipe(Equipe e) {
        DetailEquipe de=detailEquipeRepository.save(e.getDetailEquipe());
        e.setDetailEquipe(de);
            return equipeRepository.save(e) ;
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
      Equipe eq= equipeRepository.findById(e.getIdEquipe()).get();
      eq.setDetailEquipe(e.getDetailEquipe());
      eq.setNomEquipe(e.getNomEquipe());
      eq.setNiveau(e.getNiveau());
      eq.setEtudiants(e.getEtudiants());
       return equipeRepository.save(eq);

    }

    @Override
    public Equipe retrieveEquipe(Integer idEquipe) {
        return equipeRepository.findById(idEquipe).orElse(null);
    }

    @Override
    public List<Equipe> retrieveAllEquipes() {
        List<Equipe> equipes=new ArrayList<>();
        equipeRepository.findAll().forEach(equipes::add);
        return equipes;
    }


}
