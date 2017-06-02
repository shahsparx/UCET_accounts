import java.awt.BorderLayout; 
import java.awt.EventQueue;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Defaulters extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Connection conn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Defaulters frame = new Defaulters();
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
	public Defaulters() {
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("sql6.freesqldatabase.com:3306/sql6145950","sql6145950","p7y5CKPjir");
			
			String sql = "SELECT * from ucet_students";
			Statement query = (Statement)conn.createStatement();
			ResultSet rs = (ResultSet) query.executeQuery(sql);
			table.setModel((TableModel) rs);
			
			
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
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 12, 964, 681);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
	}
}
