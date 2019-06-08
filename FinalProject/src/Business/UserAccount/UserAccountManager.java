/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.UserAccount;

import Business.DisabilityCenter;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import java.util.ArrayList;

/**
 *
 * @author tejas
 */
public class UserAccountManager {

    private static ArrayList<UserAccount> allUsers = new ArrayList<>();

    public static ArrayList<UserAccount> getAllUsers() {
        return allUsers;
    }

    public static void setAllUsers(ArrayList<UserAccount> allUsers) {
        UserAccountManager.allUsers = allUsers;
    }
    
    public static boolean isUserNameUnique(String userName){
        for(UserAccount ua : allUsers){
            if(ua.getUsername().equals(userName)){
                return false;
            }
        }
        return true;
    }
    
    public static void initializeAllUsers(DisabilityCenter business){
        
        //Step 1 : Get all user accounts at business level
        for(UserAccount u : business.getUserAccountDirectory().getUserAccountList()){
            allUsers.add(u);
        }
        //Step 2 : Get all user accounts at network level
        for(Network n : business.getNetworkList()){
            for(UserAccount u : n.getUserAccountDirectory().getUserAccountList()){
                allUsers.add(u);
            }
            //Step 3 : Get all user accounts at organisation level
            for(Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()){
                for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
                    for(UserAccount u : o.getUserAccountDirectory().getUserAccountList()){
                        allUsers.add(u);
                    }
                }
            }
        }
    }
    
    public static void addUserAccount(UserAccount ua){
        allUsers.add(ua);
    }
}
