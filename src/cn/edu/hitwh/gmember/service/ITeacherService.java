package cn.edu.hitwh.gmember.service;

import cn.edu.hitwh.gmember.pojo.Teacher;
import cn.edu.hitwh.gmember.tools.PageBean;

public interface ITeacherService {
    public Teacher login(Teacher teacher);
    public PageBean<Teacher> findAllTeachers();

}
