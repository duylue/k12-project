package com.student.service.impl;

import com.student.model.Customer;
import com.student.model.Orders;
import com.student.model.User;
import com.student.service.CustomerService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("svimpl")
public class CustomerServiceImpl implements CustomerService {

    private final EntityManagerFactory factory;

    private EntityManager entityManager;

    private EntityTransaction transaction;

    public CustomerServiceImpl(EntityManagerFactory factory) {
        this.factory = factory;
        entityManager = factory.createEntityManager();
    }

    @Override
    public ArrayList<Customer> read() {
        return null;
    }

    @Override
    public void create(Customer cc) {
//        Customer customer =new Customer();
//        customer.setBirthday("asdas");
//        customer.setPhone("sdasd");
//        customer.setCusName("adsad");
//        transaction = entityManager.getTransaction();
//        Orders orders = new Orders();
//        ArrayList<Orders>list = new ArrayList<>();
//        list.add(orders);
//        customer.setOrders(list);
//        orders.setCustomer(customer);
//        transaction.begin();
//        entityManager.persist(customer);
//        entityManager.persist(orders);
//        transaction.commit();
//        Orders orders = entityManager.find(Orders.class,2);
        transaction = entityManager.getTransaction();
        Customer customer = entityManager.find(Customer.class, 1);
        User user = new User();
        customer.setUser(user);
        user.setCustomer(customer);
        transaction.begin();
        entityManager.merge(customer);
        entityManager.persist(user);
        transaction.commit();
    }

    @Override
    public void update(Customer customers) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void checkID(Customer customer) {

    }

    @Override
    public boolean checkCId(int cId) {
        return false;
    }

    @Override
    public Customer findByID(int id) {
        return null;
    }
}
