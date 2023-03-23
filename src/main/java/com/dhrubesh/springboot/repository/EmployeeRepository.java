package com.dhrubesh.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhrubesh.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
}
