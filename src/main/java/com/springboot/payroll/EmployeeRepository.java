package com.springboot.payroll;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Optional<Employee> findById(long id);
	
	List<Employee> findAll();
	

}