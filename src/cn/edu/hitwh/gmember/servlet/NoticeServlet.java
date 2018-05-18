package cn.edu.hitwh.gmember.servlet;

import cn.edu.hitwh.gmember.pojo.Admin;
import cn.edu.hitwh.gmember.pojo.News;
import cn.edu.hitwh.gmember.pojo.Notice;
import cn.edu.hitwh.gmember.service.IAdminService;
import cn.edu.hitwh.gmember.service.INewsService;
import cn.edu.hitwh.gmember.service.INoticeService;
import cn.edu.hitwh.gmember.serviceImp.AdminServiceImp;
import cn.edu.hitwh.gmember.serviceImp.NewsServiceImp;
import cn.edu.hitwh.gmember.serviceImp.NoticeServiceImp;
import cn.edu.hitwh.gmember.tools.DateTools;
import cn.edu.hitwh.gmember.tools.PageBean;
import cn.itcast.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class NoticeServlet extends BaseServlet {
    private INoticeService noticeService=new NoticeServiceImp();
    private DateTools dateTools=new DateTools();
    IAdminService adminService=new AdminServiceImp();

    public String addNotice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("调用addNotice方法！");
        HttpSession session=req.getSession();
        Notice notice=new Notice();
//      设置名称
        notice.setNoti_title(req.getParameter("noticeTitle"));
//        System.out.println("title:"+notice.getNoti_title());
//      设置时间
        Date date=new Date();
        notice.setNoti_time(dateTools.date2Str(date));
//        System.out.println("date:"+notice.getNoti_time());
//        设置发布人
        notice.setPublisher(req.getParameter("noticeAuthor"));
//        System.out.println("publisher:"+notice.getPublisher());
        notice.setNoti_source(req.getParameter("noticeSource"));
//      设置作者
        Admin admin= (Admin) session.getAttribute("Admin");
        notice.setAuthor_id(admin.getAdmin_id());
//        System.out.println("admin:"+notice.getAuthor_id());
//      设置内容
        String content=req.getParameter("content");
        notice.setNoti_content(content);
//        System.out.println("content:"+notice.getNoti_content());
//      阅读次数
        notice.setNoti_readtimes(0);
        System.out.println("readtimes:"+notice.getNoti_readtimes());
//      版块id
        String section=req.getParameter("noticeSection");
//        System.out.println("=====输出的信息是什么？"+section);
        notice.setNoti_section_id(Integer.parseInt(section));
//        System.out.println("=====Integer.parseInt(section)输出的信息是什么？"+section);
//        System.out.println("section:"+notice.getNoti_section_id());
//
//        System.out.println("notice.toString()="+notice.toString());

        Integer noticeid=noticeService.addNotice(notice);

//      Integer noticeid=1001;
        System.out.println("notice.toString()="+notice.toString());

        if (noticeid==null) {
//            System.out.println("null主键noticeid.intValue()："+noticeid.intValue());
//            System.out.println("null主键noticeid："+noticeid);
//            System.out.println("null主键noticeid.toString()："+noticeid.toString());
            session.setAttribute("msgAddNotice", "新闻发布失败，请重新发布！");
        }else{
            session.setAttribute("msgAddNotice", "新闻发布成功！");
//            System.out.println("非null主键noticeid.intValue()："+noticeid.intValue());
//            System.out.println("非null主键noticeid："+noticeid);
//            System.out.println("非null主键noticeid.toString()："+noticeid.toString());
        }
        return "r:/encryptWeb/admin/addNotice.jsp";
    }


    public String findAllNotices(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currentPage=getCurrentPage(req);
        String url=getUrl(req);
        PageBean<Notice> pageBean=noticeService.findAllNotices(currentPage);
        pageBean.setCurrentPage(currentPage);
        pageBean.setUrl(url);
        pageBean.setTotalPages(pageBean.getTotalPages());
        req.setAttribute("pb",pageBean);
        return "f:/notices.jsp";
    }

    public String findNoticesBySection(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currentPage=getCurrentPage(req);
        String url=getUrl(req);
        int sectionid=Integer.parseInt(req.getParameter("sectionid"));
        PageBean<Notice> pageBean=noticeService.findNoticesBySection(sectionid,currentPage);
        pageBean.setCurrentPage(currentPage);
        pageBean.setUrl(url);
        pageBean.setTotalPages(pageBean.getTotalPages());
        req.setAttribute("pb",pageBean);
        return "f:/notices.jsp";
    }

    public String findNoticeById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Notice noti=new Notice();
        int noticeid=Integer.parseInt(req.getParameter("noticeid"));
        noti=noticeService.findNoticeById(noticeid);
        req.setAttribute("noti",noti);
        return "f:/noticeDetail.jsp";
    }


    public String adminFindNoticeById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Notice noti=new Notice();
        int noticeid=Integer.parseInt(req.getParameter("notiid"));
        noti=noticeService.findNoticeById(noticeid);
        String adminname=adminService.findAdminNameById(noti.getAuthor_id());
        noti.setAuthor_id(adminname);
        req.setAttribute("noti",noti);
        System.out.println("servlet得到的notice信息："+noti.toString());
        return "f:/encryptWeb/admin/noticeDetail.jsp";
    }

    public String adminFindNoticesBySection(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currentPage=getCurrentPage(req);
        String url=getUrl(req);
        int sectionid=Integer.parseInt(req.getParameter("sectionid"));
        PageBean<Notice> pageBean=noticeService.findNoticesBySection(sectionid,currentPage);
        pageBean.setCurrentPage(currentPage);
        pageBean.setUrl(url);
        pageBean.setTotalPages(pageBean.getTotalPages());
        req.setAttribute("pb",pageBean);
        return "f:/encryptWeb/admin/notices.jsp";
    }

    public String adminFindAllNotices(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currentPage=getCurrentPage(req);
        String url=getUrl(req);
        PageBean<Notice> pageBean=noticeService.findAllNotices(currentPage);
        pageBean.setCurrentPage(currentPage);
        pageBean.setUrl(url);
        pageBean.setTotalPages(pageBean.getTotalPages());
        req.setAttribute("pb",pageBean);
        return "f:/encryptWeb/admin/notices.jsp";
    }

    public String toUpdateNotice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int notiid=Integer.parseInt(req.getParameter("notiid"));
        Notice notice=noticeService.findNoticeById(notiid);
        req.setAttribute("noti",notice);
        return "f:/encryptWeb/admin/noticeProfile.jsp";
    }

    public String updateNotice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Notice newNotice=new Notice();
        String url=getUrl(req);
