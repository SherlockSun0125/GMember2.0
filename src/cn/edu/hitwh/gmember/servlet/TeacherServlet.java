package cn.edu.hitwh.gmember.servlet;

import cn.edu.hitwh.gmember.pojo.Department;
import cn.edu.hitwh.gmember.pojo.Teacher;
import cn.edu.hitwh.gmember.service.IDepartmentService;
import cn.edu.hitwh.gmember.service.ITeacherService;
import cn.edu.hitwh.gmember.serviceImp.DepartmentServiceImp;
import cn.edu.hitwh.gmember.serviceImp.TeacherServiceImp;
import cn.edu.hitwh.gmember.tools.PageBean;
import cn.itcast.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class TeacherServlet extends BaseServlet {
    private ITeacherService teacherService=new TeacherServiceImp();
    private IDepartmentService departmentService=new DepartmentServiceImp();

    public String teacherLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String teanum=req.getParameter("teaid");
        String teapwd=req.getParameter("teapwd");
        System.out.println("+++++++++++++++++++"+teanum);
        System.out.println("+++++++++++++++++++"+teapwd);
        Teacher teacher=new Teacher();
        teacher.setTea_num(teanum);
        teacher.setTea_pwd(teapwd);
        Teacher teacherLogin=teacherService.login(teacher);

        if (teacherLogin!=null){
            req.getSession().setAttribute("msgTeacherLogin","");
            req.getSession().setAttribute("Teacher",teacherLogin);
//            resp.sendRedirect(req.getContextPath()+"/encryptWeb/teacher");
            return "f:/encryptWeb/teacher";
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
        return "f:/encryptWeb/admin/teachers.jsp";
    }

    public String deleteTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url=getUrl(req);
        int teacherid=Integer.parseInt(req.getParameter("teacherid"));
        teacherService.deleteTeacher(teacherid);
        return "f:/encryptWeb/admin/teacherList.jsp";
    }

    //中间转折一下获取id并找到该teacher的全部信息并转到teacherProfile.jsp
    public String findTeacherById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int tea_id=Integer.parseInt(req.getParameter("teacherid"));
        Teacher tea=teacherService.findTeacherById(tea_id);
        PageBean<Department> departmentPageBean=departmentService.findAllDepartments();
        req.setAttribute("tea",tea);
        req.setAttribute("departmentPageBean",departmentPageBean);
        for (int i=0;i< departmentPageBean.getBeanList().size();i++){
            System.out.println("获取到的院系列表元素-departmentPageBean.getBeanList().get(i)="+departmentPageBean.getBeanList().get(i));
        }
        return "f:/encryptWeb/admin/teacherProfile.jsp";
    }

    public String updateTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url=getUrl(req);


        return "f:/encryptWeb/admin/teacherList.jsp";
    }

    public String addTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url=getUrl(req);

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
