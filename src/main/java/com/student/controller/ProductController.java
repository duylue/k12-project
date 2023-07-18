package com.student.controller;

import com.student.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping
    public String home(){
        System.out.println(productService.getInfor().get(0));
        return "home";
    }
    @GetMapping("/test")
    public ResponseEntity<?> home2(){
        System.out.println(productService.getInfor().get(0));
        return ResponseEntity.ok().body("test");
    }
}
