package com.cts.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
@Entity
@Table(name = "emp_info")
public class Employee {


	@Id
	@GeneratedValue
	private int empId;
	@NotBlank(message="Employee Name should not Empty")
	@NotNull
	@NotEmpty
	private String empName;

	@Min(value = 10000, message = "Salary should be above 10000")
	@Max(value = 100000, message = "Salary should be below 100000")
	private int empSal;
	@Pattern(regexp = "^(Trainee|Manager|HR|Team Lead)$", message = "Designation must be Trainee, Manager, HR, or Team Lead")
	private String empDesg;

	public Employee(String empName, int empSal, String empDesg) {
		super();
		System.out.println("hello");
		this.empName = empName;
		this.empSal = empSal;
		this.empDesg = empDesg;
	}
}
