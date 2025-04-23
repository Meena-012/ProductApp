package com.cts.service;

import java.util.List;

import com.cts.exceptions.InvalidEmployeeIdException;
import com.cts.model.Employee;

public interface EmployeeService  {
	public abstract String AddEmployee(Employee employee);

	public abstract String UpdateEmployee(Employee employee);

	public abstract String DeletedEmployee(int empId);

	public abstract Employee GetEmployee(int empId) throws InvalidEmployeeIdException;

	public abstract List<Employee> GetAllEmployee();

	public abstract List<Employee> GetAllEmployeeBetweenSalaries(int initialValue, int finalValue);
}
