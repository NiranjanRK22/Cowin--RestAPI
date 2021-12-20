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
@Table(name="caddress")
public class CAddress {
    @Id
    @GeneratedValue(generator = "caddr_seq",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="caddr_seq",sequenceName = "caddress_sequence",initialValue = 201,allocationSize = 1)
    @Column(name = "caddressid")
    private Integer cAddressId;
    @Column(length=20)
    private String city;
    @Column(length=20)
    private String state;
    private int pincode;

    public CAddress(String city, String state, int pincode) {
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }
}
