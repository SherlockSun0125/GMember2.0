package cn.edu.hitwh.gmember.dao;

import cn.edu.hitwh.gmember.pojo.Employee;
import cn.edu.hitwh.gmember.pojo.Student;
import cn.edu.hitwh.gmember.tools.PageBean;

public interface IEmployeeDao {
    public Employee findEmployee(String phone,String pwd);
    public PageBean<Employee> findAllEmployeeDetail();
    public Employee findAllEmployeeById(int emp_id);
    public PageBean<Student> findAllStudentsByEmpLevel(int emp_id, int stu_level_id);
}
