/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.OrganizationDirectory;
import java.util.ArrayList;

/**
 *
 * @author cardinal
 */
public class EnterpriseDirectory {

    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList();

        //Create 1 enterprise for Patient
        enterpriseList.add(new PatientEnterprise("Patient Enterprise"));

        //Create 1 enterprise for Supplier
        enterpriseList.add(new SupplierEnterprise("Supplier Enterprise"));
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }

    //Create Center Enterprise
    public Enterprise createCenter(String name) {
        Enterprise enterprise = new CenterEnterprise(name);
        enterpriseList.add(enterprise);
        return enterprise;
    }
    
    public void removeCenter(CenterEnterprise center){
        enterpriseList.remove(center);
    }
    
    
}
