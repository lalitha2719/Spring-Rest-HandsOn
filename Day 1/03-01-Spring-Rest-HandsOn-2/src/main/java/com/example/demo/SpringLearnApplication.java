package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.logging.Logger;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SpringLearnApplication{



	
	 private static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	 static ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	 
	public static void main(String[] args) {

		SpringApplication.run(SpringLearnApplication.class, args);
		LOGGER.info("Start");
		displayCountry();
		LOGGER.info("End");
		LOGGER.info("List of countries");
		displayListOfCountries();
		LOGGER.info("end of list");
	}

	
	
	private static void displayCountry() {
		
		LOGGER.info("Start displayCountry");
		
		
		Country country = (Country) context.getBean("country", Country.class);
		Country anotherCountry = context.getBean("country", Country.class);
		LOGGER.info("Country : {}", country.toString());
		LOGGER.info("Country : {}", anotherCountry.toString());
		
		List<Country> countryList=(List) context.getBean("countryList");
		
		
	}
	
	public static void displayListOfCountries() {
		LOGGER.info("START");
		List<Country> list=(List) context.getBean("countryList");
		LOGGER.info("List: {}", list);
		LOGGER.info("END");
	}

}