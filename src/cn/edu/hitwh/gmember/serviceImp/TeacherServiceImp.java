package cn.edu.hitwh.gmember.serviceImp;

import cn.edu.hitwh.gmember.dao.ITeacherDao;
import cn.edu.hitwh.gmember.daoImp.TeacherDaoImp;
import cn.edu.hitwh.gmember.pojo.Teacher;
import cn.edu.hitwh.gmember.service.ITeacherService;
import cn.edu.hitwh.gmember.tools.PageBean;

public class TeacherServiceImp implements ITeacherService {
    ITeacherDao teacherDao=new TeacherDaoImp();
    @Override
    public Teacher login(Teacher teacher) {
        try{
            return teacherDao.findTeacher(teacher.getTea_id(),teacher.getTea_pwd());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public PageBean<Teacher> findAllTeachers() {
        try{
            return teacherDao.findAllTeachers();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
