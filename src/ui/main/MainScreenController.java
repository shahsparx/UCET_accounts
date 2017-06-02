/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.main;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import databaseInit.databaseHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import java.lang.Object;
import java.lang.Object.*;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.ZoneId;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.*;
import org.controlsfx.validation.Validator;


/**
 * FXML Controller class
 *
 * @author shahsparx
 */
public class MainScreenController implements Initializable{
    
    
    private static String USER_NAME = "ucetaccdepartment@gmail.com";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "alpha2105"; // GMail password
    private static String RECIPIENT = "shahsparx@gmail.com";

    private static final String DB_URL = "jdbc:mysql://sql12.freesqldatabase.com/sql12173486";
    Connection conn;
    @FXML
    private JFXTextField nm;
    @FXML
    private JFXTextField fnm;
    @FXML
    private JFXTextField mnm;
    @FXML
    private JFXDatePicker dob;
    @FXML
    private JFXRadioButton genrb;
    @FXML
    private ToggleGroup categ;
    @FXML
    private JFXRadioButton scrb;
    @FXML
    private JFXRadioButton strb;
    @FXML
    private JFXRadioButton obcrb;
    @FXML
    private JFXTextField rn;
    @FXML
    private JFXTextField br;
    @FXML
    private JFXTextField ss;
    @FXML
    private JFXTextField se;
    @FXML
    private JFXRadioButton grb;
    @FXML
    private ToggleGroup feecateg;
    @FXML
    private JFXRadioButton tfwrb;
    @FXML
    private Button submitbtn;
    @FXML
    private JFXTextField add;
    @FXML
    private JFXTextField em;
    @FXML
    private JFXTextField mn;
    @FXML
    private JFXTextField fmn;
    @FXML
    private Button uploadimage;
    @FXML
    private StackPane stackpane;
    PreparedStatement ps = null;
    PreparedStatement ps4=null;
    InputStream is = null;
    @FXML
    private ImageView prophoto;
    
    ResultSet rs =null;
    
    FileChooser fileChooser = new FileChooser();
    File file;
    @FXML
    private ImageView photopreview;
    @FXML
    private JFXTextField Vroll;
    @FXML
    private JFXTextField Vname;
    @FXML
    private JFXTextField Vfname;
    @FXML
    private JFXTextField Vbranch;
    @FXML
    private JFXTextField Vsession;
    @FXML
    private JFXTextField Vcategory;
    @FXML
    private JFXTextField ChallanNo;
    @FXML
    private JFXTextField ChallanAmount;
    @FXML
    private JFXDatePicker ChallanDate;
    @FXML
    private JFXTextField TotalAmountPayable;
    @FXML
    private JFXTextField FeeCategory;
    @FXML
    private JFXTextField FeePaid;
    @FXML
    private JFXTextField FeepaidUpto;
    @FXML
    private Button sendmailbutton;
    @FXML
    private Button studinfobutton;
    @FXML
    private Button lfpbutton;
    @FXML
    private Button alltransactions;
    @FXML
    private MenuItem exit;
    @FXML
    private Menu help;
    @FXML
    private Menu aboutbutton;

    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void submitbtnhandler(ActionEvent event) {
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,"sql12173486","bZ2DG7U3h1");
            ps = conn.prepareStatement("INSERT INTO ucet_students VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            
            ps.setInt(2,Integer.parseInt(rn.getText()));
            ps.setString(3,nm.getText());
            ps.setInt(5,Integer.parseInt(ss.getText()));
            ps.setInt(6,Integer.parseInt(se.getText()));
            ps.setString(7,br.getText());
            RadioButton selectedRadioButton = (RadioButton)categ.getSelectedToggle();
            String toggleGroupValue = selectedRadioButton.getText();
            ps.setString(11,toggleGroupValue);
            ps.setString(9,fnm.getText());
            ps.setString(10, mnm.getText());
            RadioButton selectedRadioButton2 = (RadioButton)feecateg.getSelectedToggle();
            String toggleGroupValue2 = selectedRadioButton2.getText();
            ps.setString(8,toggleGroupValue2);
            ps.setInt(12,Integer.parseInt(mn.getText()));
            ps.setString(13,add.getText());
            ps.setString(14, em.getText());
            is = new FileInputStream(file);
            ps.setBinaryStream(1, is);
            ps.setInt(15,Integer.parseInt(fmn.getText()));
            java.util.Date date = java.util.Date.from(dob.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            ps.setDate(4,sqlDate);
            System.out.println(ps);
            int count = ps.executeUpdate();
            System.out.println("Count:"+count);
            
            if(count==1)
            {
		JOptionPane.showMessageDialog(null,"Record Inserted Successfully...","Insert",JOptionPane.OK_OPTION);
		conn.close();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Record Insertion Unsuccessful ! Contact Admin ","Not Inserted",JOptionPane.CANCEL_OPTION);
		conn.close();
            }
            
            
            
            
            
            
        }
        catch(MySQLIntegrityConstraintViolationException dpk)
				{
					JOptionPane.showMessageDialog(null,"Possible Errors : \n 1.Duplicate Roll number, or \n 2.Invalid Branch or \n 3. Invalid input for 'GEN/TFW' or \n 4. Invalid input for Category .","Not Inserted",JOptionPane.CANCEL_OPTION);

				}
	catch(NumberFormatException nfe)
				{
					JOptionPane.showMessageDialog(null,"Error ! Fill up all the columns...","Not Inserted",JOptionPane.CANCEL_OPTION);

				}
        catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Error ! Contact Admin...","Not Inserted",JOptionPane.CANCEL_OPTION);

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

    @FXML
    private void uploadimagehandler(ActionEvent event) {
        
        System.out.println("Image Upload button clicked!");
         
             
            //Set extension filter
            fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
            );
            
            //Show open file dialog
            file = fileChooser.showOpenDialog(stackpane.getScene().getWindow());
                       
            try {
                BufferedImage bufferedImage = ImageIO.read(file);
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                photopreview.setImage(image);
           } catch (IOException ex) {
              ex.printStackTrace();
           }
           
     }

