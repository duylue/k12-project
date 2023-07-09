package com.student.controller;

import com.student.model.Student;
import com.student.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService service;
    @GetMapping
    public String getHome() {
//        System.out.println(service.read().get(0));
//        service.create(new Student());
        service.findByAID(5);
        return "home";
    }



}
