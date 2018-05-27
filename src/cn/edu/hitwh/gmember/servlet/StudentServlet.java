package cn.edu.hitwh.gmember.servlet;

import cn.edu.hitwh.gmember.pojo.*;
import cn.edu.hitwh.gmember.service.*;
import cn.edu.hitwh.gmember.serviceImp.*;
import cn.edu.hitwh.gmember.tools.DateTools;
import cn.edu.hitwh.gmember.tools.PageBean;
import cn.itcast.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "StudentServlet")
@MultipartConfig
public class StudentServlet extends BaseServlet {
    private DateTools dateTools=new DateTools();
    private IStudentService studentService = new StudentServiceImp();
    private IDepartmentService departmentService=new DepartmentServiceImp();
    private IStulevelService stulevelService=new StulevelServiceImp();
    private IStugradeService stugradeService=new StugradeServiceImp();
    private ITeacherService teacherService=new TeacherServiceImp();
    private IEmployeeService employeeService=new EmployeeServiceImp();
    private IStulogService stulogService=new StulogServiceImp();
    private IProjectService projectService=new ProjectServiceImp();
    private ICourseService courseService=new CourseServiceImp();
    private IResumeService resumeService=new ResumeServiceImp();

    /*
    前台的函数
     */
    //学生登录
    public String studentLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stunum = request.getParameter("stunum");
        String stupwd = request.getParameter("stupwd");
        System.out.println("===" + stunum + "=====" + stupwd);
        Student student = new Student();
        student.setStu_num(stunum);
        student.setStu_pwd(stupwd);
        Student studentSql = studentService.login(student);
        if (studentSql == null) {
            request.setAttribute("msgStudentLogin", "账号或密码错误！请重新输入！");
//            response.sendRedirect(request.getContextPath()+"/studentLogin.jsp");
            return "f:/studentLogin.jsp";
        }else if(studentSql.getStu_level_id()==0){
            request.setAttribute("msgStudentLogin", "您尚未通过遴选阶段！请耐心等待！");
            return "f:/studentLogin.jsp";
        }else {
            request.setAttribute("msgStudentLogin", "");
            request.getSession().setAttribute("Student", studentSql);
//            response.sendRedirect(request.getContextPath()+"/encryptWeb/student/index.jsp");
            return "r:/encryptWeb/student/index.jsp";
        }
    }

    //申请时获得院系列表和名次列表
    public String toApply(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PageBean<Department> departmentPageBean=departmentService.findAllDepartments();
        PageBean<Stugrade> stugradePageBean=stugradeService.findAllStuGrades();
        req.setAttribute("departmentPageBean",departmentPageBean);
        req.setAttribute("stugradePageBean",stugradePageBean);
        return "f:/apply.jsp";
    }

    //除导师和教师之外的信息
    public String apply(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student newStudent=new Student();
        String url=getUrl(req);

//        学号
        String stunum=req.getParameter("stunum");
        newStudent.setStu_num(stunum);
//        姓名
        String stuname=req.getParameter("stuname");
        newStudent.setStu_name(stuname);
//        性别
        int stusex=Integer.parseInt(req.getParameter("stusex"));
//        System.out.println("性别是什么？"+stusex);
        String sex;
        if(stusex==0){
            sex="女";
        }else{
            sex="男";
        }
        newStudent.setStu_sex(sex);
//        年龄
        int stuage=Integer.parseInt(req.getParameter("stuage"));
        newStudent.setStu_age(stuage);

//        院系
        int depid=Integer.parseInt(req.getParameter("depid"));
        newStudent.setDep_id(depid);

        //专业
        String stumajor=req.getParameter("stumajor");
        newStudent.setStu_major(stumajor);

        //获得英语成绩
        String stuenglish=req.getParameter("stuenglish");
        newStudent.setStu_english(stuenglish);

        //获得成绩id
        int stugradeid=Integer.parseInt(req.getParameter("stugrade"));
        newStudent.setStu_grade_id(stugradeid);
//        手机号
        String stuphone=req.getParameter("stuphone");
        newStudent.setStu_phone(stuphone);
//        邮箱
        String stumail=req.getParameter("stumail");
        newStudent.setStu_mail(stumail);
//        备注
        String stunote=req.getParameter("stunote");
        newStudent.setStu_note(stunote);
//        密码初始化为手机号
        String stupwd=stunum;
        newStudent.setStu_pwd(stupwd);

//        设置等级为0
        newStudent.setStu_level_id(0);

//        插入数据库
        Integer stuid=studentService.addStudent(newStudent);

//        并返回增加页
        PageBean<Department> departmentPageBean=departmentService.findAllDepartments();
        PageBean<StuLevel> stuLevelPageBean=stulevelService.findAllStuLevels();
        req.setAttribute("departmentPageBean",departmentPageBean);
        req.setAttribute("stuLevelPageBean",stuLevelPageBean);

        if(stuid==null) {
            req.setAttribute("msgApply","申请提交失败，请重新申请！");
        }else{
            req.setAttribute("msgApply","申请提交成功，请耐心等待！");
        }

        return "f:/apply.jsp";
    }

    /*
    学生区
     */
    //学生写日志
    public String addLog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        StuLog newLog=new StuLog();

