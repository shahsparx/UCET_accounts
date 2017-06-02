import java.awt.EventQueue;  
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ViewRecordsWindow extends JFrame {

	
	private static final long serialVersionUID = 11;
	private JPanel contentPane;
	private JTextField textField;
	Connection conn = null;
	ResultSet rs;
	int payment_for_cat;
	int total_paid;
	int total_due;
	String fee_cat;
	String dt;
	int session_start;
	String dt_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewRecordsWindow frame = new ViewRecordsWindow();
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
	public ViewRecordsWindow() {
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
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "name_20832181349025");
		panel.setLayout(null);
		
		JLabel label = new JLabel("ENTER ROLL NUMBER OF THE STUDENT ");
		label.setFont(new Font("Lato Medium", Font.BOLD, 26));
		label.setBounds(212, 12, 589, 56);
		panel.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("Lato Black", Font.BOLD, 75));
		textField.setColumns(10);
		textField.setBounds(286, 83, 442, 79);
		panel.add(textField);
		
		JButton button = new JButton("PROCEED");
		
		button.setFont(new Font("Dialog", Font.BOLD, 26));
		button.setBounds(414, 180, 186, 79);
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, "name_20843322225980");
		panel_1.setLayout(null);
		
		JLabel lblStudentRecord = new JLabel("STUDENT RECORD");
		lblStudentRecord.setFont(new Font("Century Schoolbook L", Font.BOLD, 47));
		lblStudentRecord.setBounds(258, 27, 498, 54);
		panel_1.add(lblStudentRecord);
		
		JLabel lblName = new JLabel("Name         :");
		lblName.setFont(new Font("L M Sans Quot8", Font.BOLD, 18));
		lblName.setBounds(12, 93, 143, 15);
		panel_1.add(lblName);
		
		JLabel lblBranch = new JLabel("Branch       :");
		lblBranch.setFont(new Font("L M Sans Quot8", Font.BOLD, 18));
		lblBranch.setBounds(12, 130, 143, 15);
		panel_1.add(lblBranch);
		
		JLabel lblRollNumber = new JLabel("Roll Number :");
		lblRollNumber.setFont(new Font("L M Sans Quot8", Font.BOLD, 18));
		lblRollNumber.setBounds(12, 211, 143, 15);
		panel_1.add(lblRollNumber);
		
		JLabel lblFathersName = new JLabel("Father's Name  :");
		lblFathersName.setFont(new Font("L M Sans Quot8", Font.BOLD, 18));
		lblFathersName.setBounds(528, 93, 179, 15);
		panel_1.add(lblFathersName);
		
		JLabel lblMothersName = new JLabel("Mother's Name :");
		lblMothersName.setFont(new Font("L M Sans Quot8", Font.BOLD, 18));
		lblMothersName.setBounds(528, 130, 179, 15);
		panel_1.add(lblMothersName);
		
		JLabel lblAddress = new JLabel("Address           :");
		lblAddress.setFont(new Font("L M Sans Quot8", Font.BOLD, 18));
		lblAddress.setBounds(528, 169, 179, 15);
		panel_1.add(lblAddress);
		
		JLabel lblEmail = new JLabel("e-mail             :");
		lblEmail.setFont(new Font("L M Sans Quot8", Font.BOLD, 18));
		lblEmail.setBounds(528, 211, 179, 15);
		panel_1.add(lblEmail);
		
		JLabel lblMobileNumber = new JLabel("Mobile number  :");
		lblMobileNumber.setFont(new Font("L M Sans Quot8", Font.BOLD, 18));
		lblMobileNumber.setBounds(528, 250, 179, 15);
		panel_1.add(lblMobileNumber);
		
		JLabel lblCatefory = new JLabel("Category     :");
		lblCatefory.setFont(new Font("L M Sans Quot8", Font.BOLD, 18));
		lblCatefory.setBounds(12, 250, 143, 15);
		panel_1.add(lblCatefory);
		
		JLabel lblSession = new JLabel("Session       :");
		lblSession.setFont(new Font("L M Sans Quot8", Font.BOLD, 18));
		lblSession.setBounds(12, 169, 143, 15);
		panel_1.add(lblSession);
		
		JLabel lblFeeDetails = new JLabel("FEE DETAILS");
		lblFeeDetails.setFont(new Font("Century Schoolbook L", Font.BOLD, 22));
		lblFeeDetails.setBounds(421, 317, 172, 23);
		panel_1.add(lblFeeDetails);
		
		JLabel lblFeeCategory = new JLabel("Fee Category                  :");
		lblFeeCategory.setFont(new Font("Lato Heavy", Font.PLAIN, 25));
		lblFeeCategory.setBounds(46, 404, 273, 31);
		panel_1.add(lblFeeCategory);
		
		JLabel lblTotalPaymentDue = new JLabel("Total Payment Due       :");
		lblTotalPaymentDue.setFont(new Font("Lato Heavy", Font.PLAIN, 25));
		lblTotalPaymentDue.setBounds(46, 473, 273, 31);
		panel_1.add(lblTotalPaymentDue);
		
		JLabel lblTotalFeeAmount = new JLabel("Total Fee Amount paid :");
		lblTotalFeeAmount.setFont(new Font("Lato Heavy", Font.PLAIN, 25));
		lblTotalFeeAmount.setBounds(46, 535, 273, 31);
		panel_1.add(lblTotalFeeAmount);
		
		JLabel lblTodaysDate = new JLabel("Today's Date :");
		lblTodaysDate.setFont(new Font("Lato Heavy", Font.PLAIN, 25));
		lblTodaysDate.setBounds(592, 404, 158, 31);
		panel_1.add(lblTodaysDate);
		
		JLabel lblCurrentSemester = new JLabel("Current Semester      :");
		lblCurrentSemester.setFont(new Font("Lato Heavy", Font.PLAIN, 25));
		lblCurrentSemester.setBounds(592, 535, 240, 31);
		panel_1.add(lblCurrentSemester);
		
		JLabel lblCurrentCourseYear = new JLabel("Current Course Year :");
		lblCurrentCourseYear.setFont(new Font("Lato Heavy", Font.PLAIN, 25));
		lblCurrentCourseYear.setBounds(592, 473, 240, 31);
		panel_1.add(lblCurrentCourseYear);
		
		JLabel lblFeePaidTill = new JLabel("Fee paid till                 :");
		lblFeePaidTill.setFont(new Font("Lato Heavy", Font.PLAIN, 25));
		lblFeePaidTill.setBounds(592, 592, 237, 31);
		panel_1.add(lblFeePaidTill);
		
		JLabel lblTotalFeeDue = new JLabel("Total Fee Due                 :");
		lblTotalFeeDue.setFont(new Font("Lato Heavy", Font.PLAIN, 25));
		lblTotalFeeDue.setBounds(46, 592, 273, 31);
		panel_1.add(lblTotalFeeDue);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		lblNewLabel.setBounds(167, 93, 349, 15);
		panel_1.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		label_1.setBounds(167, 130, 349, 15);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		label_2.setBounds(167, 169, 349, 15);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("New label");
		label_3.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		label_3.setBounds(167, 211, 349, 15);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("New label");
		label_4.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		label_4.setBounds(167, 250, 349, 15);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("New label");
		label_5.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		label_5.setBounds(709, 93, 273, 15);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("New label");
		label_6.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		label_6.setBounds(709, 130, 273, 15);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("New label");
		label_7.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		label_7.setBounds(709, 169, 273, 15);
		panel_1.add(label_7);
		
		JLabel label_8 = new JLabel("New label");
		label_8.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		label_8.setBounds(709, 211, 273, 15);
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("New label");
		label_9.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		label_9.setBounds(709, 250, 273, 15);
		panel_1.add(label_9);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("DejaVu Sans", Font.BOLD, 18));
		lblNewLabel_1.setBounds(331, 417, 262, 15);
		panel_1.add(lblNewLabel_1);
		
		JLabel label_10 = new JLabel("New label");
		label_10.setFont(new Font("DejaVu Sans", Font.BOLD, 18));
		label_10.setBounds(331, 486, 262, 15);
		panel_1.add(label_10);
		
		JLabel label_11 = new JLabel("New label");
		label_11.setFont(new Font("DejaVu Sans", Font.BOLD, 18));
		label_11.setBounds(331, 548, 262, 15);
		panel_1.add(label_11);
		
		JLabel label_12 = new JLabel("New label");
		label_12.setFont(new Font("DejaVu Sans", Font.BOLD, 18));
		label_12.setBounds(331, 605, 262, 15);
		panel_1.add(label_12);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setFont(new Font("DejaVu Sans", Font.BOLD, 18));
		lblNewLabel_2.setBounds(762, 417, 240, 15);
		panel_1.add(lblNewLabel_2);
		
		JLabel label_13 = new JLabel("New label");
		label_13.setFont(new Font("DejaVu Sans", Font.BOLD, 18));
		label_13.setBounds(836, 486, 166, 15);
		panel_1.add(label_13);
		
		JLabel label_14 = new JLabel("New label");
		label_14.setFont(new Font("DejaVu Sans", Font.BOLD, 18));
		label_14.setBounds(836, 548, 166, 15);
		panel_1.add(label_14);
		
		JLabel label_15 = new JLabel("New label");
		label_15.setFont(new Font("DejaVu Sans", Font.BOLD, 18));
		label_15.setBounds(836, 605, 166, 15);
		panel_1.add(label_15);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String sql1 = "SELECT * from ucet_students where roll="+textField.getText();
					Statement query1 = (Statement)conn.createStatement();
					rs = (ResultSet) query1.executeQuery(sql1);
					
					while(rs.next())
					{
						fee_cat = rs.getString("categ_fee");
						
						lblNewLabel.setText(rs.getString("name"));
						label_1.setText(rs.getString("branch"));
						session_start = Integer.parseInt(rs.getString("session_start"));
						label_2.setText(session_start+"-"+rs.getString("session_end"));
						label_3.setText(rs.getString("roll"));
						label_4.setText(rs.getString("cat"));
						label_5.setText(rs.getString("f_name"));
						label_6.setText(rs.getString("m_name"));
						label_7.setText(rs.getString("address"));
						label_8.setText(rs.getString("email"));
						label_9.setText(rs.getString("mob"));
					}
					
					String sqlq2 = "SELECT payment_for_cat from cat_fee where fee_category = "+"'"+fee_cat + "'";
					Statement query2 = (Statement)conn.createStatement();
					ResultSet rs1 = (ResultSet) query2.executeQuery(sqlq2);
					while(rs1.next())
					{
						lblNewLabel_1.setText(fee_cat);
						payment_for_cat = Integer.parseInt(rs1.getString("payment_for_cat"));
						label_10.setText(""+payment_for_cat);
					}
					
					
					String sqlq3 = "SELECT sum(amount) from payments where roll_no="+textField.getText();
					Statement query3 = (Statement)conn.createStatement();
					ResultSet rs2 = (ResultSet) query3.executeQuery(sqlq3);
					while(rs2.next())
					{
						total_paid = Integer.parseInt(rs2.getString("sum(amount)"));
						
					}
					total_due = payment_for_cat-total_paid;
					label_11.setText(""+total_paid);
					label_12.setText(""+total_due);
					int fee_per_sem=payment_for_cat/8;
					
					if(fee_cat.equals("GEN")||fee_cat.equals("TFW"))
					{
						int nsems=0;
						int frac=total_paid/fee_per_sem;
						if(frac>=1&&frac<2)
						{
							nsems =1;
						}
						else if(frac>=2&&frac<3)
						{
							nsems=2;
						}
						else if(frac>=3&&frac<4)
						{
							nsems=3;
						}
						else if(frac>=4&&frac<5)
						{
							nsems=4;
						}
						else if(frac>=5&&frac<6)
						{
							nsems=5;
						}
						else if(frac>=6&&frac<7)
						{
							nsems=6;
						}
						else if(frac>=7&&frac<8)
						{
							nsems=7;
						}
						else if(frac>=8&&frac<9)
						{
							nsems=8;
						}
						
						label_15.setText("" +nsems + " semesters");
						
						String sqlq4 = "SELECT sysdate()";
						Statement query4 = (Statement)conn.createStatement();
						ResultSet rs4= (ResultSet) query4.executeQuery(sqlq4);
						while(rs4.next())
						{
							dt_1 = rs4.getString("sysdate()");
						}
						lblNewLabel_2.setText(dt_1);
						
						
						String sqlq5 = "SELECT year(sysdate())";
						Statement query5 = (Statement)conn.createStatement();
						ResultSet rs5= (ResultSet) query5.executeQuery(sqlq5);
						while(rs5.next())
						{
							dt = rs5.getString("year(sysdate())");
						}
						int curr_year=Integer.valueOf(dt)-session_start+1;
						label_13.setText(""+curr_year);
						
						if(curr_year==1)
						{
							label_14.setText("1st or 2nd");
						}
						else if(curr_year==2)
						{
							label_14.setText("3rd or 4th");
						}
						else if(curr_year==3)
						{
							label_14.setText("5th or 6th");
						}
						else if(curr_year==4)
						{
							label_14.setText("7th or 8th");
						}
					}
					
				}
				catch(Exception eb)
				{
					eb.printStackTrace();
				}
				panel.setVisible(false);
				panel_1.setVisible(true);
				
			}
		});
	}
}
