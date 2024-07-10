/**
 * 
 */
package com.nttdata.demo.exceptions;

/**
 * @author 319866
 * Exception class to handle all the types of exceptions thrown by operations on Employee entity
 */
public class EmployeeNotFoundException extends RuntimeException{
	public EmployeeNotFoundException(Long id){
		super("Could not found employee with id "+id);
	}
}
