import java.awt.EventQueue; 

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {
	Connection conn = null;
	
	PreparedStatement pst = null;

	private JFrame frame;
	private JTextField txtEnterusername;
	private JLabel lblPassword;
	private JTextField txtEnterpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username : ");
		lblUsername.setBounds(75, 53, 101, 37);
		frame.getContentPane().add(lblUsername);
		
		txtEnterusername = new JTextField();
		txtEnterusername.setBounds(168, 62, 155, 19);
		frame.getContentPane().add(txtEnterusername);
		txtEnterusername.setColumns(10);
		
		lblPassword = new JLabel("Password : ");
		lblPassword.setBounds(75, 102, 101, 29);
		frame.getContentPane().add(lblPassword);
		
		txtEnterpassword = new JTextField();
		txtEnterpassword.setBounds(168, 107, 155, 19);
		frame.getContentPane().add(txtEnterpassword);
		txtEnterpassword.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String sql = "select * from acclogin where un=? and pw =?";
					pst = conn.prepareStatement(sql);
					pst.setString(1,txtEnterusername.getText());
					pst.setString(2,txtEnterpassword.getText());
					ResultSet rs = pst.executeQuery();
					int count=0;
					while(rs.next())
					{
						count++;
					}
					
					if(count>0)
					{
						JOptionPane.showMessageDialog(null, "Login Success...");
						ActionListWindow alw = new ActionListWindow();
						frame.dispose();
						alw.setVisible(true);
					}
					else if(count==0)
					{
						JOptionPane.showMessageDialog(null, "Invalid Credentials...");
					}
					
						
				}catch(Exception ce)
				{
					JOptionPane.showMessageDialog(null, ce);
					ce.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(169, 159, 117, 25);
		frame.getContentPane().add(btnLogin);
	}
}
