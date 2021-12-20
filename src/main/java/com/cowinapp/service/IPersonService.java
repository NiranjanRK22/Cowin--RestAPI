package com.cowinapp.service;

import com.cowinapp.exceptions.PersonNotFoundException;
import com.cowinapp.model.Person;

import java.util.List;

public interface IPersonService {

    Person getByPersonId(int personId) throws PersonNotFoundException;
    List<Person> getAll();
    List<Person> getByPersonName(String personName) throws PersonNotFoundException;
    List<Person> getByAgeLessThan(int age) throws PersonNotFoundException;
    List<Person> getByGender(String gender) throws PersonNotFoundException;
    List<Person> getByGenderAndAge(String gender, int age) throws PersonNotFoundException;
    List<Person> getByDateOfDoseRange(String startDate, String endDate) throws PersonNotFoundException;
    List<Person> getByCity(String city) throws PersonNotFoundException;
    List<Person> getByState(String state) throws PersonNotFoundException;
    List<Person> getByPincode(int pincode) throws PersonNotFoundException;
    List<Person> getByGenderAndCity(String gender, String city) throws PersonNotFoundException;
    List<Person> getByAgeAndCity(int age, String city) throws PersonNotFoundException;
    List<Person> getByGenderAndState(String gender, String state) throws PersonNotFoundException;
    List<Person> getByAgeAndState(int age, String state) throws PersonNotFoundException;
    List<Person> getByGenderAgeCity(String gender, int age, String city) throws PersonNotFoundException;
    List<Person> getByGenderAgeState(String gender, int age, String state) throws PersonNotFoundException;
    List<Person> getByGenderPincode(String gender, int pincode) throws PersonNotFoundException;
    List<Person> getByAgePincode(int age, int pincode) throws PersonNotFoundException;
    List<Person> getByVaccine(String vaccineName) throws PersonNotFoundException;
    List<Person> getByVaccineCity(String vaccineName, String city) throws PersonNotFoundException;
    List<Person> getByVaccineState(String vaccineName, String state) throws PersonNotFoundException;
    List<Person> getByAgeVaccine(int age, String vaccineName) throws PersonNotFoundException;
    List<Person> getByGenderVaccine(String gender, String vaccineName) throws PersonNotFoundException;
    List<Person> getByAgeGenderVaccine(int age, String gender, String vaccineName) throws PersonNotFoundException;
    List<Person> getByDose(int dose) throws PersonNotFoundException;
    List<Person> getByDoseAndCity(int dose, String city) throws PersonNotFoundException;
    List<Person> getByDoseAndState(int dose, String state) throws  PersonNotFoundException;
    List<Person> getByDosePincode(int dose, int pincode) throws PersonNotFoundException;
    List<Person> getByDoseAndAge(int dose, int age) throws PersonNotFoundException;
    List<Person> getByGenderDose(String gender, int dose) throws PersonNotFoundException;
}
