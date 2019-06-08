/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Enterprise.Patient;

import Business.Employee.Employee;
import Business.Organization.SupplierProduct.Product;
import java.util.ArrayList;

/**
 *
 * @author cardinalprivate 
 */
public class PatientHistory {

    private String dateTime;
    private String diagnosis;
    private ArrayList<Product> prescription;
    private ArrayList<Product> equipment;
    private Employee doctor;
    private Employee nurse;
    private int patientHistoryId;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public ArrayList<Product> getPrescription() {
        return prescription;
    }

    public void setPrescription(ArrayList<Product> prescription) {
        this.prescription = prescription;
    }

    public ArrayList<Product> getEquipment() {
        return equipment;
    }

    public void setEquipment(ArrayList<Product> equipment) {
        this.equipment = equipment;
    }

    public Employee getDoctor() {
        return doctor;
    }

    public void setDoctor(Employee doctor) {
        this.doctor = doctor;
    }

    public Employee getNurse() {
        return nurse;
    }

    public void setNurse(Employee nurse) {
        this.nurse = nurse;
    }

    public int getPatientHistoryId() {
        return patientHistoryId;
    }

    public void setPatientHistoryId(int patientId) {
        this.patientHistoryId = patientId;
    }
    
    
}
