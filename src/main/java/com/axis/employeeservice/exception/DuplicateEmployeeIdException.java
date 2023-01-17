package com.axis.employeeservice.exception;

public class DuplicateEmployeeIdException extends RuntimeException{

	private static final long serialVersionUID = -465324L;

	public DuplicateEmployeeIdException() {
		super();
	}

	public DuplicateEmployeeIdException(String message) {
		super(message);
	}
}