package cn.edu.hitwh.gmember.daoImp;

import cn.edu.hitwh.gmember.dao.IStudentDao;
import cn.edu.hitwh.gmember.mapper.StudentMapper;
import cn.edu.hitwh.gmember.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

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
}
