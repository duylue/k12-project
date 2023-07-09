package com.student.service.impl;

import com.student.model.Category;
import com.student.model.Product;
import com.student.model.ProductDto;
import com.student.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final EntityManagerFactory factory;


    private EntityManager entityManager;

    private EntityTransaction transaction;

    public ProductServiceImpl(EntityManagerFactory factory) {
        this.factory = factory;
        entityManager = factory.createEntityManager();
    }

    @Override
    public List<ProductDto> getProductDto() {
       Product product = entityManager.find(Product.class,1);
        Category category = entityManager.find(Category.class,product.getCid());
        ProductDto dto = new ProductDto();
        dto.setCid(product.getCid());
        dto.setCategory(category);
        dto.setPname(product.getPname());
        dto.setPid(product.getPid());
        List<ProductDto> dtos = new ArrayList<>();
        dtos.add(dto);
        return dtos;
    }
}
