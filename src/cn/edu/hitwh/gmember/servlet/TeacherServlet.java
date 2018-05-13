package cn.edu.hitwh.gmember.servlet;

import cn.edu.hitwh.gmember.pojo.Teacher;
import cn.edu.hitwh.gmember.service.ITeacherService;
import cn.edu.hitwh.gmember.serviceImp.TeacherServiceImp;
import cn.itcast.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TeacherServlet extends BaseServlet {
    private ITeacherService teacherService=new TeacherServiceImp();

    public String teacherLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
//            resp.sendRedirect(req.getContextPath()+"/encryptWeb/teacher");
            return "r:/encryptWeb/teacher";
        }else{
            req.getSession().setAttribute("msgTeacherLogin","账号或密码错误！请重新输入！");
//            resp.sendRedirect(req.getContextPath()+"/teacherLogin.jsp");
            return "/teacherLogin.jsp";
        }
    }
}
