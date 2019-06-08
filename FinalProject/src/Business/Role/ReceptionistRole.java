/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.DisabilityCenter;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.Receptionist;
import Business.UserAccount.UserAccount;
import UserInterface.Receptionist.ReceptionistWorkAreaJPanel;
import javax.swing.JPanel;



/**
 *
 * @author cardinal
 */
public class ReceptionistRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, DisabilityCenter business) {
        return new ReceptionistWorkAreaJPanel(userProcessContainer, account, (Receptionist)organization, enterprise,business);
    }
    

    
}
