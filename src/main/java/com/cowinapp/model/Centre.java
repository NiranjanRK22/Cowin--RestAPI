package com.cowinapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Centre {
    @Id
    @GeneratedValue(generator = "centre_seq",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="centre_seq",sequenceName = "centre_sequence",initialValue = 101,allocationSize = 1)
    @Column(name = "centreid")
    private Integer centreId;
    @Column(name="centrename", length=20)
    private String centreName;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //adding this(joincolumn) to prevent from creating a junction table
    @JoinColumn(name="centre_id") //this is the foreign key that will be added to person table
    private Set<Person> people;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="centre_vaccine", joinColumns = @JoinColumn(name="centre_id"), inverseJoinColumns = @JoinColumn(name="vaccine_id"))
    private Set<Vaccine> vaccines;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="c_address_id") //to rename the foreign key column
    private CAddress cAddress;

    public Centre(String centreName, Set<Person> people, Set<Vaccine> vaccines, CAddress cAddress) {
        this.centreName = centreName;
        this.people = people;
        this.vaccines = vaccines;
        this.cAddress = cAddress;
    }
}
