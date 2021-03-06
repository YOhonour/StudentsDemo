package servlet;

import bean.Student;
import dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Student student = new Student();

        String name = request.getParameter("name");
        int sex = Integer.parseInt(request.getParameter("sex"));
        int age = Integer.parseInt(request.getParameter("age"));
        int studentNumber = Integer.parseInt(request.getParameter("studentNumber"));
        int major = Integer.parseInt(request.getParameter("major"));

        student.setMajor(major);
        student.setStudentNumber(studentNumber);
        student.setAge(age);
        student.setName(name);
        student.setSex(sex);

        new StudentDao().add(student);

        response.sendRedirect("/listStudent");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
