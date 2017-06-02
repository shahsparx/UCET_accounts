import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AdmissionWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField txtGenscstobc;
	Connection conn = null;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public void CloseFrame(){
	    super.dispose();
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdmissionWindow frame = new AdmissionWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdmissionWindow() {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://sql6.freesqldatabase.com:3306/sql6145950","sql6145950","p7y5CKPjir");
		}catch(ClassNotFoundException e)
		{
			System.out.println("Where is your Mysql JDBC Driver?");
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			System.out.println("Connection Failed");
			e.printStackTrace();
		}
		if (conn != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1024,768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterStudentDetails = new JLabel("ENTER  STUDENT  DETAILS");
		lblEnterStudentDetails.setFont(new Font("Dialog", Font.BOLD, 15));
		lblEnterStudentDetails.setBounds(397, 23, 229, 15);
		contentPane.add(lblEnterStudentDetails);
		
		JLabel lblName = new JLabel("Name :   *");
		lblName.setBounds(73, 75, 70, 15);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(186, 73, 349, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblRoll = new JLabel("Roll :  *");
		lblRoll.setBounds(73, 118, 70, 15);
		contentPane.add(lblRoll);
		
		textField_1 = new JTextField();
		textField_1.setBounds(186, 116, 349, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblBranch = new JLabel("Branch :  *");
		lblBranch.setBounds(73, 164, 84, 15);
		contentPane.add(lblBranch);
		
		textField_2 = new JTextField();
		textField_2.setBounds(186, 162, 349, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblSessionStart = new JLabel("Session :  *");
		lblSessionStart.setBounds(73, 208, 105, 15);
		contentPane.add(lblSessionStart);
		
		textField_3 = new JTextField();
		textField_3.setBounds(186, 206, 70, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblGentfw = new JLabel("GEN/TFW :  *");
		lblGentfw.setBounds(73, 291, 105, 15);
		contentPane.add(lblGentfw);
		
		textField_5 = new JTextField();
		textField_5.setBounds(186, 289, 349, 19);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address :  *");
		lblAddress.setBounds(73, 335, 105, 15);
		contentPane.add(lblAddress);
		
		textField_6 = new JTextField();
		textField_6.setBounds(186, 335, 349, 52);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblMobileNo = new JLabel("Mobile No. :  *");
		lblMobileNo.setBounds(73, 414, 105, 15);
		contentPane.add(lblMobileNo);
		
		textField_7 = new JTextField();
		textField_7.setBounds(186, 412, 349, 19);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblFathersName = new JLabel("Father's Name :");
		lblFathersName.setBounds(74, 457, 126, 15);
		contentPane.add(lblFathersName);
		
		JLabel lblMothersName = new JLabel("Mother's Name :");
		lblMothersName.setBounds(73, 491, 127, 15);
		contentPane.add(lblMothersName);
		
		textField_8 = new JTextField();
		textField_8.setBounds(186, 457, 349, 19);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(186, 489, 349, 19);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblEMailId = new JLabel("e mail id :  *");
		lblEMailId.setBounds(73, 533, 105, 15);
		contentPane.add(lblEMailId);
		
		textField_10 = new JTextField();
		textField_10.setBounds(186, 531, 349, 19);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblCategory = new JLabel("Category :  *");
		lblCategory.setBounds(73, 574, 105, 15);
		contentPane.add(lblCategory);
		
		txtGenscstobc = new JTextField();
		txtGenscstobc.setBounds(186, 572, 349, 19);
		contentPane.add(txtGenscstobc);
		txtGenscstobc.setColumns(10);
		
		JButton btnSubmitAdmissionForm = new JButton("Submit Admission Form");
		btnSubmitAdmissionForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				String name = textField.getText().toString().toLowerCase();
				int roll = Integer.parseInt(textField_1.getText());
				String branch = textField_2.getText().toUpperCase();
				int session_start = Integer.parseInt(textField_3.getText());
				int session_end = Integer.parseInt(textField_4.getText());
				String fee_cat = textField_5.getText().toUpperCase();
				String address = textField_6.getText().toLowerCase();
				long mob = Long.parseLong(textField_7.getText());
				String fname = textField_8.getText().toLowerCase();
				String mname = textField_9.getText().toLowerCase();
				String email = textField_10.getText().toLowerCase();
				String category = txtGenscstobc.getText().toUpperCase();
			
				
				
				
				
				
					String sql = "INSERT INTO ucet_students VALUES("+roll+"," + "'"+name+ "'" + "," + session_start+ "," + session_end + "," + "'" + branch + "'"+ "," + "'" + fee_cat + "'" + "," + "'" + fname + "'" + "," + "'" + mname + "'" + "," + "'" + category + "'" + ","+ mob + "," + "'" + address + "'" + "," + "'" + email + "'" +")";
					Statement st = (Statement) conn.createStatement();
					int n = st.executeUpdate(sql);
					System.out.println(n + " " + "record inserted...");
					
					if(n==1)
					{
						JOptionPane.showMessageDialog(null,"Record Inserted Successfully...","Insert",JOptionPane.OK_OPTION);
						conn.close();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Record Insertion Unsuccessful ! Contact Admin ","Not Inserted",JOptionPane.CANCEL_OPTION);
						conn.close();
					}
					
					CloseFrame();
					
					
				}
				catch(MySQLIntegrityConstraintViolationException dpk)
				{
					JOptionPane.showMessageDialog(null,"Possible Errors : \n 1.Duplicate Roll number, or \n 2.Invalid Branch or \n 3. Invalid input for 'GEN/TFW' or \n 4. Invalid input for Category .","Not Inserted",JOptionPane.CANCEL_OPTION);

				}
				catch(NumberFormatException nfe)
				{
					JOptionPane.showMessageDialog(null,"Error ! Fill up the '*' marked columns...","Not Inserted",JOptionPane.CANCEL_OPTION);

				}
				catch(Exception ze)
				{
					ze.printStackTrace();
					JOptionPane.showMessageDialog(null,"Error ! Read Hints Carefully...","Not Inserted",JOptionPane.CANCEL_OPTION);
				}
				
			}
		});
		btnSubmitAdmissionForm.setBounds(390, 621, 244, 46);
		contentPane.add(btnSubmitAdmissionForm);
		
		JLabel lblhintRoll = new JLabel("[HINT] : ROLL numbers must be Numerical Digits only, ex 1309144 ");
		lblhintRoll.setBounds(541, 118, 471, 15);
		contentPane.add(lblhintRoll);
		
		JLabel lblSelectYourBranch = new JLabel("Select Your Branch From : [   ME, CSE, ECE, IT  ]");
		lblSelectYourBranch.setBounds(541, 164, 361, 15);
		contentPane.add(lblSelectYourBranch);
		
		JLabel lblSelectFrom = new JLabel("Select From : [  GEN , TFW  ]");
		lblSelectFrom.setBounds(541, 291, 321, 15);
		contentPane.add(lblSelectFrom);
		
		JLabel lblEnterYourAddress = new JLabel("ENTER your Address here (Max 50 characters)");
		lblEnterYourAddress.setBounds(541, 353, 326, 15);
		contentPane.add(lblEnterYourAddress);
		
		JLabel lblEnterYour = new JLabel("ENTER your 10 digit Mobile number");
		lblEnterYour.setBounds(540, 414, 294, 15);
		contentPane.add(lblEnterYour);
		
		JLabel lblEnterYourEmail = new JLabel("ENTER your e-mail id ( example : username@service.com)");
		lblEnterYourEmail.setBounds(539, 533, 413, 15);
		contentPane.add(lblEnterYourEmail);
		
		JLabel lblNewLabel = new JLabel("Select From :  [  GEN, ST, SC, OBC  ]");
		lblNewLabel.setBounds(541, 574, 321, 15);
		contentPane.add(lblNewLabel);
		
		textField_4 = new JTextField();
		textField_4.setBounds(268, 206, 70, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label = new JLabel("-");
		label.setFont(new Font("Dialog", Font.BOLD, 24));
		label.setBounds(258, 208, 38, 15);
		contentPane.add(label);
		
		JLabel lblSessionStartYear = new JLabel("[HINT] [Session Start Year - Session End Year]");
		lblSessionStartYear.setBounds(186, 235, 380, 15);
		contentPane.add(lblSessionStartYear);
		
		
	}
}
