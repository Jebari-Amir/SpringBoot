package tn.esprit.telecom.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.telecom.demo.entites.Equipe;
import tn.esprit.telecom.demo.entites.Universite;
import tn.esprit.telecom.demo.services.IUniversiteServices;

import java.util.List;

@RestController
@RequestMapping("/universite")
public class UniversiteRestController {

    IUniversiteServices iUniversiteServices;

    @Autowired
    public UniversiteRestController(IUniversiteServices iUniversiteServices) {
        this.iUniversiteServices = iUniversiteServices;
    }

    @GetMapping("/all")
    public List<Universite> getAllUniversite() {
        return iUniversiteServices.retrieveAllUniversites();
    }

    @PutMapping("/update")
    public Universite updateUniversite(@RequestBody Universite u) {
        return iUniversiteServices.updateUniversite(u);
    }

    @PostMapping("/add")
    public Universite addUniversite(@RequestBody Universite u) {
        return iUniversiteServices.addUniversite(u);
    }

    @GetMapping("get/{id}")
    public Universite getUniversite(@PathVariable("id") Integer idUniversite)
    {
        return iUniversiteServices.retrieveUniversite(idUniversite);
    }

    @PutMapping("/assignUnToDep/{idDepart}/{idUn}")
    public Universite assignUnToDep(@PathVariable("idDepart") Integer idDepartement , @PathVariable("idUn") Integer idUniversite ){
        return iUniversiteServices.assignUnToDep(idDepartement,idUniversite);
    }
}
