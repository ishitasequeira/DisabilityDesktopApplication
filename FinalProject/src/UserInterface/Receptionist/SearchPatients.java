/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Receptionist;

import Business.Organization.Organization;
import Business.Organization.Patient;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tejas
 */
public class SearchPatients extends javax.swing.JDialog {

    /**
     * Creates new form SearchPatients
     */
    
    private ArrayList<Patient> patientList;
    private JPanel bottomJPanel;
    
    public SearchPatients(java.awt.Frame parent, boolean modal, JPanel bottomJPanel, ArrayList<Patient> patientList) {
        super(parent, modal);
        initComponents();
        this.patientList = patientList;
        this.bottomJPanel = bottomJPanel;
        populateTable();
        
    }
    
    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) tblPatientList.getModel();
        model.setRowCount(0);
        
        for(Organization o : patientList){
            Patient patient = (Patient)o;
            Object row[] = new Object[3];
            row[0] = patient.getPatientID();
            row[1] = patient;
            row[2] = patient.getPatientEmail();
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
        tblPatientList = new javax.swing.JTable();
        btnSelect = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(192, 159, 128));

        tblPatientList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient ID", "Patient Name", "Patient Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPatientList);

        btnSelect.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnSelect.setForeground(new java.awt.Color(118, 50, 63));
        btnSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Receptionist/icons8_Checkmark_32px_1.png"))); // NOI18N
        btnSelect.setText("Select Patient");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(118, 50, 63));
        jLabel5.setText("Search Results");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSelect)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(64, 64, 64)
                            .addComponent(jLabel5))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSelect)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        
        
        int row = tblPatientList.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Please make a selection!!");
            return;
        }
        
        Patient patient = (Patient) tblPatientList.getValueAt(row, 1);
        
        //Update the patient value in the JFrame
        Component[] componentArray = bottomJPanel.getComponents();
        Component component = componentArray[componentArray.length - 1];
        CheckinPatientJPanel checkinJPanel = (CheckinPatientJPanel) component;
        checkinJPanel.setPatientNew(patient);
        
        //Close the Dialog
        this.setVisible(false);
    }//GEN-LAST:event_btnSelectActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelect;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPatientList;
    // End of variables declaration//GEN-END:variables
}