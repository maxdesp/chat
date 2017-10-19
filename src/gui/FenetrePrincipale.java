package gui;

import java.awt.BorderLayout;
import java.awt.Color;
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
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
	private ArrayList<Utilisateur> usersConnected= new ArrayList<Utilisateur>();
	public JLabel getConnecteAuSalon2() {
		return connecteAuSalon2;
	}

	public void setConnecteAuSalon2(JLabel connecteAuSalon2) {
		this.connecteAuSalon2 = connecteAuSalon2;
	}

	private JLabel listeUtilisateursConnectes = new JLabel("Utilisateurs connectés");
	private List listeUtilisateursConnectes2 = new List();
	private List listeMessages = new List();
	private JTextField message = new JTextField("",50);
	private JButton envoyer = new JButton("Envoyer");
	private Utilisateur utilisateur = new Utilisateur();
	private Salon salon = new Salon();
	private ArrayList<Message> listeMessagesPostes = new ArrayList<Message>();
	

	public void reinitialiseListeMessagesPostes() throws SQLException {
	
		Salon salon = new DaoSalonSql().charger(this.salon.getSAL_ID(), Main.getDb());
		Io.print("reinitialisation de la liste de messages avec salon= "+ salon.getSAL_NAME());
		this.listeMessagesPostes.clear();
		this.listeMessages.clear();
		Io.print("taille de la liste de message: " +this.listeMessagesPostes.size());
		ArrayList<Message> listeMessages = new DaoMessageSql().getParSalon(Main.getDb(), salon);
		
		Utilisateur uti = null;
		
		for(Message m : listeMessages){
			Io.print(m.getMES_MESSAGE());
			this.listeMessagesPostes.add(m);
			uti = new DaoUtilisateurSql().charger(m.getMES_UTI_ID(), Main.getDb());
			this.listeMessages.add(uti.getUTI_PSEUDO()+" a écrit :");
			this.listeMessages.add("	"+m.getMES_MESSAGE());
			this.listeMessages.add("\r");
		}
	}

	private Timer t = new Timer(100, this);
	private Timer t2 = new Timer(1000, this);
	
	
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
		this.t2.start();
		
	}
	
	private void init() throws SQLException{
		this.listeMessages.addKeyListener(this);
		this.listeUtilisateursConnectes.addKeyListener(this);
		this.listeUtilisateursConnectes2.addKeyListener(this);
		this.salon = new Salon();
		this.salon.setSAL_ID(1);
		this.setTitle("The chat");
		this.setSize(this.width, this.height);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.contentPane.setLayout(layoutPrincipal);
		this.setJMenuBar(menuBar);
		int c1 = 25*new Random().nextInt(11);
		int c2 = 25*new Random().nextInt(11);
		int c3 = 25*new Random().nextInt(11);
		this.menuBar.setBackground(new Color(c1,c2,c3));
		this.menuBar.add(menuFichier);
		this.menuFichier.setForeground(new Color(255-c1,255-c2,255-c3));
		this.menuBar.add(menuUtilisateur);
		this.menuUtilisateur.add(menuConnexionUtilisateur);
		this.menuUtilisateur.setForeground(new Color(255-c1,255-c2,255-c3));
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
		this.menuSalon.setForeground(new Color(255-c1,255-c2,255-c3));
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
		// this.contentPane.addc
		Salon salon = new DaoSalonSql().charger(Integer.valueOf(1), Main.getDb());
		ArrayList<Message> listeMessages = new DaoMessageSql().getParSalon(Main.getDb(), salon);
		Utilisateur uti = null;
		
		for(Message m : listeMessages){
			this.listeMessagesPostes.add(m);
			uti = new DaoUtilisateurSql().charger(m.getMES_UTI_ID(), Main.getDb());
			this.listeMessages.add(uti.getUTI_PSEUDO()+" a écrit :");
			this.listeMessages.add("\t"+m.getMES_MESSAGE());
			this.listeMessages.add("\r");
		}
		
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
				this.usersConnected.add(user);
			}
			else {
				// Io.print(user.getUTI_PSEUDO() + " n'est pas connecté");
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
	
	public boolean deconnexionUtilisateur() throws SQLException{
		this.menuDeconnexionUtilisateur.setEnabled(false);
		this.menuConnexionUtilisateur.setEnabled(true);
		this.menuAjoutSalon.setEnabled(false);
		this.menuConnexionSalon.setEnabled(false);
		this.menuSupprimerSalon.setEnabled(false);
		this.menuModifierSalon.setEnabled(false);
		this.utilisateur.seDeconnecter(Main.getDb());
		return false;
	}
	
	public boolean connexionSalon(){
		FenetreConnexionSalon fConnexionSalon = new FenetreConnexionSalon(this);
		this.menuDeconnexionSalon.setEnabled(true);
		this.menuConnexionSalon.setEnabled(false);
		if(this.salon!=null){
			this.connecteAuSalon2.setText(this.salon.getSAL_NAME());
			Io.print("affiche nom du salon: "+this.salon.getSAL_NAME());
		}
		return false;
	}
	
	public boolean creationSalon(){
		FenetreAjoutSalon fCreationSalon = new FenetreAjoutSalon(this, utilisateur);
		this.menuDeconnexionSalon.setEnabled(true);
		this.menuConnexionSalon.setEnabled(false);
		if(this.salon!=null){
			this.connecteAuSalon2.setText(this.salon.getSAL_NAME());
			Io.print("affiche nom du salon: "+this.salon.getSAL_NAME());
		}
		Io.print("affiche nom du salon: null");
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
		this.connecteAuSalon2.setText("- non connecté -");
		Io.print("affiche nom du salon: - non connecté -");
		return false;
	}
	
	private boolean rafraichirZoneMessages() throws SQLException{
		Salon salon = new DaoSalonSql().charger(this.salon.getSAL_ID(), Main.getDb());//// ici
		ArrayList<Message> listeMessages = new DaoMessageSql().getParSalon(Main.getDb(), salon);
		// Io.print(salon.getSAL_NAME());
		Utilisateur uti = null;
		
		for(int i=(this.listeMessagesPostes.size()-1);i<listeMessages.size();i++){
			Message m = listeMessages.get(i);
			this.listeMessagesPostes.add(m);
			uti = new DaoUtilisateurSql().charger(m.getMES_UTI_ID(), Main.getDb());
			this.listeMessages.add(uti.getUTI_PSEUDO()+" a écrit :");
			this.listeMessages.add("	"+m.getMES_MESSAGE());
			this.listeMessages.add("\r");
		}
		return true;
	}
	
	private boolean envoyerMessage(){
		Message message = new Message((int)this.utilisateur.getUTI_ID(),this.message.getText(), (int)this.salon.getSAL_ID());
		new DaoMessageSql().creer(message, Main.getDb());
		return false;
	}
	

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int key = arg0.getKeyCode();
		if(key==10){
			
		}
		else if (key == 27 ) {
			 this.exit();	
			
		}
		else {
			Io.print(arg0.getKeyCode());
		}
	}

	private void exit() {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(this, "Voulez vous quitter le programme ?", "Title on Box", dialogButton);
		if(dialogResult == 0) {
		  System.out.println("Quitter");
		  System.exit(0);
		} else {
		  System.out.println("Revenir");
		} 
		// System.exit(0);
		// TODO Auto-generated method stub
		
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
			try {
				this.deconnexionUtilisateur();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		if(arg0.getSource()==this.envoyer){
			this.envoyerMessage();
		}
		if(arg0.getSource()==this.t2){
			try {
				boolean rafraichir=false;
				for(Utilisateur c : usersConnected){
					if(!c.isUTI_CONNECTED()){
						rafraichir=true;
					}
				}
				boolean normal=true;
				DaoUtilisateurSql daoUtilisateur = new DaoUtilisateurSql();
				ArrayList<Utilisateur> users =daoUtilisateur.getAll(Main.getDb());
				for(Utilisateur user: users){
					if (user.isUTI_CONNECTED() == true) {
						normal=false;
						for(Utilisateur connect : usersConnected){
							if(connect.getUTI_PSEUDO().equals(user.getUTI_PSEUDO())){
								normal=true;
							}
						}
						if(!normal){
							rafraichir=true;
						}
					}
				}
				Io.print("rafraichir: "+rafraichir);
				if(rafraichir){
					this.rafraichirZoneMessages();
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(arg0.getSource()==this.t2){
			try {
				
				this.rafraichirListeUtilisateursConnectes();
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
