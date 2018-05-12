package cn.edu.hitwh.gmember.servlet;

import cn.edu.hitwh.gmember.pojo.Teacher;
import cn.edu.hitwh.gmember.service.ITeacherService;
import cn.edu.hitwh.gmember.serviceImp.TeacherServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TeacherServlet extends HttpServlet {
    private ITeacherService teacherService=new TeacherServiceImp();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String teaid=req.getParameter("teaid");
        String teapwd=req.getParameter("teapwd");
        System.out.println("+++++++++++++++++++"+teaid);
        System.out.println("+++++++++++++++++++"+teapwd);
        Teacher teacher=new Teacher();
        teacher.setTea_id(teaid);
        teacher.setTea_pwd(teapwd);
        Teacher teacherLogin=teacherService.login(teacher);

        if (teacherLogin!=null){
            req.getSession().setAttribute("msgTeacherLogin","");
            req.getSession().setAttribute("Teacher",teacherLogin);
            resp.sendRedirect(req.getContextPath()+"/encryptWeb/teacher");
        }else{
            req.getSession().setAttribute("msgTeacherLogin","账号或密码错误！请重新输入！");
            resp.sendRedirect(req.getContextPath()+"/teacherLogin.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
