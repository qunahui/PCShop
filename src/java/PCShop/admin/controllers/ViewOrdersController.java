/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PCShop.admin.controllers;

import PCShop.daos.OrderDAO;
import PCShop.dtos.OrderDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hui
 */
@WebServlet(name = "AdminViewOrdersController", urlPatterns = {"/admin/ViewOrdersController"})
public class ViewOrdersController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
                String action = request.getParameter("action");
                OrderDAO dao = new OrderDAO();
                if(action == null) {
                    log("action is null");
                }
                if(action == null || action.equals("Unconfirmed")) {
                    dao.searchUnconfirmed();
                } else if(action.equals("On process")) {
                    dao.searchOnProcess();
                } else if(action.equals("Deliveried")) {
                    dao.searchDeliveried();
                } else if(action.equals("Deleted")) {
                    dao.searchDeleted();
                }
                List<OrderDTO> result = dao.getListOrders();
                request.setAttribute("SEARCHRESULT", result);
        } catch (Exception e) {
            log("ERROR at ViewOrdersController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher("order.jsp").forward(request, response);
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