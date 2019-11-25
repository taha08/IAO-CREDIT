package com.iao.dao;

import java.sql.*;

import com.iao.model.Client; 

public class LoginDao 
{  
	
	// cette class permet de valider l'authentification d'utilisateur courant et de recuperer l'objet client s'il existe dans la base de données
	
	public static Client  validate(String name,String pass){  
	 
	
	Client client = null;
	try{  

		    Class.forName("com.mysql.cj.jdbc.Driver");  
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC","root","");  
			      
			PreparedStatement ps=con.prepareStatement(  
			"select * from tclient where MailCli=? and PassCli=?");  
			ps.setString(1,name);  
			ps.setString(2,pass);  
			
		      
			ResultSet rs=ps.executeQuery();  
			
			while (rs.next()) {
				client = new Client();
				client.setNumCli(rs.getInt(1));
				client.setMailCli(rs.getString(7));
				client.setNomCli(rs.getString(2));
				
				
					}  
	          
	}catch(Exception e){System.out.println(e);}  
	
	return client;  
	}  
	
}  
