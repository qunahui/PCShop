/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PCShop.controllers;

import PCShop.daos.RegistrationDAO;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hui
 */
@WebServlet(name = "AddAccountController", urlPatterns = {"/AddAccountController"})
public class AddAccountController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = (String) request.getParameter("regUsername");
        String password = (String) request.getParameter("regPassword");
        password = this.hashPassword(password);
        String lastname = (String) request.getParameter("regLastname");
        String firstname = (String) request.getParameter("regFirstname");
        String phone = (String) request.getParameter("regPhone");
        String Address = (String) request.getParameter("regAddress");
        try {
            
            RegistrationDAO dao = new RegistrationDAO();
            boolean res = dao.insertAccount(username, password, lastname, firstname, phone, Address, false, false);
            if(res == true) {
                log("Add success");
            } else {
                log("Add failed");
            }
        } catch (Exception e) {
            request.setAttribute("REGISTERERROR", "The username already exists. Please use a different username !");
            request.setAttribute("regUsername", username);
            request.setAttribute("regPassword", password);
            request.setAttribute("regLastname", lastname);
            request.setAttribute("regFirstname", firstname);
            request.setAttribute("regPhone", phone);
            request.setAttribute("regAddress", Address);
            log("ERROR at AddAccountController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher("Shopping/shopping.jsp").forward(request, response);
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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
