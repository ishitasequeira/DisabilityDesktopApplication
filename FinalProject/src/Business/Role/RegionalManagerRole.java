/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.DisabilityCenter;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.RegionalManager.RegionalManagerWorkAreaJPanel;

import javax.swing.JPanel;

/**
 *
 * @author cardinal
 */
public class RegionalManagerRole extends Role {

  

    @Override
    public JPanel createWorkArea(JPanel bottomPanel, UserAccount account, Organization organization, Enterprise enterprise, DisabilityCenter business) {
        return new RegionalManagerWorkAreaJPanel(bottomPanel, (Network)organization, account,business);
    }

}

