package com.student.controller;

import com.student.conn.ConnectJdbc;
import com.student.model.Customer;
import com.student.service.CustomerService;
import com.student.service.dao.CustomerDao;
import com.student.service.impl.CustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.util.ArrayList;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    CustomerService customerService = new CustomerServiceImpl();
    CustomerService dao = new CustomerDao();

    @GetMapping
    public String getHome(Model model) {
        ArrayList<Customer> customersList = dao.read();
        model.addAttribute("list", customersList);
        return "customer/home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer/create";
    }
    @GetMapping("/del/{id}")
    public String dal(Model model,@PathVariable int id) {
        customerService.delete(id);
        ArrayList<Customer> customersList = customerService.read();
        model.addAttribute("list", customersList);

        return "customer/home";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable int id) {
        Customer customer = customerService.findByID(id);
        model.addAttribute("customer", customer);
        return "customer/update";

    }

    @PostMapping("/save")
    public String postCreate(@ModelAttribute Customer customer) {
        dao.create(customer);
        return "redirect:/customer";
    }


}
