package com.revature.services;

import java.util.List;

import com.revature.daos.ReimbursementsDAO;
import com.revature.daos.ReimbursementsDAOInterface;
import com.revature.models.Reimbursements;

public class ReimbursementsService {
	
	private ReimbursementsDAOInterface rd = new ReimbursementsDAO();
	
	public void addNewTicket(int reimb_type_id, String reimb_description, int reimb_amount) {
		if(reimb_type_id > 0 && reimb_type_id < 5) {
			rd.addReimbursement(reimb_type_id, reimb_description, reimb_amount);
		} else {
			System.out.println("Something failed!");
		}
	}
	public List<Reimbursements> getPreviousReimbursements(){
		return rd.viewPreviousTickets();
	}
	public List<Reimbursements> getPendingReimbursements(){
		return rd.viewPendingTickets();
	}
	
	public List<Reimbursements> viewAllTickets(){
		return rd.viewAllTickets();
	}
	
	public List<Reimbursements> filterByStatus(int reimb_status_id){
		if(reimb_status_id > 0 && reimb_status_id < 4) {
			return rd.filterByStatus(reimb_status_id);
		} else {
			return null;
		}
	}
	
	public void resolveTicket(int reimb_id, int reimb_status_id) {
		if(reimb_status_id > 0 && reimb_status_id < 4) {
			rd.resolveTicket(reimb_id, reimb_status_id);
		} else {
			
		}
	}
}
