/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PCShop.admin.controllers;

import PCShop.daos.ProductDAO;
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
@WebServlet(name = "AdminEditProductController", urlPatterns = {"/admin/EditProductController"})
public class EditProductController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String ID = request.getAttribute("ID").toString();
        String categoryID = request.getAttribute("categoryID").toString();
        String description = request.getAttribute("desciption").toString();
        String name = request.getAttribute("name").toString();
        String quantity = request.getAttribute("quantity").toString();
        String price = request.getAttribute("price").toString();
        String discount = request.getAttribute("discount").toString();
        String details = request.getAttribute("details").toString();
        String action = request.getAttribute("action").toString();
        log("action: " + action);
        boolean result = false;
        try {  
            ProductDAO dao = new ProductDAO();
            if(action.equals("Edit product")) {       
                result = dao.updateProduct(ID,categoryID, description, name,quantity, price,discount, details);
                if(result == true) {
                    log("UPDATE SUCCESSFUL");
                }
            } else if(action.equals("Delete product")) {
                result = dao.deleteRecord(ID);
                if(result == true) {
                    log("UPDATE SUCCESSFUL");
                }
            }
            request.getRequestDispatcher("ViewShopController").forward(request, response);
        }  catch (Exception e) {
            log("ERROR at AdminAddProductController: " + e.getMessage());
        } finally {
            
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
