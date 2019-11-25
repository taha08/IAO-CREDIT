package com.iao.servcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.iao.CreditMetiertestStub;
import com.iao.CreditMetiertestStub.CalculMensualite;
import com.iao.CreditMetiertestStub.CalculMensualiteResponse;
import com.iao.dao.InsertCreditDoa;
import com.iao.model.CreditModel;


/**
 * Servlet implementation class AnnuiteServlet
 */
public class AnnuiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnuiteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	// cette servlet permet de calculer l'annuiter ansi que sauvgarder le credit si le client decide d'enregistrer le credit 
		
	
      if(request.getParameter("calculm") != null)
			
       {
    	  HttpSession session = request.getSession();
        	CreditModel creditModel=new CreditModel();
        	
					double c=Double.parseDouble(request.getParameter("montant"));
					int n = Integer.parseInt(request.getParameter("duree"));
					double t= Double.parseDouble(request.getParameter("taux"));
					
				
					
			//on instance le constructeur par defaut PUIS on donne les valeurs saisie dans le formulaire  aux attributs de ce modele --> "credit" 
						
					session.setAttribute( "montant", c );
					session.setAttribute( "duree",n );
					session.setAttribute( "taux",t );
				
			              			
					
					// on doit instancier le model et stocker les donnees saisies dans le model 
				      
					
				         	creditModel.setMonCre(c);
							creditModel.setDureeCre(n);
							creditModel.setTauxCre(t);
							
							
				//consommation des web service 	
							 						
							CreditMetiertestStub stub = new CreditMetiertestStub();
							CalculMensualite cal =new CalculMensualite();
							cal.setC(c);
							cal.setN(n);
							cal.setT(t/100);
							
							CalculMensualiteResponse res = stub.calculMensualite(cal);
	         				double mensualiteM =res.get_return();
							session.setAttribute( "mensualite",mensualiteM );
							creditModel.setAnnCred(mensualiteM);
							response.sendRedirect("index.jsp");
							 

							
		  }
      if(request.getParameter("saveannuite") != null)
    	  
      {
   	  HttpSession session = request.getSession();
       	CreditModel creditModel=new CreditModel();
       	
					double c=Double.parseDouble(request.getParameter("montant"));
					int n = Integer.parseInt(request.getParameter("duree"));
					double t= Double.parseDouble(request.getParameter("taux"));
					
					//2 eme etape : on doit instancier le model et stocker les donnees saisies dans le model 
					
			//on instance le constructeur par defaut PUIS on donne les valeurs saisie dans le formulaire  aux attributs de ce modele --> "credit" 
						
					session.setAttribute( "montant", c );
					session.setAttribute( "duree",n );
					session.setAttribute( "taux",t );
				
			              		int idc;
	          
			               	idc = (int) session.getAttribute("id")	;			
						    
				            creditModel.setNumCli(idc);
				         	creditModel.setMonCre(c);
							creditModel.setDureeCre(n);
							creditModel.setTauxCre(t);
							
							
							
  							 
							creditModel.setDatPre( new java.util.Date()) ;
							
  							 
  							 
							CreditMetiertestStub stub = new CreditMetiertestStub();
							CalculMensualite cal =new CalculMensualite();
							cal.setC(c);
							cal.setN(n);
							cal.setT(t/100);
							
							CalculMensualiteResponse res = stub.calculMensualite(cal);
	         				double mensualiteM =res.get_return();
							session.setAttribute( "mensualite",mensualiteM );
							creditModel.setAnnCred(mensualiteM);
							
							
							
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
