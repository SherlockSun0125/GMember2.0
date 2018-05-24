package cn.edu.hitwh.gmember.mapper;

import cn.edu.hitwh.gmember.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    public Teacher findTeacher(@Param(value = "num") String num,@Param(value = "pwd") String pwd);//登录专用
    public List<Teacher> findAllTeachers(@Param("from") int from,@Param("pageSize") int pageSize);
    public List<Teacher> findAllTeacherDetail();
    public int countAllTeachers();
    public void deleteTeacher(int tea_id);
    //因为xml文件中有resultMap,所以如果不写@Param("tea")，
    // 那么直接在xml中写pojo中的属性即可，如#{tea_id}而不是#{teacher.tea_id}
    public int addTeacher(Teacher teacher);
    public void updateTeacher(@Param("tea") Teacher teacher);
    public Teacher findTeacherById(int tea_id);
    public List<Teacher> findAllTeachersByDep(int dep_id);
}
