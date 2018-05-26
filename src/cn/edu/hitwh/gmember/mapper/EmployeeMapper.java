package cn.edu.hitwh.gmember.mapper;

import cn.edu.hitwh.gmember.pojo.Employee;
import cn.edu.hitwh.gmember.tools.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    public Employee findEmployee(@Param(value = "phone") String phone, @Param(value = "pwd") String pwd);
    public List<Employee> findAllEmployeeDetail();
    public Employee findAllEmployeeById(int emp_id);
}
