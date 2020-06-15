/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PCShop.daos;

import PCShop.dtos.CommentDTO;
import PCShop.dtos.OrderDTO;
import PCShop.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author Hui
 */
public class CommentDAO {
    private List<CommentDTO> listComments;
    
    public List<CommentDTO> getListComments() {
        return listComments;
    };
    
    public int getLength() {
        return this.listComments.size();
    }
    
    public void searchByProductID(String proID) 
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try { 
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "SELECT * FROM Review WHERE isDeleted = 0 AND ProductID = '" + proID + "'";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                
                while(rs.next()) {
                    String ID = rs.getString("ID").toLowerCase();
                    String CustomerID = rs.getString("CustomerID");
                    String CustomerName = rs.getString("CustomerName");
                    String ProductID = rs.getString("ProductID");
                    String Comment = rs.getString("Comment");
                    String AddDate = rs.getString("AddDate");
                    int Rating = rs.getInt("Rating");
                    CommentDTO dto = new CommentDTO(ID,CustomerID,CustomerName,ProductID,Comment,Rating,AddDate);
                    if(listComments == null) {
                        listComments = new ArrayList<CommentDTO>();
                    }
                    listComments.add(dto);
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
    
    public boolean addNewReview(String CustomerID, String CustomerName, String ProductID, String Comment,int Rating)
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try { 
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "INSERT [dbo].[Review] (ID, CustomerID, CustomerName, ProductID, Comment,Rating, AddDate, isDeleted)\n"
                            + "Values(NEWID(),?,?,?,?,?,CURRENT_TIMESTAMP,0)";
                stm = con.prepareStatement(sql);
                stm.setString(1, CustomerID);
                stm.setString(2, CustomerName);
                stm.setString(3, ProductID);
                stm.setString(4, Comment);
                stm.setInt(5, Rating);
                int rs = stm.executeUpdate();
                if(rs > 0) {
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
    
    public boolean deleteComment(String pk)
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "UPDATE [dbo].[Review] "
                        + "SET isDeleted = 1"
                        + "WHERE ID = ?";
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
}
