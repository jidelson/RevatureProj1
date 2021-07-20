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

public class ManagerController {
	
	private ReimbursementsService rs = new ReimbursementsService();
	private ObjectMapper om = new ObjectMapper();
	
	public void getAllTickets(HttpServletResponse res) throws IOException{
		List<Reimbursements> list = rs.viewAllTickets();
		
		String json = om.writeValueAsString(list);
		
		res.getWriter().print(json);
		
		res.setStatus(200);
	}
	
	public void getTicketsByStatus(HttpServletRequest req, HttpServletResponse res) throws IOException{
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
			
			List<Reimbursements> list = rs.filterByStatus(rDTO.reimb_status_id);
			
			String json = om.writeValueAsString(list);
			
			res.getWriter().print(json);
			
			res.setStatus(200);
		}
	}
	
	public void resolveTicket(HttpServletRequest req, HttpServletResponse res) throws IOException{
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
			rs.resolveTicket(rDTO.reimb_id, rDTO.reimb_status_id);
			res.setStatus(200);
		}
	}

}
