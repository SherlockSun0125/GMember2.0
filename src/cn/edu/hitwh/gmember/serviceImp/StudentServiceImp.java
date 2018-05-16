package cn.edu.hitwh.gmember.serviceImp;

import cn.edu.hitwh.gmember.dao.IStudentDao;
import cn.edu.hitwh.gmember.daoImp.StudentDaoImp;
import cn.edu.hitwh.gmember.pojo.Student;
import cn.edu.hitwh.gmember.service.IStudentService;

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
}
