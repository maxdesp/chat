package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.DaoUtilisateurSql;
import model.Salon;
import model.Utilisateur;

public class FenetrePrincipale extends JFrame implements ActionListener, KeyListener, MouseListener{
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int height = (int) screenSize.getHeight()-40;
	private int width = (int) screenSize.getWidth();
	private BorderLayout layoutPrincipal = new BorderLayout();
	private BorderLayout layoutMessages = new BorderLayout();
	private GridLayout layoutUtilisateurs = new GridLayout(10,1);
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuFichier = new JMenu("Fichier");
	private JMenu menuUtilisateur = new JMenu("Utilisateur");
	private JMenuItem menuConnexionUtilisateur = new JMenuItem("Se connecter");
	private JMenuItem menuAjoutUtilisateur = new JMenuItem("Créer un profil");
	private JMenuItem menuModifierUtilisateur = new JMenuItem("Modifier un profil");
	private JMenuItem menuSupprimerUtilisateur = new JMenuItem("Supprimer un profil");
	private JMenuItem menuDeconnexionUtilisateur = new JMenuItem("Se déconnecter");
	private JMenu menuSalon = new JMenu("Salon");
	private JMenuItem menuConnexionSalon = new JMenuItem("Entrer dans un salon");
	private JMenuItem menuAjoutSalon = new JMenuItem("Créer un salon");
	private JMenuItem menuModifierSalon = new JMenuItem("Modifier un salon");
	private JMenuItem menuSupprimerSalon = new JMenuItem("Supprimer un salon");
	private JMenuItem menuDeconnexionSalon = new JMenuItem("Quitter le salon");
	private Container contentPane = this.getContentPane();
	private JPanel pannelUtilisateurs = new JPanel();
	private JPanel pannelMessages = new JPanel();
	private JPanel pannelEnvoiMessage = new JPanel();
	private JPanel cell11 = new JPanel();
	private JPanel cell12 = new JPanel();
	private JLabel connecteEnTantQue = new JLabel("Connecté en tant que :");
	private JLabel connecteEnTantQue2 = new JLabel("- non connecté -",SwingConstants.CENTER);
	private JLabel connecteAuSalon = new JLabel("Connecté au salon :");
	private JLabel connecteAuSalon2 = new JLabel("- non connecté -",SwingConstants.CENTER);
	private JLabel listeUtilisateursConnectes = new JLabel("Utilisateurs connectés");
	private List listeUtilisateursConnectes2 = new List();
	private List listeMessages = new List();
	private JTextField message = new JTextField("Ecrivez votre message.",50);
	private JButton envoyer = new JButton("Envoyer");
	private Utilisateur utilisateur = new Utilisateur();
	private Salon salon = new Salon();
	
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}

	public FenetrePrincipale(){
		
		this.init();
		
		
		
		
	}
	
	private void init(){
		this.setTitle("The chat");
		this.setSize(this.width, this.height);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.contentPane.setLayout(layoutPrincipal);
		
		this.setJMenuBar(menuBar);
		this.menuBar.add(menuFichier);
		this.menuBar.add(menuUtilisateur);
		this.menuUtilisateur.add(menuConnexionUtilisateur);
		this.menuConnexionUtilisateur.addActionListener(this);
		this.menuUtilisateur.add(menuAjoutUtilisateur);
		this.menuAjoutUtilisateur.addActionListener(this);
		this.menuUtilisateur.add(menuModifierUtilisateur);
		this.menuModifierUtilisateur.addActionListener(this);
		this.menuUtilisateur.add(menuSupprimerUtilisateur);
		this.menuSupprimerUtilisateur.addActionListener(this);
		this.menuUtilisateur.add(menuDeconnexionUtilisateur);
		this.menuDeconnexionUtilisateur.addActionListener(this);
		this.menuDeconnexionUtilisateur.setEnabled(false);
		this.menuBar.add(menuSalon);
		this.menuSalon.add(menuConnexionSalon);
		this.menuConnexionSalon.addActionListener(this);
		this.menuSalon.add(menuAjoutSalon);
		this.menuAjoutSalon.addActionListener(this);
		this.menuSalon.add(menuModifierSalon);
		this.menuModifierSalon.addActionListener(this);
		this.menuSalon.add(menuSupprimerSalon);
		this.menuSupprimerSalon.addActionListener(this);
		this.menuSalon.add(menuDeconnexionSalon);
		this.menuDeconnexionSalon.addActionListener(this);
		this.menuDeconnexionSalon.setEnabled(false);
		
		this.contentPane.add(pannelUtilisateurs,BorderLayout.WEST);
		this.pannelUtilisateurs.setLayout(layoutUtilisateurs);
		this.pannelUtilisateurs.add(connecteEnTantQue);
		this.pannelUtilisateurs.add(connecteEnTantQue2);
		this.pannelUtilisateurs.add(connecteAuSalon);
		this.pannelUtilisateurs.add(connecteAuSalon2);
		this.pannelUtilisateurs.add(listeUtilisateursConnectes);
		this.pannelUtilisateurs.add(listeUtilisateursConnectes2);
		
		this.contentPane.add(pannelMessages, BorderLayout.CENTER);
		this.pannelMessages.setLayout(this.layoutMessages);
		this.pannelMessages.add(listeMessages, BorderLayout.CENTER);
		this.pannelMessages.add(pannelEnvoiMessage, BorderLayout.SOUTH);
		
		this.pannelEnvoiMessage.setLayout(new FlowLayout());
		this.pannelEnvoiMessage.add(cell11);
		this.cell11.add(message);
		this.message.setSize(400, 80);
		this.message.addKeyListener(this);
		this.message.addMouseListener(this);

		this.pannelEnvoiMessage.add(cell12);
		this.cell12.setSize(100,80);
		this.cell12.add(envoyer);
		this.envoyer.setSize(100, 80);
		this.envoyer.addActionListener(this);
		
		
		
		
		
		this.setVisible(true);
	}
	
	private boolean rafraichirListeUtilisateursConnectes(){
		
		DaoUtilisateurSql daoUtilisateur = new DaoUtilisateurSql();
		ArrayList<Utilisateur> users =daoUtilisateur.getAll();
		for(Utilisateur user: users){
			this.listeUtilisateursConnectes2.add((user.getUTI_PSEUDO()));
		}
		return false;
	}
	
	
	private boolean connexionUtilisateur(){
		FenetreConnexionUtilisateur fConnexionUtilisateur = new FenetreConnexionUtilisateur(this);
		this.menuDeconnexionUtilisateur.setEnabled(true);
		this.menuConnexionUtilisateur.setEnabled(false);
		if(this.utilisateur.getUTI_PSEUDO()!=null){
			this.connecteEnTantQue2.setText(this.utilisateur.getUTI_PSEUDO());
		}
		return false;
	}
	
	private boolean creationUtilisateur(){
		FenetreAjoutUtilisateur fCreationUtilisateur = new FenetreAjoutUtilisateur(this);
		return false;
	}
	
	private boolean modificationUtilisateur(){
		return false;
	}
	
	private boolean suppressionUtilisateur(){
		return false;
	}
	
	private boolean deconnexionUtilisateur(){
		this.menuDeconnexionUtilisateur.setEnabled(false);
		this.menuConnexionUtilisateur.setEnabled(true);
		return false;
	}
	
	private boolean connexionSalon(){
		FenetreConnexionSalon fConnexionSalon = new FenetreConnexionSalon(this);
		this.menuDeconnexionSalon.setEnabled(true);
		this.menuConnexionSalon.setEnabled(false);
		if(this.salon.getSAL_NAME()!=null){
			this.connecteAuSalon2.setText(this.salon.getSAL_NAME());
		}
		return false;
	}
	
	private boolean creationSalon(){
		return false;
	}
	
	private boolean modificationSalon(){
		return false;
	}
	
	private boolean suppressionSalon(){
		return false;
	}
	
	private boolean deconnexionSalon(){
		this.menuDeconnexionSalon.setEnabled(false);
		this.menuConnexionSalon.setEnabled(true);
		return false;
	}
	
	private boolean rafraichirZoneMessages(){
		return false;
	}
	
	private boolean envoyerMessage(){
		return false;
	}
	

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode()==10){
			
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==this.envoyer){
			this.envoyerMessage();
		}
		if(arg0.getSource()==this.menuConnexionUtilisateur){
			this.connexionUtilisateur();
		}
		if(arg0.getSource()==this.menuAjoutUtilisateur){
			this.creationUtilisateur();
		}
		if(arg0.getSource()==this.menuModifierUtilisateur){
			this.modificationUtilisateur();
		}
		if(arg0.getSource()==this.menuSupprimerUtilisateur){
			this.suppressionUtilisateur();
		}
		if(arg0.getSource()==this.menuDeconnexionUtilisateur){
			this.deconnexionUtilisateur();
		}
		if(arg0.getSource()==this.menuConnexionSalon){
			this.connexionSalon();
		}
		if(arg0.getSource()==this.menuAjoutSalon){
			this.creationSalon();
		}
		if(arg0.getSource()==this.menuModifierSalon){
			this.modificationSalon();
		}
		if(arg0.getSource()==this.menuSupprimerSalon){
			this.suppressionSalon();
		}
		if(arg0.getSource()==this.menuDeconnexionSalon){
			this.deconnexionSalon();
		}
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
		if(arg0.getSource()==this.message){
			this.message.setText("");
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