//        设置日志标题
        String logtitle=req.getParameter("logtitle");
        newLog.setStu_log_title(logtitle);
//        System.out.println("日志标题为："+logtitle);

//        设置日志内容
        String logcontent=req.getParameter("logcontent");
        newLog.setStu_log_content(logcontent);
//        System.out.println("日志内容为："+logcontent);

//        设置日志时间
        Date now=new Date();
        String date=dateTools.date2Str(now);
        newLog.setStu_log_time(date);

//        设置学生id
        int stuid=Integer.parseInt(req.getParameter("stuid"));
        newLog.setStu_id(stuid);

//        设置阶段id
        int stulevelid=Integer.parseInt(req.getParameter("stulevelid"));
        newLog.setStu_level_id(stulevelid);

        Integer logid=stulogService.addStuLog(newLog);

        if (logid==null){
            req.setAttribute("msgAddLog", "日志发布失败！");
        }else {
            req.setAttribute("msgAddLog", "日志发布成功！");
        }

        req.setAttribute("stuLog",newLog);

        if (stulevelid==1){
            return "f:/encryptWeb/student/level1/logDetails.jsp";
        }else if(stulevelid==2){
            return "f:/encryptWeb/student/level2/logDetails.jsp";
        }else{
            return "f:/encryptWeb/student/level3/logDetails.jsp";
        }
    }
    //学生区查看自己该阶段所写的所有日志
    public String findLogsOfStudentLevel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String url=getUrl(req);
        int currentPage=getCurrentPage(req);

        int stuid=Integer.parseInt(req.getParameter("stuid"));
        int stulevelid=Integer.parseInt(req.getParameter("stulevelid"));

        PageBean<StuLog> stuLogPageBean=stulogService.findLogsOfStudentLevel(stuid,stulevelid,currentPage);

        stuLogPageBean.setUrl(url);
        stuLogPageBean.setCurrentPage(currentPage);
        stuLogPageBean.setTotalPages(stuLogPageBean.getTotalPages());

        req.setAttribute("pb",stuLogPageBean);
        if (stulevelid==1){
            return "f:/encryptWeb/student/level1/myLog.jsp";
        }else if(stulevelid==2){
            return "f:/encryptWeb/student/level2/myLog.jsp";
        }else if(stulevelid==3){
            return "f:/encryptWeb/student/level3/myLog.jsp";
        }else{
            return "f:/encryptWeb/student/level4/myLog.jsp";
        }
    }
    //查看日志详情
    public String findLogById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int logid=Integer.parseInt(req.getParameter("logid"));
        //找到该日志
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

        req.setAttribute("stuLog",stuLog);
        int stulevelid=stuLog.getStu_level_id();

        if (stulevelid==1){
            return "f:/encryptWeb/student/level1/logDetails.jsp";
        }else if(stulevelid==2){
            return "f:/encryptWeb/student/level2/logDetails.jsp";
        }else{
            return "f:/encryptWeb/student/level3/logDetails.jsp";
        }
    }

    //学生编辑日志的一个中间跳转
    public String toUpdateLog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int logid=Integer.parseInt(req.getParameter("logid"));
        StuLog stuLog=stulogService.findLogByid(logid);

        req.setAttribute("stuLog",stuLog);
        int stulevelid=stuLog.getStu_level_id();

        if (stulevelid==1){
            return "f:/encryptWeb/student/level1/logProfile.jsp";
        }else if(stulevelid==2){
            return "f:/encryptWeb/student/level2/logProfile.jsp";
        }else{
            return "f:/encryptWeb/student/level3/logProfile.jsp";
        }
    }
    //修改日志
    public String updateLog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int logid=Integer.parseInt(req.getParameter("logid"));
        StuLog newlog=stulogService.findLogByid(logid);

        String logtitle= req.getParameter("logtitle");
        String logcontent=req.getParameter("logcontent");
        Date changeTime=new Date();

        newlog.setStu_log_title(logtitle);
        newlog.setStu_log_content(logcontent);
        newlog.setStu_log_lastchange(dateTools.date2Str(changeTime));

        stulogService.updateStuLog(newlog);

        //再次找到该日志并回显
        StuLog stuLog=stulogService.findLogByid(logid);
        //查看其教师姓名和导师姓名
        int stuid=stuLog.getStu_id();
        Student student=studentService.findStudentById(stuid);
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

        req.setAttribute("stuLog",stuLog);
        req.setAttribute("msgUpdateLog","日志更新成功！");
        int stulevelid=stuLog.getStu_level_id();
        if (stulevelid==1){
            return "f:/encryptWeb/student/level1/logDetails.jsp";
        }else if(stulevelid==2){
            return "f:/encryptWeb/student/level2/logDetails.jsp";
        }else{
            return "f:/encryptWeb/student/level3/logDetails.jsp";
        }
    }

    //删除日志
    public String deleteLog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int logid=Integer.parseInt(req.getParameter("logid"));
        StuLog stuLog=stulogService.findLogByid(logid);
        String logname=stuLog.getStu_log_title();

        String url=getUrl(req);
        int currentPage=getCurrentPage(req);
        int stuid=Integer.parseInt(req.getParameter("stuid"));
        int stulevelid=Integer.parseInt(req.getParameter("stulevelid"));

        stulogService.deleteStuLog(logid);

        PageBean<StuLog> stuLogPageBean=stulogService.findLogsOfStudentLevel(stuid,stulevelid,currentPage);

        stuLogPageBean.setUrl(url);
        stuLogPageBean.setCurrentPage(currentPage);
        stuLogPageBean.setTotalPages(stuLogPageBean.getTotalPages());

        req.setAttribute("pb",stuLogPageBean);
        req.setAttribute("msgDeleteLog","日志\""+logname+"\"已删除！");

        if (stulevelid==1){
            return "f:/encryptWeb/student/level1/myLog.jsp";
        }else if(stulevelid==2){
            return "f:/encryptWeb/student/level2/myLog.jsp";
        }else{
            return "f:/encryptWeb/student/level3/myLog.jsp";
        }
    }

    //查看某生某阶段所有项项目
    public String findProjectsByStuLevel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int stu_id=Integer.parseInt(req.getParameter("stuid"));
        int stu_level_id=Integer.parseInt(req.getParameter("stulevelid"));

        PageBean<Project> projectPageBean=projectService.findProjectsByStuLevel(stu_id,stu_level_id);

        if (stu_level_id==1){
            req.setAttribute("projectPageBean",projectPageBean);
            return "f:/encryptWeb/student/level1/myProject.jsp";
        }else if(stu_level_id==2){
            req.setAttribute("projectPageBean",projectPageBean);
            return "f:/encryptWeb/student/level2/myProject.jsp";
        }else{//第三阶段只能有一个项目
            if (projectPageBean.getTotalRecords()==0){
                req.setAttribute("project",null);
            }else {
                Project project = projectPageBean.getBeanList().get(0);
                req.setAttribute("project", project);
            }
            return "f:/encryptWeb/student/level3/myProject.jsp";
        }
    }
    //查看项目详情
    public String findProjectById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int projectid=Integer.parseInt(req.getParameter("projectid"));

        Project project=projectService.findProjectById(projectid);

        int stu_level_id=project.getStu_level_id();

        req.setAttribute("project",project);

        if (stu_level_id==1){
            return "f:/encryptWeb/student/level1/projectDetails.jsp";
        }else if(stu_level_id==2){
            return "f:/encryptWeb/student/level2/projectDetails.jsp";
        }else{
            return "f:/encryptWeb/student/level3/projectDetails.jsp";
        }
    }

    //去更新项目
    public String toUpdateProject(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int projectid=Integer.parseInt(req.getParameter("projectid"));
        //找到该项目
        Project project=projectService.findProjectById(projectid);
        int stulevelid=project.getStu_level_id();

        req.setAttribute("project",project);
        if (stulevelid==1){
            return "f:/encryptWeb/student/level1/projectProfile.jsp";
        }else if(stulevelid==2){
            return "f:/encryptWeb/student/level2/projectProfile.jsp";
        }else{
            return "f:/encryptWeb/student/level3/projectProfile.jsp";
        }
    }

    //更新项目
    public String updateProject(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int projectid=Integer.parseInt(req.getParameter("projectid"));
        //找到该项目
        Project project=projectService.findProjectById(projectid);

        //获取网页信息
        String projectName=req.getParameter("projectName");
        String projectCourse=req.getParameter("projectCourse");
        String projectTeacher=req.getParameter("projectTeacher");
        String projectStartTime=req.getParameter("projectStartTime");
        String projectStopTime=req.getParameter("projectStopTime");
        String projectPlace=req.getParameter("projectPlace");
        String projectMember=req.getParameter("projectMember");
        String projectAbout=req.getParameter("projectAbout");

        if (project.getStu_level_id()!=3){
            String startPaper=req.getParameter("startPaper");
            String midPaper=req.getParameter("midPaper");
            String endPaper=req.getParameter("endPaper");

            project.setStart_paper(startPaper);
            project.setMid_paper(midPaper);
            project.setEnd_paper(endPaper);
        }else{
            project.setStart_paper(project.getStart_paper());
            project.setMid_paper(project.getMid_paper());
            project.setEnd_paper(project.getEnd_paper());
        }

//        System.out.println("来自servlet层的问候1："+project.toString());

        //更新项目信息
        project.setProject_name(projectName);
        project.setCourse(projectCourse);
        project.setTeacher(projectTeacher);
        project.setProject_start_time(projectStartTime);
        project.setProject_stop_time(projectStopTime);
        project.setProject_place(projectPlace);
        project.setProject_member(projectMember);
        project.setProject_about(projectAbout);

//        System.out.println("来自servlet层的问候2："+project.toString());

        projectService.updateProject(project);

        req.setAttribute("project",project);

        int stulevelid=project.getStu_level_id();
        req.setAttribute("msgUpdateProject","项目信息更新成功！");
        if (stulevelid==1){
            return "f:/encryptWeb/student/level1/projectDetails.jsp";
        }else if(stulevelid==2){
            return "f:/encryptWeb/student/level2/projectDetails.jsp";
        }else{
            return "f:/encryptWeb/student/level3/myProject.jsp";
        }
    }

    //删除项目
    public String deleteProject(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int projectid=Integer.parseInt(req.getParameter("projectid"));

        Project project=projectService.findProjectById(projectid);
        int stulevelid=project.getStu_level_id();
        String projectname=project.getProject_name();

        projectService.deleteProject(projectid);

        req.setAttribute("msgDeleteProject","项目\""+projectname+"\"删除成功！");
        if (stulevelid==1){
            return "f:/encryptWeb/student/level1/myProject.jsp";
        }else if(stulevelid==2){
            return "f:/encryptWeb/student/level2/myProject.jsp";
        }else{
            return "f:/encryptWeb/student/level3/myProject.jsp";
        }
    }

    //增加项目
    public String addProject(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int stuid=Integer.parseInt(req.getParameter("stuid"));
        int stulevelid=Integer.parseInt(req.getParameter("stulevelid"));

        Project project=new Project();
        //获取网页信息
        String projectName=req.getParameter("projectName");
        String projectCourse=req.getParameter("projectCourse");
        String projectTeacher=req.getParameter("projectTeacher");
        String projectStartTime=req.getParameter("projectStartTime");
        String projectStopTime=req.getParameter("projectStopTime");
        String projectPlace=req.getParameter("projectPlace");
        String projectMember=req.getParameter("projectMember");
        String projectAbout=req.getParameter("projectAbout");

        System.out.println("来自servlet层的问候1："+project.toString());

        //设置项目信息
        project.setProject_name(projectName);
        project.setCourse(projectCourse);
        project.setTeacher(projectTeacher);
        project.setProject_start_time(projectStartTime);
        project.setProject_stop_time(projectStopTime);
        project.setProject_place(projectPlace);
        project.setProject_member(projectMember);
        project.setProject_about(projectAbout);

        project.setStu_id(stuid);
        project.setStu_level_id(stulevelid);


        projectService.addProject(project);

        req.setAttribute("project",project);

        req.setAttribute("msgAddProject","项目增加成功！");
        if (stulevelid==1){
            return "f:/encryptWeb/student/level1/projectDetails.jsp";
        }else if(stulevelid==2){
            return "f:/encryptWeb/student/level2/projectDetails.jsp";
        }else{
            return "f:/encryptWeb/student/level3/myProject.jsp";
        }
    }

    //第三阶段上传文件
    public String uploadFile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int projectid=Integer.parseInt(req.getParameter("projectid"));
        String projectlevel=req.getParameter("projectlevel");

        try {
            Project project=projectService.findProjectById(projectid);
            Student student=studentService.findStudentById(project.getStu_id());
            //获取文件描述信息
//            String desc=req.getParameter("fileDesc");
            //获取上传的文件
            Part part=req.getPart(projectlevel+"Paper");
            //获取请求的信息
            String name=part.getHeader("content-disposition");
            System.out.println(name);//测试使用
//            System.out.println(desc);//

            //获取上传文件的目录
//            String root=req.getContextPath()+("/upload");
            String root=req.getServletContext().getRealPath("/upload");
            System.out.println("测试上传文件的路径："+root);

            //获取文件的后缀
            String str=name.substring(name.lastIndexOf("."), name.length()-1);
            System.out.println("测试获取文件的后缀："+str);

            //生成一个新的文件名，不重复，数据库存储的就是这个文件名，不重复的
//            String fname= UUID.randomUUID().toString()+str;
            Date date=new Date();
            DateTools dateTools=new DateTools();
            String fname="";

            if (projectlevel.equals("start")) {
                fname= student.getStu_id() + "-" + project.getProject_name() +"-开题报告-"+ dateTools.date2Str2(date) + str;
                //将路径存入数据库
                project.setStart_paper(fname);
            }else if (projectlevel.equals("mid")){
                fname = student.getStu_id() + "-" + project.getProject_name()+"-中期报告-" + dateTools.date2Str2(date) + str;
                //将路径存入数据库
                project.setMid_paper(fname);
            }else {
                fname = student.getStu_id() + "-" + project.getProject_name()+"-终期报告-"+ dateTools.date2Str2(date) + str;
                //将路径存入数据库
                project.setEnd_paper(fname);
            }

            String filename=root+"\\"+fname;
            System.out.println("测试产生新的文件名："+filename);

            //上传文件到指定目录，不想上传文件就不调用这个
            part.write(filename);

            projectService.updateProject(project);

            req.setAttribute("msgUploadFile"+projectlevel, "上传文件成功");

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("msgUploadFile"+projectlevel, "上传文件失败");
        }

        Project newProject=projectService.findProjectById(projectid);
        req.setAttribute("project",newProject);

        return "f:/encryptWeb/student/level3/myProject.jsp";
    }


    //查看某生某阶段所有项目
    public String findCoursesByStuId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int stu_id=Integer.parseInt(req.getParameter("stuid"));
        PageBean<Course> coursePageBean=new PageBean<Course>();
        coursePageBean=courseService.findCoursesByStuId(stu_id);

        req.setAttribute("coursePageBean",coursePageBean);

        return "f:/encryptWeb/student/level1/myCourse.jsp";
    }
    //查看课程详情
    public String findCourseById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int courseid=Integer.parseInt(req.getParameter("courseid"));

        Course course=courseService.findCourseById(courseid);

        req.setAttribute("course",course);

        return "f:/encryptWeb/student/level1/courseDetails.jsp";
    }

    //更新课程
    public String toUpdateCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //找到该项目
        int courseid=Integer.parseInt(req.getParameter("courseid"));

        Course course=courseService.findCourseById(courseid);

        req.setAttribute("course",course);
        return "f:/encryptWeb/student/level1/courseProfile.jsp";
    }

    //更新课程
    public String updateCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int courseid=Integer.parseInt(req.getParameter("courseid"));

        Course course=courseService.findCourseById(courseid);

        //获取网页信息,12
        String courseNum=req.getParameter("courseNum");
        String courseSeq=req.getParameter("courseSeq");
        String courseName=req.getParameter("courseName");
        String courseType=req.getParameter("courseType");
        String examType=req.getParameter("examType");
        String coursePlace=req.getParameter("coursePlace");
        String courseTime=req.getParameter("courseTime");
        String courseWeeks=req.getParameter("courseWeeks");
        String examTime=req.getParameter("examTime");
        String examGrade=req.getParameter("examGrade");
        String teacher=req.getParameter("teacher");
        String courseAbout=req.getParameter("courseAbout");

        int isEnd;
        if (examGrade.equals(null)){
            isEnd=0;
        }else {
            isEnd=1;
        }


        //设置项目信息13
        course.setCourse_num(courseNum);
        course.setCourse_seq(courseSeq);
        course.setCourse_name(courseName);
        course.setCourse_type(courseType);
        course.setExam_type(examType);
        course.setCourse_place(coursePlace);
        course.setCourse_time(courseTime);
        course.setCourse_weeks(courseWeeks);
        course.setExam_time(examTime);
        course.setExam_grade(examGrade);
        course.setTeacher(teacher);
        course.setCourse_about(courseAbout);
        course.setIsEnd(isEnd);

        courseService.updateCourse(course);

        System.out.println("来自servlet层的问候1："+course.toString());

        req.setAttribute("course",course);

        req.setAttribute("msgAddProject","项目增加成功！");
        return "f:/encryptWeb/student/level1/courseDetails.jsp";
    }

    //删除课程
    public String deleteCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int courseid=Integer.parseInt(req.getParameter("courseid"));

        Course course=courseService.findCourseById(courseid);
        String coursename=course.getCourse_name();
        int stuid=course.getStu_id();

        courseService.deleteCourse(courseid);

        PageBean<Course> coursePageBean=new PageBean<Course>();
        coursePageBean=courseService.findCoursesByStuId(stuid);

        req.setAttribute("coursePageBean",coursePageBean);
        req.setAttribute("msgDeleteCourse","课程\""+coursename+"\"删除成功！");

        return "f:/encryptWeb/student/level1/myCourse.jsp";
    }

    //增加课程
    public String addCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int stuid=Integer.parseInt(req.getParameter("stuid"));

        System.out.println("看这里看这里stuid="+stuid);
        Course course=new Course();
        //获取网页信息
        String courseNum=req.getParameter("courseNum");
        String courseSeq=req.getParameter("courseSeq");
        String courseName=req.getParameter("courseName");
        String courseType=req.getParameter("courseType");
        String examType=req.getParameter("examType");
        String coursePlace=req.getParameter("coursePlace");
        String courseTime=req.getParameter("courseTime");
        String courseWeeks=req.getParameter("courseWeeks");
        String examTime=req.getParameter("examTime");
        String examGrade=req.getParameter("examGrade");
        String teacher=req.getParameter("teacher");
        String courseAbout=req.getParameter("courseAbout");
        int isEnd=0;

        //设置项目信息,14项
        course.setStu_id(stuid);
        course.setCourse_num(courseNum);
        course.setCourse_seq(courseSeq);
        course.setCourse_name(courseName);
        course.setCourse_type(courseType);
        course.setExam_type(examType);
        course.setCourse_place(coursePlace);
        course.setCourse_time(courseTime);
        course.setCourse_weeks(courseWeeks);
        course.setExam_time(examTime);
        course.setExam_grade(examGrade);
        course.setTeacher(teacher);
        course.setCourse_about(courseAbout);
        course.setIsEnd(isEnd);

        System.out.println("来自servlet层的问候1："+course.toString());

        courseService.addCourse(course);
        req.setAttribute("course",course);

        req.setAttribute("msgAddProject","项目增加成功！");
        return "f:/encryptWeb/student/level1/courseDetails.jsp";
    }

    //按照学生id查看简历
    public String findResumeByStuId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int stuid=Integer.parseInt(req.getParameter("stuid"));
        Resume resume=resumeService.findResumeByStuId(stuid);
        if (resume == null){
            req.setAttribute("resume",null);
        }else {
            req.setAttribute("resume",resume);
        }

        return "f:/encryptWeb/student/level4/myResume.jsp";
    }


    //上传简历
    public String addResume(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int stuid=Integer.parseInt(req.getParameter("stuid"));
        Resume resume=new Resume();
        Integer resumeid=null;

        try {
            Student student=studentService.findStudentById(stuid);
            resume.setStu_id(stuid);
            //获取文件描述信息
//            String desc=req.getParameter("fileDesc");
            //获取上传的文件
            Part part=req.getPart("resume");
            //获取请求的信息
            String name=part.getHeader("content-disposition");
            System.out.println(name);//测试使用
//            System.out.println(desc);//

            //获取上传文件的目录
//            String root=req.getContextPath()+("/upload");
            String root=req.getServletContext().getRealPath("/upload");
            System.out.println("测试上传文件的路径："+root);

            //获取文件的后缀
            String str=name.substring(name.lastIndexOf("."), name.length()-1);
            System.out.println("测试获取文件的后缀："+str);

            //生成一个新的文件名，不重复，数据库存储的就是这个文件名，不重复的
//            String fname= UUID.randomUUID().toString()+str;
            Date date=new Date();
            DateTools dateTools=new DateTools();
            String fname="";

            fname= student.getStu_id() + "-" + student.getStu_name()+"-个人简历-"+ dateTools.date2Str2(date) + str;
            //将路径存入数据库
            resume.setResume_path(fname);


            String filename=root+"\\"+fname;
            System.out.println("测试产生新的文件名："+filename);

            //上传文件到指定目录，不想上传文件就不调用这个
            part.write(filename);

            resumeid=resumeService.addResume(resume);
            if (resumeid==null){
                req.setAttribute("msgAddResume", "上传文件失败");
            }else{
                req.setAttribute("msgAddResume", "上传文件成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("msgAddResume", "上传文件失败");
        }

        Resume newResume=resumeService.findResumeById(resumeid);
        req.setAttribute("resume",newResume);

        return "f:/encryptWeb/student/level4/myResume.jsp";
    }

    //重传简历
    public String updateResume(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int resumeid=Integer.parseInt(req.getParameter("resumeid"));
        Resume resume=resumeService.findResumeById(resumeid);
        int stuid=resume.getStu_id();
        Student student=studentService.findStudentById(stuid);

        try {
            //获取文件描述信息
//            String desc=req.getParameter("fileDesc");
            //获取上传的文件
            Part part=req.getPart("resume");
            //获取请求的信息
            String name=part.getHeader("content-disposition");
            System.out.println(name);//测试使用
//            System.out.println(desc);//

            //获取上传文件的目录
//            String root=req.getContextPath()+("/upload");
            String root=req.getServletContext().getRealPath("/upload");
            System.out.println("测试上传文件的路径："+root);

            //获取文件的后缀
            String str=name.substring(name.lastIndexOf("."), name.length()-1);
            System.out.println("测试获取文件的后缀："+str);

            //生成一个新的文件名，不重复，数据库存储的就是这个文件名，不重复的
//            String fname= UUID.randomUUID().toString()+str;
            Date date=new Date();
            DateTools dateTools=new DateTools();
            String fname="";

            fname= student.getStu_id() + "-" + student.getStu_name()+"-个人简历-"+ dateTools.date2Str2(date) + str;
            //将路径存入数据库
            resume.setResume_path(fname);


            String filename=root+"\\"+fname;
            System.out.println("测试产生新的文件名："+filename);

            //上传文件到指定目录，不想上传文件就不调用这个
            part.write(filename);

            resumeService.updateResume(resume);

            req.setAttribute("msgAddResume", "上传文件成功");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("msgAddResume", "上传文件失败");
        }

        Resume newResume=resumeService.findResumeById(resumeid);
        req.setAttribute("resume",newResume);

        return "f:/encryptWeb/student/level4/myResume.jsp";
    }


    /*
    后台方法
     */
    //后台找到所有学生
    public String findAllStudents(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currentPage=getCurrentPage(req);
        String url=getUrl(req);
        PageBean<Student> pageBean=studentService.findAllStudents(currentPage);
        PageBean<Department> departmentPageBean=departmentService.findAllDepartments();
        PageBean<Teacher> teacherPageBean=teacherService.findAllTeacherDetail();
        PageBean<Employee> employeePageBean=employeeService.findAllEmployeeDetail();
        PageBean<StuLevel> stuLevelPageBean=stulevelService.findAllStuLevels();

        pageBean.setUrl(url);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPages(pageBean.getTotalPages());
        req.setAttribute("pb",pageBean);
        req.setAttribute("departmentPageBean",departmentPageBean);
        req.setAttribute("teacherPageBean",teacherPageBean);
        req.setAttribute("employeePageBean",employeePageBean);
        req.setAttribute("stuLevelPageBean",stuLevelPageBean);
        return "f:/encryptWeb/admin/students.jsp";
    }

    //中间转折一下获取id并找到该student的全部信息并转到studentProfile.jsp
    public String findStudentById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int stu_id=Integer.parseInt(req.getParameter("studentid"));
        Student stu=studentService.findStudentById(stu_id);
        req.setAttribute("stu",stu);

        return "f:/encryptWeb/admin/studentProfile.jsp";
    }

    //后台根据学生阶段获得学生列表
    public String findStudentsByLevel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url=getUrl(req);
        int currentPage=getCurrentPage(req);
        int levelid=Integer.parseInt(req.getParameter("levelid"));
        PageBean<Student> pageBean=studentService.findStudentsByLevel(levelid,currentPage);
        PageBean<Department> departmentPageBean=departmentService.findAllDepartments();
        PageBean<Teacher> teacherPageBean=teacherService.findAllTeacherDetail();
        PageBean<Employee> employeePageBean=employeeService.findAllEmployeeDetail();
        PageBean<StuLevel> stuLevelPageBean=stulevelService.findAllStuLevels();

        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPages(pageBean.getTotalPages());
        pageBean.setUrl(url);
        req.setAttribute("pb",pageBean);
        req.setAttribute("departmentPageBean",departmentPageBean);
        req.setAttribute("teacherPageBean",teacherPageBean);
        req.setAttribute("employeePageBean",employeePageBean);
        req.setAttribute("stuLevelPageBean",stuLevelPageBean);
        return "f:/encryptWeb/admin/students.jsp";
    }

    //删除学生
    public String deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url=getUrl(req);
        int currentPage=getCurrentPage(req);
        System.out.println("网页url="+url);
        int studentid=Integer.parseInt(req.getParameter("studentid"));
        String studentname=req.getParameter("studentname");
        studentService.deleteStudent(studentid);
        PageBean<Student> pageBean=new PageBean<Student>();
        pageBean= studentService.findAllStudents(currentPage);
        req.setAttribute("pb",pageBean);
        req.setAttribute("msgDeleteStudent",studentname+"同学已从系统删除。");
        return "f:/encryptWeb/admin/students.jsp";
    }

    //获得院系列表和阶段列表
    public String toAddStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PageBean<Department> departmentPageBean=departmentService.findAllDepartments();
        PageBean<Stugrade> stugradePageBean=stugradeService.findAllStuGrades();
        req.setAttribute("departmentPageBean",departmentPageBean);
        req.setAttribute("stugradePageBean",stugradePageBean);
        return "f:/encryptWeb/admin/addStudent.jsp";
    }

    //后台显示学生资料用
    public String adminFindStudentById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int stu_id=Integer.parseInt(req.getParameter("studentid"));
        Student stu=studentService.findStudentById(stu_id);

        PageBean<Department> departmentPageBean=departmentService.findAllDepartments();
        PageBean<Teacher> teacherPageBean=teacherService.findAllTeacherDetail();
        PageBean<Employee> employeePageBean=employeeService.findAllEmployeeDetail();
        PageBean<StuLevel> stuLevelPageBean=stulevelService.findAllStuLevels();
        PageBean<Stugrade> stugradePageBean=stugradeService.findAllStuGrades();
        req.setAttribute("departmentPageBean",departmentPageBean);
        req.setAttribute("teacherPageBean",teacherPageBean);
        req.setAttribute("employeePageBean",employeePageBean);
        req.setAttribute("stuLevelPageBean",stuLevelPageBean);
        req.setAttribute("stugradePageBean",stugradePageBean);

        req.setAttribute("stu",stu);
        return "f:/encryptWeb/admin/studentDetail.jsp";
    }

    //增加学生
    public String addStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student newStudent=new Student();
        String url=getUrl(req);
