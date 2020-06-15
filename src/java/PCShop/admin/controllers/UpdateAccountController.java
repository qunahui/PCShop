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
@WebServlet(name = "AdminUpdateAccountController", urlPatterns = {"/admin/UpdateAccountController"})
public class UpdateAccountController extends HttpServlet {
    private final String VIEW_ACCOUNT_CONTROLLER = "/PCShop/admin/ViewAccountController";
    private final String updateErr = "updateErr.html";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("btnAction");
            if (action.equals("Update")) {
                try {
                   String username = request.getParameter("txtUsername");
                   String password = request.getParameter("txtPassword");
                   String admin = request.getParameter("chkAdmin");
                   boolean role = false;
                   if(admin !=null) {
                       role = true;
                   }

                   String searchValue = request.getParameter("lastSearchValue");
                   RegistrationDAO dao = new RegistrationDAO();
                   boolean result = dao.updateRecord(username, password, role);
                   String url = updateErr;
                   if(result) {
                       url = VIEW_ACCOUNT_CONTROLLER;
                   }
                   response.sendRedirect(url);
                } catch(SQLException ex) {
                       log("UpdateServlet_SQL " + ex.getMessage());
                } catch(NamingException ex) {
                       log("UpdateServlet_JNDI " + ex.getMessage());
                } finally{

                }
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
