package View;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FenetrePrincipale extends JFrame implements ActionListener, KeyListener{
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private BorderLayout layout = new BorderLayout();
	private Container contentPane = this.getContentPane();
	private JPanel pannelUtilisateurs = new JPanel();
	private JPanel pannelMessages = new JPanel();
	private JPanel pannelEnvoiMessage = new JPanel();
	private List listeUtilisateurs = new List();
	private List listeMessages = new List();
	private JTextField message = new JTextField("Ecrivez votre message.");
	private JButton envoyer = new JButton("Envoyer");
	
	
	public FenetrePrincipale(){
		
		this.init();
		
		
		
		
	}
	
	private void init(){
		this.setTitle("The chat");
		this.setSize(this.screenSize);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.contentPane.setLayout(layout);
		
		this.contentPane.add(pannelUtilisateurs,BorderLayout.WEST);
		this.pannelUtilisateurs.add(listeUtilisateurs);
		
		this.contentPane.add(pannelMessages, BorderLayout.CENTER);
		this.pannelMessages.setLayout(new GridLayout(2,1));
		this.pannelMessages.add(listeMessages);
		this.pannelMessages.add(pannelEnvoiMessage);
		
		this.pannelEnvoiMessage.setLayout(new GridLayout(1,2));
		this.pannelEnvoiMessage.add(message);
		this.message.addKeyListener(this);
		this.pannelEnvoiMessage.add(envoyer);
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
}
