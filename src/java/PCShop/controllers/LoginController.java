/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PCShop.controllers;

import PCShop.daos.RegistrationDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hui
 */
@WebServlet(name = "GuessLoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private final String ADMIN = "admin/landingPage.jsp";
    private final String USER = "user/landingPage.jsp";
    private final String LANDINGPAGE = "landingPage.jsp";
    private String hashPassword(String pass) {
        String passwordToHash = pass;
        String generatedPassword = null;
        try {
                // Create MessageDigest instance for MD5
                MessageDigest md = MessageDigest.getInstance("MD5");
                //Add password bytes to digest
                md.update(passwordToHash.getBytes());
                //Get the hash's bytes 
                byte[] bytes = md.digest();
                //This bytes[] has bytes in decimal format;
                //Convert it to hexadecimal format
                StringBuilder sb = new StringBuilder();
                for(int i=0; i< bytes.length ;i++)
                {
                        sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                }
                //Get complete hashed password in hex format
                generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e){
                e.printStackTrace();
        } finally {
            return generatedPassword;
        }
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = LANDINGPAGE;
        log("begin logging......");
        try {
           String username = request.getParameter("txtUsername");
           String password = request.getParameter("txtPassword");
           password = this.hashPassword(password);
           RegistrationDAO dao = new RegistrationDAO();
           String user[] = dao.checkLogin(username,password);
           HttpSession session = request.getSession(); 
           if(user[0].equals("admin")) {
                url = ADMIN;
                session.removeAttribute("CART");  
                session.setAttribute("USERNAME", username);
                session.setAttribute("ROLE","admin");
                session.setAttribute("MEMBERID",user[1]);
            } else if(user[0].equals("user")) {
                session.removeAttribute("CART");  
                session.setAttribute("USERNAME", username);
                session.setAttribute("ROLE","user");
                session.setAttribute("MEMBERID",user[1]);
            } else if(user[0].equals("failed")) {
               request.setAttribute("ERROR","Wrong username or password !");
            }
           log("Member: " + username + " with id: " + user[1] + " logged, role: " + user[0]);
        } catch (Exception e) {
            log("ERROR at LoginController: " + e.getMessage());
        } finally{
             request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
           processRequest(request, response);
       } catch (SQLException ex) {
           Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
       } catch (NamingException ex) {
           Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
           processRequest(request, response);
       } catch (SQLException ex) {
           Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
       } catch (NamingException ex) {
           Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
