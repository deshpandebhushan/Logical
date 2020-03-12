package com.spdemo.spring.jpa.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.spdemo.spring.jpa.domain.Employees;

@Component
@Transactional
@SuppressWarnings("unchecked")
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@PersistenceContext
	private EntityManager em;

	
	@Override

	public List<Employees> getAllEmployees() {
		StoredProcedureQuery findByYearProcedure = em.createStoredProcedureQuery("get_All_Employees");
		findByYearProcedure.execute();
		return findByYearProcedure.getResultList();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getAddition(Integer firstNumber, Integer secondNumber) {
		StoredProcedureQuery findByYearProcedure = em.createStoredProcedureQuery("get_addition")
				.registerStoredProcedureParameter("firstNumber", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("secondNumber", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("total", BigDecimal.class, ParameterMode.OUT)
				.setParameter("firstNumber", firstNumber).setParameter("secondNumber",secondNumber);
		findByYearProcedure.execute();
		return findByYearProcedure.getResultList();
	}
}
