package com.spdemo.spring.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spdemo.spring.jpa.domain.Employees;
import com.spdemo.spring.jpa.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Employees>> getAllEmployees() {
		return new ResponseEntity<>(employeeRepository.getAllEmployees(), HttpStatus.OK);

	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/{firstNumber}/{secondNumber}", method = RequestMethod.GET)
	public ResponseEntity<List> getAllEmployeeById(@PathVariable(name = "firstNumber") Integer firstNumber,
			@PathVariable(name = "secondNumber") Integer secondNumber) {
		return new ResponseEntity<>(employeeRepository.getAddition(firstNumber, secondNumber), HttpStatus.OK);
	}
}
