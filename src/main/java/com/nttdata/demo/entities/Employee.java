/**
 * 
 */
package com.nttdata.demo.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * @author 319866
 * An entity class representing an Employee in the NTT Data organisatio
 */

@Entity
public class Employee {
	private @Id
	@GeneratedValue Long id;
	
	private String name;
	private String designation;

	Employee(){}
	
	public Employee(String name,String designation){
		this.name = name;
		this.designation = designation;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDesignation() {
		return this.designation;
	}
	
	public void setId(Long id) {
		this.id  =id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	

	  @Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof Employee))
	      return false;
	    Employee employee = (Employee) o;
	    return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name)
	        && Objects.equals(this.designation, employee.designation);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.id, this.name, this.designation);
	  }

	  @Override
	  public String toString() {
	    return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", designation='" + this.designation + '\'' + '}';
	  }
	
}
