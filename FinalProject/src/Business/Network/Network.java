/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Employee.Employee;
import Business.Enterprise.EnterpriseDirectory;
import Business.Organization.Organization;
import Business.Role.RegionalManagerRole;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author cardinal
 */
public class Network extends Organization {

    private String name;
    private double budget;
    private EnterpriseDirectory enterpriseDirectory;
    

    public Network() {
        super(Organization.Type.Network.getValue());
        enterpriseDirectory = new EnterpriseDirectory();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public UserAccount addRegionalManager(String username, String password, String name) {

        Employee regionalManager = this.getEmployeeDirectory().createEmployee(name);
        UserAccount userAccount = this.getUserAccountDirectory().createUserAccount(username, password, regionalManager, new RegionalManagerRole());
        return userAccount;

    }
    
    @Override
    public String toString() {
        return name;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new RegionalManagerRole());
        return roles;
    }
    
}
