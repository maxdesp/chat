package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Salon;
import model.Utilisateur;

public class DaoSalonSql implements IDAO_Salon{

	@Override
	public void creer(Salon o,DB db) {
		try{
			String query = String.format("INSERT INTO salon VALUES (NULL,'%s','%s',%s);", o.getSAL_NAME(),o.getSAL_MDP(),o.getSAL_CREATEUR_ID());
			boolean myResult = db.execute(query);	
			System.out.println("Ajout du salon");
			System.out.println(myResult);
		}
		catch (SQLException e){
			System.out.println("echec de l'ajout");
			
		}
	}

	@Override
	public boolean supprimer(Salon o,DB db) {
		// TODO Auto-generated method stub		
		try{	
			String query = String.format("delete from salon where `SAL_ID`=%s;", o.getSAL_ID());
			boolean myResult = db.execute("SET SQL_SAFE_UPDATES = 0");	
			myResult = db.execute(query);	
			System.out.println("Suppression du produit");
		}
		catch (SQLException e){
			System.out.println("echec de la suppression");
		}
		return false;		
	}

	@Override
	public boolean modifier(Integer id, String caractere_changement, String valeur, DB db) {
		try{
			String query = String.format("UPDATE salon set %s = %s where `SAL_ID` = %s;", caractere_changement,valeur,id);
			boolean myResult = db.execute(query);	
			System.out.println("Modification du salon");
			System.out.println(myResult);
			return myResult;
		}
		catch (SQLException e){
			System.out.println("echec de la modification");
			return false;
		}
	}
		

	@Override
	public Salon charger(Integer id,DB db) {
		try{			
			ResultSet myResult = db.executeQuery("SELECT * FROM salon where SAL_ID="+id);	
			Salon mySalon = new Salon();
			while (myResult.next()){
				mySalon.setSAL_NAME(myResult.getString("SAL_NAME"));
				mySalon.setSAL_MDP(myResult.getString("UTI_MDP"));    
				mySalon.setSAL_ID(myResult.getInt("SAL_ID"));
			}
			return mySalon;
		}
		catch (SQLException e){
			System.out.println("echec de connection");
			return null;
		}
	}

	@Override
	public ArrayList<Salon> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Salon> getAll(DB db) throws SQLException {
			ArrayList<Salon> salons = new ArrayList<Salon>();
			ResultSet usersSet = db.executeQuery("SELECT * FROM chat.utilisateur");
			while (usersSet.next()){
				Salon salon = new Salon();
				salon.setSAL_ID(usersSet.getInt("setSAL_ID"));
				salon.setSAL_NAME(usersSet.getString("setSAL_NAME"));
				salon.setSAL_MDP(usersSet.getString("setSAL_MDP"));
				salon.setSAL_CREATEUR_ID(usersSet.getInt("setSAL_CREATEUR_ID"));
				salons.add(salon);
			}
			return salons;
	}
}
