package com.student.service;

import com.student.model.Employee;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAll();

    Page<Employee> emPaging(int page, int size, String sort);

    void save(Employee employee);

    void delete(int id);

    Optional<Employee> findById(int id);


}
