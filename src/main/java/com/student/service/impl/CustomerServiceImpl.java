package com.student.service.impl;

import com.student.jdbc.ConnectJdbc;
import com.student.model.Customer;
import com.student.service.CustomerService;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CustomerServiceImpl implements CustomerService {
   private PreparedStatement statement ;
   private Connection con = ConnectJdbc.connection();

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
        try {
            statement = con.prepareStatement("select * from Customers as c");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        checklist();
        return customers;
    }

    @Override
    public void create(Customer customers) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(dateFormat.parse(customers.getBirthDay()).getTime());
            statement =con.prepareStatement("insert into customers  values (?,?,?,?,?)");
            statement.setInt(1,99);
            statement.setString(2,"adsdas");
            statement.setDate(3,date);
            statement.setString(4,"sadsd");
            statement.setString(5,"asda");
            statement.execute();


        }catch (Exception e){
            throw new RuntimeException(e);
        }

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
