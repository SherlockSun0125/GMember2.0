package cn.edu.hitwh.gmember.daoImp;

import cn.edu.hitwh.gmember.dao.IStulogDao;
import cn.edu.hitwh.gmember.mapper.StulogMapper;
import cn.edu.hitwh.gmember.pojo.StuLog;
import cn.edu.hitwh.gmember.tools.PageBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

import static cn.edu.hitwh.gmember.tools.PageConstants.LOG_PAGE_SIZE;

public class StulogDaoImp implements IStulogDao{
    @Override
    public Integer addStuLog(StuLog stuLog) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        Integer stu_log_id=null;
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();

        StulogMapper stulogMapper=session.getMapper(StulogMapper.class);
        try {
            stu_log_id=stulogMapper.addStuLog(stuLog);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
            return stu_log_id;
        }
    }

    @Override
    public void updateStuLog(StuLog stuLog) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();

        StulogMapper stulogMapper=session.getMapper(StulogMapper.class);
        try{
            stulogMapper.updateStuLog(stuLog);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public void deleteStuLog(int stu_log_id) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();

        StulogMapper stulogMapper=session.getMapper(StulogMapper.class);

        try{
            stulogMapper.deleteStuLog(stu_log_id);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public PageBean<StuLog> findLogsOfStudentLevel(int stu_id, int stu_level_id, int currentPage) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        PageBean<StuLog> stuLogPageBean=new PageBean<StuLog>();
        int pageSize=LOG_PAGE_SIZE;
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();

        StulogMapper stulogMapper=session.getMapper(StulogMapper.class);

        int from=(currentPage-1)*pageSize;
        int totalRecords=stulogMapper.countLogsOfStudentLevel(stu_id,stu_level_id);
        System.out.println(stu_id+"在阶段"+stu_level_id+"日志的总个数为："+totalRecords);

        List<StuLog> stuLogList=stulogMapper.findLogsOfStudentLevel(stu_id,stu_level_id,from,pageSize);

        stuLogPageBean.setBeanList(stuLogList);
        stuLogPageBean.setPageSize(pageSize);
        stuLogPageBean.setCurrentPage(currentPage);
        stuLogPageBean.setTotalRecords(totalRecords);

        session.close();
        return stuLogPageBean;

    }

    @Override
    public PageBean<StuLog> findLogsOfTeacherLevel(int tea_id, int stu_level_id, int currentPage) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        PageBean<StuLog> stuLogPageBean=new PageBean<StuLog>();
        int pageSize=LOG_PAGE_SIZE;
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();

        StulogMapper stulogMapper=session.getMapper(StulogMapper.class);

        int from=(currentPage-1)*pageSize;
        int totalRecords=stulogMapper.countLogsOfTeacherLevel(tea_id,stu_level_id);
        System.out.println(tea_id+"在阶段"+stu_level_id+"的学生的日志的总个数为："+totalRecords);

        List<StuLog> stuLogList=stulogMapper.findLogsOfTeacherLevel(tea_id,stu_level_id,from,pageSize);

        stuLogPageBean.setBeanList(stuLogList);
        stuLogPageBean.setPageSize(pageSize);
        stuLogPageBean.setCurrentPage(currentPage);
        stuLogPageBean.setTotalRecords(totalRecords);

        session.close();
        return stuLogPageBean;
    }

    @Override
    public PageBean<StuLog> findLogsOfEmployeeLevel(int emp_id, int stu_level_id, int currentPage) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        PageBean<StuLog> stuLogPageBean=new PageBean<StuLog>();
        int pageSize=LOG_PAGE_SIZE;
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();

        StulogMapper stulogMapper=session.getMapper(StulogMapper.class);

        int from=(currentPage-1)*pageSize;
        int totalRecords=stulogMapper.countLogsOfEmployeeLevel(emp_id,stu_level_id);
        System.out.println(emp_id+"在阶段"+stu_level_id+"的学生的日志的总个数为："+totalRecords);

        List<StuLog> stuLogList=stulogMapper.findLogsOfEmployeeLevel(emp_id,stu_level_id,from,pageSize);

        stuLogPageBean.setBeanList(stuLogList);
        stuLogPageBean.setPageSize(pageSize);
        stuLogPageBean.setCurrentPage(currentPage);
        stuLogPageBean.setTotalRecords(totalRecords);
        stuLogPageBean.setTotalPages(stuLogPageBean.getTotalPages());

        session.close();
        return stuLogPageBean;
    }

    @Override
    public StuLog findLogByid(int stu_log_id) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        StuLog stuLog=new StuLog();
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();

        StulogMapper stulogMapper=session.getMapper(StulogMapper.class);

        stuLog=stulogMapper.findLogById(stu_log_id);

        session.close();
        return stuLog;
    }
}
