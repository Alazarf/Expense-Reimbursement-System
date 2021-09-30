package dev.alazar.services;

import java.util.ArrayList;

import java.util.Scanner;
import dev.alazar.controllers.Controller;
import dev.alazar.models.Employee;
import dev.alazar.models.Reimbursement;
import dev.alazar.repositories.EmployeeDao;
import dev.alazar.repositories.EmployeeDaoJDBC;
import dev.alazar.repositories.ReimbursementDao;
import dev.alazar.repositories.ReimbursementDaoJDBC;
public class EmployeeService {
	
	static Scanner sc = new Scanner(System.in);
	static int id;
	static String typeOfReimbursement;
	static double amount;
	static int employee_id;
	static String username;
	static String  password;
	static String first_name;
	static String last_name;
	static String email;
	static String type;
	static String status = "Pending";
	static String emp_type = "Employee";
	public static ArrayList<Reimbursement> reimbursement = new ArrayList<Reimbursement>();
	public static ArrayList<Employee> employee = new ArrayList<Employee>();
	/*
	 * 
	 */
	public static void submitReimbursement() {
		System.out.println("Submit Reimbursement Here");
		System.out.println(" ");
		System.out.println("What is Reimbursement for? ");
		typeOfReimbursement = sc.next();
		System.out.println("Enter amount to reimburst: ");
		amount = sc.nextDouble();
		//System.out.println("Enter image for approval: ");
		
		ReimbursementDao reimbursementDao = new ReimbursementDaoJDBC();
		employee_id = Controller.currentEmployee.id;
		typeOfReimbursement = "Reimbursement is for: " + typeOfReimbursement;
		System.out.println(employee_id);
		System.out.println(typeOfReimbursement);				
		reimbursementDao.createReimbursement(new Reimbursement(id, employee_id, typeOfReimbursement, amount, status));
		reimbursement.add(new Reimbursement(id, employee_id, typeOfReimbursement, amount, status));				
		System.out.println("Thank you for subminting. ");						
		
	}

	public static void viewPendingReimbursement() {
		System.out.println("Pending Reimbursements");
		ReimbursementDao reimbursementDao = new ReimbursementDaoJDBC();
		for(Reimbursement r : reimbursementDao.viewEmployeePending()) {
			if("Pending".equals(r.status) ) 
			System.out.println( r.title + "  " + r.amountrequested + " " + r.status  + "  " + r.getDaterequested() );
			
		}
		
	}

	public static void viewResolvedReimbursement() {
		System.out.println("Resolved Reimbursement");
		ReimbursementDao reimbursementDao = new ReimbursementDaoJDBC();
		for(Reimbursement r : reimbursementDao.viewEmployeePending()) {
			if("Approved".equals(r.status) ) 
			System.out.println( r.title + "  " + r.amountrequested + " " + r.status  + "  " + r.getDaterequested() );
				
		}
		
	}
	/*
	 * 
	 */
	public static void addEmployee() {
		System.out.println("Add new Employee");
		System.out.print("Enter First Name: ");
		first_name = sc.next();
		System.out.print("Enter Last Name: ");
		last_name = sc.next();
		System.out.print("Enter Email: ");
		email = sc.next();
		System.out.print("Enter Username: ");
		username = sc.next();
		System.out.print("Enter Password: ");
		password = sc.next();
		System.out.println("Employee has been registered succesfully!");					
		EmployeeDao employeeDao = new EmployeeDaoJDBC();
		employeeDao.createEmployee(new Employee(id, first_name, last_name, email, username, password, emp_type));
		employee.add(new Employee(id, first_name, last_name, email, username, password, emp_type));
	}

	

}
