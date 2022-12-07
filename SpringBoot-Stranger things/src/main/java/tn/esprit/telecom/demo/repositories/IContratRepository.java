package tn.esprit.telecom.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.telecom.demo.entites.Contrat;

public interface IContratRepository extends CrudRepository<Contrat,Integer> {
}
