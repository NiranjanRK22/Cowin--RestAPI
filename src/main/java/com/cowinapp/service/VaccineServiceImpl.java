package com.cowinapp.service;

import com.cowinapp.model.Vaccine;
import com.cowinapp.repository.IVaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccineServiceImpl implements IVaccineService{

    private IVaccineRepository vaccineRepository;
    @Autowired
    public void setVaccineRepository(IVaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

    @Override
    public void addVaccine(Vaccine vaccine) {
        vaccineRepository.save(vaccine);
    }

    @Override
    public void updateVaccine(Vaccine vaccine) {
        vaccineRepository.save(vaccine);
    }

    @Override
    public void deleteVaccine(int vaccineId) {
        vaccineRepository.deleteById(vaccineId);
    }

    @Override
    public Vaccine getVaccineById(int vaccineId) {
        return vaccineRepository.findById(vaccineId).get();
    }

    @Override
    public Vaccine getVaccineByName(String vaccineName) {
        return vaccineRepository.findByVaccineName(vaccineName);
    }


}
