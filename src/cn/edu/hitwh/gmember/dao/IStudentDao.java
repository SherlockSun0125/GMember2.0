package cn.edu.hitwh.gmember.dao;

import cn.edu.hitwh.gmember.pojo.Student;

public interface IStudentDao {
    public Student findStudent(String stu_id, String stu_pwd);
}
