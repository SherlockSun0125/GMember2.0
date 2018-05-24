package cn.edu.hitwh.gmember.dao;

import cn.edu.hitwh.gmember.pojo.Teacher;
import cn.edu.hitwh.gmember.tools.PageBean;

public interface ITeacherDao {
    public Teacher findTeacher(String id,String pwd);
    public PageBean<Teacher> findAllTeachers(int currentPage);
    public PageBean<Teacher> findAllTeacherDetail();
    public void deleteTeacher(int tea_id);
    public Integer addTeacher(Teacher teacher);
    public void updateTeacher(Teacher teacher);
    public Teacher findTeacherById(int tea_id);
    public PageBean<Teacher> findAllTeachersByDep(int dep_id);
}
