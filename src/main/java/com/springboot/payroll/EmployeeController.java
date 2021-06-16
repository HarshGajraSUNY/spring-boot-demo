package com.springboot.payroll;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id){
		
		
		Optional<Employee> employee = employeeRepository.findById(id);
		
		if(employee.isPresent()) {
			
			return new ResponseEntity<Employee>(employee.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@GetMapping()
	public ResponseEntity<List<Employee>> getAllEmployees(){
		
		List<Employee> employees = employeeRepository.findAll();
		
		if(!employees.isEmpty()) {
			
			return new ResponseEntity<>(employees, HttpStatus.OK);
			
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	
	}
	
	@PostMapping()
	public ResponseEntity<Employee> createEmployeeRecord(@RequestBody Employee employee)	
	{
		
		Employee employeePost = employeeRepository.save(employee);
		
		if(employee.getId()!=null) {
			return new ResponseEntity<>(employeePost, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployeeRecord(@PathVariable("id") Long id,@RequestBody Employee employee)	
	{
		
		Optional<Employee> putEmployee = employeeRepository.findById(id);
		
		if(putEmployee.isPresent()) {
			
			Employee updateEmloyee =putEmployee.get();
			
			updateEmloyee.setName(employee.getName());
			updateEmloyee.setRole(employee.getRole());
			
			return new ResponseEntity<>(employeeRepository.save(updateEmloyee),HttpStatus.OK);
			
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("all")
	public ResponseEntity<List<Employee>> createAllEmployeeRecord(@RequestBody List<Employee> employees)	
	{
		
		List<Employee> employeesPosts = employeeRepository.saveAll(employees);
		
		if(employeesPosts.size()==employees.size()) {
			return new ResponseEntity<>(employeesPosts, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Employee> patchEmployee(@PathVariable("id") Long id,@RequestBody Map<String,Object> map)
	{
		
		Employee employee = employeeRepository.findById(id).get();
		
		for(Map.Entry<String, Object> entry:map.entrySet()) {
			
			String key = entry.getKey();
			Object value = entry.getValue();
			switch(key) {
			
			case "name":employee.setName(value.toString());
			case "role":employee.setRole(value.toString());
			}
			
		}
		
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		
		
	}
	
	
}
