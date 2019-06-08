/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.SupplierProduct;

import java.util.ArrayList;

/**
 *
 * @author cardinal
 */
public class Order {
    private ArrayList<OrderItem> OrderList;

    public Order(){
        OrderList = new ArrayList<>();
                
    }
    public ArrayList<OrderItem> getOrderList() {
        return OrderList;
    }

    public void setOrderList(ArrayList<OrderItem> OrderList) {
        this.OrderList = OrderList;
    }
    
    public OrderItem addOrderItem(Product product,int quantity){
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setQuantity(quantity);
        this.OrderList.add(orderItem);
        return orderItem;
    }

    public void removeOrderItem(OrderItem orderItem) {
        OrderList.remove(orderItem);
    }
    
    
}
