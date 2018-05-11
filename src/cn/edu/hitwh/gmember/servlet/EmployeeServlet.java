package cn.edu.hitwh.gmember.servlet;

import cn.edu.hitwh.gmember.pojo.Admin;
import cn.edu.hitwh.gmember.service.IAdminService;
import cn.edu.hitwh.gmember.serviceImp.AdminServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EmployeeServlet extends HttpServlet {
    private IAdminService IAdminService =new AdminServiceImp();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adminid=req.getParameter("adminid");
        String adminpwd=req.getParameter("adminpwd");
        System.out.println("+++++++++++++++++++"+adminid);
        System.out.println("+++++++++++++++++++"+adminpwd);
        HttpSession session=req.getSession();
        Admin admin=new Admin();
        admin.setAdmin_id(adminid);
        admin.setAdmin_password(adminpwd);
        Admin adminLogin= IAdminService.login(admin);
        if (adminLogin!=null){
            resp.sendRedirect(req.getContextPath()+"/encryptWeb/admin");

        }else{
            req.setAttribute("msg","账号或密码错误！");
            resp.sendRedirect(req.getContextPath()+"/adminLogin.jsp");
        }
    }
}
