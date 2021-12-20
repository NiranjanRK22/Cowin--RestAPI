package com.cowinapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Person {
    @Id
    @GeneratedValue(generator = "person_seq",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="person_seq",sequenceName = "person_sequence",initialValue = 51,allocationSize = 1)
    @Column(name = "personid")
    private Integer personId;
    @Column(name="personname", length=20)
    private String personName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private int age;
    private LocalDate dateOfDose;
    private LocalTime timeOfDose;
    private int dose;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="p_address_id")
    private PAddress pAddress;
    @OneToOne
    @JoinColumn(name="vaccine_id")
    private Vaccine vaccine;

    public Person(String personName, Gender gender, int age, LocalDate dateOfDose, LocalTime timeOfDose, int dose, PAddress pAddress, Vaccine vaccine) {
        this.personName = personName;
        this.gender = gender;
        this.age = age;
        this.dateOfDose = dateOfDose;
        this.timeOfDose = timeOfDose;
        this.dose = dose;
        this.pAddress = pAddress;
        this.vaccine = vaccine;
    }
}
