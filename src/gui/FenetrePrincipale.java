package View;

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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FenetrePrincipale extends JFrame implements ActionListener, KeyListener, MouseListener{
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int height = (int) screenSize.getHeight()-40;
	private int width = (int) screenSize.getWidth();
	private int widthUtilisateurs = 200;
	private BorderLayout layoutPrincipal = new BorderLayout();
	private BorderLayout layoutMessages = new BorderLayout();
	private FlowLayout layoutUtilisateurs = new FlowLayout();
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
	private List listeUtilisateurs = new List();
	private List listeMessages = new List();
	private JTextField message = new JTextField("Ecrivez votre message.",50);
	private JButton envoyer = new JButton("Envoyer");
	
	
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
		this.menuUtilisateur.add(menuAjoutUtilisateur);
		this.menuUtilisateur.add(menuModifierUtilisateur);
		this.menuUtilisateur.add(menuSupprimerUtilisateur);
		this.menuUtilisateur.add(menuDeconnexionUtilisateur);
		this.menuBar.add(menuSalon);
		this.menuSalon.add(menuConnexionSalon);
		this.menuSalon.add(menuAjoutSalon);
		this.menuSalon.add(menuModifierSalon);
		this.menuSalon.add(menuSupprimerSalon);
		this.menuSalon.add(menuDeconnexionSalon);
		
		this.contentPane.add(pannelUtilisateurs,BorderLayout.WEST);
		this.pannelUtilisateurs.setLayout(layoutUtilisateurs);
		this.pannelUtilisateurs.add(listeUtilisateurs);
		
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
