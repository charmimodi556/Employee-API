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

	public void updEmp(Employee employee) {
		empRepo.save(employee);
	}

	public void delEmp(int id) {
		empRepo.deleteById(id);
	}

	public List<Employee> maxUnEmployed() {
		List<Employee> empList = listEmp();
		
		int max = 0;
		Employee temp=null;
		
		for(int i=0;i<empList.size();i++) {
			if(empList.get(i).getSalary()>max) {
				max = empList.get(i).getSalary();
				temp = empList.get(i);
			}
		}
	
		temp.setEmployed(false);
		empRepo.save(temp);
		
		return empList;
	}

	public List<Employee> minUnEmployed() {
		List<Employee> empList = listEmp();
		
		int min = Integer.MAX_VALUE;
		Employee temp=null;
		
		for(int i=0;i<empList.size();i++) {
			if(empList.get(i).getSalary()<min) {
				min = empList.get(i).getSalary();
				temp = empList.get(i);
			}
		}
	
		temp.setEmployed(false);
		empRepo.save(temp);
		
		return empList;
	}

	public int avgSalary() {
		
		List<Employee> empList = listEmp();
		
		int total = 0;
		
		for(int i=0;i<empList.size();i++) {
			total = total + empList.get(i).getSalary();
		}
		
		int avg = total / empList.size();
		
		return avg;
	}

	public List<Employee> fireEmp() {
		List<Employee> empList = listEmp();
		
		int total = 0;
		Employee temp = null;
		
		for(int i=0;i<empList.size();i++) {
			total = total + empList.get(i).getSalary();
		}
		
		int avg = total / empList.size();
		
		for(int i=0;i<empList.size();i++) {
			temp = empList.get(i);
			if(temp.getSalary() > avg && temp.getYoe() < 3) {
				temp.setEmployed(false);
				empRepo.save(temp);
				empList.set(i, temp);
			}
		}
		
		return empList;
	}

}
