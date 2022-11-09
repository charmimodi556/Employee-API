package com.employeeapi.service;

import org.springframework.data.repository.CrudRepository;

import com.employeeapi.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
