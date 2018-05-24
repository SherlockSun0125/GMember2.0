package cn.edu.hitwh.gmember.mapper;


import cn.edu.hitwh.gmember.pojo.Course;

import java.util.List;

public interface CourseMapper {
    public List<Course> findCoursesByStuId(int stu_id);
    public Integer addCourse(Course course);
    public void deleteCourse(int course_id);
    public Course findCourseById(int course_id);
    public void updateCourse(Course course);
    public int countCoursesByStuId(int stu_id);
}
