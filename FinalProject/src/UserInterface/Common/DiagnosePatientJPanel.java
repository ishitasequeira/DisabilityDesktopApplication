/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Common;

import Business.DisabilityCenter;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Patient.PatientHistory;
import Business.Enterprise.SupplierEnterprise;
import Business.Network.Network;
import Business.Organization.InventoryManager;
import Business.Organization.Organization;
import Business.Organization.Patient;
import Business.Organization.Receptionist;
import Business.Organization.Doctor;
import Business.Organization.Nurse;
import Business.Organization.Supplier;
import Business.Organization.SupplierProduct.Product;
import Business.Role.DoctorRole;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AppointmentWorkRequest;
import Business.WorkQueue.OrderWorkRequest;
import Business.WorkQueue.PatientWaitRequest;
import Business.WorkQueue.WorkRequest;
import EmailConfiguration.EmailConfig;
import UserInterface.Common.PatientHistory.PatientInfoJPanel;
import java.awt.CardLayout;
import java.awt.Component;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tejas
 */
public class DiagnosePatientJPanel extends javax.swing.JPanel {

    private JPanel bottomPanel;
    private UserAccount userAccount;
    private Organization organization;
    private Patient patient;
    private DisabilityCenter business;
    private PatientHistory patientHistory;
    private boolean isDoctor;
    private boolean isNurse;
    private boolean existingHistory;
    private ArrayList<Product> oldPrescription;
    private ArrayList<Product> prescrptionList;

    /**
     * Creates new form DiagnosePatientJPanel
     */
    public DiagnosePatientJPanel(JPanel bottomPanel, UserAccount userAccount, Organization organization, Patient patient, DisabilityCenter business, PatientHistory patientHistory) {
        initComponents();
        this.bottomPanel = bottomPanel;
        this.userAccount = userAccount;
        this.organization = organization;
        this.patient = patient;
        this.business = business;
        prescrptionList = new ArrayList<>();

        //Determine if user is Doctor or Nurse
        if (userAccount.getRole() instanceof DoctorRole) {
            this.isDoctor = true;
            this.isNurse = false;
        } else {
            this.isDoctor = false;
            this.isNurse = true;
        }

        if (this.isNurse) {
            this.lblPrescription.setText("Equipment:");
        }

        //Determine if editing existing Patient History or creating new
        //If editing existing Patient History, default the fields
        if (patientHistory == null) {
            this.existingHistory = false;
        } else {
            //disable the ui elements
            comboItem.setVisible(false);
            jLabel3.setVisible(false);
            qtySpinner.setVisible(false);
            btnAddProduct.setVisible(false);
            btnRemoveProduct.setVisible(false);

            this.existingHistory = true;
            this.patientHistory = patientHistory;
            txtDiagnosisNotes.setText(patientHistory.getDiagnosis());
            if (patientHistory.getDoctor() != null) {
                populatePrescriptionTable(patientHistory.getPrescription());
                this.oldPrescription = patientHistory.getPrescription();
            } else {
                populatePrescriptionTable(patientHistory.getEquipment());
                this.oldPrescription = patientHistory.getEquipment();
            }
        }

        populatePrescriptionComboBox();

    }

    private void populatePrescriptionTable(ArrayList<Product> products) {
        DefaultTableModel model = (DefaultTableModel) prescriptionTable.getModel();
        for (Product p : products) {
            Object row[] = new Object[2];
            row[0] = p;
            row[1] = p.getQuantity();
            model.addRow(row);
        }
    }

