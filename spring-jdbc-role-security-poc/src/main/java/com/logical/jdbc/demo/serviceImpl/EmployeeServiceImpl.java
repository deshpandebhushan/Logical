package com.logical.jdbc.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.logical.jdbc.demo.model.Employees;
import com.logical.jdbc.demo.repository.EmployeeRepositoryImpl;
import com.logical.jdbc.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepositoryImpl employeeRepositoryImpl;

	@Override
	public ResponseEntity<List<Employees>> getAllEmployees() {
		return new ResponseEntity<>(employeeRepositoryImpl.getAllEmployees(), HttpStatus.OK);

	}

}
