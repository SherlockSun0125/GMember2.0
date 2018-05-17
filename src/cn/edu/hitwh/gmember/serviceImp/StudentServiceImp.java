package cn.edu.hitwh.gmember.serviceImp;

import cn.edu.hitwh.gmember.dao.IStudentDao;
import cn.edu.hitwh.gmember.daoImp.StudentDaoImp;
import cn.edu.hitwh.gmember.pojo.Student;
import cn.edu.hitwh.gmember.service.IStudentService;
import cn.edu.hitwh.gmember.tools.PageBean;

public class StudentServiceImp implements IStudentService {
    IStudentDao studentDao=new StudentDaoImp();
    @Override
    public Student login(Student student) {
        try{
            return studentDao.findStudent(student.getStu_num(),student.getStu_pwd());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public PageBean<Student> findAllStudents() {
        try{
            return studentDao.findAllStudents();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public PageBean<Student> findStudentsByLevel(int stu_level_id) {
        try{
            return studentDao.findStudentsByLevel(stu_level_id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public int countAllStudents() {
        try{
            return studentDao.countAllStudents();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteStudent(int stu_id) {
        try{
            studentDao.deleteStudent(stu_id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer addStudent(Student student) {
        try{
            return studentDao.addStudent(student);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateStudent(Student student) {
        try{
            studentDao.updateStudent(student);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
