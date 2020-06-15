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
public class CommentDTO {
    private String ID;
    private String customerID;
    private String customerName;
    private String productID;
    private String comment;
    private String addDate;
    private int Rating;
    
    public CommentDTO() {
        ID = customerID = productID = comment = customerName = addDate = "";
        Rating = 0;
    }
    
    public CommentDTO(String ID, String customerID,String customerName, String productID, String comment,int Rating, String addDate) {
        this.ID = ID;
        this.customerID = customerID;
        this.customerName = customerName;
        this.productID = productID;
        this.comment = comment;
        this.addDate = addDate;
        this.Rating = Rating;
    }
    
    public int getRating() {
        return this.Rating;
    }
    
    public void setRating(int Rating) {
        this.Rating = Rating;
    }
    
    public String getID() {
        return this.ID;
    }
    
    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDate() {
        return this.addDate;
    }
    
    public void setDate(String addDate) {
        this.addDate = addDate;
    }
    
    public String getCustomerID() {
        return this.customerID;
    }
        
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
    
    public String getCustomerName() {
        return this.customerName;
    }
        
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public String getProductID() {
        return this.productID;
    }    
    
    public void setProductID(String productID) {
        this.productID = productID;
    }
    
    public String getComment() {
        return this.comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }
    
}
