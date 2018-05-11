package cn.edu.hitwh.gmember.mapper;

import cn.edu.hitwh.gmember.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {
    public Teacher findTeacher(@Param(value = "id") String id,@Param(value = "pwd") String pwd);
    public Teacher findTeaById(String id);
    public Teacher selectAll();
}
