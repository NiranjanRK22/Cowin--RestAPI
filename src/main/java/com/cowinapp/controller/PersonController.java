package com.cowinapp.controller;

import com.cowinapp.model.Person;
import com.cowinapp.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("person-api")
public class PersonController {

    private IPersonService personService;

    @Autowired
    public void setPersonService(IPersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all persons");
        List<Person> persons = personService.getAll();
        ResponseEntity<List<Person>> personsResponse = new ResponseEntity(persons, headers, HttpStatus.OK);
        return  personsResponse;
    }

    @GetMapping("/persons/id/{personId}")
    public ResponseEntity<Person> getByPersonId(@PathVariable("personId") int personId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting person by id");
        Person person = personService.getByPersonId(personId);
        return ResponseEntity.ok().headers(headers).body(person);
    }

    @GetMapping("/persons/personName/{personName}")
    public ResponseEntity<List<Person>> getByPersonName(@PathVariable("personName") String personName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting persons by name");
        List<Person> persons = personService.getByPersonName(personName);
        return ResponseEntity.ok().headers(headers).body(persons);
    }

    @GetMapping("/persons/age/{age}")
    ResponseEntity<List<Person>> getByAgeLessThan(@PathVariable("age") int age)  {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting persons by age");
        List<Person> persons = personService.getByAgeLessThan(age);
        return ResponseEntity.ok().headers(headers).body(persons);
    }

