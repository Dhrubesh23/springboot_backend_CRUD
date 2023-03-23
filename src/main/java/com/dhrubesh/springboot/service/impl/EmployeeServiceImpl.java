package com.dhrubesh.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dhrubesh.springboot.exception.ResourceNotFoundException;
import com.dhrubesh.springboot.model.Employee;
import com.dhrubesh.springboot.repository.EmployeeRepository;
import com.dhrubesh.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	@Override
	public Employee getEmployeeById(long id) {
//		Optional<Employee> employee = employeeRepository.findById(id);
		
//		if(employee.isPresent()) {
//			return employee.get();
//			}
//			else {
//				throw new ResourceNotFoundException("Employee", "Id", id);
//			}
		
		// Using lambda expression
		return employeeRepository.findById(id).orElseThrow(() -> 
					new ResourceNotFoundException("Employee", "Id", id)); 
		
	}

	@Override
	public Employee upadateEmployee(Employee employee, long id) {
		
		// we need to check employee with given id is exist in  DB or not
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee", "Id", id));
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
	
		return employeeRepository.save(existingEmployee);
	}

	@Override
	public void deleteEmployee(long id) {
		
		//Check whether the employee exists in a DB or not	
		employeeRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("Employee", "id", id));
		
		employeeRepository.deleteById(id);
		
	}
	
	
	
	
}
	

