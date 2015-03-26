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

    private static final String DB_USER = "users";
  
    private static final String DB_TABLE_NAME = "USERS";
    private static final String CREATE_USER_TABLE = "CREATE TABLE Users (id INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), email VARCHAR(40) UNIQUE, password VARCHAR(40))";
    private static final String ALTER_TABLE = "ALTER TABLE ITEMS add foreign key(id) references USERS";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        // connecting to the database
        try {
            DataBase db = new DataBase(DB_USER, true);
            if(!db.tableExists(DB_TABLE_NAME)){
                db.execute(CREATE_USER_TABLE);
                
            }
            String query = "select * from " +DB_TABLE_NAME+" where email ='"+email+"' and where password = '"+ password+"';";
             ResultSet rs = db.query(query);
             ResultSetMetaData metaData = rs.getMetaData();
             int columns = metaData.getColumnCount();
             UserData ud= null;
            if(rs.next()){
                 ud= new UserData();
                 ud.setEmail(rs.getString(1));
                 ud.setId(rs.getInt(0));
                 HttpSession session = request.getSession(true);
                 session.setAttribute("userdata",ud);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            }else{
            
            request.setAttribute("Error", "Unknown user, please try again");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
           
            
        } catch (Exception ex) {
            
            request.setAttribute("Error", "Could not connet to DataBase");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
   
            
       
    }
   
   

  

}
