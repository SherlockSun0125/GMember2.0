package cn.edu.hitwh.gmember.mapper;

import cn.edu.hitwh.gmember.pojo.Employee;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    public Employee findEmployee(@Param(value = "id") String id, @Param(value = "pwd") String pwd);
}
