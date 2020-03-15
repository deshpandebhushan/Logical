package com.logical.jdbc.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logical.jdbc.demo.model.Employees;
import com.logical.jdbc.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@PreAuthorize("hasRole('USER') or hasRole('TEST')")
	@RequestMapping(value = "/getEmployee", method = RequestMethod.GET)
	public ResponseEntity<List<Employees>> getAllEmployees() throws Exception {
		return employeeService.getAllEmployees();

	}

}
