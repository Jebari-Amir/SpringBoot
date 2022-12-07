package tn.esprit.telecom.demo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.telecom.demo.entites.Information;

public interface IInformationRepository extends CrudRepository<Information,Integer> {

    Page<Information> findAll(Pageable pageable);
    Page<Information> findByPhotoperso(String photoperso, Pageable pageable);

}
