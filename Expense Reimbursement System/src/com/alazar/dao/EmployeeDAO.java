package com.alazar.dao;

import java.util.List;

import com.alazar.app.Employee;

public interface EmployeeDAO {
	
	Employee getUserbyId(int id);
	
	List<Employee> retrieveAllUsers();
	
	int addUser(Employee u);

	Employee findByUsernameAndPassword(String username, String password);
}
