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

public class MainView {

	private JFrame frame;
	private JTextField textField_1;
	private com.toedter.calendar.JDateChooser product_expiry_date;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField textField_2;
	private JLabel lblNewLabel_5;
	private JTextField textField_3;
	private JLabel lblNewLabel_6;
	private JTextField textField_4;
	private javax.swing.JScrollPane jScrollPane1;
	
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
		            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (InstantiationException ex) {
		            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (IllegalAccessException ex) {
		            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
		            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        }
				// Look and feel
				
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
		getData();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	Statement stmt;
    Connexion maConnexion= new Connexion();
    private JTable table;
    public JComboBox<String> comboBox;
    private JComboBox<String> comboBox_1;
    private JMenuItem mntmNewMenuItem_2;
    
    public void getData(){
        try{

            java.sql.Statement stmt1= maConnexion.ObtenirConnexion().createStatement();
            java.sql.ResultSet resultat= stmt1.executeQuery("SELECT * FROM evaluations_record");
            table.setModel(DbUtils.resultSetToTableModel(resultat));
	
	
       }catch(Exception e){
	
	
       }
    }
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1003, 555);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 984, 516);
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel);
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
		
		lblNewLabel_4 = new JLabel("Knowledge and Competence :");
		lblNewLabel_4.setBounds(10, 329, 183, 14);
		panel.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(214, 322, 137, 29);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Teaching skills/ Methodology :");
		lblNewLabel_5.setBounds(10, 370, 173, 14);
		panel.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(214, 363, 137, 29);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Ethical Values :");
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
			            String requete="INSERT INTO evaluations_record(lecturer_name, course_name, evaluation_date, knowledge_points, teaching_points, ethical_points)value ('"+lecturer_name_recup+"','"+course_name_recup+"','"+evaluation_date_recup+"','"+knowledge_points_recup+"','"+teaching_skills_recup+"','"+ethical_values_recup+"')";
			            stmt=maConnexion.ObtenirConnexion().createStatement();
			            stmt.executeUpdate(requete);
			            getData();
			            JOptionPane.showMessageDialog(null,"Record saved successfully!");
			            textField_1.setText("");
			            textField_2.setText("");
			            textField_3.setText("");
			            textField_4.setText("");
			        product_expiry_date.setDate(new Date());
			            }catch(SQLException | HeadlessException e1) {
			            	JOptionPane.showMessageDialog(null, "Something went wrong");
			            	System.out.println(e1);
			            }
			        }else {
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
            }
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
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
		
		chckbxNewCheckBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
					comboBox.setEnabled(false);
		        } else {//checkbox has been deselected
		        	comboBox.setEnabled(true);
		        };
			}
		});
		
		chckbxNewCheckBox_1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
					comboBox.setEnabled(false);
		        } else {//checkbox has been deselected
		        	comboBox.setEnabled(true);
		        };
			}
		});
		fecthStudents();
		fecthLecturers();
		
	}
	
	public void fecthStudents() {
		 try{

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

	         java.sql.Statement stmt1= maConnexion.ObtenirConnexion().createStatement();
	         java.sql.ResultSet resultat= stmt1.executeQuery("SELECT * FROM lecturers_tb");
	         while(resultat.next()){                     
	        	 comboBox_1.addItem(resultat.getString("lecturer_name")); 
	         }
		
	       }catch(Exception e){
		
		
	       }
	}
}
