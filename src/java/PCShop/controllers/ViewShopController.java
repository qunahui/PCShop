/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PCShop.controllers;

import PCShop.daos.ProductDAO;
import PCShop.dtos.ProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ViewShopController", urlPatterns = {"/ViewShopController"})
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
        log("view shop as guess");
        try {
            String searchByCategory = request.getParameter("searchByCategory");
            String searchByName = request.getParameter("searchByName");
            String sortBy = request.getParameter("sortBy");
            String searchAction = request.getParameter("action");
            if(sortBy == null) {
               sortBy = "sortByDate";
            }
            log("searchByCategory: " + searchByCategory + " searchByName: " + searchByName + " sortBy: " + sortBy);
            log("search type: " + searchAction);
           ProductDAO dao = new ProductDAO();
           if(searchAction == null || searchByCategory.equals("") && searchByName.equals("")) { 
                if(sortBy.equals("sortByDate")) {
                    dao.searchAllByDate();
                } else if(sortBy.equals("sortByPriceASC")){
                    dao.searchAllByPriceASC();
                } else if(sortBy.equals("sortByPriceDESC")){
                    dao.searchAllByPriceDESC();
                }
           } else if(searchAction.equals("categorySearch")) {
                if(sortBy.equals("sortByDate")) {
                        dao.searchCategoryByDate(searchByCategory);
                    } else if(sortBy.equals("sortByPriceASC")){
                        dao.searchCategoryByPriceASC(searchByCategory);
                    } else if(sortBy.equals("sortByPriceDESC")){
                        dao.searchCategoryByPriceDESC(searchByCategory);
                }
           } else if(searchAction.equals("nameSearch")) {
                if(sortBy.equals("sortByDate")) {
                    dao.searchNameByDate(searchByName);
                } else if(sortBy.equals("sortByPriceASC")){
                    dao.searchNameByPriceASC(searchByName);
                } else if(sortBy.equals("sortByPriceDESC")){
                    dao.searchNameByPriceDESC(searchByName);
                }
           }
           List<ProductDTO> result = dao.getListProducts();
           
           request.setAttribute("SEARCHRESULT", result);
           request.setAttribute("SEARCHBYCATEGORY",searchByCategory);
           request.setAttribute("SEARCHBYNAME",searchByName);
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
