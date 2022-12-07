package tn.esprit.telecom.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.telecom.demo.entites.Contrat;
import tn.esprit.telecom.demo.services.IContratServices;

import java.util.List;

@RestController
@RequestMapping("/contrat")
public class ContratRestController {

    IContratServices iContratServices;

    @Autowired
    public ContratRestController(IContratServices iContratServices) {
        this.iContratServices = iContratServices;
    }

    @GetMapping("/all")
    public List<Contrat> getAllContrats() {
        return iContratServices.retrieveAllContrats();
    }

    @PutMapping("/update")
    public Contrat updateContrat(@RequestBody Contrat c) {
        return iContratServices.updateContrat(c);
    }

    @PostMapping("/add")
    public Contrat addContrat(@RequestBody Contrat ce) {
        return iContratServices.addContrat(ce);
    }

    @GetMapping("get/{id}")
    public Contrat getContrat(@PathVariable("id") Integer idContrat)
    {
        return iContratServices.retrieveContrat(idContrat);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteContrat(@PathVariable("id") Integer idContrat)
    {
        iContratServices.removeContrat(idContrat);
    }

    @PutMapping("/assignCntToEt/{idCon}/{idEt}")
    public Contrat assignCntToEt(@PathVariable("idCon") Integer idContrat,@PathVariable("idEt") Integer idEtudiant){
        return iContratServices.assignContratToEt(idContrat,idEtudiant);
    }
}