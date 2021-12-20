package com.cowinapp.controller;

import com.cowinapp.model.Vaccine;
import com.cowinapp.service.IVaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("vaccine-api")
public class VaccineController {

    private IVaccineService vaccineService;

    @Autowired
    public void setVaccineService(IVaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @PostMapping("/vaccines")
    ResponseEntity<Void> addVaccine(@RequestBody Vaccine vaccine) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Adding new vaccine");
        vaccineService.addVaccine(vaccine);
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
    }

    @PutMapping("/vaccines")
    ResponseEntity<Void> updateVaccine(@RequestBody Vaccine vaccine) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Updating a vaccine");
        vaccineService.updateVaccine(vaccine);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    @DeleteMapping("vaccines/{vaccineId}")
    ResponseEntity<String> deleteVaccine(@PathVariable("vaccineId") int vaccineId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Deleting a vaccine");
        vaccineService.deleteVaccine(vaccineId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body("Deleted");
    }

    @GetMapping("vaccines/id/{vaccineId}")
    ResponseEntity<Vaccine> getVaccineById(@PathVariable("vaccineId") int vaccineId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting vaccine by id");
        Vaccine vaccine = vaccineService.getVaccineById(vaccineId);
        return ResponseEntity.ok().headers(headers).body(vaccine);
    }

    @GetMapping("vaccines/vaccineName/{vaccineName}")
    ResponseEntity<Vaccine> getVaccineByName(@PathVariable("vaccineName") String vaccineName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting vaccine by name");
        Vaccine vaccine = vaccineService.getVaccineByName(vaccineName);
        return ResponseEntity.ok().headers(headers).body(vaccine);
    }
}
