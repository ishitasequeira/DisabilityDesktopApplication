/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;


import Business.Enterprise.PatientEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.Patient;
import Business.Role.CenterHeadRole;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.UserAccount.UserAccountManager;
import java.util.ArrayList;

/**
 *
 * @author cardinal
 */
public class DisabilityCenter extends Organization{
    private static DisabilityCenter disabilityCenter;
    private ArrayList<Network> networkList;
    
    public static DisabilityCenter getInstance(){
        if(disabilityCenter == null){
            disabilityCenter = new DisabilityCenter();
        }
        return disabilityCenter;
    }
    private DisabilityCenter(){
        super(null);
        networkList = new ArrayList<>();
    }
    
    public Network createAndAddNetwork(){
        Network network=new Network();
        networkList.add(network);
        return network;
    }
    
    public void removeNetwork(Network n){
        networkList.remove(n);
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
     ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new CenterHeadRole());
        return roleList;   
    }

    @Override
    public String toString() {
        return "DisabilityCenter";
    }
    
    
}
