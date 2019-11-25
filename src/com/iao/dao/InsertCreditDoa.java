package com.iao.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;

import com.iao.model.Client;
import com.iao.model.CreditModel;
import com.sun.org.apache.xerces.internal.impl.dv.xs.DateTimeDV;

public class InsertCreditDoa {
	
	// cette class permet d'ajouter le credit effectue par le client de lasession dans la base de données table tcredit
	
	
	public static int registerCredit(CreditModel credit) throws ClassNotFoundException {
	       
		String INSERT_USERS_SQL = "INSERT INTO tcredit" +
            "  (MonCre, DurCre, TauCre, AnnCred, NumCli, DatCred) VALUES " +
            " ( ?, ?, ?, ?, ?, ?);  "; 
			
        int result = 0;

       try 
       {
        
        Class.forName("com.mysql.cj.jdbc.Driver");  
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC","root",""); 


            // Step 2:Create a statement using connection object
	    
				PreparedStatement ps=con.prepareStatement( INSERT_USERS_SQL 
				);  
            
				
				
				ps.setInt(5,credit.getNumCli());
				ps.setDouble(1,credit.getMonCre());
				ps.setDouble(2,credit.getDureeCre());
				ps.setDouble(3,credit.getTauxCre());
				ps.setDouble(4,credit.getAnnCred());
				ps.setDate(6,new java.sql.Date(credit.getDatPre().getTime()));
				
				
		
             result = ps.executeUpdate(); 

        } 
          catch(Exception e){System.out.println(e);} 
       
       return result;
    }
	
	
	
	
	

}
