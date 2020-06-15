/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PCShop.admin.controllers;

import PCShop.daos.OrderDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hui
 */
@WebServlet(name = "AdminUpdateOrderController", urlPatterns = {"/admin/UpdateOrderController"})
public class UpdateOrderController extends HttpServlet {
    private final String VIEW_ORDERS_CONTROLLER = "ViewOrdersController";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("btnAction");
        String pk = request.getParameter("pk");
        String CustomerName = request.getParameter("txtCustomerName");
        String CustomerPhone = request.getParameter("txtCustomerPhone");
        String CustomerAddress = request.getParameter("txtCustomerAddress");
        String CustomerNote = request.getParameter("txtNote");
        log("Fix: " + CustomerName);
        String url = VIEW_ORDERS_CONTROLLER;
        try {
            OrderDAO dao = new OrderDAO();
            log("Pk: " + pk);
            if(action.equals("Next step order")) {
                boolean res = dao.setConfirmedStatus(pk,Integer.parseInt(request.getParameter("orderStatus")) + 1);
                if(Integer.parseInt(request.getParameter("orderStatus")) == 2 && res == true) {
                    dao.updateStock(pk);
                }
            } else if(action.equals("Delete order")) {
                dao.deleteOrder(pk);
            } else if(action.equals("Update order")) {
                dao.updateOrder(pk,CustomerName,CustomerPhone,CustomerAddress,CustomerNote);
            } else if(action.equals("Restore order")) {
                dao.restoreOrder(pk);
            }
            url = url + "?" + request.getParameter("lastURL");
            log("url: " + url);
           response.sendRedirect(url);
        } catch(Exception ex) {
               log("Error at UpdateOrderController" + ex.getMessage());
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
