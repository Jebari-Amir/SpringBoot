package tn.esprit.telecom.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.telecom.demo.entites.Equipe;

public interface IEquipeRepository extends CrudRepository<Equipe,Integer> {
}
