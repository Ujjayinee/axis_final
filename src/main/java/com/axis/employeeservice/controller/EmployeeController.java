package com.axis.employeeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.axis.employeeservice.entity.Employee;
import com.axis.employeeservice.service.EmployeeService;
@CrossOrigin("http://localhost:3000/")
@RestController
public class EmployeeController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EmployeeService employeeService;
	
	public EmployeeController() {
		
	}
	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}


	@GetMapping("/employee/{empId}")
	public Employee getEmployeeById(@PathVariable int empId) {
		return employeeService.getEmployeeById(empId);
	}
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllemployees();
	}
	@PostMapping("/employee")
	public ResponseEntity<String> addEmployee (@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return new ResponseEntity<>("Employee Added Successfully...",HttpStatus.OK);
	} 
	@DeleteMapping("/employee/{empId}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int empId) {
		employeeService.deleteEmployeeById(empId);
		return new ResponseEntity<>("Employee Deleted Succesfully...",HttpStatus.OK);
	}
	@PutMapping("/employee/{empId}")
	public ResponseEntity<String> updateEmployee (@RequestBody Employee employee, @PathVariable int empId) {
		if(empId!=employee.getEmpId()) {
			return new ResponseEntity<>("Employee Id mismatched...",HttpStatus.OK);
		}else {
			employeeService.updateEmployeeById(employee, empId);
			return new ResponseEntity<>("Employee Updated successfully...",HttpStatus.OK);
		}
	}
}
