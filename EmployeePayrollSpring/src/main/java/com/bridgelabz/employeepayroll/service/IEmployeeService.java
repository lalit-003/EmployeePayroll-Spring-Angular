package com.bridgelabz.employeepayroll.service;

import java.util.List;

import com.bridgelabz.employeepayroll.dto.EmployeeDto;
import com.bridgelabz.employeepayroll.model.EmployeePayroll;
import com.bridgelabz.employeepayroll.utility.Response;

public interface IEmployeeService {
	public Response addEmployee(EmployeeDto employeePayrollDto);

	public String getByID(Long id);

	public void deleteById(Long id);

	public Response updateById(Long id, EmployeeDto employeeDto);

	public String getByEmail(String email);

	public List<EmployeePayroll> getList();
}
