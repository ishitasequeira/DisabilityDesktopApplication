/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.ArrayList;

/**
 *
 * @author cardinal
 */

public class OrganizationDirectory {
    private ArrayList<Organization> organizationList;
    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public void removeOrganization(Organization o){
        organizationList.remove(o);
    }
    
    public Organization createOrganization(Organization.Type type){
        Organization organization = null;
        if (type.getValue().equals(Organization.Type.Doctor.getValue())){
            organization = new Doctor();
            organization.setOrganizationID(organizationList.size() + 1);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.CenterHead.getValue())){
            organization = new CenterHead();
            organization.setOrganizationID(organizationList.size() + 1);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Receptionist.getValue())){
            organization = new Receptionist();
            organization.setOrganizationID(organizationList.size() + 1);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Nurse.getValue())){
            organization = new Nurse();
            organization.setOrganizationID(organizationList.size() + 1);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.InventoryManager.getValue())){
            organization = new InventoryManager();
            organization.setOrganizationID(organizationList.size() + 1);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Supplier.getValue())){
            organization = new Supplier();
            organization.setOrganizationID(organizationList.size() + 1);
            organizationList.add(organization);
        }
        return organization;
    }
}
