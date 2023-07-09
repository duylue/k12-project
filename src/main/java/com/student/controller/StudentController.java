package com.student.controller;

import com.student.model.Customer;
import com.student.model.Student;
import com.student.service.CustomerService;
import com.student.service.impl.CustomerServiceImpl;
import com.student.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService service;

    public StudentController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String getHome() {
        System.out.println(service.read().get(0));
        return "home";
    }
    private final CustomerService customerService;

    @GetMapping("/dk")
    public String dk(Model model) {
        customerService.create(new Customer());
     model.addAttribute("st",new Student());
        return "dang-ky";
    }
    @PostMapping("/dk")
    public String dkc(@ModelAttribute Student student) {

        System.out.println(student);
        service.create(student);
        return "redirect:/student";
    }


}
