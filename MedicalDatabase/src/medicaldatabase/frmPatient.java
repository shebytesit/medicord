/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package medicaldatabase;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
/**
 *
 * @author Seth
 */
public class frmPatient extends javax.swing.JFrame {
    private Login login;
    private String id;
    private ArrayList<String> doctorNames;
    private ArrayList<String> apptIds;
    private ArrayList<String> apptDates;
    
    /**
     * Creates new form frmPatient
     */
    public frmPatient(Login login) {
        this.login = login;
        this.id=login.getUserId();
        initComponents();
        login.setVisible(false);
        setVisible(true);
        doctorNames = new ArrayList<String>();
        apptIds = new ArrayList<String>();
        apptDates = new ArrayList<String>();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaAllergies = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaMedicalHistory = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txaCurrentMedication = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtEmergencyContact = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        txtDob = new javax.swing.JFormattedTextField();
        female = new javax.swing.JRadioButton();
        male = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAppointments = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        lblWelcome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel2.setText("Name:");

        jLabel3.setText("Date of birth:");

        jLabel4.setText("Gender:");

        jLabel5.setText("Emergency Contact Number:");

        jLabel7.setText("Allergies:");

        txaAllergies.setColumns(20);
        txaAllergies.setRows(5);
        txaAllergies.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txaAllergiesKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txaAllergies);

