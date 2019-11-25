package com.iao.servcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iao.model.CreditModel;

import com.iao.CreditMetiertestStub;
import com.iao.CreditMetiertestStub.CalculCapital;
import com.iao.CreditMetiertestStub.CalculCapitalResponse;
import com.iao.dao.InsertCreditDoa;

/**
 * Servlet implementation class CapitalServlet
 */
@WebServlet("/Capital")
public class CapitalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CapitalServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("capitalcredit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("calculc") != null) {

			HttpSession session = request.getSession();

			double c = Double.parseDouble(request.getParameter("annuitecap"));
			int n = Integer.parseInt(request.getParameter("dureecap"));
			double t = Double.parseDouble(request.getParameter("tauxcap"));

			// 2 eme etape : on doit instancier le model et stocker les donnees saisies dans
			// le model

//on instance le constructeur par defaut PUIS on donne les valeurs saisie dans le formulaire  aux attributs de ce modele --> "credit" 

			session.setAttribute("annuite", c);
			session.setAttribute("dureecap", n);
			session.setAttribute("tauxcap", t);

			CreditModel creditModel = new CreditModel();

			creditModel.setAnnCred(c);
			creditModel.setDureeCre(n);
			creditModel.setTauxCre(t);

			CreditMetiertestStub stub = new CreditMetiertestStub();
			CalculCapital cal = new CalculCapital();
			cal.setA(c);
			cal.setN(n);
			cal.setT(t / 100);

			CalculCapitalResponse res = stub.calculCapital(cal);
			double capital = res.get_return();
			session.setAttribute("capital", capital);
			creditModel.setMonCre(capital);

			request.getRequestDispatcher("capitalcredit.jsp").forward(request, response);
		}

		if (request.getParameter("savecapital") != null)

		{
			HttpSession session = request.getSession();
			CreditModel creditModel = new CreditModel();

			double c = Double.parseDouble(request.getParameter("annuitecap"));
			int n = Integer.parseInt(request.getParameter("dureecap"));
			double t = Double.parseDouble(request.getParameter("tauxcap"));

			// 2 eme etape : on doit instancier le model et stocker les donnees saisies dans
			// le model

			// on instance le constructeur par defaut PUIS on donne les valeurs saisie dans
			// le formulaire aux attributs de ce modele --> "credit"

			session.setAttribute("annuite", c);
			session.setAttribute("dureecap", n);
			session.setAttribute("tauxcap", t);

			int idc;

			idc = (int) session.getAttribute("id");

			creditModel.setNumCli(idc);
			creditModel.setAnnCred(c);
			creditModel.setDureeCre(n);
			creditModel.setTauxCre(t);

			creditModel.setDatPre(new java.util.Date());

			CreditMetiertestStub stub = new CreditMetiertestStub();
			CalculCapital cal = new CalculCapital();
			cal.setA(c);
			cal.setN(n);
			cal.setT(t / 100);

			CalculCapitalResponse res = stub.calculCapital(cal);
			double capital = res.get_return();
			session.setAttribute("capital", capital);
			creditModel.setMonCre(capital);

			try {
				if (InsertCreditDoa.registerCredit(creditModel) != 0) {
					response.sendRedirect("FetchSerlvlet");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			;

			// response.sendRedirect("vueCredit.jsp");

		}

	}

}
