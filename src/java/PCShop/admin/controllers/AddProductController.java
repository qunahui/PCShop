/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PCShop.admin.controllers;

import PCShop.daos.ProductDAO;
import java.io.*;
import java.nio.file.Files; 
import java.nio.file.*; 
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hui
 */
@WebServlet(name = "AdminAddProductController", urlPatterns = {"/admin/AddProductController"})
public class AddProductController extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        String categoryID = request.getAttribute("categoryID").toString();
        String desciption = request.getAttribute("desciption").toString();
        String name = request.getAttribute("name").toString();
        String quantity = request.getAttribute("quantity").toString();
        String price = request.getAttribute("price").toString();
        String discount = request.getAttribute("discount").toString();
        String details = request.getAttribute("details").toString();
        String RealPath = request.getAttribute("RealPath").toString();
        String fileName = request.getAttribute("fileName").toString();
        File file = new File(RealPath + "temp\\" + fileName);
        String result = null;
        try {
            
            ProductDAO dao = new ProductDAO();
            result = dao.insertProduct(categoryID, desciption, name, quantity, price, discount, details).toLowerCase();
            String moveFrom = RealPath + "temp\\" + fileName;
            String moveToWebFolder = "E:\\Hoxtap\\Semester6\\JAVA\\Project\\PCShop\\PCShop\\web\\assets\\product\\" + result + "\\" + fileName;
            new File("E:\\Hoxtap\\Semester6\\JAVA\\Project\\PCShop\\PCShop\\web\\assets\\product\\" + result).mkdir();
            new File(RealPath + result).mkdir();
            log("move from: " + moveFrom + " to: " + moveToWebFolder);
            Path temp = Files.move(Paths.get(moveFrom), Paths.get(moveToWebFolder));
            if(temp != null) 
                { 
                    System.out.println("File renamed and moved successfully"); 
                    temp = Files.copy(Paths.get(moveToWebFolder), Paths.get(RealPath + result + "\\" + fileName), StandardCopyOption.REPLACE_EXISTING);
                } 
                else
                { 
                    System.out.println("Failed to move the file"); 
                } 
            dao.updatePath(result, result + "/" + fileName);
            request.getRequestDispatcher("ViewShopController").forward(request, response);
        } catch (Exception e) {
            log("ERROR at AdminAddProductController: " + e.getMessage());
        } finally {
            out.close();
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
