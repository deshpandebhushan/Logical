package com.logical.jdbc.demo.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.logical.jdbc.demo.model.Employees;
import com.logical.jdbc.demo.service.EmployeeService;

@Component
@Transactional
@SuppressWarnings("unchecked")
public class EmployeeRepositoryImpl {

	@PersistenceContext
	private EntityManager em;

	

	public List<Employees> getAllEmployees() {
		StoredProcedureQuery findByYearProcedure = em.createStoredProcedureQuery("get_All_Employees");
		findByYearProcedure.execute();
		List<Object[]> result = findByYearProcedure.getResultList();
		return result.stream().map(employee -> new Employees((int) employee[0], (String) employee[1],
				(String) employee[2], (String) employee[3])).collect(Collectors.toList());
	}
}
