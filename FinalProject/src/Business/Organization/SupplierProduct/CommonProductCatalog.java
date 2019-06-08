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
 * @author cardinal
 */
public class CommonProductCatalog {
   private List<Product> commonProductList;

    public CommonProductCatalog() {
        this.commonProductList = new ArrayList<>(); ;
    }

    public List<Product> getCommonProductList() {
        return commonProductList;
    }

    public void setCommonProductList(List<Product> commonProductList) {
        this.commonProductList = commonProductList;
    }
   
   
}
