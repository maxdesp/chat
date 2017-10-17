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
		Class.forName("com.mysql.jdbc.Driver");
		this.setDbName("chat");
		this.setDbUser("root");
		// this.dbUser ="chatuser";
		this.connection = makeConnection(this.getDbName(), this.getDbUser());
		this.statement = this.connection.createStatement();
	}
	


	// useless if main exists ?
	public static void main() {
	}
	
	public Connection makeConnection(String base, String user) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ base +"?useSSL=false", user, "");
		return con;
		
	}
	
	
	/** useless ?

	
	public Statement makeStatement() {
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			
			//Connection  eshopConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop?useSSL=false", "root", "");
			// Statement eshopStatement = eshopConnection.createStatement()
			//ResultSet myResult = eshopStatement.executeQuery("SELECT PER_ID, PER_CP FROM personne");
			return this.connection.createStatement();
		} catch (Exception ex) {}
		return null;
		
	}
	 */
	
	public ResultSet executeQuery(String query) throws SQLException {
		Io.print(query);
		return this.statement.executeQuery(query);
		
	}
	public boolean execute(String query) throws SQLException {
		Io.print(query);
		return this.statement.execute(query);
		
	}
	
	/**
	 * 
	 * @param table			table to select from
	 * @param attribute		attribute, i.e. "UTI_ID"
	 * @param id			must be a valid id in 'database.table'
	 */
	public ResultSet getById(String table, String attribute, Integer id) throws SQLException {
		String query = "SELECT * FROM " + table +  " WHERE " + attribute + " = " + id;
		ResultSet results =  this.executeQuery(query);
		if (results.next()){
			return results;
		}
		return null;
	}
	
	/**
	 *  get single column as String from table
	 */
	public ResultSet getFromTable(String column, String table) throws SQLException {
		String query = "SELECT " + column + " FROM " + table;
		return this.executeQuery(query);
 	}
	
	/**
	 *  get multiple columns as String[] from table 
	 */
	public ResultSet getFromTable(String[] columns, String table) throws SQLException {
		String joined = String.join(", ", columns);
		String query = "SELECT " + joined + " FROM " + table;
		return this.executeQuery(query);
 	}

	
	// accessors
	public String getDbUser() {
		return dbUser;
	}
	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
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


}
