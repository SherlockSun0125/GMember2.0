import cn.edu.hitwh.gmember.dao.ICourseDao;
import cn.edu.hitwh.gmember.pojo.Course;
import cn.edu.hitwh.gmember.service.ICourseService;
import cn.edu.hitwh.gmember.serviceImp.CourseServiceImp;
import cn.edu.hitwh.gmember.tools.PageBean;

import java.util.List;

public class MyCourseTest {
    public static void main(String[] args) {
        ICourseService courseService=new CourseServiceImp();

//        修改
        Course course=new Course();
        course=courseService.findCourseById(8002);
//        course.setExam_grade();
        courseService.updateCourse(course);


//        查找
//        String detail=courseService.findCourseById(8001).toString();
//        System.out.println("8001号课程的详细信息为："+detail);

//        删除
//        courseService.deleteCourse(8004);



//        增加
//        Course course=new Course();
//        course.setCourse_name("计算机网络");
//        course.setCourse_num("SC04100910");
//        course.setCourse_seq(0);
//        course.setCourse_place("M403");
//        course.setCourse_type("必修");
//        course.setCourse_weeks("6-16周");
//        course.setExam_type("考试");
//        course.setExam_time("18周周四上午十点");
//        course.setStu_id(1002);
//        course.setTeacher("刘洋");
//
//        Integer id=courseService.addCourse(course);
//        if(id==null) {
//            System.out.println("+++++++失败+++++++");
//        }else{
//            System.out.println("++++++++++++++id=" + id);
//        }



//        查找
//        PageBean<Course> coursePageBean=new PageBean<Course>();
//        coursePageBean=courseService.findCoursesByStuId(1002);
//
//        List<Course> courses=coursePageBean.getBeanList();
//
//        for (int i=0;i<courses.size();i++){
//            System.out.println("第"+i+"个课程为："+courses.get(i));
//        }
    }
}
