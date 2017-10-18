package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.DaoSalonSql;
import dao.DaoUtilisateurSql;
import main.Io;
import main.Main;
import model.Salon;
import model.Utilisateur;

public class FenetreAjoutSalon  extends JFrame implements ActionListener, KeyListener {
	
	private FenetrePrincipale f;
	
	private BorderLayout layoutPrincipal = new BorderLayout();
	private GridLayout layoutCentral = new GridLayout(4,2);
	private Container pannelPrincipal = this.getContentPane();
	private JPanel pannelCentral = new JPanel();
	private JLabel labelCreation = new JLabel("Création du salon");
	private JLabel labelName = new JLabel("Nom du salon");
	private JTextField textFieldName = new JTextField("Ecrivez le nom du salon");
	private JLabel labelMDP = new JLabel("Mot de passe");
	private JTextField textFieldMDP = new JTextField("Ecrivez votre mot de passe");
	private JButton boutonCreation = new JButton("Création");
	private JButton boutonAnnuler = new JButton("Annuler");
	private Utilisateur createur= new Utilisateur();
	
	public FenetreAjoutSalon(FenetrePrincipale f, Utilisateur user){
		this.f = f;
		
		this.setTitle("Fenetre de création");
		this.setLocationRelativeTo(null);
		this.setSize(400,400);
		
		this.pannelPrincipal.setLayout(layoutPrincipal);
		this.pannelPrincipal.add(labelCreation,BorderLayout.NORTH);
		
		this.pannelPrincipal.add(pannelCentral,BorderLayout.CENTER);
		this.pannelCentral.setLayout(layoutCentral);
		this.pannelCentral.add(labelName);
		this.pannelCentral.add(textFieldName);
		this.pannelCentral.add(labelMDP);
		this.pannelCentral.add(textFieldMDP);
		this.pannelCentral.add(boutonCreation);
		this.pannelCentral.add(boutonAnnuler);
		this.boutonAnnuler.addActionListener(this);
		this.boutonCreation.addActionListener(this);
		this.createur=user;
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource().equals(this.boutonAnnuler)){
			this.dispose();
		}
		else if (arg0.getSource().equals(this.boutonCreation)){
			Io.print("bouton pressed");
			String name = this.textFieldName.getText();
			name.replaceAll("'", "\'");
			String mdp = this.textFieldMDP.getText();
			mdp.replaceAll("'", "\'");
			if((!name.equals("")) && (!mdp.equals(""))){
				Salon salon = new Salon(name, mdp, this.createur.getUTI_ID());
				f.setSalon(salon);
				JLabel lab= new JLabel();
				lab = f.getConnecteAuSalon2();
				lab.setText(salon.getSAL_NAME());
				f.setConnecteAuSalon2(lab);	
				new DaoSalonSql().creer(salon, Main.getDb());
				try {
					f.reinitialiseListeMessagesPostes();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			f.creationUtilisateur();
			this.dispose();
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

}
