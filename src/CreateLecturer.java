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
public class CreateLecturer extends JFrame{

	private JTextField textField;
	private JTextField textField_1;
	Statement stmt;
    Connexion maConnexion= new Connexion();
	/**
	 * Create the application.
	 */
	public CreateLecturer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("Lecturer registration");
		this.setBounds(100, 100, 450, 298);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 434, 267);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lecturer registration");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(154, 11, 124, 35);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(86, 83, 270, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Lecturer's name");
		lblNewLabel_1.setBounds(84, 61, 166, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Course");
		lblNewLabel_2.setBounds(88, 122, 78, 14);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(86, 143, 270, 29);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String name_recup = textField.getText().trim();
			     String course_recup = textField_1.getText().trim();
			     
			     if(textField.getText().trim().length()>0 && textField_1.getText().toUpperCase().trim().length()>0) {
			    	 try{
				            String requete="INSERT INTO lecturers_tb(lecturer_name, course)value ('"+name_recup+"','"+course_recup+"')";
				            stmt=maConnexion.ObtenirConnexion().createStatement();
				            stmt.executeUpdate(requete);
				            JOptionPane.showMessageDialog(null,"Lecturer registered successfully!");
				            textField.setText("");
				            textField_1.setText("");
				            }catch(SQLException | HeadlessException e1) {
				            	JOptionPane.showMessageDialog(null, "Something went wrong");
				            	System.out.println(e1);
				            }
			     }else {
			    	 JOptionPane.showMessageDialog(null, "Please fill in all required fields");
			     }
			        
			}
		});
		btnNewButton.setBounds(154, 200, 124, 41);
		panel.add(btnNewButton);
	}
}
