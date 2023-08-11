package com.abuzobaer_comp303_assignment2.controller;

import com.abuzobaer_comp303_assignment2.entity.Enrollement;
import com.abuzobaer_comp303_assignment2.entity.Student;
import com.abuzobaer_comp303_assignment2.security.UserPrincipal;
import com.abuzobaer_comp303_assignment2.service.EnrollementService;
import com.abuzobaer_comp303_assignment2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private EnrollementService enrollementService;

    @GetMapping("home")
    public String home(@AuthenticationPrincipal UserPrincipal loggedUser, Model model)
    {
        List<Enrollement> enrollementList=enrollementService.getAll();
        model.addAttribute("enrolls",enrollementList);
        Student student=studentService.findByUserName(loggedUser.getUsername());
        model.addAttribute("user",student);
        return "student/home";
    }

    @GetMapping("login")
    public String login()
    {

        return "login";
    }

    @GetMapping("profile")
    public String profile(@AuthenticationPrincipal UserPrincipal loggedUser, Model model)
    {
        Student student=studentService.findByUserName(loggedUser.getUsername());
        model.addAttribute("user",student);
        return "student/profile";
    }

    @PostMapping("profile/update")
    public String  update(Student student)
    {
        studentService.update(student);
        return "redirect:/profile";

    }
}
