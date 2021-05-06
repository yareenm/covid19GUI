/*
 * NAME-SURNAME: YAREN MENEMENCIOGLU
 * STUDENT NUMBER: 21895484
 * CLASS PURPOSE: It is for Doctor's approval of doses, participation and its appointments.
 */
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class appointmentScreen extends javax.swing.JFrame {
    private String url="jdbc:postgresql://localhost:5432/344_HMW2", user="postgres", password="Yaren1401";
    private DefaultTableModel tblModel;
    private String username,status=" ",id,dose1="F",dose2="F";
    
    public appointmentScreen(String usern) {
        initComponents();
        String query= "SELECT id FROM DOCTOR WHERE username=?";
        username=usern;
        String query2= "SELECT patient_id, vac_id,date_app FROM APPOINTMENT WHERE doctor_id =? ";
        
    try (Connection connect = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = connect.prepareStatement(query)) {
            PreparedStatement pst2 = connect.prepareStatement(query2);
                    
            pst.setString(1, username);
            ResultSet res = pst.executeQuery(); // get doctors id
            
            if(!res.next()){
            JOptionPane.showMessageDialog(null, "Something gone wrong!!!");
            }
            
            pst2.setString(1, res.getString(1));
            ResultSet res2=pst2.executeQuery();//get infos
            
            if(!res2.next()){
            
            JOptionPane.showMessageDialog(null, "There is no appointment!!!");
            }
            else{
            Object str[]= {res2.getString(1),res2.getString(2),res2.getDate(3)};    
            tblModel= (DefaultTableModel)jTable1.getModel();
            tblModel.addRow(str);
            
            while(res2.next()){
            String str2[]= {res2.getString(1),res2.getString(2),res2.getString(3)};
            
                tblModel= (DefaultTableModel)jTable1.getModel();
                tblModel.addRow(str2);
            }//hastaneleri ekrana getirme
            
            }//else
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }//display all appointment info

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("APPOINTMENTS");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient ID", "Vaccine ID", "Appointment Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
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
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        jButton1.setText("SELECT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("DOSE NUMBER");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jCheckBox1.setText("DOSE 1");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("DOSE 2");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("PARTICIPATION");
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jCheckBox3.setText("JOINED");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(jCheckBox3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(jCheckBox1)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox3)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2))
                .addGap(27, 27, 27)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        if(jCheckBox3.isSelected()){
        status="Done";
        }
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int select_Row=jTable1.getSelectedRow();
        int select_Col=jTable1.getSelectedColumn();
        String query="UPDATE APPOINTMENT SET status_app = ?, dose_1= ?, dose_2=? WHERE patient_id=?";
        
        try (Connection connect = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = connect.prepareStatement(query)) {
            
            tblModel= (DefaultTableModel)jTable1.getModel();
            
        
            pst.setString(1, status);
            pst.setString(2, dose1);
            pst.setString(3, dose2);
            pst.setString(4, tblModel.getValueAt(select_Row,select_Col).toString());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
           
            JOptionPane.showMessageDialog(null,"Appointment made failed !!!");
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if(jCheckBox1.isSelected()){
        dose1="T";
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
       if(jCheckBox2.isSelected()){
        dose2="T";
        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}


/*

Priority işlemini böyle düşünmüştüm fakat maalesef burada çalışmadı hocam fakat sql de sonuç aldım.

SELECT A.patient_id
FROM APPOINTMENT A 
WHERE A.doctor_id ='202132' 

INTERSECT

SELECT P.id
FROM PATIENTS P
WHERE P.chronicd_info IS NULL

SELECT A.patient_id
FROM APPOINTMENT A 
WHERE A.doctor_id ='202132' 

INTERSECT

SELECT P.id
FROM PATIENTS P
WHERE P.chronicd_info IS NOT NULL


*/