    private void populatePrescriptionComboBox() {

        //clear out the combo box
        comboItem.removeAllItems();

        //Step 1 : get the network of the current organization
        Network currentNetwork = null;
        for (Network network : business.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    if (this.organization.equals(organization)) {
                        currentNetwork = network;
                    }
                }
            }
        }

        //Step 2 : get the supplier enterprise and populate the combo box with the products
        for (Enterprise enterprise : currentNetwork.getEnterpriseDirectory().getEnterpriseList()) {
            if (enterprise instanceof SupplierEnterprise) {
                for (Organization s : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    Supplier supplier = (Supplier) s;
                    for (Product product : supplier.getProductCatalog().getProductList()) {
                        if (this.isDoctor && product.isIsPhysical()) {
                            continue;
                        }
                        if (this.isNurse && !product.isIsPhysical()) {
                            continue;
                        }
                        comboItem.addItem(product);
                    }
                }
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

        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiagnosisNotes = new javax.swing.JTextArea();
        lblPrescription = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnSaveDiagnosis = new javax.swing.JButton();
        btnViewPatientHistory = new javax.swing.JButton();
        comboItem = new javax.swing.JComboBox();
        qtySpinner = new javax.swing.JSpinner();
        btnAddProduct = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        prescriptionTable = new javax.swing.JTable();
        btnRemoveProduct = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(118, 50, 63));
        jLabel4.setText("Shift Check-In / Check-Out");

        setBackground(new java.awt.Color(192, 159, 128));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(118, 50, 63));
        jLabel2.setText("Diagnosis:");

        txtDiagnosisNotes.setColumns(20);
        txtDiagnosisNotes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDiagnosisNotes.setForeground(new java.awt.Color(118, 50, 63));
        txtDiagnosisNotes.setRows(5);
        jScrollPane1.setViewportView(txtDiagnosisNotes);

        lblPrescription.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblPrescription.setForeground(new java.awt.Color(118, 50, 63));
        lblPrescription.setText("Prescription:");

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(118, 50, 63));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Common/icons8_Back_To_32px_1.png"))); // NOI18N
        btnBack.setText(" Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnSaveDiagnosis.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnSaveDiagnosis.setForeground(new java.awt.Color(118, 50, 63));
        btnSaveDiagnosis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Common/icons8_Save_as_32px_1.png"))); // NOI18N
        btnSaveDiagnosis.setText("Save Diagnosis");
        btnSaveDiagnosis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveDiagnosisActionPerformed(evt);
            }
        });

        btnViewPatientHistory.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnViewPatientHistory.setForeground(new java.awt.Color(118, 50, 63));
        btnViewPatientHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Common/icons8_Activity_History_32px.png"))); // NOI18N
        btnViewPatientHistory.setText("View Patient History");
        btnViewPatientHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewPatientHistoryActionPerformed(evt);
            }
        });

        comboItem.setForeground(new java.awt.Color(118, 50, 63));

        btnAddProduct.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAddProduct.setForeground(new java.awt.Color(118, 50, 63));
        btnAddProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Common/icons8_Add_32px_1.png"))); // NOI18N
        btnAddProduct.setText("Add");
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(118, 50, 63));
        jLabel3.setText("Quantity:");

        prescriptionTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        prescriptionTable.setForeground(new java.awt.Color(118, 50, 63));
        prescriptionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(prescriptionTable);

        btnRemoveProduct.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnRemoveProduct.setForeground(new java.awt.Color(118, 50, 63));
        btnRemoveProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Common/icons8_Delete_32px_1.png"))); // NOI18N
        btnRemoveProduct.setText("Remove");
        btnRemoveProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveProductActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(118, 50, 63));
        jLabel5.setText("Patient Diagnosis");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnBack, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(45, 45, 45)
                                .addComponent(jScrollPane1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblPrescription)
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(btnSaveDiagnosis)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnViewPatientHistory))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(comboItem, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(qtySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAddProduct)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnRemoveProduct))
                                    .addComponent(jScrollPane3)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(jLabel5)))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrescription)
                    .addComponent(qtySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddProduct)
                    .addComponent(jLabel3)
                    .addComponent(btnRemoveProduct))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveDiagnosis)
                    .addComponent(btnViewPatientHistory))
                .addGap(58, 58, 58)
                .addComponent(btnBack)
                .addContainerGap(104, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        bottomPanel.remove(this);

        Component[] components = bottomPanel.getComponents();
        Component component = components[components.length - 1];
        PatientQueueJPanel pqjp = (PatientQueueJPanel) component;
        pqjp.refreshQueue();

        CardLayout layout = (CardLayout) bottomPanel.getLayout();
        layout.previous(bottomPanel);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSaveDiagnosisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveDiagnosisActionPerformed
        //Save diagnosis
        try {
            if (!this.existingHistory) {
                patientHistory = new PatientHistory();
                this.patient.createPatientHistory(patientHistory);
            }

            patientHistory.setDateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
            patientHistory.setDiagnosis(txtDiagnosisNotes.getText());

            if (this.isDoctor) {
                patientHistory.setDoctor(userAccount.getEmployee());
            } else {
                patientHistory.setNurse(userAccount.getEmployee());
            }

        JOptionPane.showMessageDialog(null, "Diagnosis saved successfully!");
        java.util.logging.Logger.getLogger(DiagnosePatientJPanel.class.getName()).log(java.util.logging.Level.INFO, "Diagnosis saved Successfully!");
        //update employees' patient's diagnosis count
        this.userAccount.getEmployee().incrementPatientsDiagnosed();

        //Check if patient needs to be sent to inventory
            //if prescription field is not empty
            //and if modifying the existing history and prescription is modified
            if (!prescrptionList.isEmpty()
                    || (this.existingHistory && areTwoPrescriptionsSame(this.oldPrescription, prescrptionList))) {
                OrderWorkRequest wr = new OrderWorkRequest(userAccount, null, "Prescription", patient, patientHistory);

                //Assign Work Request to Inventory Organization
                for (Network n : business.getNetworkList()) {
                    for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                        for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                            if (o instanceof InventoryManager) {
                                o.getWorkQueue().getWorkRequestList().add(wr);
                                break;
                            }
                        }
                    }
                }

                if (this.isDoctor) {
                    patientHistory.setPrescription(prescrptionList);
                    JOptionPane.showMessageDialog(null, "Send patient to Inventory Department for medicines");
                    java.util.logging.Logger.getLogger(DiagnosePatientJPanel.class.getName()).log(java.util.logging.Level.INFO, "Send patient to Inventory Deprtment for medicines");
                } else {
                    patientHistory.setEquipment(prescrptionList);
                    JOptionPane.showMessageDialog(null, "Send patient to Inventory Department for equipment");
                    java.util.logging.Logger.getLogger(DiagnosePatientJPanel.class.getName()).log(java.util.logging.Level.INFO, "Send patient to Inventory Deprtment for equipment");
                }

            }

            //Set the employee to available
            this.userAccount.getEmployee().setIsAvailable(true);
            EmailConfig emailConfig = new EmailConfig();
            Properties smtpProperties = emailConfig.loadProperties();
            emailConfig.sendEmail(smtpProperties, this.patient.getPatientEmail(), "Diagnosis Report", txtDiagnosisNotes.getText());
            //Remove Patient from Patient WorkQueue
            for (WorkRequest w : userAccount.getWorkQueue().getWorkRequestList()) {
                if (this.patient.equals((Patient) w.getObject())) {
                    userAccount.getWorkQueue().getWorkRequestList().remove(w);
                    break;
                }
            }
        } catch (IOException ex) {
            System.out.println("IO Exception" + ex.getMessage());
        } catch (MessagingException ex) {
            System.out.println("Messaging Exception" + ex.getMessage());
        }

        //Update the Patient Wait Queue, fetch the receptionist organization
        //Step 1: Get current Network's enterprise
        Enterprise currentEnterprise = getCurrentEnterprise();
        //Step 2: find the receptionist organization from currentEnterprise
        for (Organization o : currentEnterprise.getOrganizationDirectory().getOrganizationList()) {
            if (o instanceof Receptionist) {
                //remove the patient checkedin from patients hashmap
                Receptionist receptionist = (Receptionist) o;
                receptionist.getPatientsCheckedin().remove(patient.getPatientID());

                for (UserAccount ua : o.getUserAccountDirectory().getUserAccountList()) {
                    updatePatientWaitQueue(ua, currentEnterprise);
                }
            }
        }
        EmailConfig configuration = new EmailConfig();
        Properties smtpProperties = null;
        try {
            smtpProperties = configuration.loadProperties();
        } catch (IOException ex) {
            Logger.getLogger(DiagnosePatientJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            configuration.sendEmail(smtpProperties, this.patient.getPatientEmail(), "Diagnosis Update", txtDiagnosisNotes.getText()+"/nPlease proceed to the inventory department.");
        } catch (MessagingException ex) {
            Logger.getLogger(DiagnosePatientJPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DiagnosePatientJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveDiagnosisActionPerformed

    private boolean areTwoPrescriptionsSame(ArrayList<Product> p1, ArrayList<Product> p2) {
        //null checking
        if (p1 == null && p2 == null) {
            return true;
        }
        if ((p1 == null && p2 != null) || (p1 != null && p2 == null)) {
            return false;
        }

        if (p1.size() != p2.size()) {
            return false;
        }
        for (Product prod1 : p1) {
            if (!p2.contains(prod1)) {
                return false;
            }
        }

        return true;
    }

    public Enterprise getCurrentEnterprise() {
        Enterprise currentEnterprise = null;
        for (Network n : business.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                    if (o instanceof Organization) {
                        currentEnterprise = e;
                        break;
                    }
                }
            }
        }
        return currentEnterprise;
    }

    public void updatePatientWaitQueue(UserAccount receptionist, Enterprise currentEnterprise) {

        WorkRequest removeRequest = null;
        ArrayList<WorkRequest> receptionistWaitQueue = receptionist.getWorkQueue().getWorkRequestList();
        //loop through each Wait Queue for status "Waiting"

        for (WorkRequest w : receptionistWaitQueue) {
            if (!w.getStatus().equals("Waiting")) {
                if (w.getObject().equals(this.patient)) {
                    removeRequest = w;
                }
                continue;
            }
            PatientWaitRequest wr = (PatientWaitRequest) w;
            Patient patient = (Patient) w.getObject();
            boolean sendToDoctor = wr.getDisabilityType().equals("Mental");
            ArrayList<Employee> availableDoctors = new ArrayList<>();

            Organization org = null;

            for (Organization organization : currentEnterprise.getOrganizationDirectory().getOrganizationList()) {
                if (sendToDoctor
                        && organization instanceof Doctor) {
                    org = organization;
                }
                if (!sendToDoctor
                        && organization instanceof Nurse) {
                    org = organization;
                }
                if (org != null) {
                    for (Employee e : organization.getEmployeeDirectory().getEmployeeList()) {
                        if (e.getIsCheckedIn() && e.getIsAvailable()) {
                            availableDoctors.add(e);
                        }
                    }
                    break;
                }
            }

            if (availableDoctors.size() > 0) {
                //Step 1: sort availableDoctors based on patients diagnosed
                Collections.sort(availableDoctors, new Comparator<Employee>() {
                    @Override
                    public int compare(Employee o1, Employee o2) {
                        return o1.getPatientsDiagnosed() - o2.getPatientsDiagnosed();
                    }
                });
                Employee assignedEmployee = availableDoctors.get(0);
                //Step 2: Add the patient to assignedEmployee's work queue
                for (UserAccount useracc : org.getUserAccountDirectory().getUserAccountList()) {
                    if (useracc.getEmployee().equals(assignedEmployee)) {
                        AppointmentWorkRequest appointmentWorkRequest = new AppointmentWorkRequest();
                        appointmentWorkRequest.setSender(userAccount);
                        appointmentWorkRequest.setMessage("Employee assigned");
                        appointmentWorkRequest.setStatus("Sent");
                        appointmentWorkRequest.setReceiver(useracc);
                        appointmentWorkRequest.setObject(patient);
                        useracc.getWorkQueue().getWorkRequestList().add(appointmentWorkRequest);
                        //Set the employee to be not available
                        java.util.logging.Logger.getLogger(DiagnosePatientJPanel.class.getName()).log(java.util.logging.Level.INFO, appointmentWorkRequest.log());
                        assignedEmployee.setIsAvailable(false);

                        break;
                    }
                }
                //Step 3: Update the Wait Queue
                if (sendToDoctor) {
                    wr.setStatus("Assigned to Doctor");
                } else {
                    wr.setStatus("Assigned to Nurse");
                }
                wr.setAssignedEmployee(assignedEmployee);
                java.util.logging.Logger.getLogger(DiagnosePatientJPanel.class.getName()).log(java.util.logging.Level.INFO, wr.log());
            }
        }

        //Remove the work request for current patient if present in queue
        if (removeRequest != null) {
            receptionistWaitQueue.remove(removeRequest);
        }
    }

    private void btnViewPatientHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewPatientHistoryActionPerformed
        PatientInfoJPanel patientInfoJPanel = new PatientInfoJPanel(bottomPanel, userAccount, organization, patient, business);
        CardLayout cardLayout = (CardLayout) bottomPanel.getLayout();
        bottomPanel.add(patientInfoJPanel);
        cardLayout.next(bottomPanel);
    }//GEN-LAST:event_btnViewPatientHistoryActionPerformed

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed

        Product selectedProduct = (Product) comboItem.getSelectedItem();

        int productQuantity = (Integer) qtySpinner.getValue();
        if (productQuantity <= 0) {
            JOptionPane.showMessageDialog(null, "Select a quantity greater than 0");
            java.util.logging.Logger.getLogger(DiagnosePatientJPanel.class.getName()).log(java.util.logging.Level.INFO, "Quantity needs to be greater than 0");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) prescriptionTable.getModel();
        //add the product to the table
        //search if the product is already present
        int rows = model.getRowCount();
        if (prescrptionList.contains(selectedProduct)) {
            for (int i = 0; i < rows; i++) {
                Product prod = (Product) model.getValueAt(i, 0);
                if (prod.equals(selectedProduct)) {
                    model.setValueAt(productQuantity, i, 1);
                    break;
                }
            }
        } else {
            prescrptionList.add(selectedProduct);
            selectedProduct.setQuantity(productQuantity);
            Object[] row = new Object[model.getColumnCount()];
            row[0] = selectedProduct;
            row[1] = productQuantity;
            model.addRow(row);
            java.util.logging.Logger.getLogger(DiagnosePatientJPanel.class.getName()).log(java.util.logging.Level.INFO, "Product added to order list!");
        }


    }//GEN-LAST:event_btnAddProductActionPerformed

    private void btnRemoveProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveProductActionPerformed
        int selectedRow = prescriptionTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a Product!!");
            return;
        }
        Product selectedProduct = (Product) prescriptionTable.getValueAt(selectedRow, 0);
        prescrptionList.remove(selectedProduct);

        //remove the row from the table
        DefaultTableModel model = (DefaultTableModel) prescriptionTable.getModel();
        int rows = model.getRowCount();
        for (int i = 0; i < rows; i++) {
            Product prod = (Product) model.getValueAt(i, 0);
            if (prod.equals(selectedProduct)) {
                model.removeRow(i);
                java.util.logging.Logger.getLogger(DiagnosePatientJPanel.class.getName()).log(java.util.logging.Level.INFO, "Product removed from order list!");
                break;
            }
        }

    }//GEN-LAST:event_btnRemoveProductActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRemoveProduct;
    private javax.swing.JButton btnSaveDiagnosis;
    private javax.swing.JButton btnViewPatientHistory;
    private javax.swing.JComboBox comboItem;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblPrescription;
    private javax.swing.JTable prescriptionTable;
    private javax.swing.JSpinner qtySpinner;
    private javax.swing.JTextArea txtDiagnosisNotes;
    // End of variables declaration//GEN-END:variables
}
