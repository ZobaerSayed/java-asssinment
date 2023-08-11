package com.abuzobaer_comp303_assignment01.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @NotEmpty(message = "First Name cannot be empty.")
    private String firstName;
    @NotEmpty(message = "Last Name cannot be empty.")
    private String lastName;
    private String middleName;
    @Email(message = "Email Not Valid")
    private String email;
    @NotEmpty(message = "Country cannot be empty.")
    private String codeArea;
    @NotEmpty(message = "Country cannot be empty.")
    private String phone;
    @NotEmpty(message = "Address cannot be empty.")
    private String address;
    private String secondAddress;
    @NotEmpty(message = "City cannot be empty.")
    private String city;
    @NotEmpty(message = "State cannot be empty.")
    private String state;
    @NotEmpty(message = "ZipCode cannot be empty.")
    private String zipCode;
    @NotEmpty(message = "Country cannot be empty.")
    private String country;

    private String productId;
    @NotEmpty(message = "Brand cannot be empty.")
    private String brand;
    @NotEmpty(message = "Model cannot be empty.")
    private String model;
//    @NotEmpty(message = "Price cannot be empty.")
    private float price;

    @Min(value = 1,message = "Quantity must be > 0 ")
    private int quantity;

    @CreationTimestamp
    private LocalDate createdDate;


    @Transient
    public String getAddressLine()
    {
        return this.address+" "+this.city+" "+this.state+" "+this.zipCode+" "+this.country;
    }

    @Transient
    public float getTotal()
    {
        return this.price*this.quantity;
    }

    @Transient
    public String getPhoneN()
    {
        return "+ "+this.codeArea+" "+this.phone;
    }


}
