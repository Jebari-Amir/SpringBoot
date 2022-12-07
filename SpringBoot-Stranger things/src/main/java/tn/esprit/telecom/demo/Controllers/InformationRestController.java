package tn.esprit.telecom.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.telecom.demo.entites.Information;
import tn.esprit.telecom.demo.repositories.IInformationRepository;
import tn.esprit.telecom.demo.services.IInformationServices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/info")
public class InformationRestController {

    IInformationServices informationServices;
    @Autowired
    IInformationRepository iInformationRepository;

    @Autowired
        public InformationRestController(IInformationServices informationServices) {
        this.informationServices = informationServices;
    }


    @GetMapping("/all")
    public List<Information> getAllInformation() {
        return informationServices.ShowInf();
    }

    @PutMapping("/update")
    public Information updateInformation(@RequestBody Information d) {
        return informationServices.updateInfo(d);
    }

    @PostMapping("/add")
    public Information addInformation(@RequestBody Information d) {
        return informationServices.addInfo(d);
    }

    @GetMapping("get/{id}")
    public Information getInformation(@PathVariable("id") Integer idInfo)
    {
        return informationServices.retrieveInfo(idInfo);
    }
    @GetMapping("/infos")
    public ResponseEntity<Map<String, Object>> getAllInfos(
            @RequestParam(required = false) String photoperso,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "1") int size
    ) {

        try {
            List<Information> infos = new ArrayList<Information>();
            Pageable paging = PageRequest.of(page, size);

            Page<Information> pageTuts;
            if (photoperso == null)
                pageTuts = iInformationRepository.findAll(paging);
            else
                pageTuts = iInformationRepository.findByPhotoperso(photoperso, paging);

            infos = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("information", infos);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
