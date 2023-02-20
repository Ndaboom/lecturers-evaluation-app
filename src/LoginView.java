import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LoginView {

	private JFrame frmAuthentification;
	private JTextField textField;
	private JPasswordField passwordField;
	Statement stmt;
	Connexion dbConnexion = new Connexion();
	public static String t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// Look and feel 
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		// Look and feel
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
					window.frmAuthentification.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAuthentification = new JFrame();
		frmAuthentification.setBackground(Color.WHITE);
		frmAuthentification.setTitle("Authentification");
		frmAuthentification.setBounds(100, 100, 439, 338);
		frmAuthentification.setResizable(false);
		frmAuthentification.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAuthentification.setIconImage(new ImageIcon(getClass().getResource("logo.png")).getImage());
		frmAuthentification.getContentPane().setLayout(null);
		frmAuthentification.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 428, 299);
		frmAuthentification.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Authentification");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(140, 21, 167, 42);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(57, 114, 297, 30);
		textField.setToolTipText("Entrez votre nom d'utilisateur");
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(57, 89, 295, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(59, 155, 295, 14);
		panel.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Entrez votre mot de passe");
		passwordField.setBounds(61, 180, 295, 30);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(161, 234, 112, 40);
		btnNewButton.setForeground(new java.awt.Color(0, 51, 255));
		btnNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if(textField.getText().trim().length()>0 && passwordField.getText().toUpperCase().trim().length()>0) {
            		login(evt);
            	} else {
            		JOptionPane.showMessageDialog(null, "Please fill in all required fields");
            	}
            	
            }
        });
		panel.add(btnNewButton);
	}
	
	 private void login(java.awt.event.ActionEvent evt) {
		 String requete ="select * from users where username ='"+textField.getText()+"' and password ='"+passwordField.getText()+"' ";
	        try{
	            
	            stmt=dbConnexion.ObtenirConnexion().createStatement();
	            ResultSet resultat= stmt.executeQuery(requete);

	        if(!resultat.next()){
	            JOptionPane.showMessageDialog(null, "Invalide login détails!", "Login Error",JOptionPane.ERROR_MESSAGE);
	            textField.setText(null);
	            passwordField.setText(null);
	        }else{
	             this.t1 = resultat.getString("username");
	             frmAuthentification.setVisible(false);
	             new MainView().setVisible(true);                
	        }  
	            
	        }catch(Exception e){
	            System.out.println("--> Exception : " + e) ;
	           
	        }
	}
}
