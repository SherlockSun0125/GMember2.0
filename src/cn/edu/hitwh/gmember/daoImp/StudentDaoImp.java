package cn.edu.hitwh.gmember.daoImp;

import cn.edu.hitwh.gmember.dao.IStudentDao;
import cn.edu.hitwh.gmember.mapper.StudentMapper;
import cn.edu.hitwh.gmember.pojo.Student;
import cn.edu.hitwh.gmember.tools.PageBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class StudentDaoImp implements IStudentDao{
    @Override
    public Student findStudent(String stu_num, String stu_pwd) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        try{
            reader= Resources.getResourceAsReader(resource);
        }catch (IOException e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();
        StudentMapper studentMapper=session.getMapper(StudentMapper.class);
        Student student=studentMapper.findStudent(stu_num,stu_pwd);
        session.close();
        return student;
    }

    @Override
    public PageBean<Student> findAllStudents() {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        PageBean<Student> studentPageBean=new PageBean<Student>();
        try{
            reader= Resources.getResourceAsReader(resource);
        }catch (IOException e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();
        StudentMapper studentMapper=session.getMapper(StudentMapper.class);

        List<Student> studentList=studentMapper.findAllStudents();
        studentPageBean.setBeanList(studentList);
        return studentPageBean;
    }

    @Override
    public PageBean<Student> findStudentsByLevel(int stu_level_id) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        PageBean<Student> studentPageBean=new PageBean<Student>();
        try{
            reader= Resources.getResourceAsReader(resource);
        }catch (IOException e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();
        StudentMapper studentMapper=session.getMapper(StudentMapper.class);

        List<Student> studentList=studentMapper.findStudentsByLevel(stu_level_id);
        for(int i=0;i<studentList.size();i++) {
            System.out.println("来自dao层的问候——所有等级为" + stu_level_id + "的学生为：" + studentList.get(i).toString());
        }
        studentPageBean.setBeanList(studentList);
        return studentPageBean;
    }

    @Override
    public int countAllStudents() {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        try{
            reader= Resources.getResourceAsReader(resource);
        }catch (IOException e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();
        StudentMapper studentMapper=session.getMapper(StudentMapper.class);
        return studentMapper.countAllStudents();
    }

    @Override
    public void deleteStudent(int stu_id) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        try{
            reader= Resources.getResourceAsReader(resource);
        }catch (IOException e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();
        StudentMapper studentMapper=session.getMapper(StudentMapper.class);

        try{
            studentMapper.deleteStudent(stu_id);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

    }

    @Override
    public Integer addStudent(Student student) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        Integer stu_id=null;
        try{
            reader= Resources.getResourceAsReader(resource);
        }catch (IOException e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();
        StudentMapper studentMapper=session.getMapper(StudentMapper.class);
        try{
            stu_id=studentMapper.addStudent(student);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return stu_id;
    }

    @Override
    public void updateStudent(Student student) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        try{
            reader= Resources.getResourceAsReader(resource);
        }catch (IOException e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();
        StudentMapper studentMapper=session.getMapper(StudentMapper.class);
        try{
            studentMapper.updateStudent(student);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public Student findStudentById(int stu_id) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        try{
            reader= Resources.getResourceAsReader(resource);
        }catch (IOException e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();
        StudentMapper studentMapper=session.getMapper(StudentMapper.class);

        Student student=studentMapper.findStudentById(stu_id);
        session.close();
        return student;
    }
}
