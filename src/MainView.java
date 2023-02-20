import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.util.Date;

import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class MainView extends JFrame {

	private JFrame frame;
	private JTextField textField_1;
	private com.toedter.calendar.JDateChooser product_expiry_date;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField textField_2;
	private JLabel lblNewLabel_5;
	private JTextField textField_3;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_9_1;
	JLabel lblNewLabel_13;
	private JTextField textField_4;
	private javax.swing.JScrollPane jScrollPane1;
	public String evaluator;
	JLabel lblNewLabel_9;
	JLabel lblNewLabel_10;
	JLabel lblNewLabel_11;
	float marksSum = 0;
	String HOD = "HOD";
	JComboBox<String> comboBox_1_1;
	
	 /**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
		getData();
	}

	/**
	 * Initialize the contents of the this.
	 */
	Statement stmt;
    Connexion maConnexion= new Connexion();
    private JTable table;
    public JComboBox<String> comboBox;
    private JComboBox<String> comboBox_1;
    private JMenuItem mntmNewMenuItem_2;
    public float total_max = 0;
    
    public void getData(){
        try{

            java.sql.Statement stmt1= maConnexion.ObtenirConnexion().createStatement();
            java.sql.ResultSet resultat= stmt1.executeQuery("SELECT * FROM evaluations_record");
            table.setModel(DbUtils.resultSetToTableModel(resultat));
	
	
       }catch(Exception e){
	
	
       }
    }
	private void initialize() {
		
		this.setBounds(100, 100, 1003, 555);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon(getClass().getResource("logo.png")).getImage());
		this.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 984, 516);
		panel.setBackground(Color.WHITE);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lecturer's Evaluation");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(382, 11, 191, 29);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Lecturer's name");
		lblNewLabel_1.setBounds(10, 77, 91, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Course name");
		lblNewLabel_2.setBounds(10, 120, 81, 14);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(139, 113, 212, 29);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		product_expiry_date = new JDateChooser();
		product_expiry_date.setDate(new Date());
		product_expiry_date.setDateFormatString("yyyy-MM-dd");
		product_expiry_date.setBounds(139, 153, 213, 29);
		panel.add(product_expiry_date);
		
		lblNewLabel_3 = new JLabel("Date");
		lblNewLabel_3.setBounds(10, 163, 46, 14);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Knowledge and Competence (/40):");
		lblNewLabel_4.setBounds(10, 329, 183, 14);
		panel.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(214, 322, 137, 29);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Teaching skills/ Methodology (/40):");
		lblNewLabel_5.setBounds(10, 370, 173, 14);
		panel.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(214, 363, 137, 29);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Ethical Values (/20):");
		lblNewLabel_6.setBounds(10, 410, 146, 14);
		panel.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setBounds(214, 403, 137, 29);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Query
				 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			        String evaluation_date_recup = sdf.format(product_expiry_date.getDate());
			        String lecturer_name_recup = comboBox_1.getSelectedItem().toString().trim();
			        String course_name_recup = textField_1.getText().trim();
			        String knowledge_points_recup = textField_2.getText().trim();
			        String teaching_skills_recup = textField_3.getText().trim();
			        String ethical_values_recup = textField_4.getText().trim();
			        
			        if(textField_1.getText().trim().length()>0 && textField_2.getText().toUpperCase().trim().length()>0
			        		&& textField_3.getText().trim().length()>0 && textField_4.getText().trim().length()>0){
			            
			            try{
			            if(evaluator == null) {
			            	evaluator = comboBox.getSelectedItem().toString().trim();
			            }
			            String requete="INSERT INTO evaluations_record(lecturer_name, course_name, evaluation_date, knowledge_points, teaching_points, ethical_points, evaluator)value ('"+lecturer_name_recup+"','"+course_name_recup+"','"+evaluation_date_recup+"','"+knowledge_points_recup+"','"+teaching_skills_recup+"','"+ethical_values_recup+"','"+evaluator+"')";
			            stmt=maConnexion.ObtenirConnexion().createStatement();
			            stmt.executeUpdate(requete);
			            getData();
			            JOptionPane.showMessageDialog(null,"Record saved successfully!");
			            textField_1.setText("");
			            textField_2.setText("");
			            textField_3.setText("");
			            textField_4.setText("");
			            product_expiry_date.setDate(new Date());
			            evaluator = null;
			            
			            }catch(SQLException | HeadlessException e1) {
			            	JOptionPane.showMessageDialog(null, "Something went wrong");
			            	System.out.println(e1);
			            }
			        } else if(textField_1.getText().trim().length() > 0) {
			        	JOptionPane.showMessageDialog(null, "Please fill in the course name field");
			        } else {
			        	JOptionPane.showMessageDialog(null, "Please fill in all required fields");
			        }
				//Query
			}
		});
		btnNewButton.setBounds(104, 454, 152, 40);
		panel.add(btnNewButton);
		
		jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane1.setSize(549, 365);
		jScrollPane1.setLocation(414, 40);
		
		table = new JTable();
		table.setBounds(370, 384, 489, -343);
		table.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	                {null, null, null, null, null, null, null, null, null},
	                {null, null, null, null, null, null, null, null, null},
	                {null, null, null, null, null, null, null, null, null},
	                {null, null, null, null, null, null, null, null, null}
	            },
	            new String [] {
	                "Lecturer name", "Course name", "Knowledge & Competence", "Teaching skills", "Ethical values"
	            }
));
		table.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                //jTable1MouseClicked(evt);
	            }
	        });
		
	    jScrollPane1.setViewportView(table);
		panel.add(jScrollPane1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 101, 22);
		panel.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Add Student");
		mntmNewMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { 
            CreateStudent ct = new CreateStudent();
            ct.setVisible(true);
            }
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Add Lecturer");
		mntmNewMenuItem_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { 
            CreateLecturer cl = new CreateLecturer();
            cl.setVisible(true);
            }
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_2 = new JMenuItem("Refresh data");
		mntmNewMenuItem_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { 
            	fecthStudents();
        		fecthLecturers();
        		getData();
        		getMarks();
        		getHODMarks();
        		getAverage();
        		getStudentsMarks();
        		JOptionPane.showMessageDialog(null,"Data refreshed!");
            }
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Exit");
		mntmNewMenuItem_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	int result = JOptionPane.showConfirmDialog(null, "Sure? You want to exit?", "Please confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            	if(result == JOptionPane.YES_NO_OPTION) {
            		System.exit(0);
            	}	
            }
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 210, 394, 2);
		panel.add(separator);
		
		JLabel lblNewLabel_7 = new JLabel("Student :");
		lblNewLabel_7.setBounds(10, 233, 81, 14);
		panel.add(lblNewLabel_7);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(215, 223, 137, 29);
		panel.add(comboBox);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(139, 66, 212, 29);
		panel.add(comboBox_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("If HOD");
		chckbxNewCheckBox.setBackground(Color.WHITE);
		chckbxNewCheckBox.setBounds(96, 275, 97, 23);
		panel.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("If CP");
		chckbxNewCheckBox_1.setBackground(Color.WHITE);
		chckbxNewCheckBox_1.setBounds(198, 275, 97, 23);
		panel.add(chckbxNewCheckBox_1);
		
		JLabel lblNewLabel_8 = new JLabel("Total Marks :");
		lblNewLabel_8.setBounds(414, 418, 130, 14);
		panel.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("0");
		lblNewLabel_9.setBounds(554, 418, 82, 14);
		panel.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Total marks of HOD :");
		lblNewLabel_10.setBounds(414, 442, 130, 14);
		panel.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("0");
		lblNewLabel_11.setBounds(554, 443, 46, 14);
		panel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Total marks of Students :");
		lblNewLabel_12.setBounds(414, 467, 130, 14);
		panel.add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel("0");
		lblNewLabel_13.setBounds(554, 467, 46, 14);
		panel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_8_1 = new JLabel("Average :");
		lblNewLabel_8_1.setBounds(646, 416, 101, 14);
		panel.add(lblNewLabel_8_1);
		
		lblNewLabel_9_1 = new JLabel("0");
		lblNewLabel_9_1.setBounds(757, 416, 46, 14);
		panel.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_14 = new JLabel("Lecturers : ");
		lblNewLabel_14.setBounds(646, 442, 66, 14);
		panel.add(lblNewLabel_14);
		
		comboBox_1_1 = new JComboBox<String>();
		comboBox_1_1.setBounds(733, 438, 212, 29);
		panel.add(comboBox_1_1);
		
		comboBox_1_1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
				try{

		            java.sql.Statement stmt1= maConnexion.ObtenirConnexion().createStatement();
		            java.sql.ResultSet resultat= stmt1.executeQuery("SELECT * FROM evaluations_record WHERE lecturer_name ='"+comboBox_1_1.getSelectedItem().toString()+"'");
			        
		            
		            float row_count = 0, average;
		            
		            while(resultat.next()) {
			        	row_count = row_count+1;
			        }
		            
		            average = marksSum / row_count;
		            
		            lblNewLabel_9_1.setText(average+ " %");
		            
			
		        }catch(Exception e1){
		    	   JOptionPane.showMessageDialog(null,"Error loading total incomes"+ e1.toString());
		        }
				
			}
		});
		
		chckbxNewCheckBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
					comboBox.setEnabled(false);
					evaluator = "HOD";
		        } else {//checkbox has been deselected
		        	comboBox.setEnabled(true);
		        	evaluator = comboBox.getSelectedItem().toString().trim();
		        };
			}
		});
		
		chckbxNewCheckBox_1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
					comboBox.setEnabled(false);
					evaluator = "CP";
		        } else {//checkbox has been deselected
		        	comboBox.setEnabled(true);
		        	evaluator = comboBox.getSelectedItem().toString().trim();
		        };
			}
		});
		fecthStudents();
		fecthLecturers();
		getMarks();
		getAverage();
		getStudentsMarks();
		getHODMarks();
	}
	
	public void fecthStudents() {
		 try{
			 comboBox.removeAllItems();
	         java.sql.Statement stmt1= maConnexion.ObtenirConnexion().createStatement();
	         java.sql.ResultSet resultat= stmt1.executeQuery("SELECT * FROM students_tb");
	         while(resultat.next()){                     
	        	 comboBox.addItem(resultat.getString("student_names")+"/"+resultat.getString("roll_number")); 
	         }
		
	       }catch(Exception e){
		
		
	       }
	}
	
	public void fecthLecturers() {
		 try{
			 comboBox_1.removeAllItems();
	         java.sql.Statement stmt1= maConnexion.ObtenirConnexion().createStatement();
	         java.sql.ResultSet resultat= stmt1.executeQuery("SELECT * FROM lecturers_tb");
	         while(resultat.next()){                     
	        	 comboBox_1.addItem(resultat.getString("lecturer_name")); 
	         }
		
	       }catch(Exception e){
		
		
	       }
		 
		 try{
			 comboBox_1_1.removeAllItems();
	         java.sql.Statement stmt1= maConnexion.ObtenirConnexion().createStatement();
	         java.sql.ResultSet resultat= stmt1.executeQuery("SELECT * FROM lecturers_tb");
	         while(resultat.next()){                     
	        	 comboBox_1_1.addItem(resultat.getString("lecturer_name")); 
	         }
		
	       }catch(Exception e){
		
		
	       }
	}
	
	public void getMarks() {
		System.out.println("Get marks function called");
		try{

            java.sql.Statement stmt1= maConnexion.ObtenirConnexion().createStatement();
            java.sql.ResultSet resultat= stmt1.executeQuery("SELECT ROUND(SUM(knowledge_points),2) FROM evaluations_record");
            
            java.sql.Statement stmt2= maConnexion.ObtenirConnexion().createStatement();
            java.sql.ResultSet resultat1 = stmt2.executeQuery("SELECT ROUND(SUM(teaching_points),2) FROM evaluations_record");
            
            java.sql.Statement stmt3= maConnexion.ObtenirConnexion().createStatement();
            java.sql.ResultSet resultat2 = stmt3.executeQuery("SELECT ROUND(SUM(ethical_points),2) FROM evaluations_record");
            
            while(resultat.next()) {
	        	marksSum = resultat.getFloat(1);
	        }
            
            while(resultat1.next()) {
            	marksSum = marksSum+resultat1.getFloat(1);
            }
            
            while(resultat2.next()) {
            	marksSum = marksSum+resultat2.getFloat(1);
            }
            
	        lblNewLabel_9.setText(marksSum+ " Pts");
            
	
        }catch(Exception e){
    	   JOptionPane.showMessageDialog(null,"Error loading total incomes"+ e.toString());
        }
	}
	
	public void getAverage() {
		System.out.println("Get average function called");
		try{

            java.sql.Statement stmt1= maConnexion.ObtenirConnexion().createStatement();
            java.sql.ResultSet resultat= stmt1.executeQuery("SELECT lecturer_name FROM evaluations_record");
	        
            
            float row_count = 0, average;
            
            while(resultat.next()) {
	        	row_count = row_count+1;
	        }
            
            average = marksSum / row_count;
            
            lblNewLabel_9_1.setText(average+ " %");
            
	
        }catch(Exception e){
    	   JOptionPane.showMessageDialog(null,"Error loading total incomes"+ e.toString());
        }
	}
	
	public void getHODMarks() {
		System.out.println("Get HOD marks function called");
		try{

            java.sql.Statement stmt1= maConnexion.ObtenirConnexion().createStatement();
            java.sql.ResultSet resultat= stmt1.executeQuery("SELECT ROUND(SUM(knowledge_points),2) FROM evaluations_record WHERE evaluator='"+HOD+"'");
            
            java.sql.Statement stmt2= maConnexion.ObtenirConnexion().createStatement();
            java.sql.ResultSet resultat1 = stmt2.executeQuery("SELECT ROUND(SUM(teaching_points),2) FROM evaluations_record WHERE evaluator='"+HOD+"'");
            
            java.sql.Statement stmt3= maConnexion.ObtenirConnexion().createStatement();
            java.sql.ResultSet resultat2 = stmt3.executeQuery("SELECT ROUND(SUM(ethical_points),2) FROM evaluations_record WHERE evaluator='"+HOD+"'");
            
            while(resultat.next()) {
	        	marksSum = resultat.getFloat(1);
	        }
            
            while(resultat1.next()) {
            	marksSum = marksSum+resultat1.getFloat(1);
            }
            
            while(resultat2.next()) {
            	marksSum = marksSum+resultat2.getFloat(1);
            }
            
            lblNewLabel_11.setText(marksSum+ " Pts");
            
	
        }catch(Exception e){
    	   JOptionPane.showMessageDialog(null,"Error loading total incomes"+ e.toString());
        }
	}
	
	public void getStudentsMarks() {
		System.out.println("Get Students marks function called");
		try{

            java.sql.Statement stmt1= maConnexion.ObtenirConnexion().createStatement();
            java.sql.ResultSet resultat= stmt1.executeQuery("SELECT ROUND(SUM(knowledge_points),2) FROM evaluations_record WHERE evaluator<>'"+HOD+"'");
            
            java.sql.Statement stmt2= maConnexion.ObtenirConnexion().createStatement();
            java.sql.ResultSet resultat1 = stmt2.executeQuery("SELECT ROUND(SUM(teaching_points),2) FROM evaluations_record WHERE evaluator<>'"+HOD+"'");
            
            java.sql.Statement stmt3= maConnexion.ObtenirConnexion().createStatement();
            java.sql.ResultSet resultat2 = stmt3.executeQuery("SELECT ROUND(SUM(ethical_points),2) FROM evaluations_record WHERE evaluator<>'"+HOD+"'");
            
            while(resultat.next()) {
	        	marksSum = resultat.getFloat(1);
	        }
            
            while(resultat1.next()) {
            	marksSum = marksSum+resultat1.getFloat(1);
            }
            
            while(resultat2.next()) {
            	marksSum = marksSum+resultat2.getFloat(1);
            }
            
            lblNewLabel_13.setText(marksSum+ " Pts");
            
	
        }catch(Exception e){
    	   JOptionPane.showMessageDialog(null,"Error loading total incomes"+ e.toString());
        }
	}
}
