package tn.esprit.telecom.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.telecom.demo.entites.Etudiant;

public interface IEtudiantRepository extends CrudRepository<Etudiant,Integer> {
}
