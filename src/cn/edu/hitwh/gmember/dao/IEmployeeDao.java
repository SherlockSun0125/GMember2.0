package cn.edu.hitwh.gmember.dao;

import cn.edu.hitwh.gmember.pojo.Employee;
import cn.edu.hitwh.gmember.tools.PageBean;

public interface IEmployeeDao {
    public Employee findEmployee(String id,String pwd);
    public PageBean<Employee> findAllEmployeeDetail();
}
