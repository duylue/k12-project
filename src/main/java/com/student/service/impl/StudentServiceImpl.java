package com.student.service.impl;

import com.student.model.Address;
import com.student.model.Student;
import jakarta.persistence.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final EntityManagerFactory factory;


    private EntityManager entityManager;

    private EntityTransaction transaction;

    public StudentServiceImpl(EntityManagerFactory factory) {
        this.factory = factory;
        entityManager = factory.createEntityManager();
    }

    @Override
    public ArrayList<Student> read() {

        ArrayList<Student> list = (ArrayList<Student>)
                entityManager.createQuery("select s from Student as s", Student.class).getResultList();
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override

    public void create(Student student) {
        transaction = entityManager.getTransaction();
        student.setSname("adsa");
        Date date = new Date();
        student.setBirthday(date);
        student.setPhone("dsadsd");
        Address address = entityManager.find(Address.class,5);
        student.setAddress(address);
//        Address address = new Address();
//        address.setProvince("Hn");
//        ArrayList<Student> students = new ArrayList<>();
//        students.add(student);
//        address.setStudents(students);
//        student.setAddress(address);
        transaction.begin();
        entityManager.persist(student);
        transaction.commit();


    }

    @Override
    public List<Student> findByAID(int aid) {
        String  queryHQL = "select s from  Student as s where address.aid =?1";
        String querySQL ="select * from student where aid = ?1";
//        List<Student> list = entityManager.createQuery(queryHQL,Student.class)
//                .setParameter(1,aid).getResultList();

        List<Student> list2 = entityManager.createNativeQuery(querySQL,Student.class)
                .setParameter(1,aid).getResultList();
        return list2;
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
