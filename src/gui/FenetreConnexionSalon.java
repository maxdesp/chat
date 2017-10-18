package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FenetreConnexionSalon extends JFrame implements ActionListener, KeyListener, MouseListener {

	private FenetrePrincipale f;
	
	private BorderLayout layoutPrincipal = new BorderLayout();
	private GridLayout layoutCentral = new GridLayout(3,2);
	private Container pannelPrincipal = this.getContentPane();
	private JPanel pannelCentral = new JPanel();
	private JLabel labelConnexion = new JLabel("Connexion au salon");
	private JLabel labelName = new JLabel("Nom du salon");
	private JTextField textFieldName = new JTextField("Ecrivez le nom du salon");
	private JLabel labelMDP = new JLabel("Mot de passe");
	private JTextField textFieldMDP = new JTextField("Ecrivez votre mot de passe");
	private JButton boutonConnexion = new JButton("Connexion");
	private JButton boutonAnnuler = new JButton("Annuler");
	
	public FenetreConnexionSalon(FenetrePrincipale f){
		this.f = f;
		
		this.setTitle("Fenetre de connexion");
		this.setLocationRelativeTo(null);
		this.setSize(400,400);
		
		this.pannelPrincipal.setLayout(layoutPrincipal);
		this.pannelPrincipal.add(labelConnexion,BorderLayout.NORTH);
		
		this.pannelPrincipal.add(pannelCentral,BorderLayout.CENTER);
		this.pannelCentral.setLayout(layoutCentral);
		this.pannelCentral.add(labelName);
		this.pannelCentral.add(textFieldName);
		this.textFieldName.addMouseListener(this);
		this.pannelCentral.add(labelMDP);
		this.pannelCentral.add(textFieldMDP);
		this.textFieldMDP.addMouseListener(this);
		this.pannelCentral.add(boutonConnexion);
		this.pannelCentral.add(boutonAnnuler);
		this.boutonAnnuler.addActionListener(this);
		
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==this.boutonConnexion){
			super.dispose();
		}
		if(arg0.getSource()==this.boutonAnnuler){
			super.dispose();
		}
	}





	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==this.textFieldName){
			this.textFieldName.setText("");
		}if(arg0.getSource()==this.textFieldMDP){
			this.textFieldMDP.setText("");
		}
	}

}
