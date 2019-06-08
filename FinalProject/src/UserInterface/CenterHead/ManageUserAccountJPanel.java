/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CenterHead;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.CenterHead;
import Business.Organization.Doctor;
import Business.Organization.InventoryManager;
import Business.Organization.Nurse;
import Business.Organization.Organization;
import Business.Organization.Receptionist;
import Business.Organization.Supplier;
import Business.Role.DoctorRole;
import Business.Role.InventoryManagerRole;
import Business.Role.NurseRole;
import Business.Role.ReceptionistRole;
import Business.Role.Role;
import Business.Role.SupplierRole;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cardinal
 */
public class ManageUserAccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageUserAccountJPanel
     */
    private JPanel bottomPanel;
    private Enterprise enterprise;

    public ManageUserAccountJPanel(JPanel bottomPanel, Enterprise enterprise) {
        initComponents();
        this.enterprise = enterprise;
        this.bottomPanel = bottomPanel;

        popOrganizationComboBox();
        popData();
    }

    public void popOrganizationComboBox() {
        organizationJComboBox.removeAllItems();

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof CenterHead) {
                continue;
            }
            organizationJComboBox.addItem(organization);
        }
    }

    public void populateEmployeeComboBox(Organization organization) {
        employeeJComboBox.removeAllItems();

        for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()) {
            employeeJComboBox.addItem(employee);
        }
    }

    public void popData() {

        DefaultTableModel model = (DefaultTableModel) userJTable.getModel();

        model.setRowCount(0);

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                Object row[] = new Object[2];
                row[0] = ua.getUsername();
                row[1] = organization;
                ((DefaultTableModel) userJTable.getModel()).addRow(row);
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

        jLabel3 = new javax.swing.JLabel();
        employeeJComboBox = new javax.swing.JComboBox();
        btnBack = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        createUserJButton = new javax.swing.JButton();
        organizationJComboBox = new javax.swing.JComboBox();
        txtName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userJTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(192, 159, 128));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(118, 50, 63));
        jLabel3.setText("Employee");

        employeeJComboBox.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        employeeJComboBox.setForeground(new java.awt.Color(118, 50, 63));
        employeeJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(118, 50, 63));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/CenterHead/icons8_Back_To_32px_1.png"))); // NOI18N
        btnBack.setText(" Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(118, 50, 63));
        jLabel5.setText("Organization");

        createUserJButton.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        createUserJButton.setForeground(new java.awt.Color(118, 50, 63));
        createUserJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/CenterHead/icons8_Management_32px.png"))); // NOI18N
        createUserJButton.setText("Create User Account");
        createUserJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserJButtonActionPerformed(evt);
            }
        });

        organizationJComboBox.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        organizationJComboBox.setForeground(new java.awt.Color(118, 50, 63));
        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });

        txtName.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtName.setForeground(new java.awt.Color(118, 50, 63));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(118, 50, 63));
        jLabel1.setText("User Name");

        userJTable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        userJTable.setForeground(new java.awt.Color(118, 50, 63));
        userJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "Organization"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(userJTable);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(118, 50, 63));
        jLabel2.setText("Password");

        txtPassword.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(118, 50, 63));

        jLabel6.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(118, 50, 63));
        jLabel6.setText("Manage user account");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                    .addComponent(txtPassword)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(36, 36, 36)
                                    .addComponent(employeeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(createUserJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(43, 43, 43)
                .addComponent(createUserJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(78, 78, 78))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void createUserJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserJButtonActionPerformed
        String userName = txtName.getText();
        String password = String.valueOf(txtPassword.getPassword());
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        Employee employee = (Employee) employeeJComboBox.getSelectedItem();
        
        if(employee == null){
            JOptionPane.showMessageDialog(null, "Please create an employee first!");
            java.util.logging.Logger.getLogger(ManageUserAccountJPanel.class.getName()).log(java.util.logging.Level.INFO, "Please create an employee first!");
            return;
        }
        
        //check if UserAccount is already created for this employee
        boolean userAccountExistsForEmployee = false;
        for(UserAccount u : organization.getUserAccountDirectory().getUserAccountList()){
            if(u.getEmployee().equals(employee)){
                userAccountExistsForEmployee = true;
            }
        }
        if(userAccountExistsForEmployee){
            JOptionPane.showMessageDialog(null, "User Account already created for this employee!");
            java.util.logging.Logger.getLogger(ManageUserAccountJPanel.class.getName()).log(java.util.logging.Level.INFO, "User account already created for this employee!");
            return;
        }
        
        if (txtName.getText().length() < 5 || txtPassword.getText().length() < 5) {
            java.util.logging.Logger.getLogger(ManageUserAccountJPanel.class.getName()).log(java.util.logging.Level.INFO, "Please enter username and password with length more than 5 characters");
            JOptionPane.showMessageDialog(null, "Please enter username and password with length more than 5 characters");
            return;
        }
        if (!organization.getUserAccountDirectory().checkIfUsernameIsUnique(userName)) {
            JOptionPane.showMessageDialog(null, "User Name already exists.Please create user with different name");
            java.util.logging.Logger.getLogger(ManageUserAccountJPanel.class.getName()).log(java.util.logging.Level.INFO, "Username "+userName+" already exists.Please create user with different name");
            txtName.setText("");
            txtPassword.setText("");
            return;
        }

        UserAccount userAccount = null;

        if (organization instanceof Doctor) {
            userAccount = organization.getUserAccountDirectory().createUserAccount(userName, password, employee, new DoctorRole());
        }
        if (organization instanceof Nurse) {
            userAccount = organization.getUserAccountDirectory().createUserAccount(userName, password, employee, new NurseRole());
        }
        if (organization instanceof Receptionist) {
            userAccount = organization.getUserAccountDirectory().createUserAccount(userName, password, employee, new ReceptionistRole());
        }
        if (organization instanceof InventoryManager) {
            userAccount = organization.getUserAccountDirectory().createUserAccount(userName, password, employee, new InventoryManagerRole());
        }
        if (organization instanceof Supplier) {
            userAccount = organization.getUserAccountDirectory().createUserAccount(userName, password, employee, new SupplierRole());
        }
        
        if(userAccount == null){
            //error occured when creating user account
            return;
        }
        
        popData();
        JOptionPane.showMessageDialog(this, "User Account has been created.");
        java.util.logging.Logger.getLogger(ManageUserAccountJPanel.class.getName()).log(java.util.logging.Level.INFO, "Username "+userName+" created successfully!");
        employeeJComboBox.removeItem(employee.getName());
        txtName.setText("");
        txtPassword.setText("");
    }//GEN-LAST:event_createUserJButtonActionPerformed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        if (organization != null) {
            populateEmployeeComboBox(organization);
        }
    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        bottomPanel.remove(this);
        CardLayout layout = (CardLayout) bottomPanel.getLayout();
        layout.previous(bottomPanel);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton createUserJButton;
    private javax.swing.JComboBox employeeJComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTable userJTable;
    // End of variables declaration//GEN-END:variables
}
