package cn.edu.hitwh.gmember.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "TestServlet")
public class TestServlet implements Servlet {
    public TestServlet(){
        System.out.println("创建Servlet");
    }
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("初始化Servlet");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
