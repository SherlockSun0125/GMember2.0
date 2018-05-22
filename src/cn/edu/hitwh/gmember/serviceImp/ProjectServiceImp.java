package cn.edu.hitwh.gmember.serviceImp;

import cn.edu.hitwh.gmember.dao.IProjectDao;
import cn.edu.hitwh.gmember.daoImp.ProjectDaoImp;
import cn.edu.hitwh.gmember.pojo.Project;
import cn.edu.hitwh.gmember.service.IProjectService;
import cn.edu.hitwh.gmember.tools.PageBean;

public class ProjectServiceImp implements IProjectService {
    IProjectDao projectDao=new ProjectDaoImp();

    @Override
    public PageBean<Project> findProjectsByStuId(int stu_id) {
        try {
            return projectDao.findProjectsByStuId(stu_id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer addProject(Project project) {
        try{
            return projectDao.addProject(project);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteProject(int project_id) {
        try{
            projectDao.deleteProject(project_id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Project findProjectById(int project_id) {
        try{
            return projectDao.findProjectById(project_id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateProject(Project project) {
        try{
            projectDao.updateProject(project);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
