package cn.edu.hitwh.gmember.service;

import cn.edu.hitwh.gmember.pojo.Employee;
import cn.edu.hitwh.gmember.tools.PageBean;

public interface IEmployeeService {
    public Employee login(Employee employee);
    public PageBean<Employee> findAllEmployeeDetail();
}
