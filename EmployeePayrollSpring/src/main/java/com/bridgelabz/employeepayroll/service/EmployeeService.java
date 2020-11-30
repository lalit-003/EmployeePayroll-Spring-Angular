package com.bridgelabz.employeepayroll.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayroll.dto.EmployeeDto;
import com.bridgelabz.employeepayroll.model.EmployeePayroll;
import com.bridgelabz.employeepayroll.repository.IEmployeeRepository;
import com.bridgelabz.employeepayroll.utility.Response;

@Service
public class EmployeeService implements IEmployeeService{
	
	@Autowired
	private IEmployeeRepository empRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Response addEmployee(EmployeeDto employeePayrollDto) {
	
		EmployeePayroll employeePayroll = mapper.map(employeePayrollDto, EmployeePayroll.class);
		empRepository.save(employeePayroll);
		System.out.println("Employee " + employeePayroll + " added to repository");
		Response response = new Response(200, "Employee Data added susscesfully");
		return response;
	}

	@Override
	public String getByID(Long id) {
		return mapper.map(empRepository.findById(id).get(),EmployeeDto.class).toString();
	}

	@Override
	public void deleteById(Long id) {
		empRepository.deleteById(id);
	}

	@Override
	public Response updateById(Long id,EmployeeDto employeeDto) {
		EmployeePayroll employeePayroll = empRepository.findById(id).get();
		employeePayroll.setEmployeeName(employeeDto.getEmployeeName());
		employeePayroll.setSalary(employeeDto.getSalary());
		employeePayroll.setEmail(employeeDto.getEmail());
		empRepository.save(employeePayroll);
		Response response = new Response(200, "Employee Data updated susscesfully");
		return response;
	}

	@Override
	public String getByEmail(String email) {
		EmployeePayroll employeePayroll = empRepository.findByEmail(email);
		if(employeePayroll != null)
			return mapper.map(employeePayroll,EmployeeDto.class).toString();
		else
			return "Employee Object having email " + email +"not found";
	}

	@Override
	public List<EmployeePayroll> getList() {
		List<EmployeePayroll> employeePayroll = empRepository.findAll();
		if(employeePayroll != null) {
			return employeePayroll;
		
		}else
			return null;
	}
}
