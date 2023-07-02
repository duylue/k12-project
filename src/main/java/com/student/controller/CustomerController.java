package com.student.controller;

import com.student.model.Customer;
import com.student.service.CustomerService;
import com.student.service.impl.CustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    CustomerService customerService = new CustomerServiceImpl();

    @GetMapping
    public String getHome(Model model) {
        String mess = "hello customer";
        Customer customer = new Customer();
        customer.setaId(1);
        customer.setCusId(-1);
        customer.setPhone("q2eq312");
        customer.setCusName("duy");
        customer.setBirthDay("29/12/111");
        model.addAttribute("mess", mess);
        model.addAttribute("cus", customer);
        ArrayList<Customer> customersList = customerService.read();
        model.addAttribute("list", customersList);

        return "customer/home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer",customer);
        return "customer/create";
    }
    @PostMapping("/create")
    public String postCreate(@ModelAttribute Customer customer) {
        System.out.println(customer);

        return "redirect:/customer";
    }

}
