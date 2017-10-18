package main;

import java.sql.ResultSet;
import java.sql.SQLException;

import gui.FenetrePrincipale;
import model.Salon;
import model.Utilisateur;
import dao.DB;
import dao.DaoSalonSql;
import dao.DaoUtilisateurSql;
//import dao.IDAO_Utilisateur;

public class Main {
	
	static DB db;
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		db = new DB();
		db.getConnection();
		ResultSet test = db.executeQuery("SELECT * FROM chat.utilisateur");
		Io.print(test);
		FenetrePrincipale fenetre = new FenetrePrincipale();

		
		// creer utilisateurs
		creerUtilisateurs();
		// creer salon principal
		creerSalonPrincipal();
	}
	
	public static void creerUtilisateurs() {
		Utilisateur max = new Utilisateur("max", "password");
		Utilisateur marie = new Utilisateur("marie", "password");
		Utilisateur francois = new Utilisateur("francois", "password");
		DaoUtilisateurSql dao = new DaoUtilisateurSql();
		dao.creer(max, db);
		dao.creer(marie, db);
		dao.creer(francois, db);
	}
	
	public static void creerSalonPrincipal() {
		
		DaoSalonSql daoSalon = new DaoSalonSql();
		Salon salonPrincipal = new Salon("principal", "", 1);
		daoSalon.creer(salonPrincipal, db);
		// max.creerSalon("principal", "", 1);
	
	}

}
