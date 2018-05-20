package cn.edu.hitwh.gmember.servlet;

import cn.edu.hitwh.gmember.pojo.*;
import cn.edu.hitwh.gmember.service.*;
import cn.edu.hitwh.gmember.serviceImp.*;
import cn.edu.hitwh.gmember.tools.DateTools;
import cn.edu.hitwh.gmember.tools.PageBean;
import cn.itcast.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "StudentServlet")
public class StudentServlet extends BaseServlet {
    private DateTools dateTools=new DateTools();
    private IStudentService studentService = new StudentServiceImp();
    private IDepartmentService departmentService=new DepartmentServiceImp();
    private IStulevelService stulevelService=new StulevelServiceImp();
    private IStugradeService stugradeService=new StugradeServiceImp();
    private ITeacherService teacherService=new TeacherServiceImp();
    private IEmployeeService employeeService=new EmployeeServiceImp();
    private IStulogService stulogService=new StulogServiceImp();

//    学生登录
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

//    除导师和教师之外的信息
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
        return "f:/encryptWeb/student/level1/newLog.jsp";
    }

    //    后台找到所有学生
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

//    后台根据学生阶段获得学生列表
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

//    删除学生
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

//    增加学生
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
        req.setAttribute("departmentPageBean",departmentPageBean);
        req.setAttribute("teacherPageBean",teacherPageBean);
        req.setAttribute("employeePageBean",employeePageBean);
        req.setAttribute("stuLevelPageBean",stuLevelPageBean);
        req.setAttribute("stugradePageBean",stugradePageBean);

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
        req.setAttribute("stu",stu);
        req.setAttribute("departmentPageBean",departmentPageBean);
        req.setAttribute("stuLevelPageBean",stuLevelPageBean);
        req.setAttribute("stugradePageBean",stugradePageBean);

        req.setAttribute("msgUpdateStudent","信息更新成功！");

        return "f:/encryptWeb/admin/studentProfile.jsp";
    }

    //判断是否是总的;如果levelid为空，即为总的，否则，现在该层次所有人
    private Integer getLevelid(HttpServletRequest req){
        Integer levelid=null;
        String param=req.getParameter("levelid");
        if(param!=null && !param.trim().isEmpty()){
            try{
                levelid=Integer.parseInt(param);
            }catch (RuntimeException e){
                e.printStackTrace();
            }
        }
        return levelid;
    }

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
