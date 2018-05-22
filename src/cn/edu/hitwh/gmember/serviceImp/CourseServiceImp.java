package cn.edu.hitwh.gmember.serviceImp;

import cn.edu.hitwh.gmember.dao.ICourseDao;
import cn.edu.hitwh.gmember.daoImp.CourseDaoImp;
import cn.edu.hitwh.gmember.pojo.Course;
import cn.edu.hitwh.gmember.service.ICourseService;
import cn.edu.hitwh.gmember.tools.PageBean;

public class CourseServiceImp implements ICourseService {
    ICourseDao courseDao=new CourseDaoImp();

    @Override
    public PageBean<Course> findCoursesByStuId(int stu_id) {
        try {
            return courseDao.findCoursesByStuId(stu_id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer addCourse(Course course) {
        try{
            return courseDao.addCourse(course);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteCourse(int course_id) {
        try{
            courseDao.deleteCourse(course_id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Course findCourseById(int course_id) {
        try{
            return courseDao.findCourseById(course_id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCourse(Course course) {
        try{
            courseDao.updateCourse(course);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
