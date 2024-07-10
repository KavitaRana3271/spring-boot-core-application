/**
 * 
 */
package com.nttdata.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.demo.entities.Employee;

/**
 * @author 319866
 * JPA Repository to perform database operation with Employee Data
 */
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
}
