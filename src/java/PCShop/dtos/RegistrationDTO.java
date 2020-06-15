/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PCShop.dtos;

import java.io.Serializable;

/**
 *
 * @author Hui
 */
public class RegistrationDTO implements Serializable{
    private String username;
    private String password;
    private String lastname;
    private String firstname;
    private String phone;
    private String address;
    private String mail;
    private boolean isAdmin;
    
   public RegistrationDTO() {
       username = password = lastname = firstname = phone = address = mail = "";
       isAdmin = false;
   }
   
   public RegistrationDTO(String username, String password, String lastname, String firstname, String phone, String address, String mail, boolean isAdmin) {
       this.username = username;
       this.password = password;
       this.lastname = lastname;
       this.firstname = firstname;
       this.phone = phone;
       this.address = address;
       this.isAdmin = isAdmin;
       this.mail = mail;
   }
   public String getMail() {
       return this.mail;
   }
   
   public void setMail(String mail) {
       this.mail = mail;
   }
   
   public String getUsername() {
       return this.username;
   }
   
   public void setUsername(String username) {
       this.username = username;
   }
   
   public String getPassword() {
       return this.password;
   }
   
   public void setPassword(String password) {
       this.password = password;
   }
  
   public String getLastname() {
       return this.lastname;
   }
   
   public void setLastname(String lastname) {
       this.lastname = lastname;
   }
  
   public String getFirstname() {
       return this.firstname;
   }
   
   public void setFirstname(String firstname) {
       this.firstname = firstname;
   }
   
   public String getPhone() {
       return this.phone;
   }
   
   public void setPhone(String phone) {
       this.phone = phone;
   }
   
   public String getAddress() {
       return this.address;
   }
   
   public void setAddress(String address) {
       this.address = address;
   }
   
   public boolean isAdmin() {
       return this.isAdmin;
   }
   
   public void setAdmin(boolean admin) {
       this.isAdmin = admin;
   }
}
