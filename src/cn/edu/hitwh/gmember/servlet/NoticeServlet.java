package cn.edu.hitwh.gmember.servlet;

import cn.edu.hitwh.gmember.pojo.Admin;
import cn.edu.hitwh.gmember.pojo.News;
import cn.edu.hitwh.gmember.pojo.Notice;
import cn.edu.hitwh.gmember.service.INewsService;
import cn.edu.hitwh.gmember.service.INoticeService;
import cn.edu.hitwh.gmember.serviceImp.NewsServiceImp;
import cn.edu.hitwh.gmember.serviceImp.NoticeServiceImp;
import cn.edu.hitwh.gmember.tools.DateTools;
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

    public String addNotice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("调用addNotice方法！");
        HttpSession session=req.getSession();
        Notice notice=new Notice();
//      设置名称
        notice.setNoti_title(req.getParameter("noticeTitle"));
        System.out.println("title:"+notice.getNoti_title());
//      设置时间
        Date date=new Date();
        notice.setNoti_time(dateTools.date2Str(date));
        System.out.println("date:"+notice.getNoti_time());
//        设置发布人
        notice.setPublisher(req.getParameter("noticeAuthor"));
        System.out.println("publisher:"+notice.getPublisher());
//      设置作者
        Admin admin= (Admin) session.getAttribute("Admin");
        notice.setAuthor_id(admin.getAdmin_id());
        System.out.println("admin:"+notice.getAuthor_id());
//      设置内容
        String content=req.getParameter("content");
        notice.setNoti_content(content);
        System.out.println("content:"+notice.getNoti_content());
//      阅读次数
        notice.setNoti_readtimes(0);
        System.out.println("readtimes:"+notice.getNoti_readtimes());
//      版块id
        notice.setNoti_section_id(1);
        System.out.println("section:"+notice.getNoti_section_id());

        System.out.println("notice.toString()="+notice.toString());

        Integer noticeid=noticeService.addNotice(notice);

//        Integer noticeid=1001;
        System.out.println("notice.toString()="+notice.toString());

        if (noticeid==null) {
            System.out.println("null主键noticeid.intValue()："+noticeid.intValue());
            System.out.println("null主键noticeid："+noticeid);
            System.out.println("null主键noticeid.toString()："+noticeid.toString());
            session.setAttribute("msgAddNotice", "新闻发布失败，请重新发布！");
        }else{
            session.setAttribute("msgAddNotice", "新闻发布成功！");
            System.out.println("非null主键noticeid.intValue()："+noticeid.intValue());
            System.out.println("非null主键noticeid："+noticeid);
            System.out.println("非null主键noticeid.toString()："+noticeid.toString());
        }
        return "r:/encryptWeb/admin/addNotice.jsp";
    }
}
