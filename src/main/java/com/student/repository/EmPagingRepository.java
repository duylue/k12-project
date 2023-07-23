package com.student.repository;

import com.student.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmPagingRepository extends PagingAndSortingRepository<Employee,Integer> {

}
