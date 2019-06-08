/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.SupplierProduct;

/**
 *
 * @author cardinal
 */
public class Product {
    private String name;
    private double price;
    private String description;
    private int quantity;
    private int originalQuantity;
    private int productID;
    private boolean isPhysical;

    public Product(String name, double price, String description, int quantity, boolean isPhysical,int originalQuantity) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.isPhysical = isPhysical;
        this.originalQuantity = originalQuantity;
    }

    public int getOriginalQuantity() {
        return originalQuantity;
    }

    public void setOriginalQuantity(int originalQuantity) {
        this.originalQuantity = originalQuantity;
    }

    public boolean isIsPhysical() {
        return isPhysical;
    }

    public void setIsPhysical(boolean isPhysical) {
        this.isPhysical = isPhysical;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
     @Override
    public String toString() {
        return getName(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
