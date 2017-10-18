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
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.DaoUtilisateurSql;
import main.Main;
import model.Utilisateur;

public class FenetreConnexionUtilisateur extends JFrame implements ActionListener, KeyListener, MouseListener {

	private FenetrePrincipale f;
	
	private BorderLayout layoutPrincipal = new BorderLayout();
	private GridLayout layoutCentral = new GridLayout(3,2);
	private Container pannelPrincipal = this.getContentPane();
	private JPanel pannelCentral = new JPanel();
	private JLabel labelConnexion = new JLabel("Connexion au profil");
	private JLabel labelPseudo = new JLabel("Pseudo");
	private JTextField textFieldPseudo = new JTextField("Ecrivez votre pseudo");
	private JLabel labelMDP = new JLabel("Mot de passe");
	private JTextField textFieldMDP = new JTextField("Ecrivez votre mot de passe");
	private JButton boutonConnexion = new JButton("Connexion");
	private JButton boutonAnnuler = new JButton("Annuler");
	
	public FenetreConnexionUtilisateur(FenetrePrincipale f){
		this.f = f;
		
		this.setTitle("Fenetre de connexion");
		this.setLocationRelativeTo(null);
		this.setSize(400,400);
		
		this.pannelPrincipal.setLayout(layoutPrincipal);
		this.pannelPrincipal.add(labelConnexion,BorderLayout.NORTH);
		
		this.pannelPrincipal.add(pannelCentral,BorderLayout.CENTER);
		this.pannelCentral.setLayout(layoutCentral);
		this.pannelCentral.add(labelPseudo);
		this.pannelCentral.add(textFieldPseudo);
		this.textFieldPseudo.addMouseListener(this);
		this.pannelCentral.add(labelMDP);
		this.pannelCentral.add(textFieldMDP);
		this.textFieldMDP.addMouseListener(this);
		this.pannelCentral.add(boutonConnexion);
		this.boutonConnexion.addActionListener(this);
		this.pannelCentral.add(boutonAnnuler);
		this.boutonAnnuler.addActionListener(this);
		
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==this.boutonConnexion){
			try {
				System.out.println("test1");
				System.out.println("Main.getDb():"+Main.getDb().getDbName());
				System.out.println("this.textFieldPseudo.getText():"+this.textFieldPseudo.getText());
				System.out.println("this.textFieldMDP.getText():"+this.textFieldMDP.getText());
				Utilisateur utilisateur =new DaoUtilisateurSql().getByIdentifiants(
						Main.getDb(),
						this.textFieldPseudo.getText(),
						this.textFieldMDP.getText()
						);
			
				f.setUtilisateur(utilisateur);
			} catch (SQLException e) {
				System.out.println("fin test1");
				// TODO Auto-generated catch block
				JOptionPane messageErreur = new JOptionPane();
				messageErreur.showMessageDialog(null, "Profil inexistant");
			}
			finally{
				this.dispose();
			}
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
		if(arg0.getSource()==this.textFieldPseudo){
			this.textFieldPseudo.setText("");
		}if(arg0.getSource()==this.textFieldMDP){
			this.textFieldMDP.setText("");
		}
	}

}
