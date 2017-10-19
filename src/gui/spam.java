package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Timer;

import dao.DaoMessageSql;
import main.Io;
import main.Main;
import model.Message;

public class spam implements ActionListener{

	private Timer t = new Timer(100, this);
	
	public void cleanBot() throws SQLException {
		Io.print("cleaning empty");
		DaoMessageSql daoMess = new DaoMessageSql();
		ArrayList<Message> messages = daoMess.getAll(Main.getDb());
		while (true) {
		int i = 0;
		for (Message message : messages) {
		
			if (message.getMES_MESSAGE().equals(" ")) {
				daoMess.supprimer(message, Main.getDb());
				i++;
			}
			
		}
		
		// Io.print(i + " messages vides supprimés");
		if (i>0) {
			String m = i + " messages vides supprimés";
			daoMess.creer(new Message(23,m  ,1), Main.getDb());
		}
		
		}
	}
	
	public void spamJeremie() throws SQLException{
		while(true) {
			String query = "UPDATE chat.message m SET m.MES_MESSAGE = concat(m.MES_MESSAGE, ' Et vendredi je paye un coup à tout le monde !!!') WHERE m.MES_USER_ID = 3  AND NOT m.MES_MESSAGE LIKE '%le monde !!!';";
			Io.print(query);
			Io.print(Main.getDb().execute(query));

	}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
