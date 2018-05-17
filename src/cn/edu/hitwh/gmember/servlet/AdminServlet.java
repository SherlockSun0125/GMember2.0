package cn.edu.hitwh.gmember.servlet;

import cn.edu.hitwh.gmember.pojo.*;
import cn.edu.hitwh.gmember.service.*;
import cn.edu.hitwh.gmember.serviceImp.*;
import cn.edu.hitwh.gmember.tools.PageBean;
import cn.itcast.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminServlet extends BaseServlet {
    private IAdminService adminService =new AdminServiceImp();
    private IStulevelService stulevelService=new StulevelServiceImp();
    private IComtypeService comtypeService=new ComtypeServiceImp();
    private INewsSectionService newsSectionService=new NewsSectionServiceImp();
    private INoticeSectionService noticeSectionService=new NoticeSectionServiceImp();

    public String adminLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("调用adminLogin方法！");
        String adminid = req.getParameter("adminid");
        String adminpwd = req.getParameter("adminpwd");
        Admin admin = new Admin();
        admin.setAdmin_id(adminid);
        admin.setAdmin_password(adminpwd);
        Admin adminSql = adminService.login(admin);

        if (adminSql != null) {
            req.getSession().setAttribute("msgAdminLogin", "");
//            resp.sendRedirect(req.getContextPath()+"/encryptWeb/admin");
            PageBean<StuLevel> stuLevelPageBean=stulevelService.findAllStuLevels();
            PageBean<Comtype> comtypePageBean=comtypeService.findAllComtypes();
            PageBean<NewsSection> newsSectionPageBean=newsSectionService.findAllNewsSections();
            PageBean<NoticeSection> noticeSectionPageBean=noticeSectionService.findAllNoticeSections();
            req.getSession().setAttribute("stuLevelPageBean",stuLevelPageBean);
            req.getSession().setAttribute("comtypePageBean",comtypePageBean);
            req.getSession().setAttribute("newsSectionPageBean",newsSectionPageBean);
            req.getSession().setAttribute("noticeSectionPageBean",noticeSectionPageBean);

            req.getSession().setAttribute("Admin", adminSql);
            return "r:/encryptWeb/admin/index.jsp";
        } else {
            req.setAttribute("msgAdminLogin", "账号或密码错误！请重新输入！");
//            resp.sendRedirect(req.getContextPath()+"/adminLogin.jsp");
            return "f:/adminLogin.jsp";
        }
    }
}