//        System.out.println("网页url="+url);

//        学号
        String stunum=req.getParameter("stunum");
        newStudent.setStu_num(stunum);
        System.out.println("学生num="+stunum);
//        姓名
        String stuname=req.getParameter("stuname");
        newStudent.setStu_name(stuname);
        System.out.println("学生name="+stuname);
//        性别
        String stusex=req.getParameter("stusex");
        newStudent.setStu_sex(stusex);
        System.out.println("学生sex="+stusex);
//        年龄
        int stuage=Integer.parseInt(req.getParameter("stuage"));
        newStudent.setStu_age(stuage);
        System.out.println("学生age="+stuage);
//        院系
        int depid=Integer.parseInt(req.getParameter("depid"));
        newStudent.setDep_id(depid);
//        System.out.println("学生depid="+depid);

        //专业
        String stumajor=req.getParameter("stumajor");
        newStudent.setStu_major(stumajor);

//        所处阶段
        int stulevelid=Integer.parseInt(req.getParameter("stulevelid"));
        newStudent.setStu_level_id(stulevelid);
        System.out.println("学生levelid="+stulevelid);

        //获得英语成绩
        String stuenglish=req.getParameter("stuenglish");
        newStudent.setStu_english(stuenglish);

        //获得成绩id
        int stugradeid=Integer.parseInt(req.getParameter("stugrade"));
        newStudent.setStu_grade_id(stugradeid);
