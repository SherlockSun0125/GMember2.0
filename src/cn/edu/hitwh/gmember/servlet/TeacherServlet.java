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

public class TeacherServlet extends BaseServlet {
    private ITeacherService teacherService=new TeacherServiceImp();
    private IDepartmentService departmentService=new DepartmentServiceImp();
    private IStudentService studentService=new StudentServiceImp();
    private IStulogService stulogService=new StulogServiceImp();
    private ICourseService courseService=new CourseServiceImp();
    private IProjectService projectService=new ProjectServiceImp();
    private IEmployeeService employeeService=new EmployeeServiceImp();
    private DateTools dateTools=new DateTools();
    private IResumeService resumeService=new ResumeServiceImp();


    public String teacherLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String teanum=req.getParameter("teanum");
        String teapwd=req.getParameter("teapwd");
        Teacher teacher=new Teacher();
        teacher.setTea_num(teanum);
        teacher.setTea_pwd(teapwd);
        Teacher teacherLogin=teacherService.login(teacher);

        if (teacherLogin!=null){
            req.setAttribute("msgTeacherLogin","");
            req.getSession().setAttribute("Teacher",teacherLogin);
//            resp.sendRedirect(req.getContextPath()+"/encryptWeb/teacher");
            return "r:/encryptWeb/teacher";
        }else{
            req.setAttribute("msgTeacherLogin","账号或密码错误！请重新输入！");
//            resp.sendRedirect(req.getContextPath()+"/teacherLogin.jsp");
            return "f:/teacherLogin.jsp";
        }
    }

    public String toUpdateSetting(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int teaid=Integer.parseInt(req.getParameter("teaid"));
        Teacher teacher=teacherService.findTeacherById(teaid);

        PageBean<Department> departmentPageBean=departmentService.findAllDepartments();

        req.setAttribute("departmentPageBean",departmentPageBean);

        if (teacher.getTea_sex().equals("男")){
            req.setAttribute("sex",1);
        }else {
            req.setAttribute("sex",0);
        }

        req.setAttribute("tea",teacher);

        return "f:/encryptWeb/teacher/setting.jsp";
    }

    public String updateSetting(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      id
        int teaid=Integer.parseInt(req.getParameter("teaid"));
        Teacher newteacher=teacherService.findTeacherById(teaid);

//        学号
        String teanum=req.getParameter("teanum");
        newteacher.setTea_num(teanum);
//        姓名
        String teaname=req.getParameter("teaname");
        newteacher.setTea_name(teaname);
//        性别
        int teasex=Integer.parseInt(req.getParameter("teasex"));
        if (teasex==1){
            newteacher.setTea_sex("男");
        }else{
            newteacher.setTea_sex("女");
        }
//        年龄
        int teaage=Integer.parseInt(req.getParameter("teaage"));
        newteacher.setTea_age(teaage);
//        院系
        int depid=Integer.parseInt(req.getParameter("depid"));
        newteacher.setDep_id(depid);



//        手机号
        String teaphone=req.getParameter("teaphone");
        newteacher.setTea_phone(teaphone);
//        邮箱
        String teamail=req.getParameter("teamail");
        newteacher.setTea_mail(teamail);

//        密码
        String teapwd=req.getParameter("teapwd");
        newteacher.setTea_pwd(teapwd);

//        更新数据库
        teacherService.updateTeacher(newteacher);

//        重新获取信息并返回详情页
        Teacher teacher=teacherService.findTeacherById(teaid);
        PageBean<Department> departmentPageBean=departmentService.findAllDepartments();


        req.setAttribute("departmentPageBean",departmentPageBean);

        if (teacher.getTea_sex().equals("男")){
            req.setAttribute("sex",1);
        }else {
            req.setAttribute("sex",0);
        }

        req.setAttribute("tea",teacher);
        req.setAttribute("msgUpdateSetting","个人信息更新成功！");

        return "f:/encryptWeb/teacher/setting.jsp";
    }

    //获取log列表
    public String findAllStudentsByTea(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int teaid=Integer.parseInt(req.getParameter("teaid"));
        int stulevelid=Integer.parseInt(req.getParameter("stulevelid"));
        String url=getUrl(req);
        int currentPage=getCurrentPage(req);

        PageBean<Student> studentPageBean=teacherService.findAllStudentsByTeaLevel(teaid,stulevelid);


        if (stulevelid==1){
            if(studentPageBean.getTotalRecords()==0){
                req.setAttribute("studentPageBean",null);
            }else {
                //为了找到第一个学生
                Student firstStu=studentPageBean.getBeanList().get(0);
                int stuid=firstStu.getStu_id();

                PageBean<StuLog> stuLogPageBean=stulogService.findLogsOfStudentLevel(stuid,stulevelid,currentPage);
                PageBean<Course> coursePageBean=courseService.findCoursesByStuId(stuid);
                PageBean<Project> projectPageBean=projectService.findProjectsByStuLevel(stuid,stulevelid);

                stuLogPageBean.setCurrentPage(currentPage);
                stuLogPageBean.setUrl(url);
                req.setAttribute("pb",stuLogPageBean);
                req.setAttribute("coursePageBean",coursePageBean);
                req.setAttribute("studentPageBean",studentPageBean);
                req.setAttribute("stu",firstStu);
                req.setAttribute("projectPageBean", projectPageBean);
            }
            return "f:/encryptWeb/teacher/level1/stuList.jsp";
        }else if (stulevelid==2){
            if(studentPageBean.getTotalRecords()==0){
                req.setAttribute("studentPageBean",null);
            }else {
                //为了找到第一个学生
                Student firstStu=studentPageBean.getBeanList().get(0);
                int stuid=firstStu.getStu_id();

                PageBean<StuLog> stuLogPageBean=stulogService.findLogsOfStudentLevel(stuid,stulevelid,currentPage);
                PageBean<Course> coursePageBean=courseService.findCoursesByStuId(stuid);
                PageBean<Project> projectPageBean=projectService.findProjectsByStuLevel(stuid,stulevelid);

                stuLogPageBean.setCurrentPage(currentPage);
                stuLogPageBean.setUrl(url);
                req.setAttribute("pb",stuLogPageBean);
                req.setAttribute("projectPageBean", projectPageBean);
                req.setAttribute("coursePageBean",coursePageBean);
                req.setAttribute("studentPageBean",studentPageBean);
                req.setAttribute("stu",firstStu);
            }
            return "f:/encryptWeb/teacher/level2/stuList.jsp";
        }else{
            if (studentPageBean.getTotalRecords()==0){
                req.setAttribute("studentPageBean",null);
            }else {
                //为了找到第一个学生
                Student firstStu=studentPageBean.getBeanList().get(0);
                int stuid=firstStu.getStu_id();

                PageBean<StuLog> stuLogPageBean=stulogService.findLogsOfStudentLevel(stuid,stulevelid,currentPage);
                PageBean<Project> projectPageBean=projectService.findProjectsByStuLevel(stuid,stulevelid);


                stuLogPageBean.setCurrentPage(currentPage);
                stuLogPageBean.setUrl(url);

                req.setAttribute("stuLogPageBean",stuLogPageBean);

                if (projectPageBean.getTotalRecords() == 0) {
                    req.setAttribute("project", null);
                } else {
                    Project project = projectPageBean.getBeanList().get(0);
//                System.out.println("获取到的毕设为："+project.toString());
                    req.setAttribute("project", project);
                }
            }
            return "f:/encryptWeb/teacher/level3/stuList.jsp";
        }
    }

    //获取log列表
    public String findAllStudentLevelInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int stuid=Integer.parseInt(req.getParameter("stuid"));
        int stulevelid=Integer.parseInt(req.getParameter("stulevelid"));
        int currentPage=getCurrentPage(req);
        String url=getUrl(req);

        PageBean<StuLog> stuLogPageBean=stulogService.findLogsOfStudentLevel(stuid,stulevelid,currentPage);
        PageBean<Course> coursePageBean=courseService.findCoursesByStuId(stuid);
        PageBean<Project> projectPageBean=projectService.findProjectsByStuLevel(stuid,stulevelid);

        Student student=studentService.findStudentById(stuid);
        int teaid=student.getTea_id();
        PageBean<Student> studentPageBean=teacherService.findAllStudentsByTeaLevel(teaid,stulevelid);

        stuLogPageBean.setCurrentPage(currentPage);
        stuLogPageBean.setUrl(url);

        req.setAttribute("pb",stuLogPageBean);
        req.setAttribute("coursePageBean",coursePageBean);
        req.setAttribute("studentPageBean",studentPageBean);
        req.setAttribute("stu",student);

        if (stulevelid==1){
            req.setAttribute("projectPageBean",projectPageBean);
            return "f:/encryptWeb/teacher/level1/stuList.jsp";
        }else if (stulevelid==2){
            req.setAttribute("projectPageBean",projectPageBean);
            return "f:/encryptWeb/teacher/level2/stuList.jsp";
        }else{
            if (projectPageBean.getTotalRecords()==0){
                req.setAttribute("project",null);
            }else {
                Project project=projectPageBean.getBeanList().get(0);
                System.out.println("获取到的毕设为："+project.toString());
                req.setAttribute("project",project);
            }
            return "f:/encryptWeb/teacher/level3/stuList.jsp";
        }
    }

    //获取log详情
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

        PageBean<Student> studentPageBean=teacherService.findAllStudentsByTeaLevel(teaid,stulevelid);

        req.setAttribute("stuLog",stuLog);
        req.setAttribute("studentPageBean",studentPageBean);


        if (stulevelid==1){
            return "f:/encryptWeb/teacher/level1/stuLogDetails.jsp";
        }else if (stulevelid==2){
            return "f:/encryptWeb/teacher/level2/stuLogDetails.jsp";
        }else{
            return "f:/encryptWeb/teacher/level3/stuLogDetails.jsp";
        }
    }

    //反馈
    public String feedbackLog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int logid=Integer.parseInt(req.getParameter("logid"));
