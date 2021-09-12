package com.alazar.app;

public class Reimbursement {

	private int id;
	private double amount;
	private int status;
	private int type;
	
	public Reimbursement() {
		super();
	}

	public Reimbursement(int id, double amount, String description, int authorId,
			int resolverId, int status, int type) {
		this.id = id;
		this.amount = amount;
		this.status = status;
		this.type = type;
	}
	
	public Reimbursement(double amount, String description, int authorId,
			int resolverId, int status, int type) {
		this.amount = amount;
		this.status = status;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + status;
		result = prime * result + type;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
				return false;		
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", submitted=" + ", resolved=" 
				+ ", description="  + ", authorId="  + ", resolverId=" + ", status="
				+ status + ", type=" + type + "]";
	}
}