package dao;

// import IO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import com.mysql.jdbc.Driver;

import main.Io;

public class DB {
	
	private Connection connection;
	private Statement statement;
	private String dbName;
	private String dbUser;
	
	public DB() throws SQLException, ClassNotFoundException{
		this.dbName = "chat";
		this.dbUser = "root";
		// this.dbUser ="chatuser";
		this.connection = getConnection("chat", "root");
		this.statement = getStatement();
	}
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}



	
	public static void main() {
		
	}
	
	public static Connection getConnection(String base, String user) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ base +"?useSSL=false", user, "");
		return con;
		
	}
	public static Statement getStatement() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection  eshopConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop?useSSL=false", "root", "");
			Statement eshopStatement = eshopConnection.createStatement();
			//ResultSet myResult = eshopStatement.executeQuery("SELECT PER_ID, PER_CP FROM personne");
			return eshopStatement;
		} catch (Exception ex) {}
		return null;
		
	}
	
	public static ResultSet executeQuery(Statement statement, String query) throws SQLException {
		Io.print(query);
		return statement.executeQuery(query);
		
	}
	public static boolean execute(Statement statement, String query) throws SQLException {
		Io.print(query);
		return statement.execute(query);
		
	}
	
	public static ResultSet getByAttribute(Statement statement, String table, String attribute, Integer id) throws SQLException {
		String query = "SELECT * FROM " + table +  " WHERE " + attribute + " = " + id;
		ResultSet results =  executeQuery(statement, query);
		if (results.next()){
			return results;
		}
		return null;
	}
	
	public static ResultSet getFromTable(Statement statement, String column, String table) throws SQLException {
		String query = "SELECT " + column + " FROM " + table;
		return executeQuery(statement, query);
 	}
	
	public static ResultSet getFromTable(Statement statement, String[] columns, String table) throws SQLException {
		String joined = String.join(", ", columns);
		String query = "SELECT " + joined + " FROM " + table;
		return executeQuery(statement, query);
 	}

	
	public static void setAttribute(Statement statement, String attribute, String table) {
		
	}

}
