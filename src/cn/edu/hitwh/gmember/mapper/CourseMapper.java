package cn.edu.hitwh.gmember.mapper;


import cn.edu.hitwh.gmember.pojo.Course;

import java.util.List;

public interface CourseMapper {
    public List<Course> findCoursesByStuId(int stu_id);

}
