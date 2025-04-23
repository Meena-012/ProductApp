package com.cts.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{ //<which class name,primayKey wrapperdatatype>
	public abstract List<Employee> findByempSalBetween(int intialValue, int finalValue);
	
	
}
