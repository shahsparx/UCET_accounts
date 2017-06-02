/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucet_accounts;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import databaseInit.databaseHandler;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author shahsparx
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private AnchorPane anchorbody;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private Button loginbutton;
    
    databaseHandler databaseHandler;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        try
        {
            String uname = username.getText();
        String pword = password.getText();
        String sql = "select * from acclogin where un="+"'"+uname+"'"+"and pw="+"'"+pword+"'";
        ResultSet rs = databaseHandler.execQuery(sql);
        int count=0;
        
        while(rs.next())
        {
            count++;
        }
        if(count>0)
        {
            JOptionPane.showMessageDialog(null, "Login Success...");
            try
            {
                Stage stageold = (Stage)anchorbody.getScene().getWindow();
                stageold.close();
                
                
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/main/mainScreen.fxml"));
                Parent root1 = (Parent)fxmlLoader.load();
                Stage stage = new Stage();
                
                stage.setTitle("UCET Accounts Solution");
                stage.setScene(new Scene(root1));
                stage.show();
                stage.setResizable(false);
              
                
            }
            
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }
        else if(count==0)
	{
            JOptionPane.showMessageDialog(null, "Invalid Credentials...");
	}
            
        }
        catch(SQLException xe)
        {
            xe.printStackTrace();
        }
        
        System.out.println("You clicked me!");
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        databaseHandler= databaseHandler.getInstance();
    }    
    
}
