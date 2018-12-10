package com.jcg.jdbc.mssql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcMsSql {

	public static Connection connObj;
	public static String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=bala_db;integratedSecurity=true";
	//public static String JDBC_URL = "jdbc:sqlserver://localhost;integratedSecurity=true";

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
		String query = "select *  from persons2";	

 		//Create Statement Object		
	   Statement stmt = connObj.createStatement();					
  
			// Execute the SQL Query. Store results in ResultSet		
 		ResultSet rs= stmt.executeQuery(query);							
 
 		// While Loop to iterate through all data and print results		
		while (rs.next()){
	        		String myName = rs.getString(1);								        			                               
                    System. out.println(myName);	
	
	}
		
		
            }	
	}
