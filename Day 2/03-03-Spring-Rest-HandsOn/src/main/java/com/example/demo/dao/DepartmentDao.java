package com.example.demo.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.example.demo.Department;

@Component
public class DepartmentDao {

	static List<Department> DEPARTMENT_LIST;
	private ApplicationContext context;
	
	public DepartmentDao() {
		context = new ClassPathXmlApplicationContext("employee.xml");
		DEPARTMENT_LIST = (List<Department>) context.getBean("departmentList");
	}
	
	public List<Department> getAllDepartments() {
	
		return DEPARTMENT_LIST;
	}
}
