/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PCShop.admin.controllers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Hui
 */
@WebServlet(name = "AdminMainController", urlPatterns = {"/admin/MainController"})
public class MainController extends HttpServlet {
    private static final String VIEW_ACCOUNT_CONTROLLER = "ViewAccountController";
    private static final String SEARCH_ACCOUNT_CONTROLLER = "SearchAccountController";
    private static final String UPDATE_ACCOUNT_CONTROLLER = "UpdateAccountController";
    private static final String DELETE_ACCOUNT_CONTROLLER = "DeleteAccountController";
    private static final String VIEW_ADDPRODUCT_CONTROLLER = "ViewAddProductController";
    private static final String VIEW_LANDINGPAGE_CONTROLLER = "ViewLandingPageController";
    private static final String VIEW_SHOP_CONTROLLER = "ViewAccountController";
    private static final String ADD_PRODUCT_CONTROLLER = "AddProductController";
    private static final String VIEW_PRODUCT_CONTROLLER = "ViewProductController";
    private static final String EDIT_PRODUCT_CONTROLLER = "EditProductController";
    private static final String DELETE_PRODUCT_CONTROLLER = "DeleteProductController";
    private static final String UPDATE_ORDER_CONTROLLER = "UpdateOrderController";
    private static final String ERROR = "/error.jsp";
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
        String url = ERROR;
        try { 
            String controller = request.getParameter("controller");
            if(controller == null) {
                controller = request.getAttribute("controller").toString();
            }
            log("Controller: " + controller);
            if (controller.equals("SearchAccountController")) {
                url = SEARCH_ACCOUNT_CONTROLLER;
            } else if (controller.equals("UpdateAccountController")) {
                url = UPDATE_ACCOUNT_CONTROLLER;
            } else if (controller.equals("DeleteAccountController")) {
                url = DELETE_ACCOUNT_CONTROLLER;
            } else if (controller.equals("ViewAccountController")) {
                url = VIEW_ACCOUNT_CONTROLLER;
            } else if (controller.equals("ViewAddProductController")) {
                url = VIEW_ADDPRODUCT_CONTROLLER;
            } else if (controller.equals("ViewLandingPageController")) {
                url = VIEW_LANDINGPAGE_CONTROLLER;
            } else if (controller.equals("ViewAccountController")) {
                url = VIEW_SHOP_CONTROLLER;
            } else if (controller.equals("AddProductController")) {
                url = ADD_PRODUCT_CONTROLLER;
            } else if(controller.equals("ViewProductController")) {
                url = VIEW_PRODUCT_CONTROLLER;
            }  else if(controller.equals("EditProductController")) {
                url = EDIT_PRODUCT_CONTROLLER;
            } else if(controller.equals("DeleteProductController")) {
                url = DELETE_PRODUCT_CONTROLLER;
            } else if(controller.equals("UpdateOrderController")) {
                url = UPDATE_ORDER_CONTROLLER;
            }
        } catch (Exception e) {
            log("ERROR at AdminMainController: " + e.getMessage());
            request.setAttribute("ERROR", "PAGE NOT FOUND!");
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
        log("post request: ");
        boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
        if(isMultiPart) {
            String result = "";
            String RealPath = null;
            FileItem item = null;
            String fileName = null;

            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
            ServletFileUpload upload = new ServletFileUpload(factory);
            List items = null;
            try {
                items = upload.parseRequest(request);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
            Iterator iter = items.iterator();
            Hashtable params = new Hashtable();
            while (iter.hasNext()) {
                    item = (FileItem) iter.next();
                    if (item.isFormField()) {
                        params.put(item.getFieldName(), item.getString());
                    } else {
                        try {               
                            String itemName = item.getName();
                            fileName = itemName.substring(itemName.lastIndexOf("\\") + 1);
                            System.out.println("path " + fileName);
                            RealPath = getServletContext().getRealPath("/") + "assets\\product\\";
                            System.out.println("Rpath " + RealPath);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
            }
            String ID = (String) params.get("txtProID");
            String categoryID = (String) params.get("txtProCategoryID");
            String desciption = (String) params.get("txtProDescription");
            String name = (String) params.get("txtProName");
            String quantity = (String) params.get("txtProQuantity");
            String price = (String) params.get("txtProPrice");
            String discount = (String) params.get("txtProDiscount");
            String details = (String) params.get("txtProDetails");
            String controller = (String) params.get("controller");
            String action = (String) params.get("action");
                
            if(ID == null) {
                log("begin add product");
                request.setAttribute("categoryID", categoryID);
                request.setAttribute("desciption", desciption);
                request.setAttribute("name", name);
                request.setAttribute("quantity", quantity);
                request.setAttribute("price", price);
                request.setAttribute("discount", discount);
                request.setAttribute("details", details);
                request.setAttribute("controller",controller);
                request.setAttribute("RealPath",RealPath);
                request.setAttribute("fileName",fileName);

                new File(RealPath + "temp\\").mkdir();
                RealPath = RealPath + "temp\\" + fileName; 
                File saveFile = new File(RealPath);
                try {
                    item.write(saveFile);
                } catch (Exception ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                log("begin edit product");
                request.setAttribute("ID", ID);
                request.setAttribute("categoryID", categoryID);
                request.setAttribute("desciption", desciption);
                request.setAttribute("name", name);
                request.setAttribute("quantity", quantity);
                request.setAttribute("price", price);
                request.setAttribute("discount", discount);
                request.setAttribute("details", details);
                request.setAttribute("controller",controller);
                request.setAttribute("action",action);
            }
        }
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
