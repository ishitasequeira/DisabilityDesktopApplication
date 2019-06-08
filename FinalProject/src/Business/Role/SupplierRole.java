/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.DisabilityCenter;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.Supplier;
import Business.UserAccount.UserAccount;
import UserInterface.Supplier.SupplierWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author sharv
 */
public class SupplierRole extends Role{
     @Override
    public JPanel createWorkArea(JPanel bottomPanel, UserAccount account, Organization organization, Enterprise enterprise, DisabilityCenter business) {
       return new SupplierWorkAreaJPanel(bottomPanel, account, (Supplier)organization, enterprise,business);
    }
}
