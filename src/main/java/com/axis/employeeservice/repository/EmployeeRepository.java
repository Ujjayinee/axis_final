package com.axis.employeeservice.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axis.employeeservice.entity.Employee;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

	@Modifying
	@Query("update Employee set empName=?1, empDepartment=?2, empProjectName=?3, empDesignation=?4,"
			+ "empEmail=?5, empMobileNo=?6, supervisorName=?7, empAddress=?8, empPassword=?9 where empId=?10")
	public void updateEmployeeInfo(String empName, String empDepartment,String empProjectName,
			String empDesignation,String empEmail,long empMobileNo,String supervisorName,
			String empAddress, String empPassword,int empId);
}
