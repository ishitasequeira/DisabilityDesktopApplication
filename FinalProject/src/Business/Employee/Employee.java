/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

/**
 *
 * @author cardinal
 */
public class Employee {
    private String name;
    private int id;
    private boolean isCheckedIn;
    private String checkedInTime;
    private boolean isAvailable;
    private int patientsDiagnosed;
    
     public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getIsCheckedIn() {
        return isCheckedIn;
    }

    public void setIsCheckedIn(boolean isCheckedIn) {
        this.isCheckedIn = isCheckedIn;
        this.patientsDiagnosed = 0;
    }

    public String getCheckedInTime() {
        return checkedInTime;
    }

    public void setCheckedInTime(String checkedInTime) {
        this.checkedInTime = checkedInTime;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public int getPatientsDiagnosed() {
        return patientsDiagnosed;
    }

    public void setPatientsDiagnosed(int patientsDiagnosed) {
        this.patientsDiagnosed = patientsDiagnosed;
    }
    
    public void incrementPatientsDiagnosed(){
        this.patientsDiagnosed++;
    }
    
     @Override
    public String toString() {
        return name;
    }
}
