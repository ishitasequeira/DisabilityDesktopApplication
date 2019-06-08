/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Supplier;

import Business.DisabilityCenter;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.Organization.SupplierProduct.ProductCatalog;
import Business.Organization.Supplier;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author cardinal
 */
public class SupplierWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SupplierWorkAreaJPanel
     */
    private JPanel bottomPanel;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private Supplier supplier;
    private ProductCatalog productCatalog;
    private DisabilityCenter business;
    
    public SupplierWorkAreaJPanel(JPanel bottomPanel, UserAccount account, Supplier supplier, Enterprise enterprise, DisabilityCenter business) {
        this.bottomPanel = bottomPanel;
        this.userAccount = account;
        this.supplier = supplier;
        this.enterprise = enterprise;
        this.business = business;
        
        initComponents();
        txtSupplierName.setText(this.supplier.getSupplierName());
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
        txtSupplierName = new javax.swing.JTextField();
        btnManageProductCatalog = new javax.swing.JButton();
        btnViewBestFiveProd = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(192, 159, 128));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(118, 50, 63));
        jLabel2.setText("Supplier:");

        txtSupplierName.setEditable(false);
        txtSupplierName.setForeground(new java.awt.Color(118, 50, 63));

        btnManageProductCatalog.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnManageProductCatalog.setForeground(new java.awt.Color(118, 50, 63));
        btnManageProductCatalog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Supplier/icons8_Product_32px.png"))); // NOI18N
        btnManageProductCatalog.setText("Manage Product Catalog");
        btnManageProductCatalog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageProductCatalogActionPerformed(evt);
            }
        });

        btnViewBestFiveProd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnViewBestFiveProd.setForeground(new java.awt.Color(118, 50, 63));
        btnViewBestFiveProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Supplier/icons8_Bar_Chart_32px_6.png"))); // NOI18N
        btnViewBestFiveProd.setText("View Bargraph of 5 Best Products");
        btnViewBestFiveProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewBestFiveProdActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(118, 50, 63));
        jLabel7.setText("Supplier work area");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(35, 35, 35)
                                .addComponent(txtSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnViewBestFiveProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnManageProductCatalog, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)))
                .addContainerGap(257, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addComponent(btnManageProductCatalog, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnViewBestFiveProd, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageProductCatalogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageProductCatalogActionPerformed
        ManageProductCatalogJPanel manageProductCatalogJPanel  = new ManageProductCatalogJPanel(bottomPanel, enterprise, business, userAccount, supplier);
        bottomPanel.add("ManageProductCatalogJPanel", manageProductCatalogJPanel);
        CardLayout layout = (CardLayout)bottomPanel.getLayout();
        layout.next(bottomPanel);
    }//GEN-LAST:event_btnManageProductCatalogActionPerformed

    private void btnViewBestFiveProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewBestFiveProdActionPerformed
        ViewBestFiveProductsJPanel bestFiveProductsJPanel = new ViewBestFiveProductsJPanel(bottomPanel, supplier);
        bottomPanel.add("ViewBestFiveProductsJPanel",bestFiveProductsJPanel);
        CardLayout layout = (CardLayout)bottomPanel.getLayout();
        layout.next(bottomPanel);
    }//GEN-LAST:event_btnViewBestFiveProdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageProductCatalog;
    private javax.swing.JButton btnViewBestFiveProd;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtSupplierName;
    // End of variables declaration//GEN-END:variables
}