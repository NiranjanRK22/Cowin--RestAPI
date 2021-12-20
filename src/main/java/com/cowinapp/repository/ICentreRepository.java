package com.cowinapp.repository;

import com.cowinapp.exceptions.CentreNotFoundException;
import com.cowinapp.model.Centre;
import com.cowinapp.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ICentreRepository extends JpaRepository<Centre, Integer> {
    //derived
    List<Centre> findByCentreName(String centreName) throws CentreNotFoundException;

    //custom
    @Query("from Centre c inner join c.people p where p.personId=?1")
    List<Centre> findByPerson(int personId) throws CentreNotFoundException;

    @Query("from Centre c inner join c.cAddress a where a.city=?1")
    List<Centre> findByCity(String cCity) throws CentreNotFoundException;

    @Query("from Centre c inner join c.cAddress a where a.state=?1")
    List<Centre> findByState(String state) throws CentreNotFoundException;

    @Query("from Centre c inner join c.vaccines v where v.vaccineName = ?1")
    List<Centre> findByVaccine(String vaccineName) throws CentreNotFoundException;

    @Query("from Centre c inner join c.cAddress a where c.centreName=?1 and a.city=?2")
    List<Centre> findByCentreAndCity(String centreName, String city) throws CentreNotFoundException;

    @Query("from Centre c inner join c.vaccines v where c.centreName=?1 and v.vaccineName = ?2")
    List<Centre> findByCentreVaccine(String centreName, String vaccineName) throws CentreNotFoundException;

    @Query("from Centre c inner join c.cAddress a where a.pincode=?1")
    List<Centre> findByPincode(int pincode) throws CentreNotFoundException;

    @Query("from Centre c inner join c.vaccines v inner join c.cAddress a where v.vaccineName = ?1 and a.city=?2")
    List<Centre> findByVaccineAndCity(String vaccineName, String city) throws CentreNotFoundException;

    @Query("from Centre c inner join c.vaccines v inner join c.cAddress a where v.vaccineName = ?1 and a.state=?2")
    List<Centre> findByVaccineAndState(String vaccineName, String state) throws CentreNotFoundException;

    @Query("from Centre c inner join c.cAddress a where c.centreName=?1 and a.state=?2")
    List<Centre> findByCentreAndState(String centreName, String state) throws CentreNotFoundException;
}
