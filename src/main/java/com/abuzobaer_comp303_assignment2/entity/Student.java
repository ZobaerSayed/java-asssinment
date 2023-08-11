package com.abuzobaer_comp303_assignment2.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    @NotEmpty(message = "Username cannot be empty.")
    private String username;
    @NotEmpty(message = "Password cannot be empty.")
    private String password;
    @NotEmpty(message = "FirstName cannot be empty.")
    private String firstname;
    @NotEmpty(message = "LastName cannot be empty.")
    private String lastname;
    private String address;
    private String city;
    private int postalCode;


}
