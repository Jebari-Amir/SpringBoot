package tn.esprit.telecom.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.telecom.demo.entites.Departement;

public interface IDepartementRepository  extends CrudRepository<Departement,Integer> {
}
