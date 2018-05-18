package cn.edu.hitwh.gmember.service;

import cn.edu.hitwh.gmember.pojo.Teacher;
import cn.edu.hitwh.gmember.tools.PageBean;

public interface ITeacherService {
    public Teacher login(Teacher teacher);
    public PageBean<Teacher> findAllTeachers(int currentPage);
    public void deleteTeacher(int tea_id);
    public Integer addTeacher(Teacher teacher);
    public void updateTeacher(Teacher teacher);
    public Teacher findTeacherById(int tea_id);
}
