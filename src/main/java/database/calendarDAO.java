package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;


public class calendarDAO extends BaseDAO{
	public String loginUser(String email)
	{
		String query = "SELECT * FROM users WHERE email = ? AND wachtwoord = ?";

		 try (Connection con = super.getConnection()) {

		 PreparedStatement pstmt = con.prepareStatement(query);
		 pstmt.setString(1, email);
		 
		 
		 ResultSet resultset= pstmt.executeQuery();
		 
		 if (resultset.next() ) {
			 
			 return "SUCCESS"+resultset.getString(2);
		 }else{
			 
		 return "NOUSER"; 
		 
		 }}
		 
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		 
		 return "Failure";  // On failure, send a message from here.
		 }
	}

