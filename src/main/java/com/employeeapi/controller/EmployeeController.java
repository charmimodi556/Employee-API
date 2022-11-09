package com.employeeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeapi.Employee;
import com.employeeapi.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee employee) {
		employeeService.addEmp(employee);
		return "Employee details added successfully!!";
	}
}
