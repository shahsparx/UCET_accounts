import java.sql.*;
public class AccDBconn {
	public static void main(String[] args)
	{
		System.out.println("---MySQL JDBC Connection Testing---");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Where is your Mysql jdbc Driver?");
			e.printStackTrace();
			return;
		}
		System.out.println("mysql JDBC Driver Registered!");
		Connection connection = null;
		try
		{
			connection = DriverManager.getConnection("jdbc:mysql://sql6.freesqldatabase.com:3306/sql6145950","sql6145950","p7y5CKPjir");
		
		}
		catch(SQLException e)
		{
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		if(connection!=null)
		{
			System.out.println("Database Connected");
		}
		else
		{
			System.out.println("Connection Failed");
		}
	}

}
