/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.DisabilityCenter;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author cardinal
 */
public abstract class Role {

    public enum RoleType {

        CEO("CEO"),
        Doctor("Doctor"),
        Receptionist("Receptionist"),
        CenterHead("CenterHead"),
        Nurse("Nurse"),
        Supplier("Supplier"),
        RegionalManager("Regional Manager"),
        InventoryManager("Inventory Manager");
        

        private String value;

        private RoleType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public abstract JPanel createWorkArea(JPanel userProcessContainer,
            UserAccount account,
            Organization organization,
            Enterprise enterprise,
            DisabilityCenter business);

    @Override
    public String toString() {
        return this.getClass().getTypeName();
    }
}
