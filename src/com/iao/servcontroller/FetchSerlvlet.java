package com.iao.servcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iao.dao.fetchcredit;
import com.iao.model.CreditModel;

/**
 * Servlet implementation class FetchSerlvlet
 */

@WebServlet("/affiche")
public class FetchSerlvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public FetchSerlvlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		  HttpSession session = request.getSession();
		int	idc = (int) session.getAttribute("id")	;	
		  
		  List<CreditModel> l =fetchcredit.fetch(idc);
		     int i=0;
		 
		  for(CreditModel c:l) {
	
			  session.setAttribute("credit"+i,c );
			  //System.out.println("credit c >"+c);
	
			  i++;
		  }
		  
		  session.setAttribute("numberof", i);
		  session.setAttribute("listcredit",l);
	
		  response.sendRedirect("listcredit.jsp");
         
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
