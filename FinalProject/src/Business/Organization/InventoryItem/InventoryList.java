/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.InventoryItem;

import java.util.ArrayList;

/**
 *
 * @author cardinal
 */
public class InventoryList {
  private ArrayList<InventoryItem> inventoryList;

    public InventoryList() {
       inventoryList = new ArrayList<>();
    }

    public ArrayList<InventoryItem> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(ArrayList<InventoryItem> inventoryList) {
        this.inventoryList = inventoryList;
    }
  


}
