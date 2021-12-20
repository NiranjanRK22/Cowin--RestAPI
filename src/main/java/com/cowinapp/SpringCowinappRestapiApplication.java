package com.cowinapp;

import com.cowinapp.model.*;
import com.cowinapp.service.ICentreService;
import com.cowinapp.service.IVaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringCowinappRestapiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringCowinappRestapiApplication.class, args);
	}

	@Autowired
	private ICentreService centreService;

	@Autowired
	private IVaccineService vaccineService;

	@Override
	public void run(String... args) throws Exception {
        //One to one
//		CAddress cAddress = new CAddress("bangalore", "karnataka", 500040);
//		//one to one
//		PAddress pAddress1 = new PAddress("bangalore", "karnataka", 500326);
//		PAddress pAddress2 = new PAddress("hubli", "karnataka", 500332);
//		//one to one
//		Vaccine vaccine1 = vaccineService.getVaccineById(1);
//		Vaccine vaccine2 = vaccineService.getVaccineById(2);
//		Vaccine vaccine3 = vaccineService.getVaccineById(3);
//		//one to many
//		Person person1 = new Person("kiran", Gender.MALE, 51, LocalDate.parse("2021-10-25"), LocalTime.parse("10:35:00"), 2, pAddress1, vaccine2);
//		Person person2 = new Person("ashwini", Gender.FEMALE, 27, LocalDate.parse("2021-10-30"), LocalTime.parse("11:40:00"), 1, pAddress2, vaccine3);
//		Set<Person> people = new HashSet<>(Arrays.asList(person1, person2));
//		//many to many
//
//		Set<Vaccine> vaccines = new HashSet<>(Arrays.asList(vaccine1, vaccine3));
//		Centre centre = new Centre("kims", people, vaccines, cAddress);
//
//		//centreService.addCentre(centre);
//
//		centreService.getByCentreName("tenet").forEach(System.out::println);

	}
}
