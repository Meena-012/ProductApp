package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.exceptions.InvalidEmployeeIdException;
import com.cts.model.Employee;
import com.cts.repository.EmployeeRepository;


@Service("employeeservice")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository repository;
	
	

	@Override
	public String AddEmployee(Employee employee) {
		Employee emp=repository.save(employee);
		if (emp != null)
			return "Employee saved Successfully";
		else
			return "Employee not saved";
	}

	@Override
	public String UpdateEmployee(Employee employee) {
		Employee emp=repository.save(employee);
		if (emp != null)
			return "Employee updated Successfully";
		else
			return "Employee not updated";
	}

	@Override
	public String DeletedEmployee(int empId) {
		repository.deleteById(empId);
		return "Employee Deleted Successfully";
	}

	@Override
	public Employee GetEmployee(int empId) throws InvalidEmployeeIdException {
		Optional<Employee> optional = repository.findById(empId);
		return optional.get();
	}

	@Override
	public List<Employee> GetAllEmployee() {
		return repository.findAll();
	}

	@Override
	public List<Employee> GetAllEmployeeBetweenSalaries(int initialValue, int finalValue) {
		return repository.findByempSalBetween(initialValue, finalValue);
	}
	
}
