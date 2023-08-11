package com.abuzobaer_comp303_assignment2.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
public class Enrollement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int applicationNo;
    private int studentId;
    private int programCode;
    @CreationTimestamp
    private Date startDate;
    private BigDecimal amountPaid;
    private String status;

}
