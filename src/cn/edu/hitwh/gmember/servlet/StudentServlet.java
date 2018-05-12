package cn.edu.hitwh.gmember.servlet;

import cn.edu.hitwh.gmember.pojo.Student;
import cn.edu.hitwh.gmember.service.IStudentService;
import cn.edu.hitwh.gmember.serviceImp.StudentServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentServlet")
public class StudentServlet extends HttpServlet {
    private IStudentService studentService=new StudentServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("request.getRequestURI()="+request.getRequestURI());
        System.out.println("request.getRequestURL()="+request.getRequestURI());
        System.out.println("request.getMethod()="+request.getMethod());
        System.out.println("request.getSession()="+request.getSession());
        System.out.println("request.getContextPath()="+request.getContextPath());
        System.out.println("request.getContextPath()="+request.getParameterNames());
        String stuid=request.getParameter("stuid");
        String stupwd=request.getParameter("stupwd");
        System.out.println("==="+stuid+"====="+stupwd);
        Student student=new Student();
        student.setStu_id(stuid);
        student.setStu_pwd(stupwd);
        Student studentSql=studentService.login(student);
        if (studentSql==null){
            request.getSession().setAttribute("msgStudentLogin","账号或密码错误！请重新输入！");
            response.sendRedirect(request.getContextPath()+"/studentLogin.jsp");
        }else{
            request.getSession().setAttribute("msgStudentLogin","");
            request.getSession().setAttribute("Student",studentSql);
            response.sendRedirect(request.getContextPath()+"/encryptWeb/student/index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
