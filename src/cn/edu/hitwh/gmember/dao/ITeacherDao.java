package cn.edu.hitwh.gmember.dao;

import cn.edu.hitwh.gmember.pojo.Teacher;
import cn.edu.hitwh.gmember.tools.PageBean;

public interface ITeacherDao {
    public Teacher findTeacher(String id,String pwd);
    public PageBean<Teacher> findAllTeachers();
}