        txaMedicalHistory.setColumns(20);
        txaMedicalHistory.setRows(5);
        txaMedicalHistory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txaMedicalHistoryKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txaMedicalHistory);

        txaCurrentMedication.setColumns(20);
        txaCurrentMedication.setRows(5);
        txaCurrentMedication.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txaCurrentMedicationKeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(txaCurrentMedication);

        jLabel8.setText("Current Medication:");

        jLabel10.setText("Medical History:");

        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameKeyTyped(evt);
            }
        });

        txtEmergencyContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmergencyContactActionPerformed(evt);
            }
        });

        jButton4.setText("Save Changes");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtDob.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        buttonGroup2.add(female);
        female.setText("Female");

        buttonGroup2.add(male);
        male.setText("Male");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 33, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(138, 138, 138)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmergencyContact, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(344, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDob, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(male)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(female))
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5))
                        .addGap(0, 458, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(male)
                            .addComponent(female))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmergencyContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jButton4)
                .addGap(92, 92, 92))
        );

        jTabbedPane1.addTab("Account Information", jPanel1);

        jButton2.setText("Make New Appointment");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        jButton3.setText("View Appointment Information");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);

        tblAppointments.setRowSelectionAllowed(true);
        tblAppointments.setAutoCreateRowSorter(true);
        tblAppointments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Appointment number", "Doctor Name", "Date of appointment"
            }){
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }

            }

        );
        tblAppointments.getTableHeader().setReorderingAllowed(false);
        tblAppointments.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblAppointments.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblAppointments.setShowVerticalLines(false);
        jScrollPane3.setViewportView(tblAppointments);

        jPanel2.add(jScrollPane3);

        jTabbedPane1.addTab("Appointments", jPanel2);

        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblWelcome.setText("Welcome");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Logout button
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        login.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            // TODO add your handling code here:
            ResultSet r = Importdb.getUserInfo(id);
            if(r!=null){
                r.next();
                txtName.setText(r.getString("name"));
                
                if(txtName.getText().isEmpty())
                {
                    lblWelcome.setText("Welcome, please fill out your information.");
                }
                else lblWelcome.setText("Welcome "+r.getString("name")+"!");
                
                txtDob.setText(r.getString("dob"));                
                
                txtEmergencyContact.setText(r.getString("gender"));

                String gender;
                if (r.getString("gender") != null && r.getString("gender").isEmpty()==false)
                {
                    gender = r.getString("gender");
                    if (gender.toUpperCase().contains("M"))
                    {
                        male.setSelected(true);
                    }
                    else
                    {
                        female.setSelected(true);
                    }
                }
                
                txtEmergencyContact.setText(r.getString("econtact"));
                txaAllergies.setText(r.getString("allergies"));
                txaCurrentMedication.setText(r.getString("medication"));
                txaMedicalHistory.setText(r.getString("history"));
                int count = 0;
                r=Importdb.viewAppointments(id);
                DefaultTableModel model = (DefaultTableModel) tblAppointments.getModel();
                if(r!=null){
                    while(r.next()){
                        doctorNames.add(Importdb.getName(r.getString("did")));
                        apptIds.add(r.getString("aid"));
                        apptDates.add(r.getString("dates"));
                        model.addRow(new Object[]{apptIds.get(count),doctorNames.get(count) ,apptDates.get(count)});
                        count++;
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "Database error");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_formWindowOpened

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // save changes button
        //String phone = new String();
        StringBuilder phone = new StringBuilder();
        char[] chars = txtEmergencyContact.getText().toCharArray();
        //Character [] digits = new Character[10];
        //int j=0;
        for(int i=0;i<chars.length;i++){
            if(Character.isDigit(chars[i])){
                //digits[j] = chars[i];
                phone.append(chars[i]);
                //j++;
            }
      //          for (int i = 0; i < chars.length; i++) {
      //  characters[i]=chars[i];
      //  System.out.println(chars[i]);
        }
        int pLen = phone.toString().length();
        StringBuilder modNum = new StringBuilder();
        switch(pLen){
            case 0:
                txtEmergencyContact.setText("");
                break;
            case 7:
                modNum.append(phone.substring(0, 3));
                modNum.append("-");
                modNum.append(phone.substring(3, 7));
                txtEmergencyContact.setText(modNum.toString());
                break;
            case 10: 
                modNum.append("(");
                modNum.append(phone.substring(0, 3));
                modNum.append(")");
                modNum.append(phone.substring(3, 6));
                modNum.append("-");
                modNum.append(phone.substring(6, 10));
                txtEmergencyContact.setText(modNum.toString());
                break;
            default:
                JOptionPane.showMessageDialog(this, "Please Enter Valid Phone Number!");
                return;
        }
                    
        //txtEmergencyContact.setText(phone.toString());
             
        if (male.isSelected())
        {
  
        Importdb.setPatientProfile(id,txtName.getText(),txtDob.getText(),"M",txaAllergies.getText(),
        
            txaCurrentMedication.getText(),txaMedicalHistory.getText(),txtEmergencyContact.getText());
        }
        else
        {
              
        Importdb.setPatientProfile(id,txtName.getText(),txtDob.getText(),"F",txaAllergies.getText(),
        
            txaCurrentMedication.getText(),txaMedicalHistory.getText(),txtEmergencyContact.getText());
        }
                if(txtName.getText().isEmpty())
                {
                    lblWelcome.setText("Welcome, please fill out your information.");
                }
                else lblWelcome.setText("Welcome "+txtName.getText()+"!");
                
        JOptionPane.showMessageDialog(this, "Credentials saved!");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String apptId = null;
        if(tblAppointments.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Please select an appointment first.");
            return;
        }else{
            apptId = (String)tblAppointments.getValueAt(tblAppointments.getSelectedRow(), 0);
        }
        if(apptId != null){
            frmPatientApptInfo apptInfo = new frmPatientApptInfo(this, id, apptId);
            apptInfo.setVisible(true);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        frmPatientApptInfo apptInfo = new frmPatientApptInfo(this, id);
        apptInfo.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtEmergencyContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmergencyContactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmergencyContactActionPerformed

    private void txaCurrentMedicationKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaCurrentMedicationKeyTyped
        // TODO add your handling code here:
        if(evt.getKeyCode() != KeyEvent.VK_BACK_SPACE){ 
            if(txaCurrentMedication.getText().length()>99){
                txaCurrentMedication.setText(txaCurrentMedication.getText().substring(0,99));
                JOptionPane.showMessageDialog(this, "Character Limit exceeded");
            }
        }
    }//GEN-LAST:event_txaCurrentMedicationKeyTyped

    private void txaAllergiesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaAllergiesKeyTyped
       if(evt.getKeyCode() != KeyEvent.VK_BACK_SPACE){
           if(txaAllergies.getText().length()>99){
                txaAllergies.setText(txaAllergies.getText().substring(0,99));
                JOptionPane.showMessageDialog(this, "Character Limit exceeded");
            }
        }
    }//GEN-LAST:event_txaAllergiesKeyTyped

    private void txaMedicalHistoryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaMedicalHistoryKeyTyped
       if(evt.getKeyCode() != KeyEvent.VK_BACK_SPACE){
           if(txaMedicalHistory.getText().length()>99){
                txaMedicalHistory.setText(txaMedicalHistory.getText().substring(0,99));
                JOptionPane.showMessageDialog(this, "Character Limit exceeded");
            }
        }
    }//GEN-LAST:event_txaMedicalHistoryKeyTyped

    private void txtNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyTyped
        if(evt.getKeyCode() != KeyEvent.VK_BACK_SPACE){
           if(txtName.getText().length()>19){
                txtName.setText(txtName.getText().substring(0,19));
                JOptionPane.showMessageDialog(this, "Character Limit exceeded");
            }
        }
    }//GEN-LAST:event_txtNameKeyTyped

    private void txtNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyPressed

    }//GEN-LAST:event_txtNameKeyPressed

    public void updateApptTable() {
        DefaultTableModel model = (DefaultTableModel)tblAppointments.getModel(); 
        int rows = model.getRowCount(); 
        for(int i = rows - 1; i >=0; i--)
        {
            model.removeRow(i); 
        }
        
        try{
            ResultSet r=Importdb.viewAppointments(id);
            if(r!=null){
                while(r.next()){
                    model.addRow(new Object[]{r.getString("aid"),Importdb.getName(r.getString("did")) ,r.getString("dates")});
                    System.out.println("DATA IN MAKEAAPOINTMENT" + Importdb.getName(r.getString("did")));
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
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
            java.util.logging.Logger.getLogger(frmPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login login = new Login();
                new frmPatient(login).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton female;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JRadioButton male;
    private javax.swing.JTable tblAppointments;
    private javax.swing.JTextArea txaAllergies;
    private javax.swing.JTextArea txaCurrentMedication;
    private javax.swing.JTextArea txaMedicalHistory;
    private javax.swing.JFormattedTextField txtDob;
    private javax.swing.JTextField txtEmergencyContact;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
