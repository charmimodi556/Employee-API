package com.employeeapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeapi.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepo;
	
	public void addEmp(Employee employee) {
		empRepo.save(employee);
	}

	public List<Employee> listEmp() {
		List<Employee> empList = new ArrayList<>();
		empRepo.findAll().forEach(emp1 -> empList.add(emp1));
		return empList;
	}

}
