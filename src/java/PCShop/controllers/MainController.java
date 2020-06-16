package PCShop.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hui
 */
public class MainController extends HttpServlet {
//    private final String landingPage = "View/LandingPage/landingPage.jsp";
//    private final String shoppingPage = "View/Shopping/shopping.jsp";
//    private final String loginServlet = "LoginServlet";
//    private final String logoutServlet = "LogoutServlet";
//    private final String signUpPage = "View/Registration/createNewAccount.html";
//    private final String searchProductServlet = "SearchProductServlet";
//    private final String createAccountServlet = "CreateAccountServlet";
//    private final String addProduct = "AddProductServlet";
//    private final String viewCart = "View/Cart/viewCart.jsp";
    private final String ERROR = "error.jsp";
    private final String LANDING = "landingPage.jsp";
    private final String LOGIN = "LoginController";
    private final String LOGOUT = "LogoutController";
    private final String REGISTER = "ViewRegisterController";
    private final String VIEW_SHOP_CONTROLLER = "ViewShopController";
    private final String VIEW_PRODUCT_CONTROLLER = "ViewProductController";
    private final String VIEW_CART_CONTROLLER = "ViewCartController";
    private final String ADD_ACCOUNT_CONTROLLER = "AddAccountController";
    private final String ADD_CART_CONTROLLER = "AddCartController";
    private final String REMOVE_CART_CONTROLLER = "RemoveCartController";
    private final String UPDATE_CART_CONTROLLER = "UpdateCartController";
    private final String VIEW_CHECK_OUT_CONTROLLER = "ViewCheckOutController";
    private final String CONFIRM_CHECK_OUT_CONTROLLER = "ConfirmCheckOutController";
    private final String VIEW_ACCOUNT_CONTROLLER = "ViewAccountController";
    private final String UPDATE_ACCOUNT_CONTROLLER = "UpdateAccountController";
    private final String ADD_COMMENT_CONTROLLER = "AddCommentController";
    private final String DELETE_COMMENT_CONTROLLER = "DeleteCommentController";
    private final String CANCEL_ORDER_CONTROLLER = "CancelOrderController";
    
    

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");        
        HttpSession session = request.getSession();
        log("MainController received a request");
        if(session.getAttribute("ROLE") == null) {
          session.setAttribute("ROLE","guess");
          session.setAttribute("MEMBERID","guess");
        }
        String url = LANDING;
        try {
            String controller = request.getParameter("controller");
            log("Controller: " + controller);
            if (controller.equals("Logging")){
                String action = request.getParameter("btnAction"); 
                if(action.equals("Login")) {
                    url = LOGIN;
                } else if(action.equals("Logout")) {
                    url = LOGOUT;
                } else if(action.equals("Register")) {
                    url = REGISTER;
                } else if(action.equals("View cart")) {
                    url = VIEW_CART_CONTROLLER;
                } else if(action.equals("View account")) {
                    url = VIEW_ACCOUNT_CONTROLLER;
                }
            } else if(controller.equals("ViewShopController")) {
                url = VIEW_SHOP_CONTROLLER;
            } else if(controller.equals("ViewProductController")) {
                url = VIEW_PRODUCT_CONTROLLER;
            } else if(controller.equals("AddAccountController")) {
                url = ADD_ACCOUNT_CONTROLLER;
            } else if(controller.equals("UpdateAccountController")) {
                url = UPDATE_ACCOUNT_CONTROLLER;
            } else if(controller.equals("AddCartController")) {
                url = ADD_CART_CONTROLLER;
            } else if(controller.equals("UpdateCartController")) {
                url = UPDATE_CART_CONTROLLER;
            } else if(controller.equals("ViewCheckOutController")) {
                url = VIEW_CHECK_OUT_CONTROLLER;
            } else if(controller.equals("ConfirmCheckOutController")) {
                url = CONFIRM_CHECK_OUT_CONTROLLER;
            } else if (controller.equals("AddCommentController")) {
                url = ADD_COMMENT_CONTROLLER;
            } else if (controller.equals("DeleteCommentController")) {
                url = DELETE_COMMENT_CONTROLLER;
            } else if(controller.equals("CancelOrderController")) {
                url = CANCEL_ORDER_CONTROLLER;
            }
        } catch(Exception e) {
          log("ERROR at MainController: " + e.getMessage());
        }  finally {
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
