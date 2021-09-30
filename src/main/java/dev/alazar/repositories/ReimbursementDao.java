package dev.alazar.repositories;

import java.util.List;


import dev.alazar.models.Reimbursement;

public interface ReimbursementDao {	
	
	Reimbursement viewPending();
	
	Reimbursement viewResolved();

	Reimbursement viewAllPending(String name);
	
	Reimbursement viewAllResolved(String name);
	
	List<Reimbursement> viewEmployeePending();
	
	List<Reimbursement> viewEmployeeResolved();
	
	List<Reimbursement> viewAllPending();
	
	List<Reimbursement> viewAllResolved();
	
	boolean createReimbursement(Reimbursement r);

	Reimbursement getReimbursement(int employee_id);
	
}
