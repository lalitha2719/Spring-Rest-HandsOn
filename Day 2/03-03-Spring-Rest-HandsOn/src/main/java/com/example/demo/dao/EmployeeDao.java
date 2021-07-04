package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.example.demo.Employee;

import com.example.demo.exception.*;


@Component
public class EmployeeDao {

	
	static ArrayList<Employee> EMPLOYEE_LIST;
	private ApplicationContext context;
	
	public EmployeeDao() {
		
		context = new ClassPathXmlApplicationContext("employee.xml");
		EMPLOYEE_LIST = (ArrayList<Employee>) context.getBean("employeeList");
	}
	
	public List<Employee> getAllEmployee(){
		return EMPLOYEE_LIST;
	}
	
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException
	{
		
		for(Employee emp:EMPLOYEE_LIST)
		{
			if(emp.getId()==employee.getId())
			{
				emp.setName(employee.getName());
				emp.setSalary(employee.getSalary());
				emp.setPermanent(employee.getPermanent());
				emp.setDepartment(employee.getDepartment());
				emp.setSkill(employee.getSkill());
				
				return emp;
			}
		}
		throw new EmployeeNotFoundException();
	}
	
	public void deleteEmployee(int id) throws EmployeeNotFoundException
	{
		Employee flag=null;
		for(Employee emp:EMPLOYEE_LIST)
		{
			if(emp.getId()==id)
			{
				flag=emp;
						
			}
		}
		if(flag!=null)
		{
			EMPLOYEE_LIST.remove(flag);
		}
		else
		{
			throw new EmployeeNotFoundException();
		}
	}
	
	public Employee getEmployee(int id) throws EmployeeNotFoundException
	{
		Employee emp=null;
		for(Employee e:EMPLOYEE_LIST)
		{
			if(e.getId()==id)
			{
				emp=e;
						
			}
		}
		if(emp!=null)
			return emp;
		else
			throw new EmployeeNotFoundException();
			
	}
}
