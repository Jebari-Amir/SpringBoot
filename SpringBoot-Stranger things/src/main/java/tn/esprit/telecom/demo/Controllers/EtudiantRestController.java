package tn.esprit.telecom.demo.Controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.telecom.demo.entites.Contrat;
import tn.esprit.telecom.demo.entites.Etudiant;
import tn.esprit.telecom.demo.services.EmailService;
import tn.esprit.telecom.demo.services.EmailServiceImpl;
import tn.esprit.telecom.demo.services.IEtudiantServices;
import tn.esprit.telecom.demo.services.PdfGenerator;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantRestController {
   IEtudiantServices iEtudiantServices;
   @Autowired
    EmailService emailService;
   @Autowired
    public EtudiantRestController(IEtudiantServices iEtudiantServices) {
        this.iEtudiantServices = iEtudiantServices;
    }

    @GetMapping("/all")
    public List<Etudiant> getAllEtudiant() {
        return iEtudiantServices.retrieveAllEtudiants();
    }

    @PutMapping("/update")
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        return iEtudiantServices.updateEtudiant(e);
    }

    @PostMapping(value = "/add")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        return iEtudiantServices.addEtudiant(e);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteEtudiant(@PathVariable("id") Integer idContrat)
    {
        iEtudiantServices.removeEtudiant(idContrat);
    }

    @PutMapping("assign/{idEt}/{idDep}")
    public Etudiant asignDepToEt(@PathVariable("idEt")Integer idEt,@PathVariable("idDep") Integer idDep){
        return  iEtudiantServices.asignDepToEt(idEt,idDep);
    }

    @PutMapping("assignEtToEq/{idEt}/{idEq}")
    public Etudiant asignEtuToEqq(@PathVariable("idEt")Integer idEtudiant,@PathVariable("idEq") Integer idDepartement){
        return iEtudiantServices.asignEtToEq(idEtudiant, idDepartement);
    }
    @GetMapping("/export-to-pdf")
    public void generatePdfFile(HttpServletResponse response) throws DocumentException, IOException, MessagingException {


        response.setContentType("application/pdf");

        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD_HH_MM_SS");

        String currentDateTime = dateFormat.format(new Date());

        String headerkey = "Content-Disposition";

        String headervalue = "attachment; filename=etudiant" + currentDateTime + ".pdf";

        response.setHeader(headerkey, headervalue);

        List<Etudiant> listEtudiant = iEtudiantServices.retrieveAllEtudiants();

        PdfGenerator generator = new PdfGenerator();

        generator.generateToEtudiant(listEtudiant, response);

        emailService.sendMessageWithAttachmentEtudiant("mohmedaziz.trabelsi@esprit.tn", "liste des etudiant",
                "La liste des etudiants :", "C:\\Users\\micro\\Downloads\\".concat(headervalue.substring(21)));
    }
}
