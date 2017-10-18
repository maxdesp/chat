package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingConstants;

public class FenetreConnexionUtilisateur extends JFrame implements ActionListener {

	//private JLabel 
	
	public FenetreConnexionUtilisateur(){
		this.setTitle("Fenetre de connexion");
		this.setLocationRelativeTo(null);
		this.setSize(300,400);
		
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
