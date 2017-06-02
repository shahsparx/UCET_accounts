/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Last15Payments;

import DefBySession.DefBySessionViewController;
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
public class Last15PaymentsController implements Initializable {

    
    ObservableList<Lfp> list = FXCollections.observableArrayList();
    @FXML
    private TableView<Lfp> tv;
    @FXML
    private TableColumn<Lfp, String> cn;
    @FXML
    private TableColumn<Lfp, String> ca;
    @FXML
    private TableColumn<Lfp, String> cd;
    @FXML
    private TableColumn<Lfp, String> rn;
    @FXML
    private TableColumn<Lfp, String> name;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        initCol();
        loadData();
    }    
    
    private void initCol()
    {
        cn.setCellValueFactory(new PropertyValueFactory<>("challanno"));
        ca.setCellValueFactory(new PropertyValueFactory<>("challanamt"));
        cd.setCellValueFactory(new PropertyValueFactory<>("challandt"));
        rn.setCellValueFactory(new PropertyValueFactory<>("roll"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));     
        
        
    }
    
    private void loadData()
    {
        databaseHandler handler;
        handler=databaseHandler.getInstance();
        String qu = "select challan_no,amount,challan_date,roll_no,name from payments inner join ucet_students limit 15;";
        ResultSet rs = handler.execQuery(qu);
        
        
        try
        {
            while(rs.next())
            {
                String cnx = rs.getString("challan_no");
                String amtx = rs.getString("amount");
                String cdtx = rs.getString("challan_date");
                String rlx = rs.getString("roll_no");
                String nmx = rs.getString("name");
                
                list.add(new Lfp(cnx,amtx,cdtx,rlx,nmx));
        
        
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        
        tv.getItems().setAll(list);
        
    }
    
    public static class Lfp
    {
        private final SimpleStringProperty challanno;
        private final SimpleStringProperty challanamt;
        private final SimpleStringProperty challandt;
        private final SimpleStringProperty roll;
        private final SimpleStringProperty name;
        
        
        Lfp(String cno, String cmt, String cdt, String rl, String nm)
        {
           this.challanno=new SimpleStringProperty(cno); 
           this.challanamt=new SimpleStringProperty(cmt); 
           this.challandt=new SimpleStringProperty(cdt); 
           this.roll=new SimpleStringProperty(rl); 
           this.name=new SimpleStringProperty(nm); 
               
        }

        public String getChallanno() {
            return challanno.get();
        }

        public String getChallanamt() {
            return challanamt.get();
        }

        public String getChallandt() {
            return challandt.get();
        }

        public String getRoll() {
            return roll.get();
        }

        public String getName() {
            return name.get();
        }
        
        
}
}
