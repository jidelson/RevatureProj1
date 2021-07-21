package com.revature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.revature.services.LoginService;
import com.revature.services.ReimbursementsService;
import com.revature.services.UsersService;

public class Tests {

	LoginService ls = new LoginService();
	UsersService us = new UsersService();
	ReimbursementsService rs = new ReimbursementsService();
	
// -------------------------------------------------------------------------------------------------
	
	@Test //we need the @Test annotation in order for this to be recognized as a testing method
	public void testValidLogin() {
		System.out.println("TESTING VALID LOGIN...");
		
		assertTrue(ls.login("jidelson", "jojo123"));
	}
	
	@Test 
	public void testInValidLogin() {
		System.out.println("TESTING INVALID LOGIN...");
		
		assertFalse(ls.login("sfesf", "grsdgdg"));
	}
	
	//-----------------------------------------------------------------------------------------
	
	@Test
	public void getUsersFirstName() {
		System.out.println("TESTING FOR GETTING USERS FIRST NAME");
		assertEquals(us.getUsers("jidelson").getUser_first_name(), "Joe");
	}
	
	@Test
	public void notUsersFirstName() {
		System.out.println("TESTING NOT EQUALS FIRST NAME");
		assertNotEquals(us.getUsers("dfischer").getUser_first_name(), "Mike");
	}
	
	@Test 
	public void getUsersLastName() {
		System.out.println("TESTING FOR GETTING USERS LAST NAME");
		assertEquals(us.getUsers("jidelson").getUser_last_name(), "Idelson");
	}
	
	@Test public void notUsersLastName() {
		System.out.println("TESTING NOT EQUALS LAST NAME");
		assertNotEquals(us.getUsers("chames").getUser_last_name(), "Smith");
	}
	
	@Test
	public void getUsersEmail() {
		System.out.println("TESTING FOR USERS EMAIL");
		assertEquals(us.getUsers("jidelson").getUser_email(), "joeidelson@gmail.com");
	}
	
	@Test
	public void notUsersEmail() {
		System.out.println("TESTING NOT EQUALS EMAIL");
		assertNotEquals(us.getUsers("klinares85").getUser_email(), "kenny@hotmail.com");
	}
	
	@Test
	public void getRoleId() {
		System.out.println("TESTING FOR USERS ROLE ID");
		assertEquals(us.getUsers("jidelson").getUser_role_id(), 1);
	}
	
	
	//-----------------------------------------------------------------------------------------
	
	
	
	
}
