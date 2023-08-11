package com.abuzobaer_comp303_assignment2.dao;

import com.abuzobaer_comp303_assignment2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByUsername(String username);
}