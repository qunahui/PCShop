/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PCShop.admin.controllers;

import PCShop.daos.RegistrationDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hui
 */
@WebServlet(name = "AdminDeleteAccountController", urlPatterns = {"/admin/DeleteAccountController"})
public class DeleteAccountController extends HttpServlet {

    private final String deleteErr = "deleteErr.html";
    private final String VIEW_ACCOUNT_CONTROLLER = "/PCShop/admin/ViewAccountController";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
           String pk = request.getParameter("pk");
           String searchValue = request.getParameter("lastSearchValue");
           
           RegistrationDAO dao = new RegistrationDAO();
           boolean result = dao.deleteRecord(pk);
           String url = deleteErr;
           if(result) {
               url = VIEW_ACCOUNT_CONTROLLER;
           }   
            if(result) {
               log(url);
           }
           
           response.sendRedirect(url);
        } catch(SQLException ex) {
               log("DeleteServlet_SQL " + ex.getMessage());
        } catch(NamingException ex) {
               log("DeleteServlet_JNDI " + ex.getMessage());
        } finally{
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
