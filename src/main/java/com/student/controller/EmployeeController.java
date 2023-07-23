package com.student.controller;

import com.student.model.Employee;
import com.student.service.EmployeeService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import jakarta.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @Autowired
    MessageSource messageSource;

    @GetMapping
    public String getAll(Model model, HttpServletResponse response, HttpServletRequest request) {
        Cookie cookie = new Cookie("test", "111111");
        String message = messageSource.getMessage("hello", null, "default message", request.getLocale());
        cookie.setMaxAge(10);
        response.addCookie(cookie);

        Page<Employee> employeePage = service.emPaging(0, 5, "eid");
        List<Employee> list = employeePage.getContent();
        int totalPage = employeePage.getTotalPages();
        model.addAttribute("list", list);
        model.addAttribute("totalPage", totalPage);
        return "/employee/list";
    }

    @GetMapping("/paging")
    public String paging(Model model,
                         @RequestParam int page
    ) {


        Page<Employee> employeePage = service.emPaging(page, 5, "eid");

        List<Employee> list = employeePage.getContent();
        int totalPage = employeePage.getTotalPages();
        model.addAttribute("list", list);
        model.addAttribute("totalPage", totalPage);
        return "/employee/list";
    }

    @GetMapping("/register")
    public String save(Model model,
                       HttpServletResponse response, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies
        ) {
            if (c.getName().equals("test")) {
                c.setMaxAge(0);
                response.addCookie(c);
            }
        }
        model.addAttribute("employee", new Employee());
        return "/employee/register";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable int id) {
        Employee employee = service.findById(id).get();
        model.addAttribute("employee", employee);
        return "/employee/register";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute Employee employee) {
        service.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable int id) {
        service.delete(id);
        List<Employee> list = service.getAll();
        model.addAttribute("list", list);
        return "/employee/list";
    }
}
