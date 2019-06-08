/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.InventoryItem.InventoryList;
import Business.Organization.SupplierProduct.Order;
import Business.Organization.SupplierProduct.Product;
import Business.Role.InventoryManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author cardinal
 */
public class InventoryManager extends Organization{
     private ArrayList<Order> orderCatalog;
     private InventoryList inventoryList;

    public ArrayList<Order> getOrderCatalog() {
        return orderCatalog;
    }

    public InventoryList getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(InventoryList inventoryList) {
        this.inventoryList = inventoryList;
    }

    public void setOrderCatalog(ArrayList<Order> OrderCatalog) {
        this.orderCatalog = OrderCatalog;
    }
    
    public InventoryManager() {
        super(Organization.Type.InventoryManager.getValue());
        this.orderCatalog = new ArrayList<>();
        this.inventoryList = new InventoryList();
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new InventoryManagerRole());
        return roles;
    }
    
    public Order addOrder(Order o){
        this.orderCatalog.add(o);
        return o;
    }
    
    public Order removeOrder(Order o){
        this.orderCatalog.add(o);
        return o;
    }
}
