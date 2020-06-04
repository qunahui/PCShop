/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PCShop.controllers;

import PCShop.cart.CartObj;
import PCShop.daos.OrderDAO;
import PCShop.daos.ProductDAO;
import PCShop.product.ProductObj;
import java.io.IOException;
import java.util.Map;
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
@WebServlet(name = "ConfirmCheckOutController", urlPatterns = {"/ConfirmCheckOutController"})
public class ConfirmCheckOutController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String ERROR = "error.jsp";
    private final String SENDMAIL = "SendMailController";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            String comment = null;
            String orderID = null;
            String memberID = session.getAttribute("MEMBERID").toString();
            String memberName = request.getParameter("txtFirstname") + " " + request.getParameter("txtLastname");
            String memberMail = request.getParameter("txtMail");
            String memberPhone = request.getParameter("txtPhone");
            String memberAddress = request.getParameter("txtAddress");
            String memberNote = request.getParameter("txtNote");
            CartObj cart = (CartObj) session.getAttribute("CART");
            if(cart.isEmpty()) {
                log("Cart is empty");
            } else {
                OrderDAO dao = new OrderDAO();
                ProductDAO proDAO = new ProductDAO();
                if(memberID.equals("guess")) {
                    memberID = null;
                }
                orderID = dao.createOrder(memberID, memberName, memberMail, memberPhone, memberAddress, memberNote);
                Map<String,ProductObj> products = cart.getProducts();
                for (Map.Entry<String,ProductObj> entry : products.entrySet()) {
                    dao.createOrderProduct(orderID, entry.getKey(), entry.getValue().getQuantity(), entry.getValue().getPrice());
                }
                request.setAttribute("ORDERID", orderID);
                request.setAttribute("ORDERSTATUS", 1);
                request.setAttribute("ORDERCUSTOMERNAME", memberName);
                request.setAttribute("ORDERCUSTOMERPHONE", memberPhone);
                request.setAttribute("ORDERCUSTOMERADDRESS", memberAddress);
                request.setAttribute("ORDERCUSTOMERNOTE", memberNote);
                request.setAttribute("TOMAIL",memberMail);
                
                url = SENDMAIL;
            }
        } catch (Exception e) {
            log("ERROR at ConfirmCheckOutController: " + e.getMessage());
        } finally {
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
