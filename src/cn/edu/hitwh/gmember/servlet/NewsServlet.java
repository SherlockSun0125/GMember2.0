package cn.edu.hitwh.gmember.servlet;

import cn.edu.hitwh.gmember.pojo.Admin;
import cn.edu.hitwh.gmember.pojo.Department;
import cn.edu.hitwh.gmember.pojo.News;
import cn.edu.hitwh.gmember.service.IDepartmentService;
import cn.edu.hitwh.gmember.service.INewsService;
import cn.edu.hitwh.gmember.serviceImp.DepartmentServiceImp;
import cn.edu.hitwh.gmember.serviceImp.NewsServiceImp;
import cn.edu.hitwh.gmember.tools.DateTools;
import cn.itcast.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.print.Book;
import java.io.IOException;
import java.util.Date;
import cn.edu.hitwh.gmember.tools.PageBean;

public class NewsServlet extends BaseServlet {
    private INewsService newsService=new NewsServiceImp();
    private DateTools dateTools=new DateTools();
    IDepartmentService departmentService=new DepartmentServiceImp();

    public String addNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("调用addNews方法！");
        HttpSession session=req.getSession();
        News news = new News();
//      设置名称
        news.setNews_title(req.getParameter("newsTitle"));
        System.out.println("title:"+news.getNews_title());
//      设置时间
        Date date=new Date();
        news.setNews_time(dateTools.date2Str(date));
        System.out.println("date:"+news.getNews_time());
//        设置发布人
        news.setPublisher(req.getParameter("newsAuthor"));
        System.out.println("publisher:"+news.getPublisher());
//        设置新闻来源
        news.setNews_source(req.getParameter("newsSource"));

//      设置作者
        Admin admin= (Admin) session.getAttribute("Admin");
        news.setAuthor_id(admin.getAdmin_id());
        System.out.println("admin:"+news.getAuthor_id());
//      设置内容
        String content=req.getParameter("content");
        news.setNews_content(content);
        System.out.println("content:"+news.getNews_content());
//      阅读次数
        news.setNews_readtimes(0);
        System.out.println("readtimes:"+news.getNews_readtimes());
//      版块id
        String section=req.getParameter("newsSction");
        System.out.println("=====输出的信息是什么？"+section);
        news.setNews_section_id(Integer.parseInt(section));
        System.out.println("=====Integer.parseInt(section)输出的信息是什么？"+section);
        System.out.println("section:"+news.getNews_section_id());

        System.out.println("news.toString()="+news.toString());

        Integer newsid=newsService.addNews(news);

        System.out.println("news.toString()="+news.toString());

        if (newsid==null) {
//            System.out.println("null主键newsid.intValue()："+newsid.intValue());
//            System.out.println("null主键newsid："+newsid);
//            System.out.println("null主键newsid.toString()："+newsid.toString());
            session.setAttribute("msgAddNews", "新闻发布失败，请重新发布！");
        }else{
            session.setAttribute("msgAddNews", "新闻发布成功！");
//            System.out.println("非null主键newsid.intValue()："+newsid.intValue());
//            System.out.println("非null主键newsid："+newsid);
//            System.out.println("非null主键newsid.toString()："+newsid.toString());
        }
        return "r:/encryptWeb/admin/addNews.jsp";
    }

//    按类找到新闻
    public String findNewsByType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("========================================================");
        int currentPage=getCurrentPage(req);
        System.out.println("返回的currentPage="+currentPage);
        String url=getUrl(req);
        int sectionid=Integer.parseInt(req.getParameter("sectionid"));
        System.out.println("版块ID为："+sectionid);
        System.out.println("当前页码为："+currentPage);
        PageBean<News> pb = newsService.findNewsBySection(sectionid, currentPage);
        pb.setUrl(url);
        req.setAttribute("pb", pb);
        System.out.println("版块url为："+url);
        System.out.println(pb.getTotalPages());
        for (News news:pb.getBeanList()){
            System.out.println("pb的list为："+news.getNews_title());
        }
        return "f:/news.jsp";
    }

    //找到所有新闻
    public String findAllNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currentPage=getCurrentPage(req);
//        System.out.println("当前页码为："+currentPage);
        String url=getUrl(req);
        PageBean<News> pb =newsService.findAllNews(currentPage);
//        System.out.println("刚返回的时候的pb.toString()为："+pb.toString());
        pb.setUrl(url);
        pb.setTotalPages(pb.getTotalPages());
        req.setAttribute("pb", pb);
//        System.out.println("版块url为："+url);
//        System.out.println("加上url之后的pb.toString()为："+pb.toString());
//        for (News news:pb.getBeanList()){
//            System.out.println("pb的list为："+news.getNews_id()+news.getNews_title());
//        }
        return "f:/news.jsp";
    }

    public String adminFindAllNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currentPage=getCurrentPage(req);
//        System.out.println("当前页码为："+currentPage);
        String url=getUrl(req);
        PageBean<News> pb =newsService.findAllNews(currentPage);
//        System.out.println("刚返回的时候的pb.toString()为："+pb.toString());
        pb.setUrl(url);
        pb.setTotalPages(pb.getTotalPages());
        req.setAttribute("pb", pb);
        return "f:/encryptWeb/admin/news.jsp";
    }

    public String findNewsById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int news_id=Integer.parseInt(req.getParameter("newsid"));
        News news=newsService.findNewsById(news_id);
        req.setAttribute("news",news);
        return "f:/newsDetail.jsp";
    }

    //得到当前页
    private int getCurrentPage(HttpServletRequest req){
        int currentPage=1;
        String param=req.getParameter("currentPage");
        System.out.println("转换前的currentPage=param+"+param);
        if(param!=null && !param.trim().isEmpty()){ //trim() 方法用于删除字符串的头尾空白符
            try{
                currentPage=Integer.parseInt(param);
                System.out.println("转换后的currentPage="+currentPage);
            }catch (RuntimeException e){
                e.printStackTrace();
            }
        }
        return currentPage;
    }

    //获取URL
    private String getUrl(HttpServletRequest req){
        String url=req.getRequestURI()+"?"+req.getQueryString();
        //如果URL中存在currentPage参数，截取掉
        int index=url.lastIndexOf("&currentPage=");
        if(index!=-1){
            url=url.substring(0,index);
        }
        return url;
    }
}
