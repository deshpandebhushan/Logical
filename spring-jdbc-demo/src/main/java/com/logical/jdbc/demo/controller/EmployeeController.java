package com.logical.jdbc.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<String> getAllEmployees() throws Exception {
		return new ResponseEntity<>("Valid User", HttpStatus.OK);

	}

}
