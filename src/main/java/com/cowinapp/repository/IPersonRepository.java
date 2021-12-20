package com.cowinapp.repository;

import com.cowinapp.exceptions.PersonNotFoundException;
import com.cowinapp.model.Gender;
import com.cowinapp.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Integer> {
     //derived queries
     List<Person> findByPersonName(String personName) throws PersonNotFoundException;
     List<Person> findByAgeLessThan(int age) throws PersonNotFoundException;
     List<Person> findByGender(Gender gender) throws PersonNotFoundException;
     List<Person> findByGenderAndAge(Gender gender, int age) throws PersonNotFoundException;
     List<Person> findByDateOfDoseBetween(String startDate, String endDate) throws PersonNotFoundException;
     List<Person> findByDose(int dose) throws PersonNotFoundException;
     List<Person> findByDoseAndAge(int dose, int age) throws PersonNotFoundException;
     //custom
     @Query("from Person p inner join p.pAddress a where a.city=?1")
     List<Person> findByCity(String city) throws PersonNotFoundException;
     @Query("from Person p inner join p.pAddress a where a.state=?1")
     List<Person> findByState(String state) throws PersonNotFoundException;
     @Query("from Person p inner join p.pAddress a where a.pincode=?1")
     List<Person> findByPincode(int pincode) throws PersonNotFoundException;
     @Query("from Person p inner join p.pAddress a where p.gender=?1 and a.city=?2")
     List<Person> findByGenderAndCity(Gender gender, String city) throws PersonNotFoundException;
     @Query("from Person p inner join p.pAddress a where p.age<=?1 and a.city=?2")
     List<Person> findByAgeAndCity(int age, String city) throws PersonNotFoundException;
     @Query("from Person p inner join p.pAddress a where p.gender=?1 and a.state=?2")
     List<Person> findByGenderAndState(Gender gender, String state) throws PersonNotFoundException;
     @Query("from Person p inner join p.pAddress a where p.age<=?1 and a.state=?2")
     List<Person> findByAgeAndState(int age, String state) throws PersonNotFoundException;
     @Query("from Person p inner join p.pAddress a where p.gender=?1 and p.age<=?2 and a.city=?3")
     List<Person> findByGenderAgeCity(Gender gender, int age, String city) throws PersonNotFoundException;
     @Query("from Person p inner join p.pAddress a where p.gender=?1 and p.age<=?2 and a.state=?3")
     List<Person> findByGenderAgeState(Gender gender, int age, String state) throws PersonNotFoundException;
     @Query("from Person p inner join p.pAddress a where p.gender=?1 and a.pincode=?2")
     List<Person> findByGenderPincode(Gender gender, int pincode) throws PersonNotFoundException;
     @Query("from Person p inner join p.pAddress a where p.age<=?1 and a.pincode=?2")
     List<Person> findByAgePincode(int age, int pincode) throws PersonNotFoundException;
     @Query("from Person p inner join p.vaccine v where v.vaccineName=?1")
     List<Person> findByVaccine(String vaccineName) throws PersonNotFoundException;
     @Query("from Person p inner join p.vaccine v inner join p.pAddress a where v.vaccineName=?1 and a.city=?2")
     List<Person> findByVaccineCity(String vaccineName, String city) throws PersonNotFoundException;
     @Query("from Person p inner join p.vaccine v inner join p.pAddress a where v.vaccineName=?1 and a.state=?2")
     List<Person> findByVaccineState(String vaccineName, String state) throws PersonNotFoundException;
     @Query("from Person p inner join p.vaccine v where p.age<=?1 and v.vaccineName=?2")
     List<Person> findByAgeVaccine(int age, String vaccineName) throws PersonNotFoundException;
     @Query("from Person p inner join p.vaccine v where p.gender=?1 and v.vaccineName=?2")
     List<Person> findByGenderVaccine(Gender gender, String vaccineName) throws PersonNotFoundException;
     @Query("from Person p inner join p.vaccine v where p.age<=?1 and p.gender=?2 and v.vaccineName=?2")
     List<Person> findByAgeGenderVaccine(int age, Gender gender, String vaccineName) throws PersonNotFoundException;

     @Query("from Person p inner join p.pAddress a where p.dose=?1 and a.city=?2")
     List<Person> findByDoseAndCity(int dose, String city) throws PersonNotFoundException;
     @Query("from Person p inner join p.pAddress a where p.dose=?1 and a.state=?2")
     List<Person> findByDoseAndState(int dose, String state) throws  PersonNotFoundException;
     @Query("from Person p inner join p.pAddress a where p.dose=?1 and a.pincode=?2")
     List<Person> findByDosePincode(int dose, int pincode) throws PersonNotFoundException;
     @Query("from Person p where p.gender=?1 and p.dose=?2")
     List<Person> findByGenderDose(String gender, int dose) throws PersonNotFoundException;
}
