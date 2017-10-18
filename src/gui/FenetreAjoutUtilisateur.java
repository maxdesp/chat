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

import model.Salon;
import model.Utilisateur;

public class FenetreAjoutUtilisateur  extends JFrame implements ActionListener, KeyListener, MouseListener {
	
	private FenetrePrincipale f;
	
	private BorderLayout layoutPrincipal = new BorderLayout();
	private GridLayout layoutCentral = new GridLayout(4,2);
	private Container pannelPrincipal = this.getContentPane();
	private JPanel pannelCentral = new JPanel();
	private JLabel labelCreation = new JLabel("Création du profil");
	private JLabel labelPseudo = new JLabel("Pseudo");
	private JTextField textFieldPseudo = new JTextField("Ecrivez votre pseudo");
	private JLabel labelMDP = new JLabel("Mot de passe");
	private JTextField textFieldMDP = new JTextField("Ecrivez votre mot de passe");
	private JLabel labelAvatar = new JLabel("Avatar");
	private JTextField textFieldAvatar = new JTextField("URL de votre avatar");
	private JButton boutonCreation = new JButton("Création");
	private JButton boutonAnnuler = new JButton("Annuler");
	
	public FenetreAjoutUtilisateur(FenetrePrincipale f){
		this.f = f;
		
		this.setTitle("Fenetre de création");
		this.setLocationRelativeTo(null);
		this.setSize(400,400);
		
		this.pannelPrincipal.setLayout(layoutPrincipal);
		this.pannelPrincipal.add(labelCreation,BorderLayout.NORTH);
		
		this.pannelPrincipal.add(pannelCentral,BorderLayout.CENTER);
		this.pannelCentral.setLayout(layoutCentral);
		this.pannelCentral.add(labelPseudo);
		this.textFieldPseudo.addMouseListener(this);
		this.pannelCentral.add(textFieldPseudo);
		this.pannelCentral.add(labelMDP);
		this.pannelCentral.add(textFieldMDP);
		this.textFieldMDP.addMouseListener(this);
		this.pannelCentral.add(labelAvatar);
		this.pannelCentral.add(textFieldAvatar);
		this.textFieldAvatar.addMouseListener(this);
		this.pannelCentral.add(boutonCreation);
		this.pannelCentral.add(boutonAnnuler);
		this.boutonAnnuler.addActionListener(this);
		
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
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
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.textFieldPseudo){
			this.textFieldPseudo.setText("");
		}
		if(e.getSource()==this.textFieldMDP){
			this.textFieldMDP.setText("");
		}
		if(e.getSource()==this.textFieldAvatar){
			this.textFieldAvatar.setText("");
		}
	}

}
