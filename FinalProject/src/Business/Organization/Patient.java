/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Enterprise.Patient.PatientHistory;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author cardinal
 */
public class Patient extends Organization{
    
    private String patientName;
    private String patientEmail;
    private String patientNumber;
    private String patientAddress;
    private ArrayList<PatientHistory> patientHistory;
    private int patientID;
    
    
    public Patient() {
        super(Organization.Type.Patient.getValue());
        patientHistory = new ArrayList<>();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }
    
    public void addPatientHistory(PatientHistory ph){
        this.patientHistory.add(ph);
    }

    public ArrayList<PatientHistory> getPatientHistory() {
        return patientHistory;
    }

    public void setPatientHistory(ArrayList<PatientHistory> patientHistory) {
        this.patientHistory = patientHistory;
    }
    
    public void createPatientHistory(PatientHistory ph){
        //set patientHistoryId to size + 1
        ph.setPatientHistoryId(this.patientHistory.size() + 1);
        this.patientHistory.add(ph);
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    @Override
    public String toString() {
        return patientName;
    }
    
    
    
}