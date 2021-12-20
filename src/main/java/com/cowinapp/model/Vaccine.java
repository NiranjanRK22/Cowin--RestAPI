package com.cowinapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Vaccine {
    @Id
    @GeneratedValue(generator = "vaccine_seq",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="vaccine_seq",sequenceName = "vaccine_sequence",initialValue = 1,allocationSize = 1)
    @Column(name = "vaccineid")
    private Integer vaccineId;
    @Column(name="vaccinename", length = 20)
    private String vaccineName;
    @Column(length = 30)
    private String manufacturer;

    @ManyToMany(mappedBy = "vaccines")
    @JsonIgnore
    Set<Centre> centres;

    public Vaccine(String vaccineName, String manufacturer) {
        this.vaccineName = vaccineName;
        this.manufacturer = manufacturer;

    }

    @Override
    public String toString() {
        return "Vaccine{" +
                "vaccineName='" + vaccineName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
