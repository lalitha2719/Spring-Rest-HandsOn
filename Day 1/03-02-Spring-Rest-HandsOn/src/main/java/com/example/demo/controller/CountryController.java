package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Country;
import com.example.demo.service.CountryService;



@RestController
public class CountryController {
	@GetMapping(value ="/countries")			
	public List<Country> getallCountries(){
		CountryService service= new CountryService();
		return service.displayCountries();
	}
	
	@GetMapping(value ="/country")			
	public Country getCountryIndia(){
		CountryService service= new CountryService();
		return service.displayCountry();
	}
	
	@GetMapping(value="/country/{code}")
	public  ResponseEntity<Country> getCountryByCode(@PathVariable String code) 	{
		Country country=null;
		CountryService service= new CountryService();
		country= service.getCountryByCode(code);
		return new ResponseEntity<Country>(country,HttpStatus.OK);
	}
}
