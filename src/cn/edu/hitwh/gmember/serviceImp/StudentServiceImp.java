package cn.edu.hitwh.gmember.serviceImp;

import cn.edu.hitwh.gmember.dao.IAdminDao;
import cn.edu.hitwh.gmember.dao.IStudentDao;
import cn.edu.hitwh.gmember.daoImp.AdminDaoImp;
import cn.edu.hitwh.gmember.daoImp.StudentDaoImp;
import cn.edu.hitwh.gmember.pojo.Admin;
import cn.edu.hitwh.gmember.pojo.Student;
import cn.edu.hitwh.gmember.service.IAdminService;
import cn.edu.hitwh.gmember.service.IStudentService;

public class StudentServiceImp implements IStudentService {
    IStudentDao studentDao=new StudentDaoImp();
    @Override
    public Student login(Student student) {
        try{
            return studentDao.findStudent(student.getStu_id(),student.getStu_pwd());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
