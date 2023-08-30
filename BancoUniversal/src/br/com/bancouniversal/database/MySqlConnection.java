package br.com.bancouniversal.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	 
		private static final String URL = "jdbc:mysql://localhost:3306/banco";
	    private static final String USER = "root";
	    private static final String PASSWORD = "duda#123A";
	    
	    public static Connection getConnection() {
	    	Connection connection = null;
	    	try {
	    		Class.forName("com.mysql.cj.jdbc.Driver");
	    		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", 
	    				"root", "duda#123A");
	    		System.out.println("Conexão bem sucedida!");
	    	} catch (SQLException e) {
				System.out.println("E");
				e.getStackTrace();
			} catch(ClassNotFoundException e) {
				System.out.println("Driver não encontrado");
			}
	    	return connection;
	    }
	    
	    public static void closeConnection(Connection connection) {
	        if (connection != null) {
	            try {
	                connection.close();
	                System.out.println("Conexão fechada.");
	            } catch (SQLException e) {
	                System.out.println("Erro ao fechar a conexão!");
	                e.printStackTrace();
	            }
	        }
	    }
}
