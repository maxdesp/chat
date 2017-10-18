package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FenetreConnexionUtilisateur extends JFrame implements ActionListener {

	private JLabel labelConnexion = new JLabel("Connexion au profil");
	private JLabel labelPseudo = new JLabel("Pseudo");
	private JTextField textFieldPseudo = new JTextField("Ecrivez votre pseudo");
	private JLabel labelMDP = new JLabel("Mot de passe");
	private JTextField textFieldMDP = new JTextField("Ecrivez votre mot de passe");
	private JLabel labelAvatar = new JLabel("Avatar");
	private JTextField textFieldAvatar = new JTextField("URL de votre avatar");
	private JButton boutonConnexion = new JButton("Connexion");
	private JButton boutonAnnuler = new JButton("Annuler");
	
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
