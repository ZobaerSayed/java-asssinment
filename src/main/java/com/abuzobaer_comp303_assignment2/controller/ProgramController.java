package com.abuzobaer_comp303_assignment2.controller;

import com.abuzobaer_comp303_assignment2.entity.Program;
import com.abuzobaer_comp303_assignment2.entity.Student;
import com.abuzobaer_comp303_assignment2.security.UserPrincipal;
import com.abuzobaer_comp303_assignment2.service.ProgramService;
import com.abuzobaer_comp303_assignment2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProgramController {

    @Autowired
    private ProgramService programService;
    @Autowired
    private StudentService studentService;

    @GetMapping("programs")
    public String getAll(@AuthenticationPrincipal UserPrincipal loggedUser, Model model)
    {
        Student student=studentService.findByUserName(loggedUser.getUsername());
        model.addAttribute("user",student);
        List<Program> programList=programService.getAll();
        model.addAttribute("programs",programList);

        return "student/programs";

    }
}
