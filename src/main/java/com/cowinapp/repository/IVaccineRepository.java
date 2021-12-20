package com.cowinapp.repository;

import com.cowinapp.exceptions.VaccineNotFoundException;
import com.cowinapp.model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IVaccineRepository extends JpaRepository<Vaccine, Integer> {

    //derived
    Vaccine findByVaccineName(String vaccineName);

}
