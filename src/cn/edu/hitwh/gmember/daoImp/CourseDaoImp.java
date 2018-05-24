package cn.edu.hitwh.gmember.daoImp;

import cn.edu.hitwh.gmember.dao.ICourseDao;
import cn.edu.hitwh.gmember.mapper.CourseMapper;
import cn.edu.hitwh.gmember.pojo.Course;
import cn.edu.hitwh.gmember.tools.PageBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

public class CourseDaoImp implements ICourseDao{

    @Override
    public PageBean<Course> findCoursesByStuId(int stu_id) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        PageBean<Course> coursePageBean=new PageBean<Course>();
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();

        CourseMapper courseMapper=session.getMapper(CourseMapper.class);

        List<Course> courses=courseMapper.findCoursesByStuId(stu_id);
        int totalRecords=courseMapper.countCoursesByStuId(stu_id);

        coursePageBean.setBeanList(courses);
        coursePageBean.setTotalRecords(totalRecords);

        session.close();
        return coursePageBean;
    }

    @Override
    public Integer addCourse(Course course) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        Integer course_id=null;
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();

        CourseMapper courseMapper=session.getMapper(CourseMapper.class);

        try {
            course_id = courseMapper.addCourse(course);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
            return course_id;
        }
    }

    @Override
    public void deleteCourse(int course_id) {
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

        CourseMapper courseMapper=session.getMapper(CourseMapper.class);

        try {
            courseMapper.deleteCourse(course_id);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public Course findCourseById(int course_id) {
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

        CourseMapper courseMapper=session.getMapper(CourseMapper.class);
        Course course=courseMapper.findCourseById(course_id);
        session.close();
        return  course;
    }

    @Override
    public void updateCourse(Course course) {
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

        CourseMapper courseMapper=session.getMapper(CourseMapper.class);
        try {
            courseMapper.updateCourse(course);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

    }
}
