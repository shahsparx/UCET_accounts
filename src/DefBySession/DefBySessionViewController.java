/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DefBySession;

import databaseInit.databaseHandler;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author shahsparx
 */
public class DefBySessionViewController implements Initializable {

    
    ObservableList<Dbs> list = FXCollections.observableArrayList();
    

    @FXML
    private TableView<Dbs> tableView;

    
    @FXML
    private TableColumn<Dbs,String> rollcol;
    @FXML
    private TableColumn<Dbs,String> namecol;
    @FXML
    private TableColumn<Dbs,String> branchcol;
    @FXML
    private TableColumn<Dbs,String> feecatcol;
    @FXML
    private TableColumn<Dbs,String> sessioncol;
    @FXML
    private TableColumn<Dbs,String> amountpaidcol;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initCol();
        loadData();
    }    
    
    
    private void initCol()
    {
        rollcol.setCellValueFactory(new PropertyValueFactory<>("roll"));
        namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        branchcol.setCellValueFactory(new PropertyValueFactory<>("branch"));
        feecatcol.setCellValueFactory(new PropertyValueFactory<>("fee_category"));
        sessioncol.setCellValueFactory(new PropertyValueFactory<>("sessionstart"));
        amountpaidcol.setCellValueFactory(new PropertyValueFactory<>("amount_paid"));
        
        
    }
    
    private void loadData()
    {
        databaseHandler handler;
        handler=databaseHandler.getInstance();
        String qu = "select ucet_students.roll,ucet_students.name,ucet_students.branch,ucet_students.categ_fee,session_start,sum(amount) from ucet_students inner join payments on ucet_students.roll=payments.roll_no group by roll order by session_start;";
        ResultSet rs = handler.execQuery(qu);
        
        
        try
        {
            while(rs.next())
            {
                String rollx = rs.getString("roll");
                String namex = rs.getString("name");
                String branchx = rs.getString("branch");
                String fee_catx = rs.getString("categ_fee");
                String session_startx = rs.getString("session_start");
                String amount_paidx = rs.getString("sum(amount)");
                
                list.add(new Dbs(rollx,namex,branchx,fee_catx,session_startx,amount_paidx));
        
        
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        
        tableView.getItems().setAll(list);
        
    }
    
    
    public static class Dbs
    {
        private final SimpleStringProperty roll;
        private final SimpleStringProperty name;
        private final SimpleStringProperty branch;
        private final SimpleStringProperty fee_category;
        private final SimpleStringProperty sessionstart;
        private final SimpleStringProperty amount_paid;
        
        
        Dbs(String roll, String name, String branch, String fc, String ss, String ap)
        {
           this.roll=new SimpleStringProperty(roll); 
           this.name=new SimpleStringProperty(name); 
           this.branch=new SimpleStringProperty(branch); 
           this.fee_category=new SimpleStringProperty(fc); 
           this.sessionstart=new SimpleStringProperty(ss); 
           this.amount_paid=new SimpleStringProperty(ap);
           
        }

        public String getRoll() {
            return roll.get();
        }

        public String getName() {
            return name.get();
        }

        public String getBranch() {
            return branch.get();
        }

        public String getFee_category() {
            return fee_category.get();
        }

        public String getSessionstart() {
            return sessionstart.get();
        }

       

        public String getAmount_paid() {
            return amount_paid.get();
        }


        
        
    }
    
}
