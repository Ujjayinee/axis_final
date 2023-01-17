package com.axis.employeeservice.exception;

public class EmployeeNotFoundException extends RuntimeException{
	private static final long serialVersionUID = -465322L;

	public EmployeeNotFoundException() {
		super();
	}

	public EmployeeNotFoundException(String message) {
		super(message);
	}
}