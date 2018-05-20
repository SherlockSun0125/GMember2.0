package cn.edu.hitwh.gmember.mapper;

import cn.edu.hitwh.gmember.pojo.StuLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StulogMapper {
//    学生发布日志
    public Integer addStuLog(StuLog stuLog);
//    学生更改日志
    public void updateStuLog(StuLog stuLog);
//    学生删除日志
    public void deleteStuLog(int stu_log_id);
//    找到某学生某阶段的所有日志，从from到from+pageSize
    public List<StuLog> findLogsOfStudentLevel(@Param("stu_id") int stu_id,@Param("stu_level_id") int stu_level_id,@Param("from") int from,@Param("pageSize") int pageSize);
//    找到某阶段某位老师所有学生的所有日志，从from到from+pageSize
    public List<StuLog> findLogsOfTeacherLevel(@Param("tea_id")int tea_id,@Param("stu_level_id")int stu_level_id,@Param("from")int from,@Param("pageSize")int pageSize);
//    找到某阶段某位导师所有学生的所有日志，从from到from+pageSize
    public List<StuLog> findLogsOfEmployeeLevel(@Param("emp_id")int tea_id,@Param("stu_level_id")int stu_level_id,@Param("from")int from,@Param("pageSize")int pageSize);
//    查看某个日志的详情
    public StuLog findLogByid(int stu_log_id);

//    老师或导师对学生进行赞赏、提醒、警告时改变tea_status或emp_status或tea_feedback或emp_feedback;
//    策略是在servlet中获得stuLog，然后改变响应值
    public void feedback(StuLog stuLog);


}
