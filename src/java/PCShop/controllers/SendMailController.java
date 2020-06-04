/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PCShop.controllers;

import PCShop.cart.CartObj;
import PCShop.product.ProductObj;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
@WebServlet(name = "SendMailController", urlPatterns = {"/SendMailController"})
public class SendMailController extends HttpServlet {
        public static void send(String from,String password,String to,String sub, CartObj cart, String orderID, String orderCustomerName, String orderCustomerPhone, String orderCustomerAddress, String orderCustomerNote){  
          Map<String,ProductObj> products = cart.getProducts();
          //Get properties object    
          Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
          });  
          String docType = null;
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(sub);    
           String content = "<style type=\"text/css\">\n" +
                            "        body,\n" +
                            "        table,\n" +
                            "        td,\n" +
                            "        a {\n" +
                            "            -webkit-text-size-adjust: 100%;\n" +
                            "            -ms-text-size-adjust: 100%;\n" +
                            "        }\n" +
                            "\n" +
                            "        table,\n" +
                            "        td {\n" +
                            "            mso-table-lspace: 0pt;\n" +
                            "            mso-table-rspace: 0pt;\n" +
                            "        }\n" +
                            "\n" +
                            "        img {\n" +
                            "            -ms-interpolation-mode: bicubic;\n" +
                            "        }\n" +
                            "\n" +
                            "        img {\n" +
                            "            border: 0;\n" +
                            "            height: auto;\n" +
                            "            line-height: 100%;\n" +
                            "            outline: none;\n" +
                            "            text-decoration: none;\n" +
                            "        }\n" +
                            "\n" +
                            "        table {\n" +
                            "            border-collapse: collapse !important;\n" +
                            "        }\n" +
                            "\n" +
                            "        body {\n" +
                            "            height: 100% !important;\n" +
                            "            margin: 0 !important;\n" +
                            "            padding: 0 !important;\n" +
                            "            width: 100% !important;\n" +
                            "        }\n" +
                            "\n" +
                            "        a[x-apple-data-detectors] {\n" +
                            "            color: inherit !important;\n" +
                            "            text-decoration: none !important;\n" +
                            "            font-size: inherit !important;\n" +
                            "            font-family: inherit !important;\n" +
                            "            font-weight: inherit !important;\n" +
                            "            line-height: inherit !important;\n" +
                            "        }\n" +
                            "\n" +
                            "        @media screen and (max-width: 480px) {\n" +
                            "            .mobile-hide {\n" +
                            "                display: none !important;\n" +
                            "            }\n" +
                            "\n" +
                            "            .mobile-center {\n" +
                            "                text-align: center !important;\n" +
                            "            }\n" +
                            "        }\n" +
                            "\n" +
                            "        div[style*=\"margin: 16px 0;\"] {\n" +
                            "            margin: 0 !important;\n" +
                            "        }\n" +
                            "    </style>\n" +
                            "\n" +
                            "<body style=\"margin: 0 !important; padding: 0 !important; background-color: #eeeeee;\" bgcolor=\"#eeeeee\">\n" +
                            "    <div style=\"display: none; font-size: 1px; color: #fefefe; line-height: 1px; font-family: Open Sans, Helvetica, Arial, sans-serif; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden;\">\n" +
                            "        For what reason would it be advisable for me to think about business content? That might be little bit risky to have crew member like them.\n" +
                            "    </div>\n" +
                            "    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                            "        <tr>\n" +
                            "            <td align=\"center\" style=\"background-color: #eeeeee;\" bgcolor=\"#eeeeee\">\n" +
                            "                <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:600px;\">\n" +
                            "                    <tr>\n" +
                            "                        <td align=\"center\" valign=\"top\" style=\"font-size:0; padding: 35px;\" bgcolor=\"#F44336\">\n" +
                            "                            <div style=\"display:inline-block; max-width:50%; min-width:100px; vertical-align:top; width:100%;\">\n" +
                            "                                <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:300px;\">\n" +
                            "                                    <tr>\n" +
                            "                                        <td align=\"left\" valign=\"top\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 36px; font-weight: 800; line-height: 48px;\" class=\"mobile-center\">\n" +
                            "                                            <h1 style=\"font-size: 36px; font-weight: 800; margin: 0; color: #ffffff;\">PCShop</h1>\n" +
                            "                                        </td>\n" +
                            "                                    </tr>\n" +
                            "                                </table>\n" +
                            "                            </div>\n" +
                            "                            <div style=\"display:inline-block; max-width:50%; min-width:100px; vertical-align:top; width:100%;\" class=\"mobile-hide\">\n" +
                            "                                <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:300px;\">\n" +
                            "                                    <tr>\n" +
                            "                                        <td align=\"right\" valign=\"top\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 48px; font-weight: 400; line-height: 48px;\">\n" +
                            "                                            <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"right\">\n" +
                            "                                                <tr>\n" +
                            "                                                    <td style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400;\">\n" +
                            "                                                        <p style=\"font-size: 18px; font-weight: 400; margin: 0; color: #ffffff;\"><a href=\"#\" target=\"_blank\" style=\"color: #ffffff; text-decoration: none;\">Shop &nbsp;</a></p>\n" +
                            "                                                    </td>\n" +
                            "                                                    <td style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 24px;\"> <a href=\"#\" target=\"_blank\" style=\"color: #ffffff; text-decoration: none;\"><img src=\"https://img.icons8.com/color/48/000000/small-business.png\" width=\"27\" height=\"23\" style=\"display: block; border: 0px;\" /></a> </td>\n" +
                            "                                                </tr>\n" +
                            "                                            </table>\n" +
                            "                                        </td>\n" +
                            "                                    </tr>\n" +
                            "                                </table>\n" +
                            "                            </div>\n" +
                            "                        </td>\n" +
                            "                    </tr>\n" +
                            "                    <tr>\n" +
                            "                        <td align=\"center\" style=\"padding: 35px 35px 20px 35px; background-color: #ffffff;\" bgcolor=\"#ffffff\">\n" +
                            "                            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:600px;\">\n" +
                            "                                <tr>\n" +
                            "                                    <td align=\"center\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding-top: 25px;\"> <img src=\"https://img.icons8.com/carbon-copy/100/000000/checked-checkbox.png\" width=\"125\" height=\"120\" style=\"display: block; border: 0px;\" /><br>\n" +
                            "                                        <h2 style=\"font-size: 30px; font-weight: 800; line-height: 36px; color: #333333; margin: 0;\"> Thank You For Your Order! </h2>\n" +
                            "                                    </td>\n" +
                            "                                </tr>\n" +
                            "                                <tr>\n" +
                            "                                    <td align=\"left\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding-top: 10px;\">\n" +
                            "                                        <p style=\"font-size: 16px; font-weight: 400; line-height: 24px; color: #777777;\"> Lorem ipsum dolor sit amet, consectetur adipisicing elit. Praesentium iste ipsa numquam odio dolores, nam. </p>\n" +
                            "                                    </td>\n" +
                            "                                </tr>\n" +
                            "                                <tr>\n" +
                            "                                    <td align=\"left\" style=\"padding-top: 20px;\">\n" +
                            "                                        <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\n" +
                            "                                            <tr>\n" +
                            "                                                <td width=\"75%\" align=\"left\" bgcolor=\"#eeeeee\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\"> Order Confirmation # </td>\n" +
                            "                                                <td width=\"25%\" align=\"left\" bgcolor=\"#eeeeee\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\"> "+ orderID +"</td>\n" +
                            "                                            </tr>\n" +
                            "                                            <tr>\n" +
                            "                                                <td width=\"75%\" align=\"left\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding: 15px 10px 5px 10px;\"> Purchased Item (" + cart.getLength() + ") </td>\n" +
                            "                                                <td width=\"25%\" align=\"left\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding: 15px 10px 5px 10px;\">" + cart.getTotal() +" </td>\n" +
                            "                                            </tr>\n" +
                            "                                            <tr>\n" +
                            "                                                <td width=\"75%\" align=\"left\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding: 5px 10px;\"> Shipping + Handling </td>\n" +
                            "                                                <td width=\"25%\" align=\"left\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding: 5px 10px;\"> VND 30.000 </td>\n" +
                            "                                            </tr>\n" +
                            "                                            <tr>\n" +
                            "                                                <td width=\"75%\" align=\"left\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding: 5px 10px;\"> Sales Tax </td>\n" +
                            "                                                <td width=\"25%\" align=\"left\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding: 5px 10px;\"> VND FREE </td>\n" +
                            "                                            </tr>\n" +
                            "                                        </table>\n" +
                            "                                    </td>\n" +
                            "                                </tr>\n" +
                            "                                <tr>\n" +
                            "                                    <td align=\"left\" style=\"padding-top: 20px;\">\n" +
                            "                                        <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\n" +
                            "                                            <tr>\n" +
                            "                                                <td width=\"75%\" align=\"left\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px; border-top: 3px solid #eeeeee; border-bottom: 3px solid #eeeeee;\"> TOTAL </td>\n" +
                            "                                                <td width=\"25%\" align=\"left\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px; border-top: 3px solid #eeeeee; border-bottom: 3px solid #eeeeee;\"> " + (cart.getTotal() + 30000) +" </td>\n" +
                            "                                            </tr>\n" +
                            "                                        </table>\n" +
                            "                                    </td>\n" +
                            "                                </tr>\n" +
                            "                            </table>\n" +
                            "                        </td>\n" +
                            "                    </tr>\n" +
                            "                    <tr>\n" +
                            "                        <td align=\"center\" height=\"100%\" valign=\"top\" width=\"100%\" style=\"padding: 0 35px 35px 35px; background-color: #ffffff;\" bgcolor=\"#ffffff\">\n" +
                            "                            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:660px;\">\n" +
                            "                                <tr>\n" +
                            "                                    <td align=\"center\" valign=\"top\" style=\"font-size:0;\">\n" +
                            "                                        <div style=\"display:inline-block; max-width:50%; min-width:240px; vertical-align:top; width:100%;\">\n" +
                            "                                            <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:300px;\">\n" +
                            "                                                <tr>\n" +
                            "                                                    <td align=\"left\" valign=\"top\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px;\">\n" +
                            "                                                        <p style=\"font-weight: 800;\">Delivery Infomation: </p>\n" +
                            "                                                        <p>" + orderCustomerName + "<br>" + orderCustomerPhone +"<br>" + orderCustomerAddress +"</p>\n" +
                            "                                                    </td>\n" +
                            "                                                </tr>\n" +
                            "                                            </table>\n" +
                            "                                        </div>\n" +
                            "                                        <div style=\"display:inline-block; max-width:50%; min-width:240px; vertical-align:top; width:100%;\">\n" +
                            "                                            <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:300px;\">\n" +
                            "                                                <tr>\n" +
                            "                                                    <td align=\"left\" valign=\"top\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px;\">\n" +
                            "                                                        <p style=\"font-weight: 800;\">Note: </p>\n" +
                            "                                                        <p>"+ orderCustomerNote +"</p>\n" +
                            "                                                    </td>\n" +
                            "                                                </tr>\n" +
                            "                                            </table>\n" +
                            "                                        </div>\n" +
                            "                                    </td>\n" +
                            "                                </tr>\n" +
                            "                            </table>\n" +
                            "                        </td>\n" +
                            "                    </tr>\n" +
                            "                    <tr>\n" +
                            "                        <td align=\"center\" style=\" padding: 35px; background-color: #ff7361;\" bgcolor=\"#1b9ba3\">\n" +
                            "                            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:600px;\">\n" +
                            "                                <tr>\n" +
                            "                                    <td align=\"center\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding-top: 25px;\">\n" +
                            "                                        <h2 style=\"font-size: 24px; font-weight: 800; line-height: 30px; color: #ffffff; margin: 0;\"> Get 30% off your next order. </h2>\n" +
                            "                                    </td>\n" +
                            "                                </tr>\n" +
                            "                                <tr>\n" +
                            "                                    <td align=\"center\" style=\"padding: 25px 0 15px 0;\">\n" +
                            "                                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                            "                                            <tr>\n" +
                            "                                                <td align=\"center\" style=\"border-radius: 5px;\" bgcolor=\"#66b3b7\"> <a href=\"http://localhost:8080/PCShop/\" target=\"_blank\" style=\"font-size: 18px; font-family: Open Sans, Helvetica, Arial, sans-serif; color: #ffffff; text-decoration: none; border-radius: 5px; background-color: #F44336; padding: 15px 30px; border: 1px solid #F44336; display: block;\">Shop Again</a> </td>\n" +
                            "                                            </tr>\n" +
                            "                                        </table>\n" +
                            "                                    </td>\n" +
                            "                                </tr>\n" +
                            "                            </table>\n" +
                            "                        </td>\n" +
                            "                    </tr>\n" +
                            "                    <tr>\n" +
                            "                        <td align=\"center\" style=\"padding: 35px; background-color: #ffffff;\" bgcolor=\"#ffffff\">\n" +
                            "                            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:600px;\">\n" +
                            "                                <tr>\n" +
                            "                                    <td align=\"left\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 14px; font-weight: 400; line-height: 24px;\">\n" +
                            "                                        <p style=\"font-size: 14px; font-weight: 400; line-height: 20px; color: #777777;\"> If you didn't create an account using this email address, please ignore this email or <a href=\"#\" target=\"_blank\" style=\"color: #777777;\">unsusbscribe</a>. </p>\n" +
                            "                                    </td>\n" +
                            "                                </tr>\n" +
                            "                            </table>\n" +
                            "                        </td>\n" +
                            "                    </tr>\n" +
                            "                </table>\n" +
                            "            </td>\n" +
                            "        </tr>\n" +
                            "    </table>\n" +
                            "</body>";
            message.setContent(content, "text/html; charset=UTF-8");
           //send message  
           Transport.send(message);    
           System.out.println("message sent successfully");    
          } catch (MessagingException e) {throw new RuntimeException(e);}    
             
    } 

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
        HttpSession session = request.getSession();
        CartObj cart = (CartObj) session.getAttribute("CART");
        String orderID = request.getAttribute("ORDERID").toString();
        String orderCustomerName = request.getAttribute("ORDERCUSTOMERNAME").toString();
        String orderCustomerPhone = request.getAttribute("ORDERCUSTOMERPHONE").toString();
        String orderCustomerAddress = request.getAttribute("ORDERCUSTOMERADDRESS").toString();
        String orderCustomerNote = request.getAttribute("ORDERCUSTOMERNOTE").toString();
        String toMail = request.getAttribute("TOMAIL").toString();
        try {
            send("quanhui812@gmail.com","thitkhotau",toMail, "Thank you for your order!", cart, orderID, orderCustomerName, orderCustomerPhone, orderCustomerAddress, orderCustomerNote);
        } catch(Exception e) {
            log(" Error at send mail: " + e.getMessage());
        } finally {
            request.getRequestDispatcher("ViewSuccessOrderController").forward(request,response);
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
