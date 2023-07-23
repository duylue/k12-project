package com.student.service.impl;

import com.student.model.Employee;
import com.student.repository.EmPagingRepository;
import com.student.repository.EmployeeRepository;
import com.student.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmPagingRepository emPagingRepository;
    @Override
    public List<Employee> getAll() {
        List<Employee> list = employeeRepository.findAll();
        return list ;
    }

    @Override
    public Page<Employee> emPaging(int page, int size, String sortName) {
        Sort sort = Sort.by(Sort.Direction.ASC,sortName);
        Pageable pageable = PageRequest.of(page,size,sort);
        return emPagingRepository.findAll(pageable);
    }

    @Override
    public void save(Employee employee) {
      employeeRepository.save(employee);

    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);

    }

    @Override
    public Optional<Employee> findById(int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (!optionalEmployee.isEmpty()){
            return optionalEmployee;
        }
        return Optional.empty();
    }
}
