package com.spdemo.spring.jpa.repository;

import java.util.List;

import com.spdemo.spring.jpa.domain.Employees;

public interface EmployeeRepositoryCustom {

    List<Employees> getAllEmployees();
    @SuppressWarnings("rawtypes")
	List getAddition(Integer firstNumber, Integer secondNumber);
}
