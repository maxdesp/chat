package main;

import java.sql.SQLException;

import gui.FenetrePrincipale;
import model.Utilisateur;
import dao.DB;

public class Main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		DB db = new DB();
		db.getConnection();
		
		FenetrePrincipale fenetre = new FenetrePrincipale();
		// test
		Utilisateur user = new Utilisateur();
		
	}

}
