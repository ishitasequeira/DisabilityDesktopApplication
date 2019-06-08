/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.WorkQueue;

import Business.Enterprise.Patient.PatientHistory;
import Business.Organization.Patient;
import Business.UserAccount.UserAccount;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author cardinal
 */
public class OrderWorkRequest extends WorkRequest{
    
    Patient patient;
    PatientHistory patientHistory;
    public OrderWorkRequest(UserAccount sender, UserAccount receiver, String message, Patient patient, PatientHistory patientHistory){
        setMessage(message);
        setSender(sender);
        setReceiver(receiver);
        setStatus("New Order");
        this.patient = patient;
        this.patientHistory = patientHistory;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public PatientHistory getPatientHistory() {
        return patientHistory;
    }

    public void setPatientHistory(PatientHistory patientHistory) {
        this.patientHistory = patientHistory;
    }

    @Override
    public String toString(){
        return String.valueOf(this.getPatient().getPatientID());
    }
    
    public String log(){
        return "Work Request:"+this.getRequestDate()+" "+this.getSender()+" "+this.getReceiver()+" "+this.getMessage()+" "+this.getStatus()+" "+this.getPatient();
    }
}
