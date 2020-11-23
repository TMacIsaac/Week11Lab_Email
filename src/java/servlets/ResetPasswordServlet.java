/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.AccountService;

/**
 *
 * @author 838771
 */
@WebServlet(name = "ResetPasswordServlet", urlPatterns = {"/ResetPasswordServlet"})
public class ResetPasswordServlet extends HttpServlet {

   

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("uuid") == null){
            getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);
        }
        else{
            String uuid = request.getParameter("uuid");
            request.setAttribute("uuid", uuid);
            getServletContext().getRequestDispatcher("/WEB-INF/resetNewPassword.jsp").forward(request, response);
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountService as = new AccountService();
        if(request.getParameter("uuid") == null){
            String email = (String)request.getParameter("email");
            String url = request.getRequestURL().toString();
            String path = getServletContext().getRealPath("/WEB-INF");
            as.resetPassword(email, path, url);
            request.setAttribute("email", email);
            request.setAttribute("resetMessage", "Email sent to the address provided. Please follow the link in the email to continue.");
            getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);
        }
        else{
            try {
                String uuid = request.getParameter("uuid");
                String password = request.getParameter("newPassword");
                as.changePassword(uuid, password);
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(ResetPasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
