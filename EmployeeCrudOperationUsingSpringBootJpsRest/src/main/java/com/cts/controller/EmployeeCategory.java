package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exceptions.EmployeeNotFound;
import com.cts.exceptions.InvalidEmployeeIdException;
import com.cts.model.Employee;
import com.cts.service.EmployeeService;

@RestController
@RequestMapping("/employees") 
public class EmployeeCategory {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/getMsg")
	public String sayHello() {
		return "Say hi";
	}
	
	@PostMapping("/saveemployee")
	public String insertEmployee(Employee employee) {
		return service.AddEmployee(employee);
	}
	
	@PutMapping("/updateemployee")
	public String updateEmployee(@RequestBody Employee employee) {
		return service.UpdateEmployee(employee);
	}
	
	@DeleteMapping("/deleteeemployee/{eid}")
	public String deletedEmployee(@PathVariable("eid") int empId) {
		return service.DeletedEmployee(empId);
	}

	@GetMapping("/getemployee/{eid}")
	public Employee getEmployee(@PathVariable("eid") int empId) throws InvalidEmployeeIdException {
		return service.GetEmployee(empId);
	}
	
	@GetMapping("getallemp")
	public List<Employee> getAllEmployee(){
		return service.GetAllEmployee();
	}
	
	@GetMapping("getallempbetweensalary/{iv}/{fv}")
	public List<Employee> getAllEmployeeBetweenSalary(@PathVariable("iv") int intialValue,@PathVariable("fv") int finalValue) {
		return service.GetAllEmployeeBetweenSalaries(intialValue,finalValue);
	}
}
