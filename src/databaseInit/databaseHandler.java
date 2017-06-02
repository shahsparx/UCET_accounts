
package databaseInit;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author shahsparx
 */
public class databaseHandler {
    private static databaseHandler handler;
    
    private static final String DB_URL = "jdbc:mysql://sql12.freesqldatabase.com/sql12173486";
    private static Connection conn =null;
    private static Statement stmt = null;

    public databaseHandler() {
        createConnection();
    }
    
    public static databaseHandler getInstance()
    {
        if(handler==null)
        {
            handler=new databaseHandler();
        }
        return handler;
    }
    void createConnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,"sql12173486","bZ2DG7U3h1");
            
        }
        catch(Exception e)
        {
            System.out.println("Exceptionheheh : "+e);
            e.printStackTrace();
        }
        if (conn != null) 
            {
		System.out.println("You made it, take control your database now!");
            }
        else 
            {
		System.out.println("Failed to make connection!");
            }
    }
    
    public ResultSet execQuery(String query)
    {
        ResultSet result=null;
        try
        {
            stmt = conn.createStatement();
            result = stmt.executeQuery(query);
        }
        catch(SQLException ex)
        {
            System.out.println("Exception at execQuery:dataHandler"+ex.getLocalizedMessage());
            return null;
        }
        finally
        {
            
            
        }
        
        return result;
        
    }
    
    public boolean execAction(String qu)
    {
        try
        {
            stmt = conn.createStatement();
            stmt.execute(qu);
            return true;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error:"+ ex.getMessage(), "Error Occured",JOptionPane.ERROR_MESSAGE);
            System.out.println("Exception at execQuery:dataHandler"+ ex.getLocalizedMessage());
            return false;
        }
        finally
        {
           
        }
    }
    
    
}
