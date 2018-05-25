package cn.edu.hitwh.gmember.mapper;

import cn.edu.hitwh.gmember.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    public Student findStudent(@Param(value = "stu_num")String stu_num,@Param(value = "stu_pwd") String stu_pwd);
    public Student findStudentById(int stu_id);
    public List<Student> findAllStudents(@Param("from") int from,@Param("pageSize") int pageSize);
    public List<Student> findStudentsByLevel(@Param("stu_level_id") int stu_level_id,@Param("from") int from,@Param("pageSize") int pageSize);
    public int countAllStudents();
    public int countStudentsByLevel(int stu_level_id);
    public void deleteStudent(int stu_id);
    public int addStudent(Student student);
    public void updateStudent(@Param("stu")Student student);
    public List<Student> findAllStudentDetail();
    public List<Student> findAllStudentByDepLevel(@Param("dep_id") int dep_id,@Param("stu_level_id") int stu_level_id);
    public List<Student> findAllStudentsByTeaLevel(@Param("tea_id") int tea_id,@Param("stu_level_id") int stu_level_id);
    public int countAllStudentsByTeaLevel(@Param("tea_id") int tea_id,@Param("stu_level_id") int stu_level_id);
}
