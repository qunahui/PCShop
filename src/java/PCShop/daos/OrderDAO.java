package PCShop.daos;


import PCShop.dtos.OrderDTO;
import PCShop.dtos.ProductDTO;
import PCShop.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hui
 */
public class OrderDAO {
    private List<OrderDTO> listOrders;
    
    public List<OrderDTO> getListOrders() {
        return listOrders;
    };
    
    public int getLength() {
        return this.listOrders.size();
    }
    public void searchAll() 
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try { 
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "SELECT * FROM [dbo].[Order] WHERE isDeleted = 0";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                
                while(rs.next()) {
                    String ID = rs.getString("ID").toLowerCase();
                    String OrderDate = rs.getString("OrderDate");
                    int Status = rs.getInt("Status");
                    String Note = rs.getString("Note");
                    String CustomerID = rs.getString("CustomerID");
                    String CustomerName = rs.getString("CustomerName");
                    String CustomerPhone = rs.getString("CustomerPhone");
                    String CustomerEmail = rs.getString("CustomerEmail");
                    String CustomerAddress = rs.getString("CustomerAddress");
                    boolean isDeleted = rs.getBoolean("isDeleted");
                    OrderDTO dto = new OrderDTO(ID,CustomerID,OrderDate,Status,Note,CustomerName,CustomerPhone,CustomerEmail,CustomerAddress,isDeleted);
                    if(listOrders == null) {
                        listOrders = new ArrayList<OrderDTO>();
                    }
                    listOrders.add(dto);
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
    public void searchUnconfirmed() 
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try { 
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "SELECT * FROM [dbo].[Order] WHERE Status = 1 AND isDeleted = 0";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                
                while(rs.next()) {
                    String ID = rs.getString("ID").toLowerCase();
                    String OrderDate = rs.getString("OrderDate");
                    int Status = rs.getInt("Status");
                    String Note = rs.getString("Note");
                    String CustomerID = rs.getString("CustomerID");
                    String CustomerName = rs.getString("CustomerName");
                    String CustomerPhone = rs.getString("CustomerPhone");
                    String CustomerEmail = rs.getString("CustomerEmail");
                    String CustomerAddress = rs.getString("CustomerAddress");
                    boolean isDeleted = rs.getBoolean("isDeleted");
                    OrderDTO dto = new OrderDTO(ID,CustomerID,OrderDate,Status,Note,CustomerName,CustomerPhone,CustomerEmail,CustomerAddress,isDeleted);
                    if(listOrders == null) {
                        listOrders = new ArrayList<OrderDTO>();
                    }
                    listOrders.add(dto);
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
    public void searchOnProcess() 
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try { 
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "SELECT * FROM [dbo].[Order] WHERE Status = 2 AND isDeleted = 0";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                
                while(rs.next()) {
                    String ID = rs.getString("ID").toLowerCase();
                    String OrderDate = rs.getString("OrderDate");
                    int Status = rs.getInt("Status");
                    String Note = rs.getString("Note");
                    String CustomerID = rs.getString("CustomerID");
                    String CustomerName = rs.getString("CustomerName");
                    String CustomerPhone = rs.getString("CustomerPhone");
                    String CustomerEmail = rs.getString("CustomerEmail");
                    String CustomerAddress = rs.getString("CustomerAddress");
                    boolean isDeleted = rs.getBoolean("isDeleted");
                    OrderDTO dto = new OrderDTO(ID,CustomerID,OrderDate,Status,Note,CustomerName,CustomerPhone,CustomerEmail,CustomerAddress,isDeleted);
                    if(listOrders == null) {
                        listOrders = new ArrayList<OrderDTO>();
                    }
                    listOrders.add(dto);
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
    public void searchDeliveried() 
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try { 
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "SELECT * FROM [dbo].[Order] WHERE Status = 3 AND isDeleted = 0";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                
                while(rs.next()) {
                    String ID = rs.getString("ID").toLowerCase();
                    String OrderDate = rs.getString("OrderDate");
                    int Status = rs.getInt("Status");
                    String Note = rs.getString("Note");
                    String CustomerID = rs.getString("CustomerID");
                    String CustomerName = rs.getString("CustomerName");
                    String CustomerPhone = rs.getString("CustomerPhone");
                    String CustomerEmail = rs.getString("CustomerEmail");
                    String CustomerAddress = rs.getString("CustomerAddress");
                    boolean isDeleted = rs.getBoolean("isDeleted");
                    OrderDTO dto = new OrderDTO(ID,CustomerID,OrderDate,Status,Note,CustomerName,CustomerPhone,CustomerEmail,CustomerAddress,isDeleted);
                    if(listOrders == null) {
                        listOrders = new ArrayList<OrderDTO>();
                    }
                    listOrders.add(dto);
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
    public void searchDeleted() 
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try { 
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "SELECT * FROM [dbo].[Order] WHERE isDeleted = 1";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                
                while(rs.next()) {
                    String ID = rs.getString("ID").toLowerCase();
                    String OrderDate = rs.getString("OrderDate");
                    int Status = rs.getInt("Status");
                    String Note = rs.getString("Note");
                    String CustomerID = rs.getString("CustomerID");
                    String CustomerName = rs.getString("CustomerName");
                    String CustomerPhone = rs.getString("CustomerPhone");
                    String CustomerEmail = rs.getString("CustomerEmail");
                    String CustomerAddress = rs.getString("CustomerAddress");
                    boolean isDeleted = rs.getBoolean("isDeleted");
                    OrderDTO dto = new OrderDTO(ID,CustomerID,OrderDate,Status,Note,CustomerName,CustomerPhone,CustomerEmail,CustomerAddress,isDeleted);
                    if(listOrders == null) {
                        listOrders = new ArrayList<OrderDTO>();
                    }
                    listOrders.add(dto);
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
    public String createOrder(String CustomerID, String CustomerName, String CustomerEmail, String CustomerPhone,String CustomerAddress, String Note) 
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try { 
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "INSERT [dbo].[Order] (ID, CustomerID, OrderDate, Status, Note, CustomerName, CustomerPhone, CustomerEmail, CustomerAddress, isDeleted)\n"
                            +"OUTPUT Inserted.ID\n"
                            + "Values(NEWID(),?,CURRENT_TIMESTAMP,1,?,?,?,?,?,0)";
                stm = con.prepareStatement(sql);
                stm.setString(1,CustomerID);
                stm.setString(2,Note);
                stm.setString(3,CustomerName);
                stm.setString(4,CustomerPhone);
                stm.setString(5,CustomerEmail);
                stm.setString(6,CustomerAddress);
                System.out.println(stm.toString());
                rs = stm.executeQuery();
                if(rs.next()) {
                    return rs.getString("ID");
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
        return "failed";
    }
    public String createOrderProduct(String OrderID,String ProductID,int quantityOrder,double priceEach) 
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try { 
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "INSERT [dbo].[Order_Product] (ID, OrderID, ProductID, quantityOrdered, priceEach, orderDate)\n"
                            + "Values(NEWID(),?,?,?,?,CURRENT_TIMESTAMP)";
                stm = con.prepareStatement(sql);
                stm.setString(1, OrderID);
                stm.setString(2, ProductID);
                stm.setInt(3, quantityOrder);
                stm.setDouble(4, priceEach);
                System.out.println(stm.toString());
                int rs = stm.executeUpdate();
                if(rs > 0) {
                    return "success";
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
        return "failed";
    }
    public void setConfirmedStatus(String pk,int Status)
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        System.out.println(pk);
        try {
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "UPDATE [dbo].[Order] "
                        + "SET Status = ? "
                        + "WHERE ID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1,Status);
                stm.setString(2,pk);
                int row = stm.executeUpdate();
                if(row > 0) {
                    return;
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
    }
    public void restoreOrder(String pk)
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        System.out.println(pk);
        try {
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "UPDATE [dbo].[Order] "
                        + "SET Status = 2, isDeleted = 0"
                        + "WHERE ID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1,pk);
                int row = stm.executeUpdate();
                if(row > 0) {
                    return;
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
    }
    public void deleteOrder(String pk)
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        System.out.println(pk);
        try {
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "UPDATE [dbo].[Order] "
                        + "SET isDeleted = 1, Status = 4"
                        + "WHERE ID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1,pk);
                int row = stm.executeUpdate();
                if(row > 0) {
                    return;
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
    }
    public void updateOrder(String pk, String CustomerName, String CustomerPhone, String CustomerAddress, String Note)
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        System.out.println(pk);
        try {
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "UPDATE [dbo].[Order] "
                        + "SET CustomerName = ?, CustomerPhone = ?, CustomerAddress = ?, Note = ?, isDeleted = 0"
                        + "WHERE ID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1,CustomerName);
                stm.setString(2,CustomerPhone);
                stm.setString(3,CustomerAddress);
                stm.setString(4,Note);
                stm.setString(5,pk);
                int row = stm.executeUpdate();
                if(row > 0) {
                    return;
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
    }
}
