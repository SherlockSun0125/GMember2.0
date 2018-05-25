package cn.edu.hitwh.gmember.servlet;

import cn.edu.hitwh.gmember.pojo.*;
import cn.edu.hitwh.gmember.service.*;
import cn.edu.hitwh.gmember.serviceImp.*;
import cn.edu.hitwh.gmember.tools.DateTools;
import cn.edu.hitwh.gmember.tools.PageBean;
import cn.itcast.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class EmployeeServlet extends BaseServlet {
    private IEmployeeService employeeService=new EmployeeServiceImp();
    private ITeacherService teacherService=new TeacherServiceImp();
    private IDepartmentService departmentService=new DepartmentServiceImp();
    private IStudentService studentService=new StudentServiceImp();
    private IStulogService stulogService=new StulogServiceImp();
    private ICourseService courseService=new CourseServiceImp();
    private IProjectService projectService=new ProjectServiceImp();
    private DateTools dateTools=new DateTools();

    public String employeeLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empid = req.getParameter("empid");
        String emppwd = req.getParameter("emppwd");
        Employee employee = new Employee();
        employee.setEmp_id(empid);
        employee.setEmp_pwd(emppwd);
        Employee employeeLogin = employeeService.login(employee);
        if (employeeLogin == null) {
            req.getSession().setAttribute("msgEmployeeLogin", "账号或密码错误！请重新输入！");
//            resp.sendRedirect(req.getContextPath() + "/employeeLogin.jsp");
            return "/employeeLogin.jsp";
        } else {
            req.getSession().setAttribute("msgEmployeeLogin", "");
            req.getSession().setAttribute("Employee", employeeLogin);
//            resp.sendRedirect(req.getContextPath() + "/encryptWeb/employee/index.jsp");
            return "f:/encryptWeb/employee/index.jsp";
        }
    }

    //管理员首页
    public String findAllStudentsByEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int empid=Integer.parseInt(req.getParameter("empid"));
        int stulevelid=Integer.parseInt(req.getParameter("stulevelid"));

        PageBean<Student> studentPageBean=employeeService.findAllStudentsByEmpLevel(empid,stulevelid);

        //为了找到第一个学生
        Student firstStu=studentPageBean.getBeanList().get(0);
        int stuid=firstStu.getStu_id();
        int currentPage=getCurrentPage(req);
        String url=getUrl(req);

        PageBean<StuLog> stuLogPageBean=stulogService.findLogsOfStudentLevel(stuid,stulevelid,currentPage);
        PageBean<Course> coursePageBean=courseService.findCoursesByStuId(stuid);
        PageBean<Project> projectPageBean=projectService.findProjectsByStuLevel(stuid,stulevelid);


        stuLogPageBean.setCurrentPage(currentPage);
        stuLogPageBean.setUrl(url);

        req.setAttribute("pb",stuLogPageBean);
        req.setAttribute("coursePageBean",coursePageBean);
        req.setAttribute("projectPageBean",projectPageBean);
        req.setAttribute("studentPageBean",studentPageBean);
        req.setAttribute("stu",firstStu);
        req.setAttribute("studentPageBean",studentPageBean);

        if (stulevelid==2){
            return "f:/encryptWeb/employee/level2/stuList.jsp";
        }else if(stulevelid==3){
            return "f:/encryptWeb/employee/level3/stuList.jsp";
        }else{
            return "f:/encryptWeb/employee/level4/stuList.jsp";
        }
    }

    public String findAllStudentLevelInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int stuid=Integer.parseInt(req.getParameter("stuid"));
        int stulevelid=Integer.parseInt(req.getParameter("stulevelid"));
        int currentPage=getCurrentPage(req);
        String url=getUrl(req);

        PageBean<StuLog> stuLogPageBean=stulogService.findLogsOfStudentLevel(stuid,stulevelid,currentPage);
        PageBean<Project> projectPageBean=projectService.findProjectsByStuLevel(stuid,stulevelid);

        Student student=studentService.findStudentById(stuid);
        int empid=student.getEmp_id();
        PageBean<Student> studentPageBean=employeeService.findAllStudentsByEmpLevel(empid,stulevelid);

        stuLogPageBean.setCurrentPage(currentPage);
        stuLogPageBean.setUrl(url);

        req.setAttribute("pb",stuLogPageBean);
        req.setAttribute("projectPageBean",projectPageBean);
        req.setAttribute("studentPageBean",studentPageBean);
        req.setAttribute("stu",student);

        if (stulevelid==2){
            return "f:/encryptWeb/employee/level2/stuList.jsp";
        }else{
            return "f:/encryptWeb/employee/level3/stuList.jsp";
        }
    }

    public String findLogById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int logid=Integer.parseInt(req.getParameter("logid"));

        StuLog stuLog=stulogService.findLogByid(logid);

        //查看其教师姓名
        int stuid=stuLog.getStu_id();
        Student student=studentService.findStudentById(stuid);
        //确定有没有分配老师
        int teaid=student.getTea_id();
        if (teaid!=0){
            Teacher teacher=teacherService.findTeacherById(teaid);
            req.setAttribute("teacherName",teacher.getTea_name());
        }else {
            req.setAttribute("teacherName",null);
        }

        //确定有没有分配导师
        int empid=student.getEmp_id();
        if (empid!=0){
            Employee employee=employeeService.findAllEmployeeById(empid);
            req.setAttribute("employeeName",employee.getEmp_name());
        }else {
            req.setAttribute("employeeName",null);
        }

        int stulevelid=stuLog.getStu_level_id();

        PageBean<Student> studentPageBean=employeeService.findAllStudentsByEmpLevel(empid,stulevelid);

        req.setAttribute("stuLog",stuLog);
        req.setAttribute("studentPageBean",studentPageBean);


        if (stulevelid==2){
            return "f:/encryptWeb/employee/level2/stuLogDetails.jsp";
        }else{
            return "f:/encryptWeb/employee/level3/stuLogDetails.jsp";
        }
    }

    public String feedbackLog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int logid=Integer.parseInt(req.getParameter("logid"));
