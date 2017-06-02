/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllTransactions;

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
public class AlltransactionsController implements Initializable {

    ObservableList<At> list = FXCollections.observableArrayList();
    @FXML
    private TableView<At> tv;
    @FXML
    private TableColumn<At, String> cn;
    @FXML
    private TableColumn<At, String> ca;
    @FXML
    private TableColumn<At, String> cd;
    @FXML
    private TableColumn<At, String> rn;
    @FXML
    private TableColumn<At, String> name;

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
        String qu = "select challan_no,amount,challan_date,roll_no,name from payments inner join ucet_students;";
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
                
                list.add(new At(cnx,amtx,cdtx,rlx,nmx));
        
        
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        
        tv.getItems().setAll(list);
        
    }
    
    public static class At
    {
        private final SimpleStringProperty challanno;
        private final SimpleStringProperty challanamt;
        private final SimpleStringProperty challandt;
        private final SimpleStringProperty roll;
        private final SimpleStringProperty name;
        
        
        At(String cno, String cmt, String cdt, String rl, String nm)
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