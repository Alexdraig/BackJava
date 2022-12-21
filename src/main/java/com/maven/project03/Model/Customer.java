package com.maven.project03.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "customers")
@Getter
@Setter
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customer_id;
    @Column
    private String company_name;
    @Column
    private String contact_name;
    @Column
    private String contact_title;
    @Column
    private String address;
    @Column
    private String city;
    @Column
    private String region;
    @Column
    private String postal_code;
    @Column
    private String country;
    @Column
    private String phone;
    @Column
    private String fax;

    public Customer() {

    }
}
