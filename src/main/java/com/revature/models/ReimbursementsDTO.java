package com.revature.models;

public class ReimbursementsDTO {

	public int reimb_id;
	
	public int reimb_type_id;
	
	public int reimb_status_id;
	
	public int reimb_amount;
	
	public String reimb_description;
	
	public ReimbursementsDTO(int reimb_status_id) {
		super();
		this.reimb_status_id = reimb_status_id;
	}
	
	public ReimbursementsDTO(int reimb_id, int reimb_status_id) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_status_id = reimb_status_id;
	}
	
	public ReimbursementsDTO() {
		super();
	}
}
