package cn.edu.hitwh.gmember.service;

import cn.edu.hitwh.gmember.pojo.Employee;
import cn.edu.hitwh.gmember.pojo.Student;
import cn.edu.hitwh.gmember.tools.PageBean;

import java.util.List;

public interface IEmployeeService {
    public Employee login(Employee employee);
    public PageBean<Employee> findAllEmployeeDetail();
    public Employee findAllEmployeeById(int emp_id);
    public PageBean<Student> findAllStudentsByEmpLevel(int emp_id, int stu_level_id);
    public PageBean<Employee> adminFindAllEmployees(int currentPage);
    public Integer addEmployee(Employee employee);
    public void deleteEmployee(int emp_id);
    public void updateEmployee(Employee employee);
}
