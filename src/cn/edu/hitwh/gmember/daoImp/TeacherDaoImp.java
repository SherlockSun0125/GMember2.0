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
    @Override
    public Teacher findTeacher(String teaid,String teapwd) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (IOException e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();
        TeacherMapper teacherMapper=session.getMapper(TeacherMapper.class);
        Teacher teacher=teacherMapper.findTeacher(teaid,teapwd);
        session.close();
        return  teacher;

    }

    @Override
    public PageBean<Teacher> findAllTeachers() {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        PageBean<Teacher> teacherPageBean=new PageBean<Teacher>();
        SqlSession session;
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
}
