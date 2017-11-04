package main;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import gui.FenetrePrincipale;
import gui.spam;
import model.Message;
import model.Salon;
import model.Utilisateur;
import dao.DB;
import dao.DaoMessageSql;
import dao.DaoSalonSql;
import dao.DaoUtilisateurSql;
//import dao.IDAO_Utilisateur;

public class Main {
	
	static DB db;
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
	
		FenetrePrincipale fenetre = new FenetrePrincipale();
		DB db=fenetre.getDb();
		// bot();
	}
	
	/**
	 * not fully implemented bot 
	 * @throws SQLException
	 */
	public static void bot() throws SQLException {
		spam spam = new spam();
		spam.cleanBot();
		spam.spamJeremie();
	}

	public static DB getDb() {
		return db;
	}
	public static void setDb(DB db) {
		Main.db = db;
	}

}
