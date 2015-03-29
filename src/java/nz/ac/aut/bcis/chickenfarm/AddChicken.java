/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.bcis.chickenfarm;

import java.io.IOException;
import java.io.PrintWriter;
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
 * @author Taylor
 */
@WebServlet(urlPatterns = {"/addChicken"})
public class AddChicken extends HttpServlet {

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserData ud = (UserData) request.getSession().getAttribute("userdata");
        String type = "CHICKEN";
        String xLoc = request.getParameter("xLoc");
        String yLoc = request.getParameter("yLoc");
        String loc = xLoc + ":" + yLoc;
        
        // connecting to the database
        try {
            //add item to DB
            DataBase db = new DataBase();
            
            String addItem = "INSERT INTO ITEMS (ID, ITEM_TYPE, LOCATION) VALUES (" +ud.getId() + ",'" + type + "','" + loc + "')";
            
            db.execute(addItem);
            
            ItemData id = new ItemData();
            
            id.setOwnerID(ud.getId());
            id.setItemType(type);
            id.setxLoc(Integer.parseInt(xLoc));
            id.setyLoc(Integer.parseInt(yLoc));
            
            ud.addItem(id);
            
            //return to index
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            
        } catch (Exception ex) {
            
            InfoMessage error = new InfoMessage();
            error.setMessageType("ERROR");
            error.setMessage("Could not connect to DataBase");
            request.setAttribute("error", error);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
   }
}
