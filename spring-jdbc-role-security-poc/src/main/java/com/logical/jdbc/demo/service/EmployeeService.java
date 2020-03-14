package com.logical.jdbc.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.logical.jdbc.demo.model.Employees;

public interface EmployeeService {
	ResponseEntity<List<Employees>> getAllEmployees();
}
