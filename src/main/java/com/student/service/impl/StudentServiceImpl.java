package com.student.service.impl;

import com.student.model.Student;
import jakarta.persistence.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentServiceImpl implements StudentService {
    @PersistenceUnit
    private final EntityManagerFactory factory;

    private EntityManager entityManager;

    private EntityTransaction transaction;

    public StudentServiceImpl(EntityManagerFactory factory) {
        this.factory = factory;
        entityManager = factory.createEntityManager();

    }

    @Override
    public ArrayList<Student> read() {
        String query = "select * from student where em_id = :id";
        String query2 = "select s from Student as s where s.emId = ?1";
        ArrayList<Student> list = (ArrayList<Student>)
                entityManager.createQuery(query2, Student.class)
                        .setParameter(1,1).getResultList();
        ArrayList<Student> list2 = (ArrayList<Student>)
                entityManager.createNativeQuery(query, Student.class)
                        .setParameter("id",1).getResultList();
        return list2;
    }

    @Override
    public void create(Student student) {
        transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(student);
        transaction.commit();

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
