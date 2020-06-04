/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PCShop.daos;

import PCShop.dtos.RegistrationDTO;
import PCShop.utils.DBUtils;
import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author Hui
 */
public class RegistrationDAO implements Serializable{

    public String[] checkLogin(String username, String password)
               throws SQLException, ClassNotFoundException, NamingException  {
        String[] user = new String[2];
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "SELECT isAdmin, ID FROM Customer Where username = ? And password = ? And isDeleted = 0";
                
                stm = con.prepareStatement(sql);
                stm.setString(1,username);
                stm.setString(2,password);
                rs = stm.executeQuery();
                if(rs.next()) {
                    if(rs.getBoolean("isAdmin") == true) {
                        user[0] = "admin";
                    } else {
                        user[0] = "user";
                    }
                    user[1] = rs.getString("ID");
                } else {
                    user[0] = "failed";
                    user[1] = "failed";
                }
            }
        } finally { 
            if(rs != null) {
                rs.close();
            } 
            if(stm != null) {
                stm.close();
            }
            if(con != null) {
                con.close();
            }
        }
        return user;
    }
    
    private List<RegistrationDTO> listAccounts;
    
    public List<RegistrationDTO> getListAccounts() {
        return listAccounts;
    };
    
    public void searchLastname (String searchValue) 
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try { 
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "SELECT * FROM Customer Where lastname Like ? AND isDeleted = 0";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                
                rs = stm.executeQuery();
                
                while(rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String lastname = rs.getString("lastname");
                    String firstname = rs.getString("firstname");
                    boolean isAdmin = rs.getBoolean("isAdmin");
                    RegistrationDTO dto = new RegistrationDTO(username,password,lastname,firstname,null,null,isAdmin);
                    if(listAccounts == null) {
                        listAccounts = new ArrayList<RegistrationDTO>();
                    }
                    listAccounts.add(dto);
                }
            }
        } finally { 
            if(rs != null) {
                rs.close();
            } 
            if(stm != null) {
                stm.close();
            }
            if(con != null) {
                con.close();
            }
        }
    }
    public void searchByID (String searchValue) 
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try { 
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "SELECT * FROM Customer Where Customer.ID = ? AND isDeleted = 0";
                stm = con.prepareStatement(sql);
                stm.setString(1,searchValue);
                
                rs = stm.executeQuery();
                
                while(rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String lastname = rs.getString("lastname");
                    String firstname = rs.getString("firstname");
                    String phone = rs.getString("Phone");
                    String address = rs.getString("Address");
                    boolean isAdmin = rs.getBoolean("isAdmin");
                    RegistrationDTO dto = new RegistrationDTO(username,password,lastname,firstname,phone,address,isAdmin);
                    if(listAccounts == null) {
                        listAccounts = new ArrayList<RegistrationDTO>();
                    }
                    listAccounts.add(dto);
                }
            }
        } finally { 
            if(rs != null) {
                rs.close();
            } 
            if(stm != null) {
                stm.close();
            }
            if(con != null) {
                con.close();
            }
        }
    }
    
    public void searchAll () 
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try { 
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "SELECT * FROM Customer Where isDeleted = 0";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                
                while(rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String lastname = rs.getString("lastname");
                    String firstname = rs.getString("firstname");
                    boolean isAdmin = rs.getBoolean("isAdmin");
                    RegistrationDTO dto = new RegistrationDTO(username,password,lastname,firstname,null,null,isAdmin);
                    if(listAccounts == null) {
                        listAccounts = new ArrayList<RegistrationDTO>();
                    }
                    listAccounts.add(dto);
                }
            }
        } finally { 
            if(rs != null) {
                rs.close();
            } 
            if(stm != null) {
                stm.close();
            }
            if(con != null) {
                con.close();
            }
        }
    }
    
    public boolean deleteRecord(String pk) 
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        
        try {
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "UPDATE Customer "
                        + "SET isDeleted = 1 "
                        + "Where Username = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1,pk);
                int row = stm.executeUpdate();
                if(row > 0) {
                    return true;
                }
            } 
        } finally {
            if(stm !=null) {
                stm.close();
            }
            if(con !=null) {
                con.close();
            }
        }
        return false;
    }
    
    public boolean updateRecord (String username, String password, boolean admin)
        throws SQLException, NamingException{ 
        Connection con = null;
        PreparedStatement stm = null;
        
        try {
            con = DBUtils.makeConnection();
            if(con !=null) {
                String sql = "Update Customer " + 
                        "Set password = ?, isAdmin = ? Where username= ?";
                stm = con.prepareStatement(sql);
                stm.setString(1,password);
                stm.setBoolean(2, admin);
                stm.setString(3,username);
                
                int row = stm.executeUpdate();
                if( row > 0 ) {
                    return true;
                }
            }
        } finally {
            if(stm != null) {
                stm.close();
            }
            if(con != null) {
                con.close();
            }
        }
        return false;
    }
    
    public boolean insertAccount (String username, String password, String lastname,String firstname, String phone,String address, boolean delete, boolean role) 
        throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if(con !=null) {
                String sql = "Insert Into Customer(username,password,lastname,firstname,phone,address,isDeleted,isAdmin)"
                            + "Values(?,?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1,username);
                stm.setString(2,password);
                stm.setString(3,lastname);
                stm.setString(4,firstname);
                stm.setString(5,phone);
                stm.setString(6,address);
                stm.setBoolean(7,delete);
                stm.setBoolean(8,role);
                
                int row = stm.executeUpdate();
                if(row > 0) {
                    return true;
                }
            }
        } finally {
            if(stm !=null) {
                stm.close();
            }
            if(con !=null) {
                con.close();
            }
        }
        return false;
    }
}
