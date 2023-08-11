package com.abuzobaer_comp303_assignment2.service;

import com.abuzobaer_comp303_assignment2.dao.StudentRepository;
import com.abuzobaer_comp303_assignment2.dto.UserDto;
import com.abuzobaer_comp303_assignment2.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Student register(UserDto userDto)
    {
        Student student=new Student();
        student.setFirstname(userDto.getFirstname());
        student.setLastname(userDto.getLastname());
        student.setUsername(userDto.getUsername());
        student.setAddress(userDto.getAddress());
        student.setCity(userDto.getCity());
        student.setPostalCode(userDto.getPostalCode());
        encodePassword(encodePassword(userDto.getPassword()));

        studentRepository.save(student);
        return student;
    }

    private String encodePassword(String password) {
        String encodedPassword = passwordEncoder.encode(password);
        return encodedPassword;
    }

    public Student findByUserName(String username)
    {
        return studentRepository.findByUsername(username);
    }

    public Student update(Student student)
    {

        studentRepository.save(student);
        return student;

    }
}
