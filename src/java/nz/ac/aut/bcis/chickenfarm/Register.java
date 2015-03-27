/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.bcis.chickenfarm;

import java.io.IOException;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nz.ac.aut.bcis.chickenfarm.databases.DataBase;

/**
 *
 * @author Taylor
 */
@WebServlet(urlPatterns = {"/register"})
public class Register extends HttpServlet {

     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        if(email.length() == 0 || password.length() == 0)
        {
            InfoMessage error = new InfoMessage();
            error.setMessageType("ERROR");
            error.setMessage("User information cannot be empty");
            request.setAttribute("error", error);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            
            return;
        }
        // connecting to the database
        try {
            DataBase db = new DataBase();
            
            String query = "SELECT * FROM USERS WHERE EMAIL='"+email+"' AND PASSWORD='"+ password+"'";
            ResultSet rs = db.query(query);
            
            if(rs.next()){
                //User already exists
                InfoMessage error = new InfoMessage();
                error.setMessageType("ERROR");
                error.setMessage("User already exists");
                request.setAttribute("error", error);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
            else{
                String addUser = "INSERT INTO USERS (EMAIL, PASSWORD) VALUES ('" +email + "','" + password + "')";
                db.execute(addUser);
                
                InfoMessage error = new InfoMessage();
                error.setMessageType("INFO");
                error.setMessage("User created, login");
                request.setAttribute("error", error);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
           
            
        } catch (Exception ex) {
            
            InfoMessage error = new InfoMessage();
            error.setMessageType("ERROR");
            error.setMessage("Could not connect to DataBase");
            request.setAttribute("error", error);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
     }
}