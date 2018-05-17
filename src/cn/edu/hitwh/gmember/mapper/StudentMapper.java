package cn.edu.hitwh.gmember.mapper;

import cn.edu.hitwh.gmember.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    public Student findStudent(@Param(value = "stu_num")String stu_num,@Param(value = "stu_pwd") String stu_pwd);
    public Student findStudentById(int stu_id);
    public List<Student> findAllStudents();
    public List<Student> findStudentsByLevel(int stu_level_id);
    public int countAllStudents();
    public void deleteStudent(int stu_id);
    public int addStudent(@Param("stu") Student student);
    public void updateStudent(@Param("stu")Student student);
}
