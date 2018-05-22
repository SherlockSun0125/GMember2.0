package cn.edu.hitwh.gmember.dao;

import cn.edu.hitwh.gmember.pojo.Project;
import cn.edu.hitwh.gmember.tools.PageBean;

public interface IProjectDao {
    public PageBean<Project> findProjectsByStuId(int stu_id);
    public Integer addProject(Project project);
    public void deleteProject(int project_id);
    public Project findProjectById(int project_id);
    public void updateProject(Project project);

}
