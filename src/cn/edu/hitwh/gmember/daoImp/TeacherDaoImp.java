package cn.edu.hitwh.gmember.daoImp;

import cn.edu.hitwh.gmember.dao.ITeacherDao;
import cn.edu.hitwh.gmember.mapper.StudentMapper;
import cn.edu.hitwh.gmember.mapper.TeacherMapper;
import cn.edu.hitwh.gmember.pojo.Student;
import cn.edu.hitwh.gmember.pojo.Teacher;
import cn.edu.hitwh.gmember.tools.PageBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import static cn.edu.hitwh.gmember.tools.PageConstants.TEACHER_PAGE_SIZE;

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
    public PageBean<Teacher> findAllTeachers(int currentPage) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        PageBean<Teacher> teacherPageBean=new PageBean<Teacher>();
        int pageSize=TEACHER_PAGE_SIZE;
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

        totalTeachers=teacherMapper.countAllTeachers();
        int from=(currentPage-1)*pageSize;

        List<Teacher> teachers=teacherMapper.findAllTeachers(from,pageSize);

        teacherPageBean.setBeanList(teachers);
        teacherPageBean.setTotalRecords(totalTeachers);
        teacherPageBean.setPageSize(pageSize);
        teacherPageBean.setCurrentPage(currentPage);
        teacherPageBean.setTotalPages(teacherPageBean.getTotalPages());
        session.close();
        return teacherPageBean;
    }

    @Override
    public PageBean<Teacher> findAllTeacherDetail() {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        PageBean<Teacher> teacherPageBean=new PageBean<Teacher>();
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();

        //获得教师信息
        TeacherMapper teacherMapper=session.getMapper(TeacherMapper.class);

        List<Teacher> teachers=teacherMapper.findAllTeacherDetail();
        teacherPageBean.setBeanList(teachers);

        session.close();
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

    @Override
    public PageBean<Teacher> findAllTeachersByDep(int dep_id) {
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

        totalTeachers=teacherMapper.countAllTeachers();

        List<Teacher> teachers=teacherMapper.findAllTeachersByDep(dep_id);

        teacherPageBean.setBeanList(teachers);
        teacherPageBean.setTotalRecords(totalTeachers);

        session.close();
        return teacherPageBean;
    }

    @Override
    public PageBean<Student> findAllStudentsByTeaLevel(int tea_id, int stu_level_id) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        PageBean<Student> studentPageBean=new PageBean<Student>();
        int totalStudents;
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();

        //获得所有学生
        StudentMapper studentMapper=session.getMapper(StudentMapper.class);

        List<Student> studentList=studentMapper.findAllStudentsByTeaLevel(tea_id,stu_level_id);
        totalStudents=studentMapper.countAllStudentsByTeaLevel(tea_id, stu_level_id);

        studentPageBean.setBeanList(studentList);
        studentPageBean.setTotalRecords(totalStudents);

        session.close();
        return studentPageBean;
    }


}
