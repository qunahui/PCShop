/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PCShop.daos;


import PCShop.dtos.ProductDTO;
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
public class ProductDAO implements Serializable{

    private List<ProductDTO> listProducts;
    
    public List<ProductDTO> getListProducts() {
        return listProducts;
    };
    
    public void searchName(String searchValue) 
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try { 
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "SELECT * FROM Product Where Product.name Like ? AND isDeleted = 0";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                rs = stm.executeQuery();
                
                while(rs.next()) {
                    String ID = rs.getString("ID").toLowerCase();
                    String categoryID = rs.getString("categoryID");
                    String description = rs.getString("description");
                    String name = rs.getString("name");
                    String details = rs.getString("details");
                    long quantityProduct = rs.getLong("quantityProduct");
                    long price = rs.getLong("price");
                    long discount = rs.getLong("discount");
                    double aveRating = rs.getDouble("aveRating");
                    String path = rs.getString("titlePath");
                    ProductDTO dto = new ProductDTO(ID,categoryID,description,name,details,quantityProduct,price,discount,aveRating,path);
                    if(listProducts == null) {
                        listProducts = new ArrayList<ProductDTO>();
                    }
                    listProducts.add(dto);
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
    public void searchByID(String searchValue) 
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try { 
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "SELECT * FROM Product Where Product.ID LIKE ? AND isDeleted = 0";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                rs = stm.executeQuery();
                
                while(rs.next()) {
                    String ID = rs.getString("ID").toLowerCase();
                    String categoryID = rs.getString("categoryID");
                    String description = rs.getString("description");
                    String name = rs.getString("name");
                    String details = rs.getString("details");
                    long quantityProduct = rs.getLong("quantityProduct");
                    long price = rs.getLong("price");
                    long discount = rs.getLong("discount");
                    double aveRating = rs.getDouble("aveRating");
                    String path = rs.getString("titlePath");
                    ProductDTO dto = new ProductDTO(ID,categoryID,description,name,details,quantityProduct,price,discount,aveRating,path);
                    if(listProducts == null) {
                        listProducts = new ArrayList<ProductDTO>();
                    }
                    listProducts.add(dto);
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
    public void searchAll() 
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try { 
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "SELECT * FROM Product Where isDeleted = 0";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                
                while(rs.next()) {
                    String ID = rs.getString("ID").toLowerCase();
                    String categoryID = rs.getString("categoryID");
                    String description = rs.getString("description");
                    String name = rs.getString("name");
                    String details = rs.getString("details");
                    long quantityProduct = rs.getLong("quantityProduct");
                    long price = rs.getLong("price");
                    long discount = rs.getLong("discount");
                    double aveRating = rs.getDouble("aveRating");
                    String path = rs.getString("titlePath");
                    ProductDTO dto = new ProductDTO(ID,categoryID,description,name,details,quantityProduct,price,discount,aveRating,path);
                    if(listProducts == null) {
                        listProducts = new ArrayList<ProductDTO>();
                    }
                    listProducts.add(dto);
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
    public void searchAllByDate() 
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try { 
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "SELECT * FROM Product Where isDeleted = 0 ORDER BY addDate DESC";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                
                while(rs.next()) {
                    String ID = rs.getString("ID").toLowerCase();
                    String categoryID = rs.getString("categoryID");
                    String description = rs.getString("description");
                    String name = rs.getString("name");
                    String details = rs.getString("details");
                    long quantityProduct = rs.getLong("quantityProduct");
                    long price = rs.getLong("price");
                    long discount = rs.getLong("discount");
                    double aveRating = rs.getDouble("aveRating");
                    String path = rs.getString("titlePath");
                    ProductDTO dto = new ProductDTO(ID,categoryID,description,name,details,quantityProduct,price,discount,aveRating,path);
                    if(listProducts == null) {
                        listProducts = new ArrayList<ProductDTO>();
                    }
                    listProducts.add(dto);
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
    public void searchAllByPriceASC() 
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try { 
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "SELECT * FROM Product Where isDeleted = 0 ORDER BY Price ASC";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                
                while(rs.next()) {
                    String ID = rs.getString("ID").toLowerCase();
                    String categoryID = rs.getString("categoryID");
                    String description = rs.getString("description");
                    String name = rs.getString("name");
                    String details = rs.getString("details");
                    long quantityProduct = rs.getLong("quantityProduct");
                    long price = rs.getLong("price");
                    long discount = rs.getLong("discount");
                    double aveRating = rs.getDouble("aveRating");
                    String path = rs.getString("titlePath");
                    ProductDTO dto = new ProductDTO(ID,categoryID,description,name,details,quantityProduct,price,discount,aveRating,path);
                    if(listProducts == null) {
                        listProducts = new ArrayList<ProductDTO>();
                    }
                    listProducts.add(dto);
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
    public void searchAllByPriceDESC() 
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try { 
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "SELECT * FROM Product Where isDeleted = 0 ORDER BY Price DESC";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                
                while(rs.next()) {
                    String ID = rs.getString("ID").toLowerCase();
                    String categoryID = rs.getString("categoryID");
                    String description = rs.getString("description");
                    String name = rs.getString("name");
                    String details = rs.getString("details");
                    long quantityProduct = rs.getLong("quantityProduct");
                    long price = rs.getLong("price");
                    long discount = rs.getLong("discount");
                    double aveRating = rs.getDouble("aveRating");
                    String path = rs.getString("titlePath");
                    ProductDTO dto = new ProductDTO(ID,categoryID,description,name,details,quantityProduct,price,discount,aveRating,path);
                    if(listProducts == null) {
                        listProducts = new ArrayList<ProductDTO>();
                    }
                    listProducts.add(dto);
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
    public void searchCategoryByDate(String categoryName) 
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try { 
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "SELECT * "
                        + "FROM dbo.Product,dbo.Category "
                        + "WHERE Product.categoryID = Category.ID AND Category.name = ? AND Product.isDeleted = 0"
                        + "ORDER BY addDate DESC";
                stm = con.prepareStatement(sql);
                stm.setString(1,categoryName);
                rs = stm.executeQuery();
                
                while(rs.next()) {
                    String ID = rs.getString("ID").toLowerCase();
                    String categoryID = rs.getString("categoryID");
                    String description = rs.getString("description");
                    String name = rs.getString("name");
                    String details = rs.getString("details");
                    long quantityProduct = rs.getLong("quantityProduct");
                    long price = rs.getLong("price");
                    long discount = rs.getLong("discount");
                    double aveRating = rs.getDouble("aveRating");
                    String path = rs.getString("titlePath");
                    ProductDTO dto = new ProductDTO(ID,categoryID,description,name,details,quantityProduct,price,discount,aveRating,path);
                    if(listProducts == null) {
                        listProducts = new ArrayList<ProductDTO>();
                    }
                    listProducts.add(dto);
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
    public void searchCategoryByPriceASC(String categoryName) 
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try { 
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "SELECT * "
                        + "FROM dbo.Product,dbo.Category "
                        + "WHERE Product.categoryID = Category.ID AND Category.name = ? AND Product.isDeleted = 0"
                        + "ORDER BY Price ASC";
                stm = con.prepareStatement(sql);
                stm.setString(1,categoryName);
                rs = stm.executeQuery();
                
                while(rs.next()) {
                    String ID = rs.getString("ID").toLowerCase();
                    String categoryID = rs.getString("categoryID");
                    String description = rs.getString("description");
                    String name = rs.getString("name");
                    String details = rs.getString("details");
                    long quantityProduct = rs.getLong("quantityProduct");
                    long price = rs.getLong("price");
                    long discount = rs.getLong("discount");
                    double aveRating = rs.getDouble("aveRating");
                    String path = rs.getString("titlePath");
                    ProductDTO dto = new ProductDTO(ID,categoryID,description,name,details,quantityProduct,price,discount,aveRating,path);
                    if(listProducts == null) {
                        listProducts = new ArrayList<ProductDTO>();
                    }
                    listProducts.add(dto);
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
    public void searchCategoryByPriceDESC(String categoryName) 
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try { 
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "SELECT * "
                        + "FROM dbo.Product,dbo.Category "
                        + "WHERE Product.categoryID = Category.ID AND Category.name = ? AND Product.isDeleted = 0"
                        + "ORDER BY Price DESC";
                stm = con.prepareStatement(sql);
                stm.setString(1,categoryName);
                rs = stm.executeQuery();
                
                while(rs.next()) {
                    String ID = rs.getString("ID").toLowerCase();
                    String categoryID = rs.getString("categoryID");
                    String description = rs.getString("description");
                    String name = rs.getString("name");
                    String details = rs.getString("details");
                    long quantityProduct = rs.getLong("quantityProduct");
                    long price = rs.getLong("price");
                    long discount = rs.getLong("discount");
                    double aveRating = rs.getDouble("aveRating");
                    String path = rs.getString("titlePath");
                    ProductDTO dto = new ProductDTO(ID,categoryID,description,name,details,quantityProduct,price,discount,aveRating,path);
                    if(listProducts == null) {
                        listProducts = new ArrayList<ProductDTO>();
                    }
                    listProducts.add(dto);
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
    public void searchNameByDate(String searchValue) 
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try { 
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "SELECT * FROM Product Where Product.name Like ? AND isDeleted = 0 ORDER BY addDate ASC";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                rs = stm.executeQuery();
                
                while(rs.next()) {
                    String ID = rs.getString("ID").toLowerCase();
                    String categoryID = rs.getString("categoryID");
                    String description = rs.getString("description");
                    String name = rs.getString("name");
                    String details = rs.getString("details");
                    long quantityProduct = rs.getLong("quantityProduct");
                    long price = rs.getLong("price");
                    long discount = rs.getLong("discount");
                    double aveRating = rs.getDouble("aveRating");
                    String path = rs.getString("titlePath");
                    ProductDTO dto = new ProductDTO(ID,categoryID,description,name,details,quantityProduct,price,discount,aveRating,path);
                    if(listProducts == null) {
                        listProducts = new ArrayList<ProductDTO>();
                    }
                    listProducts.add(dto);
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
    public void searchNameByPriceASC(String searchValue) 
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try { 
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "SELECT * FROM Product Where Product.name Like ? AND isDeleted = 0 ORDER BY Price ASC";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                rs = stm.executeQuery();
                
                while(rs.next()) {
                    String ID = rs.getString("ID").toLowerCase();
                    String categoryID = rs.getString("categoryID");
                    String description = rs.getString("description");
                    String name = rs.getString("name");
                    String details = rs.getString("details");
                    long quantityProduct = rs.getLong("quantityProduct");
                    long price = rs.getLong("price");
                    long discount = rs.getLong("discount");
                    double aveRating = rs.getDouble("aveRating");
                    String path = rs.getString("titlePath");
                    ProductDTO dto = new ProductDTO(ID,categoryID,description,name,details,quantityProduct,price,discount,aveRating,path);
                    if(listProducts == null) {
                        listProducts = new ArrayList<ProductDTO>();
                    }
                    listProducts.add(dto);
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
    public void searchNameByPriceDESC(String searchValue) 
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try { 
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "SELECT * FROM Product Where Product.name Like ? AND isDeleted = 0 ORDER BY Price DESC";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                rs = stm.executeQuery();
                
                while(rs.next()) {
                    String ID = rs.getString("ID").toLowerCase();
                    String categoryID = rs.getString("categoryID");
                    String description = rs.getString("description");
                    String name = rs.getString("name");
                    String details = rs.getString("details");
                    long quantityProduct = rs.getLong("quantityProduct");
                    long price = rs.getLong("price");
                    long discount = rs.getLong("discount");
                    double aveRating = rs.getDouble("aveRating");
                    String path = rs.getString("titlePath");
                    ProductDTO dto = new ProductDTO(ID,categoryID,description,name,details,quantityProduct,price,discount,aveRating,path);
                    if(listProducts == null) {
                        listProducts = new ArrayList<ProductDTO>();
                    }
                    listProducts.add(dto);
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
    public String insertProduct (String categoryID, String description, String name, String quantityProduct, String price, String discount, String details) 
        throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if(con !=null) {
                String sql = "INSERT INTO dbo.Product (ID, categoryID, description, name,quantityProduct, price, isDeleted, discount, details, addDate)\n"
                            +"OUTPUT Inserted.ID\n"
                            + "Values(NEWID(),?,?,?,?,?,0,?,?,CURRENT_TIMESTAMP)";
                stm = con.prepareStatement(sql);
                stm.setString(1,categoryID);
                stm.setString(2,description);
                stm.setString(3,name);
                stm.setInt(4,Integer.parseInt(quantityProduct));
                stm.setInt(5,Integer.parseInt(price));
                stm.setInt(6,Integer.parseInt(discount));
                stm.setString(7,details);
                
                ResultSet rs= stm.executeQuery();
                
                if(rs.next()) {
                    return rs.getString("ID");
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
        return "failed";
    }
    public void updatePath(String pk, String path) 
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        System.out.println(pk);
        try {
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "UPDATE dbo.Product "
                        + "SET titlePath = '/PCShop/assets/product/" + path.toLowerCase() + "'\n"
                        + "Where ID = ?";
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
        return;
    }
    public void updateQuantity(String pk, int quantity) 
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        System.out.println(pk);
        try {
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "UPDATE dbo.Product "
                        + "SET quantityProduct = ?"
                        + "WHERE ID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1,quantity);
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
        return;
    }
    public boolean updateProduct(String ID, String categoryID, String description, String name, String quantityProduct, String price, String discount, String details)     
        throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if(con !=null) {
                String sql = "UPDATE dbo.Product " 
                            + "SET categoryID = ?, "
                            + "description = ?, "
                            + "name = ?, "
                            + "quantityProduct = ?, "
                            + "price = ?, "
                            + "discount = ?, "
                            + "details = ? " 
                            + "WHERE Product.ID = ? ";
                stm = con.prepareStatement(sql);
                stm.setNString(1,categoryID);
                stm.setNString(2,description);
                stm.setNString(3,name);
                stm.setInt(4,Integer.parseInt(quantityProduct));
                stm.setInt(5,Integer.parseInt(price));
                stm.setInt(6,Integer.parseInt(discount));
                stm.setNString(7,details);
                stm.setNString(8,ID);
                System.out.println(stm.toString());
                int rs= stm.executeUpdate();
                
                if(rs > 0) {
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
    public boolean deleteRecord(String pk) 
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        
        try {
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "UPDATE dbo.Product "
                        + "SET isDeleted = 1 "
                        + "Where Product.ID = ?";
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
    public int getQuantityOf(String pk) 
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        
        try {
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "SELECT quantityProduct FROM Product WHERE Product.ID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1,pk);
                ResultSet rs = stm.executeQuery();
                if(rs.next()) {
                    return rs.getInt("quantityProduct");
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
        return -1;
    }
    
//    public boolean updateRecord (String username, String password, boolean admin)
//        throws SQLException, NamingException{ 
//        Connection con = null;
//        PreparedStatement stm = null;
//        
//        try {
//            con = DBUtils.makeConnection();
//            if(con !=null) {
//                String sql = "Update Customer " + 
//                        "Set password = ?, isAdmin = ? Where username= ?";
//                stm = con.prepareStatement(sql);
//                stm.setString(1,password);
//                stm.setBoolean(2, admin);
//                stm.setString(3,username);
//                
//                int row = stm.executeUpdate();
//                if( row > 0 ) {
//                    return true;
//                }
//            }
//        } finally {
//            if(stm != null) {
//                stm.close();
//            }
//            if(con != null) {
//                con.close();
//            }
//        }
//        return false;
//    }
//    

}
