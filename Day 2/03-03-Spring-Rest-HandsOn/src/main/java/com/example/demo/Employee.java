package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	@NonNull
	@NumberFormat
	private int id;
	
	@NonNull
	private String name;
	
	@NonNull
	private double salary;
	
	@NonNull
	private String permanent;
	/*
	@NonNull
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy",timezone = "EST")
	private Date dateOfBirth;
	*/
	@NonNull
	@Autowired
	private Department department;
	
	@NonNull
	@Autowired
	private Skill skill;

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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getPermanent() {
		return permanent;
	}

	public void setPermanent(String permanent) {
		this.permanent = permanent;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", permanent=" + permanent
				+ ", department=" + department + ", skill=" + skill + "]";
	}

}