//        手机号
        String stuphone=req.getParameter("stuphone");
        newStudent.setStu_phone(stuphone);
        System.out.println("学生phone="+stuphone);
//        邮箱
        String stumail=req.getParameter("stumail");
        newStudent.setStu_mail(stumail);
        System.out.println("学生mail="+stumail);
//        备注
        String stunote=req.getParameter("stunote");
        newStudent.setStu_note(stunote);
        System.out.println("学生note="+stunote);
//        密码
        String stupwd=stuphone;
        newStudent.setStu_pwd(stupwd);
        System.out.println("学生pwd="+stupwd);


//        插入数据库
        Integer stuid=studentService.addStudent(newStudent);

//        并返回增加页
        PageBean<Department> departmentPageBean=departmentService.findAllDepartments();
        PageBean<StuLevel> stuLevelPageBean=stulevelService.findAllStuLevels();
        req.setAttribute("departmentPageBean",departmentPageBean);
        req.setAttribute("stuLevelPageBean",stuLevelPageBean);

        if(stuid==null) {
            req.setAttribute("msgAddStudent","学生添加失败！");
        }else{
            req.setAttribute("msgAddStudent","学生添加成功！");
        }

        return "f:/encryptWeb/admin/addStudent.jsp";
    }

    //用于从学生详情页装置修改信息页，获取id
    public String toUpdateStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int studentid=Integer.parseInt(req.getParameter("studentid"));
        Student student=studentService.findStudentById(studentid);

        PageBean<Department> departmentPageBean=departmentService.findAllDepartments();
        PageBean<Teacher> teacherPageBean=teacherService.findAllTeacherDetail();
        PageBean<Employee> employeePageBean=employeeService.findAllEmployeeDetail();
        PageBean<StuLevel> stuLevelPageBean=stulevelService.findAllStuLevels();
        PageBean<Stugrade> stugradePageBean=stugradeService.findAllStuGrades();
        PageBean<Teacher> teacherPageBean1=teacherService.findAllTeachersByDep(student.getDep_id());

        req.setAttribute("departmentPageBean",departmentPageBean);
        req.setAttribute("teacherPageBean",teacherPageBean);
        req.setAttribute("employeePageBean",employeePageBean);
        req.setAttribute("stuLevelPageBean",stuLevelPageBean);
        req.setAttribute("stugradePageBean",stugradePageBean);
        req.setAttribute("teacherPageBean1",teacherPageBean1);
        req.setAttribute("employeePageBean",employeePageBean);

        req.setAttribute("stu",student);
        return "f:/encryptWeb/admin/studentProfile.jsp";
    }

    //在studentProfile.jsp页面更新信息
    public String updateStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url=getUrl(req);
