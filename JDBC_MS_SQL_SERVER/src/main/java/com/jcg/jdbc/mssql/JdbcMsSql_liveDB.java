package com.jcg.jdbc.mssql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcMsSql_liveDB {

	public static Connection connObj;
	
	public static String JDBC_URL = "jdbc:sqlserver://--Here url--;databaseName=--dbname--;user=--username--;password=--pwd--";
	
	

	public static void getDbConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connObj = DriverManager.getConnection(JDBC_URL);
			if(connObj != null) {
				DatabaseMetaData metaObj = (DatabaseMetaData) connObj.getMetaData();
				System.out.println("Driver Name?= " + metaObj.getDriverName() + ", Driver Version?= " + metaObj.getDriverVersion() + ", Product Name?= " + metaObj.getDatabaseProductName() + ", Product Version?= " + metaObj.getDatabaseProductVersion());
				
		} }catch(Exception sqlException) {
			sqlException.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException {
		getDbConnection();
		
		//Query to Execute		
		String query = "select *  from EmployeeDetails";	

 		//Create Statement Object		
	   Statement stmt = connObj.createStatement();					
  
			// Execute the SQL Query. Store results in ResultSet		
 		ResultSet rs= stmt.executeQuery(query);							
 
 		// While Loop to iterate through all data and print results		
		while (rs.next()){
	        		String Id = rs.getString(1);								        			                               
                    System. out.println(Id);	
                    
                    String Employee_name = rs.getString(2);								        			                               
                    System. out.println(Employee_name);	
                    
                    String Address = rs.getString(3);								        			                               
                    System. out.println(Address);	
                    
                    String Ph_no = rs.getString(4);								        			                               
                    System. out.println(Ph_no);	
                    
                    System.out.println("*********************************************************");
	
	}
		
		
            }	
	}
