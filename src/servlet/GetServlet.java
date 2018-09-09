package servlet;

import bean.Student;
import dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GetServlet")
public class GetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Student student  = new Student();

        String name = request.getParameter("name");
        int studentNumber = Integer.parseInt(request.getParameter("student"));
        if( name != null && String.valueOf(studentNumber) == null ){
            student = new StudentDao().get(name);
        }else /*if(name == null && String.valueOf(studentNumber) != null )*/{
            student = new StudentDao().get(studentNumber);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
