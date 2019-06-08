/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.CenterHeadRole;
import Business.Role.ReceptionistRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author sharv
 */
public class CenterHead extends Organization{
    
    public CenterHead(){
    super(Organization.Type.CenterHead.getValue());
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new CenterHeadRole());
        return roles;
    }
}
