package com.employeeapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/")
	public List<Employee> listEmployee() {
		List<Employee> empList = employeeService.listEmp();
		return empList;
	}
	
	@PutMapping("/updateEmployee")
	public String updateEmployee(@RequestBody Employee employee) {
		employeeService.updEmp(employee);
		return "Employee details updated successfully!!";
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		employeeService.delEmp(id);
		return "Employee details deleted successfully!!";
	}
}
