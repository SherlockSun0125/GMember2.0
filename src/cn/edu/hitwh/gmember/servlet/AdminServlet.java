package cn.edu.hitwh.gmember.servlet;

import cn.edu.hitwh.gmember.pojo.Admin;
import cn.edu.hitwh.gmember.service.IAdminService;
import cn.edu.hitwh.gmember.serviceImp.AdminServiceImp;
import cn.itcast.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminServlet extends BaseServlet {
    private IAdminService IAdminService =new AdminServiceImp();

    public String adminLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("调用adminLogin方法！");
        String adminid = req.getParameter("adminid");
        String adminpwd = req.getParameter("adminpwd");
        Admin admin = new Admin();
        admin.setAdmin_id(adminid);
        admin.setAdmin_password(adminpwd);
        Admin adminSql = IAdminService.login(admin);
        if (adminSql != null) {
            req.getSession().setAttribute("msgAdminLogin", "");
//            resp.sendRedirect(req.getContextPath()+"/encryptWeb/admin");
            req.getSession().setAttribute("Admin", adminSql);
            return "r:/encryptWeb/admin/index.jsp";
        } else {
            req.getSession().setAttribute("msgAdminLogin", "账号或密码错误！请重新输入！");
//            resp.sendRedirect(req.getContextPath()+"/adminLogin.jsp");
            return "f:/adminLogin.jsp";
        }
    }
}
