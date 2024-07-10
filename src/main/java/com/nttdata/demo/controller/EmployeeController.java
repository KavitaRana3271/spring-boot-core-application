/**
 * 
 */
package com.nttdata.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.demo.entities.Employee;
import com.nttdata.demo.exceptions.EmployeeNotFoundException;
import com.nttdata.demo.repositories.EmployeeRepository;

/**
 * @author 319866
 * Rest Controller for Employee repo , maps http requests to corresponding rest methods
 */
@RestController
public class EmployeeController {
private final EmployeeRepository employeeRepository;

EmployeeController(EmployeeRepository repository){
	this.employeeRepository = repository;
}

@GetMapping("/employees")
List<Employee> getAllEmployees(){
	return employeeRepository.findAll();
}

@PostMapping("/employees")
Employee addNewEmployee(@RequestBody Employee newEmp) {
	return employeeRepository.save(newEmp);
}

@GetMapping("/employees/{id}")
Employee getEmployeeById(@PathVariable Long id) {
	return employeeRepository.findById(id).orElseThrow(()-> new EmployeeNotFoundException(id));
}

@PutMapping("employees/{id}")
Employee updateEmployee(@RequestBody Employee newEmployee,@PathVariable Long id) {
	return employeeRepository.findById(id)
			.map(employee -> {
				employee.setName(newEmployee.getName());
				employee.setDesignation(newEmployee.getDesignation());
				return employeeRepository.save(employee);
			})
			.orElseGet(() -> {
				return employeeRepository.save(newEmployee);
			});
}

@DeleteMapping("/employees/{id}")
String deleteEmployee(@PathVariable Long id) {
	employeeRepository.deleteById(id);
	return "Deleted employee with id "+id;
}

}
