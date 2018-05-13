package cn.edu.hitwh.gmember.servlet;

import cn.edu.hitwh.gmember.pojo.News;
import cn.edu.hitwh.gmember.service.INewsService;
import cn.edu.hitwh.gmember.serviceImp.NewsServiceImp;
import cn.itcast.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewsServlet extends BaseServlet {
    private INewsService newsService=new NewsServiceImp();

    public String addNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("调用addNews方法！");
        News news=new News();
        news.setNews_id("000001");
        news.setNews_readtimes(1212);
        news.setNews_section_id(1);
        news.setAuthor_id("0001");
        Date date= new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dateNowStr = sdf.format(date);
//        news.setNews_time(dateNowStr);
        news.setNews_time(date);
        news.setPublisher("孙鹏重");
        news.setNews_content("BaseServlet的作用是用来简化Servlet。通过我们需要为每个功能编写一个Servlet，例如用户注册写一个RegistServlet，用户登录写一个LoginServlet。如果使用BaseServlet，那么我们可以只写一个UserServlet，然后让UserServlet去继承BaseServlet，然后在UserServlet给出两个请求处理方法，一个方法叫regist()，一个叫login()。\n" +
                "BaseServlet来简化了Servlet中请求转发和重定向的代码。");
        newsService.addNews(news);
        return "/encryptWeb/admin/unloadNews.jsp";
    }

    public void getNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("调用getNews方法！");
//        String adminid = req.getParameter("adminid");
//        String adminpwd = req.getParameter("adminpwd");
//        Admin admin = new Admin();
//        admin.setAdmin_id(adminid);
//        admin.setAdmin_password(adminpwd);
//        Admin adminSql = IAdminService.login(admin);
//        if (adminSql != null) {
//            req.getSession().setAttribute("msgAdminLogin", "");
////            resp.sendRedirect(req.getContextPath()+"/encryptWeb/admin");
//            req.getSession().setAttribute("Admin", adminSql);
//            return "r:/encryptWeb/admin/index.jsp";
//        } else {
//            req.getSession().setAttribute("msgAdminLogin", "账号或密码错误！请重新输入！");
////            resp.sendRedirect(req.getContextPath()+"/adminLogin.jsp");
//            return "/adminLogin.jsp";
//        }
    }
}
