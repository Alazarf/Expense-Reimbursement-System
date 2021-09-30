package dev.alazar.models;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Reimbursement {
	public int id;
	public int employee_id;
	public String title;
	public double amountrequested;
	public String daterequested;
	public String status;
	public String resolved_status;
	static NumberFormat formatter = new DecimalFormat("#0.00");
	public Reimbursement(int id, int employee_id, String title, double amountrequested, String status) {
		super();
		this.id = id;
		this.employee_id = employee_id;
		this.title = title;
		this.amountrequested = amountrequested;
		this.status = status;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getAmountrequested() {
		return amountrequested;
	}

	public void setAmountrequested(double amountrequested) {
		this.amountrequested = amountrequested;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getResolved_status() {
		return resolved_status;
	}

	public void setResolved_status(String resolved_status) {
		this.resolved_status = resolved_status;
	}

	public String getDaterequested() {
		return daterequested;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", employee_id=" + employee_id + ", title=" + title + ", amountrequested="
				+ amountrequested + ", daterequested=" + daterequested + ", status=" + status + ", resolved_status=" + resolved_status + "]";
	}
	
}
