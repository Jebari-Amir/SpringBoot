package tn.esprit.telecom.demo.Controllers;

import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.telecom.demo.entites.Departement;
import tn.esprit.telecom.demo.entites.Equipe;
import tn.esprit.telecom.demo.entites.Etudiant;
import tn.esprit.telecom.demo.services.EmailService;
import tn.esprit.telecom.demo.services.IEquipeServices;
import tn.esprit.telecom.demo.services.PdfGenerator;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/equipe")
public class EquipeRestController {
     IEquipeServices iEquipeServices;
    @Autowired
    EmailService emailService;
    @Autowired
    public EquipeRestController(IEquipeServices iEquipeServices) {
        this.iEquipeServices = iEquipeServices;
    }

    @GetMapping("/all")
    public List<Equipe> getAllEquipe() {
        return iEquipeServices.retrieveAllEquipes();
    }

    @PutMapping("/update")
    public Equipe updateEquipe(@RequestBody Equipe e) {
        return iEquipeServices.updateEquipe(e);
    }

    @PostMapping("/add")
    public Equipe addEquipe(@RequestBody Equipe e) {
        return iEquipeServices.addEquipe(e);
    }

    @GetMapping("get/{id}")
    public Equipe getEquipe(@PathVariable("id") Integer idEquipe)
    {
        return iEquipeServices.retrieveEquipe(idEquipe);
    }
    @GetMapping("/export-to-pdf")
    public void generatePdfFile(HttpServletResponse response) throws DocumentException, IOException, MessagingException {


        response.setContentType("application/pdf");

        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD_HH_MM_SS");

        String currentDateTime = dateFormat.format(new Date());

        String headerkey = "Content-Disposition";

        String headervalue = "attachment; filename=equipe" + currentDateTime + ".pdf";

        response.setHeader(headerkey, headervalue);

        List<Equipe> listEquipe = iEquipeServices.retrieveAllEquipes();

        PdfGenerator generator = new PdfGenerator();

        generator.generateToEquipe(listEquipe, response);

        emailService.sendMessageWithAttachmentEquipe("mohmedaziz.trabelsi@esprit.tn", "liste des equipe",
                "La liste des equipes :", "C:\\Users\\micro\\Downloads\\".concat(headervalue.substring(21)));
    }
}
