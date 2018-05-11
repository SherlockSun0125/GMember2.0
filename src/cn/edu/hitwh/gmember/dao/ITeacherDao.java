package cn.edu.hitwh.gmember.dao;

import cn.edu.hitwh.gmember.pojo.Teacher;

public interface ITeacherDao {
    public Teacher findTeacher(String id,String pwd);
}
