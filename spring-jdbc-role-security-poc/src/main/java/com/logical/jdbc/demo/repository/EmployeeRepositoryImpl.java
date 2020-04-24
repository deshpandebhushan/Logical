package com.logical.jdbc.demo.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
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
		List<Employees> emp = new ArrayList<Employees>();
		StoredProcedureQuery findByYearProcedure = em.createStoredProcedureQuery("get_All_Employees");
		List<List<Object[]>> finalresult = new ArrayList<List<Object[]>>();
		findByYearProcedure.execute();
		List<Object[]> result = findByYearProcedure.getResultList();
		finalresult.add(result);
		if (findByYearProcedure.hasMoreResults()) {
			System.out.println("yes it has ");
			List<Object[]> result2 = findByYearProcedure.getResultList();
			finalresult.add(result2);
			System.out.println(result2.toString());
		}
		for (List<Object[]> out : finalresult) {
			for (Object[] out1 : out) {
				emp.add(new Employees((int) out1[0], (String) out1[1], (String) out1[2], (String) out1[3]));
			}
		}
		return emp;
	}
}
// SP code changes , please update SP for multiple result set to below one and add record into Emplyee table
/*CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_employees`()
BEGIN
select * from employees where employeeID = 1 ;
select * from employees where employeeID = 2 ;
END*/
//INSERT INTO `demo_database`.`employees` (`employeeID`, `firstName`, `lastName`, `address`) VALUES ('2', 'test', 'test1', 'test 3');
