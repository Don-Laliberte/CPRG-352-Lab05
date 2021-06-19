/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Models.User;
import Services.AccountService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author toesl
 */
public class LoginServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        //String variable obtained from querystring within welcomepage.jsp that is created upon clicking the Logout anchor tag
        String logout = request.getParameter("param");
        
        //If the user reached this page by clicking logout
        if (logout != null) {
            session.invalidate(); //destroys session
            request.setAttribute("outputmessage", true); //display message trigger
            request.setAttribute("message", "You have successfully logged out."); //lets the user know they have logge dout
            try {
                getServletContext().getRequestDispatcher("/WEB-INF/loginpage.jsp").forward(request, response);//sends them to the logout page
            }
            catch (IOException ex) { //Catches when the file cannot be located
                System.out.println("404 File Not Found");
                ex.printStackTrace();
            }
            catch (ServletException ex) {
                ex.printStackTrace();
            }        
        }        
        else if (session.getAttribute("username") != null) { //if the username session value does exist
            response.sendRedirect("home"); //redirect them to the home/welcome page
        }
        else { //otherwise
            try {
                getServletContext().getRequestDispatcher("/WEB-INF/loginpage.jsp").forward(request, response); //send them to the login page like normal               
            }
            catch (IOException ex) { //Catches when the file cannot be located
                System.out.println("404 File Not Found");
                ex.printStackTrace();
            }
            catch (ServletException ex) {
                ex.printStackTrace();
            }
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
        
        // get the current session
        HttpSession session = request.getSession();
        
        String username = request.getParameter("usernameInput"); //grabs the username input
        String password = request.getParameter("passwordInput"); //grabs the password input
        

        request.setAttribute("usernameValue", username); //sets username and password attributes
        request.setAttribute("passwordValue", password);
        if ((!username.equals("") || !password.equals(""))) { //checks for non empty inputs
            AccountService accService = new AccountService(); //creates AccountService object for password checking
            User authCheck = accService.login(username,password); //checks if the username and password pass authentication
            if (authCheck == null) { //if the check failed
                request.setAttribute("outputmessage", true); //triggers user message
                request.setAttribute("message", "Invalid Login"); //user message
                try {
                    getServletContext().getRequestDispatcher("/WEB-INF/loginpage.jsp").forward(request, response);//re-forwards the login page
                }
                catch (IOException ex) { //Catches when the file cannot be located
                    System.out.println("404 File Not Found");
                    ex.printStackTrace();
                }
                catch (ServletException ex) {
                ex.printStackTrace();
                }
            }
            else { //Otherwise upon passing
                session.setAttribute("username", username); //sets the session attribute
                request.setAttribute("outputmessage", false); //disables the user message trigger
                response.sendRedirect("home"); //redirects you to home/welcome page
            }
        }
        else { //upon empty inputs
            request.setAttribute("outputmessage", true); //triggers user message
            request.setAttribute("message", "Please fill both your Username and Password"); //tells the user to enter proper inputs
            try {
                getServletContext().getRequestDispatcher("/WEB-INF/loginpage.jsp").forward(request, response); //re-forwards the login page
            }
            catch (IOException ex) { //Catches when the file cannot be located
                System.out.println("404 File Not Found");
                ex.printStackTrace();
            }
            catch (ServletException ex) {
                ex.printStackTrace();
            }    
        }

    }

}
