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
            return teacherDao.findTeacher(teacher.getTea_num(),teacher.getTea_pwd());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public PageBean<Teacher> findAllTeachers(int currentPage) {
        try{
            return teacherDao.findAllTeachers(currentPage);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public PageBean<Teacher> findAllTeacherDetail() {
        try{
            return teacherDao.findAllTeacherDetail();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteTeacher(int tea_id) {
        try {
            teacherDao.deleteTeacher(tea_id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer addTeacher(Teacher teacher) {
        try {
            return teacherDao.addTeacher(teacher);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        try {
            teacherDao.updateTeacher(teacher);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Teacher findTeacherById(int tea_id) {
        try{
            return teacherDao.findTeacherById(tea_id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public PageBean<Teacher> findAllTeachersByDep(int dep_id) {
        try{
            return teacherDao.findAllTeachersByDep(dep_id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
