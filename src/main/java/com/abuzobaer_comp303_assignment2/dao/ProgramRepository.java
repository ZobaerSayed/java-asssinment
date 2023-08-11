package com.abuzobaer_comp303_assignment2.dao;

import com.abuzobaer_comp303_assignment2.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramRepository extends JpaRepository<Program, Integer> {
}