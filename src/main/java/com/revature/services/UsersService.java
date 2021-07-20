package com.revature.services;

import com.revature.daos.UsersDAO;
import com.revature.daos.UsersDAOInterface;
import com.revature.models.Users;

public class UsersService {
	UsersDAOInterface uDao = new UsersDAO();
	
	public Users getUsers(String ers_username) {
		return uDao.getUserByUsername(ers_username);
	}
}
