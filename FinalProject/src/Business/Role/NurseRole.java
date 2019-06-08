/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.DisabilityCenter;
import Business.Enterprise.Enterprise;
import Business.Organization.Nurse;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.Nurse.NurseWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author sharv
 */
public class NurseRole extends Role{
    @Override
    public JPanel createWorkArea(JPanel bottomPanel, UserAccount account, Organization organization, Enterprise enterprise, DisabilityCenter business) {
        return new NurseWorkAreaJPanel(bottomPanel, account, (Nurse)organization, enterprise, business);
    }
}
