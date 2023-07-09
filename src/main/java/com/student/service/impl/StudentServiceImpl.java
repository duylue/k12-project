package com.student.service.impl;

import com.student.model.Student;
import jakarta.persistence.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class StudentServiceImpl implements StudentService{
    @PersistenceUnit
    private EntityManagerFactory factory;

    private EntityManager entityManager;

    private EntityTransaction transaction;

    @Override
    public ArrayList<Student> read() {
        entityManager = factory.createEntityManager();
        ArrayList<Student> list = (ArrayList<Student>)
                entityManager.createQuery("select s from Student as s",Student.class).getResultList();
        return list;
    }

    @Override
    public void create(Student student) {

    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Student findByID(int id) {
        return null;
    }
}
