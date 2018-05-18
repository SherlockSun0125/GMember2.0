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
        Teacher teacher=new Teacher();
        teacher.setTea_num(teanum);
        teacher.setTea_pwd(teapwd);
        Teacher teacherLogin=teacherService.login(teacher);

        if (teacherLogin!=null){
            req.setAttribute("msgTeacherLogin","");
            req.getSession().setAttribute("Teacher",teacherLogin);
//            resp.sendRedirect(req.getContextPath()+"/encryptWeb/teacher");
            return "f:/encryptWeb/teacher";
        }else{
            req.setAttribute("msgTeacherLogin","账号或密码错误！请重新输入！");
//            resp.sendRedirect(req.getContextPath()+"/teacherLogin.jsp");
            return "r:/teacherLogin.jsp";
        }
    }


    public String findAllTeachers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url=getUrl(req);
        int currentPage=getCurrentPage(req);
        PageBean<Teacher> pageBean=teacherService.findAllTeachers(currentPage);
//        for(int i=0;i<pageBean.getBeanList().size();i++){
//            System.out.println("来自servlet层的问候(取出的数据)："+pageBean.getBeanList().get(i));
//        }
        pageBean.setCurrentPage(currentPage);
        pageBean.setUrl(url);
        req.setAttribute("pb",pageBean);
        return "f:/encryptWeb/admin/teachers.jsp";
    }

    public String deleteTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url=getUrl(req);
        int currentPage=getCurrentPage(req);
        System.out.println("网页url="+url);
        int teacherid=Integer.parseInt(req.getParameter("teacherid"));
        String teachername=req.getParameter("teachername");
        teacherService.deleteTeacher(teacherid);
        PageBean<Teacher> pageBean=teacherService.findAllTeachers(currentPage);
        pageBean.setCurrentPage(currentPage);
        pageBean.setUrl(url);
        req.setAttribute("pb",pageBean);
        req.setAttribute("msgDeleteTeacher",teachername+"老师已从系统删除。");
        return "f:/encryptWeb/admin/teachers.jsp";
    }

    //中间转折一下获取id并找到该teacher的全部信息并转到teacherProfile.jsp
    public String findTeacherById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int tea_id=Integer.parseInt(req.getParameter("teacherid"));
        Teacher tea=teacherService.findTeacherById(tea_id);
        PageBean<Department> departmentPageBean=departmentService.findAllDepartments();
        req.setAttribute("tea",tea);
        req.setAttribute("departmentPageBean",departmentPageBean);
//        for (int i=0;i< departmentPageBean.getBeanList().size();i++){
//            System.out.println("获取到的院系列表元素-departmentPageBean.getBeanList().get(i)="+departmentPageBean.getBeanList().get(i));
//        }
        return "f:/encryptWeb/admin/teacherProfile.jsp";
    }

    public String updateTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Teacher newTeacher=new Teacher();
        String url=getUrl(req);
        System.out.println("网页url="+url);

//      教师id
        int teaid=Integer.parseInt(req.getParameter("teacherid"));
        System.out.println("教师id="+teaid);
        newTeacher.setTea_id(teaid);
//        工号
        String teanum=req.getParameter("teanum");
        newTeacher.setTea_num(teanum);
        System.out.println("教师num="+teanum);
//        姓名
        String teaname=req.getParameter("teaname");
        newTeacher.setTea_name(teaname);
        System.out.println("教师name="+teaname);
//        性别
        String teasex=req.getParameter("teasex");
        newTeacher.setTea_sex(teasex);
        System.out.println("教师sex="+teasex);
//        年龄
        int teaage=Integer.parseInt(req.getParameter("teaage"));
        newTeacher.setTea_age(teaage);
        System.out.println("教师age="+teaage);
//        院系
        int depid=Integer.parseInt(req.getParameter("depid"));
        newTeacher.setDep_id(depid);
        System.out.println("教师depid="+depid);
//        手机号
        String teaphone=req.getParameter("teaphone");
        newTeacher.setTea_phone(teaphone);
        System.out.println("教师phone="+teaphone);
//        邮箱
        String teamail=req.getParameter("teamail");
        newTeacher.setTea_mail(teamail);
        System.out.println("教师mail="+teamail);
//        密码
        String teapwd=req.getParameter("teapwd");
        newTeacher.setTea_pwd(teapwd);
        System.out.println("教师pwd="+teapwd);

//        更新数据库
        teacherService.updateTeacher(newTeacher);

//        重新获取信息并返回详情页
        Teacher tea=teacherService.findTeacherById(teaid);
        PageBean<Department> departmentPageBean=departmentService.findAllDepartments();
        req.setAttribute("tea",tea);
        req.setAttribute("departmentPageBean",departmentPageBean);

        req.setAttribute("msgUpdateTeacher","信息更新成功！");

        return "f:/encryptWeb/admin/teacherProfile.jsp";
    }

    public String addTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Teacher newTeacher=new Teacher();
        String url=getUrl(req);
        System.out.println("网页url="+url);
//        工号
        String teanum=req.getParameter("teanum");
        newTeacher.setTea_num(teanum);
        System.out.println("教师num="+teanum);
//        姓名
        String teaname=req.getParameter("teaname");
        newTeacher.setTea_name(teaname);
        System.out.println("教师name="+teaname);
//        性别
        String teasex=req.getParameter("teasex");
        newTeacher.setTea_sex(teasex);
        System.out.println("教师sex="+teasex);
//        年龄
        int teaage=Integer.parseInt(req.getParameter("teaage"));
        newTeacher.setTea_age(teaage);
        System.out.println("教师age="+teaage);
//        院系
        int depid=Integer.parseInt(req.getParameter("depid"));
        newTeacher.setDep_id(depid);
        System.out.println("教师depid="+depid);
//        手机号
        String teaphone=req.getParameter("teaphone");
        newTeacher.setTea_phone(teaphone);
        System.out.println("教师phone="+teaphone);
//        邮箱
        String teamail=req.getParameter("teamail");
        newTeacher.setTea_mail(teamail);
        System.out.println("教师mail="+teamail);
//        密码
        String teapwd=teaphone;
        newTeacher.setTea_pwd(teapwd);
        System.out.println("教师pwd="+teapwd);

//        存入数据库
        Integer teaid=teacherService.addTeacher(newTeacher);

//        并返回增加页
        PageBean<Department> departmentPageBean = departmentService.findAllDepartments();
        req.setAttribute("departmentPageBean", departmentPageBean);
        if(teaid==null) {
            req.setAttribute("msgAddTeacher","教师添加失败！");
        }else{
            req.setAttribute("msgAddTeacher","教师添加成功！");
        }
        return "f:/encryptWeb/admin/addTeacher.jsp";
    }

//    为了得到院系列表
    public String toAddTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获得院系列表
        PageBean<Department> departmentPageBean=departmentService.findAllDepartments();
        req.setAttribute("departmentPageBean",departmentPageBean);
        return "f:/encryptWeb/admin/addTeacher.jsp";
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
