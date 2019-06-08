/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Supplier;

import Business.DisabilityCenter;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Supplier;
import Business.Organization.SupplierProduct.Product;
import Business.Organization.SupplierProduct.ProductCatalog;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cardinal
 */
public class ManageProductCatalogJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageProductCatalogJPanel
     */
    private JPanel bottomPanel;
    private ProductCatalog productCatalog;
    private Enterprise enterprise;
    private DisabilityCenter business;
    private UserAccount userAccount;
    private Supplier supplier;

    public ManageProductCatalogJPanel(JPanel bottomJPanel, Enterprise enterprise, DisabilityCenter business, UserAccount userAccount, Supplier supplier) {
        this.bottomPanel = bottomJPanel;
        this.enterprise = enterprise;
        this.business = business;
        this.userAccount = userAccount;
        this.supplier = supplier;
        this.productCatalog = this.supplier.getProductCatalog();

        initComponents();
        txtSupplierName.setText(this.supplier.getSupplierName());
        txtSearchProduct.setForeground(Color.GRAY);
        refreshTable();
    }
    /*
     public void prodDir(){
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
     }
     */

    public void refreshTable() {

        DefaultTableModel model = (DefaultTableModel) productCatalogJTable.getModel();

        model.setRowCount(0);
        for (Product o : this.productCatalog.getProductList()) {
            Object row[] = new Object[5];
            row[0] = o.getProductID();
            row[1] = o;
            row[2] = o.getPrice();
            row[3] = o.getQuantity();
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

        txtSupplierName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        productCatalogJTable = new javax.swing.JTable();
        btnCreateProduct = new javax.swing.JButton();
        btnViewProduct = new javax.swing.JButton();
        btnDeleteProduct = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        txtSearchProduct = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(192, 159, 128));

        txtSupplierName.setEditable(false);
        txtSupplierName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtSupplierName.setForeground(new java.awt.Color(118, 50, 63));

        productCatalogJTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        productCatalogJTable.setForeground(new java.awt.Color(118, 50, 63));
        productCatalogJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Product Price", "Product Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(productCatalogJTable);

        btnCreateProduct.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCreateProduct.setForeground(new java.awt.Color(118, 50, 63));
        btnCreateProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Supplier/icons8_Save_as_32px_1.png"))); // NOI18N
        btnCreateProduct.setText("Create Product");
        btnCreateProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateProductActionPerformed(evt);
            }
        });

        btnViewProduct.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnViewProduct.setForeground(new java.awt.Color(118, 50, 63));
        btnViewProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Supplier/icons8_Product_32px.png"))); // NOI18N
        btnViewProduct.setText("View Product");
        btnViewProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewProductActionPerformed(evt);
            }
        });

        btnDeleteProduct.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDeleteProduct.setForeground(new java.awt.Color(118, 50, 63));
        btnDeleteProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Supplier/icons8_Delete_32px_1.png"))); // NOI18N
        btnDeleteProduct.setText("Delete Product");
        btnDeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProductActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(118, 50, 63));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Supplier/icons8_Back_To_32px_1.png"))); // NOI18N
        btnBack.setText(" Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        txtSearchProduct.setForeground(new java.awt.Color(118, 50, 63));
        txtSearchProduct.setText("Enter Product Name");
        txtSearchProduct.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchProductFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchProductFocusLost(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(118, 50, 63));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Supplier/icons8_Search_32px.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(118, 50, 63));
        jLabel7.setText("Manage Product catalog");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btnDeleteProduct)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnViewProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnCreateProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(txtSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(239, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDeleteProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnViewProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCreateProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(136, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateProductActionPerformed
        CreateProductJPanel createProductJPanel = new CreateProductJPanel(bottomPanel, supplier);
        bottomPanel.add("CreateProductJPanel", createProductJPanel);
        CardLayout layout = (CardLayout) bottomPanel.getLayout();
        layout.next(bottomPanel);

    }//GEN-LAST:event_btnCreateProductActionPerformed

    private void btnViewProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewProductActionPerformed
        int row = productCatalogJTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Please make a selection!!");
            return;
        }
        Product product = (Product) productCatalogJTable.getValueAt(row, 1);
        ViewProductJPanel viewProductJPanel = new ViewProductJPanel(bottomPanel, supplier, product);
        CardLayout cardLayout = (CardLayout) bottomPanel.getLayout();
        bottomPanel.add(viewProductJPanel);
        cardLayout.next(bottomPanel);
    }//GEN-LAST:event_btnViewProductActionPerformed

    private void btnDeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProductActionPerformed
        int selectedRow = productCatalogJTable.getSelectedRow();
        if (selectedRow >= 0) {
            int selectionButton = JOptionPane.YES_NO_OPTION;
            int selectionResult = JOptionPane.showConfirmDialog(null, "Are you sure to delete??", "Warning", selectionButton);
            if (selectionResult == JOptionPane.YES_OPTION) {
                Product product = (Product) productCatalogJTable.getValueAt(selectedRow, 1);
                productCatalog.getProductList().remove(product);
                refreshTable();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a Row!!");
        }
    }//GEN-LAST:event_btnDeleteProductActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        bottomPanel.remove(this);
        CardLayout cardLayout = (CardLayout) bottomPanel.getLayout();
        cardLayout.previous(bottomPanel);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtSearchProductFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchProductFocusGained
        if (txtSearchProduct.getText().equals("Enter Product Name")) {
            txtSearchProduct.setText("");
        }
        txtSearchProduct.setForeground(Color.GRAY);
    }//GEN-LAST:event_txtSearchProductFocusGained

    private void txtSearchProductFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchProductFocusLost
        if (txtSearchProduct.getText().equals("")) {
            txtSearchProduct.setText("Enter Product Name");
        }
        txtSearchProduct.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtSearchProductFocusLost

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String txtSearch = txtSearchProduct.getText();
        List<Product> search = productCatalog.searchProduct(txtSearch);
        DefaultTableModel dtm = (DefaultTableModel) productCatalogJTable.getModel();
        dtm.setRowCount(0);

        for (Product a : search) {
            Object[] row = new Object[dtm.getColumnCount()];
            row[0] = a.getProductID();
            row[1] = a;
            row[2] = a.getPrice();
            row[3] = a.getQuantity();
            dtm.addRow(row);
        }
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateProduct;
    private javax.swing.JButton btnDeleteProduct;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnViewProduct;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable productCatalogJTable;
    private javax.swing.JTextField txtSearchProduct;
    private javax.swing.JTextField txtSupplierName;
    // End of variables declaration//GEN-END:variables
}
