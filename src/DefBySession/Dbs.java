
import javafx.beans.property.SimpleStringProperty;

public class Dbs
    {
        private final SimpleStringProperty roll;
        private final SimpleStringProperty name;
        private final SimpleStringProperty branch;
        private final SimpleStringProperty fee_category;
        private final SimpleStringProperty sessionstart;
        private final SimpleStringProperty amount_paid;
        private final SimpleStringProperty amount_due;
        
        
        Dbs(String roll, String name, String branch, String fc, String ss, String ap, String ad)
        {
           this.roll=new SimpleStringProperty(roll); 
           this.name=new SimpleStringProperty(name); 
           this.branch=new SimpleStringProperty(branch); 
           this.fee_category=new SimpleStringProperty(fc); 
           this.sessionstart=new SimpleStringProperty(ss); 
           this.amount_paid=new SimpleStringProperty(ap);
           this.amount_due=new SimpleStringProperty(ad); 
           
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

        public String getAmount_payable() {
            return sessionstart.get();
        }

        public String getAmount_paid() {
            return amount_paid.get();
        }

        public String getAmount_due() {
            return amount_due.get();
        }
        
        
    }
