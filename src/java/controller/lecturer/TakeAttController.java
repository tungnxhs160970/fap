/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.lecturer;

import dal.AttandanceDBContext;
import dal.SessionDBContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Account;
import model.Attandance;
import model.Session;
import model.Student;


/**
 *
 * @author tung
 */
public class TakeAttController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int sesid = Integer.parseInt(request.getParameter("id"));
        AttandanceDBContext attDB = new AttandanceDBContext();
        ArrayList<Attandance> atts = attDB.getAttsBySessionId(sesid);
        request.setAttribute("atts", atts);
        
        SessionDBContext sesDB = new SessionDBContext();
        Session ses = sesDB.get(sesid);
        request.setAttribute("ses", ses);
        

        request.getRequestDispatcher("../view/lecturer/takeatt.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Session ses = new Session();
        ses.setId(Integer.parseInt(request.getParameter("sesid")));
        
        String[] stdids = request.getParameterValues("stdid");
        for (String stdid : stdids) {
            Attandance a = new Attandance();
            Student s = new Student();
            a.setStudent(s);
            a.setSession(ses);
            s.setId(Integer.parseInt(stdid));
            a.setPresent(request.getParameter("present"+stdid).equals("present"));
            a.setDescription(request.getParameter("description"+stdid));
            ses.getAtts().add(a);
        }
        
        SessionDBContext db = new SessionDBContext();
        db.updateAttandance(ses);
        response.sendRedirect("takeatt?id="+ses.getId());
        
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