    @GetMapping("/persons/gender/{gender}")
    ResponseEntity<List<Person>> getByGender(@PathVariable("gender") String gender) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting persons by gender");
        List<Person> persons = personService.getByGender(gender);
        return ResponseEntity.ok().headers(headers).body(persons);
    }

    @GetMapping("/persons/gender/{gender}/age/{age}")
    ResponseEntity<List<Person>> getByGenderAndAge(@PathVariable("personName") String gender,@PathVariable("age") int age) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting persons by gender and age");
        List<Person> persons = personService.getByGenderAndAge(gender, age);
        return ResponseEntity.ok().headers(headers).body(persons);
    }

    @GetMapping("/persons/date/{startDate}/{endDate}")
    ResponseEntity<List<Person>> getByDateOfDoseRange(@PathVariable("startDate") String startDate,@PathVariable("endDate") String endDate) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting persons by dates");
        List<Person> persons = personService.getByDateOfDoseRange(startDate, endDate);
        return ResponseEntity.ok().headers(headers).body(persons);
    }

    @GetMapping("/persons/city/{city}")
    ResponseEntity<List<Person>> getByCity(@PathVariable("city") String city)  {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting persons by city");
        List<Person> persons = personService.getByCity(city);
        return ResponseEntity.ok().headers(headers).body(persons);
    }

    @GetMapping("/persons/state/{state}")
    ResponseEntity<List<Person>> getByState(@PathVariable("state") String state)  {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting persons by state");
        List<Person> persons = personService.getByState(state);
        return ResponseEntity.ok().headers(headers).body(persons);
    }

    @GetMapping("/persons/pincode/{pincode}")
    ResponseEntity<List<Person>> getByPincode(@PathVariable("pincode") int pincode) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting persons by pincode");
        List<Person> persons = personService.getByPincode(pincode);
        return ResponseEntity.ok().headers(headers).body(persons);
    }

    @GetMapping("/persons/gender/{gender}/city/{city}")
    ResponseEntity<List<Person>> getByGenderAndCity(@PathVariable("gender") String gender,@PathVariable("city") String city) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting persons by gender and city");
        List<Person> persons = personService.getByGenderAndCity(gender, city);
        return ResponseEntity.ok().headers(headers).body(persons);
    }

    @GetMapping("/persons/age/{age}/city/{city}")
    ResponseEntity<List<Person>> getByAgeAndCity(@PathVariable("age") int age,@PathVariable("city") String city) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting persons by age and city");
        List<Person> persons = personService.getByAgeAndCity(age, city);
        return ResponseEntity.ok().headers(headers).body(persons);
    }

    @GetMapping("/persons/gender/{gender}/state/{state}")
    ResponseEntity<List<Person>> getByGenderAndState(@PathVariable("gender") String gender,@PathVariable("state") String state) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting persons by gender and state");
        List<Person> persons = personService.getByGenderAndState(gender, state);
        return ResponseEntity.ok().headers(headers).body(persons);
    }

    @GetMapping("/persons/age/{age}/state/{state}")
    ResponseEntity<List<Person>> getByAgeAndState(@PathVariable("age") int age,@PathVariable("state") String state) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting persons by age and state");
        List<Person> persons = personService.getByAgeAndState(age, state);
        return ResponseEntity.ok().headers(headers).body(persons);
    }

    @GetMapping("/persons/gender/{gender}/age/{age}/city/{city}")
    ResponseEntity<List<Person>> getByGenderAgeCity(@PathVariable("gender") String gender,@PathVariable("age") int age,@PathVariable("city") String city) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting persons by age, gender and city");
        List<Person> persons = personService.getByGenderAgeCity(gender, age, city);
        return ResponseEntity.ok().headers(headers).body(persons);
    }

    @GetMapping("/persons/gender/{gender}/age/{age}/state/{state}")
    ResponseEntity<List<Person>> getByGenderAgeState(@PathVariable("gender") String gender,@PathVariable("age") int age,@PathVariable("state") String state) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting persons by age, gender and state");
        List<Person> persons = personService.getByGenderAgeState(gender, age, state);
        return ResponseEntity.ok().headers(headers).body(persons);
    }

    @GetMapping("/persons/gender/{gender}/pincode/{pincode}")
    ResponseEntity<List<Person>> getByGenderPincode(@PathVariable("gender") String gender,@PathVariable("pincode") int pincode) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting persons by gender and pincode");
        List<Person> persons = personService.getByGenderPincode(gender, pincode);
        return ResponseEntity.ok().headers(headers).body(persons);
    }

    @GetMapping("/persons/age/{age}/pincode/{pincode}")
    ResponseEntity<List<Person>> getByAgePincode(@PathVariable("age") int age,@PathVariable("pincode") int pincode) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting persons by age and pincode");
        List<Person> persons = personService.getByAgePincode(age, pincode);
        return ResponseEntity.ok().headers(headers).body(persons);
    }

    @GetMapping("/persons/vaccineName/{vaccineName}")
    ResponseEntity<List<Person>> getByVaccine(@PathVariable("vaccineName") String vaccineName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting persons by vaccine");
        List<Person> persons = personService.getByVaccine(vaccineName);
        return ResponseEntity.ok().headers(headers).body(persons);
    }

    @GetMapping("/persons/vaccineName/{vaccineName}/city/{city}")
    ResponseEntity<List<Person>> getByVaccineCity(@PathVariable("vaccineName") String vaccineName,@PathVariable("city") String city) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting persons by vaccine and city");
        List<Person> persons = personService.getByVaccineCity(vaccineName, city);
        return ResponseEntity.ok().headers(headers).body(persons);
    }

    @GetMapping("/persons/vaccineName/{vaccineName}/state/{state}")
    ResponseEntity<List<Person>> getByVaccineState(@PathVariable("vaccineName") String vaccineName,@PathVariable("state") String state) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting persons by vaccine and state");
        List<Person> persons = personService.getByVaccineState(vaccineName, state);
        return ResponseEntity.ok().headers(headers).body(persons);
    }

    @GetMapping("/persons/age/{age}/vaccineName/{vaccineName}")
    ResponseEntity<List<Person>> getByAgeVaccine(@PathVariable("age") int age,@PathVariable("vaccineName") String vaccineName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting persons by vaccine and age");
        List<Person> persons = personService.getByAgeVaccine(age, vaccineName);
        return ResponseEntity.ok().headers(headers).body(persons);
    }

    @GetMapping("/persons/gender/{gender}/vaccineName/{vaccineName}")
    ResponseEntity<List<Person>> getByGenderVaccine(@PathVariable("gender") String gender,@PathVariable("vaccineName") String vaccineName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting persons by vaccine and gender");
        List<Person> persons = personService.getByGenderVaccine(gender, vaccineName);
        return ResponseEntity.ok().headers(headers).body(persons);
    }

    @GetMapping("/persons/age/{age}/gender/{gender}/vaccineName/{vaccineName}")
    ResponseEntity<List<Person>> getByAgeGenderVaccine(@PathVariable("age") int age,@PathVariable("gender") String gender,@PathVariable("vaccineName") String vaccineName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting persons by age, vaccine and gender");
        List<Person> persons = personService.getByAgeGenderVaccine(age, gender, vaccineName);
        return ResponseEntity.ok().headers(headers).body(persons);
    }

    @GetMapping("/persons/dose/{dose}")
    ResponseEntity<List<Person>> getByDose(@PathVariable("dose") int dose) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting persons by dosage");
        List<Person> persons = personService.getByDose(dose);
        return ResponseEntity.ok().headers(headers).body(persons);
    }

    @GetMapping("/persons/dose/{dose}/city/{city}")
    ResponseEntity<List<Person>> getByDoseAndCity(@PathVariable("dose") int dose,@PathVariable("city") String city) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting persons by dosage and city");
        List<Person> persons = personService.getByDoseAndCity(dose, city);
        return ResponseEntity.ok().headers(headers).body(persons);
    }

    @GetMapping("/persons/dose/{dose}/state/{state}")
    ResponseEntity<List<Person>> getByDoseAndState(@PathVariable("dose") int dose,@PathVariable("state") String state) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting persons by dosage and state");
        List<Person> persons = personService.getByDoseAndState(dose, state);
        return ResponseEntity.ok().headers(headers).body(persons);
    }

    @GetMapping("/persons/dose/{dose}/pincode/{pincode}")
    ResponseEntity<List<Person>> getByDosePincode(@PathVariable("dose") int dose,@PathVariable("pincode") int pincode) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting persons by dosage and pincode");
        List<Person> persons = personService.getByDosePincode(dose, pincode);
        return ResponseEntity.ok().headers(headers).body(persons);
    }

    @GetMapping("/persons/dose/{dose}/age/{age}")
    ResponseEntity<List<Person>> getByDoseAndAge(@PathVariable("dose") int dose,@PathVariable("age") int age) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting persons by dose and age");
        List<Person> persons = personService.getByDoseAndAge(dose, age);
        return ResponseEntity.ok().headers(headers).body(persons);
    }

    @GetMapping("/persons/gender/{gender}/dose/{dose}")
    ResponseEntity<List<Person>> getByGenderDose(@PathVariable("gender") String gender,@PathVariable("dose") int dose) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting persons by dose and gender");
        List<Person> persons = personService.getByGenderDose(gender, dose);
        return ResponseEntity.ok().headers(headers).body(persons);
    }
}
