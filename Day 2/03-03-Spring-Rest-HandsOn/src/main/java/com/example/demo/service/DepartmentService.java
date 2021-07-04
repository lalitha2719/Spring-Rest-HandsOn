package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.Department;
import com.example.demo.dao.DepartmentDao;


@Component
@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentDao department;
	
	public List<Department> getAllDepartments() {
		
		List<Department> dept= department.getAllDepartments();
		for(Department d:dept)
			System.out.println(d);
		return dept;
	}
}
