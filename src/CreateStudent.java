import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CreateStudent extends JFrame{

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	Statement stmt;
    Connexion maConnexion= new Connexion();
	/**
	 * Create the application.
	 */
	public CreateStudent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("Student registration");
		this.setBounds(100, 100, 450, 357);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 434, 318);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student registration");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(154, 11, 124, 35);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(86, 83, 270, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Student name");
		lblNewLabel_1.setBounds(84, 61, 84, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Roll Number");
		lblNewLabel_2.setBounds(88, 122, 78, 14);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(86, 143, 270, 29);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Student Class");
		lblNewLabel_3.setBounds(86, 183, 89, 14);
		panel.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(86, 207, 270, 29);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String name_recup = textField.getText().trim();
			     String rn_recup = textField_1.getText().trim();
			     String student_class = textField_2.getText().trim();
			     
			     if(textField.getText().trim().length()>0 && textField_1.getText().toUpperCase().trim().length()>0 && textField_2.getText().toUpperCase().trim().length()>0) {
			    	 try{
				            String requete="INSERT INTO students_tb(roll_number, student_class, student_names)value ('"+rn_recup+"','"+name_recup+"','"+student_class+"')";
				            stmt=maConnexion.ObtenirConnexion().createStatement();
				            stmt.executeUpdate(requete);
				            JOptionPane.showMessageDialog(null,"Student registered successfully!");
				            textField.setText("");
				            textField_1.setText("");
				            textField_2.setText("");
				            }catch(SQLException | HeadlessException e1) {
				            	JOptionPane.showMessageDialog(null, "Something went wrong");
				            	System.out.println(e1);
				            }
			     }else {
			    	 JOptionPane.showMessageDialog(null, "Please fill in all required fields");
			     }
			        
			}
		});
		btnNewButton.setBounds(154, 266, 124, 41);
		panel.add(btnNewButton);
	}
}
