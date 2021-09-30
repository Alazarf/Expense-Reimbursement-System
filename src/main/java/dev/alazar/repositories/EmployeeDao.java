package dev.alazar.repositories;

import java.util.List;

import dev.alazar.models.Employee;


public interface EmployeeDao {
	Employee getEmployee(String username);
	
	Employee viewEmployee(int id);
	
	Employee viewEmployee(String name);
	
	Employee getEmployee(String username, String password);
	
	List<Employee> viewEmployees();
	
	boolean createEmployee(Employee e);
	
}
