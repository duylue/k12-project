package com.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {
    @GetMapping
    public String getHome() {
        return "home";
    }

    @GetMapping("/detail")
    public String getHome2(@RequestParam("id") int id, @RequestParam("name")String name ) {
        System.out.println(id);
        System.out.println(name);
        return "detail";
    }
    @GetMapping("/delete/{age}/{name}")
    public String delete(@PathVariable int age,@PathVariable String name) {
        System.out.println(age);
        System.out.println(name);
        return "delete";
    }


}