//        System.out.println("网页url="+url);

//      公告id--
        int notiid=Integer.parseInt(req.getParameter("notiid"));
//        System.out.println("新闻id="+notiid);
        newNotice.setNoti_id(notiid);

        Date date=new Date();
        String notitime=dateTools.date2Str(date);
        newNotice.setNoti_time(notitime);
//        System.out.println("新闻time="+notitime);
//        发布人--
        String publisher=req.getParameter("publisher");
        newNotice.setPublisher(publisher);
//        System.out.println("新闻publisher="+publisher);
//        作者id--
//        int authorid=Integer.parseInt(req.getParameter("adminid"));
        Admin admin= (Admin) req.getSession().getAttribute("Admin");
        String authorid=admin.getAdmin_id();
        newNotice.setAuthor_id(authorid);
//        System.out.println("新闻authorid="+authorid);

//        标题--
        String notititle=req.getParameter("notititle");
        newNotice.setNoti_title(notititle);
//        System.out.println("新闻title="+notititle);
//        内容--
        String noticontent=req.getParameter("content");
        newNotice.setNoti_content(noticontent);
//        System.out.println("新闻newContent="+noticontent);
//        板块id--
        int secctionid=Integer.parseInt(req.getParameter("secctionid"));
        newNotice.setNoti_section_id(secctionid);
//        System.out.println("新闻secctionid="+secctionid);
//       浏览次数重置为0
        int readtimes=0;
        newNotice.setNoti_readtimes(readtimes);
//        System.out.println("新闻readtimes="+readtimes);
//        来源--
        String notisource=req.getParameter("notisource");
        newNotice.setNoti_source(notisource);
//        System.out.println("新闻notisource="+notisource);

//        更新数据库
        noticeService.updateNotice(newNotice);

//        重新获取信息并返回详情页
        Notice notice=noticeService.findNoticeById(notiid);
        req.setAttribute("noti",notice);
        req.setAttribute("msgUpdateNotice","新闻更新成功！");

        return "f:/encryptWeb/admin/noticeProfile.jsp";
    }

    public String deleteNotice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url=getUrl(req);
        int currentPage=getCurrentPage(req);
        System.out.println("网页url="+url);
        int notiid=Integer.parseInt(req.getParameter("notiid"));
        String notititle=req.getParameter("notititle");
        noticeService.deleteNotice(notiid);
        PageBean<Notice> pageBean=new PageBean<Notice>();
        pageBean= noticeService.findAllNotices(currentPage);
        pageBean.setUrl(url);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPages(pageBean.getTotalPages());
        req.setAttribute("pb",pageBean);
        req.setAttribute("msgDeleteStudent","公告\""+notititle+"\"已从系统删除。");

        return "f:/encryptWeb/admin/notices.jsp";
    }

    //得到当前页
    private int getCurrentPage(HttpServletRequest req){
        int currentPage=1;
        String param=req.getParameter("currentPage");
//        System.out.println("转换前的currentPage=param+"+param);
        if(param!=null && !param.trim().isEmpty()){ //trim() 方法用于删除字符串的头尾空白符
            try{
                currentPage=Integer.parseInt(param);
//                System.out.println("转换后的currentPage="+currentPage);
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
