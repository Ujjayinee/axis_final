package com.axis.employeeservice.service;

import java.util.List;

import com.axis.employeeservice.entity.Employee;



public interface EmployeeService {
	public Employee getEmployeeById(int empId);
	public List<Employee> getAllemployees();
	public void addEmployee(Employee employee);
	public void deleteEmployeeById(int empId);
	public void updateEmployeeById(Employee employee, int empId);
}