    @FXML
    private void dbshandler(ActionEvent event) {
        
        try
        {
            //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/DefBySession/DefBySessionView.fxml"));
            Parent root = FXMLLoader.load(getClass().getResource("/DefBySession/DefBySessionView.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
                
            
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
    }

    @FXML
    private void LoadFeeInfo(ActionEvent event) {
        try
        {
            String sql = "SELECT name, f_name,branch,session_start,session_end,cat,image from ucet_students where roll="+Vroll.getText();
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,"sql12173486","bZ2DG7U3h1");
            Statement query = (Statement)conn.createStatement();
            ResultSet rs2 = (ResultSet) query.executeQuery(sql);
            
            while(rs2.next())
            {
                Vname.setText(rs2.getString("name"));
                Vfname.setText(rs2.getString("f_name"));
                Vbranch.setText(rs2.getString("branch"));
                Vsession.setText(rs2.getString("session_start")+"-"+rs2.getString("session_end"));
                Vcategory.setText(rs2.getString("cat"));
                InputStream input = new ByteArrayInputStream(rs2.getBytes("image"));
                Image imge = new Image(input);
                prophoto.setImage(imge);
                
                
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        try
        {
            String sql2 = "SELECT sum(amount) from payments where roll_no="+Vroll.getText();
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,"sql12173486","bZ2DG7U3h1");
            Statement query = (Statement)conn.createStatement();
            ResultSet rs3 = (ResultSet) query.executeQuery(sql2);
            
            while(rs3.next())
            {
                FeePaid.setText(rs3.getString("sum(amount)"));
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        try
        {
            String sql2 = "SELECT sum(amount) from payments where roll_no="+Vroll.getText();
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,"sql12173486","bZ2DG7U3h1");
            Statement query = (Statement)conn.createStatement();
            ResultSet rs3 = (ResultSet) query.executeQuery(sql2);
            
            while(rs3.next())
            {
                FeePaid.setText(rs3.getString("sum(amount)"));
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
    }

    @FXML
    private void PayFeeHandler(ActionEvent event) {
         try
        {
            
            java.util.Date date = java.util.Date.from(ChallanDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,"sql12173486","bZ2DG7U3h1");
            ps4 = conn.prepareStatement("INSERT INTO payments VALUES(?,?,?,?)");
            
            ps4.setInt(1,Integer.parseInt(ChallanNo.getText()));
            ps4.setInt(2, Integer.parseInt(ChallanAmount.getText()));
            ps4.setDate(3, sqlDate);
            ps4.setInt(4,Integer.parseInt(Vroll.getText()));
            
            
            
            int count = ps4.executeUpdate();            
            if(count==1)
            {
		JOptionPane.showMessageDialog(null,"Record Inserted Successfully...","Insert",JOptionPane.OK_OPTION);
		conn.close();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Record Insertion Unsuccessful ! Contact Admin ","Not Inserted",JOptionPane.CANCEL_OPTION);
		conn.close();
            }
            
            
            
            
            
            
        }
        catch(MySQLIntegrityConstraintViolationException dpk)
				{
					JOptionPane.showMessageDialog(null,"Possible Errors : \n 1.Duplicate Roll number, or \n 2.Invalid Branch or \n 3. Invalid input for 'GEN/TFW' or \n 4. Invalid input for Category .","Not Inserted",JOptionPane.CANCEL_OPTION);

				}
	catch(NumberFormatException nfe)
				{
					JOptionPane.showMessageDialog(null,"Error ! Fill up all the columns...","Not Inserted",JOptionPane.CANCEL_OPTION);

				}
        catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Error ! Contact Admin...","Not Inserted",JOptionPane.CANCEL_OPTION);

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

    @FXML
    private void sendmailtodef(ActionEvent event) {
        try
        {   String from = USER_NAME;
            String pass = PASSWORD;
            String[] to = {RECIPIENT};
            String subject = " Notification For Fee Payment";
            JDialog.setDefaultLookAndFeelDecorated(true);
            String message = JOptionPane.showInputDialog(null, "Do you want to Send Notification Mail to all Defaulters ?","Confirm",JOptionPane.QUESTION_MESSAGE);
            SendMail(from,pass,to,subject,message);
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    private static void SendMail(String from, String pass,String[] to, String subject, String body)
    {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }

    @FXML
    private void studhandler(ActionEvent event) {
        
         try
        {
            //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/DefBySession/DefBySessionView.fxml"));
            Parent root2 = FXMLLoader.load(getClass().getResource("/StudentRecords/StudRec.fxml"));
            Scene scene2 = new Scene(root2);
            Stage stage2 = new Stage();
            stage2.setTitle("Student Records");
            stage2.setScene(scene2);
            stage2.show();
                
            
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }

    @FXML
    private void lfpbtnhandler(ActionEvent event) {
        try
        {
            //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/DefBySession/DefBySessionView.fxml"));
            Parent root3 = FXMLLoader.load(getClass().getResource("/Last15Payments/Last15Payments.fxml"));
            Scene scene3 = new Scene(root3);
            Stage stage3 = new Stage();
            stage3.setTitle("Last 15 Payments");
            stage3.setScene(scene3);
            stage3.show();
                
            
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }

    @FXML
    private void alltransactionshandler(ActionEvent event) {
        
        try
        {
            //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/DefBySession/DefBySessionView.fxml"));
            Parent root4 = FXMLLoader.load(getClass().getResource("/AllTransactions/alltransactions.fxml"));
            Scene scene4 = new Scene(root4);
            Stage stage4 = new Stage();
            stage4.setTitle("All Transactions");
            stage4.setScene(scene4);
            stage4.show();
                
            
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void exitbuttonhandler(ActionEvent event) {
        
        Stage stageold = (Stage)nm.getScene().getWindow();
        stageold.close();
        
        
    }

    @FXML
    private void helpbuttonhandler(ActionEvent event) {
        
    }

    @FXML
    private void aboutbuttonhandler(ActionEvent event) {
        
        try
        {
            //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/DefBySession/DefBySessionView.fxml"));
            
            System.out.println("about clicked");
            Parent root5 = FXMLLoader.load(getClass().getResource("/about/about.fxml"));
            Scene scene5 = new Scene(root5);
            Stage stage5 = new Stage();
            stage5.setTitle("We made it!");
            stage5.setScene(scene5);
            stage5.show();
                
            
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    }
    

