package com.cowinapp.service;

import com.cowinapp.model.Vaccine;

public interface IVaccineService {
    void addVaccine(Vaccine vaccine);
    void updateVaccine(Vaccine vaccine);
    void deleteVaccine(int vaccineId);
    Vaccine getVaccineById(int vaccineId);
    Vaccine getVaccineByName(String vaccineName);



}
