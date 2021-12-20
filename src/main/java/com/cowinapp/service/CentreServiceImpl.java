package com.cowinapp.service;

import com.cowinapp.exceptions.CentreNotFoundException;
import com.cowinapp.model.Centre;
import com.cowinapp.repository.ICentreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CentreServiceImpl implements ICentreService {

    private ICentreRepository centreRepository;

    @Autowired
    public void setCentreRepository(ICentreRepository centreRepository) {
        this.centreRepository = centreRepository;
    }

    @Override
    public void addCentre(Centre centre) {
        centreRepository.save(centre);
    }

    @Override
    public void updateCentre(Centre centre) {
        centreRepository.save(centre);
    }

    @Override
    public void deleteCentre(int centreId) {
        centreRepository.deleteById(centreId);
    }

    @Override
    public Centre getCentreById(int centreId) throws CentreNotFoundException {
        return centreRepository.findById(centreId)
                .orElseThrow(() -> new CentreNotFoundException("Invalid id"));
    }

    @Override
    public List<Centre> getAll() {
        return centreRepository.findAll();
    }

    @Override
    public List<Centre> getByCentreName(String centreName) throws CentreNotFoundException {
        List<Centre> centres = centreRepository.findByCentreName(centreName);
        if (centres.isEmpty())
            throw new CentreNotFoundException("Centres not found with this name");
        return centres;
    }

    @Override
    public List<Centre> getByPerson(int personId) throws CentreNotFoundException {
        List<Centre> centres = centreRepository.findByPerson(personId);
        if (centres.isEmpty())
            throw new CentreNotFoundException("This person is not vaccinated at this centre");
        return centres;

    }

    @Override
    public List<Centre> getByCity(String city) throws CentreNotFoundException {
        List<Centre> centres = centreRepository.findByCity(city);
        if (centres.isEmpty())
            throw new CentreNotFoundException("centre not found in this city");
        return centres;
    }

    @Override
    public List<Centre> getByState(String state) throws CentreNotFoundException {
        List<Centre> centres = centreRepository.findByState(state);
        if (centres.isEmpty())
            throw new CentreNotFoundException("centre not found in this state");
        return centres;

    }

    @Override
    public List<Centre> getByPincode(int pincode) throws CentreNotFoundException {
        List<Centre> centres = centreRepository.findByPincode(pincode);
        if (centres.isEmpty())
            throw new CentreNotFoundException("centre not found in this area");
        return centres;
    }


    @Override
    public List<Centre> getByVaccine(String vaccineName) throws CentreNotFoundException {
        List<Centre> centres = centreRepository.findByVaccine(vaccineName);
        if (centres.isEmpty())
            throw new CentreNotFoundException("Vaccines not found in this centre");
        return centres;
    }

    @Override
    public List<Centre> getByVaccineAndCity(String vaccineName, String city) throws CentreNotFoundException {
        List<Centre> centres = centreRepository.findByVaccineAndCity(vaccineName, city);
        if (centres.isEmpty())
            throw new CentreNotFoundException("This Vaccine not found in this city");
        return centres;
    }

    @Override
    public List<Centre> getByVaccineAndState(String vaccineName, String state) throws CentreNotFoundException {
        List<Centre> centres = centreRepository.findByVaccineAndState(vaccineName, state);
        if (centres.isEmpty())
            throw new CentreNotFoundException("This Vaccine not found in this state");
        return centres;
    }

    @Override
    public List<Centre> getByCentreAndState(String centreName, String state) throws CentreNotFoundException {
        List<Centre> centres = centreRepository.findByCentreAndState(centreName, state);
        if (centres.isEmpty())
            throw new CentreNotFoundException("Centre not found in this state");
        return centres;
    }


    @Override
    public List<Centre> getByCentreAndCity(String centreName, String city) throws CentreNotFoundException {
        List<Centre> centres = centreRepository.findByCentreAndCity(centreName, city);
        if (centres.isEmpty())
            throw new CentreNotFoundException("Centre not found in this city");
        return centres;
    }

    @Override
    public List<Centre> getByCentreVaccine(String centreName, String vaccineName) throws CentreNotFoundException {
        List<Centre> centres = centreRepository.findByCentreVaccine(centreName, vaccineName);
        if (centres.isEmpty())
            throw new CentreNotFoundException("Centre not found with this vaccine quantity");
        return centres;
    }
}
