package com.abuzobaer_comp303_assignment2.service;

import com.abuzobaer_comp303_assignment2.dao.EntrollementRepository;
import com.abuzobaer_comp303_assignment2.dto.EntrollDto;
import com.abuzobaer_comp303_assignment2.entity.Enrollement;

import com.abuzobaer_comp303_assignment2.entity.Program;
import com.abuzobaer_comp303_assignment2.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollementService {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ProgramService programService;
    @Autowired
    private EntrollementRepository entrollementRepository;

    public List<Enrollement> getAll()
    {
        return entrollementRepository.findAll();
    }
    public Enrollement create(Enrollement enrollement)
    {


        entrollementRepository.save(enrollement);

        return enrollement;
    }
}
