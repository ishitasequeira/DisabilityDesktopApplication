/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Receptionist;

import Business.Enterprise.Enterprise;
import Business.Enterprise.PatientEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.Patient;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author tejas
 */
public class PatientsFromDifferentNetwork extends javax.swing.JDialog {

    private JPanel bottomJPanel;
    private ArrayList<Network> networkList;
    private Network currentNetwork;
    /**
     * Creates new form PatientsFromDifferentNetwork
     */
    public PatientsFromDifferentNetwork(java.awt.Frame parent, boolean modal, JPanel bottomJPanel, ArrayList<Network> networkList) {
        super(parent, modal);
        initComponents();
        this.bottomJPanel = bottomJPanel;
        this.networkList = networkList;
        populateCombobox();
    }
    
    private void populateCombobox(){
        networkComboBox.removeAllItems();
        
        for(Network n : networkList){
            networkComboBox.addItem(n.getName());
        }
    }
    
    private void populatePatientComboBox(Network n){
        patientsComboBox.removeAllItems();
        for(Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()){
            if(e instanceof PatientEnterprise){
                for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
                    Patient patient = (Patient) o;
                    patientsComboBox.addItem(patient.getPatientName());
                }
                break;
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

        jLabel2 = new javax.swing.JLabel();
        networkComboBox = new javax.swing.JComboBox<>();
        patientsComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnSelect = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(192, 159, 128));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(118, 50, 63));
        jLabel2.setText("Network:");

        networkComboBox.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        networkComboBox.setForeground(new java.awt.Color(118, 50, 63));
        networkComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkComboBoxActionPerformed(evt);
            }
        });

        patientsComboBox.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        patientsComboBox.setForeground(new java.awt.Color(118, 50, 63));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(118, 50, 63));
        jLabel3.setText("Patient:");

        btnSelect.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnSelect.setForeground(new java.awt.Color(118, 50, 63));
        btnSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Receptionist/icons8_Checkmark_32px_1.png"))); // NOI18N
        btnSelect.setText("Select");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(118, 50, 63));
        jLabel7.setText("Patient from Other Networks");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSelect, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(patientsComboBox, 0, 132, Short.MAX_VALUE)
                            .addComponent(networkComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(networkComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patientsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(38, 38, 38)
                .addComponent(btnSelect)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        String patientName = (String)patientsComboBox.getSelectedItem();
        Patient patient = null;
        boolean patientFound = false;
        for(Enterprise e : currentNetwork.getEnterpriseDirectory().getEnterpriseList()){
            for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
                patient = (Patient)o;
                if(patient.getPatientName().equals(patientName)){
                    patientFound = true;
                    break;
                }
            }
            if(patientFound){
                //remove the Patient from this network
                e.getOrganizationDirectory().removeOrganization(patient);
                break;
            }
        }
        
        //Update the patient value in the JFrame
        Component[] componentArray = bottomJPanel.getComponents();
        Component component = componentArray[componentArray.length - 1];
        CheckinPatientJPanel checkinJPanel = (CheckinPatientJPanel) component;
        checkinJPanel.setAndSavePatientNew(patient);
        
        //Close the Dialog
        this.setVisible(false);
    }//GEN-LAST:event_btnSelectActionPerformed

    private void networkComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkComboBoxActionPerformed
        String networkName = (String) networkComboBox.getSelectedItem();
        for(Network n : networkList){
            if(n.getName().equals(networkName)){
                populatePatientComboBox(n);
                this.currentNetwork = n;
                break;
            }
        }
    }//GEN-LAST:event_networkComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelect;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JComboBox<String> networkComboBox;
    private javax.swing.JComboBox<String> patientsComboBox;
    // End of variables declaration//GEN-END:variables
}
