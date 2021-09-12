package com.alazar.dao;

/*
 * Interface: ReimbursementDAO
 * Author: Kyle Settles
 * Description: Interface used to define the methods for handling reimbursements in database for easy transition between databases
 * 		Implemented by the ReimbursementDAOJdbc
 */

import java.util.List;

import com.alazar.app.Reimbursement;

public interface ReimbursementDAO {
	
	Reimbursement getReimbursementByID(int id);
	
	List<Reimbursement> retrieveAllReimbursements();
	
	List<Reimbursement> getReimbursementsByUser(int id);
	
	int addReimbursement(Reimbursement rb);
	
	boolean approveDeny(String choice, int id, int resolverId);
}