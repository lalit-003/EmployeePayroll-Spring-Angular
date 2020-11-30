package com.bridgelabz.employeepayroll.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayroll.dto.EmployeeDto;
import com.bridgelabz.employeepayroll.model.EmployeePayroll;
import com.bridgelabz.employeepayroll.service.IEmployeeService;
import com.bridgelabz.employeepayroll.utility.Response;

@RestController
@RequestMapping("/hello")
@CrossOrigin
public class EmployeeController {

	
	@Autowired
	private IEmployeeService employeeService;
		
	@PostMapping(value= "/post")
	public ResponseEntity<Response> addEmployee(@Valid @RequestBody EmployeeDto employeePayrollDto) {
		System.out.println("Inside Controller");
		Response response; 
		response = employeeService.addEmployee(employeePayrollDto);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	

	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam(value = "id")Long id) {
		System.out.println("Deleting using id: " + id);
		employeeService.deleteById(id);
		return new ResponseEntity<String>("Deleted Object with id: " + id,HttpStatus.OK);
	}
	
	@PutMapping("/put/{id}")
	public ResponseEntity<Response> update(@RequestBody EmployeeDto employeeDto,@PathVariable Long id) {
		System.out.println("Updating using id: " + id);
		Response response; 
		response = employeeService.updateById(id,employeeDto);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public String returnString(@RequestParam(value = "email") String email) {
		return employeeService.getByEmail(email);
	}
	
	@GetMapping("/get/list")
	public List<EmployeePayroll> returnStringList() {
		return employeeService.getList();
	}
	
//	@GetMapping("/get")
//	public String returnString(@RequestParam(value = "id",defaultValue = "1")Long id ){
//		return employeeService.getByID(id);
//	}
}
