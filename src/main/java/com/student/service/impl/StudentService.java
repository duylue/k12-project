package com.student.service.impl;

import com.student.model.Customer;
import com.student.model.Student;

import java.util.ArrayList;

public interface StudentService {
    ArrayList<Student> read();

    void create(Student student);

    void update(Student student);

    void delete(int id);

    Student findByID(int id);
}
