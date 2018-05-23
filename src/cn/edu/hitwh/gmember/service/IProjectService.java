package cn.edu.hitwh.gmember.service;

import cn.edu.hitwh.gmember.pojo.Project;
import cn.edu.hitwh.gmember.tools.PageBean;

public interface IProjectService {
    public PageBean<Project> findProjectsByStuLevel(int stu_id,int stu_level_id);
    public Integer addProject(Project project);
    public void deleteProject(int project_id);
    public Project findProjectById(int project_id);
    public void updateProject(Project project);
}
