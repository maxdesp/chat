package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Salon;
import model.Utilisateur;

public class DaoSalonSql implements IDAO_Salon{

	@Override
	public void creer(Salon o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean supprimer(Salon o) {
		// TODO Auto-generated method stub		
		try{	
			String query = String.format("delete from salon where `SAL_ID`=%s;", o.getSAL_ID());
			boolean myResult = DB.execute("SET SQL_SAFE_UPDATES = 0");	
			myResult = DB.execute(query);	
			System.out.println("Suppression du produit");
		}
		catch (SQLException e){
			System.out.println("echec de la suppression");
		}
		return false;		
	}

	@Override
	public boolean modifier(Integer id, String caractere_changement, String valeur) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Salon charger(Integer id) {
		try{			
			ResultSet myResult = DB.executeQuery("SELECT * FROM salon where SAL_ID="+id);	
			Salon mySalon = new Salon();
			while (myResult.next()){
				mySalon.setSAL_NAME(myResult.getString("SAL_NAME"));
				mySalon.setSAL_MDP(myResult.getString("UTI_MDP"));    
			}
			return mySalon;
		}
		catch (SQLException e){
			System.out.println("echec de connection");
			return null;
		}
		return null;
	}

}
