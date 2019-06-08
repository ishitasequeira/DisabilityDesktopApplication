/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.SupplierProduct;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sharv
 */
public class ProductCatalog {
     private List<Product> productList;
     private List<Product> searchList;
     
     public ProductCatalog(){
        productList = new ArrayList<>();
        searchList = new ArrayList<>();
     }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    
    public void addProduct(Product product) {
        product.setProductID(productList.size() + 1);
        productList.add(product);
    }
    public void deleteProduct(Product product){
        productList.remove(product);
    }
    public List<Product> searchProduct(String name){
        if(name.equals("Enter Product Name"))
            return this.productList;
        searchList.removeAll(searchList);
        for(Product product : this.productList){
            if(product.getName().contains(name)){
                searchList.add(product);
            }
        }
        return searchList;
    }
     
}
