
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class dbConnection {
    private Connection connect;
    private String url="jdbc:postgresql://localhost:5432/344_HMW2", user="postgres", password="Yaren1401";
    
    public Connection dbConnect(){
        try{
        Class.forName("org.postgresql.Driver");
        }
        catch(ClassNotFoundException cnfe){
        cnfe.getMessage();
        }
        try {     
            connect=DriverManager.getConnection(url,user,password);
            JOptionPane.showMessageDialog(null, "Connected");
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Failed to Connect");
        }
        return connect;
    }
}
