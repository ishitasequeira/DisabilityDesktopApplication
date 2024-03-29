/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Common.PatientHistory;

import Business.DisabilityCenter;
import Business.Enterprise.Enterprise;
import Business.Enterprise.PatientEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.Patient;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cardinal
 */
public class AllPatientHistoryJPanel extends javax.swing.JPanel {

    private  JPanel bottomPanel;
    private Enterprise enterprise;
    private Organization organization;
    private DisabilityCenter business;
    private UserAccount userAccount;

    /**
     * Creates new form PatientHistoryJPanel
     */
    public AllPatientHistoryJPanel(JPanel bottomPanel, 
                                   Enterprise enterprise,
                                   Organization organization,
                                   DisabilityCenter business,
                                   UserAccount userAccount) {
        initComponents();

        this.bottomPanel = bottomPanel;
        this.enterprise = enterprise;
        this.organization = organization;
        this.business = business;
        this.userAccount = userAccount;

        populateTable();
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) PatientListJTable.getModel();

        model.setRowCount(0);

        ArrayList<Enterprise> currentEnterpriseList = null;
        ArrayList<Organization> patientOrganizationDir = null;

        //Step 1: Get current Network's enterprise list
        for (Network n : business.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                if (this.enterprise.equals(e)) {
                    currentEnterpriseList = n.getEnterpriseDirectory().getEnterpriseList();
                    break;
                }
            }
        }
        //Step 2: get Patient Organization List from current Enterprise List
        for (Enterprise e : currentEnterpriseList) {
            if (e instanceof PatientEnterprise) {
                patientOrganizationDir = e.getOrganizationDirectory().getOrganizationList();
                break;
            }
        }
        //Step 3: add each patient from Patient Organization List
        for (Organization p : patientOrganizationDir) {
            Patient patient = (Patient) p;
            Object row[] = new Object[2];
            row[0] = patient.getPatientID();
            row[1] = patient;
            model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        PatientListJTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnViewHistory = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(192, 159, 128));

        PatientListJTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PatientListJTable.setForeground(new java.awt.Color(118, 50, 63));
        PatientListJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient ID", "Patient Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(PatientListJTable);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(118, 50, 63));
        jLabel2.setText("Patients in this Network:");

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(118, 50, 63));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Common/PatientHistory/icons8_Back_To_32px_1.png"))); // NOI18N
        btnBack.setText(" Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnViewHistory.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnViewHistory.setForeground(new java.awt.Color(118, 50, 63));
        btnViewHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Common/PatientHistory/icons8_Activity_History_32px.png"))); // NOI18N
        btnViewHistory.setText("View History");
        btnViewHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewHistoryActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(118, 50, 63));
        jLabel6.setText("Patient History");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnViewHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(16, 16, 16)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(255, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(68, 68, 68)
                .addComponent(jLabel2)
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnViewHistory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack)
                .addContainerGap(137, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        bottomPanel.remove(this);
        CardLayout layout = (CardLayout) bottomPanel.getLayout();
        layout.previous(bottomPanel);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnViewHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewHistoryActionPerformed
        int row = PatientListJTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Please make a selection!!");
            return;
        }
        Patient patient = (Patient) PatientListJTable.getValueAt(row, 1);
        PatientInfoJPanel patientInfoJPanel = new PatientInfoJPanel(bottomPanel, userAccount, organization, patient, business);
        CardLayout cardLayout = (CardLayout) bottomPanel.getLayout();
        bottomPanel.add(patientInfoJPanel);
        cardLayout.next(bottomPanel);
    }//GEN-LAST:event_btnViewHistoryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable PatientListJTable;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnViewHistory;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
