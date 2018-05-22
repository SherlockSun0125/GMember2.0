package cn.edu.hitwh.gmember.dao;

import cn.edu.hitwh.gmember.pojo.Course;
import cn.edu.hitwh.gmember.tools.PageBean;

public interface ICourseDao {
    public PageBean<Course> findCoursesByStuId(int stu_id);
    public Integer addCourse(Course course);
    public void deleteCourse(int course_id);
    public Course findCourseById(int course_id);
    public void updateCourse(Course course);

}
