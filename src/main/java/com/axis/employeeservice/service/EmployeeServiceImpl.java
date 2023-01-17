package com.axis.employeeservice.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.employeeservice.entity.Employee;
//import com.axis.employeeservice.exception.DuplicateEmployeeIdException;
import com.axis.employeeservice.exception.EmployeeNotFoundException;
import com.axis.employeeservice.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	Logger logger=Logger.getLogger(EmployeeServiceImpl.class.getName());
	
	
	@Override
	public Employee getEmployeeById(int empId) {
		
		Optional<Employee> empOpt =employeeRepository.findById(empId);
		if(!empOpt.isPresent())
			throw new EmployeeNotFoundException("Employee with employeeId "+empId+" not Found");
		return empOpt.get();
	}

	@Override
	public List<Employee> getAllemployees() {
		
		return (List<Employee>) employeeRepository.findAll();

	}

	@Override
	public void addEmployee(Employee employee) {
		
		/*List<Employee> empList = (List<Employee>) employeeRepository.findAll();
		for(Employee emp:empList) {
			if(emp.getEmpId()==employee.getEmpId())
				throw new DuplicateEmployeeIdException("Employee with employee ID "+employee.getEmpId()+" already exists");
		}*/
		employeeRepository.save(employee);
		

	}

	@Override
	public void deleteEmployeeById(int empId) {
		boolean flag=false;
		List<Employee> empList = (List<Employee>) employeeRepository.findAll();
		for(Employee emp:empList) {
			if(emp.getEmpId()==empId) {
				flag=true;
				break;
			}
		}
		if(!flag)
			throw new EmployeeNotFoundException("Employee with employee ID "+empId+" not present");
		employeeRepository.deleteById(empId);


	}

	@Transactional
	@Override
	public void updateEmployeeById(Employee employee, int empId) {
		employeeRepository.updateEmployeeInfo(employee.getEmpName(),
											employee.getEmpDepartment(),
											employee.getEmpProjectName(),
											employee.getEmpDesignation(),
											employee.getEmpEmail(),
											employee.getEmpMobileNo(),
											employee.getSupervisorName(),
											employee.getEmpAddress(),
											employee.getEmpPassword(),
											employee.getEmpId());
		

	}
}
