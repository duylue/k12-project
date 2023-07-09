package com.student.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter

public class Customer {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cusId;
    private String cusName;
    private String birthday;
    private String phone;
    private int aId;
    @OneToMany(mappedBy = "customer")
    private List<Orders> orders;
    @OneToOne
    private User user;




}
