package cn.edu.hitwh.gmember.service;

import cn.edu.hitwh.gmember.pojo.Course;
import cn.edu.hitwh.gmember.tools.PageBean;

public interface ICourseService {
    public PageBean<Course> findCoursesByStuId(int stu_id);
}