//        System.out.println("网页url="+url);
//      学生id
        int stuid=Integer.parseInt(req.getParameter("studentid"));
//        System.out.println("学生id="+stuid);

        Student newStudent=studentService.findStudentById(stuid);
//        学号
        String stunum=req.getParameter("stunum");
        newStudent.setStu_num(stunum);
//        System.out.println("学生num="+stunum);
//        姓名
        String stuname=req.getParameter("stuname");
        newStudent.setStu_name(stuname);
//        System.out.println("学生name="+stuname);
//        性别
        String stusex=req.getParameter("stusex");
        newStudent.setStu_sex(stusex);
//        System.out.println("学生sex="+stusex);
//        年龄
        int stuage=Integer.parseInt(req.getParameter("stuage"));
        newStudent.setStu_age(stuage);
//        System.out.println("学生age="+stuage);
//        院系
        int depid=Integer.parseInt(req.getParameter("depid"));
        newStudent.setDep_id(depid);
//        System.out.println("学生depid="+depid);

        //专业
        String stumajor=req.getParameter("stumajor");
        newStudent.setStu_major(stumajor);

//        所处阶段
        int stulevelid=Integer.parseInt(req.getParameter("stulevelid"));
        newStudent.setStu_level_id(stulevelid);
//        System.out.println("学生levelid="+stulevelid);

        int teaid=Integer.parseInt(req.getParameter("teaid"));
        newStudent.setTea_id(teaid);
        int empid=Integer.parseInt(req.getParameter("empid"));
        newStudent.setEmp_id(empid);

        //获得英语成绩
        String stuenglish=req.getParameter("stuenglish");
        newStudent.setStu_english(stuenglish);

        //获得成绩id
        int stugradeid=Integer.parseInt(req.getParameter("stugrade"));
        newStudent.setStu_grade_id(stugradeid);

