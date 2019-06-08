/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.ReceptionistRole;
import Business.Role.Role;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author cardinal
 */
public class Receptionist extends Organization{

   HashMap<Integer, Patient> patientsCheckedin;
        
   public Receptionist() {
        super(Organization.Type.Receptionist.getValue());
        patientsCheckedin = new HashMap<Integer, Patient>();
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new ReceptionistRole());
        return roles;
    }

    public HashMap<Integer, Patient> getPatientsCheckedin() {
        return patientsCheckedin;
    }

    public void setPatientsCheckedin(HashMap<Integer, Patient> patientsCheckedin) {
        this.patientsCheckedin = patientsCheckedin;
    }
    
    
    
}
