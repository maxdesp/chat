package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Message;
import model.Salon;

public class DaoMessageSql implements IDAO_Message {

	@Override
	public void creer(Message o, DB db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean supprimer(Message o,DB db) {
		// TODO Auto-generated method stub		
		try{	
			String query = String.format("delete from message where `MES_ID`=%s;", o.getMES_ID());
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
	public Message charger(Integer id,DB db) {
		try{			
			ResultSet myResult = db.executeQuery("SELECT * FROM message where MES_ID="+id);	
			Message myMessage = new Message();
			while (myResult.next()){
				myMessage.setMES_UTI_ID(myResult.getInt("MES_USER_ID"));
				myMessage.setMES_MESSAGE(myResult.getString("MES_MESSAGE"));    
				myMessage.setMES_DATE(myResult.getDate("MES_DATE"));
			}
			return myMessage;
		}
		catch (SQLException e){
			System.out.println("echec de connection");
			return null;
		}
	}
}