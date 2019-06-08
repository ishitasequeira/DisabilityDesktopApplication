package Business;

import Business.Employee.Employee;
import Business.Role.CEORole;
//import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author cardinal
 */
public class ConfigureASystem {
    
    public static DisabilityCenter configure(){
        
        DisabilityCenter disabilityCenter = DisabilityCenter.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        
      Employee employee = disabilityCenter.getEmployeeDirectory().createEmployee("CEO");
        
      UserAccount ua = disabilityCenter.getUserAccountDirectory().createUserAccount("CEO", "CEO", employee, new CEORole());
        
        return disabilityCenter;
    }
    
}
