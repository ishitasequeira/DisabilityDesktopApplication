/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.WorkQueue;

import Business.Employee.Employee;

/**
 *
 * @author tejas
 */
public class PatientWaitRequest extends WorkRequest {

    Employee assignedEmployee;
    String disabilityType;

    public Employee getAssignedEmployee() {
        return assignedEmployee;
    }

    public void setAssignedEmployee(Employee assignedEmployee) {
        this.assignedEmployee = assignedEmployee;
    }

    public String getDisabilityType() {
        return disabilityType;
    }

    public void setDisabilityType(String disabilityType) {
        this.disabilityType = disabilityType;
    }
    
    public String log(){
        return "Work Request:"+this.getRequestDate()+" "+this.getSender()+" "+this.getReceiver()+" "+this.getMessage()+" "+this.getStatus()+" "+this.getDisabilityType()+" "+this.getAssignedEmployee();
    }
    
}
