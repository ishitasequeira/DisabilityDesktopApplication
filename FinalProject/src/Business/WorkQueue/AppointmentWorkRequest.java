/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author cardinal
 */
public class AppointmentWorkRequest extends WorkRequest{
    
    public String log(){
        return "Work Request:"+this.getRequestDate()+" "+this.getSender()+" "+this.getReceiver()+" "+this.getMessage()+" "+this.getStatus();
    }
}
