/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.InventoryManager;

import Business.DisabilityCenter;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Patient.PatientHistory;
import Business.Enterprise.PatientEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.Patient;
import Business.WorkQueue.OrderWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cardinal
 */
public class ProvideEquipmentMedicinesJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ProvideEquipmentMedicinesJPanel
     */
    private JPanel bottomPanel;
    private Organization organization;
    private DisabilityCenter business;

    public ProvideEquipmentMedicinesJPanel(JPanel bottomPanel, Organization organization, DisabilityCenter business) {
        initComponents();
        this.bottomPanel = bottomPanel;
        this.organization = organization;
        this.business = business;
        populateTable();
    }

    public void populateTable() {
        PatientDetailsJTable.removeAll();
        DefaultTableModel model = (DefaultTableModel) PatientDetailsJTable.getModel();
        model.setRowCount(0);
        
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
            if(!request.getStatus().equalsIgnoreCase("Delivered")){
                OrderWorkRequest order = (OrderWorkRequest)request;
                Object row[] = new Object[model.getColumnCount()];
                row[0] = order;
                row[1] = order.getPatient().getPatientName();
                row[2] = order.getStatus();
                model.addRow(row);
            }
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
        PatientDetailsJTable = new javax.swing.JTable();
        btnView = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(192, 159, 128));

        PatientDetailsJTable.setForeground(new java.awt.Color(118, 50, 63));
        PatientDetailsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Patient ID", "Patient Name", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(PatientDetailsJTable);
        if (PatientDetailsJTable.getColumnModel().getColumnCount() > 0) {
            PatientDetailsJTable.getColumnModel().getColumn(0).setResizable(false);
            PatientDetailsJTable.getColumnModel().getColumn(1).setResizable(false);
            PatientDetailsJTable.getColumnModel().getColumn(2).setResizable(false);
        }

        btnView.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnView.setForeground(new java.awt.Color(118, 50, 63));
        btnView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/InventoryManager/icons8_Search_32px.png"))); // NOI18N
        btnView.setText("View Details");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(118, 50, 63));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/InventoryManager/icons8_Back_To_32px_1.png"))); // NOI18N
        btnBack.setText(" Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(118, 50, 63));
        jLabel4.setText("Provide equipment And Medicines");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(142, 142, 142)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnView)
                                .addComponent(jLabel4)))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnBack))))
                .addContainerGap(256, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnView)
                .addGap(101, 101, 101)
                .addComponent(btnBack)
                .addContainerGap(110, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        int row = PatientDetailsJTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Please make a selection!!");
            return;
        }
        OrderWorkRequest orderWorkRequest = (OrderWorkRequest) PatientDetailsJTable.getValueAt(row, 0);
        ViewEquipmentMedicinesJPanel viewEquipmentMedicinesJPanel = new ViewEquipmentMedicinesJPanel(bottomPanel, orderWorkRequest);
        CardLayout cardLayout = (CardLayout) bottomPanel.getLayout();
        bottomPanel.add(viewEquipmentMedicinesJPanel);
        cardLayout.next(bottomPanel);
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        bottomPanel.remove(this);
        CardLayout layout = (CardLayout) bottomPanel.getLayout();
        layout.previous(bottomPanel);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable PatientDetailsJTable;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}