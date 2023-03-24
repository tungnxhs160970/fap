/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.lecturer;

import dal.StudentDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Student;

/**
 *
 * @author tung
 */
public class StudentController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("stdid") != null) {
            int id = Integer.parseInt(req.getParameter("stdid"));
            StudentDBContext db = new StudentDBContext();
            Student student = (Student) db.get(id);
            req.setAttribute("student", student);
        }

        req.getRequestDispatcher("view/lecturer/student.jsp").forward(req, resp);
    }

}
