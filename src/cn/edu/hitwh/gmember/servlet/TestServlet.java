package cn.edu.hitwh.gmember.servlet;

import cn.itcast.servlet.BaseServlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlet extends BaseServlet {

    public String getData(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("调用了该方法");
        String logtitle=req.getParameter("logtitle");
        System.out.println("日志标题为："+logtitle);

        String logcontent=req.getParameter("logcontent");
        System.out.println("日志内容为："+logcontent);

        req.setAttribute("msgAddLog",logtitle+"=============="+logcontent);
        return "f:/encryptWeb/student/level1/newLog.jsp";
    }
}
