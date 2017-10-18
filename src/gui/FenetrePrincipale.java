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
import java.sql.SQLException;
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
import javax.swing.Timer;

import dao.DaoMessageSql;
import dao.DaoSalonSql;
import dao.DaoUtilisateurSql;
import main.Io;
import main.Main;
import model.Message;
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
	private JMenuItem menuAjoutUtilisateur = new JMenuItem("Cr�er un profil");
	private JMenuItem menuModifierUtilisateur = new JMenuItem("Modifier un profil");
	private JMenuItem menuSupprimerUtilisateur = new JMenuItem("Supprimer un profil");
	private JMenuItem menuDeconnexionUtilisateur = new JMenuItem("Se d�connecter");
	private JMenu menuSalon = new JMenu("Salon");
	private JMenuItem menuConnexionSalon = new JMenuItem("Entrer dans un salon");
	private JMenuItem menuAjoutSalon = new JMenuItem("Cr�er un salon");
	private JMenuItem menuModifierSalon = new JMenuItem("Modifier un salon");
	private JMenuItem menuSupprimerSalon = new JMenuItem("Supprimer un salon");
	private JMenuItem menuDeconnexionSalon = new JMenuItem("Quitter le salon");
	private Container contentPane = this.getContentPane();
	private JPanel pannelUtilisateurs = new JPanel();
	private JPanel pannelMessages = new JPanel();
	private JPanel pannelEnvoiMessage = new JPanel();
	private JPanel cell11 = new JPanel();
	private JPanel cell12 = new JPanel();
	private JLabel connecteEnTantQue = new JLabel("Connect� en tant que :");
	private JLabel connecteEnTantQue2 = new JLabel("- non connect� -",SwingConstants.CENTER);
	private JLabel connecteAuSalon = new JLabel("Connect� au salon :");
	private JLabel connecteAuSalon2 = new JLabel("- non connect� -",SwingConstants.CENTER);
	private JLabel listeUtilisateursConnectes = new JLabel("Utilisateurs connect�s");
	private List listeUtilisateursConnectes2 = new List();
	private List listeMessages = new List();
	private JTextField message = new JTextField("Ecrivez votre message.",50);
	private JButton envoyer = new JButton("Envoyer");
	private Utilisateur utilisateur = new Utilisateur();
	private Salon salon = new Salon();
	private Timer t = new Timer(100, this);
	
	
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

	public FenetrePrincipale() throws SQLException{
		
		this.init();
		this.t.start();
		
		
		
	}
	
	private void init() throws SQLException{
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
		this.menuConnexionSalon.setEnabled(false);
		this.menuSalon.add(menuAjoutSalon);
		this.menuAjoutSalon.setEnabled(false);
		this.menuAjoutSalon.addActionListener(this);
		this.menuSalon.add(menuModifierSalon);
		this.menuModifierSalon.addActionListener(this);
		this.menuModifierSalon.setEnabled(false);
		this.menuSalon.add(menuSupprimerSalon);
		this.menuSupprimerSalon.addActionListener(this);
		this.menuSupprimerSalon.setEnabled(false);
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
		
		
		
		this.rafraichirListeUtilisateursConnectes();
		
		this.setVisible(true);
	}
	
	
	private boolean rafraichirListeUtilisateursConnectes() throws SQLException{
		
		this.listeUtilisateursConnectes2.removeAll();
		DaoUtilisateurSql daoUtilisateur = new DaoUtilisateurSql();
		ArrayList<Utilisateur> users =daoUtilisateur.getAll(Main.getDb());
		for(Utilisateur user: users){
			if (user.isUTI_CONNECTED() == true) {
				this.listeUtilisateursConnectes2.add((user.getUTI_PSEUDO()));
				
			}
			else {
				// Io.print(user.getUTI_PSEUDO() + " n'est pas connect�");
			}
			
		}
		return false;
	}
	
	
	public boolean connexionUtilisateur(){
		
		if(this.utilisateur!=null){
			this.menuDeconnexionUtilisateur.setEnabled(true);
			this.menuConnexionUtilisateur.setEnabled(false);
			this.connecteEnTantQue2.setText(this.utilisateur.getUTI_PSEUDO());
			this.menuAjoutSalon.setEnabled(true);
			this.menuConnexionSalon.setEnabled(true);
			this.menuSupprimerSalon.setEnabled(true);
			this.menuModifierSalon.setEnabled(true);
		}
		return false;
	}
	
	public boolean creationUtilisateur(){
		
		if(this.utilisateur!=null){
			this.menuDeconnexionUtilisateur.setEnabled(true);
			this.menuConnexionUtilisateur.setEnabled(false);
			this.connecteEnTantQue2.setText(this.utilisateur.getUTI_PSEUDO());
			this.menuAjoutSalon.setEnabled(true);
			this.menuConnexionSalon.setEnabled(true);
			this.menuSupprimerSalon.setEnabled(true);
			this.menuModifierSalon.setEnabled(true);
		}
		return false;
	}
	
	public boolean modificationUtilisateur(){
		return false;
	}
	
	public boolean suppressionUtilisateur(){
		return false;
	}
	
	public boolean deconnexionUtilisateur(){
		this.menuDeconnexionUtilisateur.setEnabled(false);
		this.menuConnexionUtilisateur.setEnabled(true);
		this.menuAjoutSalon.setEnabled(false);
		this.menuConnexionSalon.setEnabled(false);
		this.menuSupprimerSalon.setEnabled(false);
		this.menuModifierSalon.setEnabled(false);
		return false;
	}
	
	public boolean connexionSalon(){
		FenetreConnexionSalon fConnexionSalon = new FenetreConnexionSalon(this);
		this.menuDeconnexionSalon.setEnabled(true);
		this.menuConnexionSalon.setEnabled(false);
		if(this.salon.getSAL_NAME()!=null){
			this.connecteAuSalon2.setText(this.salon.getSAL_NAME());
		}
		return false;
	}
	
	public boolean creationSalon(){
		FenetreAjoutSalon fCreationSalon = new FenetreAjoutSalon(this, utilisateur);
		this.menuDeconnexionSalon.setEnabled(true);
		this.menuConnexionSalon.setEnabled(false);
		if(this.salon.getSAL_NAME()!=null){
			this.connecteAuSalon2.setText(this.salon.getSAL_NAME());
		}
		return false;
	}
	
	public boolean modificationSalon(){
		return false;
	}
	
	public boolean suppressionSalon(){
		return false;
	}
	
	private boolean deconnexionSalon(){
		this.menuDeconnexionSalon.setEnabled(false);
		this.menuConnexionSalon.setEnabled(true);
		return false;
	}
	
	private boolean rafraichirZoneMessages() throws SQLException{
		Salon salon = new DaoSalonSql().charger(Integer.valueOf(1), Main.getDb());
		ArrayList<Message> listeMessages = new DaoMessageSql().getParSalon(Main.getDb(), salon);
		Utilisateur uti = null;
		
		for(Message m : listeMessages){
			uti = new DaoUtilisateurSql().charger(m.getMES_UTI_ID(), Main.getDb());
			this.listeMessages.add(uti.getUTI_PSEUDO()+" a �crit :");
			this.listeMessages.add(m.getMES_MESSAGE());
		}
		return true;
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
			FenetreConnexionUtilisateur fConnexionUtilisateur = new FenetreConnexionUtilisateur(this);
		}
		if(arg0.getSource()==this.menuAjoutUtilisateur){
			FenetreAjoutUtilisateur fCreationUtilisateur = new FenetreAjoutUtilisateur(this);
			
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
		if(arg0.getSource()==this.t){
			try {
				this.rafraichirListeUtilisateursConnectes();
				this.rafraichirZoneMessages();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
