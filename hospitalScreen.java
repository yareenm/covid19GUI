/*
 * NAME-SURNAME: YAREN MENEMENCIOGLU
 * STUDENT NUMBER: 21895484
 * CLASS PURPOSE: It is for patients to chose their hospital and related doctor with that hospital.
 */

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class hospitalScreen extends javax.swing.JFrame {
    private String url="jdbc:postgresql://localhost:5432/344_HMW2", user="postgres", password="Yaren1401";
    private DefaultTableModel tblModel,tblModel3;
    private String username,id;
    private Connection connect;
    
    public hospitalScreen(String usern) {
        initComponents();
        
        username=usern;
        String query= "SELECT * FROM HOSPITAL";
        
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
            }//hastaneleri ekrana getirme
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//constructor

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Appointment Date");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "ADDRESS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("HOSPITAL SELECTION");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("DOCTOR SELECTION");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "SURNAME"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setColumnSelectionAllowed(true);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable3);
        jTable3.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setResizable(false);
            jTable3.getColumnModel().getColumn(1).setResizable(false);
            jTable3.getColumnModel().getColumn(2).setResizable(false);
        }

        jButton1.setText("SELECT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("OK");
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
                .addGap(205, 205, 205)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(223, 223, 223))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(210, 210, 210))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(206, 206, 206))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(174, 174, 174))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(223, 223, 223))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int select_Row=jTable1.getSelectedRow();
        int select_Col=jTable1.getSelectedColumn();
        String query= "SELECT id,name,surname FROM DOCTOR WHERE hospital_id = ?";
        
        
    try (Connection connect = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = connect.prepareStatement(query)) {
            
           
            tblModel= (DefaultTableModel)jTable1.getModel();
            pst.setString(1,tblModel.getValueAt(select_Row,select_Col).toString());
            ResultSet rs = pst.executeQuery();
            
            if(!rs.next()){
            JOptionPane.showMessageDialog(null, "Something gone wrong!!!");
            }
            String str[]= {rs.getString(1),rs.getString(2),rs.getString(3)};    
            tblModel3= (DefaultTableModel)jTable3.getModel();
            tblModel3.addRow(str);
            
            while(rs.next()){
            String str2[]= {rs.getString(1),rs.getString(2),rs.getString(3)};
            
                tblModel3= (DefaultTableModel)jTable3.getModel();
                
                tblModel3.addRow(str2);
            }//doktorları ekrana getirme
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
// hastaneye göre doktorlar getirilecek
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int select_Row=jTable3.getSelectedRow();
        int select_Col=jTable3.getSelectedColumn();
        int select_Row2=jTable1.getSelectedRow();
        int select_Col2=jTable1.getSelectedColumn();
        String query= "UPDATE APPOINTMENT SET doctor_id = ? , hospital_id= ? , date_app=? WHERE patient_id = ?;";
        String query2 = "SELECT id FROM PATIENTS WHERE username= ?";
        
        
        try (Connection connect = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = connect.prepareStatement(query)) {
            PreparedStatement pst2 = connect.prepareStatement(query2);
            
            
            pst2.setString(1,username); 
            
            ResultSet rs2 = pst2.executeQuery();
            tblModel= (DefaultTableModel)jTable1.getModel();
            String h_id=tblModel.getValueAt(select_Row2,select_Col2).toString();
            id=rs2.getString(1);
          
            if(!rs2.next()){
            JOptionPane.showMessageDialog(null, "Something gone wrong!!!");
            }
            
            else {
            
            tblModel3= (DefaultTableModel)jTable3.getModel();
            pst.setString(1,tblModel3.getValueAt(select_Row,select_Col).toString());
            pst.setString(2,h_id);
            java.util.Date d = jDateChooser1.getDate();
            java.sql.Date sqldate = new java.sql.Date(d.getTime()); 
            pst.setDate(3,sqldate);
            pst.setString(4,rs2.getString(1));
            update_Stat();
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Appointment successfully made !!!");
            
            }//doktorları ekrana getirme
            
            
        } catch (SQLException ex) {
           
            JOptionPane.showMessageDialog(null,"Appointment made failed !!!");
            
        }
            
        update_Stat();
// appointment günü ile doktor bilgileri girilecek
    }//GEN-LAST:event_jButton2ActionPerformed

    private void update_Stat(){
    
    String query = "SELECT id FROM PATIENTS WHERE username= ?";
    String query3= "SELECT allergy_info, pregnancy FROM PATIENTS WHERE pregnancy= ?  OR allergy_info != ? ";
    String query2= "UPDATE APPOINTMENT SET status_app = ? FROM APPOINTMENT WHERE patient_id=?";   
    
        try (Connection connect = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = connect.prepareStatement(query)) {
            PreparedStatement pst2 = connect.prepareStatement(query2);
            PreparedStatement pst3 = connect.prepareStatement(query3);
            
            
            
            pst.setString(1,username);
            ResultSet rs5 = pst.executeQuery(); // id dönüyor
            id=rs5.getString(1);
            
           
            pst3.setString(1,"T");
            pst3.setString(2," ");
            ResultSet rs3 = pst.executeQuery();
            
            if(rs3!=null){
            pst2.setString(1,"Suspended");
            pst2.setString(2, id);
            pst2.executeUpdate(); 
            }
            
           
  
           
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Test.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
 
    }
   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
