package tn.esprit.telecom.demo.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.telecom.demo.entites.Departement;
import tn.esprit.telecom.demo.entites.Equipe;
import tn.esprit.telecom.demo.repositories.IDepartementRepository;
import tn.esprit.telecom.demo.repositories.IEquipeRepository;
import tn.esprit.telecom.demo.repositories.IEtudiantRepository;
import tn.esprit.telecom.demo.entites.Etudiant;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class  EtudiantServicesImpl implements IEtudiantServices{
IEtudiantRepository etudiantRepository;

    IDepartementRepository iDepartementRepository;
    IEquipeRepository iEquipeRepository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        List<Etudiant> users=new ArrayList<>();
        etudiantRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {

        Etudiant eq=etudiantRepository.findById(e.getIdetudiant()).get();
        eq.setNomE(e.getNomE());
        eq.setOption(e.getOption());
        eq.setPrenomE(e.getPrenomE());
        return etudiantRepository.save(eq);
    }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant) {
       return etudiantRepository.findById(idEtudiant).orElse(null);
    }


    @Override
    public void removeEtudiant(Integer idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }
    @Override
    public Etudiant asignDepToEt(Integer idEt, Integer idDep) {
        Etudiant e= etudiantRepository.findById(idEt).orElse(null);
        Departement d = iDepartementRepository.findById(idDep).orElse(null);
        e.setDepartement(d);
        return etudiantRepository.save(e);
    }
    @Override
    public Etudiant asignEtToEq(Integer idEtudiant, Integer idEquipe) {
        Etudiant e= etudiantRepository.findById(idEtudiant).orElse(null);
        Equipe eq= iEquipeRepository.findById(idEquipe).orElse(null);
        if (e.getEquipes()==null){
            Set<Equipe> equipes = new HashSet<Equipe>();
            equipes.add(eq);
            e.setEquipes(equipes);
        }else{
            e.getEquipes().add(eq);
        }
        return etudiantRepository.save(e);
    }
}
