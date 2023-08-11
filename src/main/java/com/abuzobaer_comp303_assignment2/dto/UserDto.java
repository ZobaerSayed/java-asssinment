package com.abuzobaer_comp303_assignment2.dto;

import lombok.Data;

@Data
public class UserDto {

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String address;
    private String city;
    private int postalCode;
}
