package cn.edu.hitwh.gmember.daoImp;

import cn.edu.hitwh.gmember.dao.ITeacherDao;
import cn.edu.hitwh.gmember.mapper.TeacherMapper;
import cn.edu.hitwh.gmember.pojo.Teacher;
import cn.edu.hitwh.gmember.tools.PageBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class TeacherDaoImp implements ITeacherDao{
    public Teacher findTeacher(String teanum,String teapwd) {
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

        TeacherMapper teacherMapper=session.getMapper(TeacherMapper.class);
        Teacher teacher=teacherMapper.findTeacher(teanum,teapwd);
        session.close();
        return  teacher;

    }

    @Override
    public PageBean<Teacher> findAllTeachers() {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        PageBean<Teacher> teacherPageBean=new PageBean<Teacher>();
        int totalTeachers;
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();

        //获得教师信息
        TeacherMapper teacherMapper=session.getMapper(TeacherMapper.class);
        List<Teacher> teachers=teacherMapper.findAllTeachers();
        for(int i=0;i<teachers.size();i++){
            System.out.println("来自dao层的问候(取出的数据)："+teachers.get(i));
        }
        //获得总教师人数
        totalTeachers=teacherMapper.countAllTeachers();

        teacherPageBean.setBeanList(teachers);
        teacherPageBean.setTotalRecords(totalTeachers);
        return teacherPageBean;
    }

    @Override
    public void deleteTeacher(int tea_id) {
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
        TeacherMapper teacherMapper=session.getMapper(TeacherMapper.class);
        try{
            teacherMapper.deleteTeacher(tea_id);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public Integer addTeacher(Teacher teacher) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        Integer tea_id=null;
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();
        TeacherMapper teacherMapper=session.getMapper(TeacherMapper.class);
        try{
            tea_id=teacherMapper.addTeacher(teacher);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return tea_id;
    }

    public void updateTeacher(Teacher teacher) {
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
        TeacherMapper teacherMapper=session.getMapper(TeacherMapper.class);

        try {
            teacherMapper.updateTeacher(teacher);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public Teacher findTeacherById(int tea_id) {
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
        TeacherMapper teacherMapper=session.getMapper(TeacherMapper.class);
        Teacher teacher=teacherMapper.findTeacherById(tea_id);
        session.close();
        return teacher;
    }
}
