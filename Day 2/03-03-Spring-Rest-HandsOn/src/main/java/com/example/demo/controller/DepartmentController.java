package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Department;

import com.example.demo.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping(value = "/departments")
	public List<Department> getAllDepartments() {

		return departmentService.getAllDepartments();
	}
}
