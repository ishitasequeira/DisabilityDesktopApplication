/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.DisabilityCenter;
import Business.Enterprise.Enterprise;
import Business.Organization.CenterHead;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.CenterHead.CenterHeadWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author cardinal
 */
public class CenterHeadRole extends Role{
    
    @Override
    public JPanel createWorkArea(JPanel bottomPanel, UserAccount account, Organization organization, Enterprise enterprise, DisabilityCenter business) {
        return new CenterHeadWorkAreaJPanel(bottomPanel, account, (CenterHead)organization, enterprise);
    }
}
