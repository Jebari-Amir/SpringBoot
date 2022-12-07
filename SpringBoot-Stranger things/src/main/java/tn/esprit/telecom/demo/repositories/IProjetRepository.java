package tn.esprit.telecom.demo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.telecom.demo.entites.Information;
import tn.esprit.telecom.demo.entites.Projet;

public interface IProjetRepository extends CrudRepository<Projet,Integer> {

    Page<Projet> findAll(Pageable pageable);

    Page<Projet> findByNomPrj(String nomPrj, Pageable pageable);
}
