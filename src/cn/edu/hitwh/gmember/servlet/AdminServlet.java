package cn.edu.hitwh.gmember.servlet;

import cn.edu.hitwh.gmember.pojo.Admin;
import cn.edu.hitwh.gmember.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.AccessDeniedException;

public class AdminServlet extends HttpServlet {
    private AdminService adminService=new AdminService();

    @Override
    public void init() throws ServletException {
        System.out.println("启动servlet==============================");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String adminid=(String)req.getSession().getAttribute("adminid");
//        String adminid=req.getParameter("adminid");
//        System.out.println("=========================================================="+adminid);
//        req.getSession().setAttribute("adminid","00001");
//        PrintWriter out=resp.getWriter();
//        out.write("doPost====");
//        out.write("\r\n");
//        out.write("Successful!");
//        out.write("\r\n");
//        out.write(req.getParameter("adminid"));
//        out.write("\r\n");
//        out.write(req.getParameter("adminpwd"));
//        System.out.println("==========================================================dopost()");
//        adminLogin(req,resp);
        String adminid=req.getParameter("adminid");
        String adminpwd=req.getParameter("adminpwd");
        System.out.println("+++++++++++++++++++"+adminid);
        System.out.println("+++++++++++++++++++"+adminpwd);
        HttpSession session=req.getSession();
        Admin admin=new Admin();
        admin.setAdmin_id(adminid);
        admin.setAdmin_password(adminpwd);
        Admin adminLogin=adminService.login(admin);
        if (adminLogin!=null){
            resp.sendRedirect(req.getContextPath()+"/encryptWeb/admin");
        }else{
            session.setAttribute("msg","账号或密码错误！");
            resp.sendRedirect(req.getContextPath()+"/adminLogin.jsp");
        }
    }

    public  String adminLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String adminid=request.getParameter("adminid");
        String adminpwd=request.getParameter("adminpwd");
        System.out.println("+++++++++++++++++++"+adminid);
        System.out.println("+++++++++++++++++++"+adminpwd);
        Admin admin=new Admin();
        admin.setAdmin_id(adminid);
        admin.setAdmin_password(adminpwd);
        Admin adminLogin=adminService.login(admin);
        if (adminLogin==null){
            request.setAttribute("msg","用户名或密码错误");
            return "/adminLogin.jsp";
//            response.sendRedirect();
        }else{
            request.getSession().setAttribute("admin",admin);
            return "r:/admin/index.jsp";
        }

    }
}
