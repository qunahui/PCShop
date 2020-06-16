/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PCShop.JWT;

import PCShop.daos.RegistrationDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
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
@WebServlet(name = "SendRequestController", urlPatterns = {"/SendRequestController"})
public class SendRequestController extends HttpServlet {
    public static void send(String from,String password,String to,String sub,String accessToken){  
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
           return new PasswordAuthentication("quanhui812@gmail.com","thitkhotau");  
           }    
          });  
          String docType = null;
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(sub);    
           String content = "Your link for mail change: http://localhost:8080/PCShop/ViewNewPasswordController?sign=" + accessToken;
            message.setContent(content, "text/html; charset=UTF-8");
           //send message  
           Transport.send(message);    
           System.out.println("message sent successfully");    
          } catch (MessagingException e) {throw new RuntimeException(e);}    
             
    } 
    
    public static String basicPost(String username) throws ClientProtocolException, IOException {
        String result = "failed";
        try {
            URI uri = new URIBuilder()
            .setScheme("http")
            .setHost("localhost:8082")
            .setPath("/login")
            .setParameter("username", username)
            .build();
        HttpClient client = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(uri);
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpURLConnection connection = null;
        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("txtUsername");
            String mail = request.getParameter("txtMail");
            RegistrationDAO regDAO = new RegistrationDAO();
            boolean confirm = regDAO.confirmMail(username, mail);
            if(confirm == true) {
                String res = basicPost(username);
                Object resObj = JSONValue.parse(res);
                JSONObject jsonResObject = (JSONObject)resObj; 
                log("accessToken: " + jsonResObject.get("accessToken"));
                send("quanhui812@gmail.com","thitkhotau",mail,"Account recovery",jsonResObject.get("accessToken").toString());
            }
            request.getRequestDispatcher("landingPage.jsp").forward(request, response);
        } catch(Exception e) {
            log("Error: " + e);
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
