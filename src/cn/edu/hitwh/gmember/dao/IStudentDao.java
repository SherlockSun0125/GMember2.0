package cn.edu.hitwh.gmember.dao;

import cn.edu.hitwh.gmember.pojo.Student;
import cn.edu.hitwh.gmember.tools.PageBean;

public interface IStudentDao {
    public Student findStudent(String stu_num, String stu_pwd);
    public PageBean<Student> findAllStudents(int currentPage);
    public PageBean<Student> findStudentsByLevel(int stu_level_id,int currentPage);
    public int countAllStudents();
    public void deleteStudent(int stu_id);
    public Integer addStudent(Student student);
    public void updateStudent(Student student);
    public Student findStudentById(int stu_id);
}
