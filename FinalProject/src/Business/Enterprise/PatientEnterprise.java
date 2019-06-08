/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.Patient;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author cardinal
 */
public class PatientEnterprise extends Enterprise {

    public PatientEnterprise(String name) {
        super(name, Enterprise.EnterpriseType.Center);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;

    }
    
    public void addPatient(Patient p){
        p.setPatientID(getOrganizationDirectory().getOrganizationList().size() + 1);
        getOrganizationDirectory().getOrganizationList().add(p);
    }
    
    public Patient addPatient(){
        Patient p = new Patient();
        p.setPatientID(getOrganizationDirectory().getOrganizationList().size() + 1);
        getOrganizationDirectory().getOrganizationList().add(p);
        return p;
    }

}
