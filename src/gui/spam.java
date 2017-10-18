package gui;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DaoMessageSql;
import main.Io;
import main.Main;
import model.Message;

public class spam {

	
	public void cleanBot() throws SQLException {
		Io.print("cleaning empty");
		DaoMessageSql daoMess = new DaoMessageSql();
		ArrayList<Message> messages = daoMess.getAll(Main.getDb());
		int i = 0;
		for (Message message : messages) {
		
			if (message.getMES_MESSAGE().equals(" ")) {
				daoMess.supprimer(message, Main.getDb());
				i++;
			}
			
		}
		String m = i + " messages vides supprimés";
		Io.print(i + " messages vides supprimés");
		daoMess.creer(new Message(23,m  ,1), Main.getDb());
	}
	
	public void spamJeremie(){
		Io.print("spamming jeremie");
		DaoMessageSql daoMess = new DaoMessageSql();
		ArrayList<Message> messages = daoMess.getAll();
		String v = "MES_MESSAGE";
		String nouveau;
		for (Message message : messages) {
			Io.print(message);
			if (message.getMES_UTI_ID()==3) {
				Io.print(message);
				nouveau = message.getMES_MESSAGE() + ". Et fait, je paye un coup à tout le monde Vendredi !";
				daoMess.modifier(message.getMES_ID(),v, nouveau, Main.getDb());
			}
		}
		
	}
}
