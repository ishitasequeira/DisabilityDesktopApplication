/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Common;

import Business.DisabilityCenter;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.Receptionist;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import UserInterface.CenterHead.ManageUserAccountJPanel;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author cardinal
 */
public class CheckInCheckOutJPanel extends javax.swing.JPanel {

    private JPanel bottomPanel;
    private UserAccount userAccount;
    private Organization organization;
    private DisabilityCenter business;

    /**
     * Creates new form CheckInCheckOutJPanel
     */
    public CheckInCheckOutJPanel(JPanel bottomPanel, UserAccount userAccount, Organization organization, DisabilityCenter business) {
        initComponents();
        this.bottomPanel = bottomPanel;
        this.userAccount = userAccount;
        this.organization = organization;
        this.business = business;

        if (this.userAccount.getEmployee().getIsCheckedIn()) {
            this.CheckInButton.setEnabled(false);
            this.CheckOutButton.setEnabled(true);
            this.lblCheckInTime.setText("Checked in at : " + this.userAccount.getEmployee().getCheckedInTime());
        } else {
            this.CheckInButton.setEnabled(true);
            this.CheckOutButton.setEnabled(false);
            this.lblCheckInTime.setText("");
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

        CheckInButton = new javax.swing.JButton();
        CheckOutButton = new javax.swing.JButton();
        lblCheckInTime = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(192, 159, 128));

        CheckInButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        CheckInButton.setForeground(new java.awt.Color(118, 50, 63));
        CheckInButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Common/icons8_In_Progress_32px.png"))); // NOI18N
        CheckInButton.setText("Check-In");
        CheckInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckInButtonActionPerformed(evt);
            }
        });

        CheckOutButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        CheckOutButton.setForeground(new java.awt.Color(118, 50, 63));
        CheckOutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Common/icons8_Sign_Out_32px_1.png"))); // NOI18N
        CheckOutButton.setText("Check-Out");
        CheckOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckOutButtonActionPerformed(evt);
            }
        });

        lblCheckInTime.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCheckInTime.setForeground(new java.awt.Color(118, 50, 63));
        lblCheckInTime.setText("NA");

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(118, 50, 63));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Common/icons8_Back_To_32px_1.png"))); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(118, 50, 63));
        jLabel3.setText("Shift Check-In / Check-Out");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCheckInTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(79, 683, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CheckInButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CheckOutButton)
                        .addGap(133, 133, 133))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel3)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckInButton)
                    .addComponent(CheckOutButton))
                .addGap(18, 18, 18)
                .addComponent(lblCheckInTime)
                .addGap(82, 82, 82)
                .addComponent(btnBack)
                .addContainerGap(97, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CheckOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckOutButtonActionPerformed

        //check if any patients are in this employee's queue
        if (userAccount.getWorkQueue().getWorkRequestList().size() > 0) {
            JOptionPane.showMessageDialog(null, "Sorry! Checkout not possible, patients already waiting in queue");
            return;
        }

        //check if last checkedin doctor and patient wait queue is not empty
        //Step 1: get network list
        boolean patientsInWaitQueue = false;
        Enterprise currentEnterprise = null;
        for (Network n : business.getNetworkList()) {
            //Step2 : get enterprise
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                //Step 3 : iterate through organizations
                for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                    if (o.equals(organization)) {
                        currentEnterprise = e;
                        break;
                    }
                }
                if (currentEnterprise != null) {
                    break;
                }
            }
            if (currentEnterprise != null) {
                break;
            }
        }
        //Step 4: get receptionist organization
        if (currentEnterprise != null) {
            for (Organization o : currentEnterprise.getOrganizationDirectory().getOrganizationList()) {
                if (o instanceof Receptionist) {
                    for (UserAccount ua : o.getUserAccountDirectory().getUserAccountList()) {
                        for (WorkRequest w : userAccount.getWorkQueue().getWorkRequestList()) {
                            if (w.getStatus().equals("Waiting")) {
                                patientsInWaitQueue = true;
                                break;
                            }
                        }
                        if (patientsInWaitQueue) {
                            break;
                        }
                    }
                }
                if (patientsInWaitQueue) {
                    break;
                }
            }
        }
        //Step 5 : get number of checkedin employees in current organization
        int numberOfCheckedInEmployees = 0;
        for(Employee e : organization.getEmployeeDirectory().getEmployeeList()){
            if(e.getIsCheckedIn())
                numberOfCheckedInEmployees++;
        }
        
        if(patientsInWaitQueue
                && numberOfCheckedInEmployees <= 1){
            JOptionPane.showMessageDialog(null, "Sorry! Checkout not possible, patients waiting and no one else checked in.");
            return;
        }

        this.CheckInButton.setEnabled(true);
        this.CheckOutButton.setEnabled(false);

        this.userAccount.getEmployee().setIsCheckedIn(false);
        this.userAccount.getEmployee().setIsAvailable(false);
        this.userAccount.getEmployee().setCheckedInTime("");

        this.lblCheckInTime.setText("");
        JOptionPane.showMessageDialog(null, "Checked out successfully!!");
        java.util.logging.Logger.getLogger(CheckInCheckOutJPanel.class.getName()).log(java.util.logging.Level.INFO, "Checked-In at "+Calendar.getInstance().getTime());
    }//GEN-LAST:event_CheckOutButtonActionPerformed

    private void CheckInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckInButtonActionPerformed
        this.CheckInButton.setEnabled(false);
        this.CheckOutButton.setEnabled(true);

        Date date = Calendar.getInstance().getTime();
        String formattedDate = new SimpleDateFormat("HH:mm:ss").format(date);

        this.userAccount.getEmployee().setIsCheckedIn(true);
        this.userAccount.getEmployee().setIsAvailable(true);
        this.userAccount.getEmployee().setCheckedInTime(formattedDate);

        this.lblCheckInTime.setText("Checked in at : " + formattedDate);
        java.util.logging.Logger.getLogger(CheckInCheckOutJPanel.class.getName()).log(java.util.logging.Level.INFO, "Checked-In at "+formattedDate);
    }//GEN-LAST:event_CheckInButtonActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        bottomPanel.remove(this);
        CardLayout layout = (CardLayout) bottomPanel.getLayout();
        layout.previous(bottomPanel);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CheckInButton;
    private javax.swing.JButton CheckOutButton;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblCheckInTime;
    // End of variables declaration//GEN-END:variables
}