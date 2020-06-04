/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PCShop.product;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Hui
 */
public class ProductObj implements Serializable{
    private String ID;
    private String categoryID;
    private String name;
    private String description;
    private double price;
    private double discount;
    private int quantity;
    private String path;

   public ProductObj(String ID,String categoryID, String description, String name,double price, int quantityProduct, double discount,String path) {
       this.ID = ID;
       this.categoryID = categoryID;
       this.name = name;
       this.price = price;
       this.quantity = quantityProduct;
       this.discount = discount;
       this.path = path;
       this.description = description;
   }
        
   public ProductObj() {
       ID = "";
       categoryID = "";
       name = "";
       path = "";
       price = 0;
       quantity = 0;
       discount = 0;
   }
   
      
   public String getID() {
       return this.ID;
   }
   
   public String getDescription() {
       return this.description;
   }
   
   public String getPath() {
       return this.path;
   }
   
   
   public String getName() {
       return this.name;
   }
   
   public int getQuantity() {
       return this.quantity;
   }
   
   public String getCategoryID() {
       return this.categoryID;
   }
   
   public double getPrice() {
       return this.price;
   }
   
   public double getDiscount() {
       return this.discount;
   }
   
   public double getTotal() {
       return Math.round(this.price*(1-this.discount/100)*this.quantity);
   }
   
   public void setQuantity(int quantity) {
       System.out.println("New: " + quantity);
       this.quantity = quantity;
   }
   
}
