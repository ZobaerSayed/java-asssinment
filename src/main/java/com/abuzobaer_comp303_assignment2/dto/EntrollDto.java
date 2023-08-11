package com.abuzobaer_comp303_assignment2.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class EntrollDto {

    private int programCode;
    private String username;
    private BigDecimal amountPaid;
    private String status;
}
