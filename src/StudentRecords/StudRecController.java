/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentRecords;

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
public class StudRecController implements Initializable {
    
    ObservableList<SR> list = FXCollections.observableArrayList();

    @FXML
    private TableColumn<SR, String> roll;
    @FXML
    private TableColumn<SR, String> name;
    @FXML
    private TableColumn<SR, String> sessionfrom;
    @FXML
    private TableColumn<SR, String> sessionto;
    @FXML
    private TableColumn<SR, String> branch;
    @FXML
    private TableColumn<SR, String> feeateg;
    @FXML
    private TableColumn<SR, String> father;
    @FXML
    private TableColumn<SR, String> mother;
    @FXML
    private TableColumn<SR, String> category;
    @FXML
    private TableColumn<SR, String> mobile;
    @FXML
    private TableColumn<SR, String> address;
    @FXML
    private TableColumn<SR, String> email;
    @FXML
    private TableColumn<SR, String> fathersmobile;
    @FXML
    private TableColumn<SR, String> dob;
    @FXML
    private TableView<SR> tv;

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
        roll.setCellValueFactory(new PropertyValueFactory<>("roll"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        branch.setCellValueFactory(new PropertyValueFactory<>("branch"));
        feeateg.setCellValueFactory(new PropertyValueFactory<>("fee_category"));
        sessionfrom.setCellValueFactory(new PropertyValueFactory<>("session_start"));
        sessionto.setCellValueFactory(new PropertyValueFactory<>("session_end"));
        father.setCellValueFactory(new PropertyValueFactory<>("f_name"));
        mother.setCellValueFactory(new PropertyValueFactory<>("m_name"));
        category.setCellValueFactory(new PropertyValueFactory<>("cat"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        fathersmobile.setCellValueFactory(new PropertyValueFactory<>("fmobno"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        dob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        
    }
    
    
    private void loadData()
    {
        databaseHandler handler;
        handler=databaseHandler.getInstance();
        System.out.println("ERan");
        String qu = "select roll,name,session_start,session_end,branch,categ_fee,f_name,m_name,cat,mob,address,email,fmobno,dob from ucet_students";
        System.out.println("not ERan");
        ResultSet rs = handler.execQuery(qu);
        System.out.println(rs);
        
        
        try
        {
            while(rs.next())
            {
                String rollx = rs.getString("roll");
                System.out.println(rollx);
                String namex = rs.getString("name");
                String session_startx = rs.getString("session_start");
                String session_endx = rs.getString("session_end");
                String branchx = rs.getString("branch");
                String fee_catx = rs.getString("categ_fee");
                String f_namex = rs.getString("f_name");
                String m_namex = rs.getString("m_name");
                String catx = rs.getString("cat");
                String mobx = rs.getString("mob");
                String addressx = rs.getString("address");
                String emailx = rs.getString("email");
                String fmobnox = rs.getString("fmobno");
                String dobx = rs.getString("dob");
                
                
                
                list.add(new SR(rollx,namex,session_startx,session_endx,branchx,fee_catx,f_namex,m_namex,catx,mobx,addressx,emailx,fmobnox,dobx));
                System.out.println(list);
        
        
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        
        tv.getItems().setAll(list);
        
    }
    
    
     public static class SR
    {
        private final SimpleStringProperty roll;
        private final SimpleStringProperty name;
        private final SimpleStringProperty session_start;
        private final SimpleStringProperty session_end;
        private final SimpleStringProperty branch;
        private final SimpleStringProperty fee_category;
        private final SimpleStringProperty f_name;
        private final SimpleStringProperty m_name;
        private final SimpleStringProperty cat;
        private final SimpleStringProperty mob;
        private final SimpleStringProperty address;
        private final SimpleStringProperty email;
        private final SimpleStringProperty fmobno;
        private final SimpleStringProperty dob;
        
        
        SR(String roll, String name,String sessions,String sessione, String branch, String fc, String fn,String mn, String cat,String mob,String address,String email,String fmobno,String dob)
        {
           this.roll=new SimpleStringProperty(roll); 
           this.name=new SimpleStringProperty(name); 
           this.branch=new SimpleStringProperty(branch); 
           this.fee_category=new SimpleStringProperty(fc); 
           this.session_start=new SimpleStringProperty(sessions); 
           this.session_end=new SimpleStringProperty(sessione);
           this.f_name=new SimpleStringProperty(fn);
           this.m_name=new SimpleStringProperty(mn);
           this.cat=new SimpleStringProperty(cat);
           this.mob=new SimpleStringProperty(mob);
           this.address=new SimpleStringProperty(address);
           this.email=new SimpleStringProperty(email);
           this.dob=new SimpleStringProperty(dob);
           this.fmobno=new SimpleStringProperty(fmobno);
           
        }

        public String getRoll() {
            return roll.get();
        }

        public String getName() {
            return name.get();
        }

        public String getSession_start() {
            return session_start.get();
        }

        public String getSession_end() {
            return session_end.get();
        }

        public String getBranch() {
            return branch.get();
        }

        public String getFee_category() {
            return fee_category.get();
        }

        public String getF_name() {
            return f_name.get();
        }

        public String getM_name() {
            return m_name.get();
        }

        public String getCat() {
            return cat.get();
        }

        public String getMob() {
            return mob.get();
        }

        public String getAddress() {
            return address.get();
        }

        public String getEmail() {
            return email.get();
        }

        public String getFmobno() {
            return fmobno.get();
        }

        public String getDob() {
            return dob.get();
        }
        
        
     }
    
}
