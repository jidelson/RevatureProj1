package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursements;
import com.revature.models.ReimbursementsDTO;
import com.revature.services.ReimbursementsService;

public class EmployeeController {

	private ReimbursementsService rs = new ReimbursementsService();
	private ObjectMapper om = new ObjectMapper();
	
	public void getPreviousReimbursements(HttpServletResponse res) throws IOException{
		List<Reimbursements> list = rs.getPreviousReimbursements();
		String json = om.writeValueAsString(list);
		res.getWriter().print(json);
		res.setStatus(200);
	}
	
	public void getPendingReimbursements(HttpServletResponse res) throws IOException{
		List<Reimbursements> list = rs.getPendingReimbursements();
		String json = om.writeValueAsString(list);
		res.getWriter().print(json);
		res.setStatus(200);
	}
	
	public void addReimbursement(HttpServletRequest req, HttpServletResponse res) throws IOException{
		if(req.getMethod().equals("POST")) {
			BufferedReader reader = req.getReader();
			
			StringBuilder sb = new StringBuilder();
			
			String line = reader.readLine();
			
			while(line != null) {
				sb.append(line);
				line = reader.readLine();
			}
			
			String body = new String(sb);
			
			ReimbursementsDTO rDTO = om.readValue(body, ReimbursementsDTO.class);
			rs.addNewTicket(rDTO.reimb_type_id, rDTO.reimb_description, rDTO.reimb_amount);
			res.setStatus(200);
		}
	}
}
