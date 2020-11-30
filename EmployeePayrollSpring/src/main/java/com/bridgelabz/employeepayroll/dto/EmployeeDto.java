package com.bridgelabz.employeepayroll.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmployeeDto {
	@NotNull
	@Size(min = 3,message = "Name should have atleast 3 characters")
	private String employeeName;
	
	@NotNull
	private Long salary;
	
	@NotNull
	private String email;
	
	
	
	@Override
	public String toString() {
		return "employeeName=" + employeeName + ", salary=" + salary + ", email=" + email;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}
	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	/**
	 * @return the salary
	 */
	public Long getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	
	
}
