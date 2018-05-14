package cn.edu.hitwh.gmember.servlet;

import cn.edu.hitwh.gmember.pojo.Admin;
import cn.edu.hitwh.gmember.pojo.News;
import cn.edu.hitwh.gmember.service.INewsService;
import cn.edu.hitwh.gmember.serviceImp.NewsServiceImp;
import cn.edu.hitwh.gmember.tools.DateTools;
import cn.itcast.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class NewsServlet extends BaseServlet {
    private INewsService newsService=new NewsServiceImp();
    private DateTools dateTools=new DateTools();

    public String addNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("调用addNews方法！");
        HttpSession session=req.getSession();
        News news = new News();
        news.setNews_id(121212);
//        设置名称
//        news.setNews_title(req.getParameter("title"));
        news.setNews_title("这是新闻");
        System.out.println("title:"+news.getNews_title());
//        设置时间
        Date date=new Date();
        news.setNews_time(dateTools.date2Str(date));
        System.out.println("date:"+news.getNews_time());
//        设置发布人
//        news.setPublisher(req.getParameter("author"));
        news.setPublisher("孙鹏重");
        System.out.println("author:"+news.getPublisher());
//      设置作者
        Admin admin= (Admin) session.getAttribute("Admin");
        news.setAuthor_id(admin.getAdmin_id());
        System.out.println("admin:"+news.getAuthor_id());
//        设置内容
        String content=req.getParameter("content");
        news.setNews_content(content);
        System.out.println("content:"+news.getNews_content());
        news.setNews_readtimes(1000);
        System.out.println("readtimes:"+news.getNews_readtimes());
        news.setNews_section_id(1);
        System.out.println("section:"+news.getNews_section_id());

        System.out.println("news.toString()="+news.toString());

        Integer newsid=newsService.addNews(news);

        System.out.println("news.toString()="+news.toString());

        if (newsid==null) {
            System.out.println("null主键："+newsid);
            session.setAttribute("MsgAddNews", "新闻发布失败，请重新发布！");
        }else{
            session.setAttribute("MsgAddNews", "新闻发布成功！");
            System.out.println("非null主键："+newsid);
        }
        return "r:/encryptWeb/admin/addNews.jsp";
    }
}
