package cn.edu.hitwh.gmember.mapper;

import cn.edu.hitwh.gmember.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Enumeration;

public interface StudentMapper {
    public Student findStudent(@Param(value = "stu_num")String stu_num,@Param(value = "stu_pwd") String stu_pwd);
    public Student findStuById(String id);
    public Enumeration<Student> selectAll();
}
