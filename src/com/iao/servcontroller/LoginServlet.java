package com.iao.servcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iao.dao.LoginDao;
import com.iao.model.Client;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	
      
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		
				String email= request.getParameter("email");
				String name= request.getParameter("name");
				
				String pass= request.getParameter("pass");
		
				Client client =LoginDao.validate(email,pass);
				
				if( client != null){ 
						 HttpSession session = request.getSession( true );
						 
							session.setAttribute( "email",email );
							session.setAttribute( "pass",pass );
							session.setAttribute("id", client.getNumCli());
							session.setAttribute("username", client.getNomCli());
							
					        response.sendRedirect("index.jsp");  
					          
					    }  
				  
				     else{  
				    	 
				    	 HttpSession session = request.getSession( true );
				    	 
						  session.setAttribute( "errorlog","email ou mot de passe erroné !" );
					        response.sendRedirect("logincredit.jsp"); 
					  
				     } 
				
	
	}

	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
