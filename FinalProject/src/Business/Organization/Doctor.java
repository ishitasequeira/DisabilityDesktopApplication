package Business.Organization;

import Business.Role.DoctorRole;
import Business.Role.Role;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author cardinal
 */
public class Doctor extends Organization{
    public Doctor() {
        super(Organization.Type.Doctor.getValue());
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new DoctorRole());
        return roles;
    }
}
