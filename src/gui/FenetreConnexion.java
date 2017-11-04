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

import dao.DB;
import dao.DaoSalonSql;
import dao.DaoUtilisateurSql;
import main.Io;
import main.Main;
import model.Salon;
import model.Utilisateur;

public class FenetreConnexion extends JFrame implements ActionListener, KeyListener, MouseListener {
	
	private FenetrePrincipale f;
	
	private DB db;
	private BorderLayout layoutPrincipal = new BorderLayout();
	private GridLayout layoutCentral = new GridLayout(3,2);
	private Container pannelPrincipal = this.getContentPane();
	private JPanel pannelCentral = new JPanel();
	private JLabel labelConnexion = new JLabel("Connexion au serveur");
	private JLabel labelName = new JLabel("Adresse IP / domaine: ");
	private JTextField textFieldName = new JTextField("localhost");
	private JLabel labelMDP = new JLabel("Mot de passe");
	private JTextField textFieldMDP = new JTextField("");
	private JButton boutonConnexion = new JButton("Connexion");
	private JButton boutonAnnuler = new JButton("Annuler");
	


	private boolean connected = false;


	public boolean isConnected() {
		return connected;
	}


	public void setConnected(boolean connected) {
		this.connected = connected;
	}
	
	public FenetreConnexion(FenetrePrincipale f){
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
		this.boutonConnexion.addActionListener(this);

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==this.boutonConnexion){
			try {
				String ip = this.textFieldName.getText();
				String pass = this.textFieldMDP.getText();

				// set db to main window
				this.f.setDb(new DB(ip, pass));
				this.f.getDb().getConnection();
				
				// set is connected to true
				this.connected = true;
				this.f.setConnected(true);
				
				// init main window
				this.f.initWindow();
				
			
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane messageErreur = new JOptionPane();
				messageErreur.showMessageDialog(null, "Impossible de se connecter, verifier les identifiants");
			}
			finally{
//				f.connexionUtilisateur();
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
		if(arg0.getSource()==this.textFieldName){
			this.textFieldName.setText("");
		}if(arg0.getSource()==this.textFieldMDP){
			this.textFieldMDP.setText("");
		}
	}

}
