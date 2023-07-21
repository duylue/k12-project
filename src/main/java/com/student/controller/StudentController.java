package com.student.controller;

import com.student.model.Student;
import com.student.model.StudentsDto;
import com.student.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService service;
    @GetMapping
    public String getHome(Model model) {
        ArrayList<StudentsDto> list = service.read();
        model.addAttribute("list",list);

        return "student/students";
    }
    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("student", new Student());
        return "student/register";
    }
    @GetMapping("/update/{id}")
    public String update(Model model ,@PathVariable int id){
        Student student = service.findByID(id);
        model.addAttribute("student",student);
        return "student/register";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute @Validated Student student, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "student/register";
        }
        service.create(student);

        System.out.println(student);
        return "redirect:/student";
    }



}
