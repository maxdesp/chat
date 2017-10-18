package main;

import java.sql.ResultSet;
import java.sql.SQLException;

import gui.FenetrePrincipale;
import model.Salon;
import model.Utilisateur;
import dao.DB;
import dao.DaoMessageSql;
import dao.DaoSalonSql;
import dao.DaoUtilisateurSql;
//import dao.IDAO_Utilisateur;

public class Main {
	
	public static DB getDb() {
		return db;
	}

	public static void setDb(DB db) {
		Main.db = db;
	}
	

	static DB db;
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		db = new DB();
		db.getConnection();
		ResultSet test = db.executeQuery("SELECT * FROM chat.utilisateur");
		Io.print("first");
		ResultSet usersSet = db.executeQuery("SELECT * FROM chat.utilisateur");
		Io.print(usersSet);
		FenetrePrincipale fenetre = new FenetrePrincipale();
		DaoUtilisateurSql dao = new DaoUtilisateurSql();
		Io.print(dao.getByIdentifiants(db, "marie", "eiram"));
		Io.print("FINAL");
		
		// testCreerUtilisateurs();
		testgetAll();
		// testCreerSalonPrincipal();
	}
	
	public static void testgetAll() throws SQLException {

		DaoUtilisateurSql daoUser = new DaoUtilisateurSql();
		Io.print("test");
		Io.print(daoUser.getAll(db));
		Io.print("test");
		DaoMessageSql daoMess = new DaoMessageSql();
		Salon salon = new Salon();
		salon.setSAL_ID(1);
		Io.print(daoMess.getParSalon(db, salon));
	}
	
	public static void testCreerUtilisateurs() {
		Utilisateur max = new Utilisateur("max", "password");
		Utilisateur marie = new Utilisateur("marie", "password");
		Utilisateur francois = new Utilisateur("francois", "password");
		DaoUtilisateurSql dao = new DaoUtilisateurSql();
		dao.creer(max, db);
		dao.creer(marie, db);
		dao.creer(francois, db);

	}
	
	public static void testCreerSalonPrincipal() {
		
		DaoSalonSql daoSalon = new DaoSalonSql();
		Salon salonPrincipal = new Salon("principal", "", 1);
		// daoSalon.creer(salonPrincipal, db);
	
	}

}
