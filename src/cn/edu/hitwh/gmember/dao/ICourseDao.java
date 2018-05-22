package cn.edu.hitwh.gmember.dao;

import cn.edu.hitwh.gmember.pojo.Course;
import cn.edu.hitwh.gmember.tools.PageBean;

public interface ICourseDao {
    public PageBean<Course> findCoursesByStuId(int stu_id);

}
