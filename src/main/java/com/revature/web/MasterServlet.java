package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.EmployeeController;
import com.revature.controllers.LoginController;
import com.revature.controllers.ManagerController;

public class MasterServlet extends HttpServlet {
	
	private EmployeeController ec = new EmployeeController();
	private LoginController lc = new LoginController();
	private ManagerController mc = new ManagerController();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("application/json");
		
		res.setStatus(404);
		
		final String URI = req.getRequestURI().replace("/ers/", "");
		
		switch(URI) {
		case "employees/previous":
			ec.getPreviousReimbursements(res);
			break;
			
		case "employees/pending":
			ec.getPendingReimbursements(res);
			break;
			
		case "employees/add":
			ec.addReimbursement(req, res);
			break;
			
		case "managers/all":
			mc.getAllTickets(res);
			break;
			
		case "managers/filter":
			mc.getTicketsByStatus(req, res);
			break;
			
		case "managers/resolve":
			mc.resolveTicket(req, res);
			break;
			
		case "login":
			lc.login(req, res);
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		doGet(req, res);
	}
	
}
