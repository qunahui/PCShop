/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PCShop.cart;

import PCShop.product.ProductObj;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Hui
 */
public class CartObj implements Serializable{
    private String customerID; 
    private Map<String,ProductObj> products;
    
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
    
    public String getCustomerID() {
        return this.customerID;
    }
    
    public Map<String,ProductObj> getProducts() { 
        return this.products;
    }
    
    public void addProductToCart(ProductObj pro) {
        if(products == null) {
            products = new HashMap<String,ProductObj>();
        }
        String id = pro.getID();
        if(products.containsKey(id)) {
           int newQuantity = products.get(id).getQuantity() + pro.getQuantity();
           System.out.println(newQuantity);
           products.get(id).setQuantity(newQuantity);
        } else {
            products.put(pro.getID(), pro);
        } 
    }
    public void removeProductFromCart(String ID) {
        if(products == null) {
            return;
        }
        if(products.containsKey(ID)) {
            products.remove(ID);
        }
        
        if(products.isEmpty()) {
            products = null;
        }
    }
    public void updateQuantity(String ID,int qty) {
        products.get(ID).setQuantity(qty);
    }
    
    public boolean isEmpty(){
        return products == null || products.isEmpty();
    }
    
    public int getLength() {
        return products.size();
    }
    
    public double getTotal() {
        double total = 0;
        for (Map.Entry<String,ProductObj> entry : this.products.entrySet()) {
            total += entry.getValue().getTotal();
        }
        return total;
    }
}
