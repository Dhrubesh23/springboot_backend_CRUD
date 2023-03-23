package com.dhrubesh.springboot.service;

import java.util.List;

import com.dhrubesh.springboot.model.Employee;

public interface EmployeeService  {
	Employee saveEmployee(Employee employee);
	
	List<Employee>getAllEmployees();
	
	Employee getEmployeeById(long id);
	
	Employee upadateEmployee(Employee employee, long id);
	
	void deleteEmployee(long id);
}
