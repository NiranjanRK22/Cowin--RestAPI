package com.cowinapp.controller;


import com.cowinapp.model.Centre;
import com.cowinapp.service.ICentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("centre-api")
public class CentreController {

    private ICentreService centreService;

    @Autowired
    public void setCentreService(ICentreService centreService) {
        this.centreService = centreService;
    }

    @PostMapping("/centres")
    ResponseEntity<Void> addCentre(@RequestBody Centre centre) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Adding new centre");
        centreService.addCentre(centre);
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
    }

    @PutMapping("/centres")
    ResponseEntity<Void> updateCentre(@RequestBody Centre centre) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Updating a centre");
        centreService.updateCentre(centre);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    @DeleteMapping("/centres/{centreId}")
    ResponseEntity<String> deleteCentre(@PathVariable("centreId") int centreId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Deleting a centre");
        centreService.deleteCentre(centreId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body("deleted");
    }

    @GetMapping("/centres/id/{centreId}")
    ResponseEntity<Centre> getCentreById(@PathVariable("centreId") int centreId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting centre by id");
        Centre centre = centreService.getCentreById(centreId);
        return ResponseEntity.ok().headers(headers).body(centre);
    }

    @GetMapping("/centres")
    ResponseEntity<List<Centre>> getAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all centres");
        List<Centre> centres = centreService.getAll();
        ResponseEntity<List<Centre>> centresResponse = new ResponseEntity(centres, headers, HttpStatus.OK);
        return centresResponse;
    }

    @GetMapping("/centres/centreName/{centreName}")
    ResponseEntity<List<Centre>> getByCentreName(@PathVariable("centreName") String centreName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting centres by name");
        List<Centre> centres = centreService.getByCentreName(centreName);
        return ResponseEntity.ok().headers(headers).body(centres);
    }

    @GetMapping("/centres/personId/{personId}")
    ResponseEntity<List<Centre>> getByPerson(@PathVariable("personId") int personId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting centres by person");
        List<Centre> centres = centreService.getByPerson(personId);
        return ResponseEntity.ok().headers(headers).body(centres);
    }

    @GetMapping("/centres/city/{city}")
    ResponseEntity<List<Centre>> getByCity(@PathVariable("city") String city) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting centres by city");
        List<Centre> centres = centreService.getByCity(city);
        return ResponseEntity.ok().headers(headers).body(centres);
    }

    @GetMapping("/centres/state/{state}")
    ResponseEntity<List<Centre>> getByState(@PathVariable("state") String state) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting centres by state");
        List<Centre> centres = centreService.getByState(state);
        return ResponseEntity.ok().headers(headers).body(centres);
    }

    @GetMapping("/centres/vaccineName/{vaccineName}")
    ResponseEntity<List<Centre>> getByVaccine(@PathVariable("vaccineName") String vaccineName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting centres by vaccine");
        List<Centre> centres = centreService.getByVaccine(vaccineName);
        return ResponseEntity.ok().headers(headers).body(centres);
    }

    @GetMapping("/centres/centreName/{centreName}/city/{city}")
    ResponseEntity<List<Centre>> getByCentreAndCity(@PathVariable("centreName") String centreName, @PathVariable("city") String city) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting centres by centre name and city");
        List<Centre> centres = centreService.getByCentreAndCity(centreName, city);
        return ResponseEntity.ok().headers(headers).body(centres);
    }

    @GetMapping("centres/centreName/{centreName}/vaccineName/{vaccineName}")
    ResponseEntity<List<Centre>> getByCentreVaccine(@PathVariable("centreName") String centreName, @PathVariable("vaccineName") String vaccineName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting centres by centre name and vaccine");
        List<Centre> centres = centreService.getByCentreVaccine(centreName, vaccineName);
        return ResponseEntity.ok().headers(headers).body(centres);
    }

    @GetMapping("/centres/pincode/{pincode}")
    ResponseEntity<List<Centre>> getByPincode(@PathVariable("pincode") int pincode) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting centres by pincode");
        List<Centre> centres = centreService.getByPincode(pincode);
        return ResponseEntity.ok().headers(headers).body(centres);
    }

    @GetMapping("/centres/vaccineName/{vaccineName}/city/{city}")
    ResponseEntity<List<Centre>> getByVaccineAndCity(@PathVariable("vaccineName") String vaccineName, @PathVariable("city") String city) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting centres by vaccine and city");
        List<Centre> centres = centreService.getByVaccineAndCity(vaccineName, city);
        return ResponseEntity.ok().headers(headers).body(centres);
    }

    @GetMapping("/centres/vaccineName/{vaccineName}/state/{state}")
    ResponseEntity<List<Centre>> getByVaccineAndState(@PathVariable("vaccineName") String vaccineName, @PathVariable("state") String state) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting centres by vaccine and state");
        List<Centre> centres = centreService.getByVaccineAndState(vaccineName, state);
        return ResponseEntity.ok().headers(headers).body(centres);
    }

    @GetMapping("/centres/centreName/{centreName}/state/{state}")
    ResponseEntity<List<Centre>> getByCentreAndState(@PathVariable("centreName") String centreName, @PathVariable("state") String state) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting centres by centre name and state");
        List<Centre> centres = centreService.getByCentreAndState(centreName, state);
        return ResponseEntity.ok().headers(headers).body(centres);
    }
}
