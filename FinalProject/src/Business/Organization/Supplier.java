/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.SupplierProduct.ProductCatalog;
import Business.Role.SupplierRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author cardinal
 */
public class Supplier extends Organization{
    private String supplierName;
    private ProductCatalog productCatalog;
    
    public Supplier() {
        super(Organization.Type.Supplier.getValue());
        productCatalog = new ProductCatalog();
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        
        roles.add(new SupplierRole());
        return roles;
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    public void setProductCatalog(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }

    @Override
    public String toString() {
        return supplierName;
    }
    
    
}