//        System.out.println("日志id="+logid);
        String empFeedback=req.getParameter("empFeedback");
//        System.out.println("教师反馈="+teaFeedback);
        int empStatus=Integer.parseInt(req.getParameter("empStatus"));
//        System.out.println("评论等级="+teaStatus);

        Date date=new Date();
        String now=dateTools.date2Str(date);

        StuLog stuLog=stulogService.findLogByid(logid);

        stuLog.setEmp_status(empStatus);
        stuLog.setEmp_feedback(empFeedback);
        stuLog.setEmp_time(now);

        stulogService.updateStuLog(stuLog);

        StuLog newLog=stulogService.findLogByid(logid);

        //查看其教师姓名
        int stuid=newLog.getStu_id();
        Student student=studentService.findStudentById(stuid);

        //确定有没有分配老师
        int teaid=student.getTea_id();
        if (teaid!=0){
            Teacher teacher=teacherService.findTeacherById(teaid);
            req.setAttribute("teacherName",teacher.getTea_name());
        }else {
            req.setAttribute("teacherName",null);
        }

        //确定有没有分配导师
        int empid=student.getEmp_id();
        if (empid!=0){
            Employee employee=employeeService.findAllEmployeeById(empid);
            req.setAttribute("employeeName",employee.getEmp_name());
        }else {
            req.setAttribute("employeeName",null);
        }

        int stulevelid=stuLog.getStu_level_id();

        PageBean<Student> studentPageBean=employeeService.findAllStudentsByEmpLevel(empid,stulevelid);

        req.setAttribute("stuLog",newLog);
        req.setAttribute("studentPageBean",studentPageBean);

        if (stulevelid==2){
            return "f:/encryptWeb/employee/level2/stuLogDetails.jsp";
        }else{
            return "f:/encryptWeb/employee/level3/stuLogDetails.jsp";
        }
    }

    public String deleteLogFd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int logid=Integer.parseInt(req.getParameter("logid"));
        StuLog stuLog=stulogService.findLogByid(logid);

        stuLog.setEmp_status(0);
        stuLog.setEmp_feedback(null);
        stuLog.setEmp_time(null);

        stulogService.updateStuLog(stuLog);

        StuLog newLog=stulogService.findLogByid(logid);

        //查看其导师
        int stuid=newLog.getStu_id();
        Student student=studentService.findStudentById(stuid);

        //确定有没有分配老师
        int teaid=student.getTea_id();
        if (teaid!=0){
            Teacher teacher=teacherService.findTeacherById(teaid);
            req.setAttribute("teacherName",teacher.getTea_name());
        }else {
            req.setAttribute("teacherName",null);
        }

        //确定有没有分配导师
        int empid=student.getEmp_id();
        if (empid!=0){
            Employee employee=employeeService.findAllEmployeeById(empid);
            req.setAttribute("employeeName",employee.getEmp_name());
        }else {
            req.setAttribute("employeeName",null);
        }

        int stulevelid=stuLog.getStu_level_id();

        PageBean<Student> studentPageBean=employeeService.findAllStudentsByEmpLevel(empid,stulevelid);

        req.setAttribute("stuLog",newLog);
        req.setAttribute("studentPageBean",studentPageBean);

        if (stulevelid==2){
            return "f:/encryptWeb/employee/level2/stuLogDetails.jsp";
        }else{
            return "f:/encryptWeb/employee/level3/stuLogDetails.jsp";
        }
    }

    public String toUpdateLogFd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int logid=Integer.parseInt(req.getParameter("logid"));

        StuLog newLog=stulogService.findLogByid(logid);

        //查看其教师姓名
        int stuid=newLog.getStu_id();
        Student student=studentService.findStudentById(stuid);

        //确定有没有分配老师
        int teaid=student.getTea_id();
        if (teaid!=0){
            Teacher teacher=teacherService.findTeacherById(teaid);
            req.setAttribute("teacherName",teacher.getTea_name());
        }else {
            req.setAttribute("teacherName",null);
        }

        //确定有没有分配导师
        int empid=student.getEmp_id();
        if (empid!=0){
            Employee employee=employeeService.findAllEmployeeById(empid);
            req.setAttribute("employeeName",employee.getEmp_name());
        }else {
            req.setAttribute("employeeName",null);
        }

        int stulevelid=newLog.getStu_level_id();

        PageBean<Student> studentPageBean=employeeService.findAllStudentsByEmpLevel(empid,stulevelid);

        req.setAttribute("stuLog",newLog);
        req.setAttribute("studentPageBean",studentPageBean);

        if (stulevelid==2){
            return "f:/encryptWeb/employee/level2/stuLogProfile.jsp";
        }else{
            return "f:/encryptWeb/employee/level3/stuLogProfile.jsp";
        }
    }

    public String findProjectById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int projectid=Integer.parseInt(req.getParameter("projectid"));

        Project project=projectService.findProjectById(projectid);

        //查看其导师
        int stuid=project.getStu_id();
        Student student=studentService.findStudentById(stuid);
        int empid=student.getEmp_id();

        int stulevelid=project.getStu_level_id();

        PageBean<Student> studentPageBean=employeeService.findAllStudentsByEmpLevel(empid,stulevelid);

        req.setAttribute("project",project);
        req.setAttribute("studentPageBean",studentPageBean);


        if (stulevelid==2){
            return "f:/encryptWeb/employee/level2/stuProjectDetails.jsp";
        }else{
            return "f:/encryptWeb/employee/level3/stuProjectDetails.jsp";
        }
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
