package com.student.service.impl;

import com.student.model.Customer;
import com.student.service.CustomerService;

import java.util.ArrayList;

public class CustomerServiceImpl implements CustomerService {
    ArrayList<Customer> customers = new ArrayList<>();
    public void checklist(){
        if (customers.isEmpty()){
            customers.add(new Customer(1,"duy","sadas","sadsada",1));
            customers.add(new Customer(1,"duy","sadas","sadsada",2));
            customers.add(new Customer(1,"duy","sadas","sadsada",3));
        }



    }
    @Override
    public ArrayList<Customer> read() {
        checklist();
        return customers;
    }

    @Override
    public void create(Customer customers) {

    }

    @Override
    public void update(Customer customers) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public boolean checkCId(int cId) {
        return false;
    }
}
