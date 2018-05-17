package cn.edu.hitwh.gmember.servlet;

import cn.edu.hitwh.gmember.pojo.Student;
import cn.edu.hitwh.gmember.service.IStudentService;
import cn.edu.hitwh.gmember.serviceImp.StudentServiceImp;
import cn.edu.hitwh.gmember.tools.PageBean;
import cn.itcast.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentServlet")
public class StudentServlet extends BaseServlet {
    private IStudentService studentService = new StudentServiceImp();

    public String studentLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stunum = request.getParameter("stunum");
        String stupwd = request.getParameter("stupwd");
        System.out.println("===" + stunum + "=====" + stupwd);
        Student student = new Student();
        student.setStu_num(stunum);
        student.setStu_pwd(stupwd);
        Student studentSql = studentService.login(student);
        if (studentSql == null) {
            request.setAttribute("msgStudentLogin", "账号或密码错误！请重新输入！");
//            response.sendRedirect(request.getContextPath()+"/studentLogin.jsp");
            return "f:/studentLogin.jsp";
        } else {
            request.setAttribute("msgStudentLogin", "");
            request.getSession().setAttribute("Student", studentSql);
//            response.sendRedirect(request.getContextPath()+"/encryptWeb/student/index.jsp");
            return "r:/encryptWeb/student/index.jsp";
        }
    }


    public String findAllStudents(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return null;
    }


    //    public PageBean<Student> findStudentsByLevel(int stu_level_id);
    public String findStudentsByLevel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        return null;
    }

    public String deleteStuent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        return null;
    }

    public String addStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return null;
    }

    public String updateStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        return null;
    }

}