//        System.out.println("日志id="+logid);
        String teaFeedback=req.getParameter("teaFeedback");
//        System.out.println("教师反馈="+teaFeedback);
        int teaStatus=Integer.parseInt(req.getParameter("teaStatus"));
//        System.out.println("评论等级="+teaStatus);

        Date date=new Date();
        String now=dateTools.date2Str(date);

        StuLog stuLog=stulogService.findLogByid(logid);

        stuLog.setTea_status(teaStatus);
        stuLog.setTea_feedback(teaFeedback);
        stuLog.setTea_time(now);

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

        PageBean<Student> studentPageBean=teacherService.findAllStudentsByTeaLevel(teaid,stulevelid);

        req.setAttribute("stuLog",newLog);
        req.setAttribute("studentPageBean",studentPageBean);

        if (stulevelid==1){
            return "f:/encryptWeb/teacher/level1/stuLogDetails.jsp";
        }else if (stulevelid==2){
            return "f:/encryptWeb/teacher/level2/stuLogDetails.jsp";
        }else{
            return "f:/encryptWeb/teacher/level3/stuLogDetails.jsp";
        }
    }

    //删除反馈
    public String deleteLogFd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int logid=Integer.parseInt(req.getParameter("logid"));
        StuLog stuLog=stulogService.findLogByid(logid);

        stuLog.setTea_status(0);
        stuLog.setTea_feedback(null);
        stuLog.setTea_time(null);

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

        PageBean<Student> studentPageBean=teacherService.findAllStudentsByTeaLevel(teaid,stulevelid);

        req.setAttribute("stuLog",newLog);
        req.setAttribute("studentPageBean",studentPageBean);

        if (stulevelid==1){
            return "f:/encryptWeb/teacher/level1/stuLogDetails.jsp";
        }else if (stulevelid==2){
            return "f:/encryptWeb/teacher/level2/stuLogDetails.jsp";
        }else{
            return "f:/encryptWeb/teacher/level3/stuLogDetails.jsp";
        }
    }

    //去更改反馈
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

        PageBean<Student> studentPageBean=teacherService.findAllStudentsByTeaLevel(teaid,stulevelid);

        req.setAttribute("stuLog",newLog);
        req.setAttribute("studentPageBean",studentPageBean);

        if (stulevelid==1){
            return "f:/encryptWeb/teacher/level1/stuLogProfile.jsp";
        }else if (stulevelid==2){
            return "f:/encryptWeb/teacher/level2/stuLogProfile.jsp";
        }else{
            return "f:/encryptWeb/teacher/level3/stuLogProfile.jsp";
        }
    }

    //更改反馈
    public String findProjectById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int projectid=Integer.parseInt(req.getParameter("projectid"));

        Project project=projectService.findProjectById(projectid);

        //查看其教师姓名
        int stuid=project.getStu_id();
        Student student=studentService.findStudentById(stuid);
        int teaid=student.getTea_id();

        int stulevelid=project.getStu_level_id();

        PageBean<Student> studentPageBean=teacherService.findAllStudentsByTeaLevel(teaid,stulevelid);

        req.setAttribute("project",project);
        req.setAttribute("studentPageBean",studentPageBean);


        if (stulevelid==1){
            return "f:/encryptWeb/teacher/level1/stuProjectDetails.jsp";
        }else if (stulevelid==2){
            return "f:/encryptWeb/teacher/level2/stuProjectDetails.jsp";
        }else{
            return "f:/encryptWeb/teacher/level3/stuProjectDetails.jsp";
        }
    }

    //查看课程详情
    public String findCourseById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int courseid=Integer.parseInt(req.getParameter("courseid"));

        Course course=courseService.findCourseById(courseid);

        //查看其教师姓名
        int stuid=course.getStu_id();
        Student student=studentService.findStudentById(stuid);
        int teaid=student.getTea_id();

        PageBean<Student> studentPageBean=teacherService.findAllStudentsByTeaLevel(teaid,1);

        req.setAttribute("course",course);
        req.setAttribute("studentPageBean",studentPageBean);


            return "f:/encryptWeb/teacher/level1/stuCourseDetails.jsp";
    }


    //获取resume列表
    public String findAllStudentsResumesByTea(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int teaid=Integer.parseInt(req.getParameter("teaid"));

        PageBean<Student> studentPageBean=teacherService.findAllStudentsByTeaLevel(teaid,4);

        if (studentPageBean.getTotalRecords()==0){
            req.setAttribute("studentPageBean", null);
        }else {
            //为了找到第一个学生
            Student firstStu = studentPageBean.getBeanList().get(0);
            int stuid = firstStu.getStu_id();

            Resume resume = resumeService.findResumeByStuId(stuid);

            req.setAttribute("studentPageBean", studentPageBean);
            req.setAttribute("stu", firstStu);
            req.setAttribute("resume", resume);
        }

        return "f:/encryptWeb/teacher/level4/stuList.jsp";

    }

    //获取resume列表
    public String findAllStudentLevelResumesInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int stuid=Integer.parseInt(req.getParameter("stuid"));

        Student student=studentService.findStudentById(stuid);
        int teaid=student.getTea_id();
        PageBean<Student> studentPageBean=teacherService.findAllStudentsByTeaLevel(teaid,4);

        Resume resume=resumeService.findResumeByStuId(stuid);

        req.setAttribute("studentPageBean",studentPageBean);
        req.setAttribute("stu",student);
        req.setAttribute("resume",resume);

        return "f:/encryptWeb/teacher/level4/stuList.jsp";

    }

    /*
    后台用
     */
    // 找到所有教师
    public String findAllTeachers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url=getUrl(req);
        int currentPage=getCurrentPage(req);
        PageBean<Teacher> pageBean=teacherService.findAllTeachers(currentPage);
        PageBean<Department> departmentPageBean=departmentService.findAllDepartments();
        pageBean.setCurrentPage(currentPage);
        pageBean.setUrl(url);
        req.setAttribute("departmentPageBean",departmentPageBean);
        req.setAttribute("pb",pageBean);
        return "f:/encryptWeb/admin/teachers.jsp";
    }

    //删除教师
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

    //中间转折一下获取id并找到该teacher的全部信息并转到teacherProfile.jsp，去更新教师信息
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

    //更新教师信息
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

    //增加教师
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

    //为了得到院系列表
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
