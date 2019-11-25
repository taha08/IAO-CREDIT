package com.iao.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iao.model.Client;

public class RegisterDao {
	
	// cette class permet d'ajouter le client courant dans la base de données table tclient
	
	public static int registerClient(Client client) throws ClassNotFoundException {
       
		String INSERT_USERS_SQL = "INSERT INTO tclient" +
            "  ( NomCli, AdrCli, VilCli, TelCli, PassCli , MailCli) VALUES " +
            " ( ?, ?, ?, ?,?,?);"; 
		
		
        int result = 0;

       try 
       {
        
        Class.forName("com.mysql.cj.jdbc.Driver");  
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC","root",""); 


            // Step 2:Create a statement using connection object
	    
				PreparedStatement ps=con.prepareStatement( INSERT_USERS_SQL 
				);  
           
				
				
				ps.setString(6,client.getMailCli());
				ps.setString(1,client.getNomCli());
				ps.setString(2,client.getAdrCli());
				ps.setString(3,client.getVilCli());
				ps.setString(4,client.getTelCli());
				ps.setString(5,client.getPassCli());
				
				
				
				
             result = ps.executeUpdate(); 

        } 
          catch(Exception e){System.out.println(e);} 
       
       return result;
    }
	
	
	
	
	

}
