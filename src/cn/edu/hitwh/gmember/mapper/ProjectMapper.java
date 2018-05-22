package cn.edu.hitwh.gmember.mapper;

import cn.edu.hitwh.gmember.pojo.Project;

import java.util.List;

public interface ProjectMapper {
    public List<Project> findProjectsByStuId(int stu_id);
    public Integer addProject(Project project);
    public void deleteProject(int project_id);
    public Project findProjectById(int project_id);
    public void updateProject(Project project);
}
