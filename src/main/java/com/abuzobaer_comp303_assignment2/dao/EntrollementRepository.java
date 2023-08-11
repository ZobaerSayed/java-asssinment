package com.abuzobaer_comp303_assignment2.dao;

import com.abuzobaer_comp303_assignment2.entity.Enrollement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrollementRepository extends JpaRepository<Enrollement, Integer> {
}