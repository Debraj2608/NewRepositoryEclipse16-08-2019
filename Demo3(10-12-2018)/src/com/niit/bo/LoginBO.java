package com.niit.bo;

import com.niit.dao.LoginDAO;
import com.niit.model.User;

public class LoginBO 
{
	private LoginDAO loginDAO = new LoginDAO();
	public boolean validate(User user)
	{
		boolean status = loginDAO.validate(user);
		return status;
	}
}
