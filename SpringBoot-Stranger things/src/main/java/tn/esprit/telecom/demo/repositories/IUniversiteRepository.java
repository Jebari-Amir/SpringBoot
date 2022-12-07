package tn.esprit.telecom.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.telecom.demo.entites.Universite;

public interface IUniversiteRepository extends CrudRepository<Universite,Integer> {
}
