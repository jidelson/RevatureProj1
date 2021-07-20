package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursements;

public interface ReimbursementsDAOInterface {
	
	public void addReimbursement(int reimb_type_id, String reimb_description, int reimb_amount);
	
	public List<Reimbursements> viewPendingTickets();
	
	public List<Reimbursements> viewPreviousTickets();
	
	public List<Reimbursements> viewAllTickets();
	
	public List<Reimbursements> filterByStatus(int reimb_status_id);
	
	public void resolveTicket(int reimb_id, int reimb_status_id);
}
