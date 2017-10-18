package dao;

// import IO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
//import com.mysql.jdbc.Driver;

import main.Io;

public class DB {
	
	public String getDbIP() {
		return dbIP;
	}




	public void setDbIP(String dbIP) {
		this.dbIP = dbIP;
	}




	public String getDbPass() {
		return dbPass;
	}




	public void setDbPass(String dbPass) {
		this.dbPass = dbPass;
	}
	private Connection connection;
	private static Statement statement;
	private String dbName;
	private String dbUser;
	private String dbIP;
	private String dbPass;
	private boolean local;
	
	public DB() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		this.setDbName("chat");
		
		this.local = true; // CHANGER POUR SE CONNECTER EN LOCAL OU EN DISTANT
		// distant
		this.setDbUser("chatuser");
		this.setDbPass("password");
		this.setDbIP("192.168.1.78");
		
		if (this.local) {
			this.setDbUser("root");
			this.setDbPass("");
			this.setDbIP("localhost");
		}
		// local


		this.connection = makeConnection(this.getDbName(),  this.dbUser, this.getDbIP(), this.dbPass);
		DB.statement = this.connection.createStatement();
	}
	



	// useless if main exists ?
	public static void main() throws SQLException{
	}
	
	public Connection makeConnection(String base, String user, String dbIP, String dbPass) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		
		Io.print("jdbc:mysql://"+ dbIP + ":3306/"+base);
		Connection con = DriverManager.getConnection("jdbc:mysql://"+ dbIP + ":3306/"+ base +"?useSSL=false", user, dbPass);
		
		return con;
		
	}
	

	
	public ResultSet executeQuery(String query) throws SQLException {
		Io.print(query);
		return statement.executeQuery(query);
		
	}
	public boolean execute(String query) throws SQLException {
		Io.print(query);
		return statement.execute(query);
		
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
		Io.print(query);
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
