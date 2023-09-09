package com.student.controller;

import com.student.model.ProductAPI;
import com.student.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {
    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<?> get() {
        return service.getListProductApiModel();
    }

    @GetMapping("/getOne")
    public ResponseEntity<?> getOne() {
        return ResponseEntity.ok(service.getOne());
    }

    public static int x = 15;

    @GetMapping("/save")
    public ResponseEntity<?> postProductApi() {

        ProductAPI productAPI = new ProductAPI(0, "iphone" + x, 1, 1, 1009 + x);
        x++;
        return service.postProductApi(productAPI);
    }
}
