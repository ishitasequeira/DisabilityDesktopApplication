/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Enterprise.Enterprise.EnterpriseType;
import Business.Organization.CenterHead;
import Business.Organization.SupplierProduct.Order;
import Business.Organization.SupplierProduct.ProductCatalog;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author cardinal
 */
public class CenterEnterprise extends Enterprise {

    private CenterHead centerHead;
    private double centerBudget;
    private ProductCatalog inventoryList;
    private int NumberOfTimesDoctorsNursesWereNotCheckedIn;

    public CenterEnterprise(String name) {
        super(name, EnterpriseType.Center);
        centerHead = new CenterHead();
        NumberOfTimesDoctorsNursesWereNotCheckedIn = 0;
    }

    public ProductCatalog getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(ProductCatalog inventoryList) {
        this.inventoryList = inventoryList;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

    public CenterHead getCenterHead() {
        return centerHead;
    }

    public void setCenterHead(CenterHead centerHead) {
        this.centerHead = centerHead;
    }

    public double getCenterBudget() {
        return centerBudget;
    }

    public void setCenterBudget(double centerBudget) {
        this.centerBudget = centerBudget;
    }

    //to add centerHead
    public CenterHead addCenterHead(String name) {

        CenterHead centerHead = new CenterHead();
        centerHead.setName(name);
        getOrganizationDirectory().getOrganizationList().add(centerHead);
        this.setCenterHead(centerHead);
        return centerHead;

    }

    public int getNumberOfTimesDoctorsNursesWereNotCheckedIn() {
        return NumberOfTimesDoctorsNursesWereNotCheckedIn;
    }

    public void setNumberOfTimesDoctorsNursesWereNotCheckedIn(int NumberOfTimesDoctorsNursesWereNotCheckedIn) {
        this.NumberOfTimesDoctorsNursesWereNotCheckedIn = NumberOfTimesDoctorsNursesWereNotCheckedIn;
    }
    
    public void incrementNumberOfTimesDoctorsNursesWereNotCheckedIn(){
        NumberOfTimesDoctorsNursesWereNotCheckedIn++;
    }
}
