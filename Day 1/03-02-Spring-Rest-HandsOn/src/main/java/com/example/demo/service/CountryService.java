package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.Country;
import com.example.demo.exception.CountryNotFoundException;


public class CountryService {

	public Country displayCountry() {
		ApplicationContext context = new ClassPathXmlApplicationContext("india.xml"); 
		Country country = (Country) context.getBean("in", Country.class);
		return country;
	}
	 
	
	public List<Country> displayCountries()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> list=context.getBean("countryList",java.util.ArrayList.class);
		return list;
		
	}
	/*
	 * 	public Employee getSingleEmployee(Integer eid) {
	  Optional<Employee> emp=repo.findById(eid);
	  return emp.orElseThrow(()-> new EmployeeNotFoundException("Employee With Given ID :"+eid+" Not Available"));
			  
	}
	 */
	
	public Country getCountryByCode(String code) throws CountryNotFoundException
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country=null;
		try {
		 country = context.getBean(code, Country.class);
		}
		catch(Exception e)
		{
			throw new CountryNotFoundException("Country with code "+code+" not found");
		}
		
			return country;
		
	}
}
