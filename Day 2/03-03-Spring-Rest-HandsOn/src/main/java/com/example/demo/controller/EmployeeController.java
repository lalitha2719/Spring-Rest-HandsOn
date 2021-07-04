package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Employee;
import com.example.demo.service.EmployeeService;

import com.example.demo.exception.EmployeeNotFoundException;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@GetMapping(value="/employees")
	List<Employee> getAllEmployees(){
		
		return empService.getAllEmployees();
		
	}
	
	@PutMapping(value="/updateEmployees/{id}")
	public Employee updateEmployee( @PathVariable int id,@RequestBody Employee employee) throws EmployeeNotFoundException {
		
		return empService.updateEmployee(employee);
	}
	
	@DeleteMapping("/deleteEmployees/{id}")
	public void deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException
	{
		empService.deleteEmployee(id);
	}
	
	@GetMapping(value="/getEmployee/{id}")
	public Employee getEmployee( @PathVariable int id) throws EmployeeNotFoundException
	{
		return empService.getEmployee(id);
	}
}
