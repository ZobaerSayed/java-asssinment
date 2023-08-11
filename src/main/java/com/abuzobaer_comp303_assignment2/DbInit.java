package com.abuzobaer_comp303_assignment2;

import com.abuzobaer_comp303_assignment2.dao.EntrollementRepository;
import com.abuzobaer_comp303_assignment2.dao.ProgramRepository;
import com.abuzobaer_comp303_assignment2.dao.StudentRepository;
import com.abuzobaer_comp303_assignment2.entity.Enrollement;
import com.abuzobaer_comp303_assignment2.entity.Program;
import com.abuzobaer_comp303_assignment2.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class DbInit implements CommandLineRunner {



    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ProgramRepository programRepository;

    @Autowired
    private EntrollementRepository entrollementRepository;
    private PasswordEncoder passwordEncoder;

    public DbInit(PasswordEncoder passwordEncoder){
        this.passwordEncoder=passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        studentRepository.deleteAll();;

            Student student = new Student();
            student.setCity("test");
            student.setAddress("test");
            student.setUsername("user1");
            student.setLastname("user");
            student.setFirstname("test");
            student.setPostalCode(1234);
            student.setPassword(passwordEncoder.encode("12345678"));

        programRepository.deleteAll();
        Program program=new Program();
        program.setProgramName("MATH");
        program.setDuration(3);
        program.setFee(BigDecimal.valueOf(100));
        programRepository.save(program);

            studentRepository.save(student);

            entrollementRepository.deleteAll();
        Enrollement enrollement=new Enrollement();
        enrollement.setStudentId(1);
        enrollement.setStatus("active");
        enrollement.setProgramCode(1);
        enrollement.setAmountPaid(BigDecimal.valueOf(100));
        entrollementRepository.save(enrollement);
        }

}
