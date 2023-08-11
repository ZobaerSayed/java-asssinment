package com.abuzobaer_comp303_assignment2.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int programCode;
    @NotEmpty(message = "Name cannot be empty.")
    private String programName;
    @Min(1)
    private int duration;
    private BigDecimal fee;
}
