package tn.esprit.telecom.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.telecom.demo.entites.Information;
import tn.esprit.telecom.demo.entites.Projet;
import tn.esprit.telecom.demo.repositories.IProjetRepository;
import tn.esprit.telecom.demo.services.IInformationServices;
import tn.esprit.telecom.demo.services.IProjetServices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/prj")
public class ProjetRestController {

    @Autowired
    IProjetServices projetServices;
    @Autowired
    IProjetRepository projetRepository;

/*
    @Autowired
    public ProjetRestController(IInformationServices projetServices) {
        this.projetServices = projetServices;
    }
*/


    @GetMapping("/all")
    public List<Projet> getAllInformation() {
        return projetServices.Showprj();
    }

    @PutMapping("/update")
    public Projet updateInformation(@RequestBody Projet d) {
        return projetServices.updateprj(d);
    }

    @PostMapping("/add")
    public Projet addInformation(@RequestBody Projet d) {
        return projetServices.addprj(d);
    }

    @GetMapping("get/{id}")
    public Projet getInformation(@PathVariable("id") Integer idp)
    {
        return projetServices.retrieveprj(idp);
    }

    @GetMapping("/projects")
    public ResponseEntity<Map<String, Object>> getAllProjects(
            @RequestParam(required = false) String nomPrj,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "1") int size
    ) {

        try {
            List<Projet> projets = new ArrayList<Projet>();
            Pageable paging = PageRequest.of(page, size);

            Page<Projet> pageTuts;
            if (nomPrj == null)
                pageTuts = projetRepository.findAll(paging);
            else
                pageTuts = projetRepository.findByNomPrj(nomPrj, paging);

            projets = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("projets", projets);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