//        手机号
        String stuphone=req.getParameter("stuphone");
        newStudent.setStu_phone(stuphone);
//        System.out.println("学生phone="+stuphone);
//        邮箱
        String stumail=req.getParameter("stumail");
        newStudent.setStu_mail(stumail);
//        System.out.println("学生mail="+stumail);
//        备注
        String stunote=req.getParameter("stunote");
        newStudent.setStu_note(stunote);
//        System.out.println("学生note="+stunote);
//        密码
        String stupwd=req.getParameter("stupwd");
        newStudent.setStu_pwd(stupwd);
//        System.out.println("学生pwd="+stupwd);


//        更新数据库
        studentService.updateStudent(newStudent);

//        重新获取信息并返回详情页
        Student stu=studentService.findStudentById(stuid);
        PageBean<Department> departmentPageBean=departmentService.findAllDepartments();
        PageBean<StuLevel> stuLevelPageBean=stulevelService.findAllStuLevels();
        PageBean<Stugrade> stugradePageBean=stugradeService.findAllStuGrades();
        PageBean<Teacher> teacherPageBean1=teacherService.findAllTeachersByDep(depid);
        PageBean<Employee> employeePageBean=employeeService.findAllEmployeeDetail();

        req.setAttribute("stu",stu);
        req.setAttribute("departmentPageBean",departmentPageBean);
        req.setAttribute("stuLevelPageBean",stuLevelPageBean);
        req.setAttribute("stugradePageBean",stugradePageBean);
        req.setAttribute("teacherPageBean1",teacherPageBean1);
        req.setAttribute("employeePageBean",employeePageBean);

        req.setAttribute("msgUpdateStudent","信息更新成功！");

        return "f:/encryptWeb/admin/studentProfile.jsp";
    }


    /*
    公用方法
     */
    //得到当前页
    private int getCurrentPage(HttpServletRequest req){
        int currentPage=1;
        String param=req.getParameter("currentPage");
        if(param!=null && !param.trim().isEmpty()){
            try{
                currentPage=Integer.parseInt(param);
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
