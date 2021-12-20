package com.cowinapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="paddress")
public class PAddress {
    @Id
    @GeneratedValue(generator = "paddr_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "paddr_seq", sequenceName = "paddress_sequence", initialValue = 301, allocationSize = 1)
    @Column(name = "paddressid")
    private Integer pAddressId;
    @Column(length = 20, name="p_city")
    private String city;
    @Column(length = 20, name="p_state")
    private String state;
    @Column(name="p_pincode")
    private int pincode;

    public PAddress(String city, String state, int pincode) {
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }
}
