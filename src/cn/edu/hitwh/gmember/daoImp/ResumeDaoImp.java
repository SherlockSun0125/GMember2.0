package cn.edu.hitwh.gmember.daoImp;

import cn.edu.hitwh.gmember.dao.IResumeDao;
import cn.edu.hitwh.gmember.mapper.ResumeMapper;
import cn.edu.hitwh.gmember.pojo.Resume;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class ResumeDaoImp implements IResumeDao{

    @Override
    public Resume findResumeByStuId(int stu_id) {
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

        ResumeMapper resumeMapper=session.getMapper(ResumeMapper.class);
        Resume resume=resumeMapper.findResumeByStuId(stu_id);

        session.close();
        return resume;
    }

    @Override
    public Resume findResumeById(int resume_id) {
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

        ResumeMapper resumeMapper=session.getMapper(ResumeMapper.class);

        Resume resume=resumeMapper.findResumeById(resume_id);

        session.close();
        return resume;
    }

    @Override
    public Integer addResume(Resume resume) {
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

        ResumeMapper resumeMapper=session.getMapper(ResumeMapper.class);
        Integer resume_id=null;

        try{
            resume_id=resumeMapper.addResume(resume);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

        return resume_id;
    }

    @Override
    public void updateResume(Resume resume) {
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

        ResumeMapper resumeMapper=session.getMapper(ResumeMapper.class);
        try{
            resumeMapper.updateResume(resume);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

    }
}
