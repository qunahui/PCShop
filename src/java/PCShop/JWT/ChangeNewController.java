/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PCShop.JWT;

import PCShop.daos.RegistrationDAO;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author Hui
 */
@WebServlet(name = "ChangeNewController", urlPatterns = {"/ChangeNewController"})
public class ChangeNewController extends HttpServlet {
    private String hashPassword(String pass) {
        String passwordToHash = pass;
        String generatedPassword = null;
        try {
                // Create MessageDigest instance for MD5
                MessageDigest md = MessageDigest.getInstance("MD5");
                //Add password bytes to digest
                md.update(passwordToHash.getBytes());
                //Get the hash's bytes 
                byte[] bytes = md.digest();
                //This bytes[] has bytes in decimal format;
                //Convert it to hexadecimal format
                StringBuilder sb = new StringBuilder();
                for(int i=0; i< bytes.length ;i++)
                {
                        sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                }
                //Get complete hashed password in hex format
                generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e){
                e.printStackTrace();
        } finally {
            return generatedPassword;
        }
    }
    
    public static String basicGet(String sign) throws ClientProtocolException, IOException {
        String result = "failed";
        try {
            URI uri = new URIBuilder()
            .setScheme("http")
            .setHost("localhost:8082")
            .setPath("/reset")
            .build();
        HttpClient client = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(uri);
        httpget.addHeader("Authorization","Bearer " + sign);
        HttpResponse response = client.execute(httpget);
        InputStream in = response.getEntity().getContent();
        result = IOUtils.toString(in, StandardCharsets.UTF_8);
            try {

            } finally {

            }
        } catch(Exception e) {
        } finally {
            return result;
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String sign = request.getParameter("sign");
            String newpass = request.getParameter("Password");
            String res = basicGet(sign);
            if(!res.equals("Forbidden")) {
                Object resObj = JSONValue.parse(res);
                JSONObject jsonResObject = (JSONObject)resObj; 
                RegistrationDAO regDAO = new RegistrationDAO();
                String username = jsonResObject.get("username").toString();
                boolean success = regDAO.changePassword(username, hashPassword(newpass));
                if(success) {
                    log("change pass succeed");
                }
            } else {
                request.setAttribute("ERROR","Your token has been expired");
                request.getRequestDispatcher("newpass.jsp").forward(request, response);
            }
            request.getRequestDispatcher("landingPage.jsp").forward(request, response);
        } catch(Exception e) {
            log("error : " + e.getMessage());
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ChangeNewController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(ChangeNewController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ChangeNewController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(ChangeNewController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
