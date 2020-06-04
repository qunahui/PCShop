/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PCShop.dtos;
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hui
 */
public class RegistrationInsertErr implements Serializable {
   private String usernameLengthErr;
   private String passwordLengthErr;
   private String confirmNotMatch;
   private String lastnameLengthErr;
   private String firstnameLengthErr;
   private String phoneLengthErr;
   private String addressLengthErr;
   private String usernameIsExist;
   public RegistrationInsertErr() {
    usernameLengthErr = passwordLengthErr = confirmNotMatch = lastnameLengthErr = firstnameLengthErr = phoneLengthErr = addressLengthErr = usernameIsExist =  " ";
   }
   
    public String getUsernameLengthErr () {
        return this.usernameLengthErr;
    }
    
    public void setUsernameLengthErr(String usernameLengthErr) {
        this.usernameLengthErr = usernameLengthErr;
    }
    
    public String getPasswordLengthErr () {
        return this.passwordLengthErr;
    }
    
    public void setPasswordLengthErr(String passwordLengthErr) {
        this.passwordLengthErr = passwordLengthErr;
    }
    
    public String getConfirmNotMatch () {
        return this.confirmNotMatch;
    }
    
    public void setConfirmNotMatch(String confirmNotMatch) {
        this.confirmNotMatch = confirmNotMatch;
    }
    
    public String getLastnameLengthErr () {
        return this.lastnameLengthErr;
    }
    
    public void setLastnameLengthErr(String lastnameLengthErr) {
        this.lastnameLengthErr = lastnameLengthErr;
    }
    
    public String getfirstnameLengthErr () {
        return this.firstnameLengthErr;
    }
    
    public void setFirstnameLengthErr(String firstnameLengthErr) {
        this.firstnameLengthErr = firstnameLengthErr;
    }
    
    public String getPhoneLengthErr () {
        return this.phoneLengthErr;
    }
    
    public void setPhoneLengthErr(String phoneLengthErr) {
        this.phoneLengthErr = phoneLengthErr;
    }
    
    public String getAddressLengthErr () {
        return this.addressLengthErr;
    }
    
    public void setAddressLengthErr(String addressLengthErr) {
        this.addressLengthErr = addressLengthErr;
    }
    
    public String getUsernameIsExist () {
        return this.usernameIsExist;
    }
    
    public void setUsernameIsExist(String usernameIsExist) {
        this.usernameIsExist = usernameIsExist;
    }
}  
