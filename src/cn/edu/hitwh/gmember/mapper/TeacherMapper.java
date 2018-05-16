package cn.edu.hitwh.gmember.mapper;

import cn.edu.hitwh.gmember.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    public Teacher findTeacher(@Param(value = "id") String id,@Param(value = "pwd") String pwd);//登录专用
    public Teacher findTeacherById(String tea_id);
    public List<Teacher> findAllTeachers();
    public int countAllTeachers();
}
