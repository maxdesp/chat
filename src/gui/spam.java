package gui;

import java.util.ArrayList;

import dao.DaoMessageSql;
import main.Io;
import main.Main;
import model.Message;

public class spam {

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
