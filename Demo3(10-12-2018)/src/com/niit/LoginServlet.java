package com.niit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.bo.LoginBO;
import com.niit.model.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		LoginBO loginBO = new LoginBO();
		User user = new User();
		RequestDispatcher view = null;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		user.setUsername(username);
		user.setPassword(password);
		
		boolean status = loginBO.validate(user);
		if(status)
		{
			view = request.getRequestDispatcher("success.html");
			view.forward(request, response);
		}
		else
		{
			view = request.getRequestDispatcher("error.html");
			view.forward(request, response);
		}
	}
}