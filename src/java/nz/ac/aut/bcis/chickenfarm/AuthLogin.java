package nz.ac.aut.bcis.chickenfarm;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.sql.ResultSet;
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
                 ud.setEmail(rs.getString(2));
                 ud.setId(rs.getInt(1));
                 HttpSession session = request.getSession(true);
                 session.setAttribute("userdata",ud);
                 
                String items = "SELECT * FROM ITEMS WHERE ID=" + ud.getId();
                ResultSet itemResults = db.query(items);

                while(itemResults.next())
                {
                    ItemData i = new ItemData();
                    i.setOwnerID(itemResults.getInt(1));
                    i.setItemType(itemResults.getString(2));
                    String[] loc = itemResults.getString(3).split(":");
                    i.setxLoc(Integer.parseInt(loc[0]));
                    i.setyLoc(Integer.parseInt(loc[1]));
                    
                    ud.addItem(i);
                }
                
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
            request.setAttribute("error", error);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
   
            
       
    }
   
   

  

}
