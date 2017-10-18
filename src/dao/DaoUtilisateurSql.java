package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Utilisateur;

public class DaoUtilisateurSql implements IDAO_Utilisateur{

	@Override
	public void creer(Utilisateur o,DB db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean supprimer(Utilisateur o,DB db) {
		// TODO Auto-generated method stub		
		try{	
			String query = String.format("delete from utilisateur where `UTI_ID`=%s;", o.getUTI_ID());
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
	public boolean modifier(Integer id, String caractere_changement, String valeur,DB db) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Utilisateur charger(Integer id,DB db) {
		try{			
			ResultSet myResult = db.executeQuery("SELECT * FROM utilisateur where UTI_ID="+id);	
			Utilisateur myUtilisateur = new Utilisateur();
			while (myResult.next()){
				myUtilisateur.setUTI_PSEUDO(myResult.getString("UTI_PSEUDO"));
				myUtilisateur.setUTI_CONNECTED(myResult.getBoolean("UTI_CONNECTED"));    
				myUtilisateur.setUTI_AVATAR(myResult.getString("UTI_AVATAR"));
			}
			return myUtilisateur;
		}
		catch (SQLException e){
			System.out.println("echec de connection");
			return null;
		}
	}

}
