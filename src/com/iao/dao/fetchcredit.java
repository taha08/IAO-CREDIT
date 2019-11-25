package com.iao.dao;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iao.model.Client;
import com.iao.model.CreditModel;

public class fetchcredit {
	
	// cette class permet de retourner la list des credits effectue par le client du session 

	
	public static List<CreditModel> fetch(int id){  
		 
		CreditModel credit =null;
	//	CreditModel cc[] = new CreditModel[20];
		
		List<CreditModel> l=new ArrayList<CreditModel>();
		
		try{  

			    Class.forName("com.mysql.cj.jdbc.Driver");  
			    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC","root","");  
				      
				PreparedStatement ps=con.prepareStatement(  
				"select * from tcredit where NumCli=?");  
				
				ps.setInt(1,id);  
				
			      
				ResultSet rs=ps.executeQuery();  
			int i=1;
					
				while (rs.next()) {
				
					credit = new CreditModel();
					credit.setNumCred(rs.getInt(1));
					credit.setNumCli(rs.getInt(7));
					credit.setDureeCre(rs.getDouble(4));
					credit.setAnnCred(rs.getDouble(6));
					credit.setMonCre(rs.getDouble(3));
					credit.setDatPre(rs.getDate(2));
					credit.setTauxCre(rs.getDouble(5));
					
					l.add(credit);
					
					i++;			
					
						}  
		          
		}catch(Exception e){System.out.println(e);}  
		
		return l;  
		}  
//	public static void main(String args[])
//	{
//		fetchcredit test = new fetchcredit();
//		List<CreditModel> l = test.fetch(1);
//		for(CreditModel c: l)
//		System.out.println("credit : >"+c);
//	}
	

}
