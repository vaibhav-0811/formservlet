
package com.practice;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;


public class RegistorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
       // super.doPost(req, resp); 
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h2> welcome to RegistorServlet </h2>");
        String name = req.getParameter("USER NAME");
        String password = req.getParameter("USER_PASSWORD");
        String email = req.getParameter("USER_EMAIL");
        String gender = req.getParameter("USER_GENDER");
        String course = req.getParameter("USER_COURSE");
        
        String condition =req.getParameter("CONDITION");
        if(condition!=null){
        if(condition.equals("checked")){
            out.println("<h2> NAME :"+name+"</h2>");
            out.println("<h2> PASSWORD :"+password+"</h2>");
            out.println("<h2>  EMAIL :"+email+"</h2>");
            out.println("<h2> GENDER  :"+gender+"</h2>");
            out.println("<h2> COURSE :"+course+"</h2>");       // WE CAN ALSE SAVE THE DATA IN JDBC 
            
            // we are assuming that we saved the data in db
           RequestDispatcher rd = req.getRequestDispatcher("success");
           rd.forward(req, resp);
            
        }
        else{
            out.println("<h2>you didn't checked the condition </h2>");
        }
        }
        else{
        out.println("<h2> you didn't checked the term and condition </h2>");
        // request dispatcher 
        //include  index.html file here 
        RequestDispatcher rd = req.getRequestDispatcher("index.html");
        
        // calling include method 
        rd.include(req, resp);
        }
    }
    
}
