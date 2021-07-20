package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Users;
import com.revature.utils.ConnectionUtil;

public class UsersDAO implements UsersDAOInterface {
	
	public Users getUserByUsername(String ers_username) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "SELECT * FROM \"ers\".users WHERE ers_username = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ers_username);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Users usa = new Users (
						rs.getInt("ers_users_id"),
						rs.getString("ers_username"),
						rs.getString("ers_password"),
						rs.getString("user_first_name"),
						rs.getString("user_last_name"),
						rs.getString("user_email"),
						rs.getInt("user_role_id")
						);
				return usa;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
