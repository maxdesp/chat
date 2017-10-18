package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import eshop.Produit;
import model.Utilisateur;

public class DaoUtilisateurSql implements IDAO_Utilisateur{

//	
//	/*public ArrayList<Produit> getAll(){
//		try{
//			Statement myStatement = this.connection.createStatement();
//			ResultSet myResult = myStatement.executeQuery("SELECT * FROM produit");	
//			ArrayList<Produit> produits = new ArrayList<Produit>();
//			while (myResult.next()){
//				Produit myProduit = new Produit();
//				myProduit.setId(myResult.getInt("PRO_ID"));
//				myProduit.setDesignation(myResult.getString("PRO_DESIGNATION"));
//				myProduit.setPrixVente(myResult.getDouble("PRO_PRIX_DE_VENTE"));
//		
//				produits.add(myProduit);
//			}
//			return produits;
//		}
//		catch (SQLException e){
//			System.out.println("echec de connection");
//			return null;
//		}
//	}
//	*/
	
	public ArrayList<Utilisateur> getAll(){
		ArrayList<Utilisateur> users = new ArrayList<Utilisateur>();
		return users;
	}
	
	@Override
	public void creer(Utilisateur o,DB db) {
		try{
			String query = String.format("INSERT INTO utilisateur VALUES (NULL,'%s','%s','%s',%s);", o.getUTI_PSEUDO(),o.getUTI_MDP(),o.getUTI_AVATAR(),o.getUTI_ID());
			boolean myResult = db.execute(query);	
			System.out.println("Ajout de l'utilisateur");
			System.out.println(myResult);
		}
		catch (SQLException e){
			System.out.println("echec de l'ajout");
		}
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
		try{
			String query = String.format("UPDATE utilisateur set %s = %s where `UTI_ID` = %s;", caractere_changement,valeur,id);
			boolean myResult = db.execute(query);	
			System.out.println("Modification de l utilisateur");
			System.out.println(myResult);
			return myResult;
		}
		catch (SQLException e){
			System.out.println("echec de la modification");
			return false;
		}
	}
	
	public boolean modifier(String pseudo, String caractere_changement, String valeur,DB db) {
		try{
			String query = String.format("UPDATE utilisateur set %s = %s where `UTI_PSEUDO` = '%s';", caractere_changement,valeur,pseudo);
			boolean myResult = db.execute(query);	
			System.out.println("Modification de l utilisateur");
			System.out.println(myResult);
			return myResult;
		}
		catch (SQLException e){
			System.out.println("echec de la modification");
			return false;
		}
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
