package cn.edu.hitwh.gmember.daoImp;

import cn.edu.hitwh.gmember.dao.IProjectDao;
import cn.edu.hitwh.gmember.dao.IProjectDao;
import cn.edu.hitwh.gmember.mapper.ProjectMapper;
import cn.edu.hitwh.gmember.pojo.Project;
import cn.edu.hitwh.gmember.tools.PageBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

public class ProjectDaoImp implements IProjectDao{

    @Override
    public PageBean<Project> findProjectsByStuLevel(int stu_id,int stu_level_id) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        PageBean<Project> projectPageBean=new PageBean<Project>();
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();

        ProjectMapper projectMapper=session.getMapper(ProjectMapper.class);

        List<Project> projects=projectMapper.findProjectsByStuLevel(stu_id,stu_level_id);

        projectPageBean.setBeanList(projects);

        session.close();
        return projectPageBean;
    }

    @Override
    public Integer addProject(Project project) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        Integer project_id=null;
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();

        ProjectMapper projectMapper=session.getMapper(ProjectMapper.class);

        try {
            project_id = projectMapper.addProject(project);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
            return project_id;
        }
    }

    @Override
    public void deleteProject(int project_id) {
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

        ProjectMapper projectMapper=session.getMapper(ProjectMapper.class);

        try {
            projectMapper.deleteProject(project_id);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public Project findProjectById(int project_id) {
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

        ProjectMapper projectMapper=session.getMapper(ProjectMapper.class);
        Project project=projectMapper.findProjectById(project_id);
        session.close();
        return  project;
    }

    @Override
    public void updateProject(Project project) {
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

        System.out.println("来自dao层的问候："+project.toString());

        ProjectMapper projectMapper=session.getMapper(ProjectMapper.class);
        try {
            projectMapper.updateProject(project);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

    }
}
