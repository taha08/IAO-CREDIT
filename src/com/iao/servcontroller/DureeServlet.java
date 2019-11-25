package com.iao.servcontroller;

import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iao.CreditMetiertestStub;
import com.iao.CreditMetiertestStub.CalculCapital;
import com.iao.CreditMetiertestStub.CalculCapitalResponse;
import com.iao.CreditMetiertestStub.CalculDuree;
import com.iao.CreditMetiertestStub.CalculDureeResponse;
import com.iao.dao.InsertCreditDoa;
import com.iao.model.CreditModel;

/**
 * Servlet implementation class DureeServlet
 */
public class DureeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DureeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("dureecredit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(request.getParameter("calculd") != null)	
	       {
		HttpSession session= request.getSession();

		double c=Double.parseDouble(request.getParameter("annuitedur"));
		double n =Double.parseDouble(request.getParameter("capitaldur"));
		double t= Double.parseDouble(request.getParameter("tauxdur"));
		
		//2 eme etape : on doit instancier le model et stocker les donnees saisies dans le model 
		
//on instance le constructeur par defaut PUIS on donne les valeurs saisie dans le formulaire  aux attributs de ce modele --> "credit" 
			
		session.setAttribute( "annuitedur", c );
		session.setAttribute( "capitaldur",n );
		session.setAttribute( "tauxdur",t );
		
	   CreditModel  creditModel =new CreditModel();
	   
	   creditModel.setMonCre(n);
		creditModel.setAnnCred(c);
		creditModel.setTauxCre(t);
				
				CreditMetiertestStub stub = new CreditMetiertestStub();
				CalculDuree cal =new CalculDuree();
				cal.setA(c);
				cal.setC(n);
				cal.setT(t/100);
				
				CalculDureeResponse res = stub.calculDuree(cal);
 				double duree =res.get_return();
				session.setAttribute( "dureedur",duree );
				creditModel.setDureeCre(duree);
				
			request.getRequestDispatcher("dureecredit.jsp").forward(request, response);
	
	}
	
	if(request.getParameter("saveduree") != null)
	  	  
    {
 	  HttpSession session = request.getSession();
     	CreditModel creditModel=new CreditModel();
     	
     	double c=Double.parseDouble(request.getParameter("annuitedur"));
		double n =Double.parseDouble(request.getParameter("capitaldur"));
		double t= Double.parseDouble(request.getParameter("tauxdur"));

					
					//2 eme etape : on doit instancier le model et stocker les donnees saisies dans le model 
					
			//on instance le constructeur par defaut PUIS on donne les valeurs saisie dans le formulaire  aux attributs de ce modele --> "credit" 
						
					
	
					session.setAttribute( "annuitedur", c );
					session.setAttribute( "capitaldur",n );
					session.setAttribute( "tauxdur",t );
					int idc;
	          
			               	idc = (int) session.getAttribute("id")	;			
						    
				            creditModel.setNumCli(idc);
				         	creditModel.setAnnCred(c);
							creditModel.setTauxCre(t);
							creditModel.setMonCre(n);
							
							
							creditModel.setDatPre( Calendar.getInstance().getTime()) ;
							
							 	   
							   
								
										
										CreditMetiertestStub stub = new CreditMetiertestStub();
										CalculDuree cal =new CalculDuree();
										cal.setA(c);
										cal.setC(n);
										cal.setT(t/100);
										
										CalculDureeResponse res = stub.calculDuree(cal);
						 				double duree =res.get_return();
										session.setAttribute( "dureedur",duree );
										creditModel.setDureeCre(duree);
							
							
							
							try {
								if(InsertCreditDoa.registerCredit(creditModel) !=0 )  {
									response.sendRedirect("FetchSerlvlet");
								}
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							};
							 
						
						//	response.sendRedirect("vueCredit.jsp");
							
							
					
   
							
		  }	
	
	
	

}
}