
import javax.swing.JFrame;


public class Test {
    
    
    public static void main(String[] args) {
        dbConnection connect= new dbConnection();
        connect.dbConnect();  //connection sağlanıldı.
        try{
        loginScreen logsc= new loginScreen();
        logsc.setSize(400,400); 
        logsc.setTitle("Login");
        logsc.setVisible(true);
        logsc.setLocation(800,200);   
        }
        catch(Exception exp){
        exp.getStackTrace();
        }
       
        
    }
}
