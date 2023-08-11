package com.abuzobaer_comp303_assignment2.controller;

import com.abuzobaer_comp303_assignment2.entity.Enrollement;
import com.abuzobaer_comp303_assignment2.entity.Program;
import com.abuzobaer_comp303_assignment2.entity.Student;
import com.abuzobaer_comp303_assignment2.security.UserPrincipal;
import com.abuzobaer_comp303_assignment2.service.EnrollementService;
import com.abuzobaer_comp303_assignment2.service.ProgramService;
import com.abuzobaer_comp303_assignment2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EntrollementController {

    @Autowired
    private EnrollementService enrollementService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ProgramService programService;


    @GetMapping("checkout/{id}")
    public String checkout(Model model, @PathVariable int id,@AuthenticationPrincipal UserPrincipal loggedUser)
    {
        Program program=programService.findById(id);
        Student student=studentService.findByUserName(loggedUser.getUsername());
        Enrollement enrollement=new Enrollement();
        enrollement.setAmountPaid(program.getFee());
        enrollement.setProgramCode(program.getProgramCode());
        enrollement.setStatus("active");
        enrollement.setStudentId(student.getStudentId());
        enrollementService.create(enrollement);
        model.addAttribute("program",program);
        return "student/checkout";
    }



}
