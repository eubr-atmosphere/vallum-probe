package br.edu.ufam.icomp.vallum.probe.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory 
{
	public Connection getConnection() 
	{
		//String server = "localhost";
		String server = "vallum-audit-db";	
        String userBD = "root";
        String database = "vallum_audit";
        String passwd = "#s3nh@#";
        String port = "3306";        
        String url = null;
        
        url = "jdbc:mariadb://" + server + ":" + port + "/" + database;
        try 
        {
			return DriverManager.getConnection(url, userBD, passwd);
		} 
        catch (SQLException e) 
        {	
        	System.out.println(e.toString());
        	return null;
		}
    }
}