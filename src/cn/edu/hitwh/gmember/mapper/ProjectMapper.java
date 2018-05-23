package cn.edu.hitwh.gmember.mapper;

import cn.edu.hitwh.gmember.pojo.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectMapper {
    public List<Project> findProjectsByStuLevel(@Param("stu_id") int stu_id,@Param("stu_level_id") int stu_level_id);
    public Integer addProject(Project project);
    public void deleteProject(int project_id);
    public Project findProjectById(int project_id);
    public void updateProject(Project project);
}
