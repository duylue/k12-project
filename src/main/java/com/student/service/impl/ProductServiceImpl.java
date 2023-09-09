package com.student.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.base.BaseResponse;
import com.student.common.Comm;
import com.student.model.*;
import com.student.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@Service
public class ProductServiceImpl extends BaseResponse implements ProductService {
    private final EntityManagerFactory factory;
    @Autowired
    private ProductRepository productRepository;
    private EntityManager entityManager;
    private EntityTransaction transaction;

    public ProductServiceImpl(EntityManagerFactory factory) {
        this.factory = factory;
        entityManager = factory.createEntityManager();
    }

    @Override
    public List<ProductDto> getProductDto() {
//        Product product = entityManager.find(Product.class, 1);
//        Category category = entityManager.find(Category.class, product.getCid());
//        ProductDto dto = new ProductDto();
//        dto.setCid(product.getCid());
//        dto.setCategory(category);
//        dto.setPname(product.getPname());
//        dto.setPid(product.getPid());
//        List<ProductDto> dtos = new ArrayList<>();
//        dtos.add(dto);
        return null;
    }

    @Override
    @Transactional
    public void save(Product product) {
        productRepository.save(product);

    }

    @Override
    public List<ProductDto> getInfor() {
        List<Map<String, Objects>> mapList = productRepository.findInfor();
        ObjectMapper mapper = new ObjectMapper();
        List<ProductDto> products = new ArrayList<>();
        for (Map m : mapList) {
            ProductDto dto = mapper.convertValue(m, ProductDto.class);
            products.add(dto);
        }
        return products;
    }



    @Override
    public ResponseEntity<?> getListProductApiModel() {
        WebClient webClient = WebClient.create(Comm.URL8088);
        MyResponse myResponse = webClient.get()
                .uri(Comm.URI_LIST_PRODUCT_API)
                .retrieve()
                .bodyToMono(MyResponse.class).block();
        List<ProductAPI> apiList = (List<ProductAPI>) myResponse.getData();
        System.out.println(apiList.get(0));
        return getResponseEntity(myResponse.getData());
    }

    @Override
    public ProductAPI getOne() {
        WebClient webClient = WebClient.create(Comm.URL8088);
        ProductAPI api = webClient.get()
                .uri("/api/product/getOne")
                .retrieve()
                .bodyToMono(ProductAPI.class).block();

        return api;
    }

    @Override
    public ResponseEntity<?> postProductApi(ProductAPI api) {
        WebClient client = WebClient.create(Comm.URL8088);
        MyResponse myResponse = client.post()
                .uri("/api/product/save")
                .bodyValue(api)
                .retrieve().bodyToMono(MyResponse.class)
                .block();

        return getResponseEntity(myResponse.getData());
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product findByID(int id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new RuntimeException();
        }
        return product.get();
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findAllByPname(name);
    }

    @Override
    public List<Product> findByCategory(int cid) {
        return productRepository.findAllByCid(cid);
    }


}
