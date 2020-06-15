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
public class OrderDTO {
    private String ID;
    private String CustomerID;
    private String OrderDate;
    private int Status;
    private String Note;
    private String CustomerName;
    private String CustomerPhone;
    private String CustomerEmail;
    private String CustomerAddress;
    private boolean isDeleted;
    private double Total;
    
    public OrderDTO() {
        this("","","",0,"","","","","",0,false);
    }
    
    public OrderDTO(String ID, String CustomerID, String OrderDate, int Status, String Note, String CustomerName, String CustomerPhone, String CustomerEmail, String CustomerAddress, double Total, boolean isDeleted) {
        this.ID = ID;
        this.OrderDate = OrderDate;
        this.Status = Status;
        this.Note = Note;
        this.CustomerID = CustomerID;
        this.CustomerName = CustomerName;
        this.CustomerPhone = CustomerPhone;
        this.CustomerEmail = CustomerEmail;
        this.CustomerAddress = CustomerAddress;
        this.isDeleted = isDeleted;
        this.Total = Total;
    }
    
    public String getID() {
        return this.ID;
    }
    
    public void setID(String ID) {
        this.ID = ID;
    }
    
    public double getTotal() {
        return this.Total;
    }
    
    public void setTotal(double Total) {
        this.Total = Total;
    }
    
    public String getCustomerID() {
        return this.CustomerID;
    }
    
    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }
    public int getStatus() {
        return this.Status;
    }
    
    public void setStatus(int Status) {
        this.Status = Status;
    }
    public String getOrderDate() {
        return this.OrderDate;
    }
    
    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }
    public String getNote() {
        return this.Note;
    }
    
    public void setNote(String Note) {
        this.Note = Note;
    }
    public String getCustomerName() {
        return this.CustomerName;
    }
    
    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }
    public String getCustomerPhone() {
        return this.CustomerPhone;
    }
    
    public void setCustomerPhone(String CustomerPhone) {
        this.CustomerPhone = CustomerPhone;
    }
    public String getCustomerAddress() {
        return this.CustomerAddress;
    }
    
    public void setCustomerAddress(String CustomerAddress) {
        this.CustomerAddress = CustomerAddress;
    }
    public String getCustomerEmail() {
        return this.CustomerEmail;
    }
    
    public void setCustomerEmail(String CustomerEmail) {
        this.CustomerEmail = CustomerEmail;
    }
    public boolean isDeleted() {
        return this.isDeleted;
    }
    
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
