package cn.edu.hitwh.gmember.servlet;

import cn.edu.hitwh.gmember.pojo.Teacher;
import cn.edu.hitwh.gmember.service.ITeacherService;
import cn.edu.hitwh.gmember.serviceImp.TeacherServiceImp;
import cn.edu.hitwh.gmember.tools.PageBean;
import cn.itcast.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TeacherServlet extends BaseServlet {
    private ITeacherService teacherService=new TeacherServiceImp();

    public String teacherLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String teaid=req.getParameter("teaid");
        String teapwd=req.getParameter("teapwd");
        System.out.println("+++++++++++++++++++"+teaid);
        System.out.println("+++++++++++++++++++"+teapwd);
        Teacher teacher=new Teacher();
        teacher.setTea_id(teaid);
        teacher.setTea_pwd(teapwd);
        Teacher teacherLogin=teacherService.login(teacher);

        if (teacherLogin!=null){
            req.getSession().setAttribute("msgTeacherLogin","");
            req.getSession().setAttribute("Teacher",teacherLogin);
//            resp.sendRedirect(req.getContextPath()+"/encryptWeb/teacher");
            return "r:/encryptWeb/teacher";
        }else{
            req.getSession().setAttribute("msgTeacherLogin","账号或密码错误！请重新输入！");
//            resp.sendRedirect(req.getContextPath()+"/teacherLogin.jsp");
            return "r:/teacherLogin.jsp";
        }
    }


    public String findAllTeachers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url=getUrl(req);
        PageBean<Teacher> pageBean=teacherService.findAllTeachers();
//        int currentPage=getCurrentPage(req);
        for(int i=0;i<pageBean.getBeanList().size();i++){
            System.out.println("来自servlet层的问候(取出的数据)："+pageBean.getBeanList().get(i));
        }
        pageBean.setUrl(url);
        req.setAttribute("pb",pageBean);
        return "f:/encryptWeb/admin/teacherList.jsp";
    }


    //得到当前页
    private int getCurrentPage(HttpServletRequest req){
        int currentPage=1;
        String param=req.getParameter("currentPage");
        System.out.println("转换前的currentPage=param+"+param);
        if(param!=null && !param.trim().isEmpty()){
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
