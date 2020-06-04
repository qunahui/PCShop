/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PCShop.dtos;

/**
 *
 * @author Hui
 */
public class ProductDTO {
    private String ID;
    private String categoryID;
    private String description;
    private String name;
    private long quantityProduct;
    private long price;
    private long discount;
    private String path;
    private String details;
    
   public ProductDTO() {
       ID = categoryID = description = name = path = details = "";
       quantityProduct = price = discount;
   }
   
   public ProductDTO(String ID,String categoryID, String description, String name, String details, long quantityProduct, long price,long discount, String path) {
       this.ID = ID;
       this.categoryID = categoryID;
       this.description = description;
       this.name = name;
       this.details = details;
       this.quantityProduct = quantityProduct;
       this.price = price;
       this.discount = discount;
       this.path = path;
   }
   public String getPath() {
       return this.path;
   }
   
   public void setPath(String path) {
       this.path = path;
   }
   
   public String getDetails() {
       return this.details;
   }
   
   public void setDetails(String details) {
       this.details = details;
   }
   
   public String getID() {
       return this.ID;
   }
   
   public void setID(String ID) {
       this.ID = ID;
   }
   
   public String getName() {
       return this.name;
   }
   
   public void setNname(String name) {
       this.name = name;
   }
   
   public String getCategoryID() {
       return this.categoryID;
   }
   
   public void setCategoryID(String categoryID) {
       this.categoryID = categoryID;
   }
  
   public String getDescription() {
       return this.description;
   }
   
   public void setDescription(String description) {
       this.description = description;
   }
  
   public long getQuantityProduct() {
       return this.quantityProduct;
   }
   
   public void setQuantityProduct(long quantityProduct) {
       this.quantityProduct = quantityProduct;
   }
   
   public long getPrice() {
       return this.price;
   }
   
   public void setPrice(long price) {
       this.price = price;
   }

   public long getDiscount() {
       return this.discount;
   }
   
   public void setDiscount(long discount) {
       this.discount = discount;
   }
  
} 
