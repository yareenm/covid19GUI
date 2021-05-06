/*
 * NAME-SURNAME: YAREN MENEMENCIOGLU
 * STUDENT NUMBER: 21895484
 * CLASS PURPOSE: It is for everyone that has to be logged on the system.
 */


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.postgresql.shaded.com.ongres.scram.common.ScramAttributes;


public class loginScreen extends javax.swing.JFrame {
    private String url="jdbc:postgresql://localhost:5432/344_HMW2", user="postgres", password="YOUR_PASSWORD";
    private String username;
   
    public loginScreen() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("USERNAME:");

        jLabel2.setText("PASSWORD:");

        jButton1.setText("REGISTER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Register as a Patient ?");

        jButton2.setText("LOGIN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                            .addComponent(jPasswordField1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel3)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        registerScreen regsc=new registerScreen();
        regsc.setSize(600,900); 
        regsc.setTitle("Registration");
        regsc.setVisible(true);
        regsc.setLocation(800,100);   
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    
        queryDb();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void queryDb(){
    String query= "SELECT * FROM PATIENTS WHERE username=? AND password=?";
    String query2= "SELECT * FROM DOCTOR WHERE username=? AND password=?";
    
    try (Connection connect = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = connect.prepareStatement(query)) {
            
            pst.setString(1, jTextField1.getText());
            pst.setString(2, jPasswordField1.getText());       
            ResultSet rs = pst.executeQuery();

            if(rs.next()){
            JOptionPane.showMessageDialog(null, "!! Login successfull (Patient) !!");
            username = jTextField1.getText();
            vaccineSelection vacsc=new vaccineSelection(username);
            vacsc.setSize(600,900); 
            vacsc.setTitle("Vaccine Selection");
            vacsc.setVisible(true);
            vacsc.setLocation(800,100);
            
            }//patient kısmı burada
            else{
            PreparedStatement pst2 = connect.prepareStatement(query2);
            pst2.setString(1, jTextField1.getText());
            pst2.setString(2, jPasswordField1.getText());       
            ResultSet rs2 = pst2.executeQuery();
            
            if(rs2.next()){
             JOptionPane.showMessageDialog(null, "!! Login successfull (Doctor) !!");
             //DOCTOR SAYFASI AÇILACAK
             username = jTextField1.getText();
             appointmentScreen appsc= new appointmentScreen(username);
            
            appsc.setSize(600,900); 
            appsc.setTitle("Scheduled Appointments");
            appsc.setVisible(true);
            appsc.setLocation(800,100);
            }
            else{
            JOptionPane.showMessageDialog(null, "!! Wrong password or username !!");
            System.exit(-1);
            return ;
            }
            }// doktor kısmı burada
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
