/*
 * NAME-SURNAME: YAREN MENEMENCIOGLU
 * STUDENT NUMBER: 21895484
 * CLASS PURPOSE: It is for patients to chose their vaccines type.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class vaccineSelection extends javax.swing.JFrame {
    private String url="jdbc:postgresql://localhost:5432/344_HMW2", user="postgres", password="Yaren1401";
    private DefaultTableModel tblModel;
    private String username;
    
    public vaccineSelection(String usname) {
        initComponents();
        String query= "SELECT * FROM VACCINES";
        username=usname;
    try (Connection connect = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = connect.prepareStatement(query)) {
               
            ResultSet rs = pst.executeQuery();
            
            if(!rs.next()){
            JOptionPane.showMessageDialog(null, "Something gone wrong!!!");
            }
            String str[]= {rs.getString(1),rs.getString(2),rs.getString(3)};    
            tblModel= (DefaultTableModel)jTable1.getModel();
            tblModel.addRow(str);
            
            while(rs.next()){
            String str2[]= {rs.getString(1),rs.getString(2),rs.getString(3)};
            
                tblModel= (DefaultTableModel)jTable1.getModel();
                
                tblModel.addRow(str2);
            }//aşıları ekrana getirme
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }// constructor

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Vaccine Selection");

        jButton1.setText("SELECT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "COUNTRY", "TECHNOLOGY"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton2.setText("HOSPITAL INFO");
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
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(39, 39, 39)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        insert_DB();
        JOptionPane.showMessageDialog(null, "Vaccine selection is successfull!!");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        hospitalScreen hossc=new hospitalScreen(username);
        hossc.setSize(600,900); 
        hossc.setTitle("Hospital & Doctor Selection");
        hossc.setVisible(true);
        hossc.setLocation(800,100);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void insert_DB(){
        String query = " INSERT INTO APPOINTMENT (patient_ID,vac_ID) VALUES (?,?);";
        String query2 = "SELECT id FROM PATIENTS WHERE username= ?";
        //String query3= " UPDATE APPOINTMENT SET vac_ID = ? WHERE patient_ID =? ";
        
        
        
        int select_Row=jTable1.getSelectedRow();
        int select_Col=jTable1.getSelectedColumn();
        
         try (Connection connect = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = connect.prepareStatement(query)) {
            PreparedStatement pst2 = connect.prepareStatement(query2);
            //PreparedStatement pst3 = connect.prepareStatement(query3);
            pst2.setString(1,username);
            
            ResultSet rs2 = pst2.executeQuery();
            
            
            if(rs2.next()){
                
            //pst3.setString(1, tblModel.getValueAt(select_Row,select_Col).toString());
            //pst3.setString(2,rs2.getString(1) );
            //ResultSet rs3 = pst3.executeQuery(); 
                //if(!rs3.next()){
                pst.setString(2,tblModel.getValueAt(select_Row,select_Col).toString());
                pst.setString(1,rs2.getString(1));
                pst.executeUpdate();
                //}//eğer update edilecek bir şey yoksa insert et
            }
  
           
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Test.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
