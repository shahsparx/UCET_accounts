import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import java.awt.CardLayout;
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
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class FeePaymentWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldRoll;
	Connection conn = null;
	ResultSet rs;
	
	String name;
	String fname;
	int roll;
	String branch;
	int session_start;
	int session_end;
	String category;
	int payment_due;
	String fee_cat;
	int payment_for_cat;
	private JTextField textField_chamt;
	private JTextField textField_challan_no;
	private JTextField txtDd;
	private JTextField txtMm;
	private JTextField txtYyyy;
	int challan_no;
	int challan_amt;
	String challan_dt;
	int total_paid;
	int total_due;
	String dt;

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
					FeePaymentWindow frame = new FeePaymentWindow();
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
	public FeePaymentWindow() {
		
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
		contentPane.add(panel, "name_6477445946376");
		panel.setLayout(null);
		panel.setVisible(true);
		
		JLabel lblEnterRollNumber = new JLabel("ENTER ROLL NUMBER OF THE STUDENT ");
		lblEnterRollNumber.setFont(new Font("Lato Medium", Font.BOLD, 26));
		lblEnterRollNumber.setBounds(212, 0, 589, 56);
		panel.add(lblEnterRollNumber);
		
		textFieldRoll = new JTextField();
		textFieldRoll.setFont(new Font("Lato Black", Font.BOLD, 75));
		textFieldRoll.setBounds(288, 68, 438, 79);
		panel.add(textFieldRoll);
		textFieldRoll.setColumns(10);

		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, "name_6490606118755");
		panel_1.setLayout(null);
		
		JButton btnProceed = new JButton("PROCEED");
		btnProceed.setFont(new Font("Dialog", Font.BOLD, 26));
		btnProceed.setBounds(421, 169, 172, 79);
		panel.add(btnProceed);
		
		
		
		JLabel lblFeeCategory = new JLabel("FEE Category                     :");
		lblFeeCategory.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		lblFeeCategory.setBounds(585, 49, 182, 15);
		panel_1.add(lblFeeCategory);
		
		JLabel lblNewLabel = new JLabel("Category          :");
		lblNewLabel.setFont(new Font("DejaVu Sans", Font.BOLD, 15));
		lblNewLabel.setBounds(23, 155, 138, 15);
		panel_1.add(lblNewLabel);
		
		JLabel lblTotalAmountPayable = new JLabel("TOTAL AMOUNT PAYABLE :");
		lblTotalAmountPayable.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		lblTotalAmountPayable.setBounds(585, 22, 182, 15);
		panel_1.add(lblTotalAmountPayable);
		
		JLabel lblAmounttotal = new JLabel("AMOUNT_TOTAL");
		lblAmounttotal.setFont(new Font("Lato Heavy", Font.PLAIN, 18));
		lblAmounttotal.setBounds(779, 22, 211, 15);
		panel_1.add(lblAmounttotal);
		
		JLabel lblStudentName = new JLabel("Student Name :");
		lblStudentName.setFont(new Font("DejaVu Sans", Font.BOLD, 15));
		lblStudentName.setBounds(23, 22, 138, 15);
		panel_1.add(lblStudentName);
		
		JLabel lblName = new JLabel(name);
		lblName.setFont(new Font("Lato Heavy", Font.PLAIN, 18));
		lblName.setBounds(162, 22, 394, 15);
		panel_1.add(lblName);
		
		JLabel lblFathersName = new JLabel("Father's name :");
		lblFathersName.setFont(new Font("DejaVu Sans", Font.BOLD, 15));
		lblFathersName.setBounds(23, 49, 138, 15);
		panel_1.add(lblFathersName);
		
		JLabel lblFname = new JLabel(fname);
		lblFname.setFont(new Font("Lato Heavy", Font.PLAIN, 18));
		lblFname.setBounds(162, 49, 394, 15);
		panel_1.add(lblFname);
		
		JLabel lblBranch = new JLabel("Branch             :");
		lblBranch.setFont(new Font("DejaVu Sans", Font.BOLD, 15));
		lblBranch.setBounds(23, 103, 138, 15);
		panel_1.add(lblBranch);
		
		JLabel lblBranch_1 = new JLabel(branch);
		lblBranch_1.setFont(new Font("Lato Heavy", Font.PLAIN, 18));
		lblBranch_1.setBounds(162, 103, 394, 15);
		panel_1.add(lblBranch_1);
		
		JLabel lblRollNumber = new JLabel("Roll number     :");
		lblRollNumber.setFont(new Font("DejaVu Sans", Font.BOLD, 15));
		lblRollNumber.setBounds(23, 76, 138, 15);
		panel_1.add(lblRollNumber);
		
		JLabel lblRoll = new JLabel(textFieldRoll.getText());
		lblRoll.setFont(new Font("Lato Heavy", Font.PLAIN, 18));
		lblRoll.setBounds(162, 76, 394, 15);
		panel_1.add(lblRoll);
		
		JLabel lblSession = new JLabel("Session            :");
		lblSession.setFont(new Font("DejaVu Sans", Font.BOLD, 15));
		lblSession.setBounds(23, 128, 138, 15);
		panel_1.add(lblSession);
		
		JLabel lblSession_1 = new JLabel(""+session_start + "-" + session_end);
		lblSession_1.setFont(new Font("Lato Heavy", Font.PLAIN, 18));
		lblSession_1.setBounds(162, 130, 394, 15);
		panel_1.add(lblSession_1);
		
		JLabel lblCategory = new JLabel(category);
		lblCategory.setFont(new Font("Lato Heavy", Font.PLAIN, 18));
		lblCategory.setBounds(162, 155, 394, 15);
		panel_1.add(lblCategory);
		
		JLabel lblFeecat = new JLabel(fee_cat);
		lblFeecat.setFont(new Font("Lato Heavy", Font.PLAIN, 18));
		lblFeecat.setBounds(779, 49, 211, 15);
		panel_1.add(lblFeecat);
		
		JLabel lblTotalAmountPaid = new JLabel("TOTAL AMOUNT PAID        :");
		lblTotalAmountPaid.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		lblTotalAmountPaid.setBounds(585, 76, 182, 15);
		panel_1.add(lblTotalAmountPaid);
		
		JLabel lblTap = new JLabel(""+payment_due);
		lblTap.setFont(new Font("Lato Heavy", Font.PLAIN, 18));
		lblTap.setBounds(779, 76, 211, 15);
		panel_1.add(lblTap);
		
		JLabel lblTotalAmountDue = new JLabel("TOTAL AMOUNT DUE         :");
		lblTotalAmountDue.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		lblTotalAmountDue.setBounds(585, 103, 182, 15);
		panel_1.add(lblTotalAmountDue);
		
		JLabel lblTad = new JLabel("tad");
		lblTad.setFont(new Font("Lato Heavy", Font.PLAIN, 18));
		lblTad.setBounds(779, 103, 211, 15);
		panel_1.add(lblTad);
		
		JLabel lblFeePayedTill = new JLabel("Fee Paid till                       :");
		lblFeePayedTill.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		lblFeePayedTill.setBounds(585, 132, 182, 15);
		panel_1.add(lblFeePayedTill);
		
		JLabel lblNsem = new JLabel("nsem");
		lblNsem.setFont(new Font("Lato Heavy", Font.PLAIN, 18));
		lblNsem.setBounds(779, 132, 211, 15);
		panel_1.add(lblNsem);
		
		JLabel lblTodaysDate = new JLabel("Today's date                     :");
		lblTodaysDate.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		lblTodaysDate.setBounds(585, 155, 182, 15);
		panel_1.add(lblTodaysDate);
		
		JLabel lblDate = new JLabel("date");
		lblDate.setFont(new Font("Lato Heavy", Font.PLAIN, 18));
		lblDate.setBounds(779, 155, 211, 15);
		panel_1.add(lblDate);
		
		JLabel lblFeePayment = new JLabel("FEE PAYMENT");
		lblFeePayment.setBackground(SystemColor.desktop);
		lblFeePayment.setFont(new Font("Lato", Font.PLAIN, 45));
		lblFeePayment.setBounds(375, 224, 311, 60);
		panel_1.add(lblFeePayment);
		
		JLabel lblChallanNumber = new JLabel("CHALLAN NUMBER  :");
		lblChallanNumber.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 27));
		lblChallanNumber.setBounds(213, 331, 282, 67);
		panel_1.add(lblChallanNumber);
		
		textField_chamt = new JTextField();
		textField_chamt.setBounds(513, 420, 361, 60);
		panel_1.add(textField_chamt);
		textField_chamt.setColumns(10);
		
		JLabel lblChallanAmount = new JLabel("CHALLAN AMOUNT  :");
		lblChallanAmount.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 27));
		lblChallanAmount.setBounds(213, 411, 282, 67);
		panel_1.add(lblChallanAmount);
		
		JLabel lblChallanDate = new JLabel("CHALLAN DATE    :");
		lblChallanDate.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 27));
		lblChallanDate.setBounds(213, 494, 282, 67);
		panel_1.add(lblChallanDate);
		
		textField_challan_no = new JTextField();
		textField_challan_no.setBounds(513, 340, 361, 60);
		panel_1.add(textField_challan_no);
		textField_challan_no.setColumns(10);
		
		JButton btnSubmit = new JButton("SUBMIT");
		
		btnSubmit.setFont(new Font("Droid Sans Fallback", Font.BOLD, 29));
		btnSubmit.setBounds(428, 597, 157, 48);
		panel_1.add(btnSubmit);
		
		txtDd = new JTextField();
		txtDd.setFont(new Font("cmr10", Font.PLAIN, 26));
		txtDd.setText("dd");
		txtDd.setBounds(513, 504, 72, 57);
		panel_1.add(txtDd);
		txtDd.setColumns(10);
		
		txtMm = new JTextField();
		txtMm.setFont(new Font("cmr10", Font.PLAIN, 26));
		txtMm.setText("mm");
		txtMm.setColumns(10);
		txtMm.setBounds(597, 504, 72, 57);
		panel_1.add(txtMm);
		
		txtYyyy = new JTextField();
		txtYyyy.setFont(new Font("cmr10", Font.PLAIN, 26));
		txtYyyy.setText("yyyy");
		txtYyyy.setColumns(10);
		txtYyyy.setBounds(681, 504, 72, 57);
		panel_1.add(txtYyyy);
		
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String sql1 = "SELECT name,f_name,branch,session_start,session_end,cat,categ_fee from ucet_students where roll="+textFieldRoll.getText();
					Statement query1 = (Statement)conn.createStatement();
					rs = (ResultSet) query1.executeQuery(sql1);
					
					
					while(rs.next())
					{
						name = rs.getString("name");
						fname = rs.getString("f_name");
						branch = rs.getString("branch");
						session_start = Integer.parseInt(rs.getString("session_start"));
						session_end = Integer.parseInt(rs.getString("session_end"));
						category = rs.getString("cat");
						fee_cat = rs.getString("categ_fee");
						
						
						
						
						lblName.setText(name);
						lblFname.setText(fname);
						lblBranch_1.setText(branch);
						lblSession_1.setText(session_start + "-" + session_end);
						lblCategory.setText(category);
						lblFeecat.setText(fee_cat);
						//lblTad.setText(""+payment_due);
						lblRoll.setText(textFieldRoll.getText());
					}
					String sqlq2 = "SELECT payment_for_cat from cat_fee where fee_category = "+"'"+fee_cat + "'";
					Statement query2 = (Statement)conn.createStatement();
					ResultSet rs1 = (ResultSet) query2.executeQuery(sqlq2);
					while(rs1.next())
					{
						payment_for_cat = Integer.parseInt(rs1.getString("payment_for_cat"));
						lblAmounttotal.setText(""+payment_for_cat);
					}
					
					
					String sqlq3 = "SELECT sum(amount) from payments where roll_no="+textFieldRoll.getText();
					Statement query3 = (Statement)conn.createStatement();
					ResultSet rs2 = (ResultSet) query3.executeQuery(sqlq3);
					while(rs2.next())
					{
						total_paid = Integer.parseInt(rs2.getString("sum(amount)"));
						
					}
					total_due = payment_for_cat-total_paid;
					lblTap.setText(""+total_paid);
					lblTad.setText(""+total_due);
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
						
						lblNsem.setText("" +nsems + " semesters");
						
						String sqlq4 = "SELECT sysdate()";
						Statement query4 = (Statement)conn.createStatement();
						ResultSet rs4= (ResultSet) query4.executeQuery(sqlq4);
						while(rs4.next())
						{
							dt = rs4.getString("sysdate()");
						}
						lblDate.setText(dt);
					}
					
				}
				catch(Exception xe)
				{
					xe.printStackTrace();
				}
				
				panel.setVisible(false);
				panel_1.setVisible(true);
				
			}
		});
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					challan_no = Integer.parseInt(textField_challan_no.getText());
					challan_amt = Integer.parseInt(textField_chamt.getText());
					challan_dt = Integer.parseInt(txtYyyy.getText())+"-"+Integer.parseInt(txtMm.getText())+"-"+Integer.parseInt(txtDd.getText());
					
					String sql = "INSERT INTO payments VALUES("+challan_no+","+challan_amt+ "," + "'"+challan_dt+"'"+ "," +textFieldRoll.getText()+")";
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
				}catch(MySQLIntegrityConstraintViolationException micv)
				{
					JOptionPane.showMessageDialog(null,"ERROR : Duplicate Challan Number !","Not Inserted",JOptionPane.CANCEL_OPTION);

				}
				catch(Exception We)
				{
					JOptionPane.showMessageDialog(null,"Record Insertion Unsuccessful ! Contact Admin ","Not Inserted",JOptionPane.CANCEL_OPTION);

				}
			
				
				
			}
		});
		
		
		
		
		
	}
}
