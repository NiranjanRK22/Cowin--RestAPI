package com.cowinapp.service;

import com.cowinapp.exceptions.CentreNotFoundException;
import com.cowinapp.model.Centre;

import java.time.LocalDate;
import java.util.List;

public interface ICentreService {
    void addCentre(Centre centre);
    void updateCentre(Centre centre);
    void deleteCentre(int centreId);
    Centre getCentreById(int centreId) throws CentreNotFoundException;

    List<Centre> getAll();
    List<Centre> getByCentreName(String centreName) throws CentreNotFoundException;
    List<Centre> getByPerson(int personId) throws CentreNotFoundException;
    List<Centre> getByCity(String city) throws CentreNotFoundException;
    List<Centre> getByState(String state) throws CentreNotFoundException;
    List<Centre> getByPincode(int pincode) throws CentreNotFoundException;
    List<Centre> getByVaccine(String vaccineName) throws CentreNotFoundException;
    List<Centre> getByVaccineAndCity(String vaccineName, String city) throws CentreNotFoundException;
    List<Centre> getByVaccineAndState(String vaccineName, String state) throws CentreNotFoundException;
    List<Centre> getByCentreAndState(String centreName, String state) throws CentreNotFoundException;
    List<Centre> getByCentreAndCity(String centreName, String city) throws CentreNotFoundException;
    List<Centre> getByCentreVaccine(String centreName, String vaccineName) throws CentreNotFoundException;

}
