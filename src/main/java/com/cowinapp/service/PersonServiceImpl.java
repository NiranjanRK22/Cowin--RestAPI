package com.cowinapp.service;

import com.cowinapp.exceptions.PersonNotFoundException;
import com.cowinapp.model.Gender;
import com.cowinapp.model.Person;
import com.cowinapp.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService{

    private IPersonRepository personRepository;

    @Autowired
    public void setPersonRepository(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person getByPersonId(int personId) throws PersonNotFoundException {
        return personRepository.findById(personId)
                .orElseThrow(() -> new PersonNotFoundException("Invalid id"));

    }

    @Override
    public List<Person> getByPersonName(String personName) throws PersonNotFoundException {
        List<Person> personsList = personRepository.findByPersonName(personName);
        if (personsList.isEmpty())
            throw new PersonNotFoundException("Person not found with this name");
        return personsList;
    }

    @Override
    public List<Person> getByAgeLessThan(int age) throws PersonNotFoundException {
        List<Person> personsList = personRepository.findByAgeLessThan(age);
        if (personsList.isEmpty())
            throw new PersonNotFoundException("Person not found lesser this age");
        return personsList;
    }

    @Override
    public List<Person> getByGender(String gender) throws PersonNotFoundException {
        List<Person> personsList = personRepository.findByGender(Gender.valueOf(gender));
        if (personsList.isEmpty())
            throw new PersonNotFoundException("Person not found with this gender");
        return personsList;
    }

    @Override
    public List<Person> getByGenderAndAge(String gender, int age) throws PersonNotFoundException {
        List<Person> personsList = personRepository.findByGenderAndAge(Gender.valueOf(gender), age);
        if (personsList.isEmpty())
            throw new PersonNotFoundException("Person not found with this gender");
        return personsList;
    }

    @Override
    public List<Person> getByDateOfDoseRange(String startDate, String endDate) throws PersonNotFoundException {
        List<Person> personsList = personRepository.findByDateOfDoseBetween(startDate, endDate);
        if (personsList.isEmpty())
            throw new PersonNotFoundException("Person not found between these dates");
        return personsList;
    }

    @Override
    public List<Person> getByCity(String city) throws PersonNotFoundException {
        List<Person> personsList = personRepository.findByCity(city);
        if (personsList.isEmpty())
            throw new PersonNotFoundException("Person not found in this city");
        return personsList;
    }

    @Override
    public List<Person> getByState(String state) throws PersonNotFoundException {
        List<Person> personsList = personRepository.findByState(state);
        if (personsList.isEmpty())
            throw new PersonNotFoundException("Person not found in this state");
        return personsList;
    }

    @Override
    public List<Person> getByPincode(int pincode) throws PersonNotFoundException {
        List<Person> personsList = personRepository.findByPincode(pincode);
        if (personsList.isEmpty())
            throw new PersonNotFoundException("Person not found in this area");
        return personsList;
    }

    @Override
    public List<Person> getByGenderAndCity(String gender, String city) throws PersonNotFoundException {
        List<Person> personsList = personRepository.findByGenderAndCity(Gender.valueOf(gender), city);
        if (personsList.isEmpty())
            throw new PersonNotFoundException("Person with this gender not found in this city");
        return personsList;
    }

    @Override
    public List<Person> getByAgeAndCity(int age, String city) throws PersonNotFoundException {
        List<Person> personsList = personRepository.findByAgeAndCity(age, city);
        if (personsList.isEmpty())
            throw new PersonNotFoundException("Person with this age not found in this city");
        return personsList;
    }

    @Override
    public List<Person> getByGenderAndState(String gender, String state) throws PersonNotFoundException {
        List<Person> personsList = personRepository.findByGenderAndState(Gender.valueOf(gender), state);
        if (personsList.isEmpty())
            throw new PersonNotFoundException("Person with this gender not found in this state");
        return personsList;
    }

    @Override
    public List<Person> getByAgeAndState(int age, String state) throws PersonNotFoundException {
        List<Person> personsList = personRepository.findByAgeAndState(age, state);
        if (personsList.isEmpty())
            throw new PersonNotFoundException("Person with this age range not found in this state");
        return personsList;
    }

    @Override
    public List<Person> getByGenderAgeCity(String gender, int age, String city) throws PersonNotFoundException {
        List<Person> personsList = personRepository.findByGenderAgeCity(Gender.valueOf(gender), age, city);
        if (personsList.isEmpty())
            throw new PersonNotFoundException("Person with this gender and age not found in this city");
        return personsList;
    }

    @Override
    public List<Person> getByGenderAgeState(String gender, int age, String state) throws PersonNotFoundException {
        List<Person> personsList = personRepository.findByGenderAgeState(Gender.valueOf(gender), age, state);
        if (personsList.isEmpty())
            throw new PersonNotFoundException("Person with this gender and age not found in this state");
        return personsList;
    }

    @Override
    public List<Person> getByGenderPincode(String gender, int pincode) throws PersonNotFoundException {
        List<Person> personsList = personRepository.findByGenderPincode(Gender.valueOf(gender), pincode);
        if (personsList.isEmpty())
            throw new PersonNotFoundException("Person with this gender not found in this area");
        return personsList;
    }

    @Override
    public List<Person> getByAgePincode(int age, int pincode) throws PersonNotFoundException {
        List<Person> personsList = personRepository.findByAgePincode(age, pincode);
        if (personsList.isEmpty())
            throw new PersonNotFoundException("Person with this age not found in this area");
        return personsList;
    }

    @Override
    public List<Person> getByVaccine(String vaccineName) throws PersonNotFoundException {
        List<Person> personsList = personRepository.findByVaccine(vaccineName);
        if (personsList.isEmpty())
            throw new PersonNotFoundException("Person who have taken this vaccine is not found");
        return personsList;
    }

    @Override
    public List<Person> getByVaccineCity(String vaccineName, String city) throws PersonNotFoundException {
        List<Person> personsList = personRepository.findByVaccineCity(vaccineName, city);
        if (personsList.isEmpty())
            throw new PersonNotFoundException("Person who have taken this vaccine is not found in this city");
        return personsList;
    }

    @Override
    public List<Person> getByVaccineState(String vaccineName, String state) throws PersonNotFoundException {
        List<Person> personsList = personRepository.findByVaccineState(vaccineName, state);
        if (personsList.isEmpty())
            throw new PersonNotFoundException("Person who have taken this vaccine is not found in this state");
        return personsList;
    }

    @Override
    public List<Person> getByAgeVaccine(int age, String vaccineName) throws PersonNotFoundException {
        List<Person> personsList = personRepository.findByAgeVaccine(age, vaccineName);
        if (personsList.isEmpty())
            throw new PersonNotFoundException("Person who have taken this vaccine is not found in this age range");
        return personsList;
    }

    @Override
    public List<Person> getByGenderVaccine(String gender, String vaccineName) throws PersonNotFoundException {
        List<Person> personsList = personRepository.findByGenderVaccine(Gender.valueOf(gender), vaccineName);
        if (personsList.isEmpty())
            throw new PersonNotFoundException("Person with gender haven't taken this vaccine");
        return personsList;
    }

    @Override
    public List<Person> getByAgeGenderVaccine(int age, String gender, String vaccineName) throws PersonNotFoundException {
        List<Person> personsList = personRepository.findByAgeGenderVaccine(age, Gender.valueOf(gender), vaccineName);
        if (personsList.isEmpty())
            throw new PersonNotFoundException("Person with gender and age haven't taken this vaccine");
        return personsList;
    }

    @Override
    public List<Person> getByDose(int dose) throws PersonNotFoundException {
        List<Person> personsList = personRepository.findByDose(dose);
        if (personsList.isEmpty())
            throw new PersonNotFoundException("Person with dose is not found");
        return personsList;
    }

    @Override
    public List<Person> getByDoseAndCity(int dose, String city) throws PersonNotFoundException {
        List<Person> personsList = personRepository.findByDoseAndCity(dose, city);
        if (personsList.isEmpty())
            throw new PersonNotFoundException("Person with dose is not found in this city");
        return personsList;
    }

    @Override
    public List<Person> getByDoseAndState(int dose, String state) throws PersonNotFoundException {
        List<Person> personsList = personRepository.findByDoseAndState(dose, state);
        if (personsList.isEmpty())
            throw new PersonNotFoundException("Person with dose is not found in this state");
        return personsList;
    }

    @Override
    public List<Person> getByDosePincode(int dose, int pincode) throws PersonNotFoundException {
        List<Person> personsList = personRepository.findByDosePincode(dose, pincode);
        if (personsList.isEmpty())
            throw new PersonNotFoundException("Person with dose is not found in this area");
        return personsList;
    }

    @Override
    public List<Person> getByDoseAndAge(int dose, int age) throws PersonNotFoundException {
        List<Person> personsList = personRepository.findByDoseAndAge(dose, age);
        if (personsList.isEmpty())
            throw new PersonNotFoundException("Person with dose and age is not found");
        return personsList;
    }

    @Override
    public List<Person> getByGenderDose(String gender, int dose) throws PersonNotFoundException {
        List<Person> personsList = personRepository.findByGenderDose(gender, dose);
        if (personsList.isEmpty())
            throw new PersonNotFoundException("Person with dose and gender is not found");
        return personsList;
    }


}
