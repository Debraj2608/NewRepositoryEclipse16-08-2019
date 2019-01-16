package com.niit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.niit.model.User;



public class LoginDAO 
{
	private Connection connections;
	public LoginDAO()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connections = DriverManager.getConnection("jdbc:mysql://localhost:3306/ServletDemo3DB?autoReconnect=true&useSSL=false","root","debraj2608");
		}catch(ClassNotFoundException exception)
		{
			System.out.println(exception);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public boolean validate(User user)
	{
		boolean status = false;
		try
		{
			String sql = "SELECT username, password from user_master WHERE username = ? and password = ?";
		
			PreparedStatement statement = connections.prepareStatement(sql);
			statement.setString(1,  user.getUsername());
			statement.setString(2, user.getPassword());
			ResultSet rs = statement.executeQuery();
			
			if(rs.next())
			{
				status  = true;
			}
		}
		catch(SQLException exception)
		{
			System.out.println(exception);
		}
		return status;
	}
}