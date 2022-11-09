package com.employeeapi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column
	String name;
	@Column
	String company;
	@Column
	int yoe;
	@Column
	int salary;
	@Column
	boolean employed;
	
	public Employee() {
		super();
	}

	public Employee(int id, String name, String company, int yoe, int salary, boolean employed) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
		this.yoe = yoe;
		this.salary = salary;
		this.employed = employed;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getYoe() {
		return yoe;
	}
	public void setYoe(int yoe) {
		this.yoe = yoe;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public boolean isEmployed() {
		return employed;
	}
	public void setEmployed(boolean employed) {
		this.employed = employed;
	}

}
