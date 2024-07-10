/**
 * 
 */
package com.nttdata.demo.utilities;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nttdata.demo.exceptions.EmployeeNotFoundException;

/**
 * @author 319866
 * used to render an HTTP 404 error:
 */

@RestControllerAdvice
public class EmployeeNotFoundAdvice {

  @ExceptionHandler(EmployeeNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String employeeNotFoundHandler(EmployeeNotFoundException ex) {
    return ex.getMessage();
  }
}
