package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.Io;
import model.Message;
import model.Salon;
import model.Utilisateur;

public class DaoMessageSql implements IDAO_Message {

	@Override
	public void creer(Message o, DB db) {
		try{
			String query = String.format("INSERT INTO chat.message (MES_USER_ID, MES_MESSAGE, MES_SALON_ID) VALUES (%d, '%s', %d);", o.getMES_UTI_ID(),o.getMES_MESSAGE(),o.getMES_SAL_ID());
			Io.print(query);
			boolean myResult = db.execute(query);	
			System.out.println("Ajout du message");
			System.out.println(myResult);
		}
		catch (SQLException e){
			System.out.println("echec de l'ajout");
		}
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
		try{
			String query = String.format("UPDATE message set %s = %s where `MES_ID` = %s;", caractere_changement,valeur,id);
			Io.print(query);
			boolean myResult = db.execute(query);	
			System.out.println("Modification du messsage");
			System.out.println(myResult);
			return myResult;
		}
		catch (SQLException e){
			System.out.println("echec de la modification");
			return false;
		}
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

	@Override
	public ArrayList<Message> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Message> getIfNew(DB db, Message old) throws SQLException{
		int oldId = old.getMES_ID();
		ResultSet usersSet = db.executeQuery("SELECT * FROM chat.message");
		return null;
		
	}
	@Override
	public ArrayList<Message> getAll(DB db) throws SQLException {
		ArrayList<Message> messages = new ArrayList<Message>();
		ResultSet messSet = db.executeQuery("SELECT * FROM chat.message as m ORDER BY m.MES_DATE ASC");
		while (messSet.next()){
			Message mess = new Message();
			mess.setMES_ID(messSet.getInt("MES_ID"));
			mess.setMES_UTI_ID(messSet.getInt("MES_USER_ID"));
			mess.setMES_MESSAGE(messSet.getString("MES_MESSAGE"));
			mess.setMES_DATE(messSet.getDate("MES_DATE"));
			mess.setMES_SAL_ID(messSet.getInt("MES_SALON_ID"));
			messages.add(mess);
		}
		return messages;
	}
	public ArrayList<Message> getParSalon(DB db, Salon salon) throws SQLException {
		ArrayList<Message> messages = new ArrayList<Message>();
		ResultSet messSet = db.executeQuery("SELECT * FROM chat.message as m ORDER BY m.MES_DATE ASC");
		while (messSet.next()){
			Message mess = new Message();
			mess.setMES_ID(messSet.getInt("MES_ID"));
			mess.setMES_UTI_ID(messSet.getInt("MES_USER_ID"));
			mess.setMES_MESSAGE(messSet.getString("MES_MESSAGE"));
			mess.setMES_DATE(messSet.getDate("MES_DATE"));
			mess.setMES_SAL_ID(messSet.getInt("MES_SALON_ID"));
			if (salon.getSAL_ID() == mess.getMES_SAL_ID()) {
				messages.add(mess);
			}
			
		}
		return messages;
	}
}