/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PCShop.admin.controllers;

import PCShop.daos.ProductDAO;
import PCShop.dtos.ProductDTO;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "AdminViewShopController", urlPatterns = {"/admin/ViewShopController"})
public class ViewShopController extends HttpServlet {

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
        request.setCharacterEncoding("utf-8");
        try {
//           HttpSession session = request.getSession();
           String sortBy = request.getParameter("sortBy");
           if(sortBy == null) {
               sortBy = "sortByDate";
           }
            
           ProductDAO dao = new ProductDAO();
           if(sortBy.equals("sortByDate")) {
               dao.searchAllByDate();
           } else if(sortBy.equals("sortByPriceASC")){
               dao.searchAllByPriceASC();
           } else if(sortBy.equals("sortByPriceDESC")){
               dao.searchAllByPriceDESC();
           }
           
           List<ProductDTO> result = dao.getListProducts();
           request.setAttribute("SEARCHRESULT", result);
           request.setAttribute("OPTIONSELECTED",sortBy);
        } catch (Exception e) {
            log("ERROR at UserViewShopController: " + e.getMessage());
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
