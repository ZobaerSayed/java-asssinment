package com.abuzobaer_comp303_assignment2.service;

import com.abuzobaer_comp303_assignment2.dao.ProgramRepository;
import com.abuzobaer_comp303_assignment2.entity.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramService {

    @Autowired
    private ProgramRepository programRepository;

    public List<Program> getAll()
    {
        return programRepository.findAll();
    }

    public Program findById(int id)
    {
        return programRepository.findById(id).get();
    }


}
