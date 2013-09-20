/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package medicaldatabase;

import java.awt.Dimension;
import java.sql.*;
import java.text.DateFormat;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author Austin
 */
public class frmPatientApptInfo extends javax.swing.JFrame {

    /**
     * Creates new form frmPatientApptInfo
     */
    frmPatient patient;
    String uid;
    ResultSet rs;
    ArrayList<String> doctorNames = new ArrayList<String>();
    ArrayList<String> doctorUids = new ArrayList<String>();
    public frmPatientApptInfo(frmPatient patient, String uid) {
        initComponents();
        this.patient = patient;
        this.uid = uid;
        notes.setVisible(false); 
        noteslb.setVisible(false);
        notes.setPreferredSize(new Dimension(0,0));
        //Get list of doctors from database and populate cmbDoctors
        rs = Importdb.getListofDoctorNames(this.uid);
        if(rs != null){
            String doctorName;
            String doctorUid;
            try{
                while(rs.next()){
                    doctorName = rs.getString("name");
                    doctorUid = rs.getString("did");
                    if(doctorName != null && doctorUid != null){
                        doctorNames.add(doctorName);
                        doctorUids.add(doctorUid);
                    }else{
                        System.out.println("Either a doctor name or uid was null with did: " + doctorUid
                                   + " or name: " + doctorName + ".");
                    }
                }
                for(int i = 0; i < doctorNames.size(); i++){
                    cmbDoctors.addItem(doctorNames.get(i));
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(this, "No doctors found in database.");
        }
    }
    
    public frmPatientApptInfo(frmPatient patient, String uid, String aid){
        initComponents();
        this.uid = uid;
        this.patient = patient;
        rs = Importdb.getListofDoctorNames(this.uid);
        if(rs != null){
            String doctorName;
            String doctorUid;
            try{
                while(rs.next()){
                    
                    doctorName = rs.getString("name");
                    doctorUid = rs.getString("did");
                    if(doctorName != null && doctorUid != null){
                        doctorNames.add(doctorName);
                        doctorUids.add(doctorUid);
                    }else{
                        System.out.println("Either a doctor name or uid was null with did: " + doctorUid
                                   + " or name: " + doctorName + ".");
                    }
                    
                }
                for(int i = 0; i < doctorNames.size(); i++){
                    cmbDoctors.addItem(doctorNames.get(i));
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(this, "No doctors found in database.");
        }
        System.out.println("Aid is " + aid);
        ResultSet rs = Importdb.viewAppointment(aid);
        try{
            if(rs.next()){
                String did = rs.getString("did");
                String doctorName = Importdb.getName(did);
                for(int i = 0; i < cmbDoctors.getItemCount(); i++){
                    if(cmbDoctors.getItemAt(i).equals(doctorName)){
                        cmbDoctors.setSelectedIndex(i);
                        break;
                    }
                }
                cmbDoctors.setEnabled(false);
                txtDate.setText(rs.getString("dates"));
                txtDate.setEditable(false);
                txtReason.setText(rs.getString("reason"));
                txtReason.setEditable(false);
                btnSchedule.setVisible(false);
                notes.setText(rs.getString("notes"));
                notes.setVisible(true);
                notes.setEditable(false);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbDoctors = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtReason = new javax.swing.JTextArea();
        btnSchedule = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnLookup = new javax.swing.JButton();
        notes = new javax.swing.JTextField();
        noteslb = new javax.swing.JLabel();
        txtDate = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Date:");

        jLabel2.setText("Doctor:");

        jLabel3.setText("Reason for Visit:");

        txtReason.setColumns(20);
        txtReason.setRows(5);
        jScrollPane1.setViewportView(txtReason);

        btnSchedule.setText("Schedule!");
        btnSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScheduleActionPerformed(evt);
            }
        });

        btnCancel.setText("Close");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnLookup.setText("Look at info");

        notes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notesActionPerformed(evt);
            }
        });

        noteslb.setText("Notes:");

        txtDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(notes)
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSchedule, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLookup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noteslb)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(81, 81, 81)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbDoctors, 0, 90, Short.MAX_VALUE)
                                    .addComponent(txtDate))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbDoctors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLookup))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(noteslb, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(notes, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSchedule)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScheduleActionPerformed
        // TODO add your handling code here:
        if(txtDate.getText() == ""){
            JOptionPane.showMessageDialog(null, "Please enter a date.");
            txtDate.requestFocusInWindow();
            return;
        }
        
        java.util.Date inputDate = null;
        java.util.Date currTime = new java.util.Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        try{
            inputDate = df.parse(txtDate.getText());
        }catch(Exception e){
            e.printStackTrace();
        }
        
        if(currTime.after(inputDate)){
            JOptionPane.showMessageDialog(null, "The date entered is in the past, please enter a valid date in the future.");
            txtDate.requestFocusInWindow();
            return;
        }
        if(cmbDoctors.getSelectedIndex() != -1) {
            Importdb.makeAppointment(doctorUids.get(cmbDoctors.getSelectedIndex()), uid, txtReason.getText(), txtDate.getText());
           
            JOptionPane.showMessageDialog(null, "Appointment has been scheduled!");
        }else{
            JOptionPane.showMessageDialog(null, "No doctor is selected.");
        }
    }//GEN-LAST:event_btnScheduleActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
        patient.setVisible(true);
        patient.updateApptTable();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void notesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_notesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPatientApptInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPatientApptInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPatientApptInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPatientApptInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnLookup;
    private javax.swing.JButton btnSchedule;
    private javax.swing.JComboBox cmbDoctors;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField notes;
    private javax.swing.JLabel noteslb;
    private javax.swing.JFormattedTextField txtDate;
    private javax.swing.JTextArea txtReason;
    // End of variables declaration//GEN-END:variables
}
