package cn.edu.hitwh.gmember.serviceImp;

import cn.edu.hitwh.gmember.dao.IStulogDao;
import cn.edu.hitwh.gmember.daoImp.StulogDaoImp;
import cn.edu.hitwh.gmember.pojo.StuLog;
import cn.edu.hitwh.gmember.service.IStulogService;
import cn.edu.hitwh.gmember.tools.PageBean;

public class StulogServiceImp implements IStulogService {
    IStulogDao stulogDao=new StulogDaoImp();

    @Override
    public Integer addStuLog(StuLog stuLog) {
        try{
            return stulogDao.addStuLog(stuLog);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateStuLog(StuLog stuLog) {
        try{
            stulogDao.updateStuLog(stuLog);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteStuLog(int stu_log_id) {
        try{
            stulogDao.deleteStuLog(stu_log_id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public PageBean<StuLog> findLogsOfStudentLevel(int stu_id, int stu_level_id, int currentPage) {
        try{
            return stulogDao.findLogsOfStudentLevel(stu_id,stu_level_id,currentPage);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public PageBean<StuLog> findLogsOfTeacherLevel(int tea_id, int stu_level_id, int currentPage) {
        try{
            return stulogDao.findLogsOfTeacherLevel(tea_id, stu_level_id, currentPage);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public PageBean<StuLog> findLogsOfEmployeeLevel(int emp_id, int stu_level_id, int currentPage) {
        try{
            return stulogDao.findLogsOfEmployeeLevel(emp_id, stu_level_id, currentPage);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public StuLog findLogByid(int stu_log_id) {
        try{
            return stulogDao.findLogByid(stu_log_id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
