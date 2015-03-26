package nz.ac.aut.bcis.chickenfarm;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nz.ac.aut.bcis.chickenfarm.databases.DataBase;

/**
 *
 * @author guy
 */
@WebServlet(urlPatterns = {"/authlogin"})
public class AuthLogin extends HttpServlet {
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        // connecting to the database
        try {
            DataBase db = new DataBase();
            
            String query = "SELECT * FROM USERS WHERE EMAIL='"+email+"' AND PASSWORD='"+ password+"'";
            ResultSet rs = db.query(query);
            
            if(rs.next()){
                 UserData ud= new UserData();
                 ud.setEmail(rs.getString(1));
                 ud.setId(rs.getInt(0));
                 HttpSession session = request.getSession(true);
                 session.setAttribute("userdata",ud);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
            else{
                InfoMessage error = new InfoMessage();
                error.setMessageType("ERROR");
                error.setMessage("User Details not found");
                request.setAttribute("error", error);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
           
            
        } catch (Exception ex) {
            
            InfoMessage error = new InfoMessage();
            error.setMessageType("ERROR");
            error.setMessage("Could not connect to DataBase");
            //request.setAttribute("error", error);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
   
            
       
    }
   
   

  

}